package com.starWholesale.hb.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starWholesale.hb.entity.ImCategCod;
import com.starWholesale.hb.entity.ImItem;

@Repository
public class ImCategCodDaoImpl implements ImCategCodDao {

	@Autowired
	SessionFactory cpPracticeSessionFactory;

	@Autowired
	DataSource cpPracticeDataSource;
	
	Session session = null;
	Transaction tx = null;

	
	private static Projection itemProjection=Projections.projectionList()
			.add(Projections.property("im_item.itemNo"),"itemNo")
			.add(Projections.property("im_item.descr"), "descr")
			.add(Projections.property("im_item.descrUpr"), "descrUpr")
			.add(Projections.property("im_item.longDescr"), "longDescr")
			.add(Projections.property("im_item.longDescrUpr"), "longDescrUpr")
			.add(Projections.property("im_item.shortDescr"), "shortDescr")
			.add(Projections.property("im_item.itemTyp"), "itemTyp")
			.add(Projections.property("im_item.subcatCod"), "subcatCod")
			.add(Projections.property("im_item.qtyDecs"), "qtyDecs")
			.add(Projections.property("im_item.prcDecs"), "prcDecs")
			.add(Projections.property("im_item.stkUnit"), "stkUnit")
			.add(Projections.property("im_item.prc1"), "prc1")
			.add(Projections.property("im_item.barcod"), "barcod") ;
	
	private static Projection catProjection=Projections.projectionList()
		      .add(Projections.property("categCod"), "categCod")
		      .add(Projections.property("descr"), "descr")
		      .add(Projections.property("descrUpr"), "descrUpr")
		      .add(Projections.property("pftCtr"), "pftCtr")
		      .add(Projections.property("minPftPct"), "minPftPct");
		      
	@Override
	public ImCategCod getCategoryById(String id) throws Exception {
		session = cpPracticeSessionFactory.openSession();
		Criteria cr = session.createCriteria(ImCategCod.class)
				.add(Restrictions.eq("categCod",id))
			    .setProjection(catProjection)
			    .setResultTransformer(Transformers.aliasToBean(ImCategCod.class));
	
		ImCategCod catMaster = (ImCategCod) cr.uniqueResult();
		return catMaster;
	}

	@Override
	public ImItem getProductById(String id) throws Exception {
		session = cpPracticeSessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(ImItem.class,"im_item")
				.createAlias("im_item.cat", "im_categ_cod",JoinType.LEFT_OUTER_JOIN)
				.setProjection(Projections.projectionList()
						.add(Projections.property("im_categ_cod.categCod"), "cat.categCod")
					      .add(Projections.property("im_categ_cod.descr"), "cat.descr")
					      .add(Projections.property("im_categ_cod.descrUpr"), "cat.descrUpr")
					      .add(Projections.property("im_categ_cod.pftCtr"), "cat.pftCtr")
					      .add(Projections.property("im_categ_cod.minPftPct"), "cat.minPftPct")
				.add(itemProjection))
				.add(Restrictions.eq("im_item.itemNo",id))
			    .setResultTransformer(new AliasToBeanNestedResultTransformer(ImItem.class));//(Transformers.aliasToBean(ImItem.class));
			
	
		ImItem productMaster = (ImItem) cr.uniqueResult();
		return productMaster;
	}

	@Override
	public List<ImItem> getProductByField(String field,Object value) throws Exception {
		session = cpPracticeSessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(ImItem.class,"im_item")
				.createAlias("im_item.cat", "im_categ_cod",JoinType.LEFT_OUTER_JOIN)
				.setProjection(Projections.projectionList()
						.add(Projections.property("im_categ_cod.categCod"), "cat.categCod")
					      .add(Projections.property("im_categ_cod.descr"), "cat.descr")
					      .add(Projections.property("im_categ_cod.descrUpr"), "cat.descrUpr")
					      .add(Projections.property("im_categ_cod.pftCtr"), "cat.pftCtr")
					      .add(Projections.property("im_categ_cod.minPftPct"), "cat.minPftPct")
				.add(itemProjection))
				.add(Restrictions.eq(field,value))
				.setResultTransformer(new AliasToBeanNestedResultTransformer(ImItem.class));//(Transformers.aliasToBean(ImItem.class));
			
	
		List<ImItem> productMasterList = cr.list();
		return productMasterList;
	}

	
	@Override
	public List getCategoryProductList(String categoryId) throws Exception {
		session = cpPracticeSessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(ImItem.class,"im_item")
				.createAlias("im_item.cat", "im_categ_cod",JoinType.LEFT_OUTER_JOIN)
				.setProjection(Projections.projectionList()
				.add(itemProjection))
				.add(Restrictions.eq("im_categ_cod.categCod",categoryId))
			    .setResultTransformer(new AliasToBeanNestedResultTransformer(ImItem.class));//(Transformers.aliasToBean(ImItem.class));
			
		List productList = cr.list();
		tx.commit();
		session.close();
		return productList;
	}

	@Override
	public List getCategoryList() throws Exception {
		session = cpPracticeSessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria cr = session.createCriteria(ImCategCod.class,"categories")
				.createAlias("categories.imItem", "imItem",JoinType.LEFT_OUTER_JOIN)
				.setProjection(catProjection)
				.setResultTransformer(Transformers.aliasToBean(ImCategCod.class));//new AliasToBeanNestedResultTransformer(ImCategCod.class));//
	
			List catList = cr.list();
		tx.commit();
		session.close();
		return catList;
	}

	@Override
	public List getProductList() throws Exception {
		session = cpPracticeSessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria cr = session.createCriteria(ImItem.class,"im_item")
				.createAlias("im_item.cat", "im_categ_cod",JoinType.LEFT_OUTER_JOIN)
				.setProjection(Projections.projectionList()
						.add(Projections.property("im_categ_cod.categCod"), "cat.categCod")
				.add(itemProjection))
			    .setResultTransformer(new AliasToBeanNestedResultTransformer(ImItem.class));//(Transformers.aliasToBean(ImItem.class));
	
		List productList = cr.list();
		tx.commit();
		session.close();
		return productList;
	}
	
	

}
