package com.sparity.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="shopping_cart")
public class ShoppingCartModel extends BaseModel {

	private static final long serialVersionUID = 9023157775154015369L;
	@Id
	@GeneratedValue
	@Column(name = "cart_id",unique=true, nullable=false, precision=10)
	private Long cartId;
	
	@OneToOne(mappedBy="shoppingCart",targetEntity = CartUserModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private CartUserModel userAccount;
    
	@ManyToOne
	@JoinColumn(name="prod_id",nullable=false)
	private ProductModel product;
	
	@OneToMany(mappedBy="shoppingCart",targetEntity = OrderDetailModel.class, fetch = FetchType.EAGER)
	private Set<OrderDetailModel> orderDetails = new HashSet<OrderDetailModel>(0);
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",nullable=false,updatable=true,insertable=true)
	private UserModel user;
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public CartUserModel getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(CartUserModel userAccount) {
		this.userAccount = userAccount;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public Set<OrderDetailModel> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailModel> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
	

}
