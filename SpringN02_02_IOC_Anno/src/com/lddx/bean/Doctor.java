package com.lddx.bean;

import org.springframework.stereotype.Component;

//如果不加value值，采用id的默认推算规则，id="doctor"
//如果加value值，按照指定的id进行获取
//@Component(value="doct")
@Component("doct")
public class Doctor {

	public Doctor(String name) {
		
	}
}
