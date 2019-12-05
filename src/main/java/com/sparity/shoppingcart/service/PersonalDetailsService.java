package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;

public interface PersonalDetailsService extends BaseService {

    public 	void  save(ShippingAddressModel shipmodel);

	public UserModel exist(String emailid);

	public void update(UserModel us);

	public ShippingAddressModel finding(Long userid);

	 void updating(ShippingAddressModel shipmodel);

}
