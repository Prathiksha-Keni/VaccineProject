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
@Table(name = "add_member")
@NamedQuery(name = "getAllMemberEntity", query = "SELECT entity FROM AddMemberEntity as entity")

public class AddMemberEntity {

	@Column(name = "ID")
	@Id
	@GenericGenerator(name = "primaryKey", strategy = "increment")
	@GeneratedValue(generator = "primaryKey")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "YEAR_OF_BIRTH")
	private String yearOfBirth;

	@Column(name = "ID_PROOF")
	private String idProof;

	@Column(name = "ID_NUMBER")
	private String idNumber;

	@Column(name = "VACCINE_TYPE")
	private String vaccineType;

	@Column(name = "DOSE")
	private String dose;

}
