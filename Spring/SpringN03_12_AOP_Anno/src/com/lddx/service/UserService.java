package com.lddx.service;

import com.lddx.bean.User;

//ҵ����ʲ�Service��
public interface UserService {
	//��Dao��дһ��addUser���������ӵ����ݿ⣬�����ݿ�������ݵĲ���
	//��Service��дһ��addUser��������Ҫ����ҵ���ܣ������жϣ�ѭ����������ʲôҵ��ʲôҵ�����
	//�µ���Dao�㣬ʲô����²����õȵȡ�
	
	//public void addUser();
	//public void queryUser();   
	public User queryUser();
	//public void delUser();
	
}
