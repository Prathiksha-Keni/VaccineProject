package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.exception.EmailNotFoundException;

@Component
public class OtpDAOImpl implements OtpDAO {

	public OtpDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@Autowired
	private SessionFactory factory;

	@Override
	public VaccineEntity getOtpFromTableByEmail(String email) {
		System.out.println("Invoked getOtpFromTableByEmail from DAO Impl");
		Session session = null;

		try {
			session = factory.openSession();

			Query query = session.getNamedQuery("getOtp");
			query.setParameter("Email", email);
			VaccineEntity result = (VaccineEntity) query.uniqueResult();
			System.out.println("unique result is " + result);
			if (result != null) {
				return (VaccineEntity) result;
			} else {
				throw new EmailNotFoundException("Email Found Exception");
			}

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return null;
	}

}
