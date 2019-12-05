package com.sparity.shoppingcart.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class HibernatePaginationCallback implements HibernateCallback<List<Object>> {
	private int firstResult;
	private int maxResult;
	private String queryString;
	
	public HibernatePaginationCallback(String queryString,int firstResult,int maxResult){
		this.firstResult = firstResult;
		this.maxResult = maxResult;
		this.queryString = queryString;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> doInHibernate(Session session) throws HibernateException,
			SQLException {
		Query query = session.createQuery(queryString);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        return query.list();
	}

}
