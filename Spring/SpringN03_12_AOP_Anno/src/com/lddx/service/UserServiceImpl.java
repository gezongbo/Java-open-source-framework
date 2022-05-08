package com.lddx.service;

import org.springframework.stereotype.Service;

import com.lddx.bean.User;

//业务访问层Service
//是UserService接口的子类
@Service   //id的默认推断规则id="userServiceImpl"
public class UserServiceImpl implements UserService{

//	@Override
//	public void addUser() {
//		System.out.println("新增用户...");
//	}

//	@Override
//	public void delUser() {
//		System.out.println("删除用户...");
//	}

	@Override
	public User queryUser() {
		System.out.println("查询用户...");
		//int a=3/0;
		User u=new User(1,"zs");
		return u;
	}

//	@Override
//	public void queryUser() {
//		System.out.println("查询用户...");
//	}
	
	
}
