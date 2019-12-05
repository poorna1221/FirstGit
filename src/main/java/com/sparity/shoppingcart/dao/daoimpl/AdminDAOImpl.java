package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.AdminDAO;
import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.util.HibernatePaginationCallbackParams;



@Repository("adminDAO")
public class AdminDAOImpl extends BaseDAOImpl implements AdminDAO {

	
	private static final Logger logger = Logger.getLogger(AdminDAOImpl.class.getName());

	
	
	
	@Override
	public AdminModel getadmindetials(String emailId, String password) {
		
		
		String querystring="from AdminModel as  am where am.emailId=:emailId and am.password=:password";
		
		List<AdminModel> admin = getHibernateTemplate().findByNamedParam(querystring, new String[]{"emailId","password"}, new Object[]{emailId,password});
		
		if(logger.isInfoEnabled())
			logger.info("userListsize in AdminDAOImpl "+admin.size());
		
		if(admin!=null&&admin.size()>0){
			return admin.get(0);
		} else{
			return null;
	}

	
	
	}




	@Override
	public AdminModel changePassword(AdminModel admin) {
		
         getHibernateTemplate().update(admin);
         logger.info("----");
	   return admin;
	}




	@Override
	public AdminModel exist(String email) {
		
		
		String queryString="from AdminModel as am  where  am.emailId =:email";
		List<AdminModel> amlist= getHibernateTemplate().findByNamedParam(queryString, "email", email);
		if(logger.isInfoEnabled())
			logger.info("userListsize in AdminDAOImpl "+amlist.size());
		
		if(amlist!=null&&amlist.size()>0){
			return amlist.get(0);
		} else{
			return null;
	}

		
		
	}




	@Override
	public void update(AdminModel admin) {
		getHibernateTemplate().update(admin);
		logger.info("----");
	}




	@Override
	public AdminModel forgotPassword(String email) {
		
		String queryString="from AdminModel as am  where  am.emailId =:email";
		List<AdminModel> forgtpwd= getHibernateTemplate().findByNamedParam(queryString, "email", email);
		if(logger.isInfoEnabled())
			logger.info("userListsize "+forgtpwd.size());
		if(forgtpwd.size()==0){
			return null;
		}
		else{
			return forgtpwd.get(0);
		}
		
	}




	@Override
	public void updatequery(Long productid) {
		
		
	}	
	
	@Override
	public int getCountForCategoryProducts(Long categoryId) {
		//String queryString ="select count(prodModel.productId)from ProductModel as prodModel, ProductTypeModel as prodType where prodType.prodTypeId = :categoryId and prodModel.prodTypeModel.prodTypeId = prodType.prodTypeId";
		String queryString ="select count(prodModel.productId)from ProductModel as prodModel, ProductTypeModel as prodType where prodType.categoryModel.categoryId = :categoryId and prodModel.prodstatus = true and prodModel.prodTypeModel.prodTypeId = prodType.prodTypeId";
		List<Object> counts = getHibernateTemplate().findByNamedParam(queryString, "categoryId", categoryId);
		if(logger.isInfoEnabled())
			logger.info("getCountForCategoryProducts Count "+counts.size());
		if(counts!=null&&counts.size()>0){
			Long count = (Long)counts.get(0);
			logger.info("getCountForCategoryProducts value "+count.intValue());
			return (int)count.intValue();
		} else {
			return 0;
		}
		
	}
	
	
	@Override
	public List<ProductModel> getAllCategoryProds(Long categoryId, int page,
			int rows) {
		String queryString ="from ProductModel as pm where  pm.prodTypeModel.categoryModel.categoryId=:categoryId  and pm.prodstatus = true";
		String[] pramNames= new String[]{"categoryId"};
		Object[] pramValues= new Object[]{categoryId};
		List<ProductModel> products = getHibernateTemplate().executeFind(new HibernatePaginationCallbackParams(queryString,page,rows,pramNames,pramValues));
		if(logger.isInfoEnabled())
			logger.info("getAllCategoryProds size: "+products.size());
		if(products!=null && products.size()>0){
			return products;
		} else {
			return null;
		}
	}
	
}
