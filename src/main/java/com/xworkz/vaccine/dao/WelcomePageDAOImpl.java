package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.exception.EmailAlreadyExistsException;
import com.xworkz.vaccine.exception.OTPNotFoundException;
import com.xworkz.vaccine.exception.UserEntityNotSavedException;

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
		boolean save=false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			System.out.println("User Entity is saved");
			save=true;
			return save;
		} catch (UserEntityNotSavedException exception) {
			System.out.println("User Entity is not saved");
			session.getTransaction().rollback();
			System.out.println("UserEntityNotSavedException"+exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return save;
	}

	@Override
	public String VerfiyEmail(String email) {
		System.out.println("Invoked VerfiyEmail from DAO Impl");
		Session session = null;
		String emailId = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("verifyEmail");
			query.setParameter("Email", email);
			emailId = (String) query.uniqueResult();
			System.out.println("unique result is " + emailId);
			if (emailId != null) {
				return emailId;
			} else {
				throw new EmailAlreadyExistsException("Email already exists exception");
			}
		} catch (EmailAlreadyExistsException exception) {
			System.out.println("EmailAlreadyExistsException "+exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return emailId;
	}

}
