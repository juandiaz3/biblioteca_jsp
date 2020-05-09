package com.springjsp.basico.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springjsp.basico.entity.Autor;
import com.springjsp.basico.entity.Editorial;
import com.springjsp.basico.entity.Libro;
import com.springjsp.basico.model.LibroFilter;
import com.springjsp.basico.service.IAutorService;
import com.springjsp.basico.service.IEditorialService;
import com.springjsp.basico.service.ILibroService;

@Controller
@RequestMapping(value = "/libros")
public class LibroController {
	
//	private static final Log logger = LogFa
	
	@Autowired
	private  ILibroService libroService;
	
	@Autowired
	private IAutorService autorService;
	
	@Autowired
	private IEditorialService editorialService;
	
	@GetMapping(value="/indexLibros")
	public String listaLibros(Model model) {
		
		model.addAttribute("libroFilter", new LibroFilter());
		model.addAttribute("libros", libroService.findAll());
		
		return "libro/indexLibros";
	}
	
	@PostMapping(value = "/filtrarLibro")
	public String filtrarLibros(@ModelAttribute LibroFilter libroFilter, Model model) {
		
		model.addAttribute("libros", libroService.findByTitulo(libroFilter.getTitulo()));
		
		return "libro/indexLibros";
	}
	
	@PostMapping(value = "/ordenarLibros")
	public String ordenarLibros(@RequestParam("inputOrdenarLibros") String ordenLibros, Model model) {
		
		if(ordenLibros.equals("titulo asc")) {
			model.addAttribute("libros", libroService.findAll(Sort.by("titulo")));
		}else if(ordenLibros.equals("titulo desc")) {
			model.addAttribute("libros", libroService.findAll(Sort.by("titulo").descending()));
		}
		
		return "libro/indexLibros";
	}
	
	@GetMapping(value = "/detalle/{idLibro}")
	public String detalleLibro(@PathVariable("idLibro") int idLibro, Model model) {
		
		Libro libro = libroService.findById(idLibro);
		model.addAttribute("libro", libro);
		
		return "libro/detalleLibro";
	}
	
	@GetMapping(value="/nuevoLibro")
//	public String detalle(@ModelAttribute Libro libro, Model model) {
	public String nuevo(Model model) {
		
		List<Autor> autores = autorService.findAll();
		List<Editorial> editoriales = editorialService.findAll();
		model.addAttribute("libro", new Libro());
		model.addAttribute("autores", autores);
		model.addAttribute("editoriales", editoriales);
		
		return "libro/formLibro";
	}
	
	@PostMapping(value = "/nuevoLibro")
	public String nuevoLibro(@ModelAttribute Libro libro, BindingResult result, Model model, @RequestParam("filePortada") MultipartFile filePortada, RedirectAttributes attributes) {
//	public String nuevoLibro(@ModelAttribute Libro libro, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "libro/formLibro";
		}
		
		if(!filePortada.isEmpty()) {
			// Ruta de almacenamiento de las imágenes
//			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			// Convertir Path a String
//			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			String rootPath = "C://Temp/uploads";
			
			System.out.println("Root path " + rootPath);
			
			try {
				// Obtener los bytes del archivo recibido del formulario
				byte[] bytes = filePortada.getBytes();
				// Agregar el nombre del archivo seleccionado a la ruta
				Path rutaCompleta = Paths.get(rootPath + "//" + filePortada.getOriginalFilename());
				
				System.out.println("rutaCompleta " + rutaCompleta);
				
				// Escribir el contenido del fichero en el archivo creado
				Files.write(rutaCompleta, bytes);
				attributes.addFlashAttribute("info", "Has subido el archivo " + filePortada.getOriginalFilename());
				
				libro.setPortada(filePortada.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			libroService.save(libro);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		attributes.addFlashAttribute("mensaje", "El libro se ha creado correctamente");
		
		return "redirect:/libros/indexLibros";
	}
	
	@GetMapping(value = "/modificarLibro/{idLibro}")
	public String modificarLibro(@PathVariable("idLibro") int idLibro, Model model) {
		
		if(idLibro > 0) {
			model.addAttribute("libro", libroService.findById(idLibro));
		}else {
			return "redirect:/libros/indexLibros";
		}
		
		List<Autor> autores = autorService.findAll();
		List<Editorial> editoriales = editorialService.findAll();
		model.addAttribute("autores", autores);
		model.addAttribute("editoriales", editoriales);
		
		return "libro/formLibro";
	}
	
	@GetMapping(value = "/borrarLibro/{idLibro}")
	public String borrarLibro(@PathVariable("idLibro") Integer idLibro, RedirectAttributes attributes) {
		
		if(idLibro > 0) {
			libroService.delete(idLibro);
			attributes.addFlashAttribute("mensaje", "El libro se ha borrado correctamente");
		}
		
		return "redirect:/libros/indexLibros";
	}
	
	private boolean hasRole(String role) {
		SecurityContext context = SecurityContextHolder.getContext();
		
		if(context == null) {
			return false;
		}
		
		Authentication auth = context.getAuthentication();
		
		if(auth == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		for(GrantedAuthority authority : authorities) {
			if(role.equals(authority.getAuthority())) {
				return true;
			}
		}
		
		return false;
	}

}
