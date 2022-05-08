package com.lddx.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//������
public class TestDemo {
	
	@Test
	public void test01(){
		//����û�г���֮ǰ
		FBB fbb=new FBB();
		fbb.eat();
		fbb.sign();
		//�ڳ����Ժ�ѯ�ʺͼ�¼����FBB���������Щ���飬Ҳ������FBB������ɵ���Щ���룬Υ���˸��ھ۵�ԭ��
		//���ھۣ����ɸ�������
	}
	
	//��̬����  --FBB����һ��ZL
	@Test
	public void test02(){
		//��FBB
		final FBB fbb=new FBB();  //fbb�ֲ��������ڷ����ж���ı�����
		//fbb.eat();
		//fbb.sign();
		//��������   ����һ���ֲ��ڲ���(�ڷ����ж������)  ��ZL��ʾ����
		class ZL implements Star{
			public void eat() {
				System.out.println("ZL����˭###");
				//����֪ͨfbbȥ�Է�
				fbb.eat();
				System.out.println("ZL��¼һ��#");
			}
			public void sign() {
				System.out.println("ZL����˭###");
				//����֪ͨfbbȥǩ��
				fbb.sign();
				System.out.println("ZL��¼һ��#");
			}
		}
		//����ZL��
		//ZL zl=new ZL();
		Star zl=new ZL();
		zl.eat();
		zl.sign();
	}
	

	//��̬����
	@Test
	public void test03(){
		//��FBB�Է�
		final FBB fbb=new FBB();
		//�ҼҾ��͹�˾���ɾ��͹�˾���Ƽ�һ������
		//java�ṩ��һ��Proxy�࣬��������̬����ģ����԰�Proxy�����Ϊ���͹�˾
		//obj��Object���ͣ���ʾ���͹�˾�������Ƽ�������
		//����1�������ĸ��࣬���Ϊ���ĸ������ṩ����
		//����2�����ص�����������з��������Ϊ�ṩ��������������Ǹ�����Щ����
		//����3���ص���������Ҫ�����Ϊ����Ҫ��ɵ���
		Object obj=Proxy.newProxyInstance(FBB.class.getClassLoader(),
				FBB.class.getInterfaces(),new InvocationHandler(){
					//����1:������
					//����2:��ǰ�����õķ���
					//����3:��ǰ�����÷����Ĳ���
					//��invoke�������������Ҫ��������
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("ZL����˭��###");
						//֪ͨFBBȥ�����飨�Է���ǩ����
						Object obj=method.invoke(fbb,args);
						//�ȼ����Ϊ��̬�����е�fbb.eat()����fbb.sign()
						System.out.println("ZL��¼һ��###");
						return obj;
					}
		});
		//Proxy���͹�˾���ص���Object obj�����Ϊ����
		Star zl=(Star)obj;
		zl.eat();  //�ײ��ִ��invoke()����
		zl.sign();  //�ײ��ִ��invoke()����
		//zl.sf();  //Star�ӿ���û��sf������������Ϊ��������FBB���е�sf����
	}
	
	
	/*
	 * cglib��̬����
	 */
	@Test
	public void test04(){
		//��FBB
		final FBB fbb=new FBB();
		//ʹ��cglib���� -- �ṩ����
		//1��������ǿ��  Enhancer
		Enhancer enhancer=new Enhancer();
		//2��ָ��������Ҫʵ�ֵĽӿڣ���ǿ�Ƶģ���Ϊ�Ǽ̳е��ֻ࣬��ʵ�ֽӿڲ�Ҫ��д���еķ���
		enhancer.setInterfaces(FBB.class.getInterfaces());
		//3��ָ�����࣬ǿ�ơ�Ҫ�ṩ��������FBB�������
		enhancer.setSuperclass(FBB.class);
		//4�����ûص�����
		enhancer.setCallback(new MethodInterceptor(){
			//��intercept������Ҳ���������Ҫ��������
			public Object intercept(Object arg0, Method method, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("ZL����˭��");
				//֪ͨfbbȥ��ʲô���飨�൱��ִ��fbb���еķ�����
				Object obj=method.invoke(fbb,arg2);
				System.out.println("ZL��¼һ��");
				return obj;
			}
		});
		//5������������--�ṩ����
		Object obj=enhancer.create();
		FBB zl=(FBB)obj;
		//Star zl=(Star)obj;
		zl.eat();
		zl.sign();
		zl.sf();
	}

}

//����һ���ࣨ�ⲿ�ࣩ --���� ������
class FBB implements Star{
	public void eat(){
		//System.out.println("����˭��###");
		System.out.println("FBB�Է�...");
		//System.out.println("��¼һ��###");
	}
	public void sign(){
		//System.out.println("����˭��###");
		System.out.println("FBBǩ��...");
		//System.out.println("��¼һ��###");
	}
	//sf��������Star�ӿ����У�ֻ��FBB��������
	public void sf(){
		System.out.println("FBB�鷨...");
	}
}
//����һ���ӿ�  ����
interface Star{
	public void eat();
	public void sign();
}







