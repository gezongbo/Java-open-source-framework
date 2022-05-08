package com.lddx.dao;

import org.springframework.stereotype.Repository;

//模型层Model层
//数据访问层Dao层：直接连接数据库进行数据的操作
//是UserDao接口的子类
/*
 * Spring框架的底层：  MySqlUserDao mud=new MySqlUserDao();
 *                Map.put("mySqlUserDao",mud);
 *                Map.put("userDao",mud);
 */
@Repository("userDao")   //默认id="mySqlUserDao"
public class MySqlUserDao implements UserDao{
	//模拟的方法：连接mysql数据库进行User信息的插入操作
	public void addUser(){
		//获得数据库的连接、预编译sql，insert...，执行sql...
		System.out.println("MySql...addUser...");
	}

}
