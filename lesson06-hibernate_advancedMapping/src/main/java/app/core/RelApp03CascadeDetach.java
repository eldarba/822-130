package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Company;
import app.core.entities.CompanyAddress;

public class RelApp03CascadeDetach {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Company.class).addAnnotatedClass(CompanyAddress.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// =========================

			// JPA find
			Company company = session.find(Company.class, 2); // persistent
			System.out.println(company);
			if (company != null) {
				System.out.println("company persistent? " + session.contains(company));
				if (company.getAddress() != null) {
					System.out.println("address persistent? " + session.contains(company.getAddress()));
				}
				session.detach(company);
				System.out.println("company persistent? " + session.contains(company));
				if (company.getAddress() != null) {
					System.out.println("address persistent? " + session.contains(company.getAddress()));
				}
			}

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
