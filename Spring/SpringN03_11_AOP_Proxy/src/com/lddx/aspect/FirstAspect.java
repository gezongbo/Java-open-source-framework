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
	public void before(){
		System.out.println("��ǿ����...ǰ��֪ͨ...");
	}
	
	
}
