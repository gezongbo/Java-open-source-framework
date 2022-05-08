package com.lddx.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lddx.bean.User;

//�ҵĵ�һ�������࣬Ҳ������
//�ȼ�����applicationContext.xml�ļ��е�<bean id="firstAspect" class="com.lddx.aspect.FirstAspect"></bean>
@Component   //id��Ĭ���ƶϹ���id="firstAspect"
@Aspect   //�ȼ���<aop:aspect ref="firstAspect"> 
@Order(2)
public class FirstAspect {
	//��㶨��һ������
	//<aop:pointcut expression="execution(* com.lddx.service..*.*(..))" id="mypc"/>
	//id=mx
	@Pointcut("execution(* com.lddx.service..*.*(..))")
	public void mx(){     
		
	}
	//֪ͨ������Ҳ��֪ͨ����Ҫ��д��ǿ����ķ���
	//@Beforeע����value���Ը�ֵ�����������ʽ within��execution
	//<aop:before method="before" pointcut="execution(* com.lddx.service..*.*(..))" /> 
	//@Before(value="within(com.lddx.service.UserServiceImpl)")
	@Before("mx()")
	public void before(){
		System.out.println("��ǿ����...ǰ��֪ͨ...");
	}
	//����֪ͨ
	//@Around("execution(* com.lddx.service..*.*(..))")
	@Around("mx()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("����ǰ...");
		Object obj=pjp.proceed();
		System.out.println("���ƺ�...");
		return obj;
	}
	//����֪ͨ
	//<aop:after-returning method="afterReturning" pointcut-ref="mypc" returning="obj"/>s
	@AfterReturning(value="mx()",returning="obj")
	public void afterReturning(Object obj){
		System.out.println("����֪ͨ..."+obj);
	}
	//����֪ͨ
	@After("mx()")
	public void after(){
		System.out.println("����֪ͨ...");
	}
	//�쳣֪ͨ
	//<aop:after-throwing method="afterThrowing" pointcut-ref="mypc" throwing="e"/>
	@AfterThrowing(value="mx()",throwing="ee")
	public void afterThrowing(Throwable ee){
		System.out.println("�쳣֪ͨ..."+ee);
	}
	
	
	
	
	
	
	
}
