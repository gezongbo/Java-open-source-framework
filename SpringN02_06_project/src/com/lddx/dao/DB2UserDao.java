package com.lddx.dao;

import org.springframework.stereotype.Repository;

//模型层Model层
//数据访问层Dao层
@Repository()
public class DB2UserDao implements UserDao{

	@Override
	public void addUser() {
		System.out.println("DB2...addUser....");
	}
	
	

}
