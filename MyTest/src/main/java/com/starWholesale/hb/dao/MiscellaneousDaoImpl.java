package com.starWholesale.hb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.FlyerMaster;
import com.starWholesale.hb.entity.ImageMaster;

@Repository
public class MiscellaneousDaoImpl implements MiscellaneousDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	
	@Override
	public boolean addDevice(DeviceTokenMaster device) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(device);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List getUserDevices(int userId) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List deviceList = session.createCriteria(DeviceTokenMaster.class)
								  .add(Restrictions.eq("userId", userId)).list();
		tx.commit();
		session.close();
		return deviceList;

	}

	@Override
	public List getDeviceList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List deviceList = session.createCriteria(DeviceTokenMaster.class).list();
		tx.commit();
		session.close();
		return deviceList;

	}
	
	@Override
	public boolean updateDevice(DeviceTokenMaster device) throws Exception{
		boolean result=false;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		DeviceTokenMaster d = (DeviceTokenMaster)getUserDevices(device.getUserId());
		d.setToken(device.getToken());
		session.update(d);
		tx.commit();
		session.close();
		return result;
	}
	
	@Override
	public boolean deleteDevice(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(DeviceTokenMaster.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

	@Override
	public boolean addFlyer(FlyerMaster flyer) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(flyer);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public FlyerMaster getFlyer(int flyerId) throws Exception {
		session = sessionFactory.openSession();
		FlyerMaster flyerMaster = (FlyerMaster) session.get(FlyerMaster.class,flyerId);
		return flyerMaster;
	}

	@Override
	public List getFlyerList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List flyerList = session.createCriteria(FlyerMaster.class).list();
		tx.commit();
		session.close();
		List<com.starWholesale.hb.dto.FlyerMaster> flyers = new ArrayList<com.starWholesale.hb.dto.FlyerMaster>();
		for(Object f : flyerList)
		{
			FlyerMaster flyer= (FlyerMaster)f;
			com.starWholesale.hb.dto.FlyerMaster flyerDTO = new com.starWholesale.hb.dto.FlyerMaster(
					flyer.getFlyerId(),
					flyer.getImageId(),
					flyer.getRedirectionUrl(),
					flyer.getDescription(),
					flyer.getCreatedDate(),
					flyer.getUpdatedDate(),
					flyer.getStatus()
					);
			ImageMaster image = getImage(flyer.getImageId());
			com.starWholesale.hb.dto.ImageMaster imageDTO = new com.starWholesale.hb.dto.ImageMaster(	image.getImageId(), 
																										image.getImageType(), 
																										image.getImageUrl(), image.getCreatedDate(), image.getUpdatedDate(), image.getStatus(), image.getReferenceId());
			flyerDTO.setImage(imageDTO);
			if(flyer.getStatus()==1)
				flyers.add(flyerDTO);
		}
		return flyers;
	}

	@Override
	public boolean deleteFlyer(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(FlyerMaster.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

	@Override
	public boolean addImage(ImageMaster image) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(image);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public ImageMaster getImage(int imageId) throws Exception {
		session = sessionFactory.openSession();
		ImageMaster imageMaster = (ImageMaster) session.get(ImageMaster.class,imageId);
		return imageMaster;
	}

	@Override
	public List getImageList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List imageList = session.createCriteria(ImageMaster.class).list();
		tx.commit();
		session.close();
		return imageList;
	}

	@Override
	public List getImageByType(int type) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List imageList = session.createCriteria(ImageMaster.class)
								.add(Restrictions.eq("imageType", type)).list();
		tx.commit();
		session.close();
		return imageList;
	}

	@Override
	public List getImageByType(int type, String refId) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List imageList = session.createCriteria(ImageMaster.class)
								.add(Restrictions.eq("imageType", type))
								.add(Restrictions.eq("referenceId", refId)).list();
		tx.commit();
		session.close();
		return imageList;
	}

	@Override
	public boolean deleteImage(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(ImageMaster.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}


}
