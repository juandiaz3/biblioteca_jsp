package com.springjsp.basico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjsp.basico.repository.LibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	private LibroRepository libroRepository;

}
