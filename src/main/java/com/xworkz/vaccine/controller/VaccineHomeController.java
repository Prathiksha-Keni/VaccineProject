package com.xworkz.vaccine.controller;

import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class VaccineHomeController {

	public VaccineHomeController() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/addMember")
	public String onAddMemberClicked() {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked onAddMemberClicked (from AddMember Controller) ");
		return "/WEB-INF/pages/AddMember.jsp";
	}

}
