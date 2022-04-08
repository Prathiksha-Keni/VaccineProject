package com.xworkz.welcomepage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_details")
public class WelcomePageEntity {

	public WelcomePageEntity() {
		System.out.println(this.getClass().getSimpleName() + " Created");
	}

	@Column(name = "userId")
	@Id
	@GenericGenerator(name = "primaryKey", strategy = "increment")
	@GeneratedValue(generator = "primaryKey")
	private int userId;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "otp")
	private String otp;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "WelcomePageEntity [userId=" + userId + ", emailId=" + emailId + ", otp=" + otp + "]";
	}

}
