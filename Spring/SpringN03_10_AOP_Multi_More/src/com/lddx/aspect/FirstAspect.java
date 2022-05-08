package com.lddx.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.lddx.bean.User;

//�ҵĵ�һ�������࣬Ҳ������
//�ȼ�����applicationContext.xml�ļ��е�<bean id="firstAspect" class="com.lddx.aspect.FirstAspect"></bean>
@Component   //id��Ĭ���ƶϹ���id="firstAspect"
public class FirstAspect {

	//֪ͨ������Ҳ��֪ͨ����Ҫ��д��ǿ����ķ���
	public void before(JoinPoint jp){
		//��ȡĿ�����
		Object obj=jp.getTarget();
		Class clz=obj.getClass();
		//System.out.println(clz);
		
		
		//Ŀ�귽��
		MethodSignature ms=(MethodSignature)jp.getSignature();
		Method method=ms.getMethod();
		//System.out.println(method);
		
		System.out.println("First...ǰ��֪ͨ...");
	}
	
	
	//����һ������������ִ�л���֪ͨ�ķ��������鶨��ķ�������around
	/*
	 *   1������֪ͨ������ʾ����Ŀ�귽������������ã���Ŀ�귽����ִ�С�
	 *     ��ʾ����Ŀ�귽���Ķ�����ProceedingJoinPoint����JoinPoint���ӽӿ�
	 *   2������֪ͨ�������÷����ķ���ֵ����������ߣ�Web���UserServlet����ȡ����Ŀ�귽���ķ���ֵ
	 */
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("First...����֪ͨ...ǰ");
		Object obj=pjp.proceed();   //��ʾ����Ŀ�귽��
		System.out.println("First...����֪ͨ...��");
		return obj; //�������÷���ֵ���󣬵����Ų���������ȡ
	}
	
	
	//����һ������ִ֪ͨ�еķ���
	//�����ں���֪ͨ�л��Ŀ�귽���ķ���ֵ�����ԶԺ���֪ͨ��һ��Object���͵Ĳ��������գ��ò�����Ҫ����һ��
	public void afterReturning(JoinPoint jp,Object obj){
		//��ȡĿ�����
		Object o=jp.getTarget();
		Class clz=o.getClass();
		//System.out.println(clz);
		System.out.println("First...����֪ͨ..."+obj);
	}
	
	
	//����һ���쳣ִ֪ͨ�еķ�����ֻ����Ŀ�귽�������쳣ʱ�Ż�ִ���쳣֪ͨ
	public void afterThrowing(Throwable e){
		System.out.println("First...�쳣֪ͨ..."+e);
	}
	
	
	//����һ������ִ֪ͨ�еķ���
	public void after(){
		System.out.println("First...����֪ͨ...");
	}
	
}
