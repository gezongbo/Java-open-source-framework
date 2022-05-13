package com.lddx.bean;

public class User2 {
	private String name;
	private int age;
	private String like;
	private String dname;
	private int dage;
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
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDage() {
		return dage;
	}
	public void setDage(int dage) {
		this.dage = dage;
	}
	public User2(String name, int age, String like, String dname, int dage) {
		super();
		this.name = name;
		this.age = age;
		this.like = like;
		this.dname = dname;
		this.dage = dage;
	}
	public User2() {
		super();
	}
	@Override
	public String toString() {
		return "User2 [age=" + age + ", dage=" + dage + ", dname=" + dname
				+ ", like=" + like + ", name=" + name + "]";
	}
	
	
}
