package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.AlbumModel;

public interface AlbumService  extends BaseService{

	void insertImageIntoAlbum(AlbumModel albumObject);

	List<AlbumModel> findAlbumModelData(Long userId);

	void save(AlbumModel amo);





}
