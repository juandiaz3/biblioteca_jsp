package com.springjsp.basico.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springjsp.basico.entity.Libro;

@Controller
public class LibroController {
	
	@GetMapping(value="/indexLibros")
	public String listaLibros() {
		
		return "libro/formLibro";
	}
	
	@GetMapping(value="/nuevo")
	public String detalle(@ModelAttribute Libro libro) {
		
		return "libro/formLibro";
	}
	
	@PostMapping(value = "/nuevoLibro")
	public String nuevoLibro(@ModelAttribute Libro libro, BindingResult result, Model model, @RequestParam("portada") MultipartFile portada, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "formLibro";
		}
		
		if(!portada.isEmpty()) {
			// Ruta de almacenamiento de las imágenes
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			// String para concatenar el nombre del archivo
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			
			try {
				// Obtener los bytes del archivo
				byte[] bytes = portada.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + portada.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				attributes.addFlashAttribute("info", "Has subido el archivo " + portada.getOriginalFilename());
				
				libro.setPortada(portada.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/indexLibros";
	}

}
