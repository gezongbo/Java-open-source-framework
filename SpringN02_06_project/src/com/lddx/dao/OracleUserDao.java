package com.lddx.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//模型层Model层
//数据访问层Dao层
//是UserDao接口的子类
/*
 * Spring底层：OracleUserDao oud=new OracleUserDao();
 *           Map.put("oracleUserDao",oud);
 *  配置文件的方式等价写法：<bean id="oracleUserDao" class="com.lddx.dao.OracleUserDao"></bean>
 *  
 */
//@Component   //默认id的推断  id="oracleUserDao"   通用注解
@Repository()    //Dao层注解类的专用注解
public class OracleUserDao implements UserDao{
	//模拟的方法：连接Oracle数据库进行User信息的插入操作
	public void addUser(){
		//获得数据库的连接.....
		System.out.println("Oracle...addUser...");
	}

}
