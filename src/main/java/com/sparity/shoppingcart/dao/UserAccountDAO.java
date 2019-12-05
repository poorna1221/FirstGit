package com.sparity.shoppingcart.dao;

import com.sparity.shoppingcart.model.UserModel;

public interface UserAccountDAO {

	UserModel check(String email, String pass);

	UserModel NewUserCheck(String emailid);

	UserModel forgotPassword(String email);

	UserModel changePassword(UserModel us);

	//UserModel updatePassword(String email, String newpassword);

	
	



	

	

	

}
