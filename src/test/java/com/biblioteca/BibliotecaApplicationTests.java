package com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repo.IPrestamoRepo;
import com.biblioteca.repo.IUsuarioRepo;

@SpringBootTest
class BibliotecaApplicationTests {

	@Autowired
	private IUsuarioRepo iusuario;

	@Autowired
	private IPrestamoRepo iprestamo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuario() {

		Usuario usuario = new Usuario();
		usuario.setName("Gary");
		usuario.setPassword(encoder.encode("123"));
		usuario.setAge(21);
		usuario.setZone("armenia oeste");
		Usuario prueba = iusuario.save(usuario);

		assertTrue(prueba.getName().equalsIgnoreCase(usuario.getName()));
	}

}
