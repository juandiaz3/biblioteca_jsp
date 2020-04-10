package com.springjsp.basico.repository;

import org.springframework.data.repository.CrudRepository;

import com.springjsp.basico.entity.Libro;

public interface LibroRepository extends CrudRepository<Libro, Integer> {

}
