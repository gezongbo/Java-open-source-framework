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
	 * 值的传递---Map传递
	 */
	@Test
	public void test01() throws IOException{
		//使用SqlSession进行数据库CRUD操作
		//在执行sql语句之前，需要对sql语句的${}的内容进行值的传递--使用Map传递
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("min",10);//往map集合中存储min的值为10
		map.put("max",25);//往map集合中存储max的值为25
		//selectList()适用于查询结果是多条的情况，MyBatis框架会将多条结果自动封装到集合中
		List<User> users=sqlSession.selectList("com.lddx.mapper.UserMapper.select01",map);
		System.out.println(users);
		//[User [age=19, id=1, name=aaa], User [age=20, id=2, name=bbb]]
		
	}
	
	/*
	 * 值的传递—javabean传递
	 */
	@Test
	public void test02(){
		//使用sqlSession进行CRUD操作（Create增加、Retrieve检索、Update更新、Delete删除）
		//创建一个javabean类，User类
		//User user=new User();
		//user.setId(1001);
		//user.setName("zs");
		//user.setAge(35);
		
		//使用Map的方式值传递
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",1002);
		map.put("name","ls");
		//map.put("age",69);
		//sql语句中的age是int类型，map传递的值是字符串类型，MyBatis框架会自动进行类型转换
		map.put("age", "69");
		sqlSession.insert("com.lddx.mapper.UserMapper.insert01",map);
		
		//如果不传递参数的值，#{id},#{name},#{age}这些内容会以null的方式进行插入
		//sqlSession.insert("com.lddx.mapper.UserMapper.insert01");
	}
	
	
	/*
	 * 值的传递--单值传递
	 */
	@Test
	public void test03(){
		//直接使用sqlSession完成CRUD操作
		//适合于只有一条结果的查询
		//selectOne方法会将查询出来的一条结果数据自动封装到User类中
		//方法1：单值传递
		//User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select02", 2);
		//方法2：Map传递
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("id", 1);
		//User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select02", map);
		//方法3；JavaBean传递  -->User类
		User u=new User();
		u.setId(2);//User-->id属性=2;
		User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select02",u);
		
		System.out.println(user);//User [age=19, id=1, name=aaa] User [age=20, id=2, name=bbb]
	}
	
	/*
	 * 例子：对user表进行分页查询
	 *     select * from user limit xx,xx;
	 */
	@Test
	public void test04(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", 1);
		map.put("count", 2);
		List<User> users=sqlSession.selectList("com.lddx.mapper.UserMapper.select03",map);
		System.out.println(users);
	}
	
	
	
	
	
	
	
	
	
}
