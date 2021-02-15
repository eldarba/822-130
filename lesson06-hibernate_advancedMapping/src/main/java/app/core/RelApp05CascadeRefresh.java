package app.core;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Company;
import app.core.entities.CompanyAddress;

public class RelApp05CascadeRefresh {

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

			String sql1 = "update company set name='Foo' where id=2";
			String sql2 = "update company_address set city='Bar' where id=2";

			Query query1 = session.createNativeQuery(sql1);
			Query query2 = session.createNativeQuery(sql2);

			query1.executeUpdate();
			query2.executeUpdate();

			System.out.println(company); // not synchronized with db

			// JPA refresh
			session.refresh(company);
			System.out.println(company); // now synchronized with db
			System.out.println(company.getAddress()); // now synchronized with db

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
