package com.starWholesale.hb.service;

import java.util.List;

import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;
import com.starWholesale.hb.entity.ImCategCod;
import com.starWholesale.hb.entity.ImItem;


public interface ImCategCodService {

/*	public boolean addCategory(ImCategCod cm) throws Exception;
	public boolean updateCategory(ImCategCod cm) throws Exception;
	public boolean addProduct(ImItem pm) throws Exception;
	public boolean updateProduct(ImItem pm) throws Exception;
*/	public ImCategCod getCategoryById(String id) throws Exception;
	public ImItem getProductById(String id) throws Exception;
	public List getCategoryProductList(String categoryId) throws Exception;
	public List getCategoryList() throws Exception;
	public List getProductList() throws Exception;
//	public boolean deleteCategory(long id) throws Exception;
	List getProductByField(String field, Object value) throws Exception;
	
}
