package com.sparity.shoppingcart.service;

import java.util.List;

import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.EffortTrackingModel;

public interface EffortTrackingService extends BaseService{

	List<EffortTrackingModel> getProjectBasedonDate(String showProjectForDate,String empID);

	List<EffortTrackingModel> getEffortdetails(Long editEffortsEffortID);

	EffortTrackingModel getAlreadyExistedEffortObj(Long effortId);

}
