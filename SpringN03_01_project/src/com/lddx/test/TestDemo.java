package com.lddx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.web.UserServlet;


//������
public class TestDemo {
	
	//��Ԫ������ģ��������������������˵�Servlet��������ĳ���
	@Test
	public void test01(){
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id����ȡUserServlet(ģ��������������͵�Servlet��)
		UserServlet us=(UserServlet)context.getBean("userServlet");
		us.addUserServlet();
	}
	
}







