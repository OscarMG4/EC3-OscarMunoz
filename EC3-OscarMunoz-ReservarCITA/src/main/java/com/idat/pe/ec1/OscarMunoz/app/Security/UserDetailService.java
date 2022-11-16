package com.idat.pe.ec1.OscarMunoz.app.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.pe.ec1.OscarMunoz.app.Model.UsuarioCliente;
import com.idat.pe.ec1.OscarMunoz.app.Repository.UsuarioClienteRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioCliente user = repository.findByUsuarioCliente(username);
		
		if (user != null) {
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority grantend = new SimpleGrantedAuthority(user.getRol());
			listGranted.add(grantend);
			
			return new User(
					user.getUsuario(), 
					user.getPassword(), 
					listGranted);
			
		} else {
			throw new UsernameNotFoundException("Usuario no existe!" + username);
		}
		
	}

}
