package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.AlbumDAO;
import com.sparity.shoppingcart.dao.ProductSpecDAO;
import com.sparity.shoppingcart.model.AlbumModel;
import com.sparity.shoppingcart.service.AlbumService;

@Service("albumService")
public class AlbumServiceImpl  extends BaseServiceImpl implements AlbumService{
	
	private final Logger logger = Logger.getLogger(AlbumServiceImpl.class);
	
	@Resource(name = "albumDAO")
	private AlbumDAO albumDao;

	@Override
	public void insertImageIntoAlbum(AlbumModel albumObject) {
		saveObject(albumObject);
		
	}

	@Override
	public List<AlbumModel> findAlbumModelData(Long userId) {
		return albumDao.findAlbumModelData(userId);
	}

	@Override
	public void save(AlbumModel amo) {
		saveObject(amo);
		
	}





}
