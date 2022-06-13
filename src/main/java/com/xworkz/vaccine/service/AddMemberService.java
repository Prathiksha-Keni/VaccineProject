package com.xworkz.vaccine.service;

import java.util.List;

import com.xworkz.vaccine.dto.AddMemberDTO;

public interface AddMemberService {

	public boolean validateAddMemberDto(AddMemberDTO dto);

	public boolean saveAddMemberDto(AddMemberDTO dto);

	List<Object> readAllMembersData();

}
