package com.sparity.shoppingcart.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class HibernatePriceRangeCallback implements HibernateCallback<List<Object>> {
	private Long brandId;
	private String queryString;
	
	public HibernatePriceRangeCallback(String queryString,Long brandId){
		this.queryString = queryString;
		this.brandId = brandId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> doInHibernate(Session session) throws HibernateException,
			SQLException {
		Query query = session.createQuery(queryString);
        query.setLong("brandId", brandId);
        return query.list();
	}

}
