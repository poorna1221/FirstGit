package com.sparity.shoppingcart.service;

import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.base.service.BaseService;

public interface UserAccountService extends BaseService{

	 void save(UserModel userModel);

	 UserModel check(String email, String pass);

	 UserModel NewUserCheck(String email);

	 UserModel forgotPassword(String email);

	UserModel changePassword(UserModel us);

	//UserModel updatePassword(String email, String newpassword);

	

	

	

	
	
		
		
	

}
