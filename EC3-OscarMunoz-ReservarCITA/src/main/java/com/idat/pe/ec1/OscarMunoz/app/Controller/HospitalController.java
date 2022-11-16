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

import com.idat.pe.ec1.OscarMunoz.app.Model.Hospital;
import com.idat.pe.ec1.OscarMunoz.app.Service.HospitalService;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> listar(){
		return new ResponseEntity<List<Hospital>>(hospitalService.listar(), HttpStatus.OK) ;
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Hospital hospital ){
		hospitalService.guardar(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hospital> obtenerPorId(@PathVariable Integer id){
		
		Hospital hospital = hospitalService.obtener(id);
		
		if( hospital != null) {
			return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
		}else {
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Hospital hospital){
		
		Hospital h = hospitalService.obtener(hospital.getIdHospital());
		
		if( h != null) {
			hospitalService.actualizar(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		Hospital hospital = hospitalService.obtener(id);

		if(hospital != null) {
			hospitalService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
