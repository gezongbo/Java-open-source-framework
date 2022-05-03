package com.lddx.service;

import org.springframework.stereotype.Service;

@Service
public class ProdServiceImpl implements ProdService{

	@Override
	public void addProd() {
		System.out.println("新增商品...");
	}

	@Override
	public void delProd(int id) {
		System.out.println("删除商品...");
	}

}
