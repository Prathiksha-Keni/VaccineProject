package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.ResetPasswordService;

@Component
@RequestMapping("/")
public class ResetPasswordController {

	@Autowired
	private ResetPasswordService service;

	public ResetPasswordController() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}
	// validate
	// encode new password
	// update the existing password by emailId ---- > service & DAO
	// reset/update the login count from 3 to 0
	// send new password to email_id after updating new password

	@RequestMapping("/resetPassword")
	public String onResetPasswordClick(@RequestParam String email, @RequestParam String newPassword,
			@RequestParam String confirmPassword, Model model) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked onResetPasswordClick (from Reset Controller)");

		boolean isResetDetailsValid = service.validateResetDetails(email, newPassword, confirmPassword);
		if (isResetDetailsValid) {
			System.out.println("Reset Details is Valid (from Reset Controller)");
			if (newPassword.equals(confirmPassword)) {
				System.out.println("New password and Confirm Password matches (from Reset Controller)");
				String isConfirmPasswordEncoded = service.encodeConfirmPassword(confirmPassword);
				if (isConfirmPasswordEncoded != null) {
					System.out.println("Confirm password enocoded  (from Reset Controller)");
					boolean isNewPasswordToDataBaseUpdated = service.updateNewPasswordToDataBase(email,
							isConfirmPasswordEncoded);
					if (isNewPasswordToDataBaseUpdated) {
						System.out.println("Updated new password to database (from Reset Controller)");
						boolean isNewPasswordToMailSent = service.sendNewPasswordToMail(email, confirmPassword);
						if (isNewPasswordToMailSent) {
							System.out.println("New password sent to user email (from Reset Controller)");
							model.addAttribute("newPassMail", "New password sent to user email");
							model.addAttribute("passwordResetDone", "Reset Password successfull");
							return "/WEB-INF/pages/LoginPage.jsp";
						} else {
							System.out.println("New password sent to user email (from Reset Controller)");
						}
					} else {
						System.out.println(" not Updated new password to database (from Reset Controller)");
					}
				} else {
					System.out.println("Confirm password is not enocoded  (from Reset Controller)");
				}
			} else {
				System.out.println("New password and Confirm Password not matches (from Reset Controller)");
				model.addAttribute("newPassAndConfirmNotMatch", "New password and Confirm Password not matches");
			}
		} else {
			System.out.println("Reset Details is not Valid (from Reset Controller)");
			model.addAttribute("ResetdetailsNotValid", "Details not valid");
		}
		return "/WEB-INF/pages/ResetPasswordPage.jsp";

	}
}
