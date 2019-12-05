package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.model.ApplcationUsersModel;
import com.sparity.shoppingcart.model.ProjectCreationModel;

public interface ProjectCreationDAO extends BaseDAO{

	List<ProjectCreationModel> getProjectBasedonApplication(String applicationName);

	public void updatePrjctDetails(ProjectCreationModel updatePrjctDetails);

	List<ApplcationUsersModel> getUsersList();

	ApplcationUsersModel getUserType(String empID);

	ProjectCreationModel getAlreadyExistedPrjctObj(String project_Name);

	List<ProjectCreationModel> getAllProjectNames();

	//ProjectCreationModel checkWeatherPrjctNameAlreadyExists(String applicationName, String project_Name);
}
