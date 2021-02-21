package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Order;

public interface OrdersRepository extends JpaRepository<Order, Integer> {

	@Query(value = "from order where customer_id=?1")
	List<Order> getOrders(int customerId);

}
