package com.lddx.bean;
//javabean规范
public class Teacher {
	private String name;  //姓名
	private int age;   //年龄
	private String address;  //地址
	private String email;  //邮箱
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Teacher(String name, int age, String address, String email) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [address=" + address + ", age=" + age + ", email="
				+ email + ", name=" + name + "]";
	}
	
	
	
	
	
}
