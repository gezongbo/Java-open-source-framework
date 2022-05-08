package com.lddx.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Component  //idĬ��������� id="userDao"
//@Controller
@Service
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
