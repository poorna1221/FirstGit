package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.model.UserAlbumModel;

public interface UserAlbumDAO  extends BaseDAO{

	List<UserAlbumModel> findAllImages(Long albumId,Long albumTypeId);





}
