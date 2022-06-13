package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.exception.OTPNotFoundException;

@Component
public class OtpDAOImpl implements OtpDAO {

	@Autowired
	private SessionFactory factory;

	public OtpDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getOtpFromTable(String otp) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked getOtpFromTable (message from OTP DAO Impl) ");
		Session session = null;
		String Otp = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("getOtp");
			query.setParameter("Otp", otp);
			Otp = (String) query.uniqueResult();
			System.out.println("(message from OTP DAO Impl) unique result is :- " + Otp);
			if (Otp != null) {
				return Otp;
			} else {
				throw new OTPNotFoundException(" OTP Not Found Exception (message from OTP DAO Impl)");
			}
		} catch (OTPNotFoundException exception) {
			System.out.println("OTP Not Found Exception (message from OTP DAO Impl) " + exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return Otp;
	}

}
