package com.sparity.shoppingcart.dao;

import java.util.List;

import com.sparity.shoppingcart.base.dao.BaseDAO;
import com.sparity.shoppingcart.model.EffortTrackingModel;

public interface EffortTrackingDao extends BaseDAO{

	List<EffortTrackingModel> getProjectBasedonDate(String showProjectForDate,String empID);

	List<EffortTrackingModel> getEffortdetails(Long editEffortsEffortID);

	EffortTrackingModel getAlreadyExistedEffortObj(Long effortId);

}
