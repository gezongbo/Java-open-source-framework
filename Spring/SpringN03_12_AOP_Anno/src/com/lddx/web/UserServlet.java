package com.lddx.web;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.lddx.bean.User;
import com.lddx.service.UserService;
import com.lddx.service.UserServiceImpl;
import com.lddx.service.UserServiceImpl2;

//控制层Web层（真是开发中该类应该是一个Servlet类，现在使用一个普通的类模拟）
@Controller   //id默认推断规则id="userServlet"
public class UserServlet {

	//在Web层调用执行Service层的代码
	//面向接口编程（解耦合）
	@Autowired
	private UserService userService;
	//@Autowired
	//private UserServiceImpl2 userService2;
	/*
	 * 底层理解：在userService属性的上面使用了@Autowired注解，会完成自动装配，根据UserService类型
	 * 去匹配，能够匹配到UserServiceImpl类，UserServiceImpl类加了@Service注解，Spring容器IOC会创建UserServiceImpl类，
	 * 同时还会根据配置文件中的配置，生成UserServiceImpl类的代理，在通过userServce属性调用执行queryUser()目标方法的时候，
	 * 会执行代理中的方法，也就是切面类FirstAspect中定义的通知方法。
	 * userService属性因为配置文件配置了切面，配置了通知方法，会生成UserServiceImpl的代理，实际上给userService属性赋值的是生成
	 * 的代理
	 * Object obj=Proxy.newProxyInstance.....
	 * UserService us=(UserService)obj;
	 * us等同于立即为userService属性
	 */
	
	public void addUserServlet(){
		//userService.addUser();
		//userService.delUser();
		//userService.queryUser();
		//System.out.println(userService2.getClass());
		//class com.lddx.service.UserServiceImpl2$$EnhancerByCGLIB$$ab13b75d
		//userService2.queryUser2();
		
		//System.out.println("代理模式:"+userService.getClass());//代理模式:class $Proxy6s
		User user=userService.queryUser();
		//向下转型,是有风险的
		//UserServiceImpl usi=(UserServiceImpl)userService;
		//usi.mytest();
		
		System.out.println("UserServlet类："+user);
	}
	
}
