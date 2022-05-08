package com.lddx.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
//演示配置文件的方式DI
//符合javabean规范：私有属性、构造方法、setget方法、toString方法
public class Teacher {
	
	private String name;
	private int age;
	private List<String> list;
	private Set<String> set;
	private Map<String,String> map;
	private Properties prop;
	//包含其它javabean类的情况
	private Cat cat;
	
	
	
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
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	public Teacher(String name, int age, List<String> list, Set<String> set,
			Map<String, String> map, Properties prop) {
		super();
		this.name = name;
		this.age = age;
		this.list = list;
		this.set = set;
		this.map = map;
		this.prop = prop;
	}
	public Teacher() {
		super();
	}

	public Teacher(String name, int age, List<String> list, Set<String> set,
			Map<String, String> map, Properties prop, Cat cat) {
		super();
		this.name = name;
		this.age = age;
		this.list = list;
		this.set = set;
		this.map = map;
		this.prop = prop;
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Teacher [age=" + age + ", cat=" + cat + ", list=" + list
				+ ", map=" + map + ", name=" + name + ", prop=" + prop
				+ ", set=" + set + "]";
	}

	
	
}
