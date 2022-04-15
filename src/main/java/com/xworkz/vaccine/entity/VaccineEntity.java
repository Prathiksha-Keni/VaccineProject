package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "user_data")
@NamedQuery(name = "getOtp", query = "SELECT OTP.otp FROM VaccineEntity as OTP WHERE otp=:Otp")
@NamedQuery(name = "verifyEmail", query = "SELECT EMAIL.emailId FROM VaccineEntity as EMAIL WHERE emailId=:Email")
public class VaccineEntity {

	@Column(name = "USER_ID")
	@Id
	@GenericGenerator(name = "primaryKey", strategy = "increment")
	@GeneratedValue(generator = "primaryKey")
	private int userId;

	@Column(name = "USER_EMAIL")
	private String emailId;

	@Column(name = "OTP")
	private String otp;

}
