package com.starWholesale.hb.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starWholesale.hb.dao.MiscellaneousDao;
import com.starWholesale.hb.dto.StatusDTO;
import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.UserMaster;
import com.starWholesale.hb.service.MiscellaneousService;
import com.starWholesale.hb.service.UserService;

/**
 * Handles requests for the UserMaster service.
 */

@Controller
public class UserController {

	 @Autowired
	 UserService dataServices;

	 @Autowired
	 MiscellaneousService miscellaneousServices;
	 
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	// Map to store UserMasters, ideally we should use database
	Map<Long, UserMaster> userData = new HashMap<Long, UserMaster>();

	@RequestMapping(value = UrlConstants.USER_DUMMY, method = RequestMethod.GET)
	public @ResponseBody StatusDTO addDummyUser() throws Exception {
		logger.info("Start getDummyUserMaster");
		UserMaster user = new UserMaster();
		
		user.setCreatedDate(new Date());
		user.setEmailid("jagdish.bhanushali@gmail.com");
		user.setFirstname("Jagdish");
		user.setImageId(1);
		user.setLastname("Bhanushali");
		user.setMobileno("9999900000");
		user.setPassword("password");
		user.setStatus(1);
		user.setTitle("Mr.");
		user.setUpdatedDate(new Date());
		dataServices.addUser(user);
		StatusDTO statusDTO = new StatusDTO(1,"Successfully Created",user);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.USER_GET_ONE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getUserByIDGet(@PathVariable("id") int userId) throws Exception {
		logger.info("Start getUserMaster. ID=" + userId);
		return getUserByID(userId);
	}
	
	@RequestMapping(value = UrlConstants.USER_GET_ONE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getUserByIDPost(@RequestParam("id") int userId) throws Exception {
		logger.info("Start getUserMaster. ID=" + userId);
		return getUserByID(userId);
	}
	
	private StatusDTO getUserByID(int userId)  throws Exception{
		UserMaster user= dataServices.getUserById(userId);
		
		com.starWholesale.hb.dto.UserMaster userMasterDTO = copyFromEntity(user);
		
		StatusDTO statusDTO = new StatusDTO(1,"Successfully Retrived",userMasterDTO);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.USER_GET_FIELD, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getUserByFieldGet(@PathVariable("fieldName") String fieldName,@PathVariable("value") Object value) throws Exception {
		logger.info("Start getUserMaster. FieldName=" + fieldName);
		return getUserByField(fieldName, value);
	}
	
	@RequestMapping(value = UrlConstants.USER_GET_FIELD, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getUserByFieldPost(@RequestParam("fieldName") String fieldName,@RequestParam("value") Object value) throws Exception {
		logger.info("Start getUserMaster. FieldName=" + fieldName);
		return getUserByField(fieldName, value);
	}

	private StatusDTO getUserByField(String fieldName,Object value)  throws Exception{
		List<UserMaster> user= dataServices.getUserByField(fieldName, value);
		
		List<com.starWholesale.hb.dto.UserMaster> userMasterDTO = copyFromEntity(user);
		
		StatusDTO statusDTO = new StatusDTO(1,"Successfully Retrived",userMasterDTO);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.USER_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllUserGET() throws Exception {
		return getAllUsers();
	}

	@RequestMapping(value = UrlConstants.USER_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllUserPOST() throws Exception {
		return getAllUsers();
	}
	
	private StatusDTO getAllUsers() throws Exception
	{
		logger.info("Start getAllUsers.");
		
		List<UserMaster> users = dataServices.getUserList();
		List<com.starWholesale.hb.dto.UserMaster> returnObj = copyFromEntity(users);	
		StatusDTO statusDTO = new StatusDTO(1,"Successfully Retrived",returnObj);
		return statusDTO;
	}
	
	private List<com.starWholesale.hb.dto.UserMaster> copyFromEntity(List<UserMaster> users){
		Iterator<UserMaster> iteratoruser = users.iterator();
		List<com.starWholesale.hb.dto.UserMaster> returnObj= new ArrayList<com.starWholesale.hb.dto.UserMaster>();
		
		while(iteratoruser.hasNext()){
			com.starWholesale.hb.dto.UserMaster userMasterDTO = new com.starWholesale.hb.dto.UserMaster();
			UserMaster user = iteratoruser.next();
			if(!contains(returnObj,user.getUserId())) {
				userMasterDTO = copyFromEntity(user);
				returnObj.add(userMasterDTO);
			}
		}
		return returnObj;
	}
	
 	private com.starWholesale.hb.dto.UserMaster copyFromEntity(UserMaster user)
	{
		if(user==null)return null;
		com.starWholesale.hb.dto.UserMaster userMaster = new com.starWholesale.hb.dto.UserMaster();
		userMaster.setCreatedDate(user.getCreatedDate());
		userMaster.setEmailid(user.getEmailid());
		userMaster.setFirstname(user.getFirstname());
		userMaster.setImageId(user.getImageId());
		userMaster.setLastname(user.getLastname());
		userMaster.setMobileno(user.getMobileno());
		userMaster.setPassword(user.getPassword());
		userMaster.setStatus(user.getStatus());
		userMaster.setTitle(user.getTitle());
		userMaster.setUpdatedDate(user.getUpdatedDate());
		userMaster.setUserId(user.getUserId());
		
		return userMaster;
	}
	
	private boolean contains(List<com.starWholesale.hb.dto.UserMaster> list, int userid) {
	    for (com.starWholesale.hb.dto.UserMaster item : list) {
	        if (item.getUserId()==userid) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	@RequestMapping(value = UrlConstants.USER_CREATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO createUserMaster(@RequestBody UserMaster user) {
		logger.info("Start createUser.");
		StatusDTO statusDTO;
		try {
			user.setCreatedDate(new Date());
			dataServices.addUser(user);
			statusDTO=new StatusDTO(1,"Successfully Created",user);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO = new StatusDTO(0,"Exception Occurred while creating new User",e.getMessage());
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.USER_LOGIN, method = RequestMethod.POST)
	public @ResponseBody StatusDTO login(@RequestParam("emailid") String email,@RequestParam("password") String password) {
		logger.info("Start login service.");
		StatusDTO statusDTO;
		try {
			UserMaster result=dataServices.login(email, password);
			if(result!=null)
				statusDTO=new StatusDTO(1,"Successfully Logged In",result);
			else 
				statusDTO=new StatusDTO(2,"User Not Found","");
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO = new StatusDTO(0,"Exception Occurred while logging in",e.getMessage());
			return statusDTO;
			
		}
	}

	@RequestMapping(value = UrlConstants.USER_LOGIN_DEVICE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO login(@RequestParam("emailid") String email,@RequestParam("password") String password,@RequestParam("deviceToken") String deviceToken,@RequestParam("deviceType") String deviceType) {
		logger.info("Start login service.");
		StatusDTO statusDTO;
		try {
			UserMaster result=dataServices.login(email, password);
			
			if(result!=null){
				
				statusDTO=new StatusDTO(1,"Successfully Logged In",result);
				DeviceTokenMaster device = new DeviceTokenMaster();
				device.setUserId(result.getUserId());
				device.setToken(deviceToken);
				device.setDeviceType(deviceType);
				device.setCreatedDate(new Date());
				miscellaneousServices.updateDevice(device);
				System.out.println("Device Token :"+deviceToken);
			}else 
				statusDTO=new StatusDTO(2,"User Not Found","");
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO = new StatusDTO(0,"Exception Occurred while logging in",e.getMessage());
			return statusDTO;
			
		}
	}

	
	@RequestMapping(value = UrlConstants.USER_REGISTER, method = RequestMethod.POST)
	public @ResponseBody StatusDTO registerUser(@ModelAttribute UserMaster user) {
		logger.info("Start register User.");
		StatusDTO statusDTO;
		try {
			user.setCreatedDate(new Date());
			UserMaster result = dataServices.registerUser(user);
			if(result!=null)
				statusDTO = new StatusDTO(1,"Successfully Registered",result);
			else
				statusDTO = new StatusDTO(2,"User Does not exist","");
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO = new StatusDTO(0,"Exception Occurred while registering new User",e.getMessage());
			e.printStackTrace();
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.USER_DELETE, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO deleteUserMaster(@PathVariable("id") int userId) throws Exception {
		logger.info("Start deleteUserMaster.");
		boolean result=dataServices.deleteUser(userId);
		StatusDTO statusDTO;
		if(result){
				statusDTO= new StatusDTO(1,"Successfully Retrived");
		}else{
			statusDTO= new StatusDTO(0,"Cannot Delete");
		}
		return statusDTO;
		
	}
}