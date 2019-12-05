package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.ProjectCreationDAO;
import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.ApplcationUsersModel;
import com.sparity.shoppingcart.model.ProjectCreationModel;

@Repository("projectCreationDAO")
public class ProjectCreationDAOImpl extends BaseDAOImpl implements ProjectCreationDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectCreationModel> getProjectBasedonApplication(String ApplicationName) {
		logger.info("imageId is "+ApplicationName);
		String queryString ="from ProjectCreationModel as pcm where pcm.ApplicationName=:ApplicationName";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"ApplicationName"}, new Object[]{ApplicationName});
	}

	@Override
	public void updatePrjctDetails(ProjectCreationModel updatePrjctDetails) {
		getHibernateTemplate().update(updatePrjctDetails);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplcationUsersModel> getUsersList() {
		
		return getHibernateTemplate().find("from ApplcationUsersModel as aum");
	}

	@Override
	public ApplcationUsersModel getUserType(String EmpId) {
		
		String queryString="from ApplcationUsersModel as aum  where  aum.EmpId =:EmpId";
		List<ApplcationUsersModel> aumlist= getHibernateTemplate().findByNamedParam(queryString, "EmpId", EmpId);
		if(logger.isInfoEnabled())
			logger.info("userListsize in ApplcationDAOIMPL is "+aumlist.size());
		
		if(aumlist!=null&&aumlist.size()>0){
			return aumlist.get(0);
		} else{
			return null;
	}
		
		
		
		
	}

	@Override
	public ProjectCreationModel getAlreadyExistedPrjctObj(String Project_Name) {
		String queryString="from ProjectCreationModel as pcm where pcm.Project_Name=:Project_Name";
		List<ProjectCreationModel> pcmList= getHibernateTemplate().findByNamedParam(queryString, "Project_Name", Project_Name);
		//List<ProjectCreationModel> pcmList=getHibernateTemplate().findByNamedParam(queryString, new String[]{"Project_Name"}, new Object[]{Project_Name});
	if(pcmList!=null && pcmList.size()>0)
	{
		return pcmList.get(0);
	}else
	{
		return null;	
	}
	}

	@Override
	public List<ProjectCreationModel> getAllProjectNames() {
		return getHibernateTemplate().find("from ProjectCreationModel as pcm");
	}

	/*@Override
	public ProjectCreationModel checkWeatherPrjctNameAlreadyExists(String ApplicationName, String Project_Name) {
		String queryString="from ProjectCreationModel as pcm where pcm.ApplicationName=:ApplicationName and pcm.Project_Name=:Project_Name";
		//String queryString="select pcm.Project_Name as Project_Name from ProjectCreationModel as pcm where pcm.ApplicationName =:ApplicationName";
			//"from ProjectCreationModel as pcm where pcm.ApplicationName=:ApplicationName and pcm.Project_Name=:Project_Name";
		List<ProjectCreationModel> pcmList=getHibernateTemplate().findByNamedParam(queryString, "ApplicationName", ApplicationName);
		

	}*/

}
