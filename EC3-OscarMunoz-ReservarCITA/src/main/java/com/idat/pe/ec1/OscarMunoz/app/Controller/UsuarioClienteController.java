package com.idat.pe.ec1.OscarMunoz.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.ec1.OscarMunoz.app.Model.UsuarioCliente;
import com.idat.pe.ec1.OscarMunoz.app.Service.UsuarioClienteService;

@RestController
@RequestMapping("/usuarioCliente/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService usuarioClienteService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioCliente>> listar(){
		return new ResponseEntity<List<UsuarioCliente>>(usuarioClienteService.listar(), HttpStatus.OK) ;
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente cliente ){
		usuarioClienteService.guardar(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioCliente> obtenerPorId(@PathVariable Integer id){
		
		UsuarioCliente usuario = usuarioClienteService.obtener(id);
		
		if( usuario != null) {
			return new ResponseEntity<UsuarioCliente>(usuario, HttpStatus.OK);
		}else {
			return new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UsuarioCliente usuarioCliente){
		
		UsuarioCliente uc = usuarioClienteService.obtener(usuarioCliente.getIdUsuarioCliente());
		
		if( uc != null) {
			usuarioClienteService.actualizar(uc);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		UsuarioCliente usuarioCliente = usuarioClienteService.obtener(id);

		if(usuarioCliente != null) {
			usuarioClienteService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
