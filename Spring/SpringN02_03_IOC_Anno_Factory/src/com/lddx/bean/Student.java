package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Student {
	//�޲ι���
	public Student(){
		//System.out.println("Student����޲ι���");
	}
	//����==����
	//private String name;
	//...
	
	
	//��Ϊ==����
	@Bean(name="study")
	public String study(){
		//System.out.println("�ú�ѧϰ��������");
		return "abc";
	}
	
	@Bean(name="sleep")
	public String sleep(){
		//System.out.println("����˯������˯...");
		return "123456";
	}
	
}
