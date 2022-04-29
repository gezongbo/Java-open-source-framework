package com.lddx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lddx.bean.Doctor;
import com.lddx.bean.DoctorInstanceFactory;
import com.lddx.bean.DoctorStaticFactory;
import com.lddx.bean.Student;


//������
public class TestDemo {

	/*
	 * ע��ķ�ʽ��ʵ��ʵ������
	 */
	@Test
	public void test01(){
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡDoctor��
		Doctor doctor=(Doctor)context.getBean("doctor");
		System.out.println(doctor);
	}
	
	//ע��ʵ��IOC����Ķ���
	@Test
	public void test02(){
		//�Լ��ķ�ʽ�����
		DoctorInstanceFactory dif1=new DoctorInstanceFactory();
		Doctor doctor1=dif1.getDoctor();
		
		
		//��ʼ��Spring����������xml�ļ�
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id��ȡDoctorInstanceFactory��
		DoctorInstanceFactory dif=(DoctorInstanceFactory)context.getBean("doctorInstanceFactory");
		System.out.println(dif);//com.lddx.bean.DoctorInstanceFactory@1e184cb
		Doctor doctor=dif.getDoctor();
		System.out.println(doctor);//com.lddx.bean.Doctor@d55986
	}
	
	
	/*
	 * Student���ʹ����ʾ
	 */
	@Test
	public void test03(){
		/*
		 * ��ʽ1���Լ��ķ�ʽ
		 */
		Student stu=new Student();
		stu.study();
		stu.sleep();
		/*
		 * ��ʽ2��ʹ��Spring����е�ע��
		 */
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		String str=(String)context.getBean("study");
		System.out.println(str);
	}
	
	/*
	 * Spring���ʵ�־�̬����
	 */
	@Test
	public void test04(){
		//�Լ��ķ�ʽʹ�þ�̬����
		//Doctor doctor1=DoctorStaticFactory.getDoctor();
		//System.out.println(doctor1);
		
		//DoctorStaticFactory dsf=new DoctorStaticFactory();
		//Doctor doctor11=dsf.getDoctor();
		//System.out.println(doctor11);
		
		//��ʼ��Spring����
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//�����ļ��ķ�ʽ
		//Doctor doctor2=(Doctor)context.getBean("doc2");
		//System.out.println(doctor2);
		
		//ע��ķ�ʽ
		//Doctor doctor3=(Doctor)context.getBean("gd");
		//System.out.println(doctor3);
	}
	
	
	
	
	
}
