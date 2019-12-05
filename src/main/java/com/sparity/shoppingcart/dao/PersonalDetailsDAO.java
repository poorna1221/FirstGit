package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;

public interface PersonalDetailsDAO {

	public UserModel exist(String emailid);

	public void update(UserModel us);

	public ShippingAddressModel finding(Long userid);

	public void updatePersonalDetails(ShippingAddressModel shipmodel);

	

	

}
