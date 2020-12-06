package com.everis.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author ngalindg
 *
 */
@Repository
public interface EverisCustomerRepositoryI extends JpaRepository<EverisCustomer, Integer> {

	/**
	 * Consultar cliente por id.
	 * 
	 * @param id
	 * @return result
	 */
	public EverisCustomer findBycustomerId(int id);

	/**
	 * Buscar cliente por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstName
	 * @param secondName
	 * @return List<EverisCustomer>
	 */
	public List<EverisCustomer> findByNameAndFirstNameAndSecondName(String name, String firstName, String secondName);

}
