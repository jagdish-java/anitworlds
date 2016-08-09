package com.starWholesale.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;
import com.starWholesale.hb.dao.UserDao;
import com.starWholesale.hb.entity.UserMaster;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public UserMaster addUser(UserMaster user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(UserMaster user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	

	@Override
	public UserMaster getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public List<UserMaster> getUserByField(String fieldName,Object value) throws Exception {
		return userDao.getUserByField(fieldName, value);
	}
	@Override
	public List getUserList() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

	@Override
	public boolean deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public UserMaster registerUser(UserMaster um) throws Exception {
		// TODO Auto-generated method stub
		return userDao.registerUser(um);
	}

	@Override
	public boolean isUserExist(UserMaster um) throws Exception {
		// TODO Auto-generated method stub
		return userDao.isUserExist(um.getEmailid());
	}

	@Override
	public UserMaster login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return userDao.login(email, password);
	}

	

}
