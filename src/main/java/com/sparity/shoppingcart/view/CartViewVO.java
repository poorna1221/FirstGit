package com.sparity.shoppingcart.view;

import java.io.Serializable;


public class CartViewVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long prodId;
	private String prodDescription;
	private int quantity;
	private Double price;
	private String imagePath;
	private Double totalPrice;
	private String selectedColor;
	
	
	

	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getSelectedColor() {
		return selectedColor;
	}
	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}
	
		
	
}
