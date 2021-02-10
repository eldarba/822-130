package app.core;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Student;

public class App6TypedQuery {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();

			// =========================

			String jpql = "select s from Student s where s.id=:id";
			TypedQuery<Student> query = session.createQuery(jpql, Student.class);
			query.setParameter("id", 1);

			Student student = query.getSingleResult();
			System.out.println(student);
			System.out.println(student.getEmail());

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback(); // if something went wrong
			}
		}

	}

}
