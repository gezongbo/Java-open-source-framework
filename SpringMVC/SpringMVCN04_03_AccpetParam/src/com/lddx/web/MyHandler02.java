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

	//web开发相关的对象
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test01.action?name=zs&age=30
	@RequestMapping("/test01.action")
	public void test01(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session,WebRequest webRequest) throws IOException{
		//System.out.println("处理器2中的test01方法");
		String strName=request.getParameter("name");
		String strAge=request.getParameter("age");
		System.out.println(strName+","+strAge);
		PrintWriter pw=response.getWriter();
		pw.println("hello");
		pw.println(strName);
		pw.println(strAge);
	    String id=session.getId();
	    System.out.println(id);
	    //通过request来获取HttpSession
	    HttpSession session1=request.getSession();
	    String id1=session1.getId();
	    System.out.println(id1);
	    //往session存储数据
	    session.setAttribute("a",1);
	    //使用WebRequest对象
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
	
	//处理器方法中可以使用的模型对象
	//ModelAndView对象
	@RequestMapping("/test02_1.action")
	public ModelAndView test02_1(){
		ModelAndView mav=new ModelAndView();
		//往Model封装数据
		mav.addObject("a","1");
		mav.addObject("b","2");
		mav.addObject("c",3);
		//指定View视图名
		mav.setViewName("my02test02");
		return mav;
	}
	
	//Model对象
	//处理器方法没有返回值，底层会通过视图解析器生成一个默认的View名，以及前缀（默认的跳转地址）
	//默认地址：/WEB-INF/jsp/处理器上的@RequestMapping映射地址/处理器方法上的@RequestMapping的映射地址.jsp的页面地址
	//默认地址：/WEB-INF/jsp/my02/test02_2.jsp
	/*
	@RequestMapping("/test02_2.action")
	public void test02_2(Model model){
		//直接往Model中封装数据
		model.addAttribute("a",11);
		model.addAttribute("b","张三");
	}
	*/
	@RequestMapping("/test02_2.action")
	public String test02_2(Model model){
		//直接往Model中封装数据
		model.addAttribute("a",11);
		model.addAttribute("b","张三");
		return "my02test02_2";   //返回的字符串是View视图名，返回字符串的写法等价于mav.setViewName("my02test02");
	}
	
	//Map对象
	//public void test02_3(){   }   //跳转的页面地址是默认生成的
	@RequestMapping("/test02_3.action")
	public String test02_3(Map<String,String> map){
		//Map对象和Model对象的功能一致，都可以封装数据
		map.put("a", "100");
		map.put("b", "李四");
		return "my02test02_2";
	}
	
	//ModelMap对象  = Model对象+Map对象
	@RequestMapping("/test02_4.action")
	public String test02_4(ModelMap mm){
		//往ModelMap对象中封装数据
		mm.addAttribute("a",50);
		mm.put("b","王五");
		return "my02test02_2";
	}
	
	//----------------------------------------------------------------------------
	
	//处理器方法可以加的关于接收请求参数的参数
	//A、借助于HttpServletRequest对象来接收请求参数
	@RequestMapping("/test03_1.action")
	public void test03_1(HttpServletRequest request){
		String strName=request.getParameter("name");
		String strAge=request.getParameter("age");
		String[] likes=request.getParameterValues("like");
		System.out.println(strName+","+strAge+","+Arrays.toString(likes));
	}
	
	
	//B、处理器方法可以定义方法的参数名和请求参数名一致的方式，用来获取请求参数
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
	@RequestMapping("/test03_2.action")
	public void test03_2(String name,int age,String[] like){
		System.out.println(name+","+age+","+Arrays.toString(like));
	}
	
	
	//C、 处理器方法定义的参数名和请求参数名不一致的情况，可以使用@RequestParam注解来获取请求参数传递过来的值。
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    @RequestMapping("/test03_3.action")
    public void test03_3(@RequestParam("name") String username,@RequestParam("age") int userage,
    		@RequestParam("like") String[] userlike){
    	System.out.println(username+","+userage+","+Arrays.toString(userlike));
    }
	
    //D、请求参数中有多个同名的参数的情况，既可以使用字符串数组的方式接收，也可以使用字符串的方式接收。
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    @RequestMapping("/test03_4.action")
    public void test03_4(String name,int age,String like){
    	//如果使用字符串的方式接收，会将多个值用逗号进行拼接，组成一个新的字符串
    	System.out.println(like);//lq,zq,ds
    }

	//E、 处理器的方法可以接收参数，并自动封装到javabean中。
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    @RequestMapping("/test03_5.action")
    public void test03_5(String name,int age,String like){
    	//通过自己的方式将获取的参数封装到javabean中
    	User user=new User();
    	user.setUname(name);
    	user.setUage(age);
    	user.setUlike(like);
    	System.out.println(user);
    	//调用service业务访问层....
    }
	
    //将请求参数自动封装到javabean类中
	//http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_1.action
	//?name=zs&age=10&like=lq&like=zq&like=ds
    //说明：如果javabean类中的属性和请求参数中的名字不一致，自动封装会失败
    //    如果javabea类中的属性和请求参数中的名字是一致的，可以完成自动封装
    @RequestMapping("/test03_5_1.action")
    public void test03_5_1(User1 user1){
    	System.out.println(user1);
    }
	
    
	//F 处理器的方法接收参数，javabean包含其它javabean的情况
    //http://localhost:8080/SpringMVCN04_03_AccpetParam/my02/test03_5_1.action
    //?name=zs&age=22&like=lq&like=zq&dname=fds&dage=22
    //注意：如果使用SpringMVC框架，此方法不是最优方法
    //方法1：
	@RequestMapping("/test03_6_1.action")
	public void test03_6_1(HttpServletRequest request){
		String strName=request.getParameter("name");
		String strAge=request.getParameter("age");
		String[] likes=request.getParameterValues("like");
		String strDName=request.getParameter("dname");
		String strDAge=request.getParameter("dage");
		System.out.println(strName+strAge+Arrays.toString(likes)+strDName+strDAge);
		//通过自己的方式将获取的参数封装到javabean中
		User2 user2=new User2();
		user2.setName(strName);
		user2.setAge(Integer.parseInt(strAge));
		user2.setLike(Arrays.toString(likes));
		user2.setDname(strDName);
		user2.setDage(Integer.parseInt(strDAge));
		System.out.println(user2);//User2 [age=10, dage=22, dname=fds, like=[lq, zq, ds], name=zs]
	}
	//方法2：处理器方法的参数名和请求参数名一致
	@RequestMapping("/test03_6_2.action")
	public void test03_6_2(String name,int age,String like,String dname,@RequestParam("dage") int dogAge){
		System.out.println(name+age+like+dname+dogAge);//zs10lq,zq,dswangcai1
		//通过自己的方式将获取的参数封装到javabean中
		User2 user2=new User2();
		user2.setName(name);
		user2.setAge(age);
		user2.setLike(like);
		user2.setDname(dname);
		user2.setDage(dogAge);
		System.out.println(user2);//User2 [age=10, dage=1, dname=wangcai, like=lq,zq,ds, name=zs]
	}
	//方法3：将获取的请求参数自动封装到javabean类中
	//注意：JavaBean类也就是User2类中定义的私有属性名必须和请求参数的名字一致，才能完成自动封装
	//此方法是我们选择的最优方式之一
	@RequestMapping("/test03_6_3.action")
	public void test03_6_3(User2 user2){
		System.out.println(user2); //User2 [age=22, dage=2, dname=wangcai, like=lq,zq,ds, name=zs]
	}
	//方法4：javabean包含javabean的情况（自动封装）
	//此方法也是我们选择的最优方式之一
	@RequestMapping("/test03_6_4.action")
	public void test03_6_4(User3 user3){
		System.out.println(user3);//User3 [age=10, dog=Dog [dage=22, dname=ee], like=lq,zq,ds, name=zss]
	}

	
	//----------------------------------------------------------------------------
	//请求参数中中文乱码问题
	@RequestMapping("/test04.action")
	public void test04(String name,HttpServletRequest request) throws UnsupportedEncodingException{
		//方案1：手动方式--针对get和post提交都有效
		//byte[] data=name.getBytes("iso8859-1");
		//name=new String(data,"utf-8");
		//方案2：修改tomcat服务器的配置，只针对get提交有效
		//方案3：通过request对象设置编码，只针对post提交有效
		//如果处理器方法是通过定义参数名和请求参数名一致的情况来获取值，这样情况是先获取值，然后在通过
		//request设置编码，是无效，编码没有修改成功
		//request.setCharacterEncoding("utf-8");  //先设置编码
		//System.out.println("name="+name);//name=é?????
		//String strName=request.getParameter("name");//后获取值
		//System.out.println("strName"+strName); //strName陈明
		//方案4：通过SpringMVC框架提供的过滤器来设置编码--只针对于post方法
		System.out.println("name"+name);//name陈明
	}
	
	
	//----------------------------------------------------------------------------
	//SpringMVC框架的细节3 – 作用域属性     @RequestAttribute
	//request作用域   ---  实现一次请求中的资源共享（一个servlet转发到jsp,或者一个servlet转发到另一个servlet...）
	//转发:在servlet中转发：一个servlet转发到jsp,或者一个servlet转发到另一个servlet
	//    在SpringMVC框架中：一个处理器方法转发到jsp页面              一个处理器方法转发到另一个处理器方法中   
	@RequestMapping("/test05_1.action")
	public void test05_1(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//往request域对象中存储数据
		request.setAttribute("name","zs");
		//通过request完成向test05_2处理器方法的转发
		//request.getRequestDispatcher("/my02/test05_2.action").forward(request,response);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	@RequestMapping("/test05_2.action")
	public void test05_2(HttpServletRequest request){
		String strName=(String)request.getAttribute("name");
		System.out.println(strName);//zs  ls
	}
	
	//SpringMVC框架对转发的优化支持(不用手动的写转发器完成转发了)
	@RequestMapping("/test05_3.action")
	public String test05_3(HttpServletRequest request){
		//往request作用域中存储数据，实现资源的共享
		request.setAttribute("name", "ls");
		//SpringMVC是通过返回字符串，字符串中使用forwar进行转发
		//return "forward:/my02/test05_2.action";
		//return "forward:/index.jsp";
		return "forward:/my02/test05_4.action";
	}
	//使用SpringMVC框架提供的@RequestAttribute注解来从request域对象中获取值
	@RequestMapping("/test05_4.action")
	public void test05_4(@RequestAttribute("name") String strName){
		//@RequestAttribute("name")会根据name从request域对象中获取值ls，并赋值给strName
		//@RequestAttribute("name")等价于request.getAttribute("name")
		System.out.println(strName);
	}
	
	//使用SpringMVC框架提供的@SessionAttribute注解从session域对象中获取值
	@RequestMapping("/test05_5.action")
	public String test05_5(HttpSession session){
		session.setAttribute("age",30);
		//使用SpringMVC框架的方式完成转发
		//return "forward:/my02/test05_6.action";
		return "forward:/my02/test05_7.action";
	}
	//获取session中存储的数据：方法1，通过session调用getAttribute方法
	@RequestMapping("/test05_6.action")
	public void test05_6(HttpSession session){
		Integer itgAge=(Integer)session.getAttribute("age");
		System.out.println("itgAge="+itgAge);
	}
	//获取session中存储的数据：方法2，通过@SessionAttribute注解的方法
	@RequestMapping("test05_7.action")
	public void test05_7(@SessionAttribute("age") int age1){
		//@SessionAttribute("age")是从session中根据age把30取出，并赋值给age1
		System.out.println(age1);
	}
	
	
	//----------------------------------------------------------------------------
	//SpringMVC框架对于Cookie技术的支持
	//@CookieValue注解的使用
	@RequestMapping("/test06_1.action")
	public void test06_1(HttpServletResponse response){
		//创建Cookie
		Cookie cookie=new Cookie("age","30");
		//添加Cookie
		response.addCookie(cookie);
		Cookie cookie1=new Cookie("name","zs");
		response.addCookie(cookie1);
	}
	//从Cookie中取数据，方法1：servlet阶段获取的方法
	@RequestMapping("/test06_2.action")
	public void test06_2(HttpServletRequest request){
		Cookie[] cks=request.getCookies();
		//使用增强版for循环将cks中的内容取出
		for(Cookie c:cks){
			System.out.println(c.getName()+","+c.getValue());
		}
	}
	//从Cookie中取数据，方法2：使用@CookieValue注解来获取
	@RequestMapping("/test06_3.action")
	public void test06_3(@CookieValue("age") String strAge,@CookieValue("name") String strName){
		System.out.println(strAge);
		System.out.println(strName);
	}
	
	
	
	
	
	
	
	
	
	
	
}
