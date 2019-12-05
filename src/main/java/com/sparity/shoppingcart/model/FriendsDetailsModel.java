package com.sparity.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="friendsdetails")
public class FriendsDetailsModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "friendid",unique=true, precision=10)
	private Long frndid;
	
	@Column(name="name", unique=true, length=55)
	private String PersonName;
	
	@Column(name="photo", length=20)
	private String PersonPhoto;
	
	@Column(name="dateofbirth", length=10)
	private String PersonDob;
	
	@Column(name="mobile_number", length=10)
	private String mobileNumber;
	
	@Column(name="category", length=20)
	private String Category;
	
	@Column(name="careof", length=10)
	private String CareOf;

	public Long getFrndid() {
		return frndid;
	}

	public void setFrndid(Long frndid) {
		this.frndid = frndid;
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public String getPersonPhoto() {
		return PersonPhoto;
	}

	public void setPersonPhoto(String personPhoto) {
		PersonPhoto = personPhoto;
	}

	public String getPersonDob() {
		return PersonDob;
	}

	public void setPersonDob(String personDob) {
		PersonDob = personDob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getCareOf() {
		return CareOf;
	}

	public void setCareOf(String careOf) {
		CareOf = careOf;
	}

}
