package com.lddx.bean;

import org.springframework.stereotype.Component;

//�������valueֵ������id��Ĭ���������id="doctor"
//�����valueֵ������ָ����id���л�ȡ
//@Component(value="doct")
/*
 * �ײ㣻Doctor d=new Doctor();
 *     Map.put("doct",d);
 */
@Component("doct")
public class Doctor {

	public Doctor(String name) {
		
	}
}
