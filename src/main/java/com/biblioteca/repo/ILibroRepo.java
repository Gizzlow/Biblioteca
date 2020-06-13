package com.biblioteca.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Libro;

/**
 * Clase interface que funciona como repositorio de la clase modelo Libro
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Repository
public interface ILibroRepo extends JpaRepository<Libro, Long> {

	@Query("SELECT li FROM Libro li where li.available=true")
	List<Libro> obtenerLibrosDisponibles();

	@Query("SELECT count(li) FROM Libro li where li.available=false")
	Long obtenerLibrosPrestados();

}
