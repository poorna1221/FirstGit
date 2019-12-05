package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.ProductSpecMappingDAO;
import com.sparity.shoppingcart.model.ProductSpecMappingModel;
import com.sparity.shoppingcart.model.ProductSpecModel;

@Repository("productSpecMappingDAO")
public class ProductSpecMappingDAOImpl  extends BaseDAOImpl implements ProductSpecMappingDAO{
	
	
	private static final Logger logger = Logger.getLogger(ProductSpecMappingDAOImpl.class.getName());

/*	@Override
	public List<ProductSpecMappingModel> findMappingsBySpecId(Long mapid) {
		Query query = getSession().createQuery("from ProductSpecMappingModel as psm where psm.specModel.specId="+mapid);
		return query.list();
		
		String queryString ="from ProductSpecMappingModel as psm  where  psm.specModel.specId=:mapid";
		List<ProductSpecMappingModel> prodMapSpec = getHibernateTemplate().findByNamedParam(queryString, "mapid", mapid);
	    return prodMapSpec;
	}
	*/
	

}
