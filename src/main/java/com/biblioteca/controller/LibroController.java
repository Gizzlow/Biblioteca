package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;

/**
 * Esta clase es el controlador del libro
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Controller
public class LibroController {

	// Inyección de la dependencia de libro
	@Autowired
	private LibroService book;

	@RequestMapping("/Libros")
	public String libro(Model model) {
		model.addAttribute("listBook", book.getAll());
		model.addAttribute("countBooks", book.obtenerLibrosPrestados());
		return "Libros";
	}

	@GetMapping("/saveLibro/{id}")
	public String ShowSaveLibro(@PathVariable("id") Long id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("book", book.get(id));
		} else {
			model.addAttribute("book", new Libro());
		}
		return "saveLibro";
	}

	@PostMapping("/saveLibro")
	public String saveLibro(Libro libro, Model model) {
		if (libro.getId() == null || libro.getId() == 0) {
			libro.setAvailable(true);
		}
		book.save(libro);
		return "redirect:/Libros";
	}

	@GetMapping("/deleteLibro/{id}")
	public String deleteLibro(@PathVariable("id") Long id, Model model) {
		book.delete(id);
		return "redirect:/Libros";
	}

}
