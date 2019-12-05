package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.ApplcationUsersModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ProjectCreationModel;

public interface ProjectCreationService extends BaseService{
	
	public void saveProjectDetails(ProjectCreationModel pcm);
	
	
	List<ProjectCreationModel> getProjectBasedonApplication(String applicationName);
	
	public void updatePrjctDetails(ProjectCreationModel updatePrjctDetilsModel);
	
	List<ApplcationUsersModel> getUsersList();

	
	ApplcationUsersModel getUserType(String empID);


	public ProjectCreationModel getAlreadyExistedPrjctObj(String project_Name);


	public List<ProjectCreationModel> getAllProjectNames();


	//public ProjectCreationModel checkWeatherPrjctNameAlreadyExists(String applicationName, String project_Name);
}
