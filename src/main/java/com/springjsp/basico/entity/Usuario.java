package com.springjsp.basico.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombre;
	private String email;
	private String username;
	private String estatus;
	@Column(name="fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(
//			name="UsuarioPerfil", 
//			joinColumns=@JoinColumn(name="idUsuario"), 
//			inverseJoinColumns = @JoinColumn(name="idPerfil")
//	)
//	private List<Perfil> perfiles;
	
	public Usuario() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

//	public List<Perfil> getPerfiles() {
//		return perfiles;
//	}
//
//	public void setPerfiles(List<Perfil> perfiles) {
//		this.perfiles = perfiles;
//	}
	
//	public void agregarPerfil(Perfil perfil) {
//		if(perfiles == null) {
//			perfiles = new LinkedList<>();
//		}
//		perfiles.add(perfil);
//	}

}
