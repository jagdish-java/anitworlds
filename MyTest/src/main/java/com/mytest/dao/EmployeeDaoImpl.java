package com.mytest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory demoSessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Employee e) throws Exception {

		session = demoSessionFactory.openSession();
		tx = session.beginTransaction();
		session.persist(e);
		tx.commit();
		session.close();
		return true;
	}
	
	@Override
	public boolean addAddressEntity(Empaddress empaddress) throws Exception {

		session = demoSessionFactory.openSession();
		tx = session.beginTransaction();
		session.persist(empaddress);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Employee getEntityById(long id) throws Exception {

		session = demoSessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class,new Long(id));
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getEntityList() throws Exception {

		session = demoSessionFactory.openSession();
		tx = session.beginTransaction();
		List employeeList = session.createCriteria(Employee.class).list();
		tx.commit();
		session.close();
		return employeeList;

	}

	@Override
	public boolean deleteEntity(long id) throws Exception {

		session = demoSessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
