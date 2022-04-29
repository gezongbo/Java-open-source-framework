package com.lddx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.service.UserServiceImpl;
import com.lddx.web.UserServlet;


//测试类
public class TestDemo {
	
	/*
	 * 单元测试方法模拟的浏览器发送请求访问Servlet的方式
	 */
	@Test
	public void test01(){
		//浏览器发送请求是直接访问XXXServlet类的
		//可以直接创建UserServlet就可以
		//UserServlet userServlet=new UserServlet();
		//userServlet.addUserServlet();
		
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取UserServiceImpl对象
		//UserServiceImpl usi=(UserServiceImpl)context.getBean("userServiceImpl");
		//System.out.println(usi);
		//usi.addUserService();
		
		//通过id获取UserServlet对象  
		//从Servlet(Web层)开始访问
		UserServlet userServlet=(UserServlet)context.getBean("userServlet");
		userServlet.addUserServlet();
		
	}
	
	
}







