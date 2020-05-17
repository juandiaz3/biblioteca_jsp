package com.springjsp.basico;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springjsp.basico.entity.Perfil;
import com.springjsp.basico.entity.Usuario2;
import com.springjsp.basico.repository.PerfilesRepository;
import com.springjsp.basico.repository.Usuarios2Repository;

@SpringBootApplication
public class SpringjspWarApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private Usuarios2Repository usuario2Repository;
	
	@Autowired
	private PerfilesRepository perfilesRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringjspWarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Configurado CommandLineRunner");
		
		crearPerfiles();
		
		crearUsuarioCon2Perfiles();
		
		String password = "12345";
		
		for(int i = 0; i < 2; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println("Password " + i + ": " + bcryptPassword);
		}
	}
	
	private void crearPerfiles() {
		perfilesRepository.saveAll(getPerfilesAplication());
	}
	
	private List<Perfil> getPerfilesAplication(){
		List<Perfil> listaPerfiles = new LinkedList<Perfil>();
		Perfil perfil1 = new Perfil();
		perfil1.setPerfil("ADMINISTRADOR");
		Perfil perfil2 = new Perfil();
		perfil2.setPerfil("USUARIO");
		Perfil perfil3 = new Perfil();
		perfil3.setPerfil("SUPERVISOR");
		
		listaPerfiles.add(perfil1);
		listaPerfiles.add(perfil2);
		listaPerfiles.add(perfil3);
		
		return listaPerfiles;
	}
	
	private void crearUsuarioCon2Perfiles() {
		Usuario2 usuario = new Usuario2();
		usuario.setNombre("Juan Diaz");
		usuario.setEmail("juan@correo.es");
		usuario.setFechaRegistro(new Date());
		usuario.setUsername("juanuser");
		usuario.setPassword("12345");
		usuario.setEstatus("true");
		
		Perfil perfil = new Perfil();
		perfil.setIdPerfil(1);
		Perfil perfil2 = new Perfil();
		perfil2.setIdPerfil(2);
		
		usuario.addPerfil(perfil);
		usuario.addPerfil(perfil2);
		
		usuario2Repository.save(usuario);
	}
	
	

}
