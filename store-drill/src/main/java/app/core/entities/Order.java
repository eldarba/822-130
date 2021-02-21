package app.core.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "order")
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private LocalDate suplyDate;

	public Order() {
	}

	public Order(String description, LocalDate suplyDate) {
		super();
		this.description = description;
		this.suplyDate = suplyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getSuplyDate() {
		return suplyDate;
	}

	public void setSuplyDate(LocalDate suplyDate) {
		this.suplyDate = suplyDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", suplyDate=" + suplyDate + "]";
	}

}
