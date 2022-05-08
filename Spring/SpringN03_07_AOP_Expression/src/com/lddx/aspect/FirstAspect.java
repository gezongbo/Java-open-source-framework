package com.lddx.aspect;

import org.springframework.stereotype.Component;

//我的第一个切面类，也叫切面
//等价于在applicationContext.xml文件中的<bean id="firstAspect" class="com.lddx.aspect.FirstAspect"></bean>
@Component   //id的默认推断规则，id="firstAspect"
public class FirstAspect {

	//通知方法，也叫通知，主要是写增强代码的方法
	public void before(){
		System.out.println("增强代码...first...before...");
	}
	
	
}
