package com.lddx.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//java动态代理
@Component       //该类被SPring中的IOC管理，默认id="userServiceJavaProxy"
public class UserServiceJavaProxy {

	/*
	 *  @Service注解的底层实现
	 * 	UserServiceImpl impl=new UserServiceImpl()  
		Map.put("userServiceImpl",impl);    impl-->UserService
		@Bean注解的底层实现
		UserService us=getProxy()
		Map.put("getProxy",us)  us-->UserService
	 */
	//底层：创建new UserServiceImpl,然后给userService赋值
	@Autowired
	@Qualifier("userServiceImpl")  //直接根据id查找
	private UserService userService;
	
	//定义一个获取UserService对象的一个方法
	//该方法的作用是java中的Proxy功能实现，实际上该方法可以理解为一个经纪公司的行为
	@Bean(name="getProxy")
	public UserService getProxy(){
		//Object obj=Proxy.newProxyInstance(userService.getClass().getClassLoader(), 
		UserService us=(UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), 
				userService.getClass().getInterfaces(), new InvocationHandler(){
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("#记录日志");
						System.out.println("#控制权限");
						System.out.println("#开启事务");
						Object obj=method.invoke(userService, args);
						System.out.println("#提交事务");
						return obj;
					}
		});
		//UserService us=(UserService)obj;
		return us;
	}
	
	
}
