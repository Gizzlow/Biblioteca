package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;

/**
 * Esta clase es el controlador del Usuario
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */
@Controller
public class UsuarioController {

	// Inyección de la dependencia de Usuario
	@Autowired
	private UsuarioService user;
	// Inicialización del codificador
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/Usuarios")
	public String index(Model model) {
		model.addAttribute("list", user.getAll());
		return "Usuarios";
	}

	@GetMapping("/saveUsuario/{id}")
	public String ShowSave(@PathVariable("id") Long id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("user", user.get(id));
		} else {
			model.addAttribute("user", new Usuario());
		}
		return "saveUsuario";
	}

	@PostMapping("/saveUsuario")
	public String save(Usuario usuario, Model model) {
		encoder = new BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword()));

		user.save(usuario);
		return "redirect:/Usuarios";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		user.delete(id);
		return "redirect:/Usuarios";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

}
