package com.starWholesale.hb.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starWholesale.hb.dto.StatusDTO;
import com.starWholesale.hb.entity.ImCategCod;
import com.starWholesale.hb.entity.ImItem;
import com.starWholesale.hb.entity.ImageMaster;
import com.starWholesale.hb.service.ImCategCodService;
import com.starWholesale.hb.service.MiscellaneousService;

/**
 * Handles requests for the ImCategCod service.
 */

@Controller
public class CategoryController {

	 @Autowired
	 ImCategCodService dataServices;
	 
	 @Autowired
	 MiscellaneousService imageServices;

	 
	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	// Map to store ImCategCods, ideally we should use database
	Map<Long, ImCategCod> categoryData = new HashMap<Long, ImCategCod>();


	@RequestMapping(value = UrlConstants.CAT_GET, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getCategoryGET(@PathVariable("catid") String catId) throws Exception {
		return getCategory(catId);
	}
	@RequestMapping(value = UrlConstants.CAT_GET, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getCategoryPOST(@RequestParam("catid") String catId) throws Exception {
		return getCategory(catId);
	}
	
	public StatusDTO getCategory(String catId) throws Exception {
	logger.info("Start getImCategCod. ID=" + catId);
		ImCategCod cat= dataServices.getCategoryById(catId);
		
		com.starWholesale.hb.dto.ImCategCod categoryMasterDTO = copyFromEntity(cat);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(categoryMasterDTO);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.CAT_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllCategoriesGET() throws Exception {
		return getAllCategories();
	}
	@RequestMapping(value = UrlConstants.CAT_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllCategoriesPOST() throws Exception {
		return getAllCategories();
	}
	public StatusDTO getAllCategories() throws Exception {
	logger.info("Start getAllCategories.");
		
		@SuppressWarnings("unchecked")
		List<ImCategCod> categories = dataServices.getCategoryList();
		Iterator<ImCategCod> iteratorcategory = categories.iterator();
		List<com.starWholesale.hb.dto.ImCategCod> returnObj= new ArrayList<com.starWholesale.hb.dto.ImCategCod>();
		
		while(iteratorcategory.hasNext()){
			com.starWholesale.hb.dto.ImCategCod categoryMasterDTO = new com.starWholesale.hb.dto.ImCategCod();
			List<com.starWholesale.hb.dto.ImItem> empAddressDTOs = new ArrayList<com.starWholesale.hb.dto.ImItem>();
			ImCategCod category = iteratorcategory.next();
			if(!contains(returnObj,category.getCategCod())) {
				categoryMasterDTO = copyFromEntity(category);
				List <ImItem> ed = category.getImItem();
				if(ed!=null){
				Iterator iteratorAddress = ed.iterator();
				while(iteratorAddress.hasNext()){
					ImItem empAdd = (ImItem)iteratorAddress.next();
					com.starWholesale.hb.dto.ImItem empAddressDTO = copyFromEntity(empAdd);
					empAddressDTOs.add(empAddressDTO);
				}
				categoryMasterDTO.setProducts(empAddressDTOs);
				}
				returnObj.add(categoryMasterDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}

	private com.starWholesale.hb.dto.ImCategCod copyFromEntity(ImCategCod category)
	{
		if(category==null)return null;
		com.starWholesale.hb.dto.ImCategCod categoryMaster = new com.starWholesale.hb.dto.ImCategCod();
		categoryMaster.setCategCod(category.getCategCod());
		categoryMaster.setDescrUpr(category.getDescrUpr());
		categoryMaster.setDescr(category.getDescr());
		categoryMaster.setMinPftPct(category.getMinPftPct());
		categoryMaster.setPftCtr(category.getPftCtr());

		return categoryMaster;
	}
	
	private com.starWholesale.hb.dto.ImItem copyFromEntity(ImItem product)
	{
		if(product==null)return null;
		com.starWholesale.hb.dto.ImItem productMaster = new com.starWholesale.hb.dto.ImItem();
		
		productMaster.setItemNo(product.getItemNo());
		productMaster.setDescr(product.getDescr());
		productMaster.setCat(product.getCat());
		productMaster.setLongDescr(product.getLongDescr());
		productMaster.setPrc1(product.getPrc1());
		productMaster.setBarcod(product.getBarcod());
		//productMaster.set
		return productMaster;
	}
	
	private boolean contains(List<com.starWholesale.hb.dto.ImCategCod> list, String categoryid) {
	    for (com.starWholesale.hb.dto.ImCategCod item : list) {
	        if (item.getCategCod().equals(categoryid)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private boolean containsP(List<com.starWholesale.hb.dto.ImItem> list, String productid) {
	    for (com.starWholesale.hb.dto.ImItem item : list) {
	        if (item.getItemNo().equals(productid)) {
	            return true;
	        }
	    }
	    return false;
	}
	

	@RequestMapping(value = UrlConstants.PRODUCT_GET, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getProductGET(@PathVariable("productid") String productId) throws Exception {
		return getProduct(productId);
	}
	@RequestMapping(value = UrlConstants.PRODUCT_GET, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getProductPOST(@RequestParam("productid") String productId) throws Exception {
		return getProduct(productId);
	}
	
	public StatusDTO getProduct(String productId) throws Exception {

		logger.info("Start getImItem. ID=" + productId);
		ImItem product= dataServices.getProductById(productId);
		
		com.starWholesale.hb.dto.ImItem productMasterDTO = copyFromEntity(product);
		List<String> imageUrls = getImageUrls(productMasterDTO.getDescr());
		productMasterDTO.setImages(imageUrls);
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(productMasterDTO);
		return statusDTO;
	}
	
	private List<String> getImageUrls(String descr) throws Exception {
		List<String> imageUrls = new ArrayList<String>();
		
		List<ImageMaster> imageList = imageServices.getImageByType(UrlConstants.IMAGE_TYPE_PRODUCT, descr);
		for(ImageMaster image:imageList)
		{
			imageUrls.add(image.getImageUrl());
		}
		return imageUrls;
	}
	@RequestMapping(value = UrlConstants.PRODUCT_GET_BY_FIELD, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getProductsByFieldGET(@PathVariable("fieldName") String fieldName,@PathVariable("value") Object value) throws Exception {
		return getProductsByField(fieldName,value);
	}
	@RequestMapping(value = UrlConstants.PRODUCT_GET_BY_FIELD, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getProductsByFieldPOST(@RequestParam("fieldName") String fieldName,@RequestParam("value") Object value) throws Exception {
		return getProductsByField(fieldName,value);
	}
	private StatusDTO getProductsByField(String fieldName,Object value) throws Exception {
		logger.info("Start get Products by fieldName.");
		
		@SuppressWarnings("unchecked")
		List<ImItem> products = dataServices.getProductByField(fieldName, value);
		Iterator<ImItem> iteratorproduct = products.iterator();
		List<com.starWholesale.hb.dto.ImItem> returnObj= new ArrayList<com.starWholesale.hb.dto.ImItem>();
		
		while(iteratorproduct.hasNext()){
			com.starWholesale.hb.dto.ImItem productMasterDTO = new com.starWholesale.hb.dto.ImItem();
			ImItem product = iteratorproduct.next();
			if(!containsP(returnObj,product.getItemNo())) {
				productMasterDTO = copyFromEntity(product);
				List<String> imageUrls = getImageUrls(productMasterDTO.getDescr());
				productMasterDTO.setImages(imageUrls);
				
				returnObj.add(productMasterDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}

	@RequestMapping(value = UrlConstants.CAT_GET_PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getCategoryProductsGET(@PathVariable("catid") String catId) throws Exception {
		return getCategoryProducts(catId);
	}
	@RequestMapping(value = UrlConstants.CAT_GET_PRODUCTS, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getCategoryProductsPOST(@RequestParam("catid") String catId) throws Exception {
		return getCategoryProducts(catId);
	}
	private StatusDTO getCategoryProducts(String catId) throws Exception {
		logger.info("Start getAllProductsFromCategory.");
		
		@SuppressWarnings("unchecked")
		List<ImItem> products = dataServices.getCategoryProductList(catId);
		Iterator<ImItem> iteratorproduct = products.iterator();
		List<com.starWholesale.hb.dto.ImItem> returnObj= new ArrayList<com.starWholesale.hb.dto.ImItem>();
		
		while(iteratorproduct.hasNext()){
			com.starWholesale.hb.dto.ImItem productMasterDTO = new com.starWholesale.hb.dto.ImItem();
			ImItem product = iteratorproduct.next();
			if(!containsP(returnObj,product.getItemNo())) {
				productMasterDTO = copyFromEntity(product);
				List<String> imageUrls = getImageUrls(productMasterDTO.getDescr());
				productMasterDTO.setImages(imageUrls);
				
				returnObj.add(productMasterDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.PRODUCT_GET_ALL, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllProductsGET() throws Exception {
		return getProductsImage();//getAllProducts();
	}

	@RequestMapping(value = UrlConstants.PRODUCT_GET_ALL, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getAllProductsPOST() throws Exception {
		return getProductsImage();//getAllProducts();
	}

	private StatusDTO getAllProducts() throws Exception {
		logger.info("Start getAllProducts.");
		
		@SuppressWarnings("unchecked")
		List<ImItem> products = dataServices.getProductList();
		Iterator<ImItem> iteratorproduct = products.iterator();
		List<com.starWholesale.hb.dto.ImItem> returnObj= new ArrayList<com.starWholesale.hb.dto.ImItem>();
		
		while(iteratorproduct.hasNext()){
			com.starWholesale.hb.dto.ImItem productMasterDTO = new com.starWholesale.hb.dto.ImItem();
			ImItem product = iteratorproduct.next();
			if(!containsP(returnObj,product.getItemNo())) {
				productMasterDTO = copyFromEntity(product);
				List<String> imageUrls = getImageUrls(productMasterDTO.getDescr());
				productMasterDTO.setImages(imageUrls);
				
				returnObj.add(productMasterDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}
	

	@RequestMapping(value = UrlConstants.PRODUCT_GET_WITH_IMAGE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getProductImageGET(@PathVariable("productid") String productId) throws Exception {
		return getProductImage(productId);
	}
	@RequestMapping(value = UrlConstants.PRODUCT_GET_WITH_IMAGE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getProductImagePOST(@RequestParam("productid") String productId) throws Exception {
		return getProductImage(productId);
	}
	private StatusDTO getProductImage(String productId) throws Exception {

		logger.info("Start all images by type of a user.");
		
		ImItem product = dataServices.getProductById(productId);//dataServices.getImageByType(type,refId);
		List<ImageMaster> imageList = imageServices.getImageByType(UrlConstants.IMAGE_TYPE_PRODUCT, productId);
		com.starWholesale.hb.dto.ImItem productDTO = new com.starWholesale.hb.dto.ImItem(product.getItemNo(), 
				product.getDescr(), 
				product.getDescrUpr(), 
				product.getLongDescr(), 
				product.getLongDescrUpr(), 
				product.getShortDescr(), 
				product.getItemTyp(), 
				product.getSubcatCod(), 
				product.getQtyDecs(), 
				product.getPrcDecs(), 
				product.getStkUnit(), 
				product.getPrc1(), 
				product.getBarcod(),
				product.getCat());
		productDTO.setImages(imageList);
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(productDTO);
		return statusDTO;
	}
	
	@RequestMapping(value = UrlConstants.CAT_GET_PRODUCTS_WITH_IMAGE, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getCatProductsImageGET(@PathVariable("catid") String catid) throws Exception {
		return getCatProductsImage(catid);
	}
	@RequestMapping(value = UrlConstants.CAT_GET_PRODUCTS_WITH_IMAGE, method = RequestMethod.POST)
	public @ResponseBody StatusDTO getCatProductsImagePOST(@RequestParam("catid") String catid) throws Exception {
	return getCatProductsImage(catid);
	}

	private StatusDTO getCatProductsImage(String catid) throws Exception {
		logger.info("Start all images by type of a user.");
		
		List<ImItem> products = dataServices.getCategoryProductList(catid);
		List<com.starWholesale.hb.dto.ImItem> productDTOs = new ArrayList<com.starWholesale.hb.dto.ImItem>();
		
		for(ImItem product:products){
		List<ImageMaster> imageList = imageServices.getImageByType(UrlConstants.IMAGE_TYPE_PRODUCT, product.getItemNo());
		com.starWholesale.hb.dto.ImItem productDTO = new com.starWholesale.hb.dto.ImItem(product.getItemNo(), 
				product.getDescr(), 
				product.getDescrUpr(), 
				product.getLongDescr(), 
				product.getLongDescrUpr(), 
				product.getShortDescr(), 
				product.getItemTyp(), 
				product.getSubcatCod(), 
				product.getQtyDecs(), 
				product.getPrcDecs(), 
				product.getStkUnit(), 
				product.getPrc1(), 
				product.getBarcod(),
				product.getCat());
		productDTO.setImages(imageList);
		productDTOs.add(productDTO);
		}
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(productDTOs);
		return statusDTO;
	}

	private StatusDTO getProductsImage() throws Exception {
		logger.info("Start all images by type of a user.");
		
		List<ImItem> products = dataServices.getProductList();
		List<com.starWholesale.hb.dto.ImItem> productDTOs = new ArrayList<com.starWholesale.hb.dto.ImItem>();
		
		for(ImItem product:products){
		List<ImageMaster> imageList = imageServices.getImageByType(UrlConstants.IMAGE_TYPE_PRODUCT, product.getItemNo());
		com.starWholesale.hb.dto.ImItem productDTO = new com.starWholesale.hb.dto.ImItem(product.getItemNo(), 
				product.getDescr(), 
				product.getDescrUpr(), 
				product.getLongDescr(), 
				product.getLongDescrUpr(), 
				product.getShortDescr(), 
				product.getItemTyp(), 
				product.getSubcatCod(), 
				product.getQtyDecs(), 
				product.getPrcDecs(), 
				product.getStkUnit(), 
				product.getPrc1(), 
				product.getBarcod(),
				product.getCat());
		productDTO.setImages(imageList);
		productDTOs.add(productDTO);
		}
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(productDTOs);
		return statusDTO;
	}

	
}