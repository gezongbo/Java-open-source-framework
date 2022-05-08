package com.lddx.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//第二个切面类
@Component      //ioc容器管理SecondAspect
@Aspect         //AOP管理切面
@Order(1)       //配置切面类的执行顺序
public class SecondAspect {
	
	@Before("within(com.lddx.service.*)")
	public void before(){
		System.out.println("第二个切面类...前置通知");
	}
}
