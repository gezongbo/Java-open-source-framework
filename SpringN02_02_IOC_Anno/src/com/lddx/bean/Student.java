package com.lddx.bean;

import org.springframework.stereotype.Component;
//等价代码<bean id="student" class="com.lddx.bean.Student"></bean>
//id默认自动生成为id="student"
@Component
public class Student {
	
	public void study(){
		System.out.println("我在学习...");
	}
}
