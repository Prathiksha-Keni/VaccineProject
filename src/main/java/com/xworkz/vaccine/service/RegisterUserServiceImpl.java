package com.xworkz.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccine.controller.RegisterController;
import com.xworkz.vaccine.dao.RegisterUserDAO;
import com.xworkz.vaccine.dto.RegisterUserDTO;

import com.xworkz.vaccine.entity.RegisterUserEntity;
import com.xworkz.vaccine.exception.InvalidContactNumberException;

import com.xworkz.vaccine.exception.InvalidEmailException;
import com.xworkz.vaccine.exception.InvalidGenderException;

import com.xworkz.vaccine.exception.InvalidNameException;
import com.xworkz.vaccine.exception.InvalidPasswordException;

import com.xworkz.vaccine.exception.InvalidYearOfBirthException;

@Component
public class RegisterUserServiceImpl implements RegisterUserService {

	public static String encryptedPassword;

	@Autowired
	private RegisterUserDAO registerUserDAO;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public RegisterUserServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean validateRegisterUser(RegisterUserDTO dto)
			throws InvalidNameException, InvalidEmailException, InvalidPasswordException, InvalidGenderException,
			InvalidYearOfBirthException, InvalidContactNumberException {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked validateRegisterUserDto (message from RegisterUser Service)");

		ModelAndView model = new ModelAndView();

		boolean valid = false;
		// boolean valid = true;
		try {
			if (dto.getUsername() != null && !dto.getUsername().isEmpty()) {
				System.out.println(" Valid UserName (message from RegisterUser Service) ");
				valid = true;
				// return valid;

			} else {
				// System.out.println(" Invalid UserName (message from RegisterUser Service) ");
				// valid = false;
				model.addObject("InvalidName", "Username can not be empty");
				InvalidNameException invalidNameException = new InvalidNameException("Invalid UserName");
				throw invalidNameException;
			}
			if (dto.getEmail() != null && !dto.getEmail().isEmpty() && dto.getEmail().contains("@")
					&& dto.getEmail().endsWith(".com")) {
				System.out.println(" Valid Email address (message from RegisterUser Service) ");
				valid = true;
				// return valid;

			} else {
				// System.out.println(" Invalid Email (message from RegisterUser Service) ");
				// valid = false;
				model.addObject("InvalidEmail", "Please Enter the email in proper format");
				InvalidEmailException invalidEmailException = new InvalidEmailException("Invalid Email");
				throw invalidEmailException;
			}
			if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
				System.out.println(" Valid password (message from RegisterUser Service) ");
				valid = true;
				// return valid;

			} else {
				// System.out.println(" Invalid Password (message from RegisterUser Service) ");
				// valid = false;
				model.addObject("InvalidPassword", "Password can not be empty");
				InvalidPasswordException invalidPasswordException = new InvalidPasswordException("Invalid Password");
				throw invalidPasswordException;

			}
			if (dto.getGender() != null && !dto.getGender().isEmpty()) {
				System.out.println(" Valid Gender (message from RegisterUser Service) ");
				valid = true;
				// return valid;

			} else {
				// System.out.println(" Invalid Gender (message from RegisterUser Service) ");
				// valid = false;
				model.addObject("InvalidGender", "Please select gender");
				InvalidGenderException invalidGenderException = new InvalidGenderException("Invalid Gender");
				throw invalidGenderException;
			}
			if (dto.getYearOfBirth() != null && !dto.getYearOfBirth().isEmpty() && dto.getYearOfBirth().length() == 4) {
				System.out.println(" Valid YOB (message from RegisterUser Service) ");
				valid = true;
				// return valid;

			} else {
				// System.out.println(" Invalid YOB (message from RegisterUser Service) ");
				// valid = false;
				model.addObject("InvalidYOB", "Please enter 4 digit Year Of Birth (eg.1997)");
				InvalidYearOfBirthException invalidYearOfBirthException = new InvalidYearOfBirthException(
						"Invalid YOB");
				throw invalidYearOfBirthException;
			}
			if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().isEmpty()
					&& dto.getPhoneNumber().length() == 10) {
				System.out.println(" Valid Phone Number (message from RegisterUser Service) ");
				valid = true;
				// return valid;

			} else {
				// System.out.println(" Invalid Phone Number (message from RegisterUser Service)
				// ");
				// valid = false;
				model.addObject("InvalidPhoneNumber", "Please enter 10 digit Phone Number");
				InvalidContactNumberException invalidContactNumberException = new InvalidContactNumberException(
						"Invalid Phone Number");
				throw invalidContactNumberException;
			}

		} catch (InvalidNameException | InvalidEmailException | InvalidPasswordException | InvalidGenderException
				| InvalidYearOfBirthException | InvalidContactNumberException exception) {
			System.out.println("Invalid Register Data Exception " + exception.getMessage());
		}
		// valid = false;
		return valid;

		// boolean valid = false;
		// if (dto.getUsername() != null && !dto.getUsername().isEmpty()) {
		// System.out.println(" Valid UserName (message from RegisterUser Service) ");
		// valid = true;
		//
		// } else {
		// InvalidNameException invalidNameException = new InvalidNameException("
		// Invalid UserName ");
		// throw invalidNameException;
		//
		// }
		// if (dto.getEmail() != null && !dto.getEmail().isEmpty() &&
		// dto.getEmail().contains("@")
		// && dto.getEmail().endsWith(".com")) {
		// System.out.println(" Valid Email address (message from RegisterUser Service)
		// ");
		// valid = true;
		//
		// } else {
		// InvalidEmailException invalidEmailException = new InvalidEmailException("
		// Invalid Email ");
		// throw invalidEmailException;
		// }
		// if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
		// System.out.println(" Valid password (message from RegisterUser Service) ");
		// valid = true;
		//
		// } else {
		// InvalidPasswordException invalidPasswordException = new
		// InvalidPasswordException(" Invalid password ");
		// throw invalidPasswordException;
		//
		// }
		// if (dto.getGender() != null && !dto.getGender().isEmpty()) {
		// System.out.println(" Valid Gender (message from RegisterUser Service) ");
		// valid = true;
		//
		// } else {
		// InvalidGenderException invalidGenderException = new InvalidGenderException("
		// Invalid Gender ");
		// throw invalidGenderException;
		// }
		// if (dto.getYearOfBirth() != null && !dto.getYearOfBirth().isEmpty() &&
		// dto.getYearOfBirth().length() == 4) {
		// System.out.println(" Valid YOB (message from RegisterUser Service) ");
		// valid = true;
		//
		// } else {
		// InvalidYearOfBirthException invalidYearOfBirthException = new
		// InvalidYearOfBirthException(
		// " Invalid Year Of Birth ");
		// throw invalidYearOfBirthException;
		// }
		// if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().isEmpty() &&
		// dto.getPhoneNumber().length() == 10) {
		// System.out.println(" Valid Phone Number (message from RegisterUser Service)
		// ");
		// valid = true;
		//
		// } else {
		// InvalidContactNumberException invalidContactNumberException = new
		// InvalidContactNumberException(
		// " Invalid contact number");
		// throw invalidContactNumberException;
		// }
		//
		// return valid;
	}

	@Override
	public boolean sendPasswordToMail(String email, String password, String username) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked sendPasswordToMail (message from RegisterUser Service)");
		boolean sendToMail = false;
		try {
			System.out.println(" Invoked sendOtpToMail (message from RegisterUser Service) ");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("User Password");
			message.setText(username + "  Please find the username for login \n" + password
					+ " Please find the password for login");
			// message.setText(password + " Please find the password for login");

			mailSender.send(message);
			System.out.println(" Mail Sent successfull (message from RegisterUser Service) ");
			sendToMail = true;
			return sendToMail;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return sendToMail;
	}

	@Override
	public boolean saveRegisterUser(RegisterUserDTO dto) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked saveRegisterUser (message from RegisterUser Service)");
		boolean isUserSaved = false;
		try {

			RegisterUserEntity entity = new RegisterUserEntity();

			String encodedPassword = passwordEncoder.encode(RegisterController.pws);
			System.out.println("encodePassword is : " + encodedPassword);

			// boolean decodePassword = passwordEncoder.matches(RegisterController.pws,
			// encodedPassword);
			// System.out.println("decoded Password is : "+decodePassword);
			// // Hash a password
			// String encodedPassword = BCrypt.hashpw(RegisterController.pws,
			// BCrypt.gensalt());
			// System.out.println("encodePassword is : " + encodedPassword);
			// // Check that an unencrypted password matches or not
			// if (BCrypt.checkpw(RegisterController.pws, encodedPassword))
			// System.out.println("It matches");
			// else
			// System.out.println("It does not match");

			BeanUtils.copyProperties(dto, entity);
			entity.setPassword(encodedPassword);
			entity.setLoginCount(0);
			System.out.println(entity);
			isUserSaved = registerUserDAO.saveUser(entity);
			isUserSaved = true;
			return isUserSaved;

		} catch (Exception exception) {
			System.out
					.println("New User Entity not saved (message from RegisterUser Service) " + exception.getMessage());
		}

		return isUserSaved;
	}

}
