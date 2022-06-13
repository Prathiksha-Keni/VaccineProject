package com.xworkz.vaccine.service;

public interface ResetPasswordService {

	public boolean validateResetDetails(String email, String newPassword, String confirmPassword);

	public String encodeConfirmPassword(String confirmPassword);

	public boolean updateNewPasswordToDataBase(String email, String newPassword);

	boolean sendNewPasswordToMail(String email, String newPassword);

}
