package com.lddx.bean;
//�û�--javabean�࣬��javabean�л��������javabean��
public class User3 {
	private String name;  //�û�������
	private int age; //�û�������
	private String like;  //�û�����Ȥ����
	//����Dog�ࣨjavabean�ࣩ
	private Dog dog;  //С������
	
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
