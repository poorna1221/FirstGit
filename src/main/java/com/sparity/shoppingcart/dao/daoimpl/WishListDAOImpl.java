package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.WishListDAO;
import com.sparity.shoppingcart.model.WhishListsModel;
@Repository("wishListDAO")
public class WishListDAOImpl extends BaseDAOImpl implements WishListDAO {

	private static final Logger logger = Logger.getLogger(WishListDAOImpl.class.getName());

	@Override
	public List<WhishListsModel> wishList(Long userId) {
		String queryString = "from WhishListsModel as wishList where wishList.user.userId=:userId";
		List<WhishListsModel> wishList = (List)getHibernateTemplate().findByNamedParam(queryString, "userId", userId);
		return wishList;
	}

	@Override
	public void deleteWishListItem(long wid) {
		logger.info("in side deleteWishListItem........");
		/*String queryString = "delete from WhishListsModel as wishList where wishList.whishListId=:wid";
		getHibernateTemplate().findByNamedParam(queryString, "wid", wid);*/
		
		WhishListsModel wishListModel = getHibernateTemplate().load(WhishListsModel.class, wid);
		getHibernateTemplate().delete(wishListModel);
		
	}
	

	


}


