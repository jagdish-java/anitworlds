package com.starWholesale.hb.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starWholesale.hb.dto.StatusDTO;
import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.FlyerMaster;
import com.starWholesale.hb.entity.ImItem;
import com.starWholesale.hb.entity.ImageMaster;
import com.starWholesale.hb.entity.UserMaster;
import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.service.ImCategCodService;
import com.starWholesale.hb.service.MiscellaneousService;



@Controller
public class MiscellaneousController {

	@Autowired
	 MiscellaneousService dataServices;
	
	@Autowired
	ImCategCodService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(MiscellaneousController.class);

	// DEVICE OPERATIONS
	
	@RequestMapping(value = UrlConstants.DEVICE_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllDevicesGET() throws Exception {
		return getAllDevices();
	}		
	@RequestMapping(value = UrlConstants.DEVICE_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllDevicesPOST() throws Exception {
		return getAllDevices();
	}		
	private StatusDTO getAllDevices() throws Exception {

		logger.info("Getting all devices.");
		
		List<DeviceTokenMaster> devices = dataServices.getDeviceList();
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(devices);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.DEVICE_GET_USER, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getUserDevicesGET(@PathVariable("userId") int userId) throws Exception {
		return getUserDevices(userId);
	}
	@RequestMapping(value = UrlConstants.DEVICE_GET_USER, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getUserDevicesPOST(@RequestParam("userId") int userId) throws Exception {
		return getUserDevices(userId);
	}
	
	private StatusDTO getUserDevices(int userId) throws Exception {

		logger.info("Start all devices of a user.");
		
		List<DeviceTokenMaster> devices = dataServices.getUserDevices(userId);
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(devices);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.DEVICE_CREATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO addDevice(@RequestBody DeviceTokenMaster device) {
		logger.info("Adding new Device.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			device.setCreatedDate(new Date());
			dataServices.addDevice(device);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(device);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Device");
			statusDTO.setMessageObject(e.getMessage());
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.DEVICE_UPDATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO updateDevice(@RequestBody DeviceTokenMaster device) {
		logger.info("Adding new Device.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			device.setCreatedDate(new Date());
			dataServices.updateDevice(device);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(device);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Device");
			statusDTO.setMessageObject(e.getMessage());
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.DEVICE_DELETE, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO deleteDeviceGET(@PathVariable("deviceId") int deviceId) throws Exception {
		return deleteDevice(deviceId);
	}	
	@RequestMapping(value = UrlConstants.DEVICE_DELETE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO deleteDevicePOST(@RequestParam("deviceId") int deviceId) throws Exception {
		return deleteDevice(deviceId);
	}
	private StatusDTO deleteDevice(int deviceId) throws Exception {
		logger.info("Deleting Device.");
		boolean result=dataServices.deleteDevice(deviceId);
		StatusDTO statusDTO = new StatusDTO();
		if(result){
				statusDTO.setStatusCode(1);
				statusDTO.setStatusMessage("Successfully Retrived");
				statusDTO.setMessageObject(null);
		}else{
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Cannot Delete");
			statusDTO.setMessageObject(null);
		}
		return statusDTO;
	}

	//FLYER OPERATIONS
	
	@RequestMapping(value = UrlConstants.FLYER_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllFlyersGET() throws Exception {
		return getAllFlyers();
	}
	@RequestMapping(value = UrlConstants.FLYER_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllFlyersPOST() throws Exception {
			return getAllFlyers();
	}

	private StatusDTO getAllFlyers() throws Exception {
		logger.info("Getting all flyers.");
		
		List<ImageMaster> flyers = dataServices.getImageByType(UrlConstants.IMAGE_TYPE_FLYER);//dataServices.getFlyerList();
		List<String> flyerUrls = new ArrayList<String>();
		for(ImageMaster flyer:flyers)
		{
			String imageUrl = flyer.getImageUrl();
			flyerUrls.add(imageUrl);
		}
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(flyerUrls);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.FLYER_GET_ONE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getFlyerGET(@PathVariable("flyerId") int flyerId) throws Exception {
		return getFlyer(flyerId);
	}
	
	@RequestMapping(value = UrlConstants.FLYER_GET_ONE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getFlyerPOST(@RequestParam("flyerId") int flyerId) throws Exception {
		return getFlyer(flyerId);
	}

	private StatusDTO getFlyer(int flyerId) throws Exception {
		logger.info("Start getFlyerMaster. ID=" + flyerId);
		FlyerMaster flyer= dataServices.getFlyer(flyerId);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(flyer);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.FLYER_CREATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO addFlyer(@RequestBody FlyerMaster flyer) {
		logger.info("Adding new Device.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			flyer.setCreatedDate(new Date());
			dataServices.addFlyer(flyer);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(flyer);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Device");
			statusDTO.setMessageObject(e.getMessage());
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.FLYER_DELETE, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO deleteFlyerPUT(@PathVariable("flyerId") int flyerId) throws Exception {
		return deleteFlyer(flyerId);
	}
	
	@RequestMapping(value = UrlConstants.FLYER_DELETE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO deleteFlyerPOST(@RequestParam("flyerId") int flyerId) throws Exception {
		return deleteFlyer(flyerId);
	}
	

	private StatusDTO deleteFlyer(int flyerId) throws Exception {

		logger.info("Deleting Device.");
		boolean result=dataServices.deleteFlyer(flyerId);
		StatusDTO statusDTO = new StatusDTO();
		if(result){
				statusDTO.setStatusCode(1);
				statusDTO.setStatusMessage("Successfully Retrived");
				statusDTO.setMessageObject(null);
		}else{
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Cannot Delete");
			statusDTO.setMessageObject(null);
		}
		return statusDTO;
	}

	//IMAGE OPERATIONS
	
	@RequestMapping(value = UrlConstants.IMAGE_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllImagesGET() throws Exception {
		return getAllImages();
	}
	@RequestMapping(value = UrlConstants.IMAGE_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllImagesPOST() throws Exception {
		return getAllImages();
	}

	public StatusDTO getAllImages() throws Exception {
		logger.info("Getting all images.");
		
		List<ImageMaster> images = dataServices.getImageList();
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(images);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.IMAGE_GET_ONE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getImageGET(@PathVariable("imageId") int imageId) throws Exception {
		return getImage(imageId);
	}
	@RequestMapping(value = UrlConstants.IMAGE_GET_ONE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getImagePOST(@RequestParam("imageId") int imageId) throws Exception {
		return getImage(imageId);
	}

	private StatusDTO getImage(int imageId) throws Exception {

		logger.info("Start getImageMaster. ID=" + imageId);
		ImageMaster image= dataServices.getImage(imageId);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(image);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.IMAGE_CREATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO addImage(@RequestBody ImageMaster image) {
		logger.info("Adding new Device.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			image.setCreatedDate(new Date());
			dataServices.addImage(image);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(image);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Device");
			statusDTO.setMessageObject(e.getMessage());
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.IMAGE_DELETE, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO deleteImageGET(@PathVariable("imageId") int imageId) throws Exception {
		return deleteImage(imageId);
	}
	
	@RequestMapping(value = UrlConstants.IMAGE_DELETE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO deleteImagePOST(@PathVariable("imageId") int imageId) throws Exception {
		return deleteImage(imageId);
	}
	private StatusDTO deleteImage(int imageId) throws Exception {
	logger.info("Deleting Device.");

		boolean result=dataServices.deleteImage(imageId);
		StatusDTO statusDTO = new StatusDTO();
		if(result){
				statusDTO.setStatusCode(1);
				statusDTO.setStatusMessage("Successfully Retrived");
				statusDTO.setMessageObject(null);
		}else{
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Cannot Delete");
			statusDTO.setMessageObject(null);
		}
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.IMAGE_GET_TYPE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getImageByTypeGET(@PathVariable("type") int type) throws Exception {
		return  getImageByType(type);
	}
	@RequestMapping(value = UrlConstants.IMAGE_GET_TYPE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getImageByTypePOST(@RequestParam("type") int type) throws Exception {
		return  getImageByType(type);
	}
	private StatusDTO getImageByType(int type) throws Exception {
		logger.info("Start all images by type of a user.");
		
		List<ImageMaster> images = dataServices.getImageByType(type);
		List<String> imageUrls = new ArrayList<String>();
		for(ImageMaster flyer:images)
		{
			String imageUrl = flyer.getImageUrl();
			imageUrls.add(imageUrl);
		}
		
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(imageUrls);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.IMAGE_GET_TYPE_REF, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getImageByTypeGET(@PathVariable("type") int type,@PathVariable("refId") String refId) throws Exception {
		return getImageByType(type,refId);
	}
	@RequestMapping(value = UrlConstants.IMAGE_GET_TYPE_REF, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getImageByTypePOST(@RequestParam("type") int type,@RequestParam("refId") String refId) throws Exception {
		return getImageByType(type,refId);
	}
	private StatusDTO getImageByType(int type,String refId) throws Exception {
		logger.info("Start all images by type of a user.");
		
		List<ImageMaster> images = dataServices.getImageByType(type,refId);
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(images);
		return statusDTO;
	}
	
	
}
