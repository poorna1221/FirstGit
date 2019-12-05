package com.sparity.shoppingcart.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sparity.shoppingcart.base.service.BaseServiceImpl;
import com.sparity.shoppingcart.dao.AdminDAO;
import com.sparity.shoppingcart.dao.UserAccountDAO;
import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.service.AdminService;




@Service("adminService")
public class AdminServiceImpl   extends BaseServiceImpl   implements AdminService{

	
	private final Logger log= Logger.getLogger(AdminServiceImpl.class);

	
	@Resource(name = "adminDAO")
	private AdminDAO adminDAO;
	
	
	
	@Override
	public AdminModel getadmindetials(String emailId, String password) {
		
		return adminDAO.getadmindetials(emailId,password);
	}

	@Override
	public AdminModel changePassword(AdminModel admin) {
		
		return adminDAO.changePassword(admin);
		
	}

	
	@Override
	public AdminModel exist(String email) {
		
		return adminDAO.exist(email);
	}

	@Override
	public void update(AdminModel admin) {
		adminDAO.update(admin);
		
	}


	@Override
	public AdminModel forgotPassword(String email) {
		
		return adminDAO.forgotPassword(email);
	}

	
	
	
	
	
	
	

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}




	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public void updatequery(Long productid) {
		adminDAO.updatequery(productid);
		
	}

	@Override
	public int getCountForCategoryProducts(Long categoryId) {
		return adminDAO.getCountForCategoryProducts(categoryId);
	}

	@Override
	public List<ProductModel> getAllCategoryProds(Long categoryId, int page,
			int rows) {
		return adminDAO.getAllCategoryProds(categoryId, page, rows);
	}
	
	
}
