package com.lddx.bean;

import org.springframework.stereotype.Component;

//此注解的效果等同于<bean id="person" class="com.lddx.bean.Person"></bean>
//此注解会为当前配置的javabean类默认生成一个id值，为id="person"
/*
 * 底层：Person p=new Person();
 *     Map.put("person",p);
 */
@Component   
public class Person {
	
	public void eat(){
		System.out.println("吃...");
	}
	public void say(){
		System.out.println("说...");
	}
}
