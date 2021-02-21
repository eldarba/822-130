package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Customer;
import app.core.services.StoreService;

@SpringBootApplication
public class Lesson07DataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Lesson07DataJpaApplication.class, args);

		StoreService store = ctx.getBean(StoreService.class);

		{ // add customer with orders
//			Customer c = new Customer("bbb", "Naharia", "HaDekel");
//			c.addOrder(new Order("Milk", LocalDate.now().plusDays(2)));
//			c.addOrder(new Order("Car", LocalDate.now().plusDays(10)));
//			
//			store.addCustomer(c);
		}

		{ // get customer
//			Customer c = store.getCustomer(1);
//			System.out.println(c);
//			System.out.println(store.getOrders(1));

		}

		{ // add order to existing customer
//			Order order = new Order("news papers", LocalDate.now().plusDays(5));
//			store.addOrderToCustomer(1, order);
		}

		{ // update customer
			Customer customer = new Customer("AAA_new", " New City", "new Street");
			customer.setId(1);
			store.updateCustomer(customer);
		}
	}

}
