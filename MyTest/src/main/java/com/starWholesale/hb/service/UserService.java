package com.starWholesale.hb.service;

import java.util.List;

import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;
import com.starWholesale.hb.entity.UserMaster;

public interface UserService {
	
	public UserMaster addUser(UserMaster user) throws Exception;
	public boolean updateUser(UserMaster user) throws Exception;
	public UserMaster getUserById(int id) throws Exception;
	public List getUserList() throws Exception;
	public boolean deleteUser(int id) throws Exception;
	public UserMaster registerUser(UserMaster um) throws Exception;
	public boolean isUserExist(UserMaster um) throws Exception;
	public UserMaster login(String email,String password) throws Exception;
	public List<UserMaster> getUserByField(String fieldName, Object value) throws Exception;
	
}
