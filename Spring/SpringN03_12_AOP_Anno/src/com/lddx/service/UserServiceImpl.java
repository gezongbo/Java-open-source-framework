package com.lddx.service;

import org.springframework.stereotype.Service;

import com.lddx.bean.User;

//ҵ����ʲ�Service
//��UserService�ӿڵ�����
@Service   //id��Ĭ���ƶϹ���id="userServiceImpl"
public class UserServiceImpl implements UserService{

//	@Override
//	public void addUser() {
//		System.out.println("�����û�...");
//	}

//	@Override
//	public void delUser() {
//		System.out.println("ɾ���û�...");
//	}

	@Override
	public User queryUser() {
		System.out.println("��ѯ�û�...");
		//int a=3/0;
		User u=new User(1,"zs");
		return u;
	}

//	@Override
//	public void queryUser() {
//		System.out.println("��ѯ�û�...");
//	}
	
	
}
