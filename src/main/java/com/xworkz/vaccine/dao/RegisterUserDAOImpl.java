package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.exception.MemberEntityNotSavedException;

@Component
public class RegisterUserDAOImpl implements RegisterUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public RegisterUserDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean saveUser(Object entity) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked saveUser (message from Register DAO Impl) ");
		Session session = null;
		Transaction transaction = null;
		boolean saveUser = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			System.out.println(" User is saved (message from RegisterUser DAO) ");
			saveUser = true;
			return saveUser;
		} catch (MemberEntityNotSavedException exception) {
			System.out.println(" User is not saved (message from RegisterUser DAO) ");
			session.getTransaction().rollback();
			System.out.println("Register User Entity Not Saved Exception (message from Register DAO Impl)"
					+ exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return saveUser;
	}

}
