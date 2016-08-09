package com.starWholesale.hb.service;

import java.util.List;

import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.FlyerMaster;
import com.starWholesale.hb.entity.ImageMaster;


public interface MiscellaneousService {

	public boolean addDevice(DeviceTokenMaster device) throws Exception;
	public List getUserDevices(int userId) throws Exception;
	public List getDeviceList() throws Exception;
	public boolean updateDevice(DeviceTokenMaster device) throws Exception;
	public boolean deleteDevice(int id) throws Exception;
	
	public boolean addFlyer(FlyerMaster flyer) throws Exception;
	public FlyerMaster getFlyer(int flyerId) throws Exception;
	public List getFlyerList() throws Exception;
	public boolean deleteFlyer(int id) throws Exception;
	
	public boolean addImage(ImageMaster image) throws Exception;
	public ImageMaster getImage(int imageId) throws Exception;
	public List getImageList() throws Exception;
	public List getImageByType(int type) throws Exception;
	public List getImageByType(int type,String refId) throws Exception;
	public boolean deleteImage(int id) throws Exception;
	
	
}
