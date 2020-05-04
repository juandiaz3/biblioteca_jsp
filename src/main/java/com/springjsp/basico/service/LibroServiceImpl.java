package com.springjsp.basico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springjsp.basico.entity.Libro;
import com.springjsp.basico.repository.LibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}
	
	@Override
	public List<Libro> findAll(Sort order) {
		
		return libroRepository.findAll(order);
	}
	
	@Override
	public List<Libro> findByTitulo(String titulo) {
		
		return libroRepository.findByTitulo(titulo);
	}

	@Override
	public Libro findById(int idLibro) {
		return libroRepository.findById(idLibro).orElse(null);
	}

	@Override
	public void save(Libro libro) {
		libroRepository.save(libro);
	}

	@Override
	public void delete(int idLibro) {
		libroRepository.deleteById(idLibro);;
	}

}
