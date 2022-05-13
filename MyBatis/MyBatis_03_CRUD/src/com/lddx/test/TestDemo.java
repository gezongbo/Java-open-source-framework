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
	 * �޸ĵĲ���
	 */
	@Test
	public void test01() throws IOException{
		//Mapֵ����
		//Map<String,Object> map=new HashMap<String,Object>();
		//map.put("age", 25);
		//map.put("id", 2);
		//JavaBeanֵ����
		User user=new User();
		//�޸�����Ǹ���id���޸����䣬ֻ��Ҫ����User���id��age����
		user.setId(2);
		user.setAge(35);
		sqlSession.update("com.lddx.mapper.UserMapper.update01", user);
		System.out.println("�޸ĳɹ�");
	}
	
	/*
	 * �޸Ĳ���--��̬sql���д��
	 */
	@Test
	public void test02(){
		//ѡ��JavaBean����Mapֵ����
		//����id�޸����������
		User user=new User();
		//user.setId(2);  //����id=2����������ѯ
		//user.setName("zs");  //�޸�����Ϊzs
		//user.setAge(40);     //�޸�����Ϊ40
		//����idֻ�޸�����
		user.setId(2);
		user.setName(null);  //<if test="name!=null"...   ������������
		user.setAge(18);
		sqlSession.update("com.lddx.mapper.UserMapper.update02",user);
		System.out.println("�޸ĳɹ�");
	}
	
	/*
	 * ��ѯ����--��̬sql����д��
	 */
	@Test
	public void test03(){
		//ѡ����Map�ķ�ʽ����ֵ����
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 3);
		//map.put("name", "zs");
		map.put("name", null); //����name���Ǹ��������������������name����ѯ��
		//map.put("age",18);
		map.put("age",-5);   //����age���Ǹ��������������������age����ѯ��
		User user=sqlSession.selectOne("com.lddx.mapper.UserMapper.select01", map);
		System.out.println(user);//User [age=18, id=2, name=zs]  null
	}
	
	/*
	 * �������--��̬sql����д��
	 */
	@Test
	public void test04(){
		//ʹ��JavaBean�ķ�ʽ����ֵ�Ĵ���
		//User user=new User(200,"xh",16);
		//idΪ0��������id��ֵ���������Զ�����
		//nameΪnull,������name��ֵ�����ݿ��е�nameֵ��Ϊnull
		User user=new User(0,null,70);
		sqlSession.insert("com.lddx.mapper.UserMapper.insert01", user);
		System.out.println("����ɹ�");
	}
	
	/*
	 * ɾ������-ʹ�ö�̬sql����д��
	 */
	@Test
	public void test05(){
		//ʹ��JavaBean�ķ�ʽֵ�Ĵ���
		User user=new User(10,null,-1);
		sqlSession.delete("com.lddx.mapper.UserMapper.delete01", user);
		System.out.println("ɾ���ɹ�");
	}
	
	
}
