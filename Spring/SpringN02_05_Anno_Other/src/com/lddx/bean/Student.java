package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component    //id的默认推断规则：id="student"
//@Scope(value="prototype")
@Scope("singleton")    //默认，不写也是单例模式
@Lazy     //是懒加载，注解的默认值为true
//@Lazy(value=true)
//@Lazy(false)  //默认，不写和写false都是设置不懒加载
public class Student {
	//无参构造方法
	public Student(){
		System.out.println("Student无参构造");
	}
	
	@Bean(name="study")
	@Lazy
	public String study(){
		System.out.println("在学习...");
		return "张三";
	}
	
}
