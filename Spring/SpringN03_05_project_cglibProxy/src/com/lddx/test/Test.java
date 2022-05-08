package com.lddx.test;
//类型转换
public class Test {
	public static void main(String[] args) {
//		Cat cat1=new Cat();
//		Animal am1=cat1;  //ok  自动类型转换，向上转型
//		Cat cat2=(Cat)am1;    //向下转型  强制类型转换
//		
//		//Dog dog1=(Dog)am1;  //向下转型，强制类型转换  错
//		
//		Animal am2=new Animal();
//		//Cat cat3=(Cat)am2; //向下转型   错
//		//Dog dog2=(Dog)am2; //向下转型   错
//		
//		Cat cat3=new Cat();
//		Object obj1=cat3;  //向上转型
//		Cat cat4=(Cat)obj1;//向下转型
//		
//		Animal am3=new Animal();
//		Object obj2=am3;  //向上转型
//		Animal am4=(Animal)obj2; //向下转型
//		
//		Object obj3=new Object();
		
		Object obj=A.newProxyInstance();
		//Cat c=(Cat)obj;  //向下转型
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
