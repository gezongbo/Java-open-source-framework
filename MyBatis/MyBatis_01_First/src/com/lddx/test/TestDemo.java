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
		//使用输入流来读取SqlMapConfig.xml文件
		InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();	
		//获得SqlSessionFactory对象,通过build方法来获得的，build方法需要传入用输入流读取到的配置文件
		SqlSessionFactory ssf=ssfb.build(is);
		//获得SqlSession对象
		SqlSession sqlSession=ssf.openSession();
		
		//使用sqlSession进行CRUD操作
		//selectList方法的参数是字符串类型，写要执行的映射文件UserMapper.xml中的哪个sql语句的配置，namespace+id组成的内容
		List<User> users=sqlSession.selectList("com.lddx.mapper.UserMapper.selectAll");
		System.out.println("users="+users);
		//users=[User [age=19, id=1, name=aaa], User [age=20, id=2, name=bbb], User [age=50, id=3, name=ccc]]
		
		//关闭SqlSession对象
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
