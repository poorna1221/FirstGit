package com.sparity.shoppingcart.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;


import com.opensymphony.xwork2.ActionContext;
import com.sparity.shoppingcart.action.ProductsAction.ShowPage;
import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.CategoryModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.service.AdminService;
import com.sparity.shoppingcart.service.HomePageService;
import com.sparity.shoppingcart.service.ProductService;
import com.sparity.shoppingcart.view.AdminViewBean;
import com.sparity.shoppingcart.view.ProductViewBean;

public class AdminAction extends BaseAction {

	private static final long serialVersionUID = -3106583003618296218L;
	private static final Logger logger = Logger.getLogger(AdminAction.class);
	private HomePageService homepageService = (HomePageService) getServiceBean("homePageService");

	private ProductService productService = (ProductService) getServiceBean("productService");
	private AdminService adminService=(AdminService) getServiceBean("adminService");
	  
	private AdminViewBean adminViewBean;
	
	
	
	private ProductViewBean productViewBean;

	private List<ProductModel> productHomeComputersList = new ArrayList<ProductModel>();

	private List<ProductModel> productHomeCamerasList = new ArrayList<ProductModel>();

	private List<ProductModel> productHomeGiftsList = new ArrayList<ProductModel>();

	private List<BrandModel> brandList;
	private List<ProductTypeModel> prodctTypeList;

	private List<BrandModel> cambrandList;
	private List<ProductTypeModel> camprodctTypeList;

	private List<BrandModel> compbrandList;
	private List<ProductTypeModel> compprodctTypeList;

	private List<BrandModel> accbrandList;
	private List<ProductTypeModel> accprodctTypeList;
	private List<BrandModel> trypodbrandList;
	private List<ProductTypeModel> trypodprodctTypeList;
	private List<BrandModel> giftbrandList;
	private List<ProductTypeModel> giftprodctTypeList;
	private List<AlbumTypeModel> albumTypeList;


	
	private List<BrandModel> elcbrandList;
	private List<ProductTypeModel> elcprodctTypeList;
	private List<ProductModel> productModelListHomePage = new ArrayList<ProductModel>();
	private List<ProductModel> productHomeMobilesList = new ArrayList<ProductModel>();
	private List<ProductModel> productCamList;
	
	private List<BrandModel> lenseBrandList;
	private List<ProductTypeModel> lenseprodctTypeList;

	private Long catId;

	private List<ProductModel> productSpecModel;
	private String imageId;
	private String jspPage;
	private Long prodId;
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
	 
	 
		private Double adminmrp;
	    private Double adminoffer;
	    private Long productid;
		
		
		
		
		@SuppressWarnings("unused")
		public String Signin(){
			
			logger.info("Admin emailId"+adminViewBean.getEmailId());
			logger.info("Admin Password"+adminViewBean.getPassword());
			
			
			AdminModel admin=adminService.getadmindetials(adminViewBean.getEmailId(),adminViewBean.getPassword());
			
			  if(admin==null){
				  addActionError("Your LoginDetails were incorrect");
				  return ERROR;
			  }
			
			  else{
				  
				  Map<String,Object> session=getSession();
				  session.put("admin", admin);
				  
			  }
			  
			  
			return SUCCESS;
		}
		
		
		
		
		
		
		
		
		
	//----------------------------------------------------change PassWord------------------------------------------------------------	
		
		
	   public String ChangePassword(){
		   
		  
		   Map<String,Object> session=getSession();
		 
		   String email=adminViewBean.getEmailId();
		   String pass=adminViewBean.getPassword();	   
		   String newpassword=adminViewBean.getNewPassword();
		   String mobilenum=adminViewBean.getMobileNumber();
		   AdminModel admin= (AdminModel) session.get("admin");
		   
		  // String email=admin.getEmailId();
		    
		   if(admin.getEmailId().equals(email) && admin.getPassword().equals(pass))
		   {	   
		   
		        admin.setMobilenumber(mobilenum);  
		    	admin.setPassword(newpassword);	
		    
		        AdminModel am=   adminService.changePassword(admin);
		     
		  
		    
		    addActionMessage("Your Account changed Successfully");
		    return SUCCESS;
		   }
		   else   if (admin.getEmailId().equals(email) || !(admin.getPassword().equals(pass)) ) 
		   {
			   
			   addActionError("Your old Password does n't match");
		       return ERROR;
		   } 
		      
	    
		   else 
		   {
		    	  AdminModel am =adminService.exist(email);
		    	  if(am==null){
		   		   
		   		   admin.setEmailId(email);
		   		   admin.setMobilenumber(mobilenum);
		   		   admin.setPassword(newpassword);	
		   		   
		   		   adminService.update(admin);
		   		
		   		   addActionMessage("Your Account changed Successfully");
				   return SUCCESS;
		    	  }
		    
		    	  else{
				    addActionError("emailId is already existed.Choose different emailid");
				    return ERROR;
		   	     }
		   }	
	   }	
		  

	 //--------------------------------------------------forgot password-----------------------------------------------------------
		
		
		public String forgotPassword()
		{
			
			String email=adminViewBean.getEmailId();
			logger.info("_____________________"+email);
			 
		AdminModel emailExists=adminService.forgotPassword(email);
			
		     if(emailExists==null)
		     {
		    	 addActionError("Your Email Address is incorrect!");
		    	 return ERROR;
		     }
		     
		     else{
		    	 
		    	Properties props = new Properties();
		 		
		    	props.put("mail.smtp.host", "smtp.gmail.com");
		 		props.put("mail.smtp.socketFactory.port", "465");
		 		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 		props.put("mail.smtp.auth", "true");
		 		props.put("mail.smtp.port", "465");

		 		Session session = Session.getDefaultInstance(props,
		 			new javax.mail.Authenticator() {
		 				protected PasswordAuthentication getPasswordAuthentication() {
		 					return new PasswordAuthentication("shashank.gee@gmail.com","whatif7whatif7");
		 				}
		 			});

		 		
		 		try {
	                
		 			Message message = new MimeMessage(session);
		 			message.setFrom(new InternetAddress("shashank"));
		 			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(email));
		 			message.setSubject("Forgot PassWord ");
		 			
		 			message.setText("Dear Customer ,"+"\n"+"Your Signin Details for www.parasDigitalWorld.com are as under:"
		 					+"\n"
		 					+ "Your EmailId is"+"\t"+emailExists.getEmailId()+"\n\n  Your password is"+ "\t"
		 					+   emailExists.getPassword());
	              
		 			Transport.send(message);

		 		
		 		} catch (MessagingException e) {
		 			throw new RuntimeException(e);
		 		}
		   
		 		addActionMessage("Your Password has been  sent successfully.");	 
		 		return SUCCESS;
		}
	}	
		

	   
	   
		public String Cancel(){
			
			return SUCCESS;
			
		}
		
		
		
	   
	   public String Myaccount(){
			
			return SUCCESS;
			
		}
		
	     
		public String Home(){
			 
			
			return SUCCESS;
		}
		
		
		public String	Logout(){
			 
			Map<String,Object> session=getSession();
			 session.remove("admin");
	    	 return SUCCESS;
	     }
		public String showHomePage() {

			List<CategoryModel> catList = getHomepageService().getCategoryList();
			logger.info("catList is" + catList.size());
			// List<BrandModel> brandsList = getHomepageService().getBrandList();
			List<ProductTypeModel> prodTypeList = getHomepageService()
					.getProdTypeList();

			brandList = new ArrayList<BrandModel>();
			prodctTypeList = new ArrayList<ProductTypeModel>();
			cambrandList = new ArrayList<BrandModel>();
			camprodctTypeList = new ArrayList<ProductTypeModel>();
			compbrandList = new ArrayList<BrandModel>();
			compprodctTypeList = new ArrayList<ProductTypeModel>();
			accbrandList = new ArrayList<BrandModel>();
			accprodctTypeList = new ArrayList<ProductTypeModel>();
			elcbrandList = new ArrayList<BrandModel>();
			elcprodctTypeList = new ArrayList<ProductTypeModel>();
			trypodbrandList = new ArrayList<BrandModel>();
			trypodprodctTypeList = new ArrayList<ProductTypeModel>();
			giftbrandList = new ArrayList<BrandModel>();
			giftprodctTypeList = new ArrayList<ProductTypeModel>();
			albumTypeList = new ArrayList<AlbumTypeModel>();

			lenseBrandList = new ArrayList<BrandModel>();
			lenseprodctTypeList=new ArrayList<ProductTypeModel>();

			Map<String, Object> application = (Map<String, Object>) ActionContext
					.getContext().get("application");
			albumTypeList = getHomepageService().getAlbumTypeList();

			if (catList != null && catList.size() > 0) {
				if (logger.isInfoEnabled())
					logger.info("category List Size-------- :" + catList.size());

				for (CategoryModel cl : catList) {
					if (cl.getCategoryName().equalsIgnoreCase("mobiles")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("mobiles")) {
								prodctTypeList.add(pm);
							}
						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								for (CategoryModel cm : bm.getCategoryModel()) {
									if (cm.getCategoryName().equalsIgnoreCase(
											"mobiles"))
										brandList.add(bm);
								}
							}
						}

					}
					// for cameras category
					if (cl.getCategoryName().equalsIgnoreCase("cameras")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("cameras")) {
								camprodctTypeList.add(pm);
							}
						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								for (CategoryModel cm : bm.getCategoryModel()) {
									if (cm.getCategoryName().equalsIgnoreCase(
											"cameras"))
										cambrandList.add(bm);
								}

							}
						}

					}
					// for computers category
					if (cl.getCategoryName().equalsIgnoreCase("computers")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("computers")) {
								compprodctTypeList.add(pm);
							}
						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								for (CategoryModel cm : bm.getCategoryModel()) {
									if (cm.getCategoryName().equalsIgnoreCase(
											"computers"))
										compbrandList.add(bm);
								}

							}
						}

					}
					// for Electronics
					if (cl.getCategoryName().equalsIgnoreCase("electronics")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("electronics")) {
								elcprodctTypeList.add(pm);
							}
						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								if (cl.getCategoryName().equalsIgnoreCase(
										"electronics"))
									elcbrandList.add(bm);
							}
						}

					}

					if (cl.getCategoryName().equalsIgnoreCase("accessories")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("accessories")) {
								accprodctTypeList.add(pm);

							}

						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								if (cl.getCategoryName().equalsIgnoreCase(
										"accessories"))
									accbrandList.add(bm);

							}
						}

					}
					// for Trypod
					if (cl.getCategoryName().equalsIgnoreCase("trypods")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("trypods")) {
								trypodprodctTypeList.add(pm);

							}

						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								if (cl.getCategoryName()
										.equalsIgnoreCase("trypods"))
									trypodbrandList.add(bm);

							}
						}

					}
					// for gifts
					if (cl.getCategoryName().equalsIgnoreCase("gifts")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("gifts")) {
								giftprodctTypeList.add(pm);

							}

						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								if (cl.getCategoryName().equalsIgnoreCase("gifts"))
									giftbrandList.add(bm);

							}
						}

					}
				// for lenses category
					if (cl.getCategoryName().equalsIgnoreCase("lens")) {
						for (ProductTypeModel pm : prodTypeList) {
							if (pm.getCategoryModel().getCategoryName()
									.equalsIgnoreCase("lens")) {
								lenseprodctTypeList.add(pm);

							}

						}

						if (cl.getBrand() != null && cl.getBrand().size() > 0) {
							for (BrandModel bm : cl.getBrand()) {
								if (cl.getCategoryName().equalsIgnoreCase("lens"))
									lenseBrandList.add(bm);

							}
						}

					}
	logger.info("bm is________---");
				}

				application.put("brandList", brandList);
				application.put("prodctTypeList", prodctTypeList);
				application.put("cambrandList", cambrandList);
				application.put("camprodctTypeList", camprodctTypeList);
				application.put("compbrandList", compbrandList);
				application.put("compprodctTypeList", compprodctTypeList);
				application.put("accbrandList", accbrandList);
				application.put("accprodctTypeList", accprodctTypeList);
				application.put("elcbrandList", elcbrandList);
				application.put("elcprodctTypeList", elcprodctTypeList);
				application.put("trypodbrandList", trypodbrandList);
				application.put("trypodprodctTypeList", trypodprodctTypeList);
				application.put("giftbrandList", giftbrandList);
				application.put("giftprodctTypeList", giftprodctTypeList);
				
		logger.info("lenseprodctTypeList is"+lenseprodctTypeList);
		logger.info("lenseBrandList is"+lenseBrandList);
		
				
				application.put("lenseprodctTypeList", lenseprodctTypeList);
				application.put("lenseBrandList", lenseBrandList);
				
				application.put("mobileCategory", prodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("compCategory", compprodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("elcCategory", elcprodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("cameraCategory", camprodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("accessorisCategory", accprodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("trypodCategory", trypodprodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("giftCategory", giftprodctTypeList.get(0)
						.getCategoryModel().getCategoryId());
				application.put("albumTypeList", albumTypeList);
				
				
				application.put("lensCategory", lenseprodctTypeList.get(0).getCategoryModel().getCategoryId());
				
				
			} else {
				if (logger.isInfoEnabled())
					logger.info("No category exist");
			}
			productModelListHomePage = productService.findAllProductsHomePage();
			logger.info("*******????????" + productModelListHomePage.size());

			productHomeMobilesList = new ArrayList<ProductModel>();
			for (ProductModel prod : productModelListHomePage) {
				if (prod.getProdTypeModel().getCategoryModel().getCategoryName()
						.equalsIgnoreCase("mobiles")) {

					productHomeMobilesList.add(prod);
				} else if (prod.getProdTypeModel().getCategoryModel()
						.getCategoryName().equalsIgnoreCase("computers")) {

					productHomeComputersList.add(prod);

				} else if (prod.getProdTypeModel().getCategoryModel()
						.getCategoryName().equalsIgnoreCase("cameras")) {

					productHomeCamerasList.add(prod);
				} else if (prod.getProdTypeModel().getCategoryModel()
						.getCategoryName().equalsIgnoreCase("electronics")) {
					productHomeGiftsList.add(prod);
				}
				// logger.info("productHomeComputersList size is"+productHomeComputersList.size());
			}
			return SUCCESS;
		}
		public String showAllCategoryProducts(){
			
			productModelsMap = new HashMap<Long,String> ();
			productBrandMap = new HashMap<Long,String> ();
			Map<String,Object> session =  getSession();
			logger.info("Category Id is ======"+categoryId);
			
			List<ProductModel> allProdTypesBrands = productService.getAllCategoryProds(categoryId);
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
				List<Object> priceRanges = productService.getMinAndMaxPriceForProducts(categoryId, null, null);
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
			
			int count = adminService.getCountForCategoryProducts(categoryId);
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
			
			List<ProductModel> allCategoryProds = adminService.getAllCategoryProds(categoryId,page,rows);
			
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

	public String adminmrpofferprice()
	{
		
		
		logger.info("admin   mrp price is "+adminmrp);
		logger.info("admin offer price is"+adminoffer);
		
	    ProductModel pmo =productService.getproductIdRow(productid);
	    
	    logger.info("pmo imagename is"+pmo.getImpagePath());
	    pmo.setProductId(productid);
		pmo.setMrpPrice(adminmrp);
		pmo.setOfferPrice(adminoffer);
	
		
		productService.updatepricedetails(pmo);
		
		addActionMessage("product details saved successfully");
		showAllCategoryProducts();
		
		
		return SUCCESS;
	}
	public String adminmrpofferpricedelete()
	{
	
	ProductModel pmo =productService.getproductIdRow(productid);
		
		pmo.setProdstatus(new Boolean(false));
		productService.updateStatus(pmo);
		
		
		addActionMessage("product deleted successfully");
		showAllCategoryProducts();
		return SUCCESS;
	}
	public HomePageService getHomepageService() {
		return homepageService;
	}
	public void setHomepageService(HomePageService homepageService) {
		this.homepageService = homepageService;
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
	public List<ProductModel> getProductHomeComputersList() {
		return productHomeComputersList;
	}
	public void setProductHomeComputersList(
			List<ProductModel> productHomeComputersList) {
		this.productHomeComputersList = productHomeComputersList;
	}
	public List<ProductModel> getProductHomeCamerasList() {
		return productHomeCamerasList;
	}
	public void setProductHomeCamerasList(List<ProductModel> productHomeCamerasList) {
		this.productHomeCamerasList = productHomeCamerasList;
	}
	public List<ProductModel> getProductHomeGiftsList() {
		return productHomeGiftsList;
	}
	public void setProductHomeGiftsList(List<ProductModel> productHomeGiftsList) {
		this.productHomeGiftsList = productHomeGiftsList;
	}
	public List<BrandModel> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<BrandModel> brandList) {
		this.brandList = brandList;
	}
	public List<ProductTypeModel> getProdctTypeList() {
		return prodctTypeList;
	}
	public void setProdctTypeList(List<ProductTypeModel> prodctTypeList) {
		this.prodctTypeList = prodctTypeList;
	}
	public List<BrandModel> getCambrandList() {
		return cambrandList;
	}
	public void setCambrandList(List<BrandModel> cambrandList) {
		this.cambrandList = cambrandList;
	}
	public List<ProductTypeModel> getCamprodctTypeList() {
		return camprodctTypeList;
	}
	public void setCamprodctTypeList(List<ProductTypeModel> camprodctTypeList) {
		this.camprodctTypeList = camprodctTypeList;
	}
	public List<BrandModel> getCompbrandList() {
		return compbrandList;
	}
	public void setCompbrandList(List<BrandModel> compbrandList) {
		this.compbrandList = compbrandList;
	}
	public List<ProductTypeModel> getCompprodctTypeList() {
		return compprodctTypeList;
	}
	public void setCompprodctTypeList(List<ProductTypeModel> compprodctTypeList) {
		this.compprodctTypeList = compprodctTypeList;
	}
	public List<BrandModel> getAccbrandList() {
		return accbrandList;
	}
	public void setAccbrandList(List<BrandModel> accbrandList) {
		this.accbrandList = accbrandList;
	}
	public List<ProductTypeModel> getAccprodctTypeList() {
		return accprodctTypeList;
	}
	public void setAccprodctTypeList(List<ProductTypeModel> accprodctTypeList) {
		this.accprodctTypeList = accprodctTypeList;
	}
	public List<BrandModel> getTrypodbrandList() {
		return trypodbrandList;
	}
	public void setTrypodbrandList(List<BrandModel> trypodbrandList) {
		this.trypodbrandList = trypodbrandList;
	}
	public List<ProductTypeModel> getTrypodprodctTypeList() {
		return trypodprodctTypeList;
	}
	public void setTrypodprodctTypeList(List<ProductTypeModel> trypodprodctTypeList) {
		this.trypodprodctTypeList = trypodprodctTypeList;
	}
	public List<BrandModel> getGiftbrandList() {
		return giftbrandList;
	}
	public void setGiftbrandList(List<BrandModel> giftbrandList) {
		this.giftbrandList = giftbrandList;
	}
	public List<ProductTypeModel> getGiftprodctTypeList() {
		return giftprodctTypeList;
	}
	public void setGiftprodctTypeList(List<ProductTypeModel> giftprodctTypeList) {
		this.giftprodctTypeList = giftprodctTypeList;
	}
	public List<AlbumTypeModel> getAlbumTypeList() {
		return albumTypeList;
	}
	public void setAlbumTypeList(List<AlbumTypeModel> albumTypeList) {
		this.albumTypeList = albumTypeList;
	}
	public List<BrandModel> getElcbrandList() {
		return elcbrandList;
	}
	public void setElcbrandList(List<BrandModel> elcbrandList) {
		this.elcbrandList = elcbrandList;
	}
	public List<ProductTypeModel> getElcprodctTypeList() {
		return elcprodctTypeList;
	}
	public void setElcprodctTypeList(List<ProductTypeModel> elcprodctTypeList) {
		this.elcprodctTypeList = elcprodctTypeList;
	}
	public List<ProductModel> getProductModelListHomePage() {
		return productModelListHomePage;
	}
	public void setProductModelListHomePage(
			List<ProductModel> productModelListHomePage) {
		this.productModelListHomePage = productModelListHomePage;
	}
	public List<ProductModel> getProductHomeMobilesList() {
		return productHomeMobilesList;
	}
	public void setProductHomeMobilesList(List<ProductModel> productHomeMobilesList) {
		this.productHomeMobilesList = productHomeMobilesList;
	}
	public List<ProductModel> getProductCamList() {
		return productCamList;
	}
	public void setProductCamList(List<ProductModel> productCamList) {
		this.productCamList = productCamList;
	}
	public List<BrandModel> getLenseBrandList() {
		return lenseBrandList;
	}
	public void setLenseBrandList(List<BrandModel> lenseBrandList) {
		this.lenseBrandList = lenseBrandList;
	}
	public List<ProductTypeModel> getLenseprodctTypeList() {
		return lenseprodctTypeList;
	}
	public void setLenseprodctTypeList(List<ProductTypeModel> lenseprodctTypeList) {
		this.lenseprodctTypeList = lenseprodctTypeList;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public List<ProductModel> getProductSpecModel() {
		return productSpecModel;
	}
	public void setProductSpecModel(List<ProductModel> productSpecModel) {
		this.productSpecModel = productSpecModel;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getJspPage() {
		return jspPage;
	}
	public void setJspPage(String jspPage) {
		this.jspPage = jspPage;
	}
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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
	public String getProdTypeName() {
		return prodTypeName;
	}
	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}
	public String getFromWhichList() {
		return fromWhichList;
	}
	public void setFromWhichList(String fromWhichList) {
		this.fromWhichList = fromWhichList;
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
	public List<ProductModel> getProdmodels() {
		return prodmodels;
	}
	public void setProdmodels(List<ProductModel> prodmodels) {
		this.prodmodels = prodmodels;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getProdTypeId() {
		return prodTypeId;
	}
	public void setProdTypeId(Long prodTypeId) {
		this.prodTypeId = prodTypeId;
	}
	public List<BrandModel> getBrandNames() {
		return brandNames;
	}
	public void setBrandNames(List<BrandModel> brandNames) {
		this.brandNames = brandNames;
	}
	public Map<Long, String> getProductModelsMap() {
		return productModelsMap;
	}
	public void setProductModelsMap(Map<Long, String> productModelsMap) {
		this.productModelsMap = productModelsMap;
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
	public String getSelectedProds() {
		return selectedProds;
	}
	public void setSelectedProds(String selectedProds) {
		this.selectedProds = selectedProds;
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
	public Double getAdminmrp() {
		return adminmrp;
	}
	public void setAdminmrp(Double adminmrp) {
		this.adminmrp = adminmrp;
	}
	public Double getAdminoffer() {
		return adminoffer;
	}
	public void setAdminoffer(Double adminoffer) {
		this.adminoffer = adminoffer;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}









	public AdminService getAdminService() {
		return adminService;
	}









	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}









	public AdminViewBean getAdminViewBean() {
		return adminViewBean;
	}









	public void setAdminViewBean(AdminViewBean adminViewBean) {
		this.adminViewBean = adminViewBean;
	}


	
	
}
