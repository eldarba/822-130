package app.core;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Student;

public class App5Query {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();

			// =========================

			String jpql = "select s from Student s where s.id=:id";
			String sql = "select * from student s where id=?";
			Query query = session.createQuery(jpql);
			query.setParameter("id", 1);

			Object obj = query.getSingleResult();
			System.out.println(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback(); // if something went wrong
			}
		}

	}

}
