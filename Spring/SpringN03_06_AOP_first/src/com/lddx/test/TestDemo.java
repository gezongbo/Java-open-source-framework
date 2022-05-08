package com.lddx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.web.UserServlet;


//测试类
public class TestDemo {
	
	//单元测试类模拟的是浏览器端向服务器端的Servlet发送请求的场景
	@Test
	public void test01(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id来获取UserServlet(模拟浏览器的请求发送到Servlet类)
		UserServlet us=(UserServlet)context.getBean("userServlet");
		us.addUserServlet();
	}
	
}







