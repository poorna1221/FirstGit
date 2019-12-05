package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.PersonalDetailsDAO;
import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;



@Repository("personalDetailsDAO")
public class PersonalDetailsDAOImpl extends BaseDAOImpl implements PersonalDetailsDAO{

	private static final Logger logger = Logger.getLogger(PersonalDetailsDAOImpl.class.getName());
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public UserModel exist(String emailid) {
		
		
		
		String queryString="from UserModel as um  where  um.userEmailId =:emailid";
		
		List<UserModel>  umlist=getHibernateTemplate().findByNamedParam(queryString, "emailid", emailid);
		if(logger.isInfoEnabled())
			logger.info("PersonalDetailsDAO Impl method in ......"+umlist.size());
		if(umlist.size()==0)
		{	
		return null;
		}
		else{
			return umlist.get(0);
		
	}

}

	@Override
	public void update(UserModel us) {
		getHibernateTemplate().update(us);
		logger.info("----");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ShippingAddressModel finding(Long userid) {
		
		String queryString="from ShippingAddressModel as shm where shm.user.userId=:userid";
		
		
		List<ShippingAddressModel> shlist= getHibernateTemplate().findByNamedParam(queryString, "userid", userid);
		
		         logger.info("ShipSize is"+ shlist.size());
		
		     if(shlist.size()==0){
		    	
		    	 return null;
		     }    
		     else{
		    	 
		    	 return shlist.get(0);
		     }   

	}

	@Override
	public void updatePersonalDetails(ShippingAddressModel shipmodel) {
	      getHibernateTemplate().update(shipmodel);
		  logger.info(" PERSONAL DETAILS UPDATED");
	}

}
