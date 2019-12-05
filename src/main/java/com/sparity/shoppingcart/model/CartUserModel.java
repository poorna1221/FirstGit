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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="shoppingcart_user")
public class CartUserModel extends BaseModel {

	private static final long serialVersionUID = 683099735368810123L;
	@Id
	@GeneratedValue
	@Column(name = "shopping_id",unique=true, nullable=false, precision=10)
	private Long cartId;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="album_id",nullable=false,updatable=true,insertable=true)
	private AlbumModel album;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wishlist_id",nullable=false,updatable=true,insertable=true)
	private WhishListsModel whishlists;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id",nullable=false,updatable=true,insertable=true)
	private OrderDetailModel orderDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id",nullable=false,updatable=true,insertable=true)
	private ShoppingCartModel shoppingCart;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipping_id",nullable=false,updatable=true,insertable=true)
	private ShippingAddressModel shippingAddress ;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",nullable=false)
	private UserModel user;
	
	public AlbumModel getAlbum() {
		return album;
	}
	public void setAlbum(AlbumModel album) {
		this.album = album;
	}
	public WhishListsModel getWhishlists() {
		return whishlists;
	}
	public void setWhishlists(WhishListsModel whishlists) {
		this.whishlists = whishlists;
	}
	
	public OrderDetailModel getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetailModel orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public ShoppingCartModel getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartModel shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public ShippingAddressModel getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddressModel shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	

}
