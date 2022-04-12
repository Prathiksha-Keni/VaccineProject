package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.VaccineEntity;

public interface OtpDAO {
	VaccineEntity  getOtpFromTableByEmail(String email);

}
