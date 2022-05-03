package com.lddx.service;

import org.springframework.stereotype.Service;

//业务访问层Service
//是UserService接口的子类
@Service   //id的默认推断规则id="userServiceImpl"
public class UserServiceImpl implements UserService{

	@Override
	public void addUser() {
		System.out.println("调用Dao层的方法，完成新增用户...");
	}

	@Override
	public void delUser() {
		System.out.println("调用Dao层的方法，完成删除用户...");
	}

	@Override
	public void queryUser() {
		System.out.println("调用Dao层的方法，完成查询用户...");
	}

}
