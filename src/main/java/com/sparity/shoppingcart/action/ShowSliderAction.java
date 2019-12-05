package com.sparity.shoppingcart.action;

import com.sparity.shoppingcart.base.action.BaseAction;

public class ShowSliderAction extends BaseAction {
	
 private static final long serialVersionUID = -180437314620648847L;
	private String value1;
	private String value2;
	
	public String getValue1() {
		return value1;
	}


	public void setValue1(String value1) {
		this.value1 = value1;
	}


	public String getValue2() {
		return value2;
	}


	public void setValue2(String value2) {
		this.value2 = value2;
	}


	public String displayProducts(){
		System.out.println("value1 inside action class value1=========" +value1);
		System.out.println("value1 inside action class value2========" +value1);
		
		
		if(value1==null & value2==null){
		return SUCCESS;
		
	}else
		
		return INPUT;

}

}
