package com.lddx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.service.UserService;
import com.lddx.web.UserServlet;


//测试类
public class TestDemo {
	
	//静态代理的方式
	@Test
	public void test01(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id来获取UserServlet(模拟浏览器的请求发送到Servlet类)
		UserServlet us=(UserServlet)context.getBean("userServlet");
		us.addUserServlet();
	}
	
}







