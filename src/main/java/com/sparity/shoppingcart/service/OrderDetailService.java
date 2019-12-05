package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.OrderDetailModel;
import com.sparity.shoppingcart.model.ShoppingCartModel;
import com.sparity.shoppingcart.model.TransactionModel;

public interface OrderDetailService extends BaseService{

	List<OrderDetailModel> orderHistory(Long userId);

	
	
	
		
		
	

}
