package com.lddx.bean;

import org.springframework.stereotype.Component;

//哈士奇狗
//<bean id="" class="com.lddx.bean.HSQDog"></bean>
//@Component   //id的默认归段规则  id="HSQDog"
@Component("dog")  //id="dog"
public class HSQDog extends Dog{

}


