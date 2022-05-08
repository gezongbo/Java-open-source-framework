package com.lddx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lddx.dao.UserDao;

//模型层Model层
//业务访问层Service层
@Service()
public class OrderServiceImpl implements ServiceImpl{

	
	@Override
	public void addUserService() {
		System.out.println("OrderServiceImpl...");
	}

}
