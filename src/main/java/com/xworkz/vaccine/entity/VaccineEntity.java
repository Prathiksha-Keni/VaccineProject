package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_data")
@NamedQuery(name = "getOtp", query = "SELECT OTP.otp FROM VaccineEntity as OTP WHERE otp=:Otp")
@NamedQuery(name = "verifyEmail", query = "SELECT EMAIL.emailId FROM VaccineEntity as EMAIL WHERE emailId=:Email")
@NamedQuery(name = "getMemberCount", query = "SELECT value.memberCount FROM VaccineEntity as value WHERE emailId=:email")
@NamedQuery(name = "updateMemberCount", query = "UPDATE VaccineEntity SET memberCount=:Count WHERE emailId=:EmailId")
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

	@Column(name = "MEMBER_COUNT")
	private int memberCount;

}
