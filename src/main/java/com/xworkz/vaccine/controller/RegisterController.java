package com.xworkz.vaccine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.RegisterUserDTO;

import com.xworkz.vaccine.service.RegisterUserService;

@Component
@RequestMapping("/")
public class RegisterController {

	public static String pws;

	@Autowired
	private RegisterUserService service;

	public RegisterController() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/registerUser")
	public String onUserRegister(@ModelAttribute RegisterUserDTO dto, Model model, HttpServletRequest request,
			HttpServletResponse response)  {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked onUserRegister (from Register Controller) ");

		HttpSession session = request.getSession();
		session.setAttribute("RegisterUsername", dto.getUsername());

		RegisterController.pws = dto.getPassword();

		System.out.println("(from Register Controller) Raw password is : " + dto.getPassword());
		boolean isUserValid = service.validateRegisterUser(dto);

		if (isUserValid) {
			service.sendPasswordToMail(dto.getEmail(), dto.getPassword(), dto.getUsername());
			model.addAttribute("RegisterEmail", "User Details sent to user email");
			System.out.println(" User is valid (from Register Controller) ");
			boolean isUserSaved = service.saveRegisterUser(dto);

			if (isUserSaved) {
				System.out.println(" User entity Saved to database (from Register Controller) ");
				model.addAttribute("userRegistred", "User Registred");
				return "/WEB-INF/pages/LoginPage.jsp";
			} else {
				System.out.println(" User entity not saved (from Register Controller) ");
				model.addAttribute("userNotRegistred", "User Not Registred");
				
			}

		} else {
			System.out.println(" User is not valid (from Register Controller) ");
			model.addAttribute("userNotValid", "Please enter a valid data");
			return "/WEB-INF/pages/RegisterPage.jsp";

		}

		return "/WEB-INF/pages/RegisterPage.jsp";

	}
}
