package com.lddx.service.aaa.bbb;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public void addOrder() {
		System.out.println("��������...");
	}

	@Override
	public String queryOrder(int id) {
		System.out.println("��ѯ����...");
		return "abc";
	}

}
