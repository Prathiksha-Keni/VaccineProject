package com.xworkz.vaccine.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.WelcomePageDAO;

import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.exception.InvalidEmailException;

@Component
public class WelcomePageServiceImpl implements WelcomePageService {

	@Autowired
	private WelcomePageDAO welcomePageDAO;

	@Autowired
	private MailSender mailSender;

	@Override
	public boolean validateEmail(String email) {
		System.out.println("Invoked validateEmail");
		try {
			if (email != null && !email.isEmpty() && email.contains("@") && email.endsWith(".com")) {
				System.out.println("Valid Email address");
				return true;
			} else {
				throw new InvalidEmailException("Invalid Email");
			}
		} catch (InvalidEmailException e) {
			System.out.println("InvalidEmailException" + e);
		}
		return false;

	}

	@Override
	public boolean saveOtpToDataBase(String email, String otp) {
		try {
			System.out.println("Invoked saveOtpToDataBase");
			VaccineEntity entity = new VaccineEntity();
			entity.setEmailId(email);
			entity.setOtp(otp);
			boolean isUserEntitySaved = welcomePageDAO.saveUserEntity(entity);
			return isUserEntitySaved;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	@Override
	public String generateFourDigitOtp() {
		System.out.println("Invoked generateFourDigitOtp ");
		try {
			// It will generate 4 digit random Number.
			// from 0 to 9999
			Random rnd = new Random();
			int number = rnd.nextInt(9999);
			// this will convert any number sequence into 4 character.
			return String.format("%04d", number);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean sendOtpToMail(String email, String otp) {
		System.out.println("Invoked sendOtpToMail");
		try {
			System.out.println("Invoked sendOtpToMail");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("Vaccine OTP");
			message.setText(otp + " Please find the otp for vaccination");
			mailSender.send(message);
			System.out.println("Mail Sent successfull");
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
