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
	
	//��ִ��@Testע��ķ���֮ǰִ��
	@Before
	public void before() throws IOException{
		//1����ȡSqlSessionFactory
		InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=ssfb.build(is);
		//2����ȡSqlSession
		sqlSession=factory.openSession();
	}
	
	//��ִ��@Testע��ķ���֮��ִ��
	@After
	public void after(){
		//3���ر�SqlSession
		sqlSession.close();
	}
	
	

	/*
	 * ֵ�Ĵ���---Map����
	 */
	@Test
	public void test01() throws IOException{
		//ʹ��SqlSession�������ݿ�CRUD����
		//��ִ��sql���֮ǰ����Ҫ��sql����${}�����ݽ���ֵ�Ĵ���--ʹ��Map����
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("min",10);//��map�����д洢min��ֵΪ10
		map.put("max",25);//��map�����д洢max��ֵΪ25
		//selectList()�����ڲ�ѯ����Ƕ����������MyBatis��ܻὫ��������Զ���װ��������
		List<User> users=sqlSession.selectList("com.lddx.mapper.UserMapper.select01",map);
		System.out.println(users);
		//[User [age=19, id=1, name=aaa], User [age=20, id=2, name=bbb]]
		
	}
	
	/*
	 * ֵ�Ĵ��ݡ�javabean����
	 */
	@Test
	public void test02(){
		//ʹ��sqlSession����CRUD������Create���ӡ�Retrieve������Update���¡�Deleteɾ����
		//����һ��javabean�࣬User��
		//User user=new User();
		//user.setId(1001);
		//user.setName("zs");
		//user.setAge(35);
		
		//ʹ��Map�ķ�ʽֵ����
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",1002);
		map.put("name","ls");
		//map.put("age",69);
		//sql����е�age��int���ͣ�map���ݵ�ֵ���ַ������ͣ�MyBatis��ܻ��Զ���������ת��
		map.put("age", "69");
		sqlSession.insert("com.lddx.mapper.UserMapper.insert01",map);
		
		//��������ݲ�����ֵ��#{id},#{name},#{age}��Щ���ݻ���null�ķ�ʽ���в���
		//sqlSession.insert("com.lddx.mapper.UserMapper.insert01");
	}
	
	
	/*
	 * ֵ�Ĵ���--��ֵ����
	 */
	@Test
	public void test03(){
		//ֱ��ʹ��sqlSession���CRUD����
		//�ʺ���ֻ��һ������Ĳ�ѯ
		//selectOne�����Ὣ��ѯ������һ����������Զ���װ��User����
		//����1����ֵ����
		//User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select02", 2);
		//����2��Map����
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("id", 1);
		//User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select02", map);
		//����3��JavaBean����  -->User��
		User u=new User();
		u.setId(2);//User-->id����=2;
		User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select02",u);
		
		System.out.println(user);//User [age=19, id=1, name=aaa] User [age=20, id=2, name=bbb]
	}
	
	/*
	 * ���ӣ���user����з�ҳ��ѯ
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
