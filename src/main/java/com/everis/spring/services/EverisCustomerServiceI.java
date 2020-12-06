package com.everis.spring.services;

import java.util.List;

import com.everis.spring.repository.EverisCustomer;

/**
 * Servicio: gestión de clientes
 * 
 * @author ngalindg
 *
 */
public interface EverisCustomerServiceI {
	/**
	 * Insertar un cliente.
	 * 
	 * @param entity
	 */

	public void addCustomer(EverisCustomer entity);

	/**
	 * Consultar todos los clientes.
	 * 
	 * @return List<EverisCustomer>
	 */
	public List<EverisCustomer> getAllCustomer();

	/**
	 * Consultar cliente por id.
	 * 
	 */
	public void getCustomerById(int id);

	/**
	 * Eliminar un cliente.
	 * 
	 * @param entity
	 */
	public void removeCustomer(Integer entity);

	/**
	 * Actualizar un cliente.
	 * 
	 * @param entity
	 */
	public void updCustomer(EverisCustomer entity);

	/**
	 * Buscar cliente por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstName
	 * @param lastName
	 * @return List<EverisCustomer>
	 */
	public List<EverisCustomer> getCustomerByNameFirstNameSecondName(String name, String firstName, String secondName);

}
