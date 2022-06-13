package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordDAOImpl implements ResetPasswordDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ResetPasswordDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String updateNewPasswordByEmail(String email, String newPassword) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked updateNewPasswordByEmail (message from ResetPassword DAO Impl) ");
		Session session = null;
		Transaction transaction = null;
		String update = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateNewPasswordByEmail");
			query.setParameter("EmailId", email);
			query.setParameter("newUpdatedPassword", newPassword);
			query.executeUpdate();
			transaction.commit();
			return update;

		} catch (Exception exception) {
			System.out.println("Could not update new Password Exception (message from ResetPassword DAO Impl)"
					+ exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return update;
	}

}
