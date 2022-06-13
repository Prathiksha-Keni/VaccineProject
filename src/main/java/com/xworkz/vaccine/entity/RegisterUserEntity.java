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
@Table(name = "register_user")
@NamedQuery(name = "getUserName", query = "SELECT USER.username FROM RegisterUserEntity as USER WHERE username=:name")
@NamedQuery(name = "getPasswordByUsername", query = "SELECT PASS.password FROM RegisterUserEntity as PASS WHERE username=:UserName")
@NamedQuery(name = "getLoginCountByUsername", query = "SELECT track.loginCount FROM RegisterUserEntity as track WHERE username=:UserName")
@NamedQuery(name = "updateLoginCount", query = "UPDATE RegisterUserEntity SET loginCount=:Count WHERE username=:User")
@NamedQuery(name = "updateNewPasswordByEmail", query = "UPDATE RegisterUserEntity SET password=:newUpdatedPassword,loginCount=0 WHERE email=:EmailId ")
public class RegisterUserEntity {

	@Column(name = "ID")
	@Id
	@GenericGenerator(name = "primaryKey", strategy = "increment")
	@GeneratedValue(generator = "primaryKey")
	private int id;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "EMAIL_ID")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "YEAR_OF_BIRTH")
	private String yearOfBirth;

	@Column(name = "CONTACT_NUMBER")
	private String phoneNumber;

	@Column(name = "LOGIN_COUNT")
	private int loginCount;

}
