package com.lddx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//������UserServiceImpl��ľ�̬������
//UserServiceImplʵ����UserService�ӿڣ�
//UserServiceStaticProxyҲҪʵ��UserService�ӿ�
//@Service  //�൱�ڴ�����UserServiceStaticProxy��id��Ĭ��ֵ��id="userServiceStaticProxy"
@Service("userService")   //ָ��idΪuserService id="userService"
public class UserServiceStaticProxy implements UserService{

	//private UserServiceImpl userService=new UserServiceImpl();
	//����ӿڱ�̣��ܹ������   ����ϵĺ���˼�룺�ӿ�+IOC+DI
	//private UserService userService=new UserServiceImpl();
	//ʹ��ʹ��Spring����е�IOC+DI
	//IOC����UserServiceImpl�Ĵ�����DI�����userService��ֵ
	@Autowired
	@Qualifier("userServiceImpl")     //ֱ�Ӹ���id���в��ң����������Ͳ�����
	private UserService userService;
	
	@Override
	public void addUser() {
		System.out.println("#��¼��־");
		System.out.println("#Ȩ�޿���");
		System.out.println("#��������");
		userService.addUser();
		System.out.println("#�ύ����");
	}

	@Override
	public void delUser() {
		System.out.println("#��¼��־");
		System.out.println("#Ȩ�޿���");
		System.out.println("#��������");
		userService.delUser();
		System.out.println("#�ύ����");
	}

	@Override
	public void queryUser() {
		System.out.println("#��¼��־");
		System.out.println("#Ȩ�޿���");
		System.out.println("#��������");
		userService.queryUser();
		System.out.println("#�ύ����");
	}

}
