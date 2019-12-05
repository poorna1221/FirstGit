package com.sparity.shoppingcart.view;

public class ProductViewBean {

	private Long id;

	private String code;

	private String name;

	private String desc;

	private double price;

	public ProductViewBean() {
		super();
	}
	public void validate(){
		
		if (code.length() == 0 ){
		

		//	addFieldError( "ProductViewBean.code", "code name is required." );
			
		}
		
	/*	if ( personBean.getFirstName().length() == 0 ){	

			addFieldError( "personBean.firstName", "First name is required." );
			
		}
		if ( personBean.getFirstName().length() == 0 ){	

			addFieldError( "personBean.firstName", "First name is required." );
			
		}
		if ( personBean.getFirstName().length() == 0 ){	

			addFieldError( "personBean.firstName", "First name is required." );
			
		}*/
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
