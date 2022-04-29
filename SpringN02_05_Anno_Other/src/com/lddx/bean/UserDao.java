package com.lddx.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component  //idĬ��������� id="userDao"
public class UserDao {
	//Spring������ʼ����ִ��ִ�и÷���
	@PostConstruct
	public void myInit(){
		System.out.println("��ʼ������....");
	}
	
	//Spring�������ٵ�ʱ��÷���
	@PreDestroy
	public void myDestory(){
		System.out.println("����....");
	}
}
