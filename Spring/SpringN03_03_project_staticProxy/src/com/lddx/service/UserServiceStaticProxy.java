package com.lddx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//该类是UserServiceImpl类的静态代理类
//UserServiceImpl实现了UserService接口，
//UserServiceStaticProxy也要实现UserService接口
//@Service  //相当于创建了UserServiceStaticProxy，id的默认值是id="userServiceStaticProxy"
@Service("userService")   //指定id为userService id="userService"
public class UserServiceStaticProxy implements UserService{

	//private UserServiceImpl userService=new UserServiceImpl();
	//面向接口编程，能够解耦合   解耦合的核心思想：接口+IOC+DI
	//private UserService userService=new UserServiceImpl();
	//使用使用Spring框架中的IOC+DI
	//IOC负责UserServiceImpl的创建，DI负责对userService赋值
	@Autowired
	@Qualifier("userServiceImpl")     //直接根据id进行查找，不根据类型查找了
	private UserService userService;
	
	@Override
	public void addUser() {
		System.out.println("#记录日志");
		System.out.println("#权限控制");
		System.out.println("#开启事务");
		userService.addUser();
		System.out.println("#提交事务");
	}

	@Override
	public void delUser() {
		System.out.println("#记录日志");
		System.out.println("#权限控制");
		System.out.println("#开启事务");
		userService.delUser();
		System.out.println("#提交事务");
	}

	@Override
	public void queryUser() {
		System.out.println("#记录日志");
		System.out.println("#权限控制");
		System.out.println("#开启事务");
		userService.queryUser();
		System.out.println("#提交事务");
	}

}
