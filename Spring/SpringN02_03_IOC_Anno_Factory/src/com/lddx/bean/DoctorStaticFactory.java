package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//Doctor��ľ�̬����
@Component
public class DoctorStaticFactory {
	//�޲ι��췽��
	public DoctorStaticFactory(){
		System.out.println("�޲ι���....");
	}
	
	//����һ����̬����
	@Bean(name="gd")
	public static Doctor getDoctor(){
		System.out.println("����");
		Doctor d=new Doctor("����");
		return d;
	}
	
}
