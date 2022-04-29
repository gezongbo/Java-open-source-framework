package com.lddx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.bean.Hero;
import com.lddx.bean.MySQLConnection;
import com.lddx.bean.Person;
import com.lddx.bean.Teacher;

//测试类
public class TestDemo {
	/*
	 * Spring框架配置文件的方式实现IOC和DI
	 */
	@Test
	public void test01(){
		//初始化Spring容器
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Teacher对象
		//Teacher t=(Teacher)context.getBean("teacher");
		//System.out.println(t);
		//Teacher [age=30, list=[a, b, c], map={k1=v1, k2=v2}, name=zs, prop={p2=v2, p1=v1}, set=[1, 2]]
		//通过id获取MySQLConnection类
		MySQLConnection mc=(MySQLConnection)context.getBean("mysqlCon");
		System.out.println(mc);
		//MySQLConnection [driverName=com.mysql.jdbc.Driver, name=root, password=1234,
		//url=jdbc:mysql://localhost:3306/test]
	}
	
	/*
	 * Spring框架注解的方式实现IOC和DI
	 */
	@Test
	public void test02(){
		//初始化Spring容器
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Hero对象
		//Hero hero=(Hero)context.getBean("hero");
		//System.out.println(hero);
		//通过id获取MySQLConnection类
		MySQLConnection mc=(MySQLConnection)context.getBean("mysqlCon");
		System.out.println(mc);
	}
	
	/*
	 * Spring框架注解的方式实现DI- 集合等
	 */
	@Test
	public void test03(){
		//初始化Spring容器
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Person对象
		Person p=(Person)context.getBean("person");
		System.out.println(p);
	
	}
	
	/*
	 * Spring框架注解的方式实现DI--包含javabean的情况
	 */
	@Test
	public void test04(){
		//初始化Spring容器
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Teacher对象
		//Teacher t=(Teacher)context.getBean("teacher");
		//System.out.println(t);
		//通过id获取Hero类   --注解的方式
		Hero hero=(Hero)context.getBean("hero");
		System.out.println(hero);
	}
	
	
	
}
