package com.biblioteca.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.LibroService;
import com.biblioteca.service.PrestamoService;
import com.biblioteca.service.UsuarioService;

/**
 * Esta clase es el controlador del Prestamo
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */
@Controller
public class PrestamoController {

	// Inyección de la dependencia de Prestamo
	@Autowired
	private PrestamoService loan;

	// Inyección de la dependencia de Usuario
	@Autowired
	private UsuarioService user;

	// Inyección de la dependencia de libro
	@Autowired
	private LibroService book;

	@RequestMapping("/Prestamos")
	public String index(Model model) {
		model.addAttribute("listLoan", loan.getAll());
		model.addAttribute("listZones", loan.obtenerZonasPrestamo());
		model.addAttribute("listZones2", loan.obtenerZonaNum());
		return "Prestamos";
	}

	@GetMapping("/savePrestamo/{id}")
	public String ShowSave(@PathVariable("id") Long id, Model model) {

		model.addAttribute("listUser", user.getAll());
		model.addAttribute("listBook", book.obtenerLibrosDisponibles());

		if (id != null && id != 0) {
			model.addAttribute("loan", loan.get(id));
		} else {
			model.addAttribute("loan", new Prestamo());
		}
		return "savePrestamo";
	}

	@PostMapping("/savePrestamo")
	public String save(Prestamo prestamo, Model model) {

		Usuario usuario = user.get(prestamo.getUsuario().getId());
		Libro libro = book.get(prestamo.getLibro().getId());

		if (usuario.getAge() <= libro.getPegi()) {
			return "redirect:/savePrestamo/0?error=true";
		}

		if (prestamo.getId() == null || prestamo.getId() == 0) {
			libro.setAvailable(false);
			book.save(libro);
			prestamo.setFechaInicio(new Date());
		}

		loan.save(prestamo);
		return "redirect:/Prestamos";
	}

	@GetMapping("/deletePrestamo/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {

		Libro libro = book.get(loan.get(id).getLibro().getId());
		libro.setAvailable(true);
		book.save(libro);

		loan.delete(id);
		return "redirect:/Prestamos";
	}

}
