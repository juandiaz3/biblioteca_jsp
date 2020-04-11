package com.springjsp.basico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjsp.basico.entity.AutorHerencia;
import com.springjsp.basico.repository.AutorRepository;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<AutorHerencia> findAll() {
		
		return autorRepository.findAll();
	}
	
	@Override
	public List<AutorHerencia> findByNameAndByPrimerApellido(String nombre, String primerApellido) {
		
		return autorRepository.findByNameAndByPrimerApellido(nombre, primerApellido);
	}

	@Override
	public AutorHerencia findByName(String name) {
		
		return autorRepository.getAutorByName(name);
	}

	@Override
	public Boolean save(AutorHerencia autor) {
		
		return autorRepository.saveAutor(autor);
	}

}
