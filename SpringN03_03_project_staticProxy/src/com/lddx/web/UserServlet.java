package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lddx.service.UserService;

//���Ʋ�Web�㣨���ǿ����и���Ӧ����һ��Servlet�࣬����ʹ��һ����ͨ����ģ�⣩
@Controller   //idĬ���ƶϹ���id="userServlet"
public class UserServlet {

	//��Web�����ִ��Service��Ĵ���
	//����ӿڱ�̣�����ϣ�
	@Autowired
	//��ͨ��UserService���Ͳ��ң��ҵ����������ֱ���UserServiceImpl��UserServiceStaticProxy
	//��ͨ������userSerciceȥƥ��id��ֵ��ֻ�ҵ���һ������UserServiceStaticProxy
	//�ײ�UserServiceStaticProxy userService/zl=new UserServiceStaticProxy()
	private UserService userService;
	
	public void addUserServlet(){
		userService.addUser();
		userService.delUser();
		userService.queryUser();
	}
	
}
