package com.sparity.shoppingcart.view;

public class UserAccountViewBean {

	
	private String userEmailId;
	
	private String userPasword;
	
	private String userConformPassword;
	
	private String mobileNumber;
	
	private String NewPassword;
	

	public UserAccountViewBean(){
		super();
		
	}
		


	public String getNewPassword() {
		return NewPassword;
	}

	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}

	public String getUserEmailId() {
		return userEmailId;
	}


	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}


	public String getUserConformPassword() {
		return userConformPassword;
	}


	public void setUserConformPassword(String userConformPassword) {
		this.userConformPassword = userConformPassword;
	}


	

	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getUserPasword() {
		return userPasword;
	}


	public void setUserPasword(String userPasword) {
		this.userPasword = userPasword;
	}

	
}
