package com.lddx.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//��ʾע��ķ�ʽʵ��DI
//javabean�淶
//@Component("hero")
@Component    //Ĭ��id="hero"
public class Hero {
	
	//ʹ��ע��ķ�ʽʵ��DI����ʵ�ֶ����Ե�����ע��
	@Value(value="����")
	private String name;
	@Value("30")
	private int age;
	//����������javabean��
	//�Զ�װ���ע��
	//Cat����ʾ���������ļ��ķ�ʽʵ���Զ�װ���ʵ��ԭ��
	@Autowired
	private Cat cat;
	//Dog����ʾ����ע��ķ�ʽʵ���Զ�װ���ʵ��ԭ��
	@Autowired
	@Qualifier("JMDog")    //ֱ�Ӹ���idΪJMDogȥƥ�����
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
