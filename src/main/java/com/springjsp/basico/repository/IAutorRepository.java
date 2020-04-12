package com.springjsp.basico.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjsp.basico.entity.Autor;

@Repository
@Qualifier("AutorRepository")
public interface IAutorRepository extends JpaRepository<Autor, Integer> {
	
	public List<Autor> findByNombre(String nombre);
	
	public List<Autor> findByNombreAndPrimerApellido(String nombre, String primerApellido);

}
