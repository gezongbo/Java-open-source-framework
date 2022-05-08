package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//Doctor类的静态工厂
@Component
public class DoctorStaticFactory {
	//无参构造方法
	public DoctorStaticFactory(){
		System.out.println("无参构造....");
	}
	
	//定义一个静态方法
	@Bean(name="gd")
	public static Doctor getDoctor(){
		System.out.println("李四");
		Doctor d=new Doctor("李四");
		return d;
	}
	
}
