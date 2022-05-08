package com.lddx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.service.UserServiceImpl;
import com.lddx.web.UserServlet;


//������
public class TestDemo {
	
	/*
	 * ��Ԫ���Է���ģ�������������������Servlet�ķ�ʽ
	 */
	@Test
	public void test01(){
		//���������������ֱ�ӷ���XXXServlet���
		//����ֱ�Ӵ���UserServlet�Ϳ���
		//UserServlet userServlet=new UserServlet();
		//userServlet.addUserServlet();
		
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡUserServiceImpl����
		//UserServiceImpl usi=(UserServiceImpl)context.getBean("userServiceImpl");
		//System.out.println(usi);
		//usi.addUserService();
		
		//ͨ��id��ȡUserServlet����  
		//��Servlet(Web��)��ʼ����
		UserServlet userServlet=(UserServlet)context.getBean("userServlet");
		userServlet.addUserServlet();
		
	}
	
	
}







