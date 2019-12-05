package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.UserAlbumModel;

public interface UserAlbumService extends BaseService {

	void save(UserAlbumModel useralbumobjec);

	List<UserAlbumModel> findAllImages(Long albumId,Long albumTypeId);



	

	
	
	
	

}
