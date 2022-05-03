package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lddx.service.UserService;

//控制层Web层（真是开发中该类应该是一个Servlet类，现在使用一个普通的类模拟）
@Controller   //id默认推断规则id="userServlet"
public class UserServlet {

	//在Web层调用执行Service层的代码
	//面向接口编程（解耦合）
	@Autowired
	//先通过UserService类型查找，找到了两个，分别是UserServiceImpl和UserServiceStaticProxy
	//在通过属性userSercice去匹配id的值，只找到了一个，是UserServiceStaticProxy
	//底层UserServiceStaticProxy userService/zl=new UserServiceStaticProxy()
	private UserService userService;
	
	public void addUserServlet(){
		userService.addUser();
		userService.delUser();
		userService.queryUser();
	}
	
}
