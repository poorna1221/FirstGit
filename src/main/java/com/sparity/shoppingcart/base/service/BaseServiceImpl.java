package com.sparity.shoppingcart.base.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.dao.BaseDAO;

/**
 *  
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService {

	private final Logger log = Logger.getLogger(BaseServiceImpl.class);
	@Resource(name = "baseDAO")
	private BaseDAO baseDAO ;
    public BaseServiceImpl(){
    	
    }
	public boolean deleteObject(Object object) {
		return baseDAO.deleteObject(object);
	}
	
	public boolean updateObject(Object object) {
		return baseDAO.updateObject(object);
	}

	public Object getObjectByID(Class object, Long primaryKey) {
		return baseDAO.getObjectByID(object, primaryKey);
	}

	public boolean saveObject(Object object) {
		if(log.isInfoEnabled())
		log.info("inside saveObject of BaseServiceImpl");
		return baseDAO.saveObject(object);
	}

	/**
	 * @return the baseDAO
	 */
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	/**
	 * @param baseDAO
	 *            the baseDAO to set
	 */
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
}
