package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		if (isOtpValid) {
			System.out.println("OTP is valid message from controller");
			model.addAttribute("validOtp", "OTP not Verified. Please Enter Again");
			boolean isOtpVerified = service.verifyOtp(otp);
			if (isOtpVerified) {
				System.out.println("OTP Verified message from controller");
				model.addAttribute("verifyOTP", "OTP Verified");
				return "/WEB-INF/pages/VaccineHomePage.jsp";
			} else {
				System.out.println("OTP Not Verified message from controller");
			}
		} else {
			System.out.println("Invalid OTP Try Again message from controller");
			model.addAttribute("invalidOTP", " Invalid OTP Try Again ");
		}
		return "/WEB-INF/pages/OtpPage.jsp";
	}
}