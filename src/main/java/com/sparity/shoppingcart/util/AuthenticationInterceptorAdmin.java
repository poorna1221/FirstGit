package com.sparity.shoppingcart.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Context;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sparity.shoppingcart.model.AdminModel;

public class AuthenticationInterceptorAdmin extends AbstractInterceptor {

	
	private static final long serialVersionUID = 649644925979185552L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
   
		final  ActionContext  context =invocation.getInvocationContext();
		
		
		Map session=context.getSession();
		
		
		  AdminModel admin= (AdminModel) session.get("admin");
		  
		  if(admin==null)
		  {
			  return "admin-login";
		  }
return invocation.invoke();
	}

}
