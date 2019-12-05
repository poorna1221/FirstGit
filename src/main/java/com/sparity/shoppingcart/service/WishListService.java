package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.WhishListsModel;

public interface WishListService extends BaseService {
	
	List<WhishListsModel> wishList(Long userId);
	void deleteWishListItem(long wid);
		 
}
