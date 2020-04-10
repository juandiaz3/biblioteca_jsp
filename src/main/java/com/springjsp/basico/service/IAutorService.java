package com.springjsp.basico.service;

import java.util.List;

import com.springjsp.basico.entity.Autor;

public interface IAutorService {
	
	public List<Autor> findAll();
	
	public List<Autor> findByNameAndByPrimerApellido(String nombre, String primerApellido);
	
	public Autor findByName(String name);
	
	public Boolean save(Autor autor);

}
