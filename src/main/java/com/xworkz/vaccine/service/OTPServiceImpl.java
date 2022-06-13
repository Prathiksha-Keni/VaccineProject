package com.xworkz.vaccine.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.OtpDAO;


import com.xworkz.vaccine.exception.InvalidOTPException;
import com.xworkz.vaccine.exception.OTPNotVerifiedException;

@Component
public class OTPServiceImpl implements OTPService {

	@Autowired
	private OtpDAO otpDAO;
	
	public OTPServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean validateOtp(String otp) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked validateOtp (message from OTP Service)");
		boolean valid = false;
		try {
			if (otp != null && !otp.isEmpty() && otp.length() == 4) {
				System.out.println(" OTP is valid (message from OTP Service) ");
				valid = true;
				return valid;
			} else {
				throw new InvalidOTPException(" Invalid OTP (message from OTP Service) ");
			}
		} catch (InvalidOTPException exception) {
			System.out.println(" Invalid OTP Exception (message from OTP Service)" + exception.getMessage());
		}
		return valid;
	}

	@Override
	public boolean verifyOtp(String otp) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked verifyOtp (message from OTP Service)");
		boolean verify = false;
		System.out.println(" Invoked verifyOtp (message from OTP Service)");
		String otpFromTable = otpDAO.getOtpFromTable(otp);
		try {
			if (otp.equals(otpFromTable)) {
				System.out.println(" OTP is Verified (message from OTP Service) ");
				verify = true;
				return verify;
			} else {
				throw new OTPNotVerifiedException(" OTP is not Verified (message from OTP Service) ");
			}
		} catch (OTPNotVerifiedException exception) {
			System.out.println(" OTP Not Verified Exception (message from OTP Service) " + exception.getMessage());
		}
		return verify;
	}
}
