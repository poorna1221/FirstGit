package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.ProductModel;

public interface AdminService extends BaseService{

	

	AdminModel getadmindetials(String emailId, String password);

	AdminModel  changePassword(AdminModel admin);

	AdminModel exist(String email);

	  void update(AdminModel admin);

	AdminModel forgotPassword(String email);

	void updatequery(Long productid);
	public int getCountForCategoryProducts(Long categoryId);
	
	public List<ProductModel> getAllCategoryProds(Long categoryId,int page,int rows);
}
