package com.lddx.service;

import org.springframework.stereotype.Service;

//ҵ����ʲ�Service
//��UserService�ӿڵ�����
@Service   //id��Ĭ���ƶϹ���id="userServiceImpl"
public class UserServiceImpl implements UserService{

	@Override
	public void addUser() {
		//System.out.println("#��¼��־");
		//System.out.println("#Ȩ�޿���");
		//System.out.println("#��������");
		System.out.println("����Dao��ķ�������������û�...");
		//System.out.println("#�ύ����");
	}

	@Override
	public void delUser() {
		//System.out.println("#��¼��־");
		//System.out.println("#Ȩ�޿���");
		//System.out.println("#��������");
		System.out.println("����Dao��ķ��������ɾ���û�...");
		//System.out.println("#�ύ����");
	}

	@Override
	public void queryUser() {
		//System.out.println("#��¼��־");
		//System.out.println("#Ȩ�޿���");
		//System.out.println("#��������");
		System.out.println("����Dao��ķ�������ɲ�ѯ�û�...");
		//System.out.println("#�ύ����");
	}

}
