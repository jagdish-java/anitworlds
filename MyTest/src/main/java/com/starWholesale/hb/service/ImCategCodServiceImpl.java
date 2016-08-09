package com.starWholesale.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starWholesale.hb.dao.CategoryDao;
import com.starWholesale.hb.dao.ImCategCodDao;
import com.starWholesale.hb.entity.ImCategCod;
import com.starWholesale.hb.entity.ImItem;

@Service
public class ImCategCodServiceImpl implements ImCategCodService {

	@Autowired
	ImCategCodDao categoryDao;
	
	
	
	@Override
	public ImCategCod getCategoryById(String id) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(id);
	}

	@Override
	public ImItem getProductById(String id) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getProductById(id);
	}

	@Override
	public List getProductByField(String field,Object value) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.getProductByField(field,value);
	}
	
	@Override
	public List getCategoryProductList(String categoryId) throws Exception {
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
