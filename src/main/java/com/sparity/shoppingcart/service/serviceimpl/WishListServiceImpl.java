package com.sparity.shoppingcart.service.serviceimpl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.ProductDAO;
import com.sparity.shoppingcart.dao.WishListDAO;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.Product;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProductTypeModel;
import com.sparity.shoppingcart.model.WhishListsModel;
import com.sparity.shoppingcart.service.ProductService;
import com.sparity.shoppingcart.service.WishListService;

@Service("wishListService")
public class WishListServiceImpl extends BaseServiceImpl implements
		WishListService {
	private final Logger logger = Logger.getLogger(WishListServiceImpl.class);

	@Resource(name = "wishListDAO")
	private WishListDAO wishListDAO;

	
	@Override
	public List<WhishListsModel> wishList(Long userId) {
		return wishListDAO.wishList(userId);
	}

	public WishListDAO getWishListDAO() {
		return wishListDAO;
	}

	public void setWishListDAO(WishListDAO wishListDAO) {
		this.wishListDAO = wishListDAO;
	}

	@Override
	public void deleteWishListItem(long wid) {
		wishListDAO.deleteWishListItem(wid);
		
	}

	

	
	

	

	
}
