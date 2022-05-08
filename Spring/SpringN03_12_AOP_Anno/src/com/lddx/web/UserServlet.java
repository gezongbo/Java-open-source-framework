package com.lddx.web;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.lddx.bean.User;
import com.lddx.service.UserService;
import com.lddx.service.UserServiceImpl;
import com.lddx.service.UserServiceImpl2;

//���Ʋ�Web�㣨���ǿ����и���Ӧ����һ��Servlet�࣬����ʹ��һ����ͨ����ģ�⣩
@Controller   //idĬ���ƶϹ���id="userServlet"
public class UserServlet {

	//��Web�����ִ��Service��Ĵ���
	//����ӿڱ�̣�����ϣ�
	@Autowired
	private UserService userService;
	//@Autowired
	//private UserServiceImpl2 userService2;
	/*
	 * �ײ���⣺��userService���Ե�����ʹ����@Autowiredע�⣬������Զ�װ�䣬����UserService����
	 * ȥƥ�䣬�ܹ�ƥ�䵽UserServiceImpl�࣬UserServiceImpl�����@Serviceע�⣬Spring����IOC�ᴴ��UserServiceImpl�࣬
	 * ͬʱ������������ļ��е����ã�����UserServiceImpl��Ĵ�����ͨ��userServce���Ե���ִ��queryUser()Ŀ�귽����ʱ��
	 * ��ִ�д����еķ�����Ҳ����������FirstAspect�ж����֪ͨ������
	 * userService������Ϊ�����ļ����������棬������֪ͨ������������UserServiceImpl�Ĵ���ʵ���ϸ�userService���Ը�ֵ��������
	 * �Ĵ���
	 * Object obj=Proxy.newProxyInstance.....
	 * UserService us=(UserService)obj;
	 * us��ͬ������ΪuserService����
	 */
	
	public void addUserServlet(){
		//userService.addUser();
		//userService.delUser();
		//userService.queryUser();
		//System.out.println(userService2.getClass());
		//class com.lddx.service.UserServiceImpl2$$EnhancerByCGLIB$$ab13b75d
		//userService2.queryUser2();
		
		//System.out.println("����ģʽ:"+userService.getClass());//����ģʽ:class $Proxy6s
		User user=userService.queryUser();
		//����ת��,���з��յ�
		//UserServiceImpl usi=(UserServiceImpl)userService;
		//usi.mytest();
		
		System.out.println("UserServlet�ࣺ"+user);
	}
	
}
