package com.springjsp.basico.service;

import java.util.List;

import com.springjsp.basico.entity.Autor;

public interface IAutorService {
	
	public List<Autor> findAll();
	
	public List<Autor> findByNameAndByPrimerApellido(String nombre, String primerApellido);
	
	public List<Autor> findByName(String name);
	
	public Autor findById(int idAutor);
	
	public Autor save(Autor autor);

}
