package com.biblioteca.service;

import java.util.HashMap;
import java.util.List;

import com.biblioteca.model.Prestamo;

/**
 * Esta interface implementa los metodos del Prestamo
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

public interface PrestamoService {

	public Prestamo save(Prestamo loan);

	public void delete(Long id);

	public Prestamo get(Long id);

	public List<Prestamo> getAll();

	public List<String> obtenerZonasPrestamo();

	public HashMap<String, Long> obtenerZonaNum();

}
