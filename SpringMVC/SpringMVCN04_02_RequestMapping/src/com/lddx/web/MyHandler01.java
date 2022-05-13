package com.lddx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//处理器
@Controller
@RequestMapping("/my01")
public class MyHandler01 {

	//此注解配置的处理器映射器的映射关系
	//@RequestMapping("/my01/test01.action")
	@RequestMapping("/test01.action")
	public ModelAndView test01(){
		System.out.println("测试...test01方法...");
		//创建ModelAndView对象
		ModelAndView mav=new ModelAndView();
		//往ModelAndView对象中存储数据
		mav.addObject("k1","v1");
		mav.addObject("name","张三");
		mav.addObject("age",30);
		//设置View的信息--理解为要跳转到的JSP页面的名字
		mav.setViewName("mytest");
		return mav;
	}
	
	//@RequestMapping("/test02.action")   简写
	@RequestMapping(value={"/test02.action"})
	public void test02(){
		System.out.println("测试...test02方法...");
	}
	
	//当只对value属性赋值的时候,value可以省略
	//给value赋值多个路径，使用{}来存储多个值，用逗号隔开。如果只有一个值来赋值，大括号也可以省略
	@RequestMapping(value={"test03.action","test03x.action","test03z*.action"})
	public void test03(){
		System.out.println("测试...test03方法...");
	}
	
	
	//method属性的使用
	//不指定method属性，会接收任意请求方式的请求
	//@RequestMapping(value="/test04.action")
	//使用method属性指定请求方式
	@RequestMapping(value="/test04.action",method={RequestMethod.POST,RequestMethod.GET})
	public void test04(){
		System.out.println("测试...test04方法");
	}
	
	
	//params属性的使用
	@RequestMapping(value="/test05.action",params={"name","name1","!age","salary=10000"})
	public void test05(){
		System.out.println("测试...test05方法");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
