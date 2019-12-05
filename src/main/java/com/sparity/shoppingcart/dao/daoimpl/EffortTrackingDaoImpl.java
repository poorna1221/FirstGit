package com.sparity.shoppingcart.dao.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.base.dao.BaseDAOImpl;
import com.sparity.shoppingcart.dao.EffortTrackingDao;
import com.sparity.shoppingcart.dao.ProjectCreationDAO;
import com.sparity.shoppingcart.model.EffortTrackingModel;
import com.sparity.shoppingcart.model.ProjectCreationModel;

@Repository("efDAO")
public class EffortTrackingDaoImpl extends BaseDAOImpl implements EffortTrackingDao{

	
	public List<EffortTrackingModel> getProjectBasedonDate(String datOfEntry, String empId){
		logger.info("imageId is "+datOfEntry+"dempdi id"+empId);
		String queryString ="from EffortTrackingModel as etm where etm.datOfEntry=:datOfEntry and etm.empId=:empId";
		return getHibernateTemplate().findByNamedParam(queryString, new String[]{"datOfEntry","empId"}, new Object[]{datOfEntry,empId});
	}

	@Override
	public List<EffortTrackingModel> getEffortdetails(Long EffortId) {
		String queryString="from EffortTrackingModel as etm where etm.EffortId=:EffortId";
		return getHibernateTemplate().findByNamedParam(queryString, "EffortId", EffortId);
		//List<ProjectCreationModel> pcmList=getHibernateTemplate().findByNamedParam(queryString, new String[]{"Project_Name"}, new Object[]{Project_Name});


	}

	@Override
	public EffortTrackingModel getAlreadyExistedEffortObj(Long EffortId) {
		String queryString="from EffortTrackingModel as etm where etm.EffortId=:EffortId";
		List<EffortTrackingModel> etmList= getHibernateTemplate().findByNamedParam(queryString, "EffortId", EffortId);
		//List<ProjectCreationModel> pcmList=getHibernateTemplate().findByNamedParam(queryString, new String[]{"Project_Name"}, new Object[]{Project_Name});
	if(etmList!=null && etmList.size()>0)
	{
		return etmList.get(0);
	}else
	{
		return null;	
	}
	}
	

}
