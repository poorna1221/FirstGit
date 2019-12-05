package com.sparity.shoppingcart.base.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware,SessionAware {
	
	private static final long serialVersionUID = 5236674653099025637L;
	private Map<String,Object>  session;
	private HttpServletRequest  request;
	private HttpServletResponse response;
	
   

	
	public Object getServiceBean(String serviceObj) {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
		return context.getBean(serviceObj);
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		setResponse(response);
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		setRequest(request);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		 this.session = session;
	}

	/*public Map<String, Object> getServletSession() {
		return servletSession;
	}

	public void setServletSession(Map<String, Object> servletSession) {
		this.servletSession = servletSession;
	}*/

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	 public Map<String, Object> getSession() {
         return session;
    }
}
