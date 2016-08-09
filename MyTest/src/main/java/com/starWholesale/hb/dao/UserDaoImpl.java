package com.starWholesale.hb.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starWholesale.hb.entity.ArCust;
import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.ImCategCod;
import com.starWholesale.hb.entity.ImageMaster;
import com.starWholesale.hb.entity.UserMaster;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	SessionFactory cpPracticeSessionFactory;

	@Autowired
	DataSource cpPracticeDataSource;
	
	
	Session session = null;
	Transaction tx = null;


	@Override
	public UserMaster addUser(UserMaster um) throws Exception {
		
		session = sessionFactory.openSession();
		
		tx = session.beginTransaction();
		um=(UserMaster) session.save(um);
		tx.commit();
		List<UserMaster> listUser = getUserByField("emailid",um.getEmailid());
		tx = session.beginTransaction();
		System.out.println(um.getDeviceToken());
		if(um.getDeviceToken()!=null)
		{
			
			DeviceTokenMaster deviceToken = new DeviceTokenMaster();
			deviceToken.setUserId(listUser.get(listUser.size()-1).getUserId());
			deviceToken.setDeviceType(um.getDeviceType());
			deviceToken.setToken(um.getDeviceToken());
			deviceToken.setCreatedDate(new Date());
			session.save(deviceToken);
		}
		tx.commit();
		
		session.close();
		return um;

	}

	@Override
	public boolean updateUser(UserMaster um) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(um);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public UserMaster getUserById(int id) throws Exception {
		session = sessionFactory.openSession();
		UserMaster userMaster = (UserMaster) session.get(UserMaster.class,id);
		return userMaster;

	}
	
	@Override
	public List<UserMaster> getUserByField(String fieldName,Object value) throws Exception {
		session = sessionFactory.openSession();
		
		Criteria cr = session.createCriteria(UserMaster.class,"user")
				.add(Restrictions.eq(fieldName,value));
	
		List<UserMaster> userMasters = cr.list();
		
		return userMasters;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getUserList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List employeeList = session.createCriteria(UserMaster.class).list();
		tx.commit();
		session.close();
		return employeeList;

	}

	@Override
	public boolean deleteUser(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(UserMaster.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

	@Override
	public boolean isUserExist(String email) throws Exception {
		session = cpPracticeSessionFactory.openSession();
		System.out.println("isUserExist-> email:"+email);
		Criteria cr = session.createCriteria(ArCust.class,"ar_cust")
				.add(Restrictions.eq("emailAdrs1",email));
	
		ArCust user = (ArCust) cr.uniqueResult();
		System.out.println("isUserExist-> user:"+user);
		
		if(user==null)
			return false;
		System.out.println("isUserExist-> custNo:"+user.getCustNo());
		
		return true;
	}

	@Override
	public UserMaster registerUser(UserMaster um) throws Exception {
		// TODO Auto-generated method stub
		if(isUserExist(um.getEmailid()))
		{
			um=addUser(um);
			um.setPassword("");
			return um;
		}
		return null;
	}

	@Override
	public UserMaster login(String email, String password) {
		session = sessionFactory.openSession();
		Criteria cr =  session.createCriteria(UserMaster.class,"userMaster")
													.add(Restrictions.eq("emailid", email))
													.add(Restrictions.eq("password", password));
		UserMaster user =  (UserMaster) cr.uniqueResult();
		user.setPassword("");
		return user;
		
	}

}
