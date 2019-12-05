package com.sparity.shoppingcart.service.serviceimpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.FriendsDetailsDAO;
import com.sparity.shoppingcart.dao.UserAccountDAO;
import com.sparity.shoppingcart.service.FriendsDetailsService;
@Service("friendsDetailsService")
public class FriendsDetailsServiceImpl  extends BaseServiceImpl implements FriendsDetailsService{
	
	private final Logger logger = Logger.getLogger(FriendsDetailsServiceImpl.class);
	@Resource(name = "friendsDetails")
	private FriendsDetailsDAO friendsDetailsDAO;
}
