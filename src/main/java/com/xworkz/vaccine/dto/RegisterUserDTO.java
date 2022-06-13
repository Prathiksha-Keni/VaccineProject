package com.xworkz.vaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {

	private String username;

	private String email;

	private String password;

	private String gender;

	private String yearOfBirth;

	private String phoneNumber;

}
