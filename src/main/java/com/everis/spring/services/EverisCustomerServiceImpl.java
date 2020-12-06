package com.everis.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.repository.EverisCustomerRepositoryI;

/**
 * Servicio: gestión de clientes.
 * 
 * @author ngalindg
 *
 */
@Service
public class EverisCustomerServiceImpl implements EverisCustomerServiceI {
	/** Repositorio: customer */
	@Autowired
	private EverisCustomerRepositoryI customerRepository;

	@Override
	public void addCustomer(EverisCustomer entity) {
		customerRepository.save(entity);

	}

	@Override
	public List<EverisCustomer> getAllCustomer() {
		List<EverisCustomer> everisCustomerList = customerRepository.findAll();

		if (!CollectionUtils.isEmpty(everisCustomerList)) {
			for (EverisCustomer everisCustomer : everisCustomerList) {
				System.out.println(everisCustomer.toString());
			}
		} else {
			System.out.println("Can not find customers");
		}
		return everisCustomerList;
	}

	@Override
	public void getCustomerById(int id) {
		EverisCustomer everisCustomer = customerRepository.findBycustomerId(id);

		if (everisCustomer != null) {
			System.out.println("Client with id: " + id);
			System.out.println(everisCustomer.toString());
		}

	}

	@Override
	public void removeCustomer(Integer entity) {
		customerRepository.deleteById(entity);

	}

	@Override
	public void updCustomer(EverisCustomer entity) {
		customerRepository.save(entity);

	}

	@Override
	public List<EverisCustomer> getCustomerByNameFirstNameSecondName(String name, String firstName, String secondName) {
		List<EverisCustomer> everisCustomerList = customerRepository.findByNameAndFirstNameAndSecondName(name, firstName, secondName);

		if (!CollectionUtils.isEmpty(everisCustomerList)) {

			for (EverisCustomer everisCustomer : everisCustomerList) {
				System.out.println(everisCustomer.toString());
			}
		} else {
			System.out.println("Can not find customer with name: " + name + " / firstName: " + firstName + " /secondName: " + secondName);
		}
		return everisCustomerList;
	}

}
