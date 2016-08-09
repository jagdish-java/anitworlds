package com.starWholesale.hb.dao;

import java.util.List;

import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;
import com.starWholesale.hb.entity.UserMaster;


public interface UserDao {

	public UserMaster addUser(UserMaster um) throws Exception;
	public boolean updateUser(UserMaster um) throws Exception;
	public UserMaster getUserById(int id) throws Exception;
	public List getUserList() throws Exception;
	public boolean deleteUser(int id) throws Exception;
	public boolean isUserExist(String email) throws Exception;
	public UserMaster registerUser(UserMaster um) throws Exception;
	public UserMaster login(String email,String password);
	public List<UserMaster> getUserByField(String fieldName, Object value) throws Exception;
}
