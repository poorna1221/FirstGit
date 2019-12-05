package com.sparity.shoppingcart.action;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.CategoryModel;
import com.sparity.shoppingcart.model.ProductColorModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.service.HomePageService;
import com.sparity.shoppingcart.service.ProductService;
import com.sparity.shoppingcart.util.CartUtil;
import com.sparity.shoppingcart.view.CartViewVO;
import com.sparity.shoppingcart.view.ProductViewBean;
public class HomePageAction extends BaseAction {
	private static final long serialVersionUID = -4397142033236202572L;
	private static final Logger logger = Logger.getLogger(HomePageAction.class);
	private HomePageService homepageService = (HomePageService) getServiceBean("homePageService");

	private ProductService productService = (ProductService) getServiceBean("productService");
	private ProductViewBean productViewBean;

	private List<ProductModel> productHomeComputersList = new ArrayList<ProductModel>();

	private List<ProductModel> productHomeCamerasList = new ArrayList<ProductModel>();

	private List<ProductModel> productHomeGiftsList = new ArrayList<ProductModel>();
	
	private List<String> prod=new ArrayList<String>();
	

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

	public String productSpec() {

		logger.info("mobiles list" + imageId);
		Map<String, Object> session = getSession();
		List<ProductModel> productModel = homepageService.getImageSpec(prodId);
		
		
		
		
		

		if (productModel != null && productModel.size() > 0) {

			ProductModel prodModel = productModel.get(0);
			
			
			prodModel.setMrpPrice(CartUtil.getOriginalPrice(
					prodModel.getMrpPrice(), prodModel.getOfferPrice()));
			CartViewVO cartProd = new CartViewVO();
			
			cartProd.setProdId(prodModel.getProductId());
			cartProd.setImagePath(prodModel.getImpagePath());
			cartProd.setPrice(CartUtil.getOriginalPrice(
					prodModel.getMrpPrice(), prodModel.getOfferPrice()));
			cartProd.setProdDescription(prodModel.getProductName());
			cartProd.setQuantity(1);
			cartProd.setTotalPrice(CartUtil.getOriginalPrice(
					prodModel.getMrpPrice(), prodModel.getOfferPrice()));

			session.put("cartProd", cartProd);

			String s2 = imageId.substring(0, imageId.length() - 3);
			String s3 = "jsp";
			jspPage = s2.concat(s3);
			
			Set<ProductColorModel> colorList=prodModel.getProductColor();
			for(ProductColorModel cL:colorList)
			{
				
				
				prod.add(cL.getProdColorName());
			}
			
			
		//ProductColorModel prodColor=	(ProductColorModel) prodModel.getProductColor();
			
			
			/*    
		    Set<ShippingAddressModel> shmodel=  userModel.getShippingAddLists();
		    
		    Iterator<ShippingAddressModel>	it = shmodel.iterator();
		    ShippingAddressModel sm = null;
		    while(it.hasNext()){
		    	sm = it.next();
		    	break;
		    }
		    
		    String presentaddress=sm.getPresentAddress();*/
			
			
			
			
			setProductSpecModel(productModel);
			
		}

		return SUCCESS;
	}

	public HomePageService getHomepageService() {
		return homepageService;
	}

	public void setHomepageService(HomePageService homepageService) {
		this.homepageService = homepageService;
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

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageId() {
		return imageId;
	}

	public String getJspPage() {
		return jspPage;
	}

	public void setJspPage(String jspPage) {
		this.jspPage = jspPage;
	}

	public List<ProductModel> getProductspecModel() {
		return productSpecModel;
	}

	public void setProductspecModel(List<ProductModel> productspecModel) {
		productSpecModel = productspecModel;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
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

	public List<ProductModel> getProductCamList() {
		return productCamList;
	}

	public void setProductCamList(List<ProductModel> productCamList) {
		this.productCamList = productCamList;
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

	public List<ProductModel> getProductHomeMobilesList() {
		return productHomeMobilesList;
	}

	public void setProductHomeMobilesList(
			List<ProductModel> productHomeMobilesList) {
		this.productHomeMobilesList = productHomeMobilesList;
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

	public void setProductHomeCamerasList(
			List<ProductModel> productHomeCamerasList) {
		this.productHomeCamerasList = productHomeCamerasList;
	}

	public List<ProductModel> getProductHomeGiftsList() {
		return productHomeGiftsList;
	}

	public void setProductHomeGiftsList(List<ProductModel> productHomeGiftsList) {
		this.productHomeGiftsList = productHomeGiftsList;
	}

	public List<ProductModel> getProductModelListHomePage() {
		return productModelListHomePage;
	}

	public void setProductModelListHomePage(
			List<ProductModel> productModelListHomePage) {
		this.productModelListHomePage = productModelListHomePage;
	}

	public List<AlbumTypeModel> getAlbumTypeList() {
		return albumTypeList;
	}

	public void setAlbumTypeList(List<AlbumTypeModel> albumTypeList) {
		this.albumTypeList = albumTypeList;
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

	public List<BrandModel> getTrypodbrandList() {
		return trypodbrandList;
	}

	public void setTrypodbrandList(List<BrandModel> trypodbrandList) {
		this.trypodbrandList = trypodbrandList;
	}

	public List<ProductTypeModel> getTrypodprodctTypeList() {
		return trypodprodctTypeList;
	}

	public void setTrypodprodctTypeList(
			List<ProductTypeModel> trypodprodctTypeList) {
		this.trypodprodctTypeList = trypodprodctTypeList;
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

	public List<String> getProd() {
		return prod;
	}

	public void setProd(List<String> prod) {
		this.prod = prod;
	}



}
