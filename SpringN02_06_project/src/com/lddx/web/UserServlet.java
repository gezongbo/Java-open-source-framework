package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lddx.service.OrderServiceImpl;
import com.lddx.service.ServiceImpl;
import com.lddx.service.UserServiceImpl;

//控制层Controller层
//控制层Web层
//假设的Servlet类，正常的Servlet是要继承HttpServlet，
//要调用doGet等方法，要在web.xml配置的，等等
@Controller  //id="userServlet"
public class UserServlet{

	//封装私有属性
	//在Web层调用UserServiceImpl
	//private UserServiceImpl serviceImpl=new UserServiceImpl();
	//private OrderServiceImpl serviceImpl=new OrderServiceImpl();
	//解耦合  接口+IOC+DI
	@Autowired
	private ServiceImpl serviceImpl;
	
	//封装一个方法
	//说明：如果UserServlet是一个真正的Servlet类，次方法应该是
	//doGet  doPost或者service方法。
	public void addUserServlet(){
		//在Web层调用Service层的
		serviceImpl.addUserService();
	}
	
}
