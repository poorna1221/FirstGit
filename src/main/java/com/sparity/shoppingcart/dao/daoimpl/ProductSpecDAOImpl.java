package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.ProductSpecDAO;
import com.sparity.shoppingcart.model.ProductSpecMappingModel;
import com.sparity.shoppingcart.model.ProductSpecModel;



@Repository("productSpecDAO")
public class ProductSpecDAOImpl  extends BaseDAOImpl implements ProductSpecDAO{
	
	private static final Logger logger = Logger.getLogger(ProductSpecDAOImpl.class.getName());
	
	
	/*@Override
	public ProductSpecModel findProductSpecByProductId(Long produ) {
		
	
		
		logger.info("inside product Specific DAO IMPL"+produ);
		
		 Query query =getSession().createQuery("from ProductSpecModel as pm  where  pm.product.productId=:produ");
	       query.setParameter("produ",produ);
	        logger.info("____________________"+query.uniqueResult());
		String queryString ="from ProductSpecModel as pm  where  pm.product.productId=:produ";
		List<ProductSpecModel> prodSpecs = getHibernateTemplate().findByNamedParam(queryString, "produ", produ);
		if(prodSpecs!=null){
			return prodSpecs.get(0);
		} else {
			
			return null;
		}
	      
	
	}*/


/*	@Override
	public List<ProductSpecModel> findProductSpecByProductId(long produ) {
		String queryString ="from ProductSpecModel as pm  where  pm.product.productId=:produ";
		List<ProductSpecModel> prodMapSpec = getHibernateTemplate().findByNamedParam(queryString, "produ", produ);
	    return prodMapSpec;
	}
*/
	

}
