package com.lddx.test;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lddx.bean.User;

public class TestDemo {

	@Test
	public void test01() throws IOException{
		//ʹ������������ȡSqlMapConfig.xml�ļ�
		InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
		//����SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();	
		//���SqlSessionFactory����,ͨ��build��������õģ�build������Ҫ��������������ȡ���������ļ�
		SqlSessionFactory ssf=ssfb.build(is);
		//���SqlSession����
		SqlSession sqlSession=ssf.openSession();
		
		//ʹ��sqlSession����CRUD����
		//selectList�����Ĳ������ַ������ͣ�дҪִ�е�ӳ���ļ�UserMapper.xml�е��ĸ�sql�������ã�namespace+id��ɵ�����
		List<User> users=sqlSession.selectList("com.lddx.mapper.UserMapper.selectAll");
		System.out.println("users="+users);
		//users=[User [age=19, id=1, name=aaa], User [age=20, id=2, name=bbb], User [age=50, id=3, name=ccc]]
		
		//�ر�SqlSession����
		sqlSession.close();
	}
	/*
	 * jdbc
		String sql="select * from user";
		PreparedStatement prep=con.prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		List<User> users=new ArrayList<User>();
		while(rs.next()){
      		User user=new User();
      		user.setId(rs.getInt("id"));
      		user.setName(rs.getString("name"));
      		user.setAge(rs.getInt("age"));
     		users.add(user);
		}
		return users;
	 */
	
	
	
	
	
}
