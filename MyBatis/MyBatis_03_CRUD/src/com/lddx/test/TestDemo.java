package com.lddx.test;



import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lddx.bean.User;

public class TestDemo {
	
	private SqlSession sqlSession;
	
	//在执行@Test注解的方法之前执行
	@Before
	public void before() throws IOException{
		//1、获取SqlSessionFactory
		InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=ssfb.build(is);
		//2、获取SqlSession
		sqlSession=factory.openSession();
	}
	
	//在执行@Test注解的方法之后执行
	@After
	public void after(){
		//3、关闭SqlSession
		sqlSession.close();
	}
	
	/*
	 * 修改的操作
	 */
	@Test
	public void test01() throws IOException{
		//Map值传递
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("age", 25);
		//map.put("id", 2);
		//JavaBean值传递
		User user=new User();
		//修改语句是根据id来修改年龄，只需要设置User类的id和age属性
		user.setId(2);
		user.setAge(35);
		sqlSession.update("com.lddx.mapper.UserMapper.update01", user);
		System.out.println("修改成功");
	}
	
	/*
	 * 修改操作--动态sql语句写法
	 */
	@Test
	public void test02(){
		//选择JavaBean或者Map值传递
		//根据id修改年龄和姓名
		User user=new User();
		//user.setId(2);  //根据id=2来做条件查询
		//user.setName("zs");  //修改姓名为zs
		//user.setAge(40);     //修改年龄为40
		//根据id只修改年龄
		user.setId(2);
		user.setName(null);  //<if test="name!=null"...   条件不成立了
		user.setAge(18);
		sqlSession.update("com.lddx.mapper.UserMapper.update02",user);
		System.out.println("修改成功");
	}
	
	/*
	 * 查询操作--动态sql语句的写法
	 */
	@Test
	public void test03(){
		//选择用Map的方式进行值传递
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 3);
		//map.put("name", "zs");
		map.put("name", null); //设置name的那个条件不成立，不会根据name做查询了
		//map.put("age",18);
		map.put("age",-5);   //设置age的那个条件不成立，不会根据age做查询了
		User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select01", map);
		System.out.println(user);//User [age=18, id=2, name=zs]  null
	}
	
	/*
	 * 插入操作--动态sql语句的写法
	 */
	@Test
	public void test04(){
		//使用JavaBean的方式进行值的传递
		//User user=new User(200,"xh",16);
		//id为0，不插入id的值，会主键自动增长
		//name为null,不插入name的值，数据库中的name值就为null
		User user=new User(0,null,70);
		sqlSession.insert("com.lddx.mapper.UserMapper.insert01", user);
		System.out.println("插入成功");
	}
	
	/*
	 * 删除操作-使用动态sql语句的写法
	 */
	@Test
	public void test05(){
		//使用JavaBean的方式值的传递
		User user=new User(10,null,-1);
		sqlSession.delete("com.lddx.mapper.UserMapper.delete01", user);
		System.out.println("删除成功");
	}
	
	
}
