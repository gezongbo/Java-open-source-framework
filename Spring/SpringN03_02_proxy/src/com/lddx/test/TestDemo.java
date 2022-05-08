package com.lddx.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//测试类
public class TestDemo {
	
	@Test
	public void test01(){
		//明星没有出名之前
		FBB fbb=new FBB();
		fbb.eat();
		fbb.sign();
		//在出名以后，询问和记录都是FBB本人完成这些事情，也就是在FBB类中完成的这些代码，违背了高内聚的原则
		//高内聚：各干各的事情
	}
	
	//静态代理  --FBB找了一个ZL
	@Test
	public void test02(){
		//找FBB
		final FBB fbb=new FBB();  //fbb局部变量（在方法中定义的变量）
		//fbb.eat();
		//fbb.sign();
		//先找助理   定义一个局部内部类(在方法中定义的类)  类ZL表示助理
		class ZL implements Star{
			public void eat() {
				System.out.println("ZL你是谁###");
				//助理通知fbb去吃饭
				fbb.eat();
				System.out.println("ZL记录一下#");
			}
			public void sign() {
				System.out.println("ZL你是谁###");
				//助理通知fbb去签名
				fbb.sign();
				System.out.println("ZL记录一下#");
			}
		}
		//创建ZL类
		//ZL zl=new ZL();
		Star zl=new ZL();
		zl.eat();
		zl.sign();
	}
	

	//动态代理
	@Test
	public void test03(){
		//找FBB吃饭
		final FBB fbb=new FBB();
		//找家经纪公司，由经纪公司给推荐一个助理
		//java提供了一个Proxy类，用于做动态代理的，可以把Proxy类理解为经纪公司
		//obj是Object类型，表示经纪公司给我们推荐的助理
		//参数1：加载哪个类，理解为对哪个明星提供助理
		//参数2：加载的类包含的所有方法，理解为提供的这个助理都对明星负责哪些事情
		//参数3：回调方法，主要完成所为助理要完成的事
		Object obj=Proxy.newProxyInstance(FBB.class.getClassLoader(),
				FBB.class.getInterfaces(),new InvocationHandler(){
					//参数1:代理者
					//参数2:当前被调用的方法
					//参数3:当前被调用方法的参数
					//在invoke方法中完成助理要做的事情
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("ZL你是谁啊###");
						//通知FBB去做事情（吃饭、签名）
						Object obj=method.invoke(fbb,args);
						//等价理解为静态代理中的fbb.eat()或者fbb.sign()
						System.out.println("ZL记录一下###");
						return obj;
					}
		});
		//Proxy经纪公司返回的是Object obj，理解为助理
		Star zl=(Star)obj;
		zl.eat();  //底层会执行invoke()方法
		zl.sign();  //底层会执行invoke()方法
		//zl.sf();  //Star接口中没有sf方法，所以作为助理看不到FBB类中的sf方法
	}
	
	
	/*
	 * cglib动态代理
	 */
	@Test
	public void test04(){
		//找FBB
		final FBB fbb=new FBB();
		//使用cglib代理 -- 提供助理
		//1、创建增强器  Enhancer
		Enhancer enhancer=new Enhancer();
		//2、指定代理者要实现的接口，不强制的，因为是继承的类，只有实现接口才要求写所有的方法
		enhancer.setInterfaces(FBB.class.getInterfaces());
		//3、指定父类，强制。要提供的助理是FBB类的子类
		enhancer.setSuperclass(FBB.class);
		//4、设置回调函数
		enhancer.setCallback(new MethodInterceptor(){
			//在intercept方法里也是完成助理要做的事情
			public Object intercept(Object arg0, Method method, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("ZL你是谁啊");
				//通知fbb去做什么事情（相当于执行fbb类中的方法）
				Object obj=method.invoke(fbb,arg2);
				System.out.println("ZL记录一下");
				return obj;
			}
		});
		//5、创建代理者--提供助理
		Object obj=enhancer.create();
		FBB zl=(FBB)obj;
		//Star zl=(Star)obj;
		zl.eat();
		zl.sign();
		zl.sf();
	}

}

//定义一个类（外部类） --明星 范冰冰
class FBB implements Star{
	public void eat(){
		//System.out.println("你是谁啊###");
		System.out.println("FBB吃饭...");
		//System.out.println("记录一下###");
	}
	public void sign(){
		//System.out.println("你是谁啊###");
		System.out.println("FBB签名...");
		//System.out.println("记录一下###");
	}
	//sf方法不在Star接口中有，只在FBB本类中有
	public void sf(){
		System.out.println("FBB书法...");
	}
}
//定义一个接口  明星
interface Star{
	public void eat();
	public void sign();
}







