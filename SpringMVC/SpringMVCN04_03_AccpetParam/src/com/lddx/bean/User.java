package com.lddx.bean;
//javabean��
public class User {
	//˽������
	private String uname; //����
	private int uage;  //����
	private String ulike;  //����
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUlike() {
		return ulike;
	}
	public void setUlike(String ulike) {
		this.ulike = ulike;
	}
	public User(String uname, int uage, String ulike) {
		super();
		this.uname = uname;
		this.uage = uage;
		this.ulike = ulike;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [uage=" + uage + ", ulike=" + ulike + ", uname=" + uname
				+ "]";
	}
	
	
	
}
