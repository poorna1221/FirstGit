package com.sparity.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="friendsuser")
public class FriendsLoginModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "user_id",unique=true, precision=10)
	private Long userId;
	
	@Column(name="user_emailid", unique=true, length=55)
	private String userEmailId;
	
	@Column(name="user_password", length=20)
	private String userPassword;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
