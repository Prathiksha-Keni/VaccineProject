package com.xworkz.vaccine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LogoutController {

	public LogoutController() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/logout")
	public void onLogoutClicked(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked onLogoutClicked (from logout Controller)");
		HttpSession session = request.getSession();
		session.removeAttribute("emailId");
		session.removeAttribute("username");
		session.invalidate();
		response.sendRedirect("WelcomePage.jsp");

	}
}
