package com.starWholesale.hb.dao;

import java.util.List;

import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;


public interface CartDao {

/*	//URLs for Cart Operations
		public static final String CARTS_GET_ALL = "/star/carts";
		public static final String CARTS_GET_USERWISE = "/star/cart/{userid}";
		public static final String CART_GET = "/star/cart/{cartid}";
		public static final String CART_CREATE = "/star/cart/create";
		public static final String CART_UPDATE = "/star/cart/update";
		public static final String CART_ADD_PRODUCT = "/star/cart/add";
		public static final String CART_REMOVE_PRODUCT = "/star/cart/remove/{productid}";
		public static final String CART_UPDATE_PRODUCT = "/star/cart/change";
		public static final String CART_DELETE = "/star/cart/delete/{id}";
*/
	public List getCartList() throws Exception;
	public List getUserCarts(int userid) throws Exception;
	public CartMaster getCartById(int id) throws Exception;
	public boolean addCart(CartMaster cm) throws Exception;
	public boolean updateCart(CartMaster cm) throws Exception;
	public boolean addCartDetail(CartDetail cd) throws Exception;
	public boolean updateCartDetail(CartDetail cd) throws Exception;
	public boolean removeCartDetail(int id) throws Exception;
	public boolean deleteCart(int id) throws Exception;
}
