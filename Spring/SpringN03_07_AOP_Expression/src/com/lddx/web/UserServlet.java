package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lddx.service.ProdService;
import com.lddx.service.ProdServiceImpl;
import com.lddx.service.UserService;
import com.lddx.service.aaa.bbb.OrderService;

//���Ʋ�Web�㣨���ǿ����и���Ӧ����һ��Servlet�࣬����ʹ��һ����ͨ����ģ�⣩
@Controller   //idĬ���ƶϹ���id="userServlet"
public class UserServlet {

	//��Web�����ִ��Service��Ĵ���
	//����ӿڱ�̣�����ϣ�
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
