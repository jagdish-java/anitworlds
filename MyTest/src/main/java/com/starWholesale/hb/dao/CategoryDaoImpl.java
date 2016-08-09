package com.starWholesale.hb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starWholesale.hb.entity.CategoryMaster;
import com.starWholesale.hb.entity.ProductMaster;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public CategoryMaster getCategoryById(int id) throws Exception {
		session = sessionFactory.openSession();
		CategoryMaster catMaster = (CategoryMaster) session.get(CategoryMaster.class,id);
		return catMaster;
	}

	@Override
	public ProductMaster getProductById(int id) throws Exception {
		session = sessionFactory.openSession();
		ProductMaster productMaster = (ProductMaster) session.get(ProductMaster.class,id);
		return productMaster;
	}

	@Override
	public List getCategoryProductList(int categoryId) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr=session.createCriteria(ProductMaster.class);
		cr.add(Restrictions.eq("categoryId", categoryId));
		List productList = cr.list();
		tx.commit();
		session.close();
		return productList;
	}

	@Override
	public List getCategoryList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List catList = session.createCriteria(CategoryMaster.class).list();
		tx.commit();
		session.close();
		return catList;
	}

	@Override
	public List getProductList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List productList = session.createCriteria(ProductMaster.class).list();
		tx.commit();
		session.close();
		return productList;
	}

	@Override
	public List getProductList(String fieldName, Object value) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr=session.createCriteria(ProductMaster.class);
		cr.add(Restrictions.eq(fieldName,value));
		List productList = cr.list();
		tx.commit();
		session.close();
		return productList;
		
	}

}
