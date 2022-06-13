package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.ResetPasswordDAO;

import com.xworkz.vaccine.exception.InvalidEmailException;

import com.xworkz.vaccine.exception.InvalidPasswordException;

@Component
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ResetPasswordDAO resetPasswordDAO;

	@Autowired
	private MailSender mailSender;

	public ResetPasswordServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean validateResetDetails(String email, String newPassword, String confirmPassword) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked validateResetDetails (message from ResetPassword Service) ");
		boolean valid = false;
		try {

			if (email != null && !email.isEmpty() && email.contains("@") && email.endsWith(".com")) {
				System.out.println(" Valid Email address (message from ResetPassword Service) ");
				valid = true;
			} else {
				throw new InvalidEmailException("Invalid Email");
			}
			if (newPassword != null && !newPassword.isEmpty()) {
				System.out.println(" Valid password (message from ResetPassword Service) ");
				valid = true;

			} else {
				throw new InvalidPasswordException("Invalid New Password");

			}
			if (confirmPassword != null && !confirmPassword.isEmpty()) {
				System.out.println(" Valid password (message from ResetPassword Service) ");
				valid = true;

			} else {
				throw new InvalidPasswordException("Invalid confirm Password");

			}

		} catch (InvalidPasswordException exception) {
			System.out.println(
					"Invalid Reset Data Exception (message from ResetPassword Service) " + exception.getMessage());
		}
		return valid;
		// boolean valid = false;
		// if (email != null && !email.isEmpty() && email.contains("@") &&
		// email.endsWith(".com")) {
		// System.out.println(" Valid Email address (message from ResetPassword Service)
		// ");
		// valid = true;
		//
		// } else {
		// InvalidEmailException invalidEmailException = new InvalidEmailException("
		// Invalid Email ");
		// throw invalidEmailException;
		// }
		// if (newPassword != null && !newPassword.isEmpty()) {
		// System.out.println(" Valid New password (message from ResetPassword Service)
		// ");
		// valid = true;
		//
		// } else {
		// InvalidPasswordException invalidPasswordException = new
		// InvalidPasswordException(" Invalid new password ");
		// throw invalidPasswordException;
		//
		// }
		// if (confirmPassword != null && !confirmPassword.isEmpty()) {
		// System.out.println(" Valid Confirm password (message from ResetPassword
		// Service) ");
		// valid = true;
		//
		// } else {
		// InvalidPasswordException invalidPasswordException = new
		// InvalidPasswordException(
		// " Invalid confirm password ");
		// throw invalidPasswordException;
		//
		// }
		// return valid;
	}

	@Override
	public String encodeConfirmPassword(String confirmPassword) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked encodeConfirmPassword (message from ResetPassword Service)");
		String isPasswordEncoded = null;
		try {
			String isConfirmPasswordEncoded = passwordEncoder.encode(confirmPassword);
			System.out.println("(message from ResetPassword Service) encodePassword confirm password is : "
					+ isConfirmPasswordEncoded);
			return isConfirmPasswordEncoded;

		} catch (Exception exception) {
			System.out.println(
					"Confirm Password not encoded (message from ResetPassword Service) " + exception.getMessage());
		}

		return isPasswordEncoded;
	}

	@Override
	public boolean updateNewPasswordToDataBase(String email, String newPassword) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked updateNewPasswordToDataBase (message from ResetPassword Service)");
		boolean isNewPasswordSaved = false;
		try {
			// String encodeConfirmPassword = this.encodeConfirmPassword(newPassword);
			resetPasswordDAO.updateNewPasswordByEmail(email, newPassword);
			isNewPasswordSaved = true;
			return isNewPasswordSaved;

		} catch (Exception exception) {
			System.out.println("New Password not saved to database (message from ResetPassword Service) "
					+ exception.getMessage());
		}

		return isNewPasswordSaved;
	}

	@Override
	public boolean sendNewPasswordToMail(String email, String newPassword) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked sendNewPasswordToMail (message from ResetPassword Service)");
		boolean sendToMail = false;
		try {
			System.out.println(" Invoked sendOtpToMail (message from ResetPassword Service) ");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("New Password");
			message.setText(newPassword + " Please find the New password for login");
			mailSender.send(message);
			System.out.println(" Mail Sent successfull (message from ResetPassword Service) ");
			sendToMail = true;
			return sendToMail;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return sendToMail;
	}

}
