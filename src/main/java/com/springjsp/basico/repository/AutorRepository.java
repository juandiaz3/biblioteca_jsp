package com.springjsp.basico.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springjsp.basico.entity.Autor;

public interface AutorRepository {
	
	public List<Autor> findAll();
	
	public List<Autor> findByNameAndByPrimerApellido(String name, String primerApellido);
	
	public Autor getAutorByName(String name);
	
	public Boolean saveAutor(Autor autor);
	

}
