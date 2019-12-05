package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.ProductModel;

public interface AdminDAO {

	
	public AdminModel getadmindetials(String emailId, String password) ;

	public AdminModel changePassword(AdminModel admin);

	public AdminModel exist(String email);

	public void update(AdminModel admin);

	public AdminModel forgotPassword(String email);

	public void updatequery(Long productid);
		
	public int getCountForCategoryProducts(Long categoryId);	
	public List<ProductModel> getAllCategoryProds(Long categoryId,int page,int rows);

}
