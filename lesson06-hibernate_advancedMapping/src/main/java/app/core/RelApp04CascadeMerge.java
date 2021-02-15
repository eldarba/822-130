package app.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.core.entities.Company;
import app.core.entities.CompanyAddress;

public class RelApp04CascadeMerge {

	public static void main(String[] args) {

		Transaction tx = null;
		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Company.class).addAnnotatedClass(CompanyAddress.class).buildSessionFactory();) {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// =========================

			// JPA find
			Company companyPersistent = session.find(Company.class, 2); // persistent
			System.out.println(companyPersistent);
			if (companyPersistent != null) {
				Company companyTransient = new Company(); // transient
				companyTransient.setId(companyPersistent.getId());
				companyTransient.setName(companyPersistent.getName() + "--");
				companyTransient.setEmail(companyPersistent.getEmail() + "--");

				CompanyAddress addressPersistent = companyPersistent.getAddress();
				if (addressPersistent != null) {
					CompanyAddress addressTransient = new CompanyAddress();
					addressTransient.setId(addressPersistent.getId());
					addressTransient.setCity(addressPersistent.getCity() + "--");
					addressTransient.setCountry(addressPersistent.getCountry() + "--");

					companyTransient.setAddress(addressTransient);
				}
				// JPA merge
				Object thePersistentEntity = session.merge(companyTransient);
				System.out.println(thePersistentEntity);
				System.out.println(session.contains(thePersistentEntity));
				System.out.println(session.contains(companyTransient));

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
