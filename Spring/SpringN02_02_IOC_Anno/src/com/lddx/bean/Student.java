package com.lddx.bean;

import org.springframework.stereotype.Component;
//�ȼ۴���<bean id="student" class="com.lddx.bean.Student"></bean>
//idĬ���Զ�����Ϊid="student"
@Component
public class Student {
	
	public void study(){
		System.out.println("����ѧϰ...");
	}
}
