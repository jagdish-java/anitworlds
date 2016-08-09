package com.starWholesale.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starWholesale.hb.dao.CartDao;
import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	@Override
	public List<?> getCartList() throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getCartList();
	}

	@Override
	public List<?> getUserCarts(int userid) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getUserCarts(userid);
	}

	@Override
	public CartMaster getCartById(int id) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getCartById(id);
	}

	@Override
	public boolean addCart(CartMaster cm) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.addCart(cm);
	}

	@Override
	public boolean updateCart(CartMaster cm) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.updateCart(cm);
	}

	@Override
	public boolean addCartDetail(CartDetail cd) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.addCartDetail(cd);
	}

	@Override
	public boolean updateCartDetail(CartDetail cd) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.updateCartDetail(cd);
	}

	@Override
	public boolean removeCartDetail(int id) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.removeCartDetail(id);
	}

	@Override
	public boolean deleteCart(int id) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

}
