package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.model.WhishListsModel;


/**
 * 
 */

public interface WishListDAO extends BaseDAO {

	List<WhishListsModel> wishList(Long userId);
	void deleteWishListItem(long wid);

}
