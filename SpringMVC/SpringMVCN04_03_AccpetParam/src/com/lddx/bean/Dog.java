package com.lddx.bean;
//��  - javabean��
public class Dog {
	private String dname;  //С��������
	private int dage;   //С��������
	
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
