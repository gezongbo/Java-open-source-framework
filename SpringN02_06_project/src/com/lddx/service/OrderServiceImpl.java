package com.lddx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lddx.dao.UserDao;

//ģ�Ͳ�Model��
//ҵ����ʲ�Service��
@Service()
public class OrderServiceImpl implements ServiceImpl{

	
	@Override
	public void addUserService() {
		System.out.println("OrderServiceImpl...");
	}

}
