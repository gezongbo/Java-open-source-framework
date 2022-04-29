package com.lddx.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//演示注解的方式实现DI
//javabean规范
//@Component("hero")
@Component    //默认id="hero"
public class Hero {
	
	//使用注解的方式实现DI，来实现对属性的依赖注入
	@Value(value="张三")
	private String name;
	@Value("30")
	private int age;
	//包含其它的javabean类
	//自动装配的注解
	//Cat类演示的是配置文件的方式实现自动装配的实现原理
	@Autowired
	private Cat cat;
	//Dog类演示的是注解的方式实现自动装配的实现原理
	@Autowired
	@Qualifier("JMDog")    //直接根据id为JMDog去匹配查找
	private Dog dog;
	
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
	
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	
	public Hero(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Hero() {
		super();
	}
	public Hero(String name, int age, Cat cat) {
		super();
		this.name = name;
		this.age = age;
		this.cat = cat;
	}
	public Hero(String name, int age, Cat cat, Dog dog) {
		super();
		this.name = name;
		this.age = age;
		this.cat = cat;
		this.dog = dog;
	}
	@Override
	public String toString() {
		return "Hero [age=" + age + ", cat=" + cat + ", dog=" + dog + ", name="
				+ name + "]";
	}
	


	
	
	
}
