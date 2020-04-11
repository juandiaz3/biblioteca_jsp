package com.springjsp.basico.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.springjsp.basico.entity.AutorHerencia;

@Repository
public class AutorRepositoryImpl implements AutorRepository {
	
	private static Log logger = LogFactory.getLog(AutorRepositoryImpl.class);
	
	private List<AutorHerencia> listaAutores;
	
	public AutorRepositoryImpl() {
		this.listaAutores = createListAutores();
	}

	@Override
	public List<AutorHerencia> findAll() {
		
		return listaAutores;
	}
	
	@Override
	public List<AutorHerencia> findByNameAndByPrimerApellido(String name, String primerApellido) {
		
		return listaAutores.stream().filter(autor -> autor.getNombre().equals(name)).collect(Collectors.toList());
	}

	@Override
	public AutorHerencia getAutorByName(String name) {
		AutorHerencia a = listaAutores.stream().filter(autor->autor.getNombre().equals(name)).findFirst().orElse(null);
				
		return a;
	}
	
	@Override
	public Boolean saveAutor(AutorHerencia autor) {
		
		try {
			listaAutores.add(autor);
			return true;
		}catch(Exception e) {
			logger.debug("Error en la creación de Autor");
		}
		
		return false;
	}
	
	private List<AutorHerencia> createListAutores(){
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		
		List<AutorHerencia> listaAutores = null;
		
		try {
			listaAutores = new ArrayList<>();
			
			AutorHerencia autor1 = new AutorHerencia();
			autor1.setNombre("Juan");
			autor1.setPrimerApellido("García");
			autor1.setSegundoApellido("Mouriño");
			autor1.setFechaNacimiento(formatDate.parse("11-05-1998"));
			autor1.setLugarNacimiento("A Coruña");
			listaAutores.add(autor1);
			
			AutorHerencia autor2 = new AutorHerencia();
			autor2.setNombre("Jose");
			autor2.setPrimerApellido("Gómez");
			autor2.setSegundoApellido("Atrezo");
			autor2.setFechaNacimiento(formatDate.parse("20-10-1993"));
			autor2.setLugarNacimiento("Santander");
			listaAutores.add(autor2);
			
			AutorHerencia autor3 = new AutorHerencia();
			autor3.setNombre("María");
			autor3.setPrimerApellido("Sanesteban");
			autor3.setSegundoApellido("Picazo");
			autor3.setFechaNacimiento(formatDate.parse("05-03-1991"));
			autor3.setLugarNacimiento("Santander");
			listaAutores.add(autor3);
		}catch(Exception e) {
		
		}
		
		
		
		return listaAutores;
	}
	
}
