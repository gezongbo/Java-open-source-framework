package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.lddx.service.UserService;
import com.lddx.service.UserServiceImpl;

//���Ʋ�Web�㣨���ǿ����и���Ӧ����һ��Servlet�࣬����ʹ��һ����ͨ����ģ�⣩
@Controller   //idĬ���ƶϹ���id="userServlet"
public class UserServlet {

	//��Web�����ִ��Service��Ĵ���
	//����ӿڱ�̣�����ϣ�
	@Autowired
	//@Qualifier("userServiceJavaProxy") //ֱ�Ӹ���id���ҵ�
	@Qualifier("getProxy")
	//Ĭ�ϣ���ͨ��UserService���Ͳ��ң��ҵ���1����ֻ���ҵ�UserServiceImpl�࣬��������ʵ���java�Ķ�̬������UserServiceJavaProxy
	//private UserService userService;
	private UserServiceImpl userService;
	/*
	 *   ����1������UserServiceJavaProxy�࣬Ȼ���userService���Ը�ֵ
	 *   UserServiceJavaProxy javaProxy=new UserServiceJavaProxy();
	 *   userService=javaProxy;   ���Ͳ�ƥ��
	 *   ����1�в�ͨ
	 *   ����2��ֱ��ͨ��id����UserServiceJavaProxy���еķ���
	 *   ����@Qualifier��getProxy�����ĸ�@Bean��nameҲΪgetProxy
	 *   UserService us=getProxy();
	 *   userService=us;  ok ����һ��
	 *   ����2�е�ͨ
	 */
	
	public void addUserServlet(){
		userService.addUser();
		userService.delUser();
		userService.queryUser();
		userService.test();
		userService.test1();
		
	}
	
}
