package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.HomePageDAO;
import com.sparity.shoppingcart.dao.ProductDAO;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.CategoryModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.service.HomePageService;

@Service("homePageService")
public class HomePageServiceImpl extends BaseServiceImpl implements HomePageService {
	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Resource(name="homePageDao")
	private HomePageDAO homePageDao;
	
	@Override
	public List<BrandModel> getBrandList() {
		return getHomePageDao().getBrandList();
	}

	@Override
	public List<CategoryModel> getCategoryList() {
		return getHomePageDao().getCategoryList();
	}

	@Override
	public List<ProductTypeModel> getProdTypeList() {
		return getHomePageDao().getProdTypeList();
	}

	public HomePageDAO getHomePageDao() {
		return homePageDao;
	}

	public void setHomePageDao(HomePageDAO homePageDao) {
		this.homePageDao = homePageDao;
	}

	@Override
	public List<ProductModel> getProductsModel() {
		
		return homePageDao.getProductsModel();
	}

	@Override
	public List<ProductModel> getImageSpec(long prodId) {
		
		return homePageDao.getImageSpec(prodId);
	}

	public List<ProductModel> getCameraList(long catId){
		return homePageDao.getCameraList(catId);
	}

	@Override
	public List<AlbumTypeModel> getAlbumTypeList() {
		// TODO Auto-generated method stub
		return homePageDao.getAlbumTypeList();
	}
	
			
}
