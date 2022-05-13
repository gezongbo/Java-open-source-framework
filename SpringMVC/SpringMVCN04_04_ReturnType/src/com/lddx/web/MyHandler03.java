package com.lddx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lddx.bean.Teacher;

//处理器方法的返回值类型
@Controller
@RequestMapping("/my03")
public class MyHandler03 {
	/*
	 * 1、ModelAndView返回值类型
	 */
	@RequestMapping("/test01.action")
	public ModelAndView test01(){
		ModelAndView mav=new ModelAndView();
		//往Model中封装数据
		mav.addObject("name","zs");
		mav.addObject("age", 30);
		//设置View的信息,结合视图解析器的配置来写
		mav.setViewName("mytest");
		return mav;
	}
	
	/*
	 * 2、普通字符串类型：返回的字符串将作为视图名来使用
	 */
	@RequestMapping("/test02.action")
	public String test02(Model model){
		//往Model中封装数据,也可以使用Map,也可以使用ModelMap
		model.addAttribute("name", "ls");
		model.addAttribute("age", 20);
		//返回的是普通字符串，字符串的内容作为视图名来使用，等价代码：mav.setViewName("mytest");
		return "mytest";
	}
	
	/*
	 * 3、forward组成的字符串类型：通过返回forward:/xxx格式的字符串表明要转发的指定地址
	 */
	@RequestMapping("/test03.action")
	public String test03(Model model){
		//往Model中封装数据
		model.addAttribute("name", "ww");
		model.addAttribute("age", 50);
		//转发要写清楚跳转页面的路径，转发技术的跳转不会执行视图解析器
		//转发可以访问WEB-INF下的jsp页面，因为转发不会在浏览器地址栏暴露真正的地址
		return "forward:/WEB-INF/jsp/mytest.jsp";
		//return "forward:/index.jsp";
	}
	
	/*
	 * 4、redirect组成的字符串类型：通过返回redirect:/xxx格式的字符串表示要重定向的地址
	 */
	@RequestMapping("/test04.action")
	public String test04(Model model){
		//往Model中封装数据
		model.addAttribute("name", "xh");
		model.addAttribute("age", 40);
		//WEB-INF下的jsp页面不可以直接在浏览器地址栏输入地址直接访问，jsp页面在WEB-INF是受保护的
		//WEB-Root下的jsp页面是可以直接被浏览器输入地址直接访问的
		//重定向以后，在页面中是获取不到Model中的数据
		//返回的字符串类型由redirect组成，重定向的效果
		//return "redirect:/WEB-INF/jsp/mytest.jsp";  //不可以
		//return "redirect:/index.jsp";  //ok
		//return "redirect:/mytest.jsp";  //ok
		//解决方案：重定向到其它的处理器方法，由其它的处理器方法进行跳转
		//(不能直接访问到WEB-INF下的页面，又不想把页面直接拿出来放入WEB-Root下)
		return "redirect:/my03/test04_1.action";
	}
	@RequestMapping("/test04_1.action")
	public String test04_1(Model model){
		model.addAttribute("name", "xh");
		model.addAttribute("age", 40);
		//return "forward:/WEB-INF/jsp/mytest.jsp"; //转发技术
		return "mytest"; //经过视图解析器
		//总结：重定向技术不可以直接访问WEB-INF下的页面，转发，视图解析器可以访问WEB-INF下的页面
	}
	
	
	/*
	 * 5、void返回值类型
	 * 默认路径：/WEB-INF/jsp/处理器上的@RequestMapping映射地址/处理器方法上的@RequestMapping的映射地址.jsp的页面地址
	 *        /WEB-INF/jsp/my03/test05.jsp
	 */
	@RequestMapping("/test05.action")
	public void test05(Model model){
		System.out.println("test05...");
		model.addAttribute("age", 100);
	}
	
	
	/*
	 * 6、处理器方法的--其它返回值类型（不是ModelAndView类型，不是void类型，不是String字符串类型,都称为其它类型）
	 * 底层：Model model;   model.addAttribute("teacher",t);
	 *     默认路径：/WEB-INF/jsp/my03/test06.jsp
	 */
	@RequestMapping("/test06.action")
	public Teacher test06(){
		Teacher t=new Teacher();
		t.setName("张三");
		t.setAge(50);
		t.setAddress("山东青岛");
		t.setEmail("dsd@qq.com");
		return t;
	}
	//另一种方式来实现此功能
	@RequestMapping("/test06_1.action")
	public String test06_1(Model model){
		//往Model中存储数据
		Teacher tt=new Teacher("李四",29,"烟台","sd@qq.com");
		model.addAttribute("teacher",tt);
		return "test06";
	}
	//另一种方法
	//public ModelAndView test06_2(){}
	
	
	
	
	
	
	
	
}
