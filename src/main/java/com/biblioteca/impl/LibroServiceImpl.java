package com.biblioteca.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Libro;
import com.biblioteca.repo.ILibroRepo;
import com.biblioteca.service.LibroService;

/**
 * Esta clase implementa los metodos del Libro
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Service
public class LibroServiceImpl implements LibroService {

	// Inicializa el repositorio de Libro
	@Autowired
	private ILibroRepo repo;

	/**
	 * Implementación del metodo de guardar libro
	 */
	@Override
	public Libro save(Libro book) {
		return repo.save(book);
	}

	/**
	 * Implementaicón del metodo borrar libro
	 */
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	/**
	 * Implementación del metodo obtener libro por id
	 */
	@Override
	public Libro get(Long id) {
		Optional<Libro> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	/**
	 * Implementación del metodo obtener la lista de libros
	 */
	@Override
	public List<Libro> getAll() {
		List<Libro> returnList = new ArrayList<>();
		repo.findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	/**
	 * Implementación del metodo para obtener los libros que estan disponibles para
	 * prestar
	 */
	@Override
	public List<Libro> obtenerLibrosDisponibles() {
		return repo.obtenerLibrosDisponibles();
	}

	/**
	 * Implementacíon del metodo para obtener los libros que estan prestados
	 */
	@Override
	public long obtenerLibrosPrestados() {
		return repo.obtenerLibrosPrestados();
	}

}
