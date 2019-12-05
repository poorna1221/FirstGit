package com.sparity.shoppingcart.base.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED
		, isolation = Isolation.DEFAULT
		, rollbackFor = Throwable.class
		)
public interface BaseService {

	Object getObjectByID(Class object, Long primaryKey);

	boolean saveObject(Object object);

	boolean deleteObject(Object object);
	boolean updateObject(Object object);
	

}
