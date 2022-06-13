package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.LoginUserDAO;

import com.xworkz.vaccine.exception.InvalidNameException;
import com.xworkz.vaccine.exception.InvalidPasswordException;

@Component
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserDAO loginUserDAO;

	@Autowired
	private PasswordEncoder passwordDecoder;

	public static int blockedCount;

	public static int matchedCount;
	
	public LoginUserServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean validateUserCredentails(String username, String password) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked validateUserCredentails (message from LoginUser Service) ");
		boolean valid = false;
		try {
			if (username != null && !username.isEmpty()) {
				System.out.println(" Valid UserName (message from LoginUser Service) ");
				valid = true;
			} else {
				throw new InvalidNameException("Invalid Username");
			}
			if (password != null && !password.isEmpty()) {
				System.out.println(" Valid password (message from LoginUser Service) ");
				valid = true;
			} else {
				throw new InvalidPasswordException("Invalid Password");
			}
		} catch (InvalidPasswordException exception) {
			System.out.println("Invalid Credentails Exception " + exception.getMessage());
		}
		return valid;

		// boolean valid = false;
		// if (username != null && !username.isEmpty()) {
		// System.out.println(" Valid UserName (message from LoginUser Service) ");
		// valid = true;
		//
		// } else {
		// InvalidNameException invalidNameException = new InvalidNameException("
		// Invalid UserName ");
		// throw invalidNameException;
		//
		// }
		// if (password != null && !password.isEmpty()) {
		// System.out.println(" Valid password (message from LoginUser Service) ");
		// valid = true;
		//
		// } else {
		// InvalidPasswordException invalidPasswordException = new
		// InvalidPasswordException(" Invalid password ");
		// throw invalidPasswordException;
		//
		// }
		// return valid;
	}

	@Override
	public boolean verifyUserNameAndPassword(String username, String password) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked verifyUserNameAndPassword (message from LoginUser Service)");
		boolean verifyDetails = false;
		try {
			String userNameFromTable = loginUserDAO.getUserName(username);
			System.out.println("USERNAME FROM LoginUser SERVICE is : " + userNameFromTable);

			String passwordFromTable = loginUserDAO.getPasswordByUsername(username);
			System.out.println("PASSWORD FROM LoginUser SERVICE is : " + passwordFromTable);

			boolean matches = passwordDecoder.matches(password, passwordFromTable);
			System.out.println("Decoded is from loginuser service: " + matches);

			if (username.equals(userNameFromTable) && matches == true) {
				System.out.println(" UserName and Password matched (message from LoginUser Service) ");
				int loginCount = loginUserDAO.getLoginCountByUsername(username);
				LoginUserServiceImpl.matchedCount = loginCount;
				System.out.println("UPDATED LOGIN COUNT TO SEND TO CONTROLLER IS if credential matches : ");
				System.out.println(LoginUserServiceImpl.matchedCount = loginCount);
				verifyDetails = true;
				return verifyDetails;

			} else {
				int loginCount = loginUserDAO.getLoginCountByUsername(username);
				LoginUserServiceImpl.blockedCount = loginCount;
				System.out.println("UPDATED LOGIN COUNT TO SEND TO CONTROLLER IS : ");
				System.out.println(LoginUserServiceImpl.blockedCount = loginCount);

				System.out.println("Login count from db ie from DAO is  : " + loginCount);
				if (loginCount >= 3) {
					System.out.println("Account Has Been Blocked (message from LoginUser Service)");
					return verifyDetails;
				} else {
					loginCount++;
					loginUserDAO.updateLoginCount(username, loginCount);

				}

			}

		} catch (Exception exception) {
			System.out.println(
					"UserName and Password is not matched (message from LoginUser Service) " + exception.getMessage());
		}
		return verifyDetails;
	}

}
