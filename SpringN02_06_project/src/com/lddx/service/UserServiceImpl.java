package com.lddx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lddx.dao.MySqlUserDao;
import com.lddx.dao.OracleUserDao;
import com.lddx.dao.UserDao;

//模型层Model层
//业务访问层Service层
/*
 * Spring底层：UserServiceImpl usi=new UserServiceImpl();
 *           Map.put("userServiceImpl",usi);
 */
@Service("serviceImpl")     //id默认推断的值   id="userServiceImpl"
public class UserServiceImpl implements ServiceImpl{
	//封装私有属性
	//在Service层中调用MySqlUserDao
	//private MySqlUserDao userDao=new MySqlUserDao();
	//在Service层中调用OracleUserDao
	//private OracleUserDao userDao=new OracleUserDao();
	//思考：如果数据库发生变化，Service层需要修改代码，层与层之间的耦合度较高
	//耦合度高的原因有两方面：一方面类型要变，需要MySqlUserDao和OracleUserDao类型来回切换
	//                 另一方面是new创建的对象要变化，需要new MySqlUserDao()和new OracleUserDao()来回切换
	//解决高耦合：一方面解决 面向接口编程
	//        另一方面的解决：Spring框架中的IOC+DI
	//private UserDao userDao=new MySqlUserDao();
	//private UserDao userDao=new OracleUserDao();
	//注解实现DI依赖注入
	//自动装配的实现原理：先根据类型匹配查找，根据UserDao类类型匹配查找，能找到3个，分别是UserDao,MySqlUserDao,OracleUserDao
	//然后在根据id进行查找，根据属性名userDao去查找id的值，找到了id为mysqlUserDao和oracleUserDao两个值。
	@Autowired
	private UserDao userDao;

	
	//封装一个方法
	public void addUserService(){
		//在Service层中调用Dao层
		userDao.addUser();
	}
	
}
