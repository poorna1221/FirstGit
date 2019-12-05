package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.UserAlbumDAO;
import com.sparity.shoppingcart.model.UserAlbumModel;

@Repository("userAlbumDAO")
public class UserAlbumDAOImpl  extends BaseDAOImpl implements UserAlbumDAO{
	
	private static final Logger logger = Logger.getLogger(UserAlbumDAOImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbumModel> findAllImages(Long albumId, Long albumTypeId) {
		String queryString="from UserAlbumModel as uam where uam.albumModel.albumId=:albumId and uam.albumTypeModel.albumId=:albumTypeId";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"albumId","albumTypeId"}, new Object[]{albumId,albumTypeId});
	}

}
