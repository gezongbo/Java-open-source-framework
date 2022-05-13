package com.lddx.bean;
//狗  - javabean类
public class Dog {
	private String dname;  //小狗的名字
	private int dage;   //小狗的年龄
	
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
	public Dog(String dname, int dage) {
		super();
		this.dname = dname;
		this.dage = dage;
	}
	public Dog() {
		super();
	}
	@Override
	public String toString() {
		return "Dog [dage=" + dage + ", dname=" + dname + "]";
	}
	
}
