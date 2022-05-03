package com.lddx.service;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//cglib动态代理
@Component
public class UserServceCglibProxy {

	//给该属性赋值的
	@Autowired
	@Qualifier("userServiceImpl")
	//userService=new UserServiceImpl();
	private UserService userService;
	
	@Bean(name="getProxy")
	public UserServiceImpl getProxy(){
		//使用cglib动态代理
		//1、创建增强器
		Enhancer enhancer=new Enhancer();
		//2、指定代理者要实现的接口...
		enhancer.setInterfaces(userService.getClass().getInterfaces());
		//3、强制，指定父类
		enhancer.setSuperclass(userService.getClass());
		//4、指定回调函数
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object arg0, Method method, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("记录日志");
				System.out.println("控制权限");
				System.out.println("开始事务");
				Object obj=method.invoke(userService, arg2);
				System.out.println("提交事务");
				return obj;
			}
		});
		//5、创建代理者
		Object obj=enhancer.create();
		UserServiceImpl us=(UserServiceImpl)obj;
		return us;
	}
	
}
