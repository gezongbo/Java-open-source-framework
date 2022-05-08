package com.lddx.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//Doctor类的实例工厂
//此注解等价于<bean id="dif" class="com.lddx.bean.DoctorInstanceFactory"></bean>
//底层相当于执行：DoctorInstanceFactory  dif=new DoctorInstanceFactory()
/*
 * 底层：DoctorInstanceFactory dif=new DoctorInstanceFactory();
 *     Map.put("doctorInstanceFactory",dif);
 */
@Component
public class DoctorInstanceFactory {
	//添加无参构造
	public DoctorInstanceFactory() {
		//System.out.println("DoctorInstanceFactory类的无参构造。。。");
	}

	//提供的是非static方法
	//此注解等价于<bean id="doctor" factory-bean="dif" factory-method="getDoctor"></bean>
	//name=""等价配置文件中的id=""
	/*
	 * 底层：Map.get("doctorInstanceFactory")-->DoctorInstanceFactory dif;
	 *     Doctor d=dif.getDoctor();
	 *     Map.put("doctor",d);
	 */
	@Bean(name="doctor")
	public Doctor getDoctor(){
		//System.out.println("获取医生对象的方法执行.....");
		Doctor d=new Doctor("张三");
		return d;
	}
	
}
