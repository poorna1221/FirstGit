package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.OrderDetailDAO;
import com.sparity.shoppingcart.model.OrderDetailModel;
import com.sparity.shoppingcart.model.ShoppingCartModel;
import com.sparity.shoppingcart.model.TransactionModel;



@Repository("orderDetailDAO")
public class OrderDetailDAOImpl extends BaseDAOImpl implements OrderDetailDAO{

	private static final Logger logger = Logger.getLogger(OrderDetailDAOImpl.class.getName());

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetailModel> orderHistory(Long userId) {
	
		if(logger.isInfoEnabled())
			logger.info("shoppingcartList method in ");
		String queryString = "from OrderDetailModel as odm where odm.shoppingCart.user.userId=:userId ";
		//logger.info("--------------"+queryString.trim());
		return getHibernateTemplate().findByNamedParam(queryString, "userId", userId);
		
	}
}
