package com.springjsp.basico.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springjsp.basico.entity.AutorHerencia;
import com.springjsp.basico.service.IAutorService;

@Controller
public class IndexController {
	
	@Autowired
	private IAutorService autorService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("titulo", "Listado de autores");
		model.addAttribute("autores", autorService.findAll());
		return "home";
	}
	
	@PostMapping(value="/filtrarAutor")
	public String filtrarAutor(@RequestParam("inputFiltrarNombre") String nombre, @RequestParam("inputFiltrarPrimerApellido") String primerApellido, Model model) {
		
		System.out.println("Nombre y apellido " + nombre + ", " + primerApellido);
		
		model.addAttribute("titulo", "Listado de autores");
		model.addAttribute("autores", autorService.findByNameAndByPrimerApellido(nombre, primerApellido));
//		model.addAttribute("autores", autorService.findAll());
		
		return "home";
	}
	
	@GetMapping(value="/detalle/{name}")
	public String mostrarDetalle(@PathVariable("name") String name, Model model) {
		
		model.addAttribute("autor", autorService.findByName(name));
		
		return "detalle";
	}
	
	@GetMapping(value="/nuevoAutor")
	public String nuevoAutor(Model model) {
		
		model.addAttribute("autor", new AutorHerencia());
		
		return "autor/nuevo";
	}
	
	@PostMapping(value="/nuevoAutor")
	public String nuevoAutorPost(@ModelAttribute AutorHerencia autor, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			System.out.println("Se ha producido un error " + result.toString());
			return "autor/nuevo";
		}
		
//		for(ObjectError error : result.getAllErrors()) {
//			System.out.println("Tipo error: " + error.getDefaultMessage());
//		}
			
		autorService.save(autor);
		
		attributes.addFlashAttribute("msgExito", "El nuevo autor se ha creado");
		
		return "redirect:/home";
	}
	
	@InitBinder("autor")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));
	}

}
