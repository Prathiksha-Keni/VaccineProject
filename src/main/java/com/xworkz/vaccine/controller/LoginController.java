package com.xworkz.vaccine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.AddMemberService;
import com.xworkz.vaccine.service.LoginUserService;
import com.xworkz.vaccine.service.LoginUserServiceImpl;

@Component
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginUserService service;

	@Autowired
	private AddMemberService addMemeberService;

	public LoginController() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/reset")
	public String onClickReset() {
		return "/WEB-INF/pages/ResetPasswordPage.jsp";

	}

	@RequestMapping("/login")
	public String onClickedLoginButton(@RequestParam String username, @RequestParam String password, Model model,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked onClickedLoginButton (from login Controller) ");

		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		boolean isUserCredentailsValid = service.validateUserCredentails(username, password);
		if (isUserCredentailsValid) {
			System.out.println("User Credentails is Valid (from login Controller)");
			boolean isUserNameAndPasswordVerfied = service.verifyUserNameAndPassword(username, password);
			if (isUserNameAndPasswordVerfied) {

				if (LoginUserServiceImpl.matchedCount < 3) {
					System.out.println("Username and Password verified (from login Controller)");
					System.out.println(
							"*******************************************************************************************");
					List<Object> readAllMembersData = addMemeberService.readAllMembersData();
					model.addAttribute("ListOfAllMembers", readAllMembersData);

					return "/WEB-INF/pages/VaccineHomePage.jsp";
				} else {

					System.out.println("Username and Password is verified but user is blocked (from login Controller)");
					model.addAttribute("userVerifiedButBlocked",
							"Login attempts Exceeded. Your Account has been blocked. Please Reset");
					return "/WEB-INF/pages/LoginPage.jsp";
				}

			} else {
				System.out.println("Username and Password not verified (from login Controller)");
				model.addAttribute("notVerified", "UserName or Password not matching. Please try again");

				if (LoginUserServiceImpl.blockedCount >= 3) {
					System.out.println("Account Blocked Please reset the password (from login Controller)");
					model.addAttribute("accountBlocked",
							"Your Account has been blocked due to too many unsuccessful attempts. Please Reset");
					return "/WEB-INF/pages/LoginPage.jsp";
				}

			}

		} else {
			System.out.println("User Credentails is not Valid (from login Controller)");
		}
		return "/WEB-INF/pages/LoginPage.jsp";

	}

}
