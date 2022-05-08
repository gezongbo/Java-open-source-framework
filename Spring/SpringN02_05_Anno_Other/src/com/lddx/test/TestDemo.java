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

//������
public class TestDemo {
	/*
	 * �����ļ��ķ�ʽ--������������������
	 */
	@Test
	public void test01(){
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡPerson����
		//Person p=(Person)context.getBean("person");
		//System.out.println(p);
		//Person p1=(Person)context.getBean("person");
		//System.out.println(p1);
		/*
		 * Ĭ���ǵ���ģʽ�������p1��p2��ͬһ�������ֵ������ģʽ����һ��Person����ʹ�õ�Ҳ��ͬһ��Person����
		 * �ײ㣺Person p=new Person();   --21�г�ʼ��Spring������ʱ��ִ��
		 *     Map.put("person",p);
		 *     getBean("person") p --  Map.get("person")
		 *     getBean("person") p1 --  Map.get("person")
		 * ����ģʽ�������p1��p2��һ��������ģʽ���γ���Person����
		 * �ײ㣺  21�г�ʼ��Spring������ʱ��ɶҲ����
		 *      getBean("person") p   --  Map.put("person",new Person())  Map.get("person")
		 *      getBean("person") p1   -- Map.put("person",new Person())  Map.get("person")
		 * �����أ�����ڵ���ģʽ����21��spring������ʼ����ʱ�򲻻����ϴ��������ˣ����ǵ�һ��ʹ�øö����ʱ���ڴ�����ֻ���ڵ�һ��ʹ�õ�ʱ�򴴽�1��
		 * ��������p��p1�Ľ����һ��
		 * �ײ㣺21��ִ���꣬ʲôҲ����
		 *     23�д��룬getBean("person")   Map.put("person",new Person())  Map.get("person") -->p
		 *     25�д��룬getBean("person")   Map.get("person")-->p1
		 */
		Person p=(Person)context.getBean("person");
		System.out.println(p);
	}
	
	/*
	 * ע��ķ�ʽʵ�ֵ�����������������
	 */
	@Test
	public void test02(){
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡStudent����
		Student stu1=(Student)context.getBean("student");
		System.out.println(stu1);
		Student stu2=(Student)context.getBean("student");
		System.out.println(stu2);
		//����study��������÷����ķ���ֵ
		String str=(String)context.getBean("study");
		System.out.println(str);
	}
	
	/*
	 * ����Spring�����ĳ�ʼ��������
	 */
	@Test
	public void test03(){
		//��ʼ��Spring����������xml�ļ�
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡUserDao����
		UserDao ud=(UserDao)context.getBean("userDao");
		System.out.println(ud);
		//�ر�Spring����
		context.close();
	}
	
	
}







