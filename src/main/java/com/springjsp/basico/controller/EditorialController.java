package com.springjsp.basico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springjsp.basico.service.IEditorialService;

@Controller
@RequestMapping(value = "/editoriales")
public class EditorialController {
	
	@Autowired
	private IEditorialService editorialService;
	
	@GetMapping(value = "/indexEditoriales")
	public String indexEditorial(Model model) {
		model.addAttribute("editoriales", editorialService.findAll());
		
		return "editorial/indexEditoriales";
	}
	
	@GetMapping(value = "/detalleEditorial/{idEditorial}")
	public String detalleEditorial(@PathVariable("idEditorial") Integer idEditorial) {
		
		return "editorial/detalleEditorial";
	}
	
	@GetMapping(value = "/modificarEditorial/{idEditorial}")
	public String modificarEditorial(@PathVariable("idEditorial") Integer idEditorial) {
		
		return "editorial/formEditorial";
	}
	
	@GetMapping(value = "/borrarEditorial/{idEditorial}")
	public String borrarEditorial(@PathVariable("idEditorial") Integer idEditorial) {
		
		return "redirect:/editoriales/indexEditoriales";
	}

}
