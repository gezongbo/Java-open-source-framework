package com.lddx.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.lddx.bean.User;

//我的第一个切面类，也叫切面
//等价于在applicationContext.xml文件中的<bean id="firstAspect" class="com.lddx.aspect.FirstAspect"></bean>
@Component   //id的默认推断规则，id="firstAspect"
public class FirstAspect {

	//通知方法，也叫通知，主要是写增强代码的方法
	public void before(JoinPoint jp){
		//获取目标对象
		Object obj=jp.getTarget();
		Class clz=obj.getClass();
		//System.out.println(clz);
		
		
		//目标方法
		MethodSignature ms=(MethodSignature)jp.getSignature();
		Method method=ms.getMethod();
		//System.out.println(method);
		
		System.out.println("First...前置通知...");
	}
	
	
	//定义一个方法，用于执行环绕通知的方法，建议定义的方法名叫around
	/*
	 *   1、环绕通知必须显示调用目标方法，如果不调用，则目标方法不执行。
	 *     显示调用目标方法的对象是ProceedingJoinPoint，是JoinPoint的子接口
	 *   2、环绕通知必须设置方法的返回值，否则调用者（Web层的UserServlet）获取不到目标方法的返回值
	 */
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("First...环绕通知...前");
		Object obj=pjp.proceed();   //显示调用目标方法
		System.out.println("First...环绕通知...后");
		return obj; //必须设置返回值对象，调用着才能正常获取
	}
	
	
	//定义一个后置通知执行的方法
	//可以在后置通知中获得目标方法的返回值，可以对后置通知加一个Object类型的参数来接收，该参数需要配置一下
	public void afterReturning(JoinPoint jp,Object obj){
		//获取目标对象
		Object o=jp.getTarget();
		Class clz=o.getClass();
		//System.out.println(clz);
		System.out.println("First...后置通知..."+obj);
	}
	
	
	//定义一个异常通知执行的方法：只有在目标方法出现异常时才会执行异常通知
	public void afterThrowing(Throwable e){
		System.out.println("First...异常通知..."+e);
	}
	
	
	//定义一个最终通知执行的方法
	public void after(){
		System.out.println("First...最终通知...");
	}
	
}
