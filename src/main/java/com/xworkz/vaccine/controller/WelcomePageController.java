package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.WelcomePageService;

@Component
@RequestMapping("/")
public class WelcomePageController {

	@Autowired
	private WelcomePageService welcomePageService;

	public WelcomePageController() {
		System.out.println(this.getClass().getSimpleName() + " Bean  created");
	}

	@RequestMapping("/emailOtp")
	public String onGetOtpClicked(@RequestParam String email, Model model) {
		System.out.println("Invoked onGetOtpClicked");
		boolean isEmailValid = welcomePageService.validateEmail(email);
		if (isEmailValid) {
			System.out.println("Email is Valid " + email);

			String isOtpGenerated = welcomePageService.generateFourDigitOtp();

			System.out.println("Four Digit OTP is Generated " + isOtpGenerated);

			if (isOtpGenerated != null) {
				System.out.println("OTP and Email saved to database");

				boolean isOtpSavedToDb = welcomePageService.saveOtpToDataBase(email, isOtpGenerated);
				if (isOtpSavedToDb) {
					System.out.println("OTP sent to Mail");
					model.addAttribute("message", "OTP sent to Mail");
					boolean isMailSent = welcomePageService.sendOtpToMail(email, isOtpGenerated);
					if (isMailSent) {
						return "/WEB-INF/pages/OtpPage.jsp";
					} else {
						System.out.println("OTP not sent to Mail");
						model.addAttribute("message1", "OTP not sent to Mail");
						return "/WelcomePage.jsp";
					}
				}
			} else {
				System.out.println("OTP and Email is not saved to database");

				return "/WelcomePage.jsp";
			}
		}

		else {
			System.out.println("InValid Email Please Enter a valid Email " + email);
			model.addAttribute("message2", "InValid Email Please Enter a valid Email " + email);

			System.out.println("Four Digit OTP is not Generated ");

			return "/WelcomePage.jsp";
		}
		return "/WelcomePage.jsp";
	}
}
