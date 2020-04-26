package com.springjsp.basico.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model, Principal principal, RedirectAttributes attributes) {
		
		if(principal != null) {
			attributes.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");
			return "redirect:/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Error en el login: Nombre o usuario incorrecto");
		}
		
		return "login";
	}

}