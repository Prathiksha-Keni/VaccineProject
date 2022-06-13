package com.xworkz.vaccine.service;

public interface LoginUserService {

	public boolean validateUserCredentails(String username, String password);

	boolean verifyUserNameAndPassword(String username, String password);
}
