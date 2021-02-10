package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Student;

public class App1 {

	public static void main(String[] args) {

		// 1. get a session factory - Driver Manager + connection pool
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// 2. get a session - Connection
		Session session = factory.getCurrentSession();
		// 3. start a transaction - allows a set of operations to be counted as a unit
		Transaction tx = session.beginTransaction();
		// 4. do some data work
		Student student = new Student(101, "aaa", "aaa@mmail");
		session.save(student);
		// commit
		tx.commit(); // set state permanently in the database

	}

}
