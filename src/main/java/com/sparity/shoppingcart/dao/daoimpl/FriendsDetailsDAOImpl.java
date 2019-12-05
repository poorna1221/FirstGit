package com.sparity.shoppingcart.dao.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.FriendsDetailsDAO;
import com.sparity.shoppingcart.service.serviceimpl.FriendsDetailsServiceImpl;

@Repository("friendsDetails")
public class FriendsDetailsDAOImpl  extends BaseDAOImpl implements FriendsDetailsDAO{
	private final Logger logger = Logger.getLogger(FriendsDetailsDAOImpl.class);
}
