package com.springjsp.basico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjspWarApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringjspWarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Configurado CommandLineRunner");
	}

}
