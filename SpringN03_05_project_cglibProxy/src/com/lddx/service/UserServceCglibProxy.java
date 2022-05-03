package com.lddx.service;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//cglib��̬����
@Component
public class UserServceCglibProxy {

	//�������Ը�ֵ��
	@Autowired
	@Qualifier("userServiceImpl")
	//userService=new UserServiceImpl();
	private UserService userService;
	
	@Bean(name="getProxy")
	public UserServiceImpl getProxy(){
		//ʹ��cglib��̬����
		//1��������ǿ��
		Enhancer enhancer=new Enhancer();
		//2��ָ��������Ҫʵ�ֵĽӿ�...
		enhancer.setInterfaces(userService.getClass().getInterfaces());
		//3��ǿ�ƣ�ָ������
		enhancer.setSuperclass(userService.getClass());
		//4��ָ���ص�����
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object arg0, Method method, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("��¼��־");
				System.out.println("����Ȩ��");
				System.out.println("��ʼ����");
				Object obj=method.invoke(userService, arg2);
				System.out.println("�ύ����");
				return obj;
			}
		});
		//5������������
		Object obj=enhancer.create();
		UserServiceImpl us=(UserServiceImpl)obj;
		return us;
	}
	
}
