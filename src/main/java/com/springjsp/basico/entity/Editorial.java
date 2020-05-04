package com.springjsp.basico.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEditorial;
	
	@NotEmpty
	private String nombre;
	private String pais;
	
	@OneToMany(mappedBy = "editorial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Libro> libros;
	
	public Editorial() {
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void addLibro(Libro libro) {
		if(libros == null) {
			this.libros = new ArrayList<>();
			this.libros.add(libro);
		}
		this.libros.add(libro);
	}
	
	public void removeLibro(Libro libro) {
		this.libros.remove(libro);
	}

}
