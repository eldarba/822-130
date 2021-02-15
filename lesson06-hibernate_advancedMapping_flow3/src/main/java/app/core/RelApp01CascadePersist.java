package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Coupon;
import app.core.entities.Review;

public class RelApp01CascadePersist {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Coupon.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// =========================

			Coupon coupon = new Coupon(0, "bbb");
			coupon.addReview(new Review(0, "coment 10"));
			coupon.addReview(new Review(0, "coment 20"));

			session.persist(coupon);

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
