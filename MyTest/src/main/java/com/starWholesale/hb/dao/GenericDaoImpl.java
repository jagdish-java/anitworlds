package com.starWholesale.hb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	private Class<T> type;	
	
	public GenericDaoImpl() {
	    // TODO Auto-generated constructor stub

	}

	public GenericDaoImpl(Class<T> type) {
	
	    this.type = type;
	}
	
	@Override
	public T save(T emp) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.persist(emp);
		tx.commit();
		session.close();
		return emp;
	}

	@Override
	public Boolean delete(T emp) {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(emp);
		tx.commit();
		return true;
	}

	@Override
	public T edit(T emp) {
	    session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(emp);
		tx.commit();
		session.close();
		return emp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(Long empId) {
	    // TODO Auto-generated method stub
		session = sessionFactory.openSession();
		T emp = (T) session.get(type,empId);
		return emp;
	}

}
