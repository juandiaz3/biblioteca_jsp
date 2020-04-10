package com.springjsp.basico.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Autor extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idAutor;
//	@OneToMany(mappedBy = "autor")
//	private List<Libro> libros;

	public Autor() {
		super();
		createCodigo();
	}
	
	public Autor(String nombre, String primerApellido, String segundoApellido, String lugarNacimiento, List<Libro> libros) {
		super(nombre, primerApellido, segundoApellido, lugarNacimiento);
		createCodigo();
//		this.libros = libros;
	}

	public Autor(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento,
			String lugarNacimiento, List<Libro> libros) {
		super(nombre, primerApellido, segundoApellido, fechaNacimiento,	lugarNacimiento);
//		this.libros = libros;
	}

	public String getIdAutor() {
		return idAutor;
	}

//	public List<Libro> getLibros() {
//		return libros;
//	}
//
//	public void addLibro(Libro libro) {
//		if(libros == null) {
//			this.libros = new ArrayList<>();
//			this.libros.add(libro);
//		}
//		this.libros.add(libro);
//	}
//	
//	public void removeLibro(Libro libro) {
//		this.libros.remove(libro);
//	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Autor [libros=]";
	}

	@Override
	public void createCodigo() {
		this.idAutor = "AUT".concat(String.valueOf(super.getIdPersona()));
	}
	
}
