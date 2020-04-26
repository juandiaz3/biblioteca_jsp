package com.springjsp.basico.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}
	
	@GetMapping(value = "/bienvenida")
	public String mostrarBienvenida(Authentication authentication) {
		
		if(authentication != null) {
			System.out.println("Username " + authentication.getName());
			
			for(GrantedAuthority rol : authentication.getAuthorities()) {
				System.out.println("Rol: " + rol.getAuthority());
			}
		}
		
		// Otra forma de recuperar Authentication, de forma estática
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return "redirect:/bienvenida";
	}

}
