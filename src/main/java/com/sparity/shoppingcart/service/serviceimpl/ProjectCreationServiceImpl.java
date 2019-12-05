package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.HomePageDAO;
import com.sparity.shoppingcart.dao.ProjectCreationDAO;
import com.sparity.shoppingcart.model.ApplcationUsersModel;
import com.sparity.shoppingcart.model.ProjectCreationModel;
import com.sparity.shoppingcart.service.ProjectCreationService;

@Service("projectCreationService")
public class ProjectCreationServiceImpl extends BaseServiceImpl implements ProjectCreationService{

	private static final Logger logger = Logger.getLogger(ProjectCreationServiceImpl.class);
	
	@Resource(name="projectCreationDAO")
	private ProjectCreationDAO projectCreationDAO;
	
	
	@Override
	public void saveProjectDetails(ProjectCreationModel pcm) {

    saveObject(pcm);
    
	}

	@Override
	public List<ProjectCreationModel> getProjectBasedonApplication(String applicationName) {
	
		return projectCreationDAO.getProjectBasedonApplication(applicationName);
	}

	@Override
	public void updatePrjctDetails(ProjectCreationModel updatePrjctDetilsModel) {
		projectCreationDAO.updatePrjctDetails(updatePrjctDetilsModel);
		
	}

	@Override
	public List<ApplcationUsersModel> getUsersList() {
		 
		return projectCreationDAO.getUsersList();
	}

	@Override
	public ApplcationUsersModel getUserType(String empID) {
		return  projectCreationDAO.getUserType(empID);
	}

	@Override
	public ProjectCreationModel getAlreadyExistedPrjctObj(String project_Name) {
		// TODO Auto-generated method stub
		return projectCreationDAO.getAlreadyExistedPrjctObj(project_Name);
	}

	@Override
	public List<ProjectCreationModel> getAllProjectNames() {
		// TODO Auto-generated method stub
		return projectCreationDAO.getAllProjectNames();
	}

	/*@Override
	public ProjectCreationModel checkWeatherPrjctNameAlreadyExists(String applicationName, String project_Name) {
		 
		return projectCreationDAO.checkWeatherPrjctNameAlreadyExists(applicationName,project_Name);
	}*/

}
