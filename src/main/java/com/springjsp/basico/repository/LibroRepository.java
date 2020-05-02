package com.springjsp.basico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjsp.basico.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
	
	public List<Libro> findByTitulo(String titulo);

}
