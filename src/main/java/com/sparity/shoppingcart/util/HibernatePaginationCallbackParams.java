package com.sparity.shoppingcart.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.sparity.shoppingcart.model.ProductModel;

public class HibernatePaginationCallbackParams implements HibernateCallback<List<ProductModel>> {
	private int firstResult;
	private int maxResult;
	private String queryString;
	String[] paramNames; 
    Object[] values;

	
	public HibernatePaginationCallbackParams(String queryString,int firstResult,int maxResult,String[] paramNames, Object[] values
){
		this.firstResult = firstResult;
		this.maxResult = maxResult;
		this.queryString = queryString;
		this.paramNames = paramNames;
	    this.values = values;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> doInHibernate(Session session) throws HibernateException,
			SQLException {
		Query query = session.createQuery(queryString);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        for (int c=0; c<paramNames.length; c++) {
            query.setParameter(paramNames[c], values[c]);
        }

        return query.list();
	}

}
