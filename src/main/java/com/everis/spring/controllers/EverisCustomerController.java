package com.everis.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerServiceI;

/**
 * 
 * @author ngalindg
 *
 */

@Controller
public class EverisCustomerController {
	/**
	 * Servicio: gestión de clientes.
	 */
	@Autowired
	private EverisCustomerServiceI customerService;

	/**
	 * Mostrar todos los clientes.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/showCustomerView")
	public String showCustomers(Model model) {

		// Obtener todos los clientes.
		final List<EverisCustomer> customerList = customerService.getAllCustomer();

		// Cargar todos los datos al modelo.
		model.addAttribute("customerListView", customerList);
		model.addAttribute("btnDropCustomerEnabled", Boolean.FALSE);

		return "showCustomers";
	}

	/**
	 * Eliminar un cliente.
	 * 
	 * @param entity
	 * @param model
	 * @return String
	 */
	@PostMapping("/actDropCustomer")
	public String deleteCustomer(@RequestParam Integer entity, Model model) {

		// Eliminar cliente.
		customerService.removeCustomer(entity);

		return "redirect:showCustomerView";
	}

	/**
	 * Consultar un cliente por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstName
	 * @param secondName
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actSearchCustomer")
	public String submitSearchCustomerForm(@ModelAttribute EverisCustomer searchedCustomer, Model model) throws Exception {

		// Posibilidad de varios resultados.
		List<EverisCustomer> customerList = new ArrayList<EverisCustomer>();

		String customerName = searchedCustomer.getName();
		String customerFirstName = searchedCustomer.getFirstName();
		String customerSecondName = searchedCustomer.getSecondName();

		// Buscar por nombre y apellidos.
		if (StringUtils.hasText(customerName) && StringUtils.hasText(customerFirstName) && StringUtils.hasText(customerSecondName)) {

			customerList = customerService.getCustomerByNameFirstNameSecondName(customerName, customerFirstName, customerSecondName);

		} else {
			throw new Exception("Parámetros de búsqueda erróneos.Debes introducir todos los datos requeridos");
		}

		// Cargar todos los datos al modelo.
		model.addAttribute("customerListView", customerList);
		model.addAttribute("btnDropCustomerEnabled", Boolean.FALSE);

		return "showCustomers";
	}

	/**
	 * Añadir un cliente.
	 * 
	 * @param newCustomer
	 * @param result
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actAddCustomer")
	private String submitAddCustomerForm(@Valid @ModelAttribute EverisCustomer newCustomer, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de registro erróneos. Debes introducir todos los datos requeridos");
		} else {

			// Añadir un cliente.
			customerService.addCustomer(newCustomer);
		}

		return "redirect:showCustomerView";
	}

}
