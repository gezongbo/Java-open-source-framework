package com.lddx.service;

import org.springframework.stereotype.Service;

//ҵ����ʲ�Service
//��UserService�ӿڵ�����
@Service   //id��Ĭ���ƶϹ���id="userServiceImpl"
public class UserServiceImpl implements UserService{

	@Override
	public void addUser() {
		System.out.println("����Dao��ķ�������������û�...");
	}

	@Override
	public void delUser() {
		System.out.println("����Dao��ķ��������ɾ���û�...");
	}

	@Override
	public void queryUser() {
		System.out.println("����Dao��ķ�������ɲ�ѯ�û�...");
	}

}
