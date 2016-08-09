package com.starWholesale.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starWholesale.hb.dao.MiscellaneousDao;
import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.FlyerMaster;
import com.starWholesale.hb.entity.ImageMaster;

@Service
public class MiscellaneousServiceImpl implements MiscellaneousService {

	@Autowired
	MiscellaneousDao miscellaneousDao;
	
	@Override
	public boolean addDevice(DeviceTokenMaster device) throws Exception {
		
		return miscellaneousDao.addDevice(device);
	}

	@Override
	public List getUserDevices(int userId) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getUserDevices(userId);
	}

	@Override
	public List getDeviceList() throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getDeviceList();
	}

	@Override
	public boolean updateDevice(DeviceTokenMaster device) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.updateDevice(device);
	}

	@Override
	public boolean deleteDevice(int id) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.deleteDevice(id);
	}

	@Override
	public boolean addFlyer(FlyerMaster flyer) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.addFlyer(flyer);
	}

	@Override
	public FlyerMaster getFlyer(int flyerId) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getFlyer(flyerId);
	}

	@Override
	public List getFlyerList() throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getFlyerList();
	}

	@Override
	public boolean deleteFlyer(int id) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.deleteFlyer(id);
	}

	@Override
	public boolean addImage(ImageMaster image) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.addImage(image);
	}

	@Override
	public ImageMaster getImage(int imageId) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getImage(imageId);
	}

	@Override
	public List getImageList() throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getImageList();
	}

	@Override
	public List getImageByType(int type) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getImageByType(type);
	}

	@Override
	public List getImageByType(int type, String refId) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.getImageByType(type, refId);
	}

	@Override
	public boolean deleteImage(int id) throws Exception {
		// TODO Auto-generated method stub
		return miscellaneousDao.deleteImage(id);
	}

}
