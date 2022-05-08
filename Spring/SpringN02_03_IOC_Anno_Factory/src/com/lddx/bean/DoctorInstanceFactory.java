package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//Doctor���ʵ������
//��ע��ȼ���<bean id="dif" class="com.lddx.bean.DoctorInstanceFactory"></bean>
//�ײ��൱��ִ�У�DoctorInstanceFactory  dif=new DoctorInstanceFactory()
/*
 * �ײ㣺DoctorInstanceFactory dif=new DoctorInstanceFactory();
 *     Map.put("doctorInstanceFactory",dif);
 */
@Component
public class DoctorInstanceFactory {
	//����޲ι���
	public DoctorInstanceFactory() {
		//System.out.println("DoctorInstanceFactory����޲ι��졣����");
	}

	//�ṩ���Ƿ�static����
	//��ע��ȼ���<bean id="doctor" factory-bean="dif" factory-method="getDoctor"></bean>
	//name=""�ȼ������ļ��е�id=""
	/*
	 * �ײ㣺Map.get("doctorInstanceFactory")-->DoctorInstanceFactory dif;
	 *     Doctor d=dif.getDoctor();
	 *     Map.put("doctor",d);
	 */
	@Bean(name="doctor")
	public Doctor getDoctor(){
		//System.out.println("��ȡҽ������ķ���ִ��.....");
		Doctor d=new Doctor("����");
		return d;
	}
	
}
