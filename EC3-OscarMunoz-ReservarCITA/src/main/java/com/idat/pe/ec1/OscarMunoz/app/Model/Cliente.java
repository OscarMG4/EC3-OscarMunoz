package com.idat.pe.ec1.OscarMunoz.app.Model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	@Column(name = "nombre", nullable = true, length = 25)
	private String nombre;
	@Column(name = "celular", nullable = true, length = 9)
	private String celular;
	
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<UsuarioCliente> usuariosClientes = new ArrayList<>();
    
	@ManyToMany(mappedBy = "clientes", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Hospital> hospitales = new ArrayList<>();

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<UsuarioCliente> getUsuariosClientes() {
		return usuariosClientes;
	}

	public void setUsuariosClientes(List<UsuarioCliente> usuariosClientes) {
		this.usuariosClientes = usuariosClientes;
	}

	public List<Hospital> getHospitales() {
		return hospitales;
	}

	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}
	
	
	
}
