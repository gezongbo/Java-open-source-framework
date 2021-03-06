package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lddx.service.ProdService;
import com.lddx.service.ProdServiceImpl;
import com.lddx.service.UserService;
import com.lddx.service.aaa.bbb.OrderService;

//控制层Web层（真是开发中该类应该是一个Servlet类，现在使用一个普通的类模拟）
@Controller   //id默认推断规则id="userServlet"
public class UserServlet {

	//在Web层调用执行Service层的代码
	//面向接口编程（解耦合）
	@Autowired
	private UserService userService;
	@Autowired
	private ProdService prodService;
	@Autowired
	private OrderService orderService;
	
	public void addUserServlet(){
		userService.addUser();
		userService.delUser();
		userService.queryUser();
		
		prodService.addProd();
		prodService.delProd(3);
		
		orderService.addOrder();
		orderService.queryOrder(6);
	}
	
}
