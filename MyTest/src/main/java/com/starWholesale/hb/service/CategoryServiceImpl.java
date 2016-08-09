package com.starWholesale.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starWholesale.hb.dao.CategoryDao;
import com.starWholesale.hb.entity.CategoryMaster;
import com.starWholesale.hb.entity.ProductMaster;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	
	
	@Override
	public CategoryMaster getCategoryById(int id) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(id);
	}

	@Override
	public ProductMaster getProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getProductById(id);
	}

	@Override
	public List getCategoryProductList(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryProductList(categoryId);
	}

	@Override
	public List getCategoryList() throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryList();
	}

	@Override
	public List getProductList() throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getProductList();
	}

}
