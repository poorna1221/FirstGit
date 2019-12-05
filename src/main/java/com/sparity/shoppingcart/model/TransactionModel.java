package com.sparity.shoppingcart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="transaction")
public class TransactionModel extends BaseModel {

	private static final long serialVersionUID = 1592569095381937297L;
	@Id
	@GeneratedValue
	@Column(name = "tran_id",unique=true, nullable=false, precision=10)
	private Long transactionId;
	
	@Column(name="tran_date")
	private Date transactionDate;
	
	@Column(name="amount", precision=6, scale=2)
	private Double amount;
	
	@Column(name="quantity", length=10)
	private Integer quantity;
	
	@Column(name="status")
	//@Type(type="true_false")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="order_id",nullable=false)
	private OrderDetailModel orderDetails;
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderDetailModel getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetailModel orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

}
