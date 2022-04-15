package com.xworkz.vaccine.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.WelcomePageDAO;

import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.exception.EmailNotVerifiedException;
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
		boolean valid = false;
		try {
			if (email != null && !email.isEmpty() && email.contains("@") && email.endsWith(".com")) {
				System.out.println("Valid Email address");
				valid = true;
				return valid;
			} else {
				throw new InvalidEmailException("Invalid Email");
			}
		} catch (InvalidEmailException exception) {
			System.out.println("InvalidEmailException" + exception.getMessage());
		}
		return valid;

	}

	@Override
	public boolean saveOtpToDataBase(String email, String otp) {
		boolean isUserEntitySaved=false;
		try {
			System.out.println("Invoked saveOtpToDataBase");
			VaccineEntity entity = new VaccineEntity();
			entity.setEmailId(email);
			entity.setOtp(otp);
			isUserEntitySaved = welcomePageDAO.saveUserEntity(entity);
			isUserEntitySaved=true;
			return isUserEntitySaved;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return isUserEntitySaved;

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
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return null;
	}

	@Override
	public boolean sendOtpToMail(String email, String otp) {
		System.out.println("Invoked sendOtpToMail");
		boolean sendToMail = false;
		try {
			System.out.println("Invoked sendOtpToMail");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("Vaccine OTP");
			message.setText(otp + " Please find the otp for vaccination");
			mailSender.send(message);
			System.out.println("Mail Sent successfull");
			sendToMail = true;
			return sendToMail;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return sendToMail;
	}

	@Override
	public boolean verifyEmail(String email) {
		boolean verifyEmail = true;
		System.out.println("Invoked verifyEmail");
		String emailFromTable = welcomePageDAO.VerfiyEmail(email);
		try {
			if (email.equals(emailFromTable)) {
				System.out.println("Email Id Already exists Please try with different Email");
				verifyEmail = false;
				return verifyEmail;
			} else {
				throw new EmailNotVerifiedException("Email Id Already exists");
			}
		} catch (EmailNotVerifiedException exception) {
			System.out.println("EmailNotVerifiedException" + exception.getMessage());
		}
		return verifyEmail;
	}

}
