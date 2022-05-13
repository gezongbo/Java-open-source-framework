package com.lddx.bean;

public class User1 {

	//ÀΩ”– Ù–‘
	private String name;
	private int age;
	private String like;
	
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
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public User1(String name, int age, String like) {
		super();
		this.name = name;
		this.age = age;
		this.like = like;
	}
	public User1() {
		super();
	}
	@Override
	public String toString() {
		return "User1 [age=" + age + ", like=" + like + ", name=" + name + "]";
	}
	
	
}
