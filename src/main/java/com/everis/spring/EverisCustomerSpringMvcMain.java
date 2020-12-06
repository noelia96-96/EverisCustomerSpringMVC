package com.everis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerServiceI;

/**
 * 
 * @author ngalindg
 *
 */
@SpringBootApplication
public class EverisCustomerSpringMvcMain implements CommandLineRunner{
	
	@Autowired
	private EverisCustomerServiceI everisCustomerService;

	/**
	 * MAIN
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(EverisCustomerSpringMvcMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// CREAR E INSERTAR CLIENTES

				// Cliente 1
				EverisCustomer customer1 = new EverisCustomer();
				//customer1.setCustomerId(1);
				customer1.setName("María");
				customer1.setFirstName("Fernández");
				customer1.setSecondName("Rodríguez");
				customer1.setDni("45176256Y");
				everisCustomerService.addCustomer(customer1);

				// Cliente 2
				EverisCustomer customer2 = new EverisCustomer();
				//customer2.setCustomerId(2);
				customer2.setName("Juan");
				customer2.setFirstName("Galiano");
				customer2.setSecondName("Galindo");
				customer2.setDni("65267154G");
				everisCustomerService.addCustomer(customer2);

				// Cliente 3
				EverisCustomer customer3 = new EverisCustomer();
				//customer3.setCustomerId(3);
				customer3.setName("Alba");
				customer3.setFirstName("Soria");
				customer3.setSecondName("Puig");
				customer3.setDni("14629379D");
				everisCustomerService.addCustomer(customer3);

				// Cliente 4
				EverisCustomer customer4 = new EverisCustomer();
				//customer4.setCustomerId(4);
				customer4.setName("Luis");
				customer4.setFirstName("Mora");
				customer4.setSecondName("Díaz");
				customer4.setDni("97392641L");
				everisCustomerService.addCustomer(customer4);

				System.out.println("------------");

				// MOSTRAR TODOS LOS CLIENTES
				everisCustomerService.getAllCustomer();
				
				System.out.println("------------");

				// BUSCAR CLIENTE POR NOMBRE Y APELLIDOS
				everisCustomerService.getCustomerByNameFirstNameSecondName("Luis", "Mora", "Díaz");
				
				System.out.println("------------");

				// BUSCAR CLIENTE POR ID
				everisCustomerService.getCustomerById(4);
				
				System.out.println("------------");

				// ACTUALIZAR
				customer4.setName("Mario");
				everisCustomerService.updCustomer(customer4);
				
				System.out.println("------------");

				// AÑADIR

				// ELIMINAR
				
				
				//everisCustomerService.removeCustomer(customer4.getCustomerId());
		
	}

}
