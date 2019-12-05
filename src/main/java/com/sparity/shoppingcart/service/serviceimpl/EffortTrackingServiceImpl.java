package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.EffortTrackingDao;
import com.sparity.shoppingcart.model.EffortTrackingModel;
import com.sparity.shoppingcart.service.EffortTrackingService;
@Service("efService")
public class EffortTrackingServiceImpl extends BaseServiceImpl implements EffortTrackingService{
	@Resource(name="efDAO")
	private EffortTrackingDao effortTrackingDao;

	@Override
	public List<EffortTrackingModel> getProjectBasedonDate(
			String showProjectForDate, String empID) {
		// TODO Auto-generated method stub
		return effortTrackingDao.getProjectBasedonDate(showProjectForDate,empID);
	}

	@Override
	public List<EffortTrackingModel> getEffortdetails(Long editEffortsEffortID) {
		// TODO Auto-generated method stub
		return effortTrackingDao.getEffortdetails(editEffortsEffortID);
	}

	@Override
	public EffortTrackingModel getAlreadyExistedEffortObj(Long effortId) {
		// TODO Auto-generated method stub
		return effortTrackingDao.getAlreadyExistedEffortObj(effortId);
	}

	
	
	
}
