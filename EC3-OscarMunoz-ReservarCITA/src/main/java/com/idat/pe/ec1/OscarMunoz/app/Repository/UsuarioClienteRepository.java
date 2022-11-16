package com.idat.pe.ec1.OscarMunoz.app.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.idat.pe.ec1.OscarMunoz.app.Model.UsuarioCliente;


@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer>{
	
	UsuarioCliente findByUsuarioCliente(String Usuario);
	
}
