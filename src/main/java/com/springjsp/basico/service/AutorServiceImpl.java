package com.springjsp.basico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjsp.basico.entity.Autor;
import com.springjsp.basico.repository.IAutorRepository;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	@Qualifier("AutorRepository")
	private IAutorRepository autorRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Autor> findAll() {
		
		return (List<Autor>) autorRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Autor> findByNameAndByPrimerApellido(String nombre, String primerApellido) {
		
		return autorRepository.findByNombreAndPrimerApellido(nombre, primerApellido);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Autor> findByName(String name) {
		
		return autorRepository.findByNombre(name);
	}
	
	@Override
	public Autor findById(int idAutor) {
		return autorRepository.findById(idAutor).orElse(null);
	}

	public Autor save(Autor autor) {
		
		return autorRepository.save(autor);
	}

	
}
