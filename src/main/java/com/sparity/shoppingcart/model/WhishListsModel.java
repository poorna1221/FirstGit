package com.sparity.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="wish_lists")
public class WhishListsModel extends BaseModel {

	private static final long serialVersionUID = -6530645350201112573L;
	@Id
	@GeneratedValue
	@Column(name = "wishlist_id",unique=true, nullable=false, precision=10)
	private Long whishListId;
    
	@ManyToOne
	@JoinColumn(name="prod_id",nullable=false)
	private ProductModel productModel;
	
	@OneToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserModel user;
	
	@OneToOne(mappedBy="whishlists",targetEntity = CartUserModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private CartUserModel userAccount;
	
	@Column(name = "quantity",nullable=false)
	private Integer quantity;
	
	@Column(name = "color",nullable=false)
	private String color;
	
	
	public Long getWhishListId() {
		return whishListId;
	}

	public void setWhishListId(Long whishListId) {
		this.whishListId = whishListId;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public CartUserModel getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(CartUserModel userAccount) {
		this.userAccount = userAccount;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
