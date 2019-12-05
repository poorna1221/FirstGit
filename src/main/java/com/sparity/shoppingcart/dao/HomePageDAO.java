package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.CategoryModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;

public interface HomePageDAO extends BaseDAO{
	
	List<BrandModel> getBrandList();
	List<CategoryModel> getCategoryList();
	List<ProductTypeModel> getProdTypeList();
	List<ProductModel> getProductsModel();
	
	public List<ProductModel> getCameraList(long catId);
	
	List<ProductModel> getImageSpec(long prodId);
	List<AlbumTypeModel> getAlbumTypeList();

}
