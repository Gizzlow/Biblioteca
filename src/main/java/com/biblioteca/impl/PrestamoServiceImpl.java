package com.biblioteca.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Prestamo;
import com.biblioteca.repo.IPrestamoRepo;
import com.biblioteca.service.PrestamoService;

/**
 * Esta clase implementa los metodos del Prestamo
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Service
public class PrestamoServiceImpl implements PrestamoService {

	// Inicializa el repositorio de prestamo
	@Autowired
	private IPrestamoRepo repo;

	/**
	 * Implementación del metodo de guardar prestamo
	 */
	@Override
	public Prestamo save(Prestamo loan) {
		return repo.save(loan);
	}

	/**
	 * Implementación del metodo de eliminar prestamo
	 */
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	/**
	 * Implementación del metodo obtener prestamo por id
	 */
	@Override
	public Prestamo get(Long id) {
		Optional<Prestamo> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	/**
	 * Implementación del metodo obtener la lista de prestamos
	 */
	@Override
	public List<Prestamo> getAll() {
		List<Prestamo> returnList = new ArrayList<>();
		repo.findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	/**
	 * Implementación del metodo obtener las zonas de prestamo
	 */
	@Override
	public List<String> obtenerZonasPrestamo() {
		return repo.obtenerZonasPrestamo();
	}

	/**
	 * Implementación del metodo para obtener un mapa de las zonas por libro
	 * prestado
	 */
	@Override
	public HashMap<String, Long> obtenerZonaNum() {

		List<String> lista = repo.obtenerZonasPrestamo();
		HashMap<String, Long> resultado = new HashMap<>();

		for (int i = 0; i < lista.size(); i++) {

			resultado.put(lista.get(i), repo.obtenerZonasNum(lista.get(i)));

		}

		return resultado;
	}

}
