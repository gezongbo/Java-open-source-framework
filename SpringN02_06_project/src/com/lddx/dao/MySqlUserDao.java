package com.lddx.dao;

import org.springframework.stereotype.Repository;

//ģ�Ͳ�Model��
//���ݷ��ʲ�Dao�㣺ֱ���������ݿ�������ݵĲ���
//��UserDao�ӿڵ�����
/*
 * Spring��ܵĵײ㣺  MySqlUserDao mud=new MySqlUserDao();
 *                Map.put("mySqlUserDao",mud);
 *                Map.put("userDao",mud);
 */
@Repository("userDao")   //Ĭ��id="mySqlUserDao"
public class MySqlUserDao implements UserDao{
	//ģ��ķ���������mysql���ݿ����User��Ϣ�Ĳ������
	public void addUser(){
		//������ݿ�����ӡ�Ԥ����sql��insert...��ִ��sql...
		System.out.println("MySql...addUser...");
	}

}
