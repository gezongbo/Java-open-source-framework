package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Student {
	//无参构造
	public Student(){
		//System.out.println("Student类的无参构造");
	}
	//特征==属性
	//private String name;
	//...
	
	
	//行为==方法
	@Bean(name="study")
	public String study(){
		//System.out.println("好好学习天天向上");
		return "abc";
	}
	
	@Bean(name="sleep")
	public String sleep(){
		//System.out.println("白天睡，晚上睡...");
		return "123456";
	}
	
}
