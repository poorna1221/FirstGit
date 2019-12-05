package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.model.AlbumModel;

public interface AlbumDAO  extends BaseDAO{

	List<AlbumModel> findAlbumModelData(Long userId);



	

	

}
