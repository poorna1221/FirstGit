package com.sparity.shoppingcart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="shipping_address")
public class ShippingAddressModel extends BaseModel {

	private static final long serialVersionUID = -2983682144591220942L;
	@Id
	@GeneratedValue
	@Column(name = "shipping_id",unique=true, nullable=false, precision=10)
	private Long shippingAddId;
	
	@Column(name="first_name", length=20)
	private String firstName;
	
	@Column(name="last_name", length=20)
	private String lastName;
	
	@Column(name="address1", length=100)
	private String presentAddress;
	
	@Column(name="address2", length=100)
	private String alternateAddress;
	
	@Column(name="city", length=20)
	private String city;
	
	@Column(name="pincode", length=8)
	private Integer pincode;
	
	@Column(name="state", length=20)
	private String state;
	
	@Column(name="country", length=20)
	private String country;
	
	@Column(name="title", length=20)
	private String title;
	
	@Column(name="gender", length=8)
	private String gender;
	
	@Column(name="dateofbirth" )
	//@Temporal(TemporalType.DATE)
	private String dateOfBirth;
	
	@Column(name="telnumber", length=15 )
	private String telNumber;
	
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserModel user;
	
	
	
	public Long getShippingAddId() {
		return shippingAddId;
	}
	public void setShippingAddId(Long shippingAddId) {
		this.shippingAddId = shippingAddId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	
	public String getAlternateAddress() {
		return alternateAddress;
	}
	public void setAlternateAddress(String alternateAddress) {
		this.alternateAddress = alternateAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	

}
