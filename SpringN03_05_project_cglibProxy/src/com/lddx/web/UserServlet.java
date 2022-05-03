package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.lddx.service.UserService;
import com.lddx.service.UserServiceImpl;

//控制层Web层（真是开发中该类应该是一个Servlet类，现在使用一个普通的类模拟）
@Controller   //id默认推断规则id="userServlet"
public class UserServlet {

	//在Web层调用执行Service层的代码
	//面向接口编程（解耦合）
	@Autowired
	//@Qualifier("userServiceJavaProxy") //直接根据id查找的
	@Qualifier("getProxy")
	//默认：先通过UserService类型查找，找到了1个，只能找到UserServiceImpl类，我们想访问的是java的动态代理类UserServiceJavaProxy
	//private UserService userService;
	private UserServiceImpl userService;
	/*
	 *   方案1：创建UserServiceJavaProxy类，然后给userService属性赋值
	 *   UserServiceJavaProxy javaProxy=new UserServiceJavaProxy();
	 *   userService=javaProxy;   类型不匹配
	 *   方案1行不通
	 *   方案2：直接通过id查找UserServiceJavaProxy类中的方法
	 *   根据@Qualifier中getProxy查找哪个@Bean的name也为getProxy
	 *   UserService us=getProxy();
	 *   userService=us;  ok 类型一致
	 *   方案2行得通
	 */
	
	public void addUserServlet(){
		userService.addUser();
		userService.delUser();
		userService.queryUser();
		userService.test();
		userService.test1();
		
	}
	
}
