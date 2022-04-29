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

//������
public class TestDemo {
	/*
	 * Spring��������ļ��ķ�ʽʵ��IOC��DI
	 */
	@Test
	public void test01(){
		//��ʼ��Spring����
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡTeacher����
		//Teacher t=(Teacher)context.getBean("teacher");
		//System.out.println(t);
		//Teacher [age=30, list=[a, b, c], map={k1=v1, k2=v2}, name=zs, prop={p2=v2, p1=v1}, set=[1, 2]]
		//ͨ��id��ȡMySQLConnection��
		MySQLConnection mc=(MySQLConnection)context.getBean("mysqlCon");
		System.out.println(mc);
		//MySQLConnection [driverName=com.mysql.jdbc.Driver, name=root, password=1234,
		//url=jdbc:mysql://localhost:3306/test]
	}
	
	/*
	 * Spring���ע��ķ�ʽʵ��IOC��DI
	 */
	@Test
	public void test02(){
		//��ʼ��Spring����
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡHero����
		//Hero hero=(Hero)context.getBean("hero");
		//System.out.println(hero);
		//ͨ��id��ȡMySQLConnection��
		MySQLConnection mc=(MySQLConnection)context.getBean("mysqlCon");
		System.out.println(mc);
	}
	
	/*
	 * Spring���ע��ķ�ʽʵ��DI- ���ϵ�
	 */
	@Test
	public void test03(){
		//��ʼ��Spring����
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡPerson����
		Person p=(Person)context.getBean("person");
		System.out.println(p);
	
	}
	
	/*
	 * Spring���ע��ķ�ʽʵ��DI--����javabean�����
	 */
	@Test
	public void test04(){
		//��ʼ��Spring����
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡTeacher����
		//Teacher t=(Teacher)context.getBean("teacher");
		//System.out.println(t);
		//ͨ��id��ȡHero��   --ע��ķ�ʽ
		Hero hero=(Hero)context.getBean("hero");
		System.out.println(hero);
	}
	
	
	
}
