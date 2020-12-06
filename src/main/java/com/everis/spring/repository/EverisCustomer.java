package com.everis.spring.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tabla: customer
 * 
 * @author ngalindg
 *
 */
@Entity
@Table(name = "customer")
public class EverisCustomer implements Serializable {
	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	/**
	 * COLUMNAS DE LA TABLA CUSTOMER
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerId;

	/** Nombre */
	@Column(name = "name")
	private String name;

	/** Primer apellido */
	@Column(name = "firstname")
	private String firstName;

	/** Segundo apellido */
	@Column(name = "secondname")
	private String secondName;

	/** Dni */
	@Column(name = "dni", unique = true, nullable = false, length = 9)
	private String dni;

	/** Constructor vacío */
	public EverisCustomer() {

	}

	/** Constructor con los componentes de la tabla */
	public EverisCustomer(int customerId, String name, String firstName, String secondName, String dni) {
		this.customerId = customerId;
		this.name = name;
		this.firstName = firstName;
		this.secondName = secondName;
		this.dni = dni;

	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName
	 *            the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "EverisCustomer [customerId=" + customerId + ", name=" + name + ", firstName=" + firstName + ", secondName=" + secondName + ", dni=" + dni + "]";
	}

}
