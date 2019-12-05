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
@Table(name="order_details")
public class OrderDetailModel extends BaseModel {

	private static final long serialVersionUID = 85753765465640228L;
	@Id
	@GeneratedValue
	@Column(name = "order_id",unique=true, nullable=false, precision=10)
	private Long orderId;
	
	
	@Column(name = "estimated_delivery_days")
	private String deliveryDays;
	
	@Column(name = "shipping_charges")
	private Double shipCharges;
	

	@Column(name = "total_amount")
	private Double totalAmount;
	
	@ManyToOne
	@JoinColumn(name="cart_id",nullable=false)
	private ShoppingCartModel shoppingCart;
	
	@OneToOne(mappedBy="orderDetails",targetEntity = CartUserModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private CartUserModel userAccount;
	
	@OneToOne(mappedBy="orderDetails",targetEntity = TransactionModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private TransactionModel transaction;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public ShoppingCartModel getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartModel shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public CartUserModel getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(CartUserModel userAccount) {
		this.userAccount = userAccount;
	}

	public TransactionModel getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionModel transaction) {
		this.transaction = transaction;
	}

	public String getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(String deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public Double getShipCharges() {
		return shipCharges;
	}

	public void setShipCharges(Double shipCharges) {
		this.shipCharges = shipCharges;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
