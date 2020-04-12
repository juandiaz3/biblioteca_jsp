package com.springjsp.basico.repository;

import java.util.List;

import com.springjsp.basico.entity.Autor;

public interface AutorRepository {
	
	public List<Autor> findAll();
	
	public List<Autor> findByNameAndByPrimerApellido(String name, String primerApellido);
	
	public Autor getAutorByName(String name);
	
	public Boolean saveAutor(Autor autor);
	

}
