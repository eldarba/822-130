package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Student;

public class App2 {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Student student1 = new Student(0, "bbb", "bbb@mmail");
			Student student2 = new Student(0, "ccc", "ccc@mmail");
			Student student3 = new Student(0, "ddd", "ddd@mmail");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback(); // if something went wrong
			}
		}

	}

}
