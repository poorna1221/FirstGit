package com.sparity.shoppingcart.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.service.ProductService;

public class ProductsAction extends BaseAction {

	private static final long serialVersionUID = -3106583003618296218L;
	private static final Logger logger = Logger.getLogger(ProductsAction.class);
	private ProductService prodService = (ProductService) getServiceBean("productService");
	private Long brandId;
	private Double minPrice;
	private Double maxPrice;
	private Double searchMaxPrice;
	private Double searchMinPrice;
	private List<ProductModel> brandProdList;
	private String brandName;
	private String prodTypeName;
	private String fromWhichList;
	private List<ProductModel> productTypes;
	
	private List<ProductTypeModel> productTypeModels;
	private List<ProductModel> prodmodels;
	
	private Long categoryId;
	private Long prodTypeId;
	private List<BrandModel> brandNames;
	private Map<Long,String>  productModelsMap;
	private Map<Long,String>  productBrandMap;
	private Map<Long,String> productTypesMap;
	
	

	private List<Long>  prodTypeIdList;
	private List<Long> brandIdList;
	
	private String selectedProds;
	
	//pagination properties.
	List<ShowPage> showPageList= new ArrayList<ShowPage>();
	 private String pageNumbers;
	 private int nextPage;
	 private int lastPage;
	 private int previousPage;
	 private boolean firsthide;
	 private boolean lasthide;
	 private boolean show;
	 private int currentPage;
	 private Long pageCategoryId;
	 private Long pagebrandId;
	 private Long pageProdTypeId;
	 private List<Long>  pageProdTypeIdList;
	 private List<Long> pageBrandIdList;
	 private String pageSelectedProds;
	
	public String showBrandProds(){
		return SUCCESS;
	}
	
	
	

	public String showSpeicifcBrandProds(){
		Map<String,Object> session =  getSession();
		fromWhichList = getRequest().getParameter("fromWhichList");
		
		logger.info("fromWhichList is---------------- "+fromWhichList);
		
		logger.info("Entered into showSpeicifcBrandProds");
		List<ProductModel> brandProducts = prodService.findSpecificBrandProds(brandId);
		if(brandProducts!=null && brandProducts.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(brandProducts);
			ProductModel  products = brandProducts.get(0);
			brandName = products.getBrandModel().getBrandName();
			brandId = products.getBrandModel().getBrandId();
			productTypes = new ArrayList<ProductModel>();
			productTypesMap = new HashMap<Long, String>();
			productBrandMap = new HashMap<Long,String> ();
			for(ProductModel prodTypes:brandProducts){
				productTypesMap.put(prodTypes.getProdTypeModel().getProdTypeId(), prodTypes.getProdTypeModel().getProdTypeName());
				productBrandMap.put(prodTypes.getBrandModel().getBrandId(), prodTypes.getBrandModel().getBrandName());
			}
			logger.info("productTypes size..."+productTypes.size());
			logger.info("End of showSpeicifcBrandProds");
			
		}
		
		session.put("productModelsMap", productTypesMap);
		session.put("productBrandMap", productBrandMap);
		
		List<Object> pricerange = prodService.brandPriceRange(brandId);
		List<String> ranges = new ArrayList<String>();
		if (pricerange!=null && pricerange.size()>0) {
			Object[] prange= (Object[])pricerange.get(0);
			for(int i=0;i<prange.length;i++){
				if(i==0){
					minPrice = (Double)prange[i];
				}
				if(i==1){
					maxPrice = (Double)prange[i];
				}
			}
			logger.info("price range "+minPrice+" MaxPrice :"+maxPrice);
		}
		return SUCCESS;
	}
	
	public String showAllMobileSelection(){
		logger.info("inside showAllMobileSelection" );
	//	productTypes=prodService.getProductsByBrandProd(brandId);
		return SUCCESS;
		
	}
	
	public String showAllCategoriesBrands(){
		return SUCCESS;
	}
	
	/*public String showSpeicificProductTypes(){
		Map<String,Object> session = getSession();
		productModelsMap = new HashMap<Long,String> ();
		productBrandMap = new HashMap<Long, String>();
	    fromWhichList = getRequest().getParameter("fromWhichList");
	    
	    logger.info("fromWhichList---------------"+fromWhichList);
	    logger.info("_______________fromWhichList :"+fromWhichList);
		logger.info("prodtypeId is ========"+prodTypeId);
		brandProdList=prodService.getProductTypes(prodTypeId);
		logger.info("________________"+brandProdList.size());
		if(brandProdList.size()>0){
			productModelsMap = new HashMap<Long, String>();
			ProductTypeModel productTypeModel = brandProdList.get(0).getProdTypeModel();
			productModelsMap.put(productTypeModel.getProdTypeId(), productTypeModel.getProdTypeName());
			session.put("productModelsMap", productModelsMap);
			
			minPrice = brandProdList.get(0).getMrpPrice();
			maxPrice = brandProdList.get(brandProdList.size()-1).getMrpPrice();
		
		}
		
		for(ProductModel pm:brandProdList){
			logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeName());
			productBrandMap.put(pm.getBrandModel().getBrandId(), pm.getBrandModel().getBrandName());
		}
		logger.info("________________"+productBrandMap);
		session.put("productBrandMap", productBrandMap);
		
	  return SUCCESS;
	}*/
	
	public String  showSpeicificProductTypeswithBrandId(){
		logger.info("prodtypeId is ========"+prodTypeId);
		logger.info("brandId is "+brandId);
		List<ProductModel> brandProducts=prodService.getProductTypes(prodTypeId,brandId);
		if(brandProducts!=null && brandProducts.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(brandProducts);
			ProductModel  products = brandProducts.get(0);
			brandName = products.getBrandModel().getBrandName();
			brandId = products.getBrandModel().getBrandId();
			productTypes = new ArrayList<ProductModel>();
			minPrice = brandProducts.get(0).getMrpPrice();
			maxPrice = brandProducts.get(brandProducts.size()-1).getMrpPrice();
			
			for(ProductModel prodTypes:brandProducts){
				//productTypes.add(prodTypes.getProdTypeModel().getProdTypeName());
				if(!productTypes.contains(prodTypes)){
				productTypes.add(prodTypes);
				}
			}
			logger.info("productTypes size..."+productTypes.size());
			logger.info("End of showSpeicifcBrandProds");
			
		}
			logger.info("price range "+minPrice+" MaxPrice :"+maxPrice);
		
		return SUCCESS;
	}
	
	public String showPriceRangeProducts(){
		logger.info("brandId is======="+brandId);
		List<ProductModel> rangeProds = prodService.priceRangeProducts(minPrice, maxPrice,brandId);
		if(rangeProds!=null&&rangeProds.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(rangeProds);
			logger.info("price range ressssss  brandProdList"+brandProdList.size());
		}
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @return
	 */
	// for category selection
/*	public String showAllMobilesList(){
		productModelsMap = new HashMap<Long,String> ();
		productBrandMap = new HashMap<Long,String> ();
		Map<String,Object> session =  getSession();
		logger.info("Category Id is ======"+categoryId);
		List<ProductModel> allMobiles =prodService.getAllMobiles(categoryId);
		logger.info("allMobiles size is-----------"+allMobiles.size());
		if(allMobiles!=null && allMobiles.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(allMobiles);
			minPrice = allMobiles.get(0).getMrpPrice();
			maxPrice = allMobiles.get(allMobiles.size()-1).getMrpPrice();
	
			logger.info("min and max prices are ---------"+minPrice+""+maxPrice);
			for(ProductModel pm:allMobiles){
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeName());
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeId());
				productModelsMap.put(pm.getProdTypeModel().getProdTypeId(), pm.getProdTypeModel().getProdTypeName());
			}
		
			for(ProductModel pm:allMobiles){
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeName());
				productBrandMap.put(pm.getBrandModel().getBrandId(), pm.getBrandModel().getBrandName());
			}
			session.put("productModelsMap", productModelsMap);
			session.put("productBrandMap", productBrandMap);
			
		}
		
		
		//brandNames=prodService.getMobileBrands(categoryId);
		return SUCCESS;
		
	}*/
	
	public String T(){
		
		productModelsMap = new HashMap<Long,String> ();
		productBrandMap = new HashMap<Long,String> ();
		Map<String,Object> session =  getSession();
		logger.info("Category Id is ======"+categoryId);
		
		List<ProductModel> allProdTypesBrands = prodService.getAllCategoryProds(categoryId);
		//to show all prod types and brands.
		if(allProdTypesBrands!=null && allProdTypesBrands.size()>0){
			for(ProductModel product:allProdTypesBrands){
				productModelsMap.put(product.getProdTypeModel().getProdTypeId(), product.getProdTypeModel().getProdTypeName());
				productBrandMap.put(product.getBrandModel().getBrandId(), product.getBrandModel().getBrandName());
			}
			
			session.put("productModelsMap", productModelsMap);
			session.put("productBrandMap", productBrandMap);
		}
		
	/*	Object[] prices = (Object[]) session.get("prodPrices");
		if(prices!=null){
			minPrice = (Double)prices[0];
			maxPrice = (Double)prices[1];
			logger.info("price range "+minPrice+" MaxPrice :"+maxPrice);
			
		} else {*/
			List<Object> priceRanges = prodService.getMinAndMaxPriceForProducts(categoryId, null, null);
				if (priceRanges!=null) {
					Object[] prange = (Object[]) priceRanges.get(0);
					for (int i = 0; i < prange.length; i++) {
						if (i == 0) {
							minPrice = (Double) prange[i];
							searchMinPrice = (Double) prange[i];

						}
						if (i == 1) {
							maxPrice = (Double) prange[i];
							searchMaxPrice = (Double) prange[i];
						}
					}
				} else {
					minPrice = 0D;
					maxPrice = 0D;
					searchMinPrice = 0D;
					searchMaxPrice = 0D;
				}
				//session.put("prodPrices", prange);
				logger.info("price range(Db Execute) "+minPrice+" MaxPrice :"+maxPrice);
		//}
		//List<ProductModel> allMobiles =prodService.getAllMobiles(categoryId);
		//logger.info("allMobiles size is-----------"+allMobiles.size());
		
		int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		String reqPage = pageNumbers;
		logger.info("reqPage is.."+reqPage);
		
		int count = prodService.getCountForCategoryProducts(categoryId);
		int last = count/rows;
		if(count%rows==0){
			lastPage=last-1;
			
		}else{
			lastPage=last;
			
		}
		
		if(reqPage!=null){
			page=Integer.parseInt(reqPage);	
			tempPage=page;
		}else{
			page=0;	
			tempPage=0;
		}
		
		currentPage=tempPage+1;
		logger.info("currentPage......."+currentPage);
		next = page+1;
		previous = page-1;
		
		
		if(page==0){
			firsthide = false;}
		else{
			firsthide = true;}
		
		if(page==last){
			lasthide = false;
		}else if(page!=0 && count-(page*rows)==rows){
			lasthide = false;
		} else{
			lasthide = true;}
		if(count>rows){show=true;}
		else{
			show=false;}
		
		previousPage=previous;
		nextPage=next;
		
		page = page*rows;
		
		List<ProductModel> allCategoryProds = prodService.getAllCategoryProds(categoryId,page,rows);
		
		int pageNationCount=0;
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		logger.info("tempPage///////////"+tempPage);	
		
		logger.info("countRows-------"+pageNationCount);
		logger.info("last-------"+last);	
		if(tempPage<=2){
			if(pageNationCount==1){
				min=1;
				max=1;
			}else
				if(pageNationCount==2){
					min=1;
					max=2;
				}else
					if(pageNationCount==3){
						min=1;
						max=3;
					}else
						if(pageNationCount==4){
							min=1;
							max=4;
						}else{
							min=1;
							max=5;
						}
		}else{
			tempPage=tempPage+1;
			if(tempPage==pageNationCount){
				
				min=tempPage-2;
				max=tempPage;
			}else
			if(tempPage==pageNationCount-1){
				min=tempPage-2;
				max=tempPage+1;
			}else{
				min=tempPage-2;
				max=tempPage+2;
			}
		}
		
		for(int i=min;i<=max;i++){
			ShowPage showPage = new ShowPage();
			showPage.setPageNumber(i-1);
			showPage.setPageNumber1(i);
			showPageList.add(showPage);
		}
		
		if(allCategoryProds!=null && allCategoryProds.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(allCategoryProds);
			//minPrice = allCategoryProds.get(0).getMrpPrice();
			//maxPrice = allCategoryProds.get(allCategoryProds.size()-1).getMrpPrice();
	
			//logger.info("min and max prices are ---------"+minPrice+""+maxPrice);
			/*for(ProductModel pm:allCategoryProds){
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeName());
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeId());
				productModelsMap.put(pm.getProdTypeModel().getProdTypeId(), pm.getProdTypeModel().getProdTypeName());
				productBrandMap.put(pm.getBrandModel().getBrandId(), pm.getBrandModel().getBrandName());
			}*/
		
			/*for(ProductModel pm:allMobiles){
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeName());
				productBrandMap.put(pm.getBrandModel().getBrandId(), pm.getBrandModel().getBrandName());
			}*/
			/*session.put("productModelsMap", productModelsMap);
			session.put("productBrandMap", productBrandMap);*/
			
		}
		
		pageCategoryId = getCategoryId();
		
		return SUCCESS;
	}
	
	
	public String showBrandCategoryProducts(){
		
		productModelsMap = new HashMap<Long,String> ();
		productBrandMap = new HashMap<Long,String> ();
		Map<String,Object> session =  getSession();
		
		List<ProductModel> allBrandProds = prodService.getAllBrandProds(categoryId,brandId);
		
		if(allBrandProds!=null && allBrandProds.size()>0){
			for(ProductModel product:allBrandProds){
				productModelsMap.put(product.getProdTypeModel().getProdTypeId(), product.getProdTypeModel().getProdTypeName());
				productBrandMap.put(product.getBrandModel().getBrandId(), product.getBrandModel().getBrandName());
			}
			
			session.put("productModelsMap", productModelsMap);
			session.put("productBrandMap", productBrandMap);
		}
		
		List<Object> priceRanges = prodService.getMinAndMaxPriceForProducts(categoryId, brandId, null);
		if (priceRanges!=null) {
			Object[] prange = (Object[]) priceRanges.get(0);
			for (int i = 0; i < prange.length; i++) {
				if (i == 0) {
					Double dbMinPrice = (Double) prange[i];
						if(dbMinPrice!=null){
							minPrice = (Double) prange[i];
							searchMinPrice = (Double) prange[i];
						} else {
							minPrice = 0D;
							searchMinPrice = 0D;
						}

				}
				if (i == 1) {
					Double dbMaxPrice = (Double) prange[i];
						if(dbMaxPrice!=null){
							maxPrice = (Double) prange[i];
							searchMaxPrice = (Double) prange[i];
						} else {
							maxPrice = 0D;
							searchMaxPrice = 0D;
						}
				}
			}
		} else {
			minPrice = 0D;
			maxPrice = 0D;
			searchMinPrice = 0D;
			searchMaxPrice = 0D;
		}
		
		int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		String reqPage = pageNumbers;
		logger.info("reqPage is.."+reqPage);
		int count = prodService.getCountForBrandCategoryProducts(categoryId,brandId);
		int last = count/rows;
		if(count%rows==0){
			lastPage=last-1;
			
		}else{
			lastPage=last;
			
		}
		
		if(reqPage!=null){
			page=Integer.parseInt(reqPage);	
			tempPage=page;
		}else{
			page=0;	
			tempPage=0;
		}
		
		currentPage=tempPage+1;
		logger.info("currentPage......."+currentPage);
		next = page+1;
		previous = page-1;
		
		
		if(page==0){
			firsthide = false;}
		else{
			firsthide = true;}
		
		if(page==last){
			lasthide = false;
		}else if(page!=0 && count-(page*rows)==rows){
			lasthide = false;
		} else{
			lasthide = true;}
		if(count>rows){show=true;}
		else{
			show=false;}
		
		previousPage=previous;
		nextPage=next;
		
		page = page*rows;
		
		List<ProductModel> brandProducts = prodService.getBrandCategoryProds(categoryId,brandId,page,rows);
		
		int pageNationCount=0;
		
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		logger.info("tempPage///////////"+tempPage);	
		
		logger.info("countRows-------"+pageNationCount);
		logger.info("last-------"+last);	
		if(tempPage<=2){
			if(pageNationCount==1){
				min=1;
				max=1;
			}else
				if(pageNationCount==2){
					min=1;
					max=2;
				}else
					if(pageNationCount==3){
						min=1;
						max=3;
					}else
						if(pageNationCount==4){
							min=1;
							max=4;
						}else{
							min=1;
							max=5;
						}
		}else{
			tempPage=tempPage+1;
			if(tempPage==pageNationCount){
				
				min=tempPage-2;
				max=tempPage;
			}else
			if(tempPage==pageNationCount-1){
				min=tempPage-2;
				max=tempPage+1;
			}else{
				min=tempPage-2;
				max=tempPage+2;
			}
		}
		
		for(int i=min;i<=max;i++){
			ShowPage showPage = new ShowPage();
			showPage.setPageNumber(i-1);
			showPage.setPageNumber1(i);
			showPageList.add(showPage);
		}
		if(brandProducts!=null && brandProducts.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(brandProducts);
			ProductModel  products = brandProducts.get(0);
			brandName = products.getBrandModel().getBrandName();
			brandId = products.getBrandModel().getBrandId();
			productTypes = new ArrayList<ProductModel>();
			productTypesMap = new HashMap<Long, String>();
			productBrandMap = new HashMap<Long,String> ();
			//minPrice = brandProducts.get(0).getMrpPrice();
			//maxPrice = brandProducts.get(brandProducts.size()-1).getMrpPrice();
			for(ProductModel prodTypes:brandProducts){
				productTypesMap.put(prodTypes.getProdTypeModel().getProdTypeId(), prodTypes.getProdTypeModel().getProdTypeName());
				productBrandMap.put(prodTypes.getBrandModel().getBrandId(), prodTypes.getBrandModel().getBrandName());
			}
			logger.info("productTypes size..."+productTypes.size());
			logger.info("End of showSpeicifcBrandProds");
			
		}
		
		session.put("productModelsMap", productTypesMap);
		session.put("productBrandMap", productBrandMap);
		pageCategoryId = getCategoryId();
		pagebrandId = getBrandId();
		
		/*List<Object> pricerange = prodService.brandPriceRange(brandId);
		List<String> ranges = new ArrayList<String>();
		if (pricerange!=null && pricerange.size()>0) {
			Object[] prange= (Object[])pricerange.get(0);
			for(int i=0;i<prange.length;i++){
				if(i==0){
					minPrice = (Double)prange[i];
				}
				if(i==1){
					maxPrice = (Double)prange[i];
				}
			}
			logger.info("price range "+minPrice+" MaxPrice :"+maxPrice);
		}*/
		return SUCCESS;
	}
	
	
	public String showProductTypes(){
		
		Map<String,Object> session = getSession();
		productModelsMap = new HashMap<Long,String> ();
		productBrandMap = new HashMap<Long, String>();
	    logger.info("prodtypeId is ========"+prodTypeId);
	    
	    List<ProductModel> allProdTypeProds = prodService.getProductTypes(prodTypeId,null);
		
		if(allProdTypeProds!=null && allProdTypeProds.size()>0){
			for(ProductModel product:allProdTypeProds){
				productModelsMap.put(product.getProdTypeModel().getProdTypeId(), product.getProdTypeModel().getProdTypeName());
				productBrandMap.put(product.getBrandModel().getBrandId(), product.getBrandModel().getBrandName());
			}
			
			session.put("productModelsMap", productModelsMap);
			session.put("productBrandMap", productBrandMap);
		}
		
		List<Object> priceRanges = prodService.getMinAndMaxPriceForProducts(null, null, prodTypeId);
		if (priceRanges!=null) {
			Object[] prange = (Object[]) priceRanges.get(0);
			for (int i = 0; i < prange.length; i++) {
				if (i == 0) {
					minPrice = (Double) prange[i];
					searchMinPrice = (Double) prange[i];

				}
				if (i == 1) {
					maxPrice = (Double) prange[i];
					searchMaxPrice = (Double) prange[i];
				}
			}
		} else {
			minPrice = 0D;
			maxPrice = 0D;
			searchMinPrice = 0D;
			searchMaxPrice = 0D;
		}
	    
	    int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		String reqPage = pageNumbers;
		logger.info("reqPage is.."+reqPage);
		
		int count = prodService.getCountForProdTypes(prodTypeId);
		int last = count/rows;
		if(count%rows==0){
			lastPage=last-1;
			
		}else{
			lastPage=last;
			
		}
		
		if(reqPage!=null){
			page=Integer.parseInt(reqPage);	
			tempPage=page;
		}else{
			page=0;	
			tempPage=0;
		}
		
		currentPage=tempPage+1;
		logger.info("currentPage......."+currentPage);
		next = page+1;
		previous = page-1;
		
		
		if(page==0){
			firsthide = false;}
		else{
			firsthide = true;}
		
		if(page==last){
			lasthide = false;
		}else if(page!=0 && count-(page*rows)==rows){
			lasthide = false;
		} else{
			lasthide = true;}
		if(count>rows){show=true;}
		else{
			show=false;}
		
		previousPage=previous;
		nextPage=next;
		
		page = page*rows;
		
		List<ProductModel> prodTypeList=prodService.getProductTypes(prodTypeId,page,rows);
		int pageNationCount=0;
		
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		logger.info("tempPage///////////"+tempPage);	
		
		logger.info("countRows-------"+pageNationCount);
		logger.info("last-------"+last);	
		if(tempPage<=2){
			if(pageNationCount==1){
				min=1;
				max=1;
			}else
				if(pageNationCount==2){
					min=1;
					max=2;
				}else
					if(pageNationCount==3){
						min=1;
						max=3;
					}else
						if(pageNationCount==4){
							min=1;
							max=4;
						}else{
							min=1;
							max=5;
						}
		}else{
			tempPage=tempPage+1;
			if(tempPage==pageNationCount){
				
				min=tempPage-2;
				max=tempPage;
			}else
			if(tempPage==pageNationCount-1){
				min=tempPage-2;
				max=tempPage+1;
			}else{
				min=tempPage-2;
				max=tempPage+2;
			}
		}
		
		for(int i=min;i<=max;i++){
			ShowPage showPage = new ShowPage();
			showPage.setPageNumber(i-1);
			showPage.setPageNumber1(i);
			showPageList.add(showPage);
		}
		
		if(prodTypeList!=null && prodTypeList.size()>0){
			productTypes = new ArrayList<ProductModel>();
			productTypes.addAll(prodTypeList);
			productModelsMap = new HashMap<Long, String>();
			ProductTypeModel productTypeModel = prodTypeList.get(0).getProdTypeModel();
			productModelsMap.put(productTypeModel.getProdTypeId(), productTypeModel.getProdTypeName());
			session.put("productModelsMap", productModelsMap);
			
			//minPrice = prodTypeList.get(0).getMrpPrice();
			//maxPrice = prodTypeList.get(prodTypeList.size()-1).getMrpPrice();
			for(ProductModel pm:prodTypeList){
				logger.info("product type name is: "+pm.getProdTypeModel().getProdTypeName());
				productBrandMap.put(pm.getBrandModel().getBrandId(), pm.getBrandModel().getBrandName());
			}
		
		}
		
		logger.info("________________"+productBrandMap);
		session.put("productBrandMap", productBrandMap);
		pageProdTypeId = getProdTypeId();
		
	  return SUCCESS;
	}
	
/*	
	public String selectMultilpeIds(){
		
	logger.info("prodTypeIdList and brandIdList   are  "+prodTypeIdList+ " and "+brandIdList);	
		prodmodels=prodService.selectMultilpleBrandProdIds(prodTypeIdList,brandIdList,minPrice,maxPrice);
		
		if(prodmodels!=null){
			minPrice = prodmodels.get(0).getMrpPrice();
		   maxPrice = prodmodels.get(prodmodels.size()-1).getMrpPrice();
			}
		return SUCCESS;
	}*/
	
	
	/**
	 * this method for filter By BrandName and ProductTypes
	 */
	
	public String filterProdsByProdTypes(){
		
		logger.info("Selected Prods..."+getSelectedProds());
		List<Long> prodTypeIds = new ArrayList<Long>();
		List<Long> brandIds = new ArrayList<Long>();
		List<Double> prices = new ArrayList<Double>();
		Double minprice = null;
		Double maxprice = null;
		
		//brandIds.add(brandId);
		
		List<Object> priceRanges = prodService.getMinAndMaxPriceForProducts(categoryId, brandId, null);
		if (priceRanges!=null) {
			Object[] prange = (Object[]) priceRanges.get(0);
			for (int i = 0; i < prange.length; i++) {
				if (i == 0) {
					minPrice = (Double) prange[i];
				}
				if (i == 1) {
					maxPrice = (Double) prange[i];
				}
			}
		} else {
			minPrice = 0D;
			maxPrice = 0D;
		}
 
		
		if (getSelectedProds()!=null && getSelectedProds().length()>0) {
			String[] result = getSelectedProds().split("#");
			for (int x = 0; x < result.length; x++) {
				logger.info("values:" + result[x]);
				if (result[x].startsWith("prodType_")) {
					prodTypeIds.add(Long.valueOf(result[x].substring(9)));
					logger.info("yes" + result[x].substring(9));
				} /*else if (result[x].startsWith("brand_")) {
					brandIds.add(Long.valueOf(result[x].substring(6)));
					logger.info("no" + result[x].substring(6));
				}*/else if (result[x].startsWith("checkbox")) {
					//brandIds.add(Long.valueOf(result[x].substring(6)));
					//logger.info("no" + result[x].substring(6));
				}
				else {
					if (StringUtils.isNotBlank(result[x])) {
						prices.add(Double.valueOf(result[x]));
					}
				}
			}
		}
		
		if (prices!=null && prices.size()>0) {
			minprice = prices.get(0);
			maxprice = prices.get(1);
		}
		
		if(minprice!=null && maxprice!=null){
			
			searchMinPrice = minprice;
			searchMaxPrice = maxprice;
		} else {
			searchMinPrice = minPrice;
			searchMaxPrice = maxPrice;
		}
		
		
		int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		String reqPage = pageNumbers;
		logger.info("reqPage is.."+reqPage);
		
		int count =0;
		if((prodTypeIds!=null && prodTypeIds.size()>0)&&(searchMinPrice ==null || searchMaxPrice==null)&& (brandIds!=null || brandIds.size()>0 ) && categoryId!=null ){
			 count = prodService.productTypesCount(prodTypeIds,brandId,categoryId,null,null);
		} else if((searchMinPrice !=null || searchMaxPrice!=null) &&(prodTypeIds==null || prodTypeIds.size()==0) && brandId !=null && categoryId!=null ){
			count = prodService.productTypesCount(null,brandId,categoryId,searchMinPrice,searchMaxPrice);
		} else if((searchMinPrice !=null || searchMaxPrice!=null) &&(prodTypeIds!=null && prodTypeIds.size()>0) && brandId !=null && categoryId!=null ){
			count = prodService.productTypesCount(prodTypeIds,brandId,categoryId,searchMinPrice,searchMaxPrice);
		}else {
			pageCategoryId = getCategoryId();
			pagebrandId = getBrandId();
			return INPUT;
		}
		
		int last = count/rows;
		if(count%rows==0){
			lastPage=last-1;
			
		}else{
			lastPage=last;
			
		}
		
		if(reqPage!=null){
			page=Integer.parseInt(reqPage);	
			tempPage=page;
		}else{
			page=0;	
			tempPage=0;
		}
		
		currentPage=tempPage+1;
		logger.info("currentPage......."+currentPage);
		next = page+1;
		previous = page-1;
		
		
		if(page==0){
			firsthide = false;}
		else{
			firsthide = true;}
		
		if(page==last){
			lasthide = false;
		}else if(page!=0 && count-(page*rows)==rows){
			lasthide = false;
		} else{
			lasthide = true;}
		if(count>rows){show=true;}
		else{
			show=false;}
		
		previousPage=previous;
		nextPage=next;
		
		page = page*rows;
		List<ProductModel> prodTypeProds = null;
		
		if((prodTypeIds!=null && prodTypeIds.size()>0)&&(searchMinPrice ==null || searchMaxPrice==null)&& (brandIds!=null || brandIds.size()>0 ) && categoryId!=null ){
			prodTypeProds = prodService.getProdsFromProdType(prodTypeIds,brandId,categoryId,page,rows,null,null);
		} else if((searchMinPrice !=null || searchMaxPrice!=null) && (prodTypeIds==null || prodTypeIds.size()==0) && brandId !=null && categoryId!=null ){
			prodTypeProds = prodService.getProdsFromProdType(null,brandId,categoryId,page,rows,searchMinPrice,searchMaxPrice);
		} else {
			prodTypeProds = prodService.getProdsFromProdType(prodTypeIds,brandId,categoryId,page,rows,searchMinPrice,searchMaxPrice);
		}		 
		 
		int pageNationCount=0;
		
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		logger.info("tempPage///////////"+tempPage);	
		
		logger.info("countRows-------"+pageNationCount);
		logger.info("last-------"+last);	
		if(tempPage<=2){
			if(pageNationCount==1){
				min=1;
				max=1;
			}else
				if(pageNationCount==2){
					min=1;
					max=2;
				}else
					if(pageNationCount==3){
						min=1;
						max=3;
					}else
						if(pageNationCount==4){
							min=1;
							max=4;
						}else{
							min=1;
							max=5;
						}
		}else{
			tempPage=tempPage+1;
			if(tempPage==pageNationCount){
				
				min=tempPage-2;
				max=tempPage;
			}else
			if(tempPage==pageNationCount-1){
				min=tempPage-2;
				max=tempPage+1;
			}else{
				min=tempPage-2;
				max=tempPage+2;
			}
		}
		
		for(int i=min;i<=max;i++){
			ShowPage showPage = new ShowPage();
			showPage.setPageNumber(i-1);
			showPage.setPageNumber1(i);
			showPageList.add(showPage);
		}
		 productModelsMap = new HashMap<Long,String> ();
		 productBrandMap = new HashMap<Long,String> ();
		 
		 if(prodTypeProds!=null && prodTypeProds.size()>0){
				brandProdList = new ArrayList<ProductModel>();
				brandProdList.addAll(prodTypeProds);
				
				prodTypeIdList = new ArrayList<Long>();
				prodTypeIdList.addAll(prodTypeIds);
			
				pageSelectedProds = getSelectedProds();
				pageCategoryId = getCategoryId();
				pagebrandId = getBrandId();
				return SUCCESS;	
				
		} else {
			pageCategoryId = getCategoryId();
			pagebrandId = getBrandId();
			return INPUT;
		}
		
	}
	
	// this method is for filter porducts by Brands 
	
	public String filterProdsByBrands(){
		
		logger.info("Selected Prods..."+getSelectedProds());
		List<Long> prodTypeIds = new ArrayList<Long>();
		List<Long> brandIds = new ArrayList<Long>();
		List<Double> prices = new ArrayList<Double>();
		Double minprice = null;
		Double maxprice = null;
		
		//brandIds.add(brandId);
		
		
				
		List<Object> priceRanges = prodService.getMinAndMaxPriceForProducts(null, null, prodTypeId);
		if (priceRanges!=null) {
			Object[] prange = (Object[]) priceRanges.get(0);
			for (int i = 0; i < prange.length; i++) {
				if (i == 0) {
					minPrice = (Double) prange[i];
				}
				if (i == 1) {
					maxPrice = (Double) prange[i];
				}
			}
		} else {
			minPrice = 0D;
			maxPrice = 0D;
		}
 
		
		if (getSelectedProds()!=null && getSelectedProds().length()>0) {
			String[] result = getSelectedProds().split("#");
			for (int x = 0; x < result.length; x++) {
				logger.info("values:" + result[x]);
				if (result[x].startsWith("prodType_")) {
					prodTypeIds.add(Long.valueOf(result[x].substring(9)));
					logger.info("yes" + result[x].substring(9));
				} else if (result[x].startsWith("brand_")) {
					brandIds.add(Long.valueOf(result[x].substring(6)));
					logger.info("no" + result[x].substring(6));
				}else if (result[x].startsWith("checkbox")) {
					//brandIds.add(Long.valueOf(result[x].substring(6)));
					//logger.info("no" + result[x].substring(6));
				}
				else {
					if (StringUtils.isNotBlank(result[x])) {
						prices.add(Double.valueOf(result[x]));
					}
				}
			}
		}
		
		if (prices!=null && prices.size()>0) {
			minprice = prices.get(0);
			maxprice = prices.get(1);
		}
		
		if(minprice!=null && maxprice!=null){
			
			searchMinPrice = minprice;
			searchMaxPrice = maxprice;
		} else {
			searchMinPrice = minPrice;
			searchMaxPrice = maxPrice;
		}
		
		
		int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		String reqPage = pageNumbers;
		logger.info("reqPage is.."+reqPage);
		
		int count =0;
		if((searchMinPrice ==null || searchMaxPrice==null)&& (brandIds!=null || brandIds.size()>0 ) && prodTypeId!=null ){
			 count = prodService.brandsCount(prodTypeId,brandIds,null,null,null);
		} else if((searchMinPrice !=null || searchMaxPrice!=null) &&(brandIds==null || brandIds.size()==0) && prodTypeId!=null ){
			count = prodService.brandsCount(prodTypeId,null,null,searchMinPrice,searchMaxPrice);
		} else if((searchMinPrice !=null || searchMaxPrice!=null) &&(brandIds!=null && brandIds.size()>0) && prodTypeId!=null ){
			count = prodService.brandsCount(prodTypeId,brandIds,null,searchMinPrice,searchMaxPrice);
		}else {
			//pageCategoryId = getCategoryId();
			//pagebrandId = getBrandId();
			pageProdTypeId = prodTypeId;
			return INPUT;
		}
		
		int last = count/rows;
		if(count%rows==0){
			lastPage=last-1;
			
		}else{
			lastPage=last;
			
		}
		
		if(reqPage!=null){
			page=Integer.parseInt(reqPage);	
			tempPage=page;
		}else{
			page=0;	
			tempPage=0;
		}
		
		currentPage=tempPage+1;
		logger.info("currentPage......."+currentPage);
		next = page+1;
		previous = page-1;
		
		
		if(page==0){
			firsthide = false;}
		else{
			firsthide = true;}
		
		if(page==last){
			lasthide = false;
		}else if(page!=0 && count-(page*rows)==rows){
			lasthide = false;
		} else{
			lasthide = true;}
		if(count>rows){show=true;}
		else{
			show=false;}
		
		previousPage=previous;
		nextPage=next;
		
		page = page*rows;
		List<ProductModel> brandProducts = null;
		
		if((searchMinPrice ==null || searchMaxPrice==null)&& (brandIds!=null || brandIds.size()>0 ) && prodTypeId!=null){
			brandProducts = prodService.getProdsFromBrands(prodTypeId,brandIds,null,page,rows,null,null);
		} else if((searchMinPrice !=null || searchMaxPrice!=null) &&(brandIds==null || brandIds.size()==0) && prodTypeId!=null){
			brandProducts = prodService.getProdsFromBrands(prodTypeId,null,null,page,rows,searchMinPrice,searchMaxPrice);
		} else {
			brandProducts = prodService.getProdsFromBrands(prodTypeId,brandIds,null,page,rows,searchMinPrice,searchMaxPrice);
		}		 
		 
		int pageNationCount=0;
		
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		logger.info("tempPage///////////"+tempPage);	
		
		logger.info("countRows-------"+pageNationCount);
		logger.info("last-------"+last);	
		if(tempPage<=2){
			if(pageNationCount==1){
				min=1;
				max=1;
			}else
				if(pageNationCount==2){
					min=1;
					max=2;
				}else
					if(pageNationCount==3){
						min=1;
						max=3;
					}else
						if(pageNationCount==4){
							min=1;
							max=4;
						}else{
							min=1;
							max=5;
						}
		}else{
			tempPage=tempPage+1;
			if(tempPage==pageNationCount){
				
				min=tempPage-2;
				max=tempPage;
			}else
			if(tempPage==pageNationCount-1){
				min=tempPage-2;
				max=tempPage+1;
			}else{
				min=tempPage-2;
				max=tempPage+2;
			}
		}
		
		for(int i=min;i<=max;i++){
			ShowPage showPage = new ShowPage();
			showPage.setPageNumber(i-1);
			showPage.setPageNumber1(i);
			showPageList.add(showPage);
		}
		 productModelsMap = new HashMap<Long,String> ();
		 productBrandMap = new HashMap<Long,String> ();
		 
		 if(brandProducts!=null && brandProducts.size()>0){
				brandProdList = new ArrayList<ProductModel>();
				brandProdList.addAll(brandProducts);
				
				brandIdList = new ArrayList<Long>();
				brandIdList.addAll(brandIds);
			
				pageSelectedProds = getSelectedProds();
				//pageCategoryId = getCategoryId();
				//pagebrandId = getBrandId();
				pageProdTypeId = prodTypeId;
				return SUCCESS;	
				
		} else {
			//pageCategoryId = getCategoryId();
			//pagebrandId = getBrandId();
			pageProdTypeId = prodTypeId;
			return INPUT;
		}
		
	}
	
	
	
	public String filterCategoryProds(){
		
		logger.info("Selected Prods..."+getSelectedProds());
		logger.info("filterCategoryProds categoryId: "+getCategoryId());
		List<Long> prodTypeIds = new ArrayList<Long>();
		List<Long> brandIds = new ArrayList<Long>();
		List<Double> prices = new ArrayList<Double>();
		Map<String,Object> session = getSession();
		//Object[] sessionPrices = (Object[]) session.get("prodPrices");
		
		/*if(sessionPrices!=null){
			minPrice = (Double)sessionPrices[0];
			maxPrice = (Double)sessionPrices[1];
			logger.info("price range "+minPrice+" MaxPrice :"+maxPrice);
			
		} else {*/
			List<Object> priceRanges = prodService.getMinAndMaxPriceForProducts(categoryId, null, null);
				if (priceRanges!=null) {
					Object[] prange = (Object[]) priceRanges.get(0);
					for (int i = 0; i < prange.length; i++) {
						if (i == 0) {
							minPrice = (Double) prange[i];
						}
						if (i == 1) {
							maxPrice = (Double) prange[i];
						}
					}
				} else {
					minPrice = 0D;
					maxPrice = 0D;
				}
				//session.put("prodPrices", prange);
				logger.info("price range(Db Execute) "+minPrice+" MaxPrice :"+maxPrice);
		//}
		
		Double minprice = null;
		Double maxprice = null;
		
		if (getSelectedProds()!=null && getSelectedProds().length()>0) {
			String[] result = getSelectedProds().split("#");
			for (int x = 0; x < result.length; x++) {
				logger.info("values:" + result[x]);
				if (result[x].startsWith("prodType_")) {
					prodTypeIds.add(Long.valueOf(result[x].substring(9)));
					logger.info("yes" + result[x].substring(9));
				} else if (result[x].startsWith("brand_")) {
					brandIds.add(Long.valueOf(result[x].substring(6)));
					logger.info("no" + result[x].substring(6));
				}else if (result[x].startsWith("checkbox")) {
					//brandIds.add(Long.valueOf(result[x].substring(6)));
					//logger.info("no" + result[x].substring(6));
				}
				else {
					if (StringUtils.isNotBlank(result[x])) {
						prices.add(Double.valueOf(result[x]));
					}
				}
			}
		}
		
		if (prices!=null && prices.size()>0) {
			minprice = prices.get(0);
			maxprice = prices.get(1);
		}
		//Map<String,Object> session =  getSession();
		
		if(minprice!=null && maxprice!=null){
			
			searchMinPrice = minprice;
			searchMaxPrice = maxprice;
		} else {
			searchMinPrice = minPrice;
			searchMaxPrice = maxPrice;
		}
		
		int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		String reqPage = pageNumbers;
		logger.info("reqPage is.."+reqPage);
		
		int count =0;
		if((prodTypeIds!=null && prodTypeIds.size()>0)&& (brandIds ==null || brandIds.size()==0 )&& (searchMinPrice ==null || searchMaxPrice==null)){
			 count = prodService.productTypeBrandsCount(prodTypeIds,null,null,null,null);
		} else if((prodTypeIds!=null && prodTypeIds.size()>0)&& (brandIds ==null || brandIds.size()==0 ) && (searchMinPrice !=null || searchMaxPrice!=null )){
			 count = prodService.productTypeBrandsCount(prodTypeIds,null,null,searchMinPrice,searchMaxPrice);
		} else if((brandIds!=null && brandIds.size()>0) && (prodTypeIds ==null || prodTypeIds.size()==0 ) && categoryId!=null &&(searchMinPrice ==null || searchMaxPrice==null)){
			 count = prodService.productTypeBrandsCount(null,brandIds,categoryId,null,null);
		} else if((brandIds!=null && brandIds.size()>0) && (prodTypeIds ==null || prodTypeIds.size()==0 ) && categoryId!=null && (searchMinPrice !=null || searchMaxPrice!=null )){
			 count = prodService.productTypeBrandsCount(null,brandIds,categoryId,searchMinPrice,searchMaxPrice);
		} else if((brandIds!=null && brandIds.size()>0) && (prodTypeIds!=null && prodTypeIds.size()>0) && categoryId!=null && (searchMinPrice !=null || searchMaxPrice!=null )) {
			 count = prodService.productTypeBrandsCount(prodTypeIds,brandIds,categoryId,searchMinPrice,searchMaxPrice);
		} else if((minprice!=null && maxprice!=null) &&(brandIds == null || brandIds.size()==0) &&(prodTypeIds ==null || prodTypeIds.size()==0)){
			count = prodService.getProductPriceRangeCount(minprice, maxprice, categoryId);			
		}else {
			pageCategoryId = getCategoryId();
			return INPUT;
		}
		
		int last = count/rows;
		if(count%rows==0){
			lastPage=last-1;
			
		}else{
			lastPage=last;
			
		}
		
		if(reqPage!=null){
			page=Integer.parseInt(reqPage);	
			tempPage=page;
		}else{
			page=0;	
			tempPage=0;
		}
		
		currentPage=tempPage+1;
		logger.info("currentPage......."+currentPage);
		next = page+1;
		previous = page-1;
		
		
		if(page==0){
			firsthide = false;}
		else{
			firsthide = true;}
		
		if(page==last){
			lasthide = false;
		}else if(page!=0 && count-(page*rows)==rows){
			lasthide = false;
		} else{
			lasthide = true;}
		if(count>rows){show=true;}
		else{
			show=false;}
		
		previousPage=previous;
		nextPage=next;
		
		page = page*rows;
		
		List<ProductModel> categoryProds = null;
		
		if((prodTypeIds!=null && prodTypeIds.size()>0)&& (brandIds ==null || brandIds.size()==0 )&&(searchMinPrice ==null || searchMaxPrice==null)){
			categoryProds = prodService.getProdsFromProdTypeAndBrands(prodTypeIds,null,null,page,rows,null,null);
		} else if((prodTypeIds!=null && prodTypeIds.size()>0)&& (brandIds ==null || brandIds.size()==0 ) && (searchMinPrice !=null || searchMaxPrice!=null )){
			categoryProds = prodService.getProdsFromProdTypeAndBrands(prodTypeIds,null,null,page,rows,searchMinPrice,searchMaxPrice);
		} else if((brandIds!=null && brandIds.size()>0) && (prodTypeIds ==null || prodTypeIds.size()==0 ) && categoryId!=null &&(searchMinPrice ==null || searchMaxPrice==null)){
			categoryProds = prodService.getProdsFromProdTypeAndBrands(null,brandIds,categoryId,page,rows,null,null);
		} else if((brandIds!=null && brandIds.size()>0) && (prodTypeIds ==null || prodTypeIds.size()==0 ) && categoryId!=null && (searchMinPrice !=null || searchMaxPrice!=null )){
			categoryProds = prodService.getProdsFromProdTypeAndBrands(null,brandIds,categoryId,page,rows,searchMinPrice,searchMaxPrice);
		} else if((minprice!=null && maxprice!=null) &&(brandIds == null || brandIds.size()==0) &&(prodTypeIds ==null || prodTypeIds.size()==0)){
			categoryProds = prodService.getPriceRangeProducts(categoryId, minprice, maxprice, page, rows);			
		}
		else {
			categoryProds = prodService.getProdsFromProdTypeAndBrands(prodTypeIds,brandIds,categoryId,page,rows,searchMinPrice,searchMaxPrice);
		}
		
		int pageNationCount=0;
		
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		logger.info("tempPage///////////"+tempPage);	
		
		logger.info("countRows-------"+pageNationCount);
		logger.info("last-------"+last);	
		if(tempPage<=2){
			if(pageNationCount==1){
				min=1;
				max=1;
			}else
				if(pageNationCount==2){
					min=1;
					max=2;
				}else
					if(pageNationCount==3){
						min=1;
						max=3;
					}else
						if(pageNationCount==4){
							min=1;
							max=4;
						}else{
							min=1;
							max=5;
						}
		}else{
			tempPage=tempPage+1;
			if(tempPage==pageNationCount){
				
				min=tempPage-2;
				max=tempPage;
			}else
			if(tempPage==pageNationCount-1){
				min=tempPage-2;
				max=tempPage+1;
			}else{
				min=tempPage-2;
				max=tempPage+2;
			}
		}
		
		for(int i=min;i<=max;i++){
			ShowPage showPage = new ShowPage();
			showPage.setPageNumber(i-1);
			showPage.setPageNumber1(i);
			showPageList.add(showPage);
		}
		
		productModelsMap = new HashMap<Long,String> ();
		productBrandMap = new HashMap<Long,String> ();
		
		if(categoryProds!=null && categoryProds.size()>0){
			brandProdList = new ArrayList<ProductModel>();
			brandProdList.addAll(categoryProds);
			/*minPrice = categoryProds.get(0).getMrpPrice();
			maxPrice = categoryProds.get(categoryProds.size()-1).getMrpPrice();*/
			/*if(minprice!=null && maxprice!=null){
				
				searchMinPrice = minprice;
				searchMaxPrice = maxprice;
			} else {
				searchMinPrice = minPrice;
				searchMaxPrice = maxPrice;
			}*/
			
			/*Map<Long,Object> sessionProdTypes = (Map<Long,Object>) session.get("productModelsMap");
			if(sessionProdTypes!=null){
				sessionProdTypes.
			}*/
			
			/*Map<Long,Object> sessionProdTypes = (Map<Long,Object>) session.get("productModelsMap");
			Set<Long> prodTypeId = sessionProdTypes.keySet();
			Map<Long,String> newProdTypes = new HashMap<Long,String>();
			for(Long id:prodTypeId){
				for(ProductModel pm:categoryProds){
				if(pm.getProdTypeModel().getProdTypeId().longValue() != id.longValue()){
					newProdTypes.put(pm.getProdTypeModel().getProdTypeId(),pm.getProdTypeModel().getProdTypeName());
				}
			  }
			}*/
			
			/*for(ProductModel pm:categoryProds){
				if(sessionProdTypes!=null){
					for(Long id:prodTypeId){
							if(pm.getProdTypeModel().getProdTypeId().longValue() != id.longValue()){
								sessionProdTypes.remove(pm.getProdTypeModel().getProdTypeId());
							}
						}
				}
				productModelsMap.put(pm.getProdTypeModel().getProdTypeId(), pm.getProdTypeModel().getProdTypeName());
				productBrandMap.put(pm.getBrandModel().getBrandId(), pm.getBrandModel().getBrandName());
			}*/
			
			prodTypeIdList = new ArrayList<Long>();
			brandIdList = new ArrayList<Long>();
			prodTypeIdList.addAll(prodTypeIds);
			brandIdList.addAll(brandIds);
			/*if(newProdTypes.size()>0&&newProdTypes!=null){
				session.put("productModelsMap", newProdTypes);
			} else {
				session.put("productModelsMap", sessionProdTypes);
			}*/
			//session.put("selProdIds", prodTypeIds);
			//session.put("selBrandIds", brandIds);
			//session.put("mobileCatId", allMobiles.get(0).getProdTypeModel().getCategoryModel().getCategoryId());
			//session.put("minprice", minprice);
			//session.put("maxprice",maxprice);
			//session.put("productModelsMap", productModelsMap);
			//session.put("productBrandMap", productBrandMap);
			pageSelectedProds = getSelectedProds();
			pageCategoryId = getCategoryId();
			return SUCCESS;
		} else {
			pageCategoryId = getCategoryId();
			prodTypeIdList = new ArrayList<Long>();
			brandIdList = new ArrayList<Long>();
			prodTypeIdList.addAll(prodTypeIds);
			brandIdList.addAll(brandIds);
			return SUCCESS;
		}
		//return SUCCESS;
		
		
	}
	
	
	public List<BrandModel> getBrandNames() {
		return brandNames;
	}

	public void setBrandNames(List<BrandModel> brandNames) {
		this.brandNames = brandNames;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public ProductService getProdService() {
		return prodService;
	}

	public void setProdService(ProductService prodService) {
		this.prodService = prodService;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public List<ProductModel> getBrandProdList() {
		return brandProdList;
	}

	public void setBrandProdList(List<ProductModel> brandProdList) {
		this.brandProdList = brandProdList;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<ProductModel> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductModel> productTypes) {
		this.productTypes = productTypes;
	}

	public List<ProductTypeModel> getProductTypeModels() {
		return productTypeModels;
	}

	public void setProductTypeModels(List<ProductTypeModel> productTypeModels) {
		this.productTypeModels = productTypeModels;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String showAllProds(){
		return SUCCESS;
	}

	public Long getProdTypeId() {
		return prodTypeId;
	}

	public void setProdTypeId(Long prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public List<ProductModel> getProdmodels() {
		return prodmodels;
	}

	public void setProdmodels(List<ProductModel> prodmodels) {
		this.prodmodels = prodmodels;
	}

	public Map<Long, String> getProductModelsMap() {
		return productModelsMap;
	}

	public void setProductModelsMap(Map<Long, String> productModelsMap) {
		this.productModelsMap = productModelsMap;
	}

	public String getProdTypeName() {
		return prodTypeName;
	}

	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}

	public List<Long> getProdTypeIdList() {
		return prodTypeIdList;
	}

	public void setProdTypeIdList(List<Long> prodTypeIdList) {
		this.prodTypeIdList = prodTypeIdList;
	}

	public List<Long> getBrandIdList() {
		return brandIdList;
	}

	public void setBrandIdList(List<Long> brandIdList) {
		this.brandIdList = brandIdList;
	}

	public Map<Long, String> getProductBrandMap() {
		return productBrandMap;
	}

	public void setProductBrandMap(Map<Long, String> productBrandMap) {
		this.productBrandMap = productBrandMap;
	}

	public Map<Long, String> getProductTypesMap() {
		return productTypesMap;
	}

	public void setProductTypesMap(Map<Long, String> productTypesMap) {
		this.productTypesMap = productTypesMap;
	}

	public String getSelectedProds() {
		return selectedProds;
	}

	public void setSelectedProds(String selectedProds) {
		this.selectedProds = selectedProds;
	}

	public static Logger getLogger() {
		return logger;
	}	
	

	public String getFromWhichList() {
		return fromWhichList;
	}


	public void setFromWhichList(String fromWhichList) {
		this.fromWhichList = fromWhichList;
	}
	
	
	public class ShowPage{
		int pageNumber;
		int pageNumber1;

		public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public int getPageNumber1() {
			return pageNumber1;
		}

		public void setPageNumber1(int pageNumber1) {
			this.pageNumber1 = pageNumber1;
		}
	}


	public List<ShowPage> getShowPageList() {
		return showPageList;
	}




	public void setShowPageList(List<ShowPage> showPageList) {
		this.showPageList = showPageList;
	}




	public String getPageNumbers() {
		return pageNumbers;
	}




	public void setPageNumbers(String pageNumbers) {
		this.pageNumbers = pageNumbers;
	}




	public int getNextPage() {
		return nextPage;
	}




	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}




	public int getLastPage() {
		return lastPage;
	}




	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}




	public int getPreviousPage() {
		return previousPage;
	}




	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}




	public boolean isFirsthide() {
		return firsthide;
	}




	public void setFirsthide(boolean firsthide) {
		this.firsthide = firsthide;
	}




	public boolean isLasthide() {
		return lasthide;
	}




	public void setLasthide(boolean lasthide) {
		this.lasthide = lasthide;
	}




	public boolean isShow() {
		return show;
	}




	public void setShow(boolean show) {
		this.show = show;
	}




	public int getCurrentPage() {
		return currentPage;
	}




	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}




	public Long getPageCategoryId() {
		return pageCategoryId;
	}




	public void setPageCategoryId(Long pageCategoryId) {
		this.pageCategoryId = pageCategoryId;
	}




	public Long getPagebrandId() {
		return pagebrandId;
	}




	public void setPagebrandId(Long pagebrandId) {
		this.pagebrandId = pagebrandId;
	}




	public Long getPageProdTypeId() {
		return pageProdTypeId;
	}




	public void setPageProdTypeId(Long pageProdTypeId) {
		this.pageProdTypeId = pageProdTypeId;
	}




	public List<Long> getPageProdTypeIdList() {
		return pageProdTypeIdList;
	}




	public void setPageProdTypeIdList(List<Long> pageProdTypeIdList) {
		this.pageProdTypeIdList = pageProdTypeIdList;
	}




	public List<Long> getPageBrandIdList() {
		return pageBrandIdList;
	}




	public void setPageBrandIdList(List<Long> pageBrandIdList) {
		this.pageBrandIdList = pageBrandIdList;
	}




	public String getPageSelectedProds() {
		return pageSelectedProds;
	}




	public void setPageSelectedProds(String pageSelectedProds) {
		this.pageSelectedProds = pageSelectedProds;
	}




	public Double getSearchMaxPrice() {
		return searchMaxPrice;
	}




	public void setSearchMaxPrice(Double searchMaxPrice) {
		this.searchMaxPrice = searchMaxPrice;
	}




	public Double getSearchMinPrice() {
		return searchMinPrice;
	}




	public void setSearchMinPrice(Double searchMinPrice) {
		this.searchMinPrice = searchMinPrice;
	}
}
