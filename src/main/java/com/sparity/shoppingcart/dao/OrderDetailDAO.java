package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.model.OrderDetailModel;
import com.sparity.shoppingcart.model.ShoppingCartModel;
import com.sparity.shoppingcart.model.TransactionModel;

public interface OrderDetailDAO  {

	List<OrderDetailModel> orderHistory(Long userId);

	
	
	 
		
	
}
