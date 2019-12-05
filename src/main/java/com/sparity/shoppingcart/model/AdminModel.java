package com.sparity.shoppingcart.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="admin")
public class AdminModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id",unique=true, precision=10)
	private Long adminId;
	
	@Column(name="emailid", unique=true, length=55)
	private String emailId;


	@Column(name="password", length=20)
	private String password;
	
	@Column(name="mobilenumber", length=20)
	private String mobilenumber;
	

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	
	
	
	
	
}
	