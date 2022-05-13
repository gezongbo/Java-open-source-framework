package com.lddx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;

import com.lddx.bean.User;
import com.lddx.bean.User1;
import com.lddx.bean.User2;
import com.lddx.bean.User3;


@Controller
@RequestMapping("/my02")
public class MyHandler02 {

	//web������صĶ���
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test01.action?name=zs&age=30
	@RequestMapping("/test01.action")
	public void test01(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session,WebRequest webRequest) throws IOException{
		//System.out.println("������2�е�test01����");
		String strName=request.getParameter("name");
		String strAge=request.getParameter("age");
		System.out.println(strName+","+strAge);
		PrintWriter pw=response.getWriter();
		pw.println("hello");
		pw.println(strName);
		pw.println(strAge);
	    String id=session.getId();
	    System.out.println(id);
	    //ͨ��request����ȡHttpSession
	    HttpSession session1=request.getSession();
	    String id1=session1.getId();
	    System.out.println(id1);
	    //��session�洢����
	    session.setAttribute("a",1);
	    //ʹ��WebRequest����
	    String strName1=webRequest.getParameter("name");
	    System.out.println(strName1);
	    
	}
	@RequestMapping("/test011.action")
	public void test011(HttpSession session,WebRequest webRequest,HttpServletRequest request){
		Integer a=(Integer)session.getAttribute("a");
		System.out.println("a="+a);
		Integer a1=(Integer)webRequest.getAttribute("a",WebRequest.SCOPE_SESSION);
		System.out.println("a1="+a1);
		request.setAttribute("bb", 22);
		Integer bb=(Integer)webRequest.getAttribute("bb",WebRequest.SCOPE_REQUEST);
		System.out.println("bb="+bb);
		
	}
	
	//----------------------------------------------------------------------------
	
	//�����������п���ʹ�õ�ģ�Ͷ���
	//ModelAndView����
	@RequestMapping("/test02_1.action")
	public ModelAndView test02_1(){
		ModelAndView mav=new ModelAndView();
		//��Model��װ����
		mav.addObject("a","1");
		mav.addObject("b","2");
		mav.addObject("c",3);
		//ָ��View��ͼ��
		mav.setViewName("my02test02");
		return mav;
	}
	
	//Model����
	//����������û�з���ֵ���ײ��ͨ����ͼ����������һ��Ĭ�ϵ�View�����Լ�ǰ׺��Ĭ�ϵ���ת��ַ��
	//Ĭ�ϵ�ַ��/WEB-INF/jsp/�������ϵ�@RequestMappingӳ���ַ/�����������ϵ�@RequestMapping��ӳ���ַ.jsp��ҳ���ַ
	//Ĭ�ϵ�ַ��/WEB-INF/jsp/my02/test02_2.jsp
	/*
	@RequestMapping("/test02_2.action")
	public void test02_2(Model model){
		//ֱ����Model�з�װ����
		model.addAttribute("a",11);
		model.addAttribute("b","����");
	}
	*/
	@RequestMapping("/test02_2.action")
	public String test02_2(Model model){
		//ֱ����Model�з�װ����
		model.addAttribute("a",11);
		model.addAttribute("b","����");
		return "my02test02_2";   //���ص��ַ�����View��ͼ���������ַ�����д���ȼ���mav.setViewName("my02test02");
	}
	
	//Map����
	//public void test02_3(){   }   //��ת��ҳ���ַ��Ĭ�����ɵ�
	@RequestMapping("/test02_3.action")
	public String test02_3(Map<String,String> map){
		//Map�����Model����Ĺ���һ�£������Է�װ����
		map.put("a", "100");
		map.put("b", "����");
		return "my02test02_2";
	}
	
	//ModelMap����  = Model����+Map����
	@RequestMapping("/test02_4.action")
	public String test02_4(ModelMap mm){
		//��ModelMap�����з�װ����
		mm.addAttribute("a",50);
		mm.put("b","����");
		return "my02test02_2";
	}
	
	//----------------------------------------------------------------------------
	
	//�������������ԼӵĹ��ڽ�����������Ĳ���
	//A��������HttpServletRequest�����������������
	@RequestMapping("/test03_1.action")
	public void test03_1(HttpServletRequest request){
		String strName=request.getParameter("name");
		String strAge=request.getParameter("age");
		String[] likes=request.getParameterValues("like");
		System.out.println(strName+","+strAge+","+Arrays.toString(likes));
	}
	
	
	//B���������������Զ��巽���Ĳ����������������һ�µķ�ʽ��������ȡ�������
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
	@RequestMapping("/test03_2.action")
	public void test03_2(String name,int age,String[] like){
		System.out.println(name+","+age+","+Arrays.toString(like));
	}
	
	
	//C�� ��������������Ĳ������������������һ�µ����������ʹ��@RequestParamע������ȡ����������ݹ�����ֵ��
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    @RequestMapping("/test03_3.action")
    public void test03_3(@RequestParam("name") String username,@RequestParam("age") int userage,
    		@RequestParam("like") String[] userlike){
    	System.out.println(username+","+userage+","+Arrays.toString(userlike));
    }
	
    //D������������ж��ͬ���Ĳ�����������ȿ���ʹ���ַ�������ķ�ʽ���գ�Ҳ����ʹ���ַ����ķ�ʽ���ա�
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    @RequestMapping("/test03_4.action")
    public void test03_4(String name,int age,String like){
    	//���ʹ���ַ����ķ�ʽ���գ��Ὣ���ֵ�ö��Ž���ƴ�ӣ����һ���µ��ַ���
    	System.out.println(like);//lq,zq,ds
    }

	//E�� �������ķ������Խ��ղ��������Զ���װ��javabean�С�
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    @RequestMapping("/test03_5.action")
    public void test03_5(String name,int age,String like){
    	//ͨ���Լ��ķ�ʽ����ȡ�Ĳ�����װ��javabean��
    	User user=new User();
    	user.setUname(name);
    	user.setUage(age);
    	user.setUlike(like);
    	System.out.println(user);
    	//����serviceҵ����ʲ�....
    }
	
    //����������Զ���װ��javabean����
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    //˵�������javabean���е����Ժ���������е����ֲ�һ�£��Զ���װ��ʧ��
    //    ���javabea���е����Ժ���������е�������һ�µģ���������Զ���װ
    @RequestMapping("/test03_5_1.action")
    public void test03_5_1(User1 user1){
    	System.out.println(user1);
    }
	
    
	//F �������ķ������ղ�����javabean��������javabean�����
    //http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_5_1.action
    //?name=zs&age=22&like=lq&like=zq&dname=fds&dage=22
    //ע�⣺���ʹ��SpringMVC��ܣ��˷����������ŷ���
    //����1��
	@RequestMapping("/test03_6_1.action")
	public void test03_6_1(HttpServletRequest request){
		String strName=request.getParameter("name");
		String strAge=request.getParameter("age");
		String[] likes=request.getParameterValues("like");
		String strDName=request.getParameter("dname");
		String strDAge=request.getParameter("dage");
		System.out.println(strName+strAge+Arrays.toString(likes)+strDName+strDAge);
		//ͨ���Լ��ķ�ʽ����ȡ�Ĳ�����װ��javabean��
		User2 user2=new User2();
		user2.setName(strName);
		user2.setAge(Integer.parseInt(strAge));
		user2.setLike(Arrays.toString(likes));
		user2.setDname(strDName);
		user2.setDage(Integer.parseInt(strDAge));
		System.out.println(user2);//User2 [age=10, dage=22, dname=fds, like=[lq, zq, ds], name=zs]
	}
	//����2�������������Ĳ����������������һ��
	@RequestMapping("/test03_6_2.action")
	public void test03_6_2(String name,int age,String like,String dname,@RequestParam("dage") int dogAge){
		System.out.println(name+age+like+dname+dogAge);//zs10lq,zq,dswangcai1
		//ͨ���Լ��ķ�ʽ����ȡ�Ĳ�����װ��javabean��
		User2 user2=new User2();
		user2.setName(name);
		user2.setAge(age);
		user2.setLike(like);
		user2.setDname(dname);
		user2.setDage(dogAge);
		System.out.println(user2);//User2 [age=10, dage=1, dname=wangcai, like=lq,zq,ds, name=zs]
	}
	//����3������ȡ����������Զ���װ��javabean����
	//ע�⣺JavaBean��Ҳ����User2���ж����˽��������������������������һ�£���������Զ���װ
	//�˷���������ѡ������ŷ�ʽ֮һ
	@RequestMapping("/test03_6_3.action")
	public void test03_6_3(User2 user2){
		System.out.println(user2); //User2 [age=22, dage=2, dname=wangcai, like=lq,zq,ds, name=zs]
	}
	//����4��javabean����javabean��������Զ���װ��
	//�˷���Ҳ������ѡ������ŷ�ʽ֮һ
	@RequestMapping("/test03_6_4.action")
	public void test03_6_4(User3 user3){
		System.out.println(user3);//User3 [age=10, dog=Dog [dage=22, dname=ee], like=lq,zq,ds, name=zss]
	}

	
	//----------------------------------------------------------------------------
	//���������������������
	@RequestMapping("/test04.action")
	public void test04(String name,HttpServletRequest request) throws UnsupportedEncodingException{
		//����1���ֶ���ʽ--���get��post�ύ����Ч
		//byte[] data=name.getBytes("iso8859-1");
		//name=new String(data,"utf-8");
		//����2���޸�tomcat�����������ã�ֻ���get�ύ��Ч
		//����3��ͨ��request�������ñ��룬ֻ���post�ύ��Ч
		//���������������ͨ����������������������һ�µ��������ȡֵ������������Ȼ�ȡֵ��Ȼ����ͨ��
		//request���ñ��룬����Ч������û���޸ĳɹ�
		//request.setCharacterEncoding("utf-8");  //�����ñ���
		//System.out.println("name="+name);//name=��?????
		//String strName=request.getParameter("name");//���ȡֵ
		//System.out.println("strName"+strName); //strName����
		//����4��ͨ��SpringMVC����ṩ�Ĺ����������ñ���--ֻ�����post����
		System.out.println("name"+name);//name����
	}
	
	
	//----------------------------------------------------------------------------
	//SpringMVC��ܵ�ϸ��3 �C ����������     @RequestAttribute
	//request������   ---  ʵ��һ�������е���Դ����һ��servletת����jsp,����һ��servletת������һ��servlet...��
	//ת��:��servlet��ת����һ��servletת����jsp,����һ��servletת������һ��servlet
	//    ��SpringMVC����У�һ������������ת����jspҳ��              һ������������ת������һ��������������   
	@RequestMapping("/test05_1.action")
	public void test05_1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//��request������д洢����
		request.setAttribute("name","zs");
		//ͨ��request�����test05_2������������ת��
		//request.getRequestDispatcher("/my02/test05_2.action").forward(request,response);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	@RequestMapping("/test05_2.action")
	public void test05_2(HttpServletRequest request){
		String strName=(String)request.getAttribute("name");
		System.out.println(strName);//zs  ls
	}
	
	//SpringMVC��ܶ�ת�����Ż�֧��(�����ֶ���дת�������ת����)
	@RequestMapping("/test05_3.action")
	public String test05_3(HttpServletRequest request){
		//��request�������д洢���ݣ�ʵ����Դ�Ĺ���
		request.setAttribute("name", "ls");
		//SpringMVC��ͨ�������ַ������ַ�����ʹ��forwar����ת��
		//return "forward:/my02/test05_2.action";
		//return "forward:/index.jsp";
		return "forward:/my02/test05_4.action";
	}
	//ʹ��SpringMVC����ṩ��@RequestAttributeע������request������л�ȡֵ
	@RequestMapping("/test05_4.action")
	public void test05_4(@RequestAttribute("name") String strName){
		//@RequestAttribute("name")�����name��request������л�ȡֵls������ֵ��strName
		//@RequestAttribute("name")�ȼ���request.getAttribute("name")
		System.out.println(strName);
	}
	
	//ʹ��SpringMVC����ṩ��@SessionAttributeע���session������л�ȡֵ
	@RequestMapping("/test05_5.action")
	public String test05_5(HttpSession session){
		session.setAttribute("age",30);
		//ʹ��SpringMVC��ܵķ�ʽ���ת��
		//return "forward:/my02/test05_6.action";
		return "forward:/my02/test05_7.action";
	}
	//��ȡsession�д洢�����ݣ�����1��ͨ��session����getAttribute����
	@RequestMapping("/test05_6.action")
	public void test05_6(HttpSession session){
		Integer itgAge=(Integer)session.getAttribute("age");
		System.out.println("itgAge="+itgAge);
	}
	//��ȡsession�д洢�����ݣ�����2��ͨ��@SessionAttributeע��ķ���
	@RequestMapping("test05_7.action")
	public void test05_7(@SessionAttribute("age") int age1){
		//@SessionAttribute("age")�Ǵ�session�и���age��30ȡ��������ֵ��age1
		System.out.println(age1);
	}
	
	
	//----------------------------------------------------------------------------
	//SpringMVC��ܶ���Cookie������֧��
	//@CookieValueע���ʹ��
	@RequestMapping("/test06_1.action")
	public void test06_1(HttpServletResponse response){
		//����Cookie
		Cookie cookie=new Cookie("age","30");
		//���Cookie
		response.addCookie(cookie);
		Cookie cookie1=new Cookie("name","zs");
		response.addCookie(cookie1);
	}
	//��Cookie��ȡ���ݣ�����1��servlet�׶λ�ȡ�ķ���
	@RequestMapping("/test06_2.action")
	public void test06_2(HttpServletRequest request){
		Cookie[] cks=request.getCookies();
		//ʹ����ǿ��forѭ����cks�е�����ȡ��
		for(Cookie c:cks){
			System.out.println(c.getName()+","+c.getValue());
		}
	}
	//��Cookie��ȡ���ݣ�����2��ʹ��@CookieValueע������ȡ
	@RequestMapping("/test06_3.action")
	public void test06_3(@CookieValue("age") String strAge,@CookieValue("name") String strName){
		System.out.println(strAge);
		System.out.println(strName);
	}
	
	
	
	
	
	
	
	
	
	
	
}
