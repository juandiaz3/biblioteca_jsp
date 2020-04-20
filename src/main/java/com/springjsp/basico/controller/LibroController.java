package com.springjsp.basico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springjsp.basico.entity.Autor;
import com.springjsp.basico.entity.Editorial;
import com.springjsp.basico.entity.Libro;
import com.springjsp.basico.service.IAutorService;
import com.springjsp.basico.service.IEditorialService;
import com.springjsp.basico.service.ILibroService;

@Controller
public class LibroController {
	
	@Autowired
	private  ILibroService libroService;
	
	@Autowired
	private IAutorService autorService;
	
	@Autowired
	private IEditorialService editorialService;
	
	@GetMapping(value="/indexLibros")
	public String listaLibros(Model model) {
		
		model.addAttribute("libros", libroService.findAll());
		
		return "libro/indexLibros";
	}
	
	@GetMapping(value = "/detalle/{idLibro}")
	public String detalleLibro(@PathVariable("idLibro") int idLibro, Model model) {
		
		Libro libro = libroService.findById(idLibro);
		model.addAttribute("libro", libro);
		
		return "libro/detalleLibro";
	}
	
	@GetMapping(value="/nuevoLibro")
	public String detalle(@ModelAttribute Libro libro, Model model) {
		
		List<Autor> autores = autorService.findAll();
		List<Editorial> editoriales = editorialService.findAll();
		model.addAttribute("autores", autores);
		model.addAttribute("editoriales", editoriales);
		
		return "libro/formLibro";
	}
	
	@PostMapping(value = "/nuevoLibro")
//	public String nuevoLibro(@ModelAttribute Libro libro, BindingResult result, Model model, @RequestParam("portada") MultipartFile portada, RedirectAttributes attributes) {
	public String nuevoLibro(@ModelAttribute Libro libro, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "libro/formLibro";
		}
		
//		if(!portada.isEmpty()) {
//			// Ruta de almacenamiento de las imágenes
//			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
//			// String para concatenar el nombre del archivo
//			String rootPath = directorioRecursos.toFile().getAbsolutePath();
//			
//			try {
//				// Obtener los bytes del archivo
//				byte[] bytes = portada.getBytes();
//				Path rutaCompleta = Paths.get(rootPath + "//" + portada.getOriginalFilename());
//				Files.write(rutaCompleta, bytes);
//				attributes.addFlashAttribute("info", "Has subido el archivo " + portada.getOriginalFilename());
//				
//				libro.setPortada(portada.getOriginalFilename());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		try {
			libroService.save(libro);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		attributes.addFlashAttribute("mensaje", "El libro se ha creado correctamente");
		
		return "redirect:/indexLibros";
	}
	
	@GetMapping(value = "/modificarLibro/{idLibro}")
	public String modificarLibro(@PathVariable("idLibro") int idLibro, Model model) {
		
		if(idLibro > 0) {
			model.addAttribute("libro", libroService.findById(idLibro));
		}else {
			return "redirect:/indexLibros";
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
		
		return "redirect:/indexLibros";
	}

}
