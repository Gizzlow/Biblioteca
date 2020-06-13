package com.biblioteca.service;

import java.util.List;

import com.biblioteca.model.Usuario;

/**
 * Esta interface implementa los metodos del Usuario
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

public interface UsuarioService {

	public Usuario save(Usuario user);

	public void delete(Long id);

	public Usuario get(Long id);

	public List<Usuario> getAll();

}
