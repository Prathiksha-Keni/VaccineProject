package com.xworkz.vaccine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMemberDTO {

	private String name;

	private String gender;

	private String yearOfBirth;

	private String idProof;

	private String idNumber;

	private String vaccineType;

	private String dose;

}
