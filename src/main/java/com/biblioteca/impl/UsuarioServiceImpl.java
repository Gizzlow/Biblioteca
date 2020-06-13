package com.biblioteca.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Usuario;
import com.biblioteca.repo.IUsuarioRepo;
import com.biblioteca.service.UsuarioService;

/**
 * Esta clase implementa los metodos del Usuario
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

	// Inicializa el repositorio de Usuario
	@Autowired
	private IUsuarioRepo repo;

	/**
	 * Implementación del metodo de guardar usuario
	 */
	@Override
	public Usuario save(Usuario user) {
		return repo.save(user);
	}

	/**
	 * Implementaicón del metodo borrar usuario
	 */
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	/**
	 * Implementación del metodo obtener usuario por id
	 */
	@Override
	public Usuario get(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	/**
	 * Implementación del metodo obtener la lista de usuarios
	 */
	@Override
	public List<Usuario> getAll() {
		List<Usuario> returnList = new ArrayList<>();
		repo.findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

}
