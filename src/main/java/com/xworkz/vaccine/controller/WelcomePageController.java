package com.xworkz.vaccine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.WelcomePageService;

@SuppressWarnings("serial")
@Component
@RequestMapping("/")
public class WelcomePageController extends HttpServlet {

	public static String email;

	@Autowired
	private WelcomePageService welcomePageService;
	Logger logger = Logger.getLogger(WelcomePageController.class);

	public WelcomePageController() {
		System.out.println(this.getClass().getSimpleName() + " Bean  created");
	//	logger.debug(this.getClass().getSimpleName() + " Bean  created");
		logger.info(this.getClass().getSimpleName() + " Bean  created");
		//logger.error(this.getClass().getSimpleName() + " Bean  created");
		//logger.fatal(this.getClass().getSimpleName() + " Bean  created");

	}

	@RequestMapping("/onclickregister")
	public String onClickRegisterUser() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked onClickRegisterUser (message from Welcome controller) ");
		return "/WEB-INF/pages/RegisterPage.jsp";
	}

	@RequestMapping("/Welcomelogin")
	public String onClickLogin() {
		System.out.println("Invoked onClickLogin (message from Welcome controller) ");
		return "/WEB-INF/pages/LoginPage.jsp";
	}

	@RequestMapping("/emailOtp")
	public String onGetOtpClicked(@RequestParam String email, Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------");
		System.out.println(" Invoked onGetOtpClicked (message from Welcome controller) ");

		HttpSession session = request.getSession();
		session.setAttribute("emailId", email);

		WelcomePageController.email = email;

		boolean isEmailValid = welcomePageService.validateEmail(email);

		if (isEmailValid) {
			System.out.println(" Email is Valid (message from Welcome controller) :- " + email);
			boolean isEmailVerified = welcomePageService.verifyEmail(email);
			if (isEmailVerified) {
				System.out.println(" Email is verified (message from Welcome controller) ");
				String isOtpGenerated = welcomePageService.generateFourDigitOtp();
				System.out
				.println(" Four Digit OTP is Generated (message from Welcome controller) :- " + isOtpGenerated);
				if (isOtpGenerated != null) {
					System.out.println(" OTP and Email saved to database (message from Welcome controller) ");
					boolean isOtpSavedToDb = welcomePageService.saveOtpToDataBase(email, isOtpGenerated);

					if (isOtpSavedToDb) {
						System.out.println(" OTP sent to Mail (message from Welcome controller) ");
						model.addAttribute("message", "OTP sent to Mail");
						boolean isMailSent = welcomePageService.sendOtpToMail(email, isOtpGenerated);
						if (isMailSent) {
							return "/WEB-INF/pages/OtpPage.jsp";
						}
					} else {
						System.out.println(" OTP not sent to Mail (message from Welcome controller) ");
						model.addAttribute("message1", "OTP not sent to Mail");
						return "/WelcomePage.jsp";
					}
				} else {
					System.out.println(" OTP and Email is not saved to database (message from Welcome controller) ");

					return "/WelcomePage.jsp";
				}

			} else {
				System.out.println(" Email is not verified (message from Welcome controller) ");
				model.addAttribute("VerifyEmail", "Email already exists please enter a different email");
				System.out.println(" Four Digit OTP is not Generated (message from Welcome controller) ");
				return "/WelcomePage.jsp";
			}

		} else {
			System.out
			.println(" InValid Email Please Enter a valid Email (message from Welcome controller) :- " + email);
			model.addAttribute("message2", "InValid Email Please Enter a valid Email " + email);
			return "/WelcomePage.jsp";
		}
		return "/WelcomePage.jsp";

	}
}
