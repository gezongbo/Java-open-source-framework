package com.lddx.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//javabean¹æ·¶     
@Component  //Ä¬ÈÏid   id="person"
public class Person {
	@Value("#{@mylist}")
	private List<String> list;
	@Value("#{@myset}")
	private Set<String> set;
	@Value("#{@mymap}")
	private Map<String,String> map;
	@Value("#{@myprop}")
	private Properties prop;
	
	
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
	public Person(List<String> list, Set<String> set, Map<String, String> map,
			Properties prop) {
		super();
		this.list = list;
		this.set = set;
		this.map = map;
		this.prop = prop;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [list=" + list + ", map=" + map + ", prop=" + prop
				+ ", set=" + set + "]";
	}
	
	
}
