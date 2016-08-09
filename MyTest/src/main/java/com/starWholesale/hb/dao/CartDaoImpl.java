package com.starWholesale.hb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public List<?> getCartList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<?> cartList = session.createCriteria(CartMaster.class).list();
		tx.commit();
		session.close();
		return cartList;
	}

	@Override
	public List<?> getUserCarts(int userid) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr=session.createCriteria(CartMaster.class);
		cr.add(Restrictions.eq("userId", userid));
		List<?> cartList = cr.list();
		tx.commit();
		session.close();
		return cartList;
	}

	@Override
	public CartMaster getCartById(int id) throws Exception {
		session = sessionFactory.openSession();
		CartMaster cartMaster = (CartMaster) session.get(CartMaster.class,id);
		return cartMaster;

	}

	@Override
	public boolean addCart(CartMaster cm) throws Exception {
		session = sessionFactory.openSession();
		List<CartDetail> cdList= cm.getCartItems();
		cm.setCartItems(null);
		tx = session.beginTransaction();
		session.save(cm);
		for(CartDetail cd : cdList)
		{
			cd.setCart(cm);
			session.saveOrUpdate(cd);
		}
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateCart(CartMaster cm) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(cm);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public boolean addCartDetail(CartDetail cd) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(cd);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateCartDetail(CartDetail cd) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(cd);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public boolean removeCartDetail(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(CartDetail.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

	@Override
	public boolean deleteCart(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(CartMaster.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

}
