package com.sparity.shoppingcart.base.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("baseDAO")
public class BaseDAOImpl extends HibernateDaoSupport implements BaseDAO {
	private final Logger log = Logger.getLogger(BaseDAOImpl.class);
    private SessionFactory daoSessionFactory;
    
	@SuppressWarnings("unchecked")
	public Object getObjectByID(Class object, Long primaryKey) {
		return getHibernateTemplate().get(object, primaryKey);
	}

	public boolean saveObject(Object object) {
		if(log.isDebugEnabled())
		log.info(" saveObject method of BaseDAOImpl");
		getHibernateTemplate().getSessionFactory().openSession();
		try {
			getHibernateTemplate().save(object);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
		}
	}

	public boolean deleteObject(Object object) {
		if(log.isDebugEnabled())
			log.info(" deleteObject method of BaseDAOImpl");
		try {
			getHibernateTemplate().delete(object);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
		}
	}
	@Autowired
	public void setDaoSessionFactory(SessionFactory daoSessionFactory) {
		super.setSessionFactory(daoSessionFactory);
	}

	//getHibernateTemplate().update(updatePrjctDetails);
	public boolean updateObject(Object object) {
		if(log.isDebugEnabled())
			log.info(" updateObject method of BaseDAOImpl");
		try {
			getHibernateTemplate().update(object);//update(object);
			return true;
		} catch (Exception e) {
			System.out.println("false becasu of"+e);
			return false;
			
		} finally {
		}
	}
	

}
