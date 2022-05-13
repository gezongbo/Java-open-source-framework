package com.lddx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lddx.bean.Teacher;

//�����������ķ���ֵ����
@Controller
@RequestMapping("/my03")
public class MyHandler03 {
	/*
	 * 1��ModelAndView����ֵ����
	 */
	@RequestMapping("/test01.action")
	public ModelAndView test01(){
		ModelAndView mav=new ModelAndView();
		//��Model�з�װ����
		mav.addObject("name","zs");
		mav.addObject("age", 30);
		//����View����Ϣ,�����ͼ��������������д
		mav.setViewName("mytest");
		return mav;
	}
	
	/*
	 * 2����ͨ�ַ������ͣ����ص��ַ�������Ϊ��ͼ����ʹ��
	 */
	@RequestMapping("/test02.action")
	public String test02(Model model){
		//��Model�з�װ����,Ҳ����ʹ��Map,Ҳ����ʹ��ModelMap
		model.addAttribute("name", "ls");
		model.addAttribute("age", 20);
		//���ص�����ͨ�ַ������ַ�����������Ϊ��ͼ����ʹ�ã��ȼ۴��룺mav.setViewName("mytest");
		return "mytest";
	}
	
	/*
	 * 3��forward��ɵ��ַ������ͣ�ͨ������forward:/xxx��ʽ���ַ�������Ҫת����ָ����ַ
	 */
	@RequestMapping("/test03.action")
	public String test03(Model model){
		//��Model�з�װ����
		model.addAttribute("name", "ww");
		model.addAttribute("age", 50);
		//ת��Ҫд�����תҳ���·����ת����������ת����ִ����ͼ������
		//ת�����Է���WEB-INF�µ�jspҳ�棬��Ϊת���������������ַ����¶�����ĵ�ַ
		return "forward:/WEB-INF/jsp/mytest.jsp";
		//return "forward:/index.jsp";
	}
	
	/*
	 * 4��redirect��ɵ��ַ������ͣ�ͨ������redirect:/xxx��ʽ���ַ�����ʾҪ�ض���ĵ�ַ
	 */
	@RequestMapping("/test04.action")
	public String test04(Model model){
		//��Model�з�װ����
		model.addAttribute("name", "xh");
		model.addAttribute("age", 40);
		//WEB-INF�µ�jspҳ�治����ֱ�����������ַ�������ֱַ�ӷ��ʣ�jspҳ����WEB-INF���ܱ�����
		//WEB-Root�µ�jspҳ���ǿ���ֱ�ӱ�����������ֱַ�ӷ��ʵ�
		//�ض����Ժ���ҳ�����ǻ�ȡ����Model�е�����
		//���ص��ַ���������redirect��ɣ��ض����Ч��
		//return "redirect:/WEB-INF/jsp/mytest.jsp";  //������
		//return "redirect:/index.jsp";  //ok
		//return "redirect:/mytest.jsp";  //ok
		//����������ض��������Ĵ������������������Ĵ���������������ת
		//(����ֱ�ӷ��ʵ�WEB-INF�µ�ҳ�棬�ֲ����ҳ��ֱ���ó�������WEB-Root��)
		return "redirect:/my03/test04_1.action";
	}
	@RequestMapping("/test04_1.action")
	public String test04_1(Model model){
		model.addAttribute("name", "xh");
		model.addAttribute("age", 40);
		//return "forward:/WEB-INF/jsp/mytest.jsp"; //ת������
		return "mytest"; //������ͼ������
		//�ܽ᣺�ض�����������ֱ�ӷ���WEB-INF�µ�ҳ�棬ת������ͼ���������Է���WEB-INF�µ�ҳ��
	}
	
	
	/*
	 * 5��void����ֵ����
	 * Ĭ��·����/WEB-INF/jsp/�������ϵ�@RequestMappingӳ���ַ/�����������ϵ�@RequestMapping��ӳ���ַ.jsp��ҳ���ַ
	 *        /WEB-INF/jsp/my03/test05.jsp
	 */
	@RequestMapping("/test05.action")
	public void test05(Model model){
		System.out.println("test05...");
		model.addAttribute("age", 100);
	}
	
	
	/*
	 * 6��������������--��������ֵ���ͣ�����ModelAndView���ͣ�����void���ͣ�����String�ַ�������,����Ϊ�������ͣ�
	 * �ײ㣺Model model;   model.addAttribute("teacher",t);
	 *     Ĭ��·����/WEB-INF/jsp/my03/test06.jsp
	 */
	@RequestMapping("/test06.action")
	public Teacher test06(){
		Teacher t=new Teacher();
		t.setName("����");
		t.setAge(50);
		t.setAddress("ɽ���ൺ");
		t.setEmail("dsd@qq.com");
		return t;
	}
	//��һ�ַ�ʽ��ʵ�ִ˹���
	@RequestMapping("/test06_1.action")
	public String test06_1(Model model){
		//��Model�д洢����
		Teacher tt=new Teacher("����",29,"��̨","sd@qq.com");
		model.addAttribute("teacher",tt);
		return "test06";
	}
	//��һ�ַ���
	//public ModelAndView test06_2(){}
	
	
	
	
	
	
	
	
}
