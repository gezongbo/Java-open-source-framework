package com.lddx.bean;
//用户--javabean类，此javabean中会包含其它javabean类
public class User3 {
	private String name;  //用户的姓名
	private int age; //用户的年龄
	private String like;  //用户的兴趣爱好
	//包含Dog类（javabean类）
	private Dog dog;  //小狗对象
	
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
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public User3(String name, int age, String like, Dog dog) {
		super();
		this.name = name;
		this.age = age;
		this.like = like;
		this.dog = dog;
	}
	public User3() {
		super();
	}
	@Override
	public String toString() {
		return "User3 [age=" + age + ", dog=" + dog + ", like=" + like
				+ ", name=" + name + "]";
	}
	
	
}
