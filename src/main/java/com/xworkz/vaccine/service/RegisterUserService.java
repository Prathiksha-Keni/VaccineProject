package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.RegisterUserDTO;

public interface RegisterUserService {
	public boolean validateRegisterUser(RegisterUserDTO dto);

	public boolean saveRegisterUser(RegisterUserDTO dto);

	boolean sendPasswordToMail(String email, String password, String username);

}
