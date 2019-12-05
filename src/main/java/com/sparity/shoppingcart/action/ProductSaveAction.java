package com.sparity.shoppingcart.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.common.ShoppingCartConstants;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.Product;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductSpecMappingModel;
import com.sparity.shoppingcart.model.ProductSpecModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.service.ProductService;
import com.sparity.shoppingcart.service.ProductSpecMappingService;
import com.sparity.shoppingcart.service.ProductSpecService;
import com.sparity.shoppingcart.view.ProductViewBean;


public class ProductSaveAction extends BaseAction{
	private final Logger log = Logger.getLogger(ProductSaveAction.class);
	private static final long serialVersionUID = 1L;
	
/*	private ProductService productService=(ProductService) getServiceBean("productService");
	
	private ProductViewBean productViewBean;
    private List<ProductModel>productModelList;*/
	List<ShowPage> showPageList= new ArrayList<ShowPage>();
    private String pageNumbers;
   	private int nextPage;
    private int lastPage;
    private int previousPage;
    private boolean firsthide;
    private boolean lasthide;
    private boolean show;
    private int currentPage;
    private long prodId;
    private Long categoryid;
    private long sessionsize;
   
	private ProductService productService=(ProductService) getServiceBean("productService");
	private ProductSpecService productSpecService=(ProductSpecService) getServiceBean("productSpecService");;
	
	private ProductSpecMappingService productSpecMappingService=(ProductSpecMappingService) getServiceBean("productSpecMappingService");
	private ProductViewBean productViewBean;
    private List<ProductModel> productCheckBoxList= new ArrayList<ProductModel>();
	//private List<ProductSpecModel> productSpecList= new ArrayList<ProductSpecModel>();
	
	//private List<ProductSpecMappingModel> productMappingList= new ArrayList<ProductSpecMappingModel>();
	private List<Long> gridCompare= new ArrayList<Long>();
	//private List<BaseModel>finalList=new ArrayList<BaseModel>();
	//private List<Object> finalList=new ArrayList<Object>();
	//private String[] gridCompare;	
	private List<ProductModel>productModelList;
	//List<ProductSpecMappingModel> prodSpecMappingList;
	//private List<Object>  finalSpec=new ArrayList<Object>();
	/*List<ProductTypeModel> producttypes;
	List<BrandModel> brandModel;*/
    private List<BrandModel> brandModel;
    private List<ProductTypeModel> producttypes;
    
	

	

/*	public List<ProductTypeModel> getProducttypes() {
		return producttypes;
	}

	public void setProducttypes(List<ProductTypeModel> producttypes) {
		this.producttypes = producttypes;
	}*/











	/*public List<BrandModel> getBrandModel() {
		return brandModel;
	}

	public void setBrandModel(List<BrandModel> brandModel) {
		this.brandModel = brandModel;
	}*/

    
    
	public List<ProductModel> getProductModelList() {
		return productModelList;
	}

	public void setProductModelList(List<ProductModel> productModelList) {
		this.productModelList = productModelList;
	}

	public String saveProduct() {
		try {
			
			log.info("inside Action of saveProduct");
			Product prod = new Product();
			prod.setCode(productViewBean.getCode());
			prod.setDesc(productViewBean.getDesc());
			prod.setName(productViewBean.getName());
			prod.setPrice(productViewBean.getPrice());
			log.info("inside Action of saveProduct "+productViewBean.getCode());
			productService.save(prod);
			log.info("Saved success Fully...................");
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	
	public String productList()
	{
		
		producttypes=productService.getProductTypes();
		brandModel= productService.getBrands();
		
		log.info("inside Action of productList");
		int rows = 10;
		int page=0;
		int previous=0; 
		int next=0;
		int tempPage=0;
		
		String reqPage = pageNumbers;
		log.info("reqPage is.."+reqPage);
		
		int count = productService.countTransactions();
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
		log.info("currentPage......."+currentPage);
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
		
		productModelList=productService.findAllProducts(page,rows);
		log.info("productModelList size is.."+productModelList.size());
		log.info("show  is.."+show);
		
		
		
		int pageNationCount=0;
		List<Integer> pageNationList2= new ArrayList<Integer>();
		
		int min=0;
		int max=0;
		
		if(count%rows==0){
			pageNationCount=count/rows;
		}else{
			pageNationCount=(count/rows)+1;
		}
		
		log.info("tempPage///////////"+tempPage);	
		
		log.info("countRows-------"+pageNationCount);
		log.info("last-------"+last);	
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
		
		return SUCCESS;
	}
	
	
	//}


	@SuppressWarnings("unchecked")
	public String testcompare1()
	{
		
		long prodId= getProdId();
		Map<String,Object> session = getSession();
	    log.info("inside testcompare1"+prodId);
	
		List<Long> prodIds = null;
		if(session.get("comList")!=null){
				
			Long comid = (Long) session.get("comListcatid");
			if(comid.longValue()==categoryid.longValue())
			{
				
				List<Long> ids = (List<Long>) session.get("comList");
				prodIds = new ArrayList<Long>();
				prodIds.addAll(ids);
				prodIds.add(new Long(prodId));
			}
			else
			{
				addActionError("you can compare only similar products");
			}		
			
		}
		else {
			prodIds = new ArrayList<Long>();
			prodIds.add(new Long(prodId));
		}
		/*l.add(prodId);
		log.info("list l size is"+l.size());*/
		
		session.put("comList",prodIds);
	
		session.put("sesssize", prodIds.size());
		session.put("comListcatid", categoryid);
		
		
	    //productCheckBoxList=productService.findDataOfCheckBox(gridCompare);
		
	    return SUCCESS;
		
	}
	public String testcompareunchecked()
	
	{
		Map<String,Object> session = getSession();
		List<Long> uncheckIdsList = (List<Long>) session.get("comList");
		for(Long id: uncheckIdsList){
			if(id==getProdId()){
				uncheckIdsList.remove(getProdId());
			}
		}
		//session.remove("comList");
		session.put("comList",uncheckIdsList);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String testcompare()
	{
		Map<String,Object> session = getSession();
		List<Long> ll = (List<Long>)session.get("comList");
		
		log.info("ll size"+ll.size());
		
		if(ll.size()>4)
		{
			
			addActionMessage("please select maximum of four products");
			
			session.remove("comList");
			session.remove("comListcatid");
		    session.remove("sesssize");
		    return INPUT;
		    
		    
			
		}
		else
		{
		productCheckBoxList=productService.findDataOfCheckBox(ll);
		session.remove("comList");
		session.remove("comListcatid");
	    session.remove("sesssize");
		return SUCCESS;
		}
	
	
		
	}
	

	public String addProduct() {
		return SUCCESS;
	}

	

	public String compareProds(String item1,String item2){
	
		return "str";
	}
	
	public String constantsCheck(){
		ShoppingCartConstants scc = (ShoppingCartConstants)getServiceBean("appconstants");
		log.info("constvalue "+scc.getSpconstants());
		return SUCCESS;
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
	
	
	public void validate() {

	}
	
	public String InsertRecord(){
		return SUCCESS;
		
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductViewBean getProductViewBean() {
		return productViewBean;
	}

	public void setProductViewBean(ProductViewBean productViewBean) {
		this.productViewBean = productViewBean;
	}
	/*public List<ShowPage> getShowPageList() {
		return showPageList;
	}


	public void setShowPageList(List<ShowPage> showPageList) {
		this.showPageList = showPageList;
	}*/



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

		public List<ShowPage> getShowPageList() {
			return showPageList;
		}

		public void setShowPageList(List<ShowPage> showPageList) {
			this.showPageList = showPageList;
		}

		public int getCurrentPage() {
			return currentPage;
		}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ProductSpecService getProductSpecService() {
		return productSpecService;
	}



	public void setProductSpecService(ProductSpecService productSpecService) {
		this.productSpecService = productSpecService;
	}



	public ProductSpecMappingService getProductSpecMappingService() {
		return productSpecMappingService;
	}



	public void setProductSpecMappingService(
			ProductSpecMappingService productSpecMappingService) {
		this.productSpecMappingService = productSpecMappingService;
	}



	public List<ProductModel> getProductCheckBoxList() {
		return productCheckBoxList;
	}



	public void setProductCheckBoxList(List<ProductModel> productCheckBoxList) {
		this.productCheckBoxList = productCheckBoxList;
	}




	public List<Long> getGridCompare() {
		return gridCompare;
	}



	public void setGridCompare(List<Long> gridCompare) {
		this.gridCompare = gridCompare;
	}






	public List<ProductTypeModel> getProducttypes() {
		return producttypes;
	}




	public void setProducttypes(List<ProductTypeModel> producttypes) {
		this.producttypes = producttypes;
	}




	public List<BrandModel> getBrandModel() {
		return brandModel;
	}




	public void setBrandModel(List<BrandModel> brandModel) {
		this.brandModel = brandModel;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public long getSessionsize() {
		return sessionsize;
	}

	public void setSessionsize(long sessionsize) {
		this.sessionsize = sessionsize;
	}

		
	
	
}
