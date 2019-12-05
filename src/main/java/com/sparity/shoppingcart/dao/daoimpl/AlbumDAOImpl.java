package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.AlbumDAO;
import com.sparity.shoppingcart.model.AlbumModel;

@Repository("albumDAO")
public class AlbumDAOImpl extends BaseDAOImpl implements AlbumDAO {
	
	private static final Logger logger = Logger.getLogger(AlbumDAOImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<AlbumModel> findAlbumModelData(Long userId) {
	    
		logger.info("inside album DAO Impl"+userId);
		String queryString = "from AlbumModel as am where am.userModel.userId=:userId";
		return getHibernateTemplate().findByNamedParam(queryString, "userId", userId);
	}

	
}
