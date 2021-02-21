package app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Customer;
import app.core.entities.Order;
import app.core.repositories.CustomerRepository;
import app.core.repositories.OrdersRepository;

@Service
@Transactional
public class StoreService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrdersRepository ordersRepository;
//	@Autowired
//	private EntityManager em;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomer(int customerId) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}
		return null;
	}

	public List<Order> getOrders(int customerId) {
		return ordersRepository.getOrders(customerId);
	}

	public void addOrderToCustomer(int customerId, Order order) {
		Customer c = getCustomer(customerId);
		if (c != null) {
			c.addOrder(order); // will be updated in the database
		}
	}

	public Customer updateCustomer(Customer customer) {
		Customer dbCustomer = getCustomer(customer.getId());
		if (dbCustomer != null) {
			dbCustomer.setName(customer.getName()); // will be updated in the database
		}
		return dbCustomer;
	}

}
