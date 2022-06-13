package com.xworkz.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.AddMemberService;
import com.xworkz.vaccine.service.OTPService;

@Component
@RequestMapping("/")
public class OTPController {

	@Autowired
	private OTPService service;

	@Autowired
	private AddMemberService addMemeberService;

	public OTPController() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");
	}

	@RequestMapping("/otpvalidate")
	public String onVerifyButtonClicked(@RequestParam String otp, Model model) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked onVerifyButtonClicked (from OTP Controller)");
		boolean isOtpValid = service.validateOtp(otp);
		if (isOtpValid) {
			System.out.println(" OTP is valid (message from OTP controller) ");
			model.addAttribute("validOtp", "OTP not Verified. Please Enter Again");
			boolean isOtpVerified = service.verifyOtp(otp);
			if (isOtpVerified) {
				System.out.println(" OTP Verified (message from OTP controller) ");
				model.addAttribute("verifyOTP", "OTP Verified");

				List<Object> readAllMembersData = addMemeberService.readAllMembersData();
				model.addAttribute("ListOfAllMembers", readAllMembersData);
				return "/WEB-INF/pages/VaccineHomePage.jsp";
			} else {
				System.out.println(" OTP Not Verified (message from OTP controller) ");
			}
		} else {
			System.out.println(" Invalid OTP Try Again (message from OTP controller) ");
			model.addAttribute("invalidOTP", " Invalid OTP Try Again ");
		}
		return "/WEB-INF/pages/OtpPage.jsp";
	}
}