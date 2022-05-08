package com.lddx.service.aaa.bbb;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public void addOrder() {
		System.out.println("新增订单...");
	}

	@Override
	public String queryOrder(int id) {
		System.out.println("查询订单...");
		return "abc";
	}

}
