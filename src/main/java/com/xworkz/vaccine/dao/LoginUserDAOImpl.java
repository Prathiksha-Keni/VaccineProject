package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUserDAOImpl implements LoginUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public LoginUserDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getUserName(String userName) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked getUserName (message from Login DAO Impl) ");
		Session session = null;
		String UserName = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getUserName");
			query.setParameter("name", userName);
			UserName = (String) query.uniqueResult();
			System.out.println("unique result is of username (message from Login DAO Impl) " + UserName);
			if (UserName != null) {
				return UserName;
			} else {
				throw new Exception("Username not found");
			}

		} catch (Exception exception) {
			System.out.println("User Name does not exist (message from Login DAO Impl)" + exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return UserName;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getPasswordByUsername(String username) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked getPasswordByUsername (message from Login DAO Impl) ");
		Session session = null;
		String Pass = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getPasswordByUsername");
			query.setParameter("UserName", username);
			Pass = (String) query.uniqueResult();
			System.out.println("unique result is of password " + Pass);
			if (Pass != null) {
				return Pass;
			} else {
				throw new Exception("Password not found");
			}

		} catch (Exception exception) {
			System.out.println("Password does not exist (message from Login DAO Impl) " + exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return Pass;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int getLoginCountByUsername(String username) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked getLoginCountByPassword (message from Login DAO Impl) ");
		Session session = null;
		int loginCount = 0;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getLoginCountByUsername");
			query.setParameter("UserName", username);
			loginCount = (int) query.uniqueResult();
			System.out.println(" Login count is  (message from Login DAO) : " + loginCount);
			return loginCount;
		} catch (Exception exception) {
			System.out.println(
					"Could not get login count Exception (message from Login DAO Impl) " + exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return loginCount;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int updateLoginCount(String username, int count) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked updateLoginCount (message from Login DAO Impl)");
		Session session = null;
		Transaction transaction = null;
		int update = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateLoginCount");
			query.setParameter("User", username);
			query.setParameter("Count", count);
			update = query.executeUpdate();
			transaction.commit();
			return update;
		} catch (Exception exception) {
			System.out.println(" count not increment Login Count (message from Login DAO) ");
			session.getTransaction().rollback();
			System.out.println("Exception " + exception.getMessage());
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
