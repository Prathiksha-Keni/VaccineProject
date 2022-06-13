package com.xworkz.vaccine.dao;

public interface WelcomePageDAO {
	public boolean saveUserEntity(Object entity);

	String VerfiyEmail(String email);

	int getMemberCountByEmail(String email);

	int updateMemberCount(String email, int count);

}
