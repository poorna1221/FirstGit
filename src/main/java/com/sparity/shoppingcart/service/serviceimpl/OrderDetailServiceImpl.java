package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.OrderDetailDAO;
import com.sparity.shoppingcart.dao.UserAccountDAO;
import com.sparity.shoppingcart.model.OrderDetailModel;
import com.sparity.shoppingcart.model.ShoppingCartModel;
import com.sparity.shoppingcart.model.TransactionModel;
import com.sparity.shoppingcart.service.OrderDetailService;



@Service("orderDetailService")
public class OrderDetailServiceImpl extends BaseServiceImpl implements OrderDetailService{

	
    private final Logger logger = Logger.getLogger(OrderDetailServiceImpl.class);
	
	@Resource(name = "orderDetailDAO")
	private OrderDetailDAO orderDetailDAO;
	
	
	
	


	
	public OrderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

	@Override
	public List<OrderDetailModel> orderHistory(Long userId) {
		
		return orderDetailDAO.orderHistory(userId);
	}

	
	

	
	
	
	
}
