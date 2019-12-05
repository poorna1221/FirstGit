package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.ProductDAO;
import com.sparity.shoppingcart.dao.ProductSpecDAO;
import com.sparity.shoppingcart.model.ProductSpecModel;
import com.sparity.shoppingcart.service.ProductSpecService;



@Service("productSpecService")
public class ProductSpecServiceImpl  extends BaseServiceImpl implements ProductSpecService{
	
	private final Logger logger = Logger.getLogger(ProductSpecServiceImpl.class);
	
	@Resource(name = "productSpecDAO")
	private ProductSpecDAO productSpecDao;

	public ProductSpecDAO getProductSpecDao() {
		return productSpecDao;
	}

	public void setProductSpecDao(ProductSpecDAO productSpecDao) {
		this.productSpecDao = productSpecDao;
	}

/*	@Override
	public List<ProductSpecModel> findProductSpecByProductId(long produ) {
		return productSpecDao.findProductSpecByProductId(produ);
	}*/

/*	@Override
	public ProductSpecModel findProductSpecByProductId(Long produ) {
		return productSpecDao.findProductSpecByProductId(produ);
	}*/
	
	
	
	

}
