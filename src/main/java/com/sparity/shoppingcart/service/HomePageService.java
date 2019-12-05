package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.CategoryModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;

public interface HomePageService extends BaseService{
	
	List<BrandModel> getBrandList();
	List<CategoryModel> getCategoryList();
	List<ProductTypeModel> getProdTypeList();
	List<ProductModel> getProductsModel();
	List<ProductModel> getImageSpec(long prodId);
	List<ProductModel> getCameraList(long catId);
	List<AlbumTypeModel> getAlbumTypeList();
	

}
