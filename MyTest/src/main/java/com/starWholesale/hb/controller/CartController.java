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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.starWholesale.hb.dto.StatusDTO;
import com.starWholesale.hb.entity.CartDetail;
import com.starWholesale.hb.entity.CartMaster;
import com.starWholesale.hb.service.CartService;

/**
 * Handles requests for the CartMaster service.
 */

@Controller
public class CartController {

	 @Autowired
	 CartService dataServices;

	private static final Logger logger = LoggerFactory
			.getLogger(CartController.class);

	// Map to store CartMasters, ideally we should use database
	Map<Long, CartMaster> cartData = new HashMap<Long, CartMaster>();

		

	@RequestMapping(value = UrlConstants.CART_GET, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getCartGET(@PathVariable("cartid") int cartId) throws Exception {
		logger.info("Start getCartMaster. ID=" + cartId);
		return getCart(cartId);
	}

	@RequestMapping(value = UrlConstants.CART_GET, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getCartPOST(@RequestParam("cartid") int cartId) throws Exception {
		logger.info("Start getCartMaster. ID=" + cartId);
		return getCart(cartId);
	}
	
	private StatusDTO getCart(int cartId) throws Exception {
		CartMaster cart= dataServices.getCartById(cartId);
		
		com.starWholesale.hb.dto.CartMaster cartMasterDTO = copyFromEntity(cart);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(cartMasterDTO);
		return statusDTO;

	}
	
	@RequestMapping(value = UrlConstants.CARTS_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllCartGET() throws Exception {
		logger.info("Start getAllCarts.");
		return getAllCart();
	}
	
	@RequestMapping(value = UrlConstants.CARTS_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllCartPOST() throws Exception {
		logger.info("Start getAllCarts.");
		return getAllCart();
	}

	private StatusDTO getAllCart() throws Exception {
		@SuppressWarnings("unchecked")
		List<CartMaster> carts = dataServices.getCartList();
		Iterator<CartMaster> iteratorcart = carts.iterator();
		List<com.starWholesale.hb.dto.CartMaster> returnObj= new ArrayList<com.starWholesale.hb.dto.CartMaster>();
		
		while(iteratorcart.hasNext()){
			com.starWholesale.hb.dto.CartMaster cartMasterDTO = new com.starWholesale.hb.dto.CartMaster();
			CartMaster cart = iteratorcart.next();
			if(!contains(returnObj,cart.getCartId())) {
				cartMasterDTO = copyFromEntity(cart);
				returnObj.add(cartMasterDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.CARTS_GET_USERWISE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getUserCartsGET(@PathVariable("userid") int userId) throws Exception {
		return getUserCarts(userId);
	}
	@RequestMapping(value = UrlConstants.CARTS_GET_USERWISE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getUserCartsPOST(@RequestParam("userid") int userId) throws Exception {
		return getUserCarts(userId);
	}
	
	private StatusDTO getUserCarts(int userId) throws Exception {
	logger.info("Start getAllCarts of User.");
		
		@SuppressWarnings("unchecked")
		List<CartMaster> carts = dataServices.getUserCarts(userId);
		Iterator<CartMaster> iteratorcart = carts.iterator();
		List<com.starWholesale.hb.dto.CartMaster> returnObj= new ArrayList<com.starWholesale.hb.dto.CartMaster>();
		
		while(iteratorcart.hasNext()){
			com.starWholesale.hb.dto.CartMaster cartMasterDTO = new com.starWholesale.hb.dto.CartMaster();
			CartMaster cart = iteratorcart.next();
			if(!contains(returnObj,cart.getCartId())) {
				cartMasterDTO = copyFromEntity(cart);
				returnObj.add(cartMasterDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}

	private com.starWholesale.hb.dto.CartMaster copyFromEntity(CartMaster cart)
	{
		if(cart==null)return null;
		com.starWholesale.hb.dto.CartMaster cartMaster = new com.starWholesale.hb.dto.CartMaster();
		cartMaster.setCreatedDate(cart.getCreatedDate());
		cartMaster.setStatus(cart.getStatus());
		cartMaster.setUpdatedDate(cart.getUpdatedDate());
		cartMaster.setCartId(cart.getCartId());
		cartMaster.setUserId(cart.getUserId());
		//cartMaster.setCartItems(cartItems);
		List<com.starWholesale.hb.dto.CartDetail> cartItems = new ArrayList<com.starWholesale.hb.dto.CartDetail>();
		List <CartDetail> cartDetail = cart.getCartItems();
		Iterator<CartDetail> iteratorDetail = cartDetail.iterator();
		while(iteratorDetail.hasNext()){
	         CartDetail cartItem = (CartDetail)iteratorDetail.next();
	         com.starWholesale.hb.dto.CartDetail cartItemDto = new com.starWholesale.hb.dto.CartDetail();
	         cartItemDto.setCartDetailId(cartItem.getCartDetailId());
	         cartItemDto.setCartId(cart.getCartId());
	         cartItemDto.setPId(cartItem.getPId());
	         cartItemDto.setPrice(cartItem.getPrice());
	         cartItemDto.setQty(cartItem.getQty());
	         cartItemDto.setStatus(cartItem.getStatus());
	         cartItems.add(cartItemDto);
		}
		cartMaster.setCartItems(cartItems);
		return cartMaster;
	}
	
	private boolean contains(List<com.starWholesale.hb.dto.CartMaster> list, int cartid) {
	    for (com.starWholesale.hb.dto.CartMaster item : list) {
	        if (item.getCartId()==cartid) {
	            return true;
	        }
	    }
	    return false;
	}
	
	@RequestMapping(value = UrlConstants.CART_CREATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO createCart(@RequestParam("data") String data) {
		System.out.println("Start createCart.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			ObjectMapper om = new ObjectMapper();
			CartMaster cart = om.readValue(data,CartMaster.class);
			
			cart.setCreatedDate(new Date());
			dataServices.addCart(cart);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(cart);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Cart");
			statusDTO.setMessageObject(e.getMessage());
			e.printStackTrace();
			return statusDTO;
			
		}
	}	
/*	@RequestMapping(value = UrlConstants.CART_CREATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO createCart(@RequestBody CartMaster cart) {
		System.out.println("Start createCart.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			cart.setCreatedDate(new Date());
			dataServices.addCart(cart);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(cart);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Cart");
			statusDTO.setMessageObject(e.getMessage());
			e.printStackTrace();
			return statusDTO;
			
		}
	}
*/	
	@RequestMapping(value = UrlConstants.CART_DELETE, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO deleteCart(@PathVariable("id") int cartId) throws Exception {
		logger.info("Start deleteCartMaster.");
		boolean result=dataServices.deleteCart(cartId);
		StatusDTO statusDTO = new StatusDTO();
		if(result){
				statusDTO.setStatusCode(1);
				statusDTO.setStatusMessage("Successfully Retrived");
				statusDTO.setMessageObject(null);
		}else{
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Cannot Delete Cart");
			statusDTO.setMessageObject(null);
		}
		return statusDTO;
		
	}

	@RequestMapping(value = UrlConstants.CART_UPDATE, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO updateCartPUT(@RequestBody CartMaster cart) {
		return updateCart(cart);
	}
	@RequestMapping(value = UrlConstants.CART_UPDATE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO updateCartPOST(@RequestBody CartMaster cart) {
		return updateCart(cart);
	}
	
	private StatusDTO updateCart(CartMaster cart) {
	
		logger.info("Start createCart.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			cart.setUpdatedDate(new Date());;
			dataServices.updateCart(cart);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(cart);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Cart");
			statusDTO.setMessageObject(e.getMessage());
			return statusDTO;
			
		}
	}
	

	@RequestMapping(value = UrlConstants.CART_ADD_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody StatusDTO addProductToCart(@RequestBody CartDetail cartDetail) {
		logger.info("Start add Product to Cart.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			cartDetail.setStatus(1);
			dataServices.addCartDetail(cartDetail);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Created");
			statusDTO.setMessageObject(cartDetail);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Cart");
			statusDTO.setMessageObject(e.getMessage());
			e.printStackTrace();
			return statusDTO;
			
		}
	}
	
	@RequestMapping(value = UrlConstants.CART_REMOVE_PRODUCT, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO removeProductFromCartPUT(@PathVariable("productid") int productId) throws Exception {
		return removeProductFromCart(productId);
	}
	@RequestMapping(value = UrlConstants.CART_REMOVE_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody StatusDTO removeProductFromCartPOST(@RequestParam("productid") int productId) throws Exception {
		return removeProductFromCart(productId);
	}
	public StatusDTO removeProductFromCart(int productId) throws Exception {
		
		logger.info("Start remove product from Cart.");
		boolean result=dataServices.removeCartDetail(productId);
		StatusDTO statusDTO = new StatusDTO();
		if(result){
				statusDTO.setStatusCode(1);
				statusDTO.setStatusMessage("Successfully Retrived");
				statusDTO.setMessageObject(null);
		}else{
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Cannot Delete Cart");
			statusDTO.setMessageObject(null);
		}
		return statusDTO;
		
	}

	@RequestMapping(value = UrlConstants.CART_UPDATE_PRODUCT, method = RequestMethod.PUT)
	public @ResponseBody StatusDTO updateCartPUT(@RequestBody CartDetail cartDetail) {
		return updateCart(cartDetail);
	}
	@RequestMapping(value = UrlConstants.CART_UPDATE_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody StatusDTO updateCartPOST(@RequestBody CartDetail cartDetail) {
		return updateCart(cartDetail);
	}

	private StatusDTO updateCart(CartDetail cartDetail) {

		logger.info("Start update Cart Detail.");
		StatusDTO statusDTO = new StatusDTO();
		try {
			dataServices.updateCartDetail(cartDetail);
			statusDTO.setStatusCode(1);
			statusDTO.setStatusMessage("Successfully Updated Product into Cart");
			statusDTO.setMessageObject(cartDetail);
			return statusDTO;
			
		} catch (Exception e) {
			statusDTO.setStatusCode(0);
			statusDTO.setStatusMessage("Exception Occurred while creating new Cart");
			statusDTO.setMessageObject(e.getMessage());
			return statusDTO;
			
		}
	}
	

}