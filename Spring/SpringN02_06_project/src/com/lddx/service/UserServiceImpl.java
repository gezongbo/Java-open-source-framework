package com.lddx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lddx.dao.MySqlUserDao;
import com.lddx.dao.OracleUserDao;
import com.lddx.dao.UserDao;

//ģ�Ͳ�Model��
//ҵ����ʲ�Service��
/*
 * Spring�ײ㣺UserServiceImpl usi=new UserServiceImpl();
 *           Map.put("userServiceImpl",usi);
 */
@Service("serviceImpl")     //idĬ���ƶϵ�ֵ   id="userServiceImpl"
public class UserServiceImpl implements ServiceImpl{
	//��װ˽������
	//��Service���е���MySqlUserDao
	//private MySqlUserDao userDao=new MySqlUserDao();
	//��Service���е���OracleUserDao
	//private OracleUserDao userDao=new OracleUserDao();
	//˼����������ݿⷢ���仯��Service����Ҫ�޸Ĵ��룬�����֮�����϶Ƚϸ�
	//��϶ȸߵ�ԭ���������棺һ��������Ҫ�䣬��ҪMySqlUserDao��OracleUserDao���������л�
	//                 ��һ������new�����Ķ���Ҫ�仯����Ҫnew MySqlUserDao()��new OracleUserDao()�����л�
	//�������ϣ�һ������ ����ӿڱ��
	//        ��һ����Ľ����Spring����е�IOC+DI
	//private UserDao userDao=new MySqlUserDao();
	//private UserDao userDao=new OracleUserDao();
	//ע��ʵ��DI����ע��
	//�Զ�װ���ʵ��ԭ���ȸ�������ƥ����ң�����UserDao������ƥ����ң����ҵ�3�����ֱ���UserDao,MySqlUserDao,OracleUserDao
	//Ȼ���ڸ���id���в��ң�����������userDaoȥ����id��ֵ���ҵ���idΪmysqlUserDao��oracleUserDao����ֵ��
	@Autowired
	private UserDao userDao;

	
	//��װһ������
	public void addUserService(){
		//��Service���е���Dao��
		userDao.addUser();
	}
	
}
