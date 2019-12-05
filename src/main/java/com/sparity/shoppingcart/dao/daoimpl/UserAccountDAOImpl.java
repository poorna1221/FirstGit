package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.UserAccountDAO;
import com.sparity.shoppingcart.model.UserModel;

@Repository("userAccountDAO")
public class UserAccountDAOImpl extends BaseDAOImpl implements UserAccountDAO{

	private static final Logger logger = Logger.getLogger(UserAccountDAOImpl.class.getName());

	
	@SuppressWarnings("unchecked")
	@Override
	public UserModel check(String email, String pass) {
		String queryString ="from UserModel as um  where  um.userEmailId =:email and um.userPassword =:pass";
		List<UserModel> users = getHibernateTemplate().findByNamedParam(queryString, new String[]{"email","pass"}, new Object[]{email,pass});
		if(logger.isInfoEnabled())
			logger.info("userListsize "+users.size());
		if(users!=null&&users.size()>0){
			return users.get(0);
		} else{
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserModel NewUserCheck(String email) {
		String queryString ="from UserModel as um  where  um.userEmailId =:email";
		List<UserModel> newuser=getHibernateTemplate().findByNamedParam(queryString, "email", email);
		if(logger.isInfoEnabled())
			logger.info("userListsize "+newuser.size());
		if(newuser.size()==0)
		{	
		return null;
		}
		else{
			return newuser.get(0);
			
		}
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public UserModel forgotPassword(String email) {
		logger.info(" User EMAIL ID IS "+email);
		String queryString="from UserModel as um  where  um.userEmailId =:email";
		List<UserModel> forgtpwd=getHibernateTemplate().findByNamedParam(queryString, "email", email);
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
	public UserModel changePassword(UserModel us)
	{
		getHibernateTemplate().update(us);
		logger.info("----");
		return us;
	   }
	}

	
