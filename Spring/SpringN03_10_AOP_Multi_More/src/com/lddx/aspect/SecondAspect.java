package com.lddx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//第二个切面类
@Component   //默认id="secondAspect"
public class SecondAspect {

	//前置通知
	public void before(){
		System.out.println("Second...前置通知");
	}
	
	//环绕通知
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Second...环绕通知前");
		pjp.proceed();
		System.out.println("Second...环绕通知后");
	}
	
	//后置通知
	public void afterReturning(){
		System.out.println("Second...后置通知");
	}
	
	//最终通知
	public void after(){
		System.out.println("Second...最终通知");
	}
	
	
}
