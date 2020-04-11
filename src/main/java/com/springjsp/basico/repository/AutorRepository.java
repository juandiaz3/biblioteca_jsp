package com.springjsp.basico.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springjsp.basico.entity.AutorHerencia;

public interface AutorRepository {
	
	public List<AutorHerencia> findAll();
	
	public List<AutorHerencia> findByNameAndByPrimerApellido(String name, String primerApellido);
	
	public AutorHerencia getAutorByName(String name);
	
	public Boolean saveAutor(AutorHerencia autor);
	

}
