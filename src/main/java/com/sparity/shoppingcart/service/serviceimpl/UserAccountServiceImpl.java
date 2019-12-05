package com.sparity.shoppingcart.service.serviceimpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.UserAccountDAO;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.service.UserAccountService;


@Service("userAccountService")
public class UserAccountServiceImpl extends BaseServiceImpl implements UserAccountService{

	
	private final Logger logger = Logger.getLogger(UserAccountServiceImpl.class);
	
	@Resource(name = "userAccountDAO")
	private UserAccountDAO userAccountDAO;
	
	
	
	@Override
	public void save(UserModel userModel) {
		
		if(logger.isDebugEnabled())
			logger.info("inside save of UserAccountServiceeImpl");
			saveObject(userModel);
		
		
	}

	public UserAccountDAO getUserAccountDAO() {
		return userAccountDAO;
	}

	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	@Override
	public UserModel check(String email, String pass) {
		return userAccountDAO.check(email,pass);
		
		
	}

	@Override
	public UserModel NewUserCheck(String emailid) {
		
		return userAccountDAO.NewUserCheck(emailid);
	}

	@Override
	public UserModel forgotPassword(String email) {
		
		return userAccountDAO.forgotPassword(email);
	}

	@Override
	public UserModel changePassword(UserModel us) {
		
		return userAccountDAO.changePassword(us);
	}

	/*@Override
	public UserModel updatePassword(String email, String newpassword) {
		
		return userAccountDAO.updatePassword(email,newpassword);
	}
*/
	
	
	
	
	
}
