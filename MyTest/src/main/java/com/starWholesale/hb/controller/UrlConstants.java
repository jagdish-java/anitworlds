package com.starWholesale.hb.controller;

import java.util.List;

import com.starWholesale.hb.entity.DeviceTokenMaster;
import com.starWholesale.hb.entity.FlyerMaster;
import com.starWholesale.hb.entity.ImageMaster;

public class UrlConstants {

	//URLs for User Operations
	public static final String USER_DUMMY = "/star/user/dummy";
	public static final String USER_GET_ONE = "/star/user/{id}";
	public static final String USER_GET_ALL = "/star/users";
	public static final String USER_CREATE = "/star/user/create";
	public static final String USER_REGISTER = "/star/user/register";
	public static final String USER_DELETE = "/star/user/delete/{id}";
	public static final String USER_UPDATE = "/star/user/update";
	public static final String USER_LOGIN = "/star/user/login";
	public static final String USER_LOGIN_DEVICE = "/star/user/login/device";
	public static final String USER_GET_FIELD = "/star/user/{fieldName}/{value}";
	//URLs for Cart Operations
	public static final String CARTS_GET_ALL = "/star/carts";
	public static final String CARTS_GET_USERWISE = "/star/cart/user/{userid}";
	public static final String CART_GET = "/star/cart/{cartid}";
	public static final String CART_CREATE = "/star/cart/create";
	public static final String CART_UPDATE = "/star/cart/update";
	public static final String CART_ADD_PRODUCT = "/star/cart/add";
	public static final String CART_REMOVE_PRODUCT = "/star/cart/remove/{productid}";
	public static final String CART_UPDATE_PRODUCT = "/star/cart/change";
	public static final String CART_DELETE = "/star/cart/delete/{id}";
	
	
	//URLs for Category Operations
	public static final String CAT_GET_ALL = "/star/cats";
	public static final String CAT_GET = "/star/cat/{catid}";
	public static final String CAT_GET_PRODUCTS = "/star/cat/products/{catid}";
	public static final String CAT_GET_PRODUCTS_WITH_IMAGE = "/star/cat/products/image/{catid}";
	public static final String CAT_CREATE = "/star/cat/create";
	public static final String CAT_UPDATE = "/star/cat/update";
	public static final String CAT_DELETE = "/star/cat/delete/{id}";

	//URLs for Product Operations
	public static final String PRODUCT_GET_ALL = "/star/products";
	public static final String PRODUCT_GET = "/star/product/{productid}";
	public static final String PRODUCT_GET_BY_FIELD = "/star/product/{fieldName}/{value}";
	public static final String PRODUCT_GET_WITH_IMAGE = "/star/product/image/{productid}";
	public static final String PRODUCT_CREATE = "/star/product/create";
	public static final String PRODUCT_UPDATE = "/star/product/update";
	public static final String PRODUCT_DELETE = "/star/product/delete/{id}";
	
	
	public static final String DEVICE_GET_USER = "/star/device/user/{userId}";
	public static final String DEVICE_GET_ALL = "/star/devices";
	public static final String DEVICE_CREATE = "/star/device/create";
	public static final String DEVICE_DELETE = "/star/device/delete/{deviceId}";
	public static final String DEVICE_UPDATE = "/star/device/update";

	public static final String FLYER_GET_ONE = "/star/flyer/{flyerId}";
	public static final String FLYER_GET_ALL = "/star/flyers";
	public static final String FLYER_CREATE = "/star/flyer/create";
	public static final String FLYER_DELETE = "/star/flyer/delete/{flyerId}";
	
	public static final String IMAGE_GET_ONE = "/star/image/{imageId}";
	public static final String IMAGE_GET_ALL = "/star/images";
	public static final String IMAGE_CREATE = "/star/image/create";
	public static final String IMAGE_DELETE = "/star/image/delete/{imageId}";
	public static final String IMAGE_GET_TYPE = "/star/image/type/{type}";
	public static final String IMAGE_GET_TYPE_REF = "/star/image/type/{type}/(refId)";
	
	public static final int IMAGE_TYPE_FLYER=0;
	public static final int IMAGE_TYPE_BANNER=1;
	public static final int IMAGE_TYPE_CATEGORY=2;
	public static final int IMAGE_TYPE_PRODUCT=3;
	
	
	
	
	
}
