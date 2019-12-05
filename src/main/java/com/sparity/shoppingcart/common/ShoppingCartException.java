package com.sparity.shoppingcart.common;

public class ShoppingCartException extends Exception {
	
	private static final long serialVersionUID = 8349675202431952805L;

	public ShoppingCartException() {
	        super();
	    }

	    public ShoppingCartException(String errorMsg) {
	        super(errorMsg);
	    }

	    public ShoppingCartException(String errorMsg, Throwable cause) {
	        super(errorMsg, cause);
	    }

	    public ShoppingCartException(Throwable t) {
	        super(t);
	    }

}
