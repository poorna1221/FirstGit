package com.sparity.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;
	@Entity
	@Table(name="applicationUsers")
	public class ApplcationUsersModel extends BaseModel {
		
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue
		@Column(name = "user_id",unique=true, nullable=false, precision=10)
		private Long ProjectID;
		
		@Column(name="employeeId",unique=true, nullable=false)
		private String EmpId;
		
		@Column(name="TypeOfUser")
		private String TypeOfUser;

		
		
		
		
		
		
		
		
		
		public Long getProjectID() {
			return ProjectID;
		}

		public void setProjectID(Long projectID) {
			ProjectID = projectID;
		}

		public String getEmpId() {
			return EmpId;
		}

		public void setEmpId(String empId) {
			EmpId = empId;
		}

		public String getTypeOfUser() {
			return TypeOfUser;
		}

		public void setTypeOfUser(String typeOfUser) {
			TypeOfUser = typeOfUser;
		}

		
		
	}
	
