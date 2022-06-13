package com.xworkz.vaccine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.controller.WelcomePageController;
import com.xworkz.vaccine.dao.AddMemberDAO;
import com.xworkz.vaccine.dao.WelcomePageDAO;
import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;

import com.xworkz.vaccine.exception.InvalidDoseException;
import com.xworkz.vaccine.exception.InvalidEmailException;
import com.xworkz.vaccine.exception.InvalidGenderException;
import com.xworkz.vaccine.exception.InvalidIdNumberException;
import com.xworkz.vaccine.exception.InvalidIdProofException;

import com.xworkz.vaccine.exception.InvalidVaccineTypeException;
import com.xworkz.vaccine.exception.InvalidYearOfBirthException;

@Component
public class AddMemberServiceImpl implements AddMemberService {

	@Autowired
	private AddMemberDAO addMemberDAO;

	@Autowired
	private WelcomePageDAO welcomPageDAO;

	public AddMemberServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean validateAddMemberDto(AddMemberDTO dto) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked validateAddMemberDto (message from AddMemeber Service) ");
		boolean valid = false;
		try {
			if (dto.getName() != null && !dto.getName().isEmpty()) {
				System.out.println(" Valid Name (message from AddMemeber Service) ");
				valid = true;

			} else {
				throw new InvalidEmailException(" Invalid Email ");
			}
			if (dto.getGender() != null && !dto.getGender().isEmpty()) {
				System.out.println(" Valid Gender (message from AddMemeber Service) ");
				valid = true;
			} else {
				throw new InvalidGenderException("Invalid Gender");
			}
			if (dto.getYearOfBirth() != null && !dto.getYearOfBirth().isEmpty() && dto.getYearOfBirth().length() == 4) {
				System.out.println(" Valid YOB (message from AddMemeber Service) ");
				valid = true;

			} else {
				throw new InvalidYearOfBirthException("Invalid YOB");

			}
			if (dto.getIdProof() != null && !dto.getIdProof().isEmpty()) {
				System.out.println(" Valid IdProof (message from AddMemeber Service) ");
				valid = true;

			} else {
				throw new InvalidIdProofException("Invalid Id Proof");
			}
			if (dto.getIdNumber() != null && !dto.getIdNumber().isEmpty()) {
				System.out.println(" Valid IdNumber (message from AddMemeber Service) ");
				valid = true;

			} else {
				throw new InvalidIdNumberException("Invalid Id Number");
			}
			if (dto.getVaccineType() != null && !dto.getVaccineType().isEmpty()) {
				System.out.println(" Valid VaccineType (message from AddMemeber Service) ");
				valid = true;

			} else {
				throw new InvalidVaccineTypeException("Invalid Vaccine Type");
			}
			if (dto.getDose() != null && !dto.getDose().isEmpty()) {
				System.out.println(" Valid Dose (message from AddMemeber Service) ");
				valid = true;

			} else {
				throw new InvalidDoseException("Invalid Dose");
			}
		} catch (InvalidDoseException exception) {
			System.out.println("Invalid Data Exception " + exception.getMessage());
		}
		return valid;

		// boolean valid = false;
		// if (dto.getName() != null && !dto.getName().isEmpty()) {
		// System.out.println(" Valid Name (message from AddMemeber Service) ");
		// valid = true;
		//
		// } else {
		// InvalidNameException invalidNameException = new InvalidNameException("
		// Invalid Name ");
		// throw invalidNameException;
		//
		// }
		// if (dto.getGender() != null && !dto.getGender().isEmpty()) {
		// System.out.println(" Valid Gender (message from AddMemeber Service) ");
		// valid = true;
		//
		// } else {
		// InvalidGenderException invalidGenderException = new InvalidGenderException("
		// Invalid Gender ");
		// throw invalidGenderException;
		// }
		// if (dto.getYearOfBirth() != null && !dto.getYearOfBirth().isEmpty() &&
		// dto.getYearOfBirth().length() == 4) {
		// System.out.println(" Valid YOB (message from AddMemeber Service) ");
		// valid = true;
		//
		// } else {
		// InvalidYearOfBirthException invalidYearOfBirthException = new
		// InvalidYearOfBirthException(
		// " Invalid Year Of Birth ");
		// throw invalidYearOfBirthException;
		// }
		// if (dto.getIdProof() != null && !dto.getIdProof().isEmpty()) {
		// System.out.println(" Valid IdProof (message from AddMemeber Service) ");
		// valid = true;
		//
		// } else {
		// InvalidIdProofException invalidIdProofException = new
		// InvalidIdProofException(" Invalid ID Proof ");
		// throw invalidIdProofException;
		// }
		// if (dto.getIdNumber() != null && !dto.getIdNumber().isEmpty()) {
		// System.out.println(" Valid IdNumber (message from AddMemeber Service) ");
		// valid = true;
		//
		// } else {
		// InvalidIdNumberException invalidIdNumberException = new
		// InvalidIdNumberException(" Invalid Id Number ");
		// throw invalidIdNumberException;
		// }
		// if (dto.getVaccineType() != null && !dto.getVaccineType().isEmpty()) {
		// System.out.println(" Valid VaccineType (message from AddMemeber Service) ");
		// valid = true;
		// } else {
		// InvalidVaccineTypeException invalidVaccineTypeException = new
		// InvalidVaccineTypeException(
		// " Invalid Vaccine Type ");
		// throw invalidVaccineTypeException;
		// }
		// if (dto.getDose() != null && !dto.getDose().isEmpty()) {
		// System.out.println(" Valid Dose (message from AddMemeber Service) ");
		// valid = true;
		//
		// } else {
		// InvalidDoseException invalidDoseException = new InvalidDoseException("
		// Invalid Dose ");
		// throw invalidDoseException;
		// }
		// return valid;

	}

	@Override
	public boolean saveAddMemberDto(AddMemberDTO dto) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked saveAddMemberDto (message from AddMemeber Service)");
		boolean isEntitySaved = false;
		try {
			AddMemberEntity entity = new AddMemberEntity();
			BeanUtils.copyProperties(dto, entity);
			int memberCount = welcomPageDAO.getMemberCountByEmail(WelcomePageController.email);
			if (memberCount >= 4) {
				System.out.println(" Cant add more than 4 member (message from AddMemeber Service) ");
				return isEntitySaved; // to cont and display error msg in cont
			} else {
				isEntitySaved = addMemberDAO.saveMember(entity);
				memberCount++;
				welcomPageDAO.updateMemberCount(WelcomePageController.email, memberCount);
				isEntitySaved = true;
				return isEntitySaved;
			}
		} catch (Exception exception) {
			System.out.println("NewMember Entity not saved (message from AddMemeber Service) " + exception);
		}
		return isEntitySaved;
	}

	@Override
	public List<Object> readAllMembersData() {
		System.out.println("-----------------------------------------------------------");
		System.out.println(" Invoked readAllMembersData (message from AddMemeber Service)");
		List<Object> obj = null;
		List<AddMemberEntity> allMemberEntity = addMemberDAO.getAllMemberEntity();

		if (allMemberEntity != null) {
			return obj = new ArrayList<Object>(allMemberEntity);
		}
		return obj;
	}

}
