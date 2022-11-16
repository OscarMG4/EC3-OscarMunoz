package com.idat.pe.ec1.OscarMunoz.app.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.app.Model.Cliente;
import com.idat.pe.ec1.OscarMunoz.app.Repository.ClienteRepository;
import com.idat.pe.ec1.OscarMunoz.app.Service.ClienteService;

public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void guardar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente obtener(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

}
