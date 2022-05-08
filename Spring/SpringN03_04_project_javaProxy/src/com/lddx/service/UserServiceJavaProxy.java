package com.lddx.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//java��̬����
@Component       //���౻SPring�е�IOC����Ĭ��id="userServiceJavaProxy"
public class UserServiceJavaProxy {

	/*
	 *  @Serviceע��ĵײ�ʵ��
	 * 	UserServiceImpl impl=new UserServiceImpl()  
		Map.put("userServiceImpl",impl);    impl-->UserService
		@Beanע��ĵײ�ʵ��
		UserService us=getProxy()
		Map.put("getProxy",us)  us-->UserService
	 */
	//�ײ㣺����new UserServiceImpl,Ȼ���userService��ֵ
	@Autowired
	@Qualifier("userServiceImpl")  //ֱ�Ӹ���id����
	private UserService userService;
	
	//����һ����ȡUserService�����һ������
	//�÷�����������java�е�Proxy����ʵ�֣�ʵ���ϸ÷����������Ϊһ�����͹�˾����Ϊ
	@Bean(name="getProxy")
	public UserService getProxy(){
		//Object obj=Proxy.newProxyInstance(userService.getClass().getClassLoader(), 
		UserService us=(UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), 
				userService.getClass().getInterfaces(), new InvocationHandler(){
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("#��¼��־");
						System.out.println("#����Ȩ��");
						System.out.println("#��������");
						Object obj=method.invoke(userService, args);
						System.out.println("#�ύ����");
						return obj;
					}
		});
		//UserService us=(UserService)obj;
		return us;
	}
	
	
}
