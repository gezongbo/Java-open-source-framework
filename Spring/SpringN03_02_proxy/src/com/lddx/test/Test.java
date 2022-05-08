package com.lddx.test;

public class Test {
	public static void main(String[] args) {
		//Animal aml=new Animal();
		//Animal aml=new Dog();
		//aml.shout();
//		Animal aml2=new Animal(){
//			public void shout() {
//				System.out.println("ÍúÍúÍú¡£¡£¡£");
//			}
//		};
//		aml2.shout();
		
	}
}
interface Animal{
	public void shout();
}
class Dog implements Animal{
	public void shout() {
		System.out.println("ÍôÍôÍô...");
	}
}
class Cat extends Dog{
	
}

