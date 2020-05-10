package com.springjsp.basico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLibro;
	@Column(nullable = false)
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Editorial editorial;
	private String portada;
	@ManyToOne(fetch = FetchType.LAZY)
	private Autor autor;
	
	public Libro() {
	} 

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", editorial=" + editorial + ", portada=" + portada
				+ ", autor=" + autor + "]";
	}

}
