package com.lddx.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//javabean规范
//new Cat()
//@Component   //id的默认推断规则：id="cat"
public class Cat {
	@Value("小汤姆")
	private String name;
	@Value("1")
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Cat() {
		super();
	}
	@Override
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}
	
}
