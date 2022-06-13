package com.xworkz.vaccine.dao;

public interface LoginUserDAO {

	String getUserName(String userName);

	String getPasswordByUsername(String userName);

	int getLoginCountByUsername(String username);

	int updateLoginCount(String username, int count);

}
