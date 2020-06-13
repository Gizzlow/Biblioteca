package com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Clase modelo del prestamo
 * 
 * @author Juan David Trujillo Jaramillo
 * @version 1.0
 */
@Entity
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "libro", referencedColumnName = "id")
	private Libro libro;

	@Column
	private Date fechaInicio;
	@Column
	private Date fechaFin;
	@Transient
	private Long diasPrestamo;

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
	 * Metodo get del usuario
	 * 
	 * @return retorna el usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Metodo set del usuario
	 * 
	 * @param usuario, parametro para setear el usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo get del libro
	 * 
	 * @return retorna el libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * Metodo set del libro
	 * 
	 * @param libro, parametro para setear el libro
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * Metodo get de la fecha de prestamo
	 * 
	 * @return retorna la fecha de prestamo
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Metodo set de la fecha de prestamo
	 * 
	 * @param fechaInicio, parametro para setear la fecha de prestamo
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Metodo get de la fecha de entrega
	 * 
	 * @return retorna la fecha de entrega
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Metodo set de la fecha de entrega
	 * 
	 * @param fechaFin, parametro para setear la fecha de entrega
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Metodo get de los dias que lleva prestado el libro
	 * 
	 * @return retorna los dias que lleva prestado el libro
	 */
	public Long getDiasPrestamo() {
		Date date = new Date();
		Long dateResult = date.getTime() - fechaInicio.getTime();

		return dateResult / 86400000;
	}

	/**
	 * Metodo set de los dias que lleva prestado el libro
	 * 
	 * @param diasPrestamo, parametro para setear los dias que lleva prestado el
	 *                      libro
	 */
	public void setDiasPrestamo(Long diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}

}
