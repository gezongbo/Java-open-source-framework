package com.lddx.aspect;

import org.springframework.stereotype.Component;

//�ҵĵ�һ�������࣬Ҳ������
//�ȼ�����applicationContext.xml�ļ��е�<bean id="firstAspect" class="com.lddx.aspect.FirstAspect"></bean>
@Component   //id��Ĭ���ƶϹ���id="firstAspect"
public class FirstAspect {

	//֪ͨ������Ҳ��֪ͨ����Ҫ��д��ǿ����ķ���
	public void before(){
		System.out.println("��ǿ����...first...before...");
	}
	
	
}
