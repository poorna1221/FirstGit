package com.sparity.shoppingcart.base.dao;

public interface BaseDAO {

	public Object getObjectByID(Class object, Long primaryKey);

	public boolean saveObject(Object object);

	public boolean deleteObject(Object object);
	
	public boolean updateObject(Object object);

}