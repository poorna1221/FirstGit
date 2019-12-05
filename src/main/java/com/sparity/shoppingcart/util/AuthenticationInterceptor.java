package com.sparity.shoppingcart.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sparity.shoppingcart.model.UserModel;

public class AuthenticationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 649644925979185552L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {		
		final ActionContext context = invocation.getInvocationContext();
		
		Map session = context.getSession();
		
		UserModel account = (UserModel) session.get("user");

		if (account == null) { 
			return "user-login";
		}
		
		return invocation.invoke();
	}

}
