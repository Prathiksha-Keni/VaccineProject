package com.xworkz.vaccine.service;

public interface OTPService {
	public boolean validateOtp(String otp);

	public boolean verifyOtp(String otp);
}
