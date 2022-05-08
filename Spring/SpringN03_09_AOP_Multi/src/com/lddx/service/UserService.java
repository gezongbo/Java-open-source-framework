package com.lddx.service;

import com.lddx.bean.User;

//业务访问层Service层
public interface UserService {
	//在Dao层写一个addUser方法，连接到数据库，往数据库插入数据的操作
	//在Service层写一个addUser方法，主要包含业务功能，例如判断，循环等来处理什么业务，什么业务情况
	//下调用Dao层，什么情况下不调用等等。
	
	//public void addUser();
	//public void queryUser();   
	public User queryUser();
	//public void delUser();
	
}
