package com.biblioteca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Usuario;

/**
 * Clase interface que funciona como repositorio de la clase modelo Usuario
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

	Usuario findByName(String name);

}
