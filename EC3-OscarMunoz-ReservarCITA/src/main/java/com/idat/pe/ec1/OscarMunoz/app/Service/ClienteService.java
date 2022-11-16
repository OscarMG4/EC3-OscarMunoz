package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.app.Model.Cliente;


public interface ClienteService {
	
	void guardar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Integer id);
	List<Cliente> listar();
	Cliente obtener(Integer id);

}
