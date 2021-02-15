package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Company;
import app.core.entities.CompanyAddress;

public class RelApp06OneToOneBiDir {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Company.class).addAnnotatedClass(CompanyAddress.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// =========================

			CompanyAddress address = session.find(CompanyAddress.class, 1);
			System.out.println(address);
			System.out.println(address.getCompany());

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
