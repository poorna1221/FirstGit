package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.ProductSpecDAO;
import com.sparity.shoppingcart.dao.UserAlbumDAO;
import com.sparity.shoppingcart.model.UserAlbumModel;
import com.sparity.shoppingcart.service.UserAlbumService;


@Service("userAlbumService")
public class UserAlbumServiceImpl extends BaseServiceImpl implements UserAlbumService {
	
	private final Logger logger = Logger.getLogger(UserAlbumServiceImpl.class);
	
	@Resource(name = "userAlbumDAO")
	private UserAlbumDAO userAlbumDao;

	@Override
	public void save(UserAlbumModel useralbumobjec) {
		saveObject(useralbumobjec);
		
	}

	

	@Override
	public List<UserAlbumModel> findAllImages(Long albumId, Long albumTypeId) {
		// TODO Auto-generated method stub
		return userAlbumDao.findAllImages(albumId,albumTypeId);
	}



	


	

	

}
