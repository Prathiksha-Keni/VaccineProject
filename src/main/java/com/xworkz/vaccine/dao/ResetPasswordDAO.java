package com.xworkz.vaccine.dao;

public interface ResetPasswordDAO {

	String updateNewPasswordByEmail(String email, String newPassword);

}
