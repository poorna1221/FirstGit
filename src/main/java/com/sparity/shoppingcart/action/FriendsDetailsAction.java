package com.sparity.shoppingcart.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.BrandModel;
import com.sparity.shoppingcart.model.FriendsDetailsModel;
import com.sparity.shoppingcart.service.FriendsDetailsService;
import com.sparity.shoppingcart.service.ProductService;
import com.sparity.shoppingcart.service.serviceimpl.PersonalDetailsServiceImpl;

public class FriendsDetailsAction extends BaseAction{

	private FriendsDetailsService frndsDetailsService = (FriendsDetailsService) getServiceBean("friendsDetailsService");

	private List<FriendsDetailsModel> frndDetailsModel=new ArrayList<FriendsDetailsModel>();
	
	private final Logger logger = Logger.getLogger(FriendsDetailsAction.class);
	private String AcPersonName;
	private String AcPersonPhoto;
	private String AcPersonDob;
	private String AcmobileNumber;
	private String AcCategory;
	private String AcCareOf;
	
	
	
	FriendsDetailsModel fdm= new FriendsDetailsModel();
	
	
	
	public String saveFriendDetails()
	{
		fdm.setPersonName(AcPersonName);
		fdm.setPersonPhoto(AcPersonPhoto);
		fdm.setPersonDob(AcPersonDob);
		fdm.setMobileNumber(AcmobileNumber);
		fdm.setCategory(AcCategory);
		fdm.setCareOf(AcCareOf);
		logger.info("person name"+AcPersonName);
		logger.info("person name"+AcPersonPhoto);
		logger.info("person name"+AcPersonDob);
		logger.info("person name"+AcmobileNumber);
		logger.info("person name"+AcCategory);
		logger.info("person name"+AcCareOf);
		frndsDetailsService.saveObject(fdm);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public FriendsDetailsService getFrndsDetailsService() {
		return frndsDetailsService;
	}

	public void setFrndsDetailsService(FriendsDetailsService frndsDetailsService) {
		this.frndsDetailsService = frndsDetailsService;
	}

	public List<FriendsDetailsModel> getFrndDetailsModel() {
		return frndDetailsModel;
	}

	public void setFrndDetailsModel(List<FriendsDetailsModel> frndDetailsModel) {
		this.frndDetailsModel = frndDetailsModel;
	}

	public String getAcPersonName() {
		return AcPersonName;
	}

	public void setAcPersonName(String acPersonName) {
		AcPersonName = acPersonName;
	}

	public String getAcPersonPhoto() {
		return AcPersonPhoto;
	}

	public void setAcPersonPhoto(String acPersonPhoto) {
		AcPersonPhoto = acPersonPhoto;
	}

	public String getAcPersonDob() {
		return AcPersonDob;
	}

	public void setAcPersonDob(String acPersonDob) {
		AcPersonDob = acPersonDob;
	}

	public String getAcmobileNumber() {
		return AcmobileNumber;
	}

	public void setAcmobileNumber(String acmobileNumber) {
		AcmobileNumber = acmobileNumber;
	}

	public String getAcCategory() {
		return AcCategory;
	}

	public void setAcCategory(String acCategory) {
		AcCategory = acCategory;
	}

	public String getAcCareOf() {
		return AcCareOf;
	}

	public void setAcCareOf(String acCareOf) {
		AcCareOf = acCareOf;
	}

	
	
}
