package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Coupon;
import app.core.entities.Review;
import app.core.entities.Student;
import app.core.entities.University;

public class App1 {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Coupon.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).addAnnotatedClass(University.class)
				.buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// =========================

			University u1 = new University("Tel Aviv", "Israel");
			University u2 = new University("MIT", "USA");
			// save universities
			session.persist(u1);
			session.persist(u2);

			Student s1 = new Student(0, "aaa", "aaa@mail");
			s1.setUniversity(u1);
			Student s2 = new Student(0, "bbb", "bbb@mail");
			s2.setUniversity(u1);
			Student s3 = new Student(0, "ccc", "ccc@mail");
			s3.setUniversity(u2);
			Student s4 = new Student(0, "ddd", "ddd@mail");
			s4.setUniversity(u2);

			// save students
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			session.persist(s4);

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
