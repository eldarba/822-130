package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.entities.Review;
import app.core.entities.Student;
import app.core.entities.University;

public class App3 {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Coupon.class)
				.addAnnotatedClass(Customer.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(University.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// =========================

			Coupon c1 = new Coupon(0, "aaa");
			Customer customer1 = new Customer("Dan", "dan@Mail");
			Customer customer2 = new Customer("Rina", "rina@Mail");
			c1.addCustomer(customer1);
			c1.addCustomer(customer2);
			session.persist(c1);

			// =========================

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback(); // if something went wrong
			}
		}

	}

}
