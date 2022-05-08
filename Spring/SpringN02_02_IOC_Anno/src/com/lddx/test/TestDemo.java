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

//������
public class TestDemo {

	/*
	 * ʹ���Լ��ķ�ʽ����JavaBean��  --��ʹ��Spring����е�IOC
	 */
	@Test
	public void test01(){
		Person p=new Person();
		p.eat();
		p.say();
	}
	/*
	 * ʹ��Spring����е�IOC����JavaBean��  -- xml�����ļ��ķ�ʽ
	 */
	@Test
	public void test02(){
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡPerson��
		Person p=(Person)context.getBean("person");
		p.eat();
		p.say();
	}
	/*
	 * ʹ��Spring����е�IOC����JavaBean��  -- ע��ķ�ʽ
	 */
	@Test
	public void test03(){
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡPerson����
		Person p=(Person)context.getBean("person");
		p.eat();
		p.say();
		//ͨ��id��ȡStudent��
		Student stu=(Student)context.getBean("student");
		stu.study();
		//ͨ��id��ȡTeacher��
		Teacher t=(Teacher)context.getBean("teacher");
		System.out.println(t);
		//ͨ��id��ȡHelloWorld��
		HelloWorld hw=(HelloWorld)context.getBean("helloWorld");
		System.out.println(hw);
		//ͨ��id��ȡSDCard
		SDCard card=(SDCard)context.getBean("SDCard");
		System.out.println(card);
		//ͨ��id��ȡDoctor
		Doctor doctor=(Doctor)context.getBean("doct");
		System.out.println(doctor);
	
	}
	
	
}
