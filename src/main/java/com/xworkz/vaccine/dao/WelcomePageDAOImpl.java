package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.exception.UserEntityNotSavedException;

@Component
public class WelcomePageDAOImpl implements WelcomePageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public WelcomePageDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@Override
	public boolean saveUserEntity(Object entity) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked saveUserEntity (message from Welcome DAO Impl)");
		Session session = null;
		Transaction transaction = null;
		boolean save = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			System.out.println(" User Entity is saved (message from Welcome DAO) ");
			save = true;
			return save;
		} catch (UserEntityNotSavedException exception) {
			System.out.println(" User Entity is not saved (message from Welcome DAO) ");
			session.getTransaction().rollback();
			System.out.println("User Entity Not Saved Exception (message from Welcome DAO)" + exception.getMessage());
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

	@SuppressWarnings("rawtypes")
	@Override
	public String VerfiyEmail(String email) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked VerfiyEmail (message from Welcome DAO Impl) ");
		Session session = null;
		String emailId = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("verifyEmail");
			query.setParameter("Email", email);
			emailId = (String) query.uniqueResult();
			System.out.println("(message from Welcome DAO) unique result is " + emailId);
			return emailId;
		} catch (Exception exception) {
			System.out.println("Email Already Exists Exception (message from Welcome DAO) " + exception.getMessage());
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

	@SuppressWarnings("rawtypes")
	@Override
	public int getMemberCountByEmail(String email) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked getMemberCount (message from Welcome DAO Impl) ");
		Session session = null;
		int memberCount = 0;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getMemberCount");
			query.setParameter("email", email);
			memberCount = (int) query.uniqueResult();
			System.out.println(" Memebr count is  (message from Welcome DAO) : " + memberCount);
			return memberCount;
		} catch (Exception exception) {
			System.out.println("Could not get member count Exception " + exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return memberCount;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int updateMemberCount(String email, int count) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked updateMemberCount (message from Welcome DAO Impl)");
		Session session = null;
		Transaction transaction = null;
		int update = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateMemberCount");
			query.setParameter("EmailId", email);
			query.setParameter("Count", count);
			update = query.executeUpdate();
			transaction.commit();
			return update;
		} catch (Exception exception) {
			System.out.println(" count not increment member count (message from Welcome DAO) ");
			session.getTransaction().rollback();
			System.out.println(
					"Memeber count not incremented Exception (message from Welcome DAO) " + exception.getMessage());
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
