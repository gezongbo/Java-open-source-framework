package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component    //id��Ĭ���ƶϹ���id="student"
//@Scope(value="prototype")
@Scope("singleton")    //Ĭ�ϣ���дҲ�ǵ���ģʽ
@Lazy     //�������أ�ע���Ĭ��ֵΪtrue
//@Lazy(value=true)
//@Lazy(false)  //Ĭ�ϣ���д��дfalse�������ò�������
public class Student {
	//�޲ι��췽��
	public Student(){
		System.out.println("Student�޲ι���");
	}
	
	@Bean(name="study")
	@Lazy
	public String study(){
		System.out.println("��ѧϰ...");
		return "����";
	}
	
}
