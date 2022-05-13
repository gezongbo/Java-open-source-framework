package com.lddx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//������
@Controller
@RequestMapping("/my01")
public class MyHandler01 {

	//��ע�����õĴ�����ӳ������ӳ���ϵ
	//@RequestMapping("/my01/test01.action")
	@RequestMapping("/test01.action")
	public ModelAndView test01(){
		System.out.println("����...test01����...");
		//����ModelAndView����
		ModelAndView mav=new ModelAndView();
		//��ModelAndView�����д洢����
		mav.addObject("k1","v1");
		mav.addObject("name","����");
		mav.addObject("age",30);
		//����View����Ϣ--���ΪҪ��ת����JSPҳ�������
		mav.setViewName("mytest");
		return mav;
	}
	
	//@RequestMapping("/test02.action")   ��д
	@RequestMapping(value={"/test02.action"})
	public void test02(){
		System.out.println("����...test02����...");
	}
	
	//��ֻ��value���Ը�ֵ��ʱ��,value����ʡ��
	//��value��ֵ���·����ʹ��{}���洢���ֵ���ö��Ÿ��������ֻ��һ��ֵ����ֵ��������Ҳ����ʡ��
	@RequestMapping(value={"test03.action","test03x.action","test03z*.action"})
	public void test03(){
		System.out.println("����...test03����...");
	}
	
	
	//method���Ե�ʹ��
	//��ָ��method���ԣ��������������ʽ������
	//@RequestMapping(value="/test04.action")
	//ʹ��method����ָ������ʽ
	@RequestMapping(value="/test04.action",method={RequestMethod.POST,RequestMethod.GET})
	public void test04(){
		System.out.println("����...test04����");
	}
	
	
	//params���Ե�ʹ��
	@RequestMapping(value="/test05.action",params={"name","name1","!age","salary=10000"})
	public void test05(){
		System.out.println("����...test05����");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
