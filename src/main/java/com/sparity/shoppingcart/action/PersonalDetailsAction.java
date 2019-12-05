package com.sparity.shoppingcart.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.service.PersonalDetailsService;
import com.sparity.shoppingcart.view.PersonalDetailsViewBean;

public class PersonalDetailsAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private final Logger log = Logger.getLogger(PersonalDetailsAction.class);

	private PersonalDetailsService personalDetailsService=(PersonalDetailsService) getServiceBean("personalDetailsService");
	
	private PersonalDetailsViewBean personalDetailsViewBean;
	
	private String firstName;
	
     private String lastName;
	
	private String presentAddress;
	
	private String alternateAddress;
	
	private String city;
	
	private Integer pincode;
	
	private String state;
	
	private String country;
	
	private String title;
	
	private String gender;
	
	private String dateOfBirth;
	
	private String telNumber;
	
    private String emailID;

	private UserModel user;
	
	 private String   mobilenumber;
	
	//----------------------------------------------PersonalDetails-------------------------------------------------------------------------------	
		

	public String PersonalDetails(){
		Map<String,Object> session = getSession();
		UserModel user = (UserModel)session.get("user");
		if(user!=null){
			ShippingAddressModel shipaddressmodel = personalDetailsService.finding(user.getUserId());
			 if(shipaddressmodel!=null){
				 
				 session.put("shipmodel", shipaddressmodel);
				 personalDetailsViewBean = new PersonalDetailsViewBean();
				 personalDetailsViewBean.setLastName(shipaddressmodel.getLastName());
				 personalDetailsViewBean.setFirstName(shipaddressmodel.getFirstName());
				 personalDetailsViewBean.setPresentAddress(shipaddressmodel.getPresentAddress());
				 personalDetailsViewBean.setAlternateAddress(shipaddressmodel.getAlternateAddress());
				 personalDetailsViewBean.setCity(shipaddressmodel.getCity());
				 personalDetailsViewBean.setCountry(shipaddressmodel.getCountry());
				 personalDetailsViewBean.setState(shipaddressmodel.getState());
				 personalDetailsViewBean.setPincode(shipaddressmodel.getPincode());
				 personalDetailsViewBean.setTelePhoneNumber(shipaddressmodel.getTelNumber());
				 personalDetailsViewBean.setDateOfBirth(shipaddressmodel.getDateOfBirth());
			 } else {
				 if(log.isInfoEnabled())
					 log.info("Person details doesn't exist.");
			 }
			return SUCCESS;

		} else {
			return INPUT;
		}
			
	}
		
	
	
	
	     @SuppressWarnings({"unused" })
		public String SavePersonalDetails(){
			 
			
			Map<String,Object> session = getSession();
			  
			  ShippingAddressModel shipmodel=new ShippingAddressModel();
			
			   UserModel usermodel=new UserModel();
			 
			   Long userid=(Long)session.get("userid");
			   log.info("userID is"+userid);
			   String address=presentAddress;
			   address.trim();
			  log.info("AFTER TRIM"+address);
			 
			
			 String aladdress=alternateAddress;
			   aladdress.trim();
			   log.info("AFTER TRIM"+aladdress);
			   
			   UserModel us=(UserModel) session.get("user");
			   String sessionmobilenum=us.getMobileNumber();
			    String sessionemail = us.getUserEmailId();   
                Long userId=us.getUserId();
              
			
			   
         ShippingAddressModel shipaddressmodel = personalDetailsService.finding(userId);
         
             
              String emailid =emailID;
			   
			   
			   
         
         if(shipaddressmodel==null)
         {
        	 log.info("+++++ NEW USER");
        	 
       	  
			   log.info("________"+mobilenumber);
			   log.info("________"+emailID);
			   log.info("________"+dateOfBirth);
			   
			  
			   
			   us.setUserId(userId) ;
			   shipmodel.setUser(us);
			   
			   shipmodel.setFirstName(firstName);
			   shipmodel.setLastName(lastName);
			   shipmodel.setPresentAddress(address); 
			   shipmodel.setCity(city);
			   shipmodel.setCountry(country);
			   shipmodel.setPincode(pincode);			   
			   shipmodel.setTitle(title);
			   shipmodel.setState(state);
			   shipmodel.setDateOfBirth(dateOfBirth);
			   shipmodel.setGender(gender);
			   shipmodel.setTelNumber(telNumber);
			   shipmodel.setAlternateAddress(aladdress);
			   
			   
		
			   
		  
			   
			   if(sessionemail.equals(emailid)){
				   
				   log.info("&&&&&&&&&&&");
				   log.info("_____________"+sessionemail);
				   log.info("_____________"+sessionmobilenum);
				   //personalDetailsService.save(shipmodel); 
			   }
			   
			   else{
				  
				UserModel usrmodel= personalDetailsService.exist(emailid);
				   if(usrmodel==null){
					  us.setUserEmailId(emailid);
					   personalDetailsService.update(us);
					   
					   //personalDetailsService.save(shipmodel);
				   }
					   
					   
				   else if(usrmodel!=null){   
					   addActionError("Email Id is already existed! Choose different emailid");
					   return ERROR;
				   }
			   }

			   
			   if(sessionmobilenum.equals(mobilenumber)){
				   
				    personalDetailsService.save(shipmodel); 
				   
				   personalDetailsViewBean = new PersonalDetailsViewBean();
				   personalDetailsViewBean.setLastName(lastName);
				   personalDetailsViewBean.setFirstName(firstName);
					 personalDetailsViewBean.setPresentAddress(address);
					 personalDetailsViewBean.setAlternateAddress(aladdress);
					 personalDetailsViewBean.setCity(city);
					 personalDetailsViewBean.setCountry(country);
					 personalDetailsViewBean.setState(state);
					 personalDetailsViewBean.setPincode(pincode);
					 personalDetailsViewBean.setTelePhoneNumber(telNumber);
					 personalDetailsViewBean.setDateOfBirth(dateOfBirth);
			   }
			   
			   else{
				   us.setMobileNumber(mobilenumber);
				   
				   personalDetailsService.update(us);
				  
				   personalDetailsService.save(shipmodel);
				   
				   personalDetailsViewBean = new PersonalDetailsViewBean();
				   personalDetailsViewBean.setLastName(lastName);
				   personalDetailsViewBean.setFirstName(firstName);
					 personalDetailsViewBean.setPresentAddress(address);
					 personalDetailsViewBean.setAlternateAddress(aladdress);
					 personalDetailsViewBean.setCity(city);
					 personalDetailsViewBean.setCountry(country);
					 personalDetailsViewBean.setState(state);
					 personalDetailsViewBean.setPincode(pincode);
					 personalDetailsViewBean.setTelePhoneNumber(telNumber);
					 personalDetailsViewBean.setDateOfBirth(dateOfBirth);
				   
			   }
			        addActionMessage("Your Personal profile saved successfully");
			        PersonalDetails();
			       
					return SUCCESS;
         }
		
         
         else{
	        	
        	 log.info("---------THIS USER HAVING PERSONAL DETAILS");
	     
	        	 if(sessionemail.equals(emailid)){
					   
					   log.info("&&&&&&&&&&&");
					   log.info("_____________"+sessionemail);
					   log.info("_____________"+sessionmobilenum);
					   //personalDetailsService.save(shipmodel); 
				   }
				   
				else
				{
				   UserModel usrmodel= personalDetailsService.exist(emailid);
				   if(usrmodel==null){
					  us.setUserEmailId(emailid);
					   personalDetailsService.update(us);
					   
					   personalDetailsViewBean = new PersonalDetailsViewBean();
					   personalDetailsViewBean.setLastName(lastName);
					   personalDetailsViewBean.setFirstName(firstName);
						 personalDetailsViewBean.setPresentAddress(address);
						 personalDetailsViewBean.setAlternateAddress(aladdress);
						 personalDetailsViewBean.setCity(city);
						 personalDetailsViewBean.setCountry(country);
						 personalDetailsViewBean.setState(state);
						 personalDetailsViewBean.setPincode(pincode);
						 personalDetailsViewBean.setTelePhoneNumber(telNumber);
						 personalDetailsViewBean.setDateOfBirth(dateOfBirth);
				   }
        	 
				   else if(usrmodel!=null){   
					   addActionError("Email Id is already existed! Choose different emailid");
					   personalDetailsViewBean = new PersonalDetailsViewBean();
					   personalDetailsViewBean.setLastName(lastName);
					   personalDetailsViewBean.setFirstName(firstName);
						 personalDetailsViewBean.setPresentAddress(address);
						 personalDetailsViewBean.setAlternateAddress(aladdress);
						 personalDetailsViewBean.setCity(city);
						 personalDetailsViewBean.setCountry(country);
						 personalDetailsViewBean.setState(state);
						 personalDetailsViewBean.setPincode(pincode);
						 personalDetailsViewBean.setTelePhoneNumber(telNumber);
						 personalDetailsViewBean.setDateOfBirth(dateOfBirth);
					   
					   return ERROR;
				   }
				}   
				   if(sessionmobilenum.equals(mobilenumber)){
					   
					log.info("Personal Details are Updating.........................................................");
			        	 
					
					   us.setUserId(userId) ;
					   shipaddressmodel.setUser(us);
					   
					   shipaddressmodel.setFirstName(firstName);
					   shipaddressmodel.setLastName(lastName);
					   shipaddressmodel.setPresentAddress(address); 
					   shipaddressmodel.setCity(city);
					   shipaddressmodel.setCountry(country);
					   shipaddressmodel.setPincode(pincode);			   
					   shipaddressmodel.setTitle(title);
					   shipaddressmodel.setState(state);
					   shipaddressmodel.setDateOfBirth(dateOfBirth);
					   shipaddressmodel.setGender(gender);
					   shipaddressmodel.setTelNumber(telNumber);
					   shipaddressmodel.setAlternateAddress(aladdress);
					   
						   
						   personalDetailsService.updating(shipaddressmodel);
						   personalDetailsViewBean = new PersonalDetailsViewBean();
						   personalDetailsViewBean.setLastName(lastName);
						   personalDetailsViewBean.setFirstName(firstName);
							 personalDetailsViewBean.setPresentAddress(address);
							 personalDetailsViewBean.setAlternateAddress(aladdress);
							 personalDetailsViewBean.setCity(city);
							 personalDetailsViewBean.setCountry(country);
							 personalDetailsViewBean.setState(state);
							 personalDetailsViewBean.setPincode(pincode);
							 personalDetailsViewBean.setTelePhoneNumber(telNumber);
							 personalDetailsViewBean.setDateOfBirth(dateOfBirth);
 				   }
				   
				   else {
					   us.setMobileNumber(mobilenumber);
					   personalDetailsService.update(us);
					  
						 log.info("Personal Details are Updating");
			        	 
						   shipaddressmodel.setFirstName(firstName);
						   shipaddressmodel.setLastName(lastName);
						   shipaddressmodel.setPresentAddress(address); 
						   shipaddressmodel.setCity(city);
						   shipaddressmodel.setCountry(country);
						   shipaddressmodel.setPincode(pincode);			   
						   shipaddressmodel.setTitle(title);
						   shipaddressmodel.setState(state);
						   shipaddressmodel.setDateOfBirth(dateOfBirth);
						   shipaddressmodel.setGender(gender);
						   shipaddressmodel.setTelNumber(telNumber);
						   shipaddressmodel.setAlternateAddress(aladdress);
						   
						   personalDetailsService.updating(shipaddressmodel);
						   personalDetailsViewBean = new PersonalDetailsViewBean();
						   personalDetailsViewBean.setLastName(lastName);
						   personalDetailsViewBean.setFirstName(firstName);
							 personalDetailsViewBean.setPresentAddress(address);
							 personalDetailsViewBean.setAlternateAddress(aladdress);
							 personalDetailsViewBean.setCity(city);
							 personalDetailsViewBean.setCountry(country);
							 personalDetailsViewBean.setState(state);
							 personalDetailsViewBean.setPincode(pincode);
							 personalDetailsViewBean.setTelePhoneNumber(telNumber);
							 personalDetailsViewBean.setDateOfBirth(dateOfBirth);
					   }
                  }
		
		             addActionMessage("Your Personal profile Changed successfully");
		             PersonalDetails();
					return SUCCESS;
					
					 
		         
		}


	     
	     
	     
	     
	     
	     
	     public String getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
		}

		public String getEmailID() {
			return emailID;
		}

		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getGender() {
			return gender;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		
			public String getTelNumber() {
			return telNumber;
		}

		public void setTelNumber(String telNumber) {
			this.telNumber = telNumber;
		}

			public UserModel getUser() {
			return user;
		}

		public void setUser(UserModel user) {
			this.user = user;
		}

			public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPresentAddress() {
			return presentAddress;
		}

		public void setPresentAddress(String presentAddress) {
			this.presentAddress = presentAddress;
		}

		public String getAlternateAddress() {
			return alternateAddress;
		}

		public void setAlternateAddress(String alternateAddress) {
			this.alternateAddress = alternateAddress;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Integer getPincode() {
			return pincode;
		}

		public void setPincode(Integer pincode) {
			this.pincode = pincode;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
	
	public PersonalDetailsService getPersonalDetailsService() {
		return personalDetailsService;
	}

	public void setPersonalDetailsService(
			PersonalDetailsService personalDetailsService) {
		this.personalDetailsService = personalDetailsService;
	}

	public PersonalDetailsViewBean getPersonalDetailsViewBean() {
		return personalDetailsViewBean;
	}

	public void setPersonalDetailsViewBean(
			PersonalDetailsViewBean personalDetailsViewBean) {
		this.personalDetailsViewBean = personalDetailsViewBean;
	}

	
	
}
