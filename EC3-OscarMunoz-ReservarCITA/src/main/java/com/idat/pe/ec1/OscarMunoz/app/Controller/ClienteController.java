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

import com.idat.pe.ec1.OscarMunoz.app.Model.Cliente;
import com.idat.pe.ec1.OscarMunoz.app.Service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar(){
		return new ResponseEntity<List<Cliente>>(clienteService.listar(), HttpStatus.OK) ;
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Cliente cliente ){
		clienteService.guardar(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id){
		
		Cliente cliente = clienteService.obtener(id);
		
		if( cliente != null) {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Cliente cliente){
		
		Cliente c = clienteService.obtener(cliente.getIdCliente());
		
		if( c != null) {
			clienteService.actualizar(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		Cliente cliente = clienteService.obtener(id);

		if(cliente != null) {
			clienteService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
