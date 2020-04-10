package com.springjsp.basico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjsp.basico.entity.Autor;
import com.springjsp.basico.repository.AutorRepository;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<Autor> findAll() {
		
		return autorRepository.findAll();
	}
	
	@Override
	public List<Autor> findByNameAndByPrimerApellido(String nombre, String primerApellido) {
		
		return autorRepository.findByNameAndByPrimerApellido(nombre, primerApellido);
	}

	@Override
	public Autor findByName(String name) {
		
		return autorRepository.getAutorByName(name);
	}

	@Override
	public Boolean save(Autor autor) {
		
		return autorRepository.saveAutor(autor);
	}

}
