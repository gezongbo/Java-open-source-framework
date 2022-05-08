package com.lddx.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Component  //id默认推算规则 id="userDao"
//@Controller
@Service
public class UserDao {
	//Spring容器初始化的执行执行该方法
	@PostConstruct
	public void myInit(){
		System.out.println("初始化连接....");
	}
	
	//Spring容器销毁的时候该方法
	@PreDestroy
	public void myDestory(){
		System.out.println("销毁....");
	}
}
