package com.springjsp.basico.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class PersonaHerencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idPersona;
	
//	@Column(nullable = false)
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
//	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	private String lugarNacimiento;
	
	public PersonaHerencia() {
		this.idPersona = this.idPersona++;
	}
	
	public PersonaHerencia(String nombre, String primerApellido, String segundoApellido, String lugarNacimiento) {
		this();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = new Date();
		this.lugarNacimiento = lugarNacimiento;
	}

	public PersonaHerencia(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento,
			String lugarNacimiento) {
		this();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarNacimiento = lugarNacimiento;
	}
	
	public int getIdPersona() {
		return idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	
	public abstract void createCodigo();

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento="
				+ lugarNacimiento + "]";
	}

}
