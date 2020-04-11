package com.springjsp.basico.service;

import java.util.List;

import com.springjsp.basico.entity.AutorHerencia;

public interface IAutorService {
	
	public List<AutorHerencia> findAll();
	
	public List<AutorHerencia> findByNameAndByPrimerApellido(String nombre, String primerApellido);
	
	public AutorHerencia findByName(String name);
	
	public Boolean save(AutorHerencia autor);

}
