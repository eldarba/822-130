package app.core;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Student;

public class App7BulkQuery {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();

			// =========================

			String jpql = "from Student";
//			String jpql = "select s from Student s";
			TypedQuery<Student> query = session.createQuery(jpql, Student.class);

			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback(); // if something went wrong
			}
		}

	}

}
