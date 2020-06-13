package com.biblioteca.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.biblioteca.service.UserService;

/**
 * Clase que implementa la seguridad
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	// Exepciones de autenticación
	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**" };

	/**
	 * Metodo que inicializa el codificador
	 * 
	 * @return retorna la variable del codificador
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}

	/**
	 * Metodo que controla los parametros de autenticación.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}

	/**
	 * Metodo que controla las rutas de usuarios que estan logueados o no
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll()
				.antMatchers("/login", "/saveUsuario/0", "/saveUsuario").permitAll().antMatchers("/admin*")
				.access("hasRole('ADMIN')").antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/")
				.failureUrl("/login?error=true").usernameParameter("name").passwordParameter("password").and().logout()
				.permitAll().logoutSuccessUrl("/login?logout");
	}

}
