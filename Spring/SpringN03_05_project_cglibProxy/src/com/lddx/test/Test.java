package com.lddx.test;
//����ת��
public class Test {
	public static void main(String[] args) {
//		Cat cat1=new Cat();
//		Animal am1=cat1;  //ok  �Զ�����ת��������ת��
//		Cat cat2=(Cat)am1;    //����ת��  ǿ������ת��
//		
//		//Dog dog1=(Dog)am1;  //����ת�ͣ�ǿ������ת��  ��
//		
//		Animal am2=new Animal();
//		//Cat cat3=(Cat)am2; //����ת��   ��
//		//Dog dog2=(Dog)am2; //����ת��   ��
//		
//		Cat cat3=new Cat();
//		Object obj1=cat3;  //����ת��
//		Cat cat4=(Cat)obj1;//����ת��
//		
//		Animal am3=new Animal();
//		Object obj2=am3;  //����ת��
//		Animal am4=(Animal)obj2; //����ת��
//		
//		Object obj3=new Object();
		
		Object obj=A.newProxyInstance();
		//Cat c=(Cat)obj;  //����ת��
		Animal aml=(Animal)obj;
	}
}
class A{
	public static Object newProxyInstance(){
		//...
		//Object obj=new Object();
		//Object obj=new Cat();
		Object obj=new Animal();
		//....
		return obj;
	}
}
class Animal{
	
}
class Cat extends Animal{
	
}
class Dog extends Animal{
	
}
