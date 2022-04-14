package com.xworkz.vaccine.service;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.OtpDAO;

import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.exception.InvalidOTPException;
import com.xworkz.vaccine.exception.OTPNotVerifiedException;

@Component
public class OTPServiceImpl implements OTPService {

	@Autowired
	private OtpDAO otpDAO;

	@Override
	public boolean validateOtp(String otp) {
		try {
			if (otp != null && !otp.isEmpty() && otp.length() == 4) {
				System.out.println("OTP is valid message from serviceimpl");
				return true;
			} else {
				throw new InvalidOTPException("Invalid OTP message from serviceimpl");
			}
		} catch (InvalidOTPException e) {
			System.out.println("InvalidOTPException" + e);
		}
		return false;
	}

	@Override
	public boolean verifyOtp(String otp) {
		System.out.println("Invoked verifyOtp ");
		String otpFromTable = otpDAO.getOtpFromTable(otp);
		try {
			if (otp.equals(otpFromTable)) {
				System.out.println("OTP is Verified message from serviceimpl");
				return true;
			} else {
				throw new OTPNotVerifiedException("OTP is not Verified message from serviceimpl");
			}
		} catch (OTPNotVerifiedException e) {
			System.out.println("OTPNotVerifiedException" + e);
		}
		return false;
	}
}
