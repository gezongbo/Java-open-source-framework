package com.lddx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lddx.service.OrderServiceImpl;
import com.lddx.service.ServiceImpl;
import com.lddx.service.UserServiceImpl;

//���Ʋ�Controller��
//���Ʋ�Web��
//�����Servlet�࣬������Servlet��Ҫ�̳�HttpServlet��
//Ҫ����doGet�ȷ�����Ҫ��web.xml���õģ��ȵ�
@Controller  //id="userServlet"
public class UserServlet{

	//��װ˽������
	//��Web�����UserServiceImpl
	//private UserServiceImpl serviceImpl=new UserServiceImpl();
	//private OrderServiceImpl serviceImpl=new OrderServiceImpl();
	//�����  �ӿ�+IOC+DI
	@Autowired
	private ServiceImpl serviceImpl;
	
	//��װһ������
	//˵�������UserServlet��һ��������Servlet�࣬�η���Ӧ����
	//doGet  doPost����service������
	public void addUserServlet(){
		//��Web�����Service���
		serviceImpl.addUserService();
	}
	
}
