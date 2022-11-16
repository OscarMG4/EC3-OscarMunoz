package com.idat.pe.ec1.OscarMunoz.app.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec1.OscarMunoz.app.Model.Hospital;
import com.idat.pe.ec1.OscarMunoz.app.Repository.HospitalRepository;
import com.idat.pe.ec1.OscarMunoz.app.Service.HospitalService;

public class HospitalServiceImp implements HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public void guardar(Hospital hospital) {
		hospitalRepository.save(hospital);

	}

	@Override
	public void actualizar(Hospital hospital) {
		hospitalRepository.saveAndFlush(hospital);

	}

	@Override
	public void eliminar(Integer id) {
		hospitalRepository.deleteById(id);

	}

	@Override
	public List<Hospital> listar() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital obtener(Integer id) {
		return hospitalRepository.findById(id).orElse(null);
	}

}
