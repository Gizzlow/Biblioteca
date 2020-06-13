package com.biblioteca.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Clase modelo del usuario
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private int age;
	@Column
	private String zone;
	@OneToMany(mappedBy = "usuario")
	private Set<Prestamo> prestamo;

	// Getters and setters

	/**
	 * Metodo get del id
	 * 
	 * @return retorna el id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo set del id
	 * 
	 * @param id, parametro para setear el id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo get del nombre
	 * 
	 * @return retorna el nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo set del nombre
	 * 
	 * @param name, parametro para setear el nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo get de la contraseña
	 * 
	 * @return retorna la contraseña
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo set de la contraseña
	 * 
	 * @param password, parametro para setear la contraseña
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metodo get de la edad
	 * 
	 * @return retorna la edad
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Metodo set de la edad
	 * 
	 * @param age, parametro para setear la edad
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Metodo get de la zona
	 * 
	 * @return retorna la zona
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * Metodo set de la zona
	 * 
	 * @param zone, parametro para setear la zona
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

}
