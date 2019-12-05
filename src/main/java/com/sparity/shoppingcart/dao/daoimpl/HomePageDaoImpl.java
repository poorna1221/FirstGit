package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.HomePageDAO;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.CategoryModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;

@Repository("homePageDao")
public class HomePageDaoImpl extends BaseDAOImpl implements HomePageDAO {
	private static final Logger logger = Logger.getLogger(HomePageDaoImpl.class
			.getName());
	private final String className = "MainMenuDaoImpl";

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandModel> getBrandList() {
		if(logger.isInfoEnabled())
			logger.info("brandList method in "+className);
		String queryString = "from BrandModel as bm";
		return getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryModel> getCategoryList() {
		if(logger.isInfoEnabled())
			logger.info("categoryList method in "+className);
		String queryString = "from CategoryModel as cm";
		return getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTypeModel> getProdTypeList() {
		if(logger.isInfoEnabled())
			logger.info("ProductTypeModel method in "+className);
		String queryString = "from ProductTypeModel as pm";
		return getHibernateTemplate().find(queryString);
	}

	@Override
	public List<ProductModel> getProductsModel() {
		String queryString = "from ProductModel as pm";
		return getHibernateTemplate().find(queryString);
		
	}
	@Override
	public List<ProductModel> getImageSpec(long prodId){
		logger.info("imageId is "+prodId);
		String queryString ="from ProductModel as pm where pm.productId=:pId";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"pId"}, new Object[]{prodId});
			
		
	}
	
	public List<ProductModel> getCameraList(long catId){
		logger.info("catId isssss "+catId);	
		String queryString="from ProductModel as pm where pm.prodTypeModel.categoryModel.categoryId=:catId ";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"catId"}, new Object[]{catId});
	}

	@Override
	public List<AlbumTypeModel> getAlbumTypeList() {
		String queryString = "from AlbumTypeModel as albumType";
		return getHibernateTemplate().find(queryString);
	}
	

}
