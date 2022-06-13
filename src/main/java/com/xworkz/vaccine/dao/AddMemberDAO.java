package com.xworkz.vaccine.dao;

import java.util.List;

import com.xworkz.vaccine.entity.AddMemberEntity;

public interface AddMemberDAO {

	public boolean saveMember(Object entity);

	List<AddMemberEntity> getAllMemberEntity();

}
