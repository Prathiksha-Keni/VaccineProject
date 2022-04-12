package com.xworkz.vaccine.service;



public interface WelcomePageService {

	public boolean validateEmail(String email);

	 boolean saveOtpToDataBase(String email, String otp);

	public String generateFourDigitOtp();
	
	boolean sendOtpToMail(String email,String otp);

}
