package com.xworkz.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.service.AddMemberService;

@Component
@RequestMapping("/")
public class AddMemberController {

	@Autowired
	private AddMemberService service;

	public AddMemberController() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@RequestMapping("/register")
	public String onClickedAddButton(@ModelAttribute AddMemberDTO dto, Model model) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked onClickedAddButton (from addMember Controller)");
		boolean isMemberValid = service.validateAddMemberDto(dto);

		if (isMemberValid) {
			System.out.println(" Memeber is valid (from addMember Controller) ");
			boolean isMemberSaved = service.saveAddMemberDto(dto);
			if (isMemberSaved) {
				System.out.println(" member entity Saved to database (from addMember Controller) ");
				model.addAttribute("memberSaved", "Data Saved");
				List<Object> readAllMembersData = service.readAllMembersData();

				if (readAllMembersData != null) {
					model.addAttribute("ListOfAllMembers", readAllMembersData);
					return "/WEB-INF/pages/VaccineHomePage.jsp";
				} else {
					return "/WEB-INF/pages/AddMember.jsp";
				}

			} else {
				System.out.println(" member entity not saved (from addMember Controller) ");
				model.addAttribute("cantAdd", "Can not add more than 4 member");

			}

		} else {
			System.out.println(" member not valid (from addMember Controller) ");
			model.addAttribute("memberNotValid", "Please enter a valid data");
			return "/WEB-INF/pages/AddMember.jsp";

		}
		return "/WEB-INF/pages/AddMember.jsp";
	}
}
