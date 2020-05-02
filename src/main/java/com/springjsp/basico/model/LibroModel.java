package com.springjsp.basico.model;

import java.io.Serializable;

public class LibroModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String autor;
	
	public LibroModel() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
