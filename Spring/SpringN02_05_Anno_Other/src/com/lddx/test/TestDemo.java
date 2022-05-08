package com.lddx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.bean.Person;
import com.lddx.bean.Student;
import com.lddx.bean.UserDao;

//测试类
public class TestDemo {
	/*
	 * 配置文件的方式--单例、多例、懒加载
	 */
	@Test
	public void test01(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Person对象
		//Person p=(Person)context.getBean("person");
		//System.out.println(p);
		//Person p1=(Person)context.getBean("person");
		//System.out.println(p1);
		/*
		 * 默认是单例模式，输出的p1和p2是同一个对象的值。单例模式创建一次Person对象，使用的也是同一个Person对象
		 * 底层：Person p=new Person();   --21行初始化Spring容器的时候执行
		 *     Map.put("person",p);
		 *     getBean("person") p --  Map.get("person")
		 *     getBean("person") p1 --  Map.get("person")
		 * 多例模式，输出的p1和p2不一样，多例模式会多次常见Person对象
		 * 底层：  21行初始化Spring容器的时候啥也不做
		 *      getBean("person") p   --  Map.put("person",new Person())  Map.get("person")
		 *      getBean("person") p1   -- Map.put("person",new Person())  Map.get("person")
		 * 懒加载，针对于单例模式，在21行spring容器初始化的时候不会马上创建对象了，而是第一次使用该对象的时候在创建，只是在第一次使用的时候创建1次
		 * 输出结果：p和p1的结果是一样
		 * 底层：21行执行完，什么也不做
		 *     23行代码，getBean("person")   Map.put("person",new Person())  Map.get("person") -->p
		 *     25行代码，getBean("person")   Map.get("person")-->p1
		 */
		Person p=(Person)context.getBean("person");
		System.out.println(p);
	}
	
	/*
	 * 注解的方式实现单例、多例、懒加载
	 */
	@Test
	public void test02(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Student对象
		Student stu1=(Student)context.getBean("student");
		System.out.println(stu1);
		Student stu2=(Student)context.getBean("student");
		System.out.println(stu2);
		//调用study方法，获得方法的返回值
		String str=(String)context.getBean("study");
		System.out.println(str);
	}
	
	/*
	 * 关于Spring容器的初始化和销毁
	 */
	@Test
	public void test03(){
		//初始化Spring容器，解析xml文件
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取UserDao对象
		UserDao ud=(UserDao)context.getBean("userDao");
		System.out.println(ud);
		//关闭Spring容器
		context.close();
	}
	
	
}







