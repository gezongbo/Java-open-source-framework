package com.lddx.dao;

import org.springframework.stereotype.Repository;

//ģ�Ͳ�Model��
//���ݷ��ʲ�Dao��
@Repository()
public class DB2UserDao implements UserDao{

	@Override
	public void addUser() {
		System.out.println("DB2...addUser....");
	}
	
	

}
