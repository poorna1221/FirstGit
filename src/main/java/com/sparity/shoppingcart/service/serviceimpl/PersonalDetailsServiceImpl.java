package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.PersonalDetailsDAO;
import com.sparity.shoppingcart.dao.UserAccountDAO;
import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.service.PersonalDetailsService;


@Service("personalDetailsService")
public class PersonalDetailsServiceImpl extends BaseServiceImpl implements PersonalDetailsService {

	
private final Logger logger = Logger.getLogger(PersonalDetailsServiceImpl.class);
		
				@Resource(name = "personalDetailsDAO")
				private PersonalDetailsDAO personalDetailsDAO;




       @Override
		public void save(ShippingAddressModel shipmodel) {
		
			if(logger.isDebugEnabled())
				logger.info("inside save of UserAccountServiceeImpl");
				saveObject(shipmodel);
		}


       @Override
		public UserModel exist(String emailid) {
			
			return personalDetailsDAO.exist(emailid);
		}


       
	

		@Override
		public void update(UserModel us) {
			personalDetailsDAO.update(us);
			
		}


		@Override
		public ShippingAddressModel finding(Long userid) {
			return personalDetailsDAO.finding(userid);
			
			
		}


		@Override
		public void updating(ShippingAddressModel shipmodel) {
			 personalDetailsDAO.updatePersonalDetails(shipmodel);
		}

		
		
		
		public PersonalDetailsDAO getPersonalDetailsDAO() {
			return personalDetailsDAO;
		}


		public void setPersonalDetailsDAO(PersonalDetailsDAO personalDetailsDAO) {
			this.personalDetailsDAO = personalDetailsDAO;
		}

		
		
		
}
