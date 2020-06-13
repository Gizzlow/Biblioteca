package com.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Usuario;
import com.biblioteca.repo.IUsuarioRepo;

/**
 * Esta clase implementa los metodos del UserDetailsServiceImpl
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 *
 */

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUsuarioRepo user;

	/**
	 * Metodo que permite cargar los datos para validar el login
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario us = user.findByName(username);

		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("usuario"));

		UserDetails userDet = new User(us.getName(), us.getPassword(), roles);

		return userDet;
	}

}
