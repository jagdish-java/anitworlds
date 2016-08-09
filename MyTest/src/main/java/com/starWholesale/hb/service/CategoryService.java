package com.starWholesale.hb.service;

import java.util.List;

import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;
import com.starWholesale.hb.entity.CategoryMaster;
import com.starWholesale.hb.entity.ProductMaster;


public interface CategoryService {

/*	public boolean addCategory(CategoryMaster cm) throws Exception;
	public boolean updateCategory(CategoryMaster cm) throws Exception;
	public boolean addProduct(ProductMaster pm) throws Exception;
	public boolean updateProduct(ProductMaster pm) throws Exception;
*/	public CategoryMaster getCategoryById(int id) throws Exception;
	public ProductMaster getProductById(int id) throws Exception;
	public List getCategoryProductList(int categoryId) throws Exception;
	public List getCategoryList() throws Exception;
	public List getProductList() throws Exception;
//	public boolean deleteCategory(long id) throws Exception;
	
}
