package com.lddx.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//�ڶ���������
@Component      //ioc��������SecondAspect
@Aspect         //AOP��������
@Order(1)       //�����������ִ��˳��
public class SecondAspect {
	
	@Before("within(com.lddx.service.*)")
	public void before(){
		System.out.println("�ڶ���������...ǰ��֪ͨ");
	}
}
