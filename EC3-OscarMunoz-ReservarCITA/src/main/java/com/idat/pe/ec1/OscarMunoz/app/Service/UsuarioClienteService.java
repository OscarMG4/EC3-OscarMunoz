package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.app.Model.UsuarioCliente;

public interface UsuarioClienteService {
	
	void guardar(UsuarioCliente usuarioCliente);
	void actualizar(UsuarioCliente usuarioCliente);
	void eliminar(Integer id);
	List<UsuarioCliente> listar();
	UsuarioCliente obtener(Integer id);
	
}
