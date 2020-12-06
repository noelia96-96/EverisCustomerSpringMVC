package com.everis.spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author ngalindg
 *
 */
@Controller
@RequestMapping("*")
public class EverisSystemController {

	/**
	 * Capta cualquier solicitud.
	 * 
	 * @return String
	 */
	@GetMapping
	public String showIndex() {
		return "index";
	}

	/**
	 * Redirecciona al controlador de gestión de clientes.
	 * 
	 * @return String
	 */
	@GetMapping("/customerView")
	public String redirectToCustomerController() {
		return "redirect:showCustomerView";
	}

	/**
	 * Redirecciona a la plantilla de búsqueda.
	 * 
	 * @return String
	 */
	@GetMapping("/searchCustomerByView")
	public String redirectToCustomerSearchByTemplate() {
		return "searchCustomerBy";
	}

	/**
	 * Redirecciona a la plantilla de insercción.
	 * 
	 * @return String
	 */
	@GetMapping("/newCustomerView")
	public String redirectToNewCustomerTemplate() {
		return "newCustomer";
	}

}
