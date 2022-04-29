package com.lddx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.bean.Doctor;
import com.lddx.bean.DoctorInstanceFactory;
import com.lddx.bean.DoctorStaticFactory;
import com.lddx.bean.Student;


//测试类
public class TestDemo {

	/*
	 * 注解的方式来实现实例工厂
	 */
	@Test
	public void test01(){
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取Doctor类
		Doctor doctor=(Doctor)context.getBean("doctor");
		System.out.println(doctor);
	}
	
	//注解实现IOC管理的对象
	@Test
	public void test02(){
		//自己的方式来完成
		DoctorInstanceFactory dif1=new DoctorInstanceFactory();
		Doctor doctor1=dif1.getDoctor();
		
		
		//初始化Spring容器，解析xml文件
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获取DoctorInstanceFactory类
		DoctorInstanceFactory dif=(DoctorInstanceFactory)context.getBean("doctorInstanceFactory");
		System.out.println(dif);//com.lddx.bean.DoctorInstanceFactory@1e184cb
		Doctor doctor=dif.getDoctor();
		System.out.println(doctor);//com.lddx.bean.Doctor@d55986
	}
	
	
	/*
	 * Student类的使用演示
	 */
	@Test
	public void test03(){
		/*
		 * 方式1：自己的方式
		 */
		Student stu=new Student();
		stu.study();
		stu.sleep();
		/*
		 * 方式2：使用Spring框架中的注解
		 */
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		String str=(String)context.getBean("study");
		System.out.println(str);
	}
	
	/*
	 * Spring框架实现静态工厂
	 */
	@Test
	public void test04(){
		//自己的方式使用静态工厂
		//Doctor doctor1=DoctorStaticFactory.getDoctor();
		//System.out.println(doctor1);
		
		//DoctorStaticFactory dsf=new DoctorStaticFactory();
		//Doctor doctor11=dsf.getDoctor();
		//System.out.println(doctor11);
		
		//初始化Spring容器
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//配置文件的方式
		//Doctor doctor2=(Doctor)context.getBean("doc2");
		//System.out.println(doctor2);
		
		//注解的方式
		//Doctor doctor3=(Doctor)context.getBean("gd");
		//System.out.println(doctor3);
	}
	
	
	
	
	
}
