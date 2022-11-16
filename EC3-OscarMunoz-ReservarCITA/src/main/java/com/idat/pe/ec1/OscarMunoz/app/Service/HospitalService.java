package com.idat.pe.ec1.OscarMunoz.app.Service;

import java.util.List;

import com.idat.pe.ec1.OscarMunoz.app.Model.Hospital;

public interface HospitalService {
	
	void guardar(Hospital hospital);
	void actualizar(Hospital hospital);
	void eliminar(Integer id);
	List<Hospital> listar();
	Hospital obtener(Integer id);

}
