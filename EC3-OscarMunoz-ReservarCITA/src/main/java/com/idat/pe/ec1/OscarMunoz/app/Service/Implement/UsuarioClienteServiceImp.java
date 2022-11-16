package com.idat.pe.ec1.OscarMunoz.app.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.app.Model.UsuarioCliente;
import com.idat.pe.ec1.OscarMunoz.app.Repository.UsuarioClienteRepository;
import com.idat.pe.ec1.OscarMunoz.app.Service.UsuarioClienteService;

public class UsuarioClienteServiceImp implements UsuarioClienteService {

	@Autowired
	private UsuarioClienteRepository usuarioClienteRepository;
	
	@Override
	public void guardar(UsuarioCliente usuarioCliente) {
		usuarioClienteRepository.save(usuarioCliente);
	}

	@Override
	public void actualizar(UsuarioCliente usuarioCliente) {
		usuarioClienteRepository.saveAndFlush(usuarioCliente);
	}

	@Override
	public void eliminar(Integer id) {
		usuarioClienteRepository.deleteById(id);
		
	}

	@Override
	public List<UsuarioCliente> listar() {
		return usuarioClienteRepository.findAll();
	}

	@Override
	public UsuarioCliente obtener(Integer id) {
		return usuarioClienteRepository.findById(id).orElse(null);
	}

}
