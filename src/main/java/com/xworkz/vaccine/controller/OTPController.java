package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.entity.VaccineEntity;
import com.xworkz.vaccine.service.OTPService;


@Component
@RequestMapping("/")
public class OTPController {

	public OTPController() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@Autowired
	private OTPService service;

	@RequestMapping("/otpvalidate")
	public String onVerifyButtonClicked(@RequestParam String otp, Model model) {
		System.out.println("--------------");
		System.out.println("Invoked onVerifyButtonClicked");
		boolean isOtpValid = service.validateOtp(otp);

//		if (isOtpValid) {
//			System.out.println("OTP is valid");
//
//			VaccineEntity entity = new VaccineEntity();
//			String email = entity.getEmailId();
//			System.out.println("email from db" + email);
//
//			boolean isOtpVerified = service.verifyOtp(otp, email);
//
//			if (isOtpVerified) {
//				VaccineEntity entity2 = new VaccineEntity();
//				String otpFromDb = entity2.getOtp();
//				System.out.println("otp from db" + otpFromDb);
//				String emailFromDb = entity.getEmailId();
//
//				if (otp.equals(otpFromDb)) {
//					System.out.println("OTP Verified");
//					return "/WEB-INF/pages/VaccineHomePage.jsp";
//				} else {
//					System.out.println("OTP Not Verified");
//				}
//
//			} else {
//				return "/WEB-INF/pages/OtpPage.jsp";
//			}
//		} else {
//			System.out.println("Invalid OTP Try Again");
//		}

		if (isOtpValid) {
			System.out.println("OTP is valid message from controller");
			VaccineEntity entity = new VaccineEntity();
			String email = entity.getEmailId();
			boolean isOtpVerified = service.verifyOtp(otp, email);
			if (isOtpVerified) {
				System.out.println("OTP Verified message from controller");
				return "/WEB-INF/pages/VaccineHomePage.jsp";
			} else {
				System.out.println("OTP Not Verified message from controller");
			}
			
		} else {
			System.out.println("Invalid OTP Try Again message from controller");
		}
		return "/WEB-INF/pages/OtpPage.jsp";
	}
}