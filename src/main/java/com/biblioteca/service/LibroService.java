package com.biblioteca.service;

import java.util.List;

import com.biblioteca.model.Libro;

/**
 * Esta interface implementa los metodos del Usuario
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

public interface LibroService {

	public Libro save(Libro book);

	public void delete(Long id);

	public Libro get(Long id);

	public List<Libro> getAll();

	public List<Libro> obtenerLibrosDisponibles();

	public long obtenerLibrosPrestados();

}
