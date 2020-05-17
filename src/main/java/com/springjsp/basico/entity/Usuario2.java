package com.springjsp.basico.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * Entidad creada para realizar prueba de relación muchos a muchos con la entidad Perfil
 */
@Entity
@Table(name = "Usuarios2")
public class Usuario2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario2;
	private String username;
	private String nombre;
	private String email;
	private String password;
	private String estatus;
	private Date fechaRegistro;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Usuario2Perfil",
			joinColumns = @JoinColumn(name="idUsuario2"),
			inverseJoinColumns = @JoinColumn(name="idPerfil")
	)
	private List<Perfil> perfiles;
	
	public Usuario2() {
	}

	public Integer getIdUsuario2() {
		return idUsuario2;
	}

	public void setIdUsuario2(Integer idUsuario2) {
		this.idUsuario2 = idUsuario2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}
	
	public void addPerfil(Perfil perfil) {
		if(perfil != null) {
			if(perfiles == null) {
				this.perfiles = new LinkedList<Perfil>();
				this.perfiles.add(perfil);
			}else {
				this.perfiles.add(perfil);
			}
			
		}
	}
	
}
