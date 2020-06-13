package com.biblioteca.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Prestamo;

/**
 * Clase interface que funciona como repositorio de la clase modelo Prestamo
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Repository
public interface IPrestamoRepo extends JpaRepository<Prestamo, Long> {

	@Query(value = "select distinct u.zone from prestamo pres join usuario u on pres.usuario=u.id", nativeQuery = true)
	List<String> obtenerZonasPrestamo();

	@Query(value = "select count(*) from prestamo pres join usuario u on pres.usuario=u.id where u.zone=?1", nativeQuery = true)
	Long obtenerZonasNum(String zona);

}
