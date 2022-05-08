package com.lddx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.bean.Doctor;
import com.lddx.bean.HelloWorld;
import com.lddx.bean.Person;
import com.lddx.bean.SDCard;
import com.lddx.bean.Student;
import com.lddx.bean.Teacher;

//测试类
public class TestDemo {

	/*
	 * 使用自己的方式创建JavaBean类  --不使用Spring框架中的IOC
	 */
	@Test
	public void test01(){
		Person p=new Person();
		p.eat();
		p.say();
	}
	/*
	 * 使用Spring框架中的IOC创建JavaBean类  -- xml配置文件的方式
	 */
	@Test
	public void test02(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Person类
		Person p=(Person)context.getBean("person");
		p.eat();
		p.say();
	}
	/*
	 * 使用Spring框架中的IOC创建JavaBean类  -- 注解的方式
	 */
	@Test
	public void test03(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Person类型
		Person p=(Person)context.getBean("person");
		p.eat();
		p.say();
		//通过id获取Student类
		Student stu=(Student)context.getBean("student");
		stu.study();
		//通过id获取Teacher类
		Teacher t=(Teacher)context.getBean("teacher");
		System.out.println(t);
		//通过id获取HelloWorld类
		HelloWorld hw=(HelloWorld)context.getBean("helloWorld");
		System.out.println(hw);
		//通过id获取SDCard
		SDCard card=(SDCard)context.getBean("SDCard");
		System.out.println(card);
		//通过id获取Doctor
		Doctor doctor=(Doctor)context.getBean("doct");
		System.out.println(doctor);
	
	}
	
	
}
