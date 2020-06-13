package com.biblioteca.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * Clase modelo del libro
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */
@Entity
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	@Column
	private String name;
	@Column
	private int pegi;
	@Column
	private boolean available;
	@Column
	private String photo;
	@OneToMany(mappedBy = "libro")
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
	 * Metodo get de la clasificación
	 * 
	 * @return retorna la clasificación
	 */
	public int getPegi() {
		return pegi;
	}

	/**
	 * Metodo set de la clasificación de edad
	 * 
	 * @param pegi, parametro para setear la clasificación de edad
	 */
	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	/**
	 * Metodo get de la disponibilidad
	 * 
	 * @return availale, retorna la disponibilidad
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Metodo set de la disponibilidad
	 * 
	 * @param available, parametro para setear la disponibilidad
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Metodo get de la foto
	 * 
	 * @return retorna la foto
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Metodo set de la foto
	 * 
	 * @param photo, parametro para setear la foto
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Metodo get de la conexión con un prestamo
	 * 
	 * @return Retonra la conexión con un prestamo
	 */
	public Set<Prestamo> getPrestamo() {
		return prestamo;
	}

	/**
	 * Metodo set de la conexión con un prestamo
	 * 
	 * @param prestamo, parametro para la conexión con un prestamo
	 */
	public void setPrestamo(Set<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}

}
