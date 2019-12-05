package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.ProductSpecDAO;
import com.sparity.shoppingcart.dao.ProductSpecMappingDAO;
import com.sparity.shoppingcart.model.ProductSpecMappingModel;
import com.sparity.shoppingcart.service.ProductSpecMappingService;


@Service("productSpecMappingService")
public class ProductSpecMappingServiceImpl extends BaseServiceImpl implements ProductSpecMappingService {
	
	
	private final Logger logger = Logger.getLogger(ProductSpecMappingServiceImpl.class);
	
	
	
	@Resource(name = "productSpecMappingDAO")
	private ProductSpecMappingDAO productSpecMappingDao;



	public ProductSpecMappingDAO getProductSpecMappingDao() {
		return productSpecMappingDao;
	}



	public void setProductSpecMappingDao(ProductSpecMappingDAO productSpecMappingDao) {
		this.productSpecMappingDao = productSpecMappingDao;
	}



/*	@Override
	public List<ProductSpecMappingModel> findMappingsBySpecId(Long mapid) {
	return productSpecMappingDao.findMappingsBySpecId(mapid);
	}
	*/
	
	
	

}
