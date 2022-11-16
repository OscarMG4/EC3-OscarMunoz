package com.idat.pe.ec1.OscarMunoz.app.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios_clientes")
public class UsuarioCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuarioCliente;
	@Column(name = "usuario", nullable = false, unique = true, length = 20)
	private String usuario;
	@Column(name = "password", nullable = false, unique = true, length = 20)
	private String password;
	@Column(name = "rol", nullable = false, unique = true, length = 20)
	private String rol;
	
	@ManyToOne
	@JoinColumn(
			name="id_cliente",
			nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clientes(id_cliente)")
	)
	private Cliente cliente;

	public Integer getIdUsuarioCliente() {
		return idUsuarioCliente;
	}

	public void setIdUsuarioCliente(Integer idUsuarioCliente) {
		this.idUsuarioCliente = idUsuarioCliente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
