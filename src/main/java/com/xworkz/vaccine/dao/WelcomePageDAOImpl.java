package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomePageDAOImpl implements WelcomePageDAO {

	public WelcomePageDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveUserEntity(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			System.out.println("User Entity is saved");
			return true;
		} catch (Exception e) {
			System.out.println("User Entity is not saved");
			session.getTransaction().rollback();
			System.out.println(e);
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return false;
	}

}
