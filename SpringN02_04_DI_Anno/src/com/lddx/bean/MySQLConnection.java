package com.lddx.bean;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//javabean规范
//@Component    //默认id的推断规则：id="mySQLConnection"
@Component("mysqlCon")   //指定了id="mysqlCon"
public class MySQLConnection {
	
	//@Value("com.mysql.jdbc.Driver")
	@Value("${jarName}") 
	private String driverName;
	//@Value("jdbc:mysql://localhost:3306/test")
	@Value("${strurl}")
	private String url;
	//@Value("root")
	@Value("${strusername}")
	private String name;
	//@Value("abc123")
	@Value("${strpassword}")
	private String password;
	
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MySQLConnection(String driverName, String url, String name,
			String password) {
		super();
		this.driverName = driverName;
		this.url = url;
		this.name = name;
		this.password = password;
	}
	public MySQLConnection() {
		super();
	}
	@Override
	public String toString() {
		return "MySQLConnection [driverName=" + driverName + ", name=" + name
				+ ", password=" + password + ", url=" + url + "]";
	}
	
	
	
}
