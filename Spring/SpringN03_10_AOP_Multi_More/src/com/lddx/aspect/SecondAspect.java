package com.lddx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//�ڶ���������
@Component   //Ĭ��id="secondAspect"
public class SecondAspect {

	//ǰ��֪ͨ
	public void before(){
		System.out.println("Second...ǰ��֪ͨ");
	}
	
	//����֪ͨ
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Second...����֪ͨǰ");
		pjp.proceed();
		System.out.println("Second...����֪ͨ��");
	}
	
	//����֪ͨ
	public void afterReturning(){
		System.out.println("Second...����֪ͨ");
	}
	
	//����֪ͨ
	public void after(){
		System.out.println("Second...����֪ͨ");
	}
	
	
}
