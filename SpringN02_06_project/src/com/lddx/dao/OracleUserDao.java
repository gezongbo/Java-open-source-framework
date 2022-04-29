package com.lddx.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//ģ�Ͳ�Model��
//���ݷ��ʲ�Dao��
//��UserDao�ӿڵ�����
/*
 * Spring�ײ㣺OracleUserDao oud=new OracleUserDao();
 *           Map.put("oracleUserDao",oud);
 *  �����ļ��ķ�ʽ�ȼ�д����<bean id="oracleUserDao" class="com.lddx.dao.OracleUserDao"></bean>
 *  
 */
//@Component   //Ĭ��id���ƶ�  id="oracleUserDao"   ͨ��ע��
@Repository()    //Dao��ע�����ר��ע��
public class OracleUserDao implements UserDao{
	//ģ��ķ���������Oracle���ݿ����User��Ϣ�Ĳ������
	public void addUser(){
		//������ݿ������.....
		System.out.println("Oracle...addUser...");
	}

}
