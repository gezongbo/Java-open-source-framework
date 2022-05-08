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

//我的第一个切面类，也叫切面
//等价于在applicationContext.xml文件中的<bean id="firstAspect" class="com.lddx.aspect.FirstAspect"></bean>
@Component   //id的默认推断规则，id="firstAspect"
@Aspect   //等价于<aop:aspect ref="firstAspect"> 
@Order(2)
public class FirstAspect {
	//随便定义一个方法
	//<aop:pointcut expression="execution(* com.lddx.service..*.*(..))" id="mypc"/>
	//id=mx
	@Pointcut("execution(* com.lddx.service..*.*(..))")
	public void mx(){     
		
	}
	//通知方法，也叫通知，主要是写增强代码的方法
	//@Before注解中value属性赋值的是切入点表达式 within、execution
	//<aop:before method="before" pointcut="execution(* com.lddx.service..*.*(..))" /> 
	//@Before(value="within(com.lddx.service.UserServiceImpl)")
	@Before("mx()")
	public void before(){
		System.out.println("增强代码...前置通知...");
	}
	//环绕通知
	//@Around("execution(* com.lddx.service..*.*(..))")
	@Around("mx()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕前...");
		Object obj=pjp.proceed();
		System.out.println("环绕后...");
		return obj;
	}
	//后置通知
	//<aop:after-returning method="afterReturning" pointcut-ref="mypc" returning="obj"/>s
	@AfterReturning(value="mx()",returning="obj")
	public void afterReturning(Object obj){
		System.out.println("后置通知..."+obj);
	}
	//最终通知
	@After("mx()")
	public void after(){
		System.out.println("最终通知...");
	}
	//异常通知
	//<aop:after-throwing method="afterThrowing" pointcut-ref="mypc" throwing="e"/>
	@AfterThrowing(value="mx()",throwing="ee")
	public void afterThrowing(Throwable ee){
		System.out.println("异常通知..."+ee);
	}
	
	
	
	
	
	
	
}
