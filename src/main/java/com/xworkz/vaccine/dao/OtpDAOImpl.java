package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.exception.OTPNotFoundException;

@Component
public class OtpDAOImpl implements OtpDAO {

	public OtpDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@Autowired
	private SessionFactory factory;

	@Override
	public String getOtpFromTable(String otp) {
		System.out.println("Invoked getOtpFromTable from DAO Impl");
		Session session = null;
		String Otp = null;
		try {
			session = factory.openSession();

			Query query = session.getNamedQuery("getOtp");
			query.setParameter("Otp", otp);
			Otp = (String) query.uniqueResult();
			System.out.println("unique result is " + Otp);
			if (Otp != null) {
				return Otp;
			} else {
				throw new OTPNotFoundException("OTP Not Found Exception");
			}
		} catch (OTPNotFoundException e) {
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
