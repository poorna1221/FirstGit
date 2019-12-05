package com.sparity.shoppingcart.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.AlbumModel;
import com.sparity.shoppingcart.model.AlbumTypeModel;
import com.sparity.shoppingcart.model.OrderDetailModel;
import com.sparity.shoppingcart.model.UserAlbumModel;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.model.WhishListsModel;
import com.sparity.shoppingcart.service.AlbumService;
import com.sparity.shoppingcart.service.OrderDetailService;
import com.sparity.shoppingcart.service.UserAccountService;
import com.sparity.shoppingcart.service.UserAlbumService;
import com.sparity.shoppingcart.service.WishListService;
import com.sparity.shoppingcart.util.CartUtil;
import com.sparity.shoppingcart.view.CartViewVO;
import com.sparity.shoppingcart.view.UserAccountViewBean;

public class UserAccountAction extends PersonalDetailsAction{
	
	private final Logger log = Logger.getLogger(UserAccountAction.class);
	private static final long serialVersionUID = 1L;
	
	private UserAccountService userAccountService=(UserAccountService) getServiceBean("userAccountService");
	private WishListService wishListService=(WishListService) getServiceBean("wishListService");
	  private AlbumService albumService=(AlbumService) getServiceBean("albumService");
		
	private UserAlbumService userAlbumService=(UserAlbumService) getServiceBean("userAlbumService");
	  private List<AlbumModel> albumModelList= new ArrayList<AlbumModel>();
		
		private List<UserAlbumModel>userAlbumList=new ArrayList<UserAlbumModel>();
		
		private File userImage1;
		private String userImageContentType1;
		private String userImageFileName1;
		private BufferedImage  image;
		 Image images = null;
		 Vector imageList = new Vector();
		 private String redirectUrl;
	  
	  
	private OrderDetailService orderDetailService=(OrderDetailService) getServiceBean("orderDetailService");
	
	private UserAccountViewBean  userAccountViewBean;
	private File userImage;
		
	private String userImageContentType;
			
	private String userImageFileName;
		
	private Long userAlbumId;
     private String imagename;
     private String albumType;
     private Long albumTypeId;
     private String emailid;
	
	
	public OrderDetailService getOrderDetailService() {
		return orderDetailService;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	
//----------------------------------------------RegisteredUser-----------------------------------------------------------
	
	public String validateUserAccount() {
		
		Map<String,Object> session = getSession();
		redirectUrl=(String) session.get("urlbeforelogin");
       String   email=userAccountViewBean.getUserEmailId();
       String   pass= userAccountViewBean.getUserPasword();
         log.info("------"+pass);
             
	        UserModel isExists=userAccountService.check(email,pass);
	          if(isExists==null)		
	          {
	        	  addActionError(" Sorry, Your Login details were incorrect!.You may click on ForgotPassword");
	        	  return ERROR;	        	  
	          }
	          else{
	        	 
	        	  
	        	List<WhishListsModel> wishList =  wishListService.wishList(isExists.getUserId());
	        	log.info("wishList------"+wishList);
	        	session.put("user", isExists);
	        	LinkedList<CartViewVO> linkedList = new LinkedList<CartViewVO>();
	        	for(WhishListsModel wl:wishList){
	        		CartViewVO cvo = new CartViewVO();
	        		cvo.setProdId(wl.getProductModel().getProductId());
	        		cvo.setImagePath(wl.getProductModel().getImpagePath());
	        		cvo.setQuantity(wl.getQuantity());
	        		cvo.setPrice(wl.getProductModel().getMrpPrice());
	        		cvo.setProdDescription(wl.getProductModel().getProductDesc());
	        		cvo.setSelectedColor(wl.getColor());
	        		
	        		
	        		linkedList.add(cvo);
	        	}
	        	session.put("whishList", linkedList);
	        	session.put("email", isExists.getUserEmailId());
                session.put("mobilenumber", isExists.getMobileNumber());
                
                /*LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("cartList");               
                
                session.put("cartList", spcart);
                Object[] totals = CartUtil.calculateMyCartSummary(spcart);
              
                session.put("totalItems", totals[0]);
	        	*/
                session.put("userid",isExists.getUserId());
                PersonalDetails();
				  return SUCCESS;
	          }
	}

//---------------------------------------------------New User----------------------------------------------------------------	
	public String SaveUserDetails()
	{
		    Map<String,Object> session = getSession();
			
		     String email=userAccountViewBean.getUserEmailId();
		     
			String PassWord=userAccountViewBean.getUserPasword();

			log.info("-------------------------------------------------------------------"+email);
	        log.info("-------------------------------------------------------------------"+PassWord);
	        
		   UserModel UserExists=userAccountService.NewUserCheck(email);
		  
		   
		   if(UserExists==null)
	    	{
			   
			    
				session.put("email", email);
				log.info("storing the new user details........................");
				log.info("$$$$$$$$$$$$$$$$$$$"+session.get("email"));
				
				UserModel userModel = new UserModel();
				
				userModel.setUserEmailId(userAccountViewBean.getUserEmailId());
				userModel.setUserPassword(userAccountViewBean.getUserPasword());
				
				userModel.setMobileNumber(userAccountViewBean.getMobileNumber());
				
				userAccountService.save(userModel);
				session.put("user",userModel);
		
		session.put("userid",userModel.getUserId());
				session.put("mobilenumber", userModel.getMobileNumber());
				log.info("*******************************************************"+session.get("userid"));
				log.info("**************"+session.get("user"));	
		
		
		
		
		
		
				log.info("$$$$$$$$$$$$$$$$$$$"+session.get("user"));
				 UserModel umo= new UserModel();
	                umo.setUserId(userModel.getUserId());
	                AlbumModel amo=new AlbumModel();
	                amo.setUserModel(umo);
	                albumService.save(amo);
	                PersonalDetails();
				return SUCCESS;
			
			   
	    	}
		
		else {
			addActionError("User exists.. Choose Different Login Id ");
			return ERROR;  
		   }
			
	}
	
		public  String Signin()
		{
			Map<String,Object>session=getSession();
			
			 String url=getRequest().getHeader("referer");
	 	     log.info("befor login url is"+url); 
			 
			 session.put("urlbeforelogin", url);
       	  
      
       	     
			return SUCCESS;
		}
		public String Signin1()
		
		{
			Map<String,Object>session=getSession();
			log.info("url in signin1 is"+session.get("urlbeforelogin"));
			
			redirectUrl=(String) session.get("urlbeforelogin");
			log.info("redirectUrl is"+redirectUrl);
			return SUCCESS;
		}
		public String SignOut(){
			 Map<String,Object> session = getSession();
			session.remove("user");
			session.remove("cartList");
			session.remove("totalItems");
			session.remove("totalAmount");
			session.remove("shipmodel");
			session.remove("selectedUrls");
			
			
			
			return SUCCESS;
		}
		
		public String MyAccount(){
			
			return SUCCESS;
		}
		
		
		
			
 //--------------------------------------------------forgot password-----------------------------------------------------------
		
		
		public String forgotPassword()
		{
			
			String email=userAccountViewBean.getUserEmailId();
			log.info("_____________________"+email);
			 
		UserModel emailExists=userAccountService.forgotPassword(email);
			
		     if(emailExists==null)
		     {
		    	 addActionError("Your Email Address is incorrect!");
		    	 return ERROR;
		     }
		     
		     else{
		    	 
		    	Properties props = new Properties();
		 		
		    	props.put("mail.smtp.host", "smtp.gmail.com");
		 		props.put("mail.smtp.socketFactory.port", "465");
		 		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 		props.put("mail.smtp.auth", "true");
		 		props.put("mail.smtp.port", "465");

		 		Session session = Session.getDefaultInstance(props,
		 			new javax.mail.Authenticator() {
		 				protected PasswordAuthentication getPasswordAuthentication() {
		 					return new PasswordAuthentication("shashank.gee@gmail.com","whatif7whatif7");
		 				}
		 			});

		 		
		 		try {
                     
		 			Message message = new MimeMessage(session);
		 			message.setFrom(new InternetAddress("shashank"));
		 			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(email));
		 			message.setSubject("Forgot PassWord ");
		 			String bodyContent = "Dear Customer ,"+"\n"+"Your Signin Details for www.parasDigitalWorld.com are as under:"+emailExists.getUserEmailId();
		 			for(int i=1;i<=5;i++){
		 				bodyContent += "your product details are prodId: "+i+"\n";
		 				
		 				
		 			}
		 			/*message.setText("Dear Customer ,"+"\n"+"Your Signin Details for www.parasDigitalWorld.com are as under:"
		 					+"\n"
		 					+ "Your EmailId is"+"\t"+emailExists.getUserEmailId()+"\n\n  Your password is"+ "\t"
		 					+   emailExists.getUserPassword());*/
		 			message.setText(bodyContent);
		 			Transport.send(message);

		 		
		 		} catch (MessagingException e) {
		 			throw new RuntimeException(e);
		 		}
		   
		 		addActionMessage("Your Password has been  sent successfully.");	 
		 		return SUCCESS;
		}
	}	
		
//----------------------------------------------ChangePassWord----------------------------------------------------------------
		
		public String checkShippingAddress(){
			
			
			
			

			
			
			return SUCCESS;
		}
		public String MyAcount()
		{
			return SUCCESS;
		}
		
	
         public String Cancel(){
			
			return SUCCESS;
		}
		
		
	@SuppressWarnings("unused")
	public String ChangePassword()
	{
			
			Map<String,Object> session = getSession();
			
			String	 pass=userAccountViewBean.getUserPasword();
			String   newpassword=userAccountViewBean.getNewPassword();
			
			
			log.info("emailid is"+ session.get("email"));
			log.info("PASSWORD IS-------------"+ pass);
			log.info("NEW PASSWORD IS---------"+ newpassword);
			
			UserModel us=(UserModel) session.get("user");		
			
			 log.info("PASSWORD IN SESSION"+us.getUserPassword());
			 
			 String email=    us.getUserEmailId();
			//String email=(String) session.get("email");
			 if(us.getUserEmailId().equals(email)&& us.getUserPassword().equals(pass))
			 {
				 log.info("PASSWORD IN SESSION "+us.getUserPassword());
				 log.info("NEW PASSWORD "+userAccountViewBean.getNewPassword());
				
				 us.setUserPassword(userAccountViewBean.getNewPassword());
				
				 UserModel ispwdExists=userAccountService.changePassword(us);
				
				
				 addActionMessage("PassWord has been changed Successfully");
					return SUCCESS;
			 }
			 
			 else{
				 addActionError("OldPassWord doesn't match");
					return ERROR;
			    }
		}
	
	
//-------------------------------------------OrderHistory----------------------------------------------------------------------	
	List<OrderDetailModel> orderDetailList=new ArrayList<OrderDetailModel>();
	
	
	Date tdate;
	String  transactiondate;

	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public String OrderHistory() throws ParseException{
	
		    Map<String,Object> session=getSession();
	       
		  Long userId=  (Long) session.get("userid");
		  log.info("((((((((((((((("+userId);
		  orderDetailList= orderDetailService.orderHistory(userId);
	
	      log.info("OrderDetailList is-------------------------------------------- "+orderDetailList.size());
	      
	 for(OrderDetailModel orderdetail:orderDetailList)
	    {
		 if(orderdetail.getShoppingCart().getUser().getUserId()==userId)
		 {
	      for( OrderDetailModel odm: orderDetailList)
	          {
		   	   
			   log.info("Product images ____________"+odm.getShoppingCart().getProduct().getImpagePath());
			   log.info("Trnsction dates ____________"+odm.getTransaction().getTransactionDate());
		 
			        tdate=(Date) odm.getTransaction().getTransactionDate();
				   
			       Format   formater = new SimpleDateFormat("MM/dd/yyyy");
				   transactiondate = formater.format(tdate);
				  log.info(";;;;;;;;"+transactiondate);	    
	          }
		
	      return SUCCESS;
		 }
		 
		 }
	 addActionError("You haven't made any  Orders so far");
	 return ERROR;
	    }


	
	//-------------------------------------------------------------file upload-------------------------------------------------------------------
	
	
	public String fileUploadMethod()
	{
		Map<String,Object> session = getSession();
		log.info("emailid is++++++++"+ session.get("email"));		
log.info("emailis---------------------"+session.get("email"));
		
		return SUCCESS;
	}
	public String fileUploadSuccess() 
	{
		
		Map<String,Object> session = getSession();
		UserModel user = (UserModel)session.get("user");
		
		try{
		log.info("uploaded file name is"+userImageFileName);
		
		log.info("userimagepath is"+userImage);
	
		emailid=(String) session.get("email");
		/*int endindexx=emailid.indexOf('@');
		String emailaftersplit=(String)emailid.substring(0,endindexx);
		log.info("emailaftersplit is"+emailaftersplit);*/
		log.info("email id is"+emailid);
		String s3=emailid.concat(userImageFileName);
		log.info("images after email concat"+s3);
		File file = new File("E:\\ShoppingCartDev\\tomcat_64 bit\\apache-tomcat-6.0.35\\webapps\\images\\"+emailid+"\\"+albumType);
		file.mkdir();
		
	//	String fullFileName = (("F:/shoppingcartDev/Development/shoppingcart/src/main/webapp/images/useruploadedimages")+ "//"+s3);
		
		/*File f1=new File(".\\..\\../images/useruploadedimages");
		f1.mkdir();
*/
		
		
		String fullFileName = (("E:/ShoppingCartDev/tomcat_64 bit/apache-tomcat-6.0.35/webapps/images"+"/"+emailid+"/"+albumType)+ "//"+s3);
		//String fullFileName = (("../../../images")+ "//"+s3);
		log.info("full image name is "+fullFileName);
		
		//File saveImage = new File(("C:/Documents and Settings/User/My Documents/My Pictures/New Folder")+ "//" + event.getFile().getFileName());
		
		File theFile = new File(fullFileName);
	
		log.info("filename is"+theFile);
		
	
			FileUtils.copyFile(userImage,theFile);
			
		
			
			log.info("uploaded file"+userImageFileName);
			
			log.info("email inside fileupload success is---------------------"+session.get("email"));
			log.info("email inside fileupload success is---------------------"+session.get("userid"));
			
			 Long userId=user.getUserId();
			 log.info("long userid is"+userId);
			
			albumModelList=albumService.findAlbumModelData(userId);
			
			albumType=getAlbumType();
			albumTypeId=getAlbumTypeId();
			for(AlbumModel am:albumModelList)
			{
				log.info("album id related to login userid is"+am.getAlbumId());
				Long albumId=am.getAlbumId();
				log.info("al id is"+albumId);
				//am.getUserAccount().getUser().getUserId()
				//log.info("album id "+am.getAlbumId());
				log.info("album name is"+am.getAlbumName());
				log.info("userimagefile name is"+userImageFileName);
				
				LOG.info("image name after split"+emailid.indexOf('@'));
				//log.info("end index of emailis"+endindexx);
				log.info("unique image is "+s3);
				
				UserAlbumModel useralbumobjec= new UserAlbumModel();
				
				
				useralbumobjec.setLocation(s3);
				
				AlbumModel albumModel= new AlbumModel();
				
				albumModel.setAlbumId(albumId);
				useralbumobjec.setAlbumModel(albumModel);
				
				AlbumTypeModel albumTypeModel = new AlbumTypeModel(); 
				
				albumTypeModel.setAlbumId(albumTypeId);
				useralbumobjec.setAlbumTypeModel(albumTypeModel);
				
				//userAlbumService.save(useralbumobjec);
			userAlbumList=userAlbumService.findAllImages(albumId,albumTypeId);
					if(!(isThisImageExists(userAlbumList,s3)))
					{
						log.info("image already existed with same name");
						userAlbumService.save(useralbumobjec);
					}
					else
					{
						addActionMessage("Image with same name already existed");
					}
		
					
				}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		showMyAlbumImages();
		
	
	
		return SUCCESS;
		
	}
	
	private boolean isThisImageExists(List<UserAlbumModel> userAlbumList,String s3) {
		for (UserAlbumModel userAlbum : userAlbumList) {
			if (userAlbum.getLocation().equals(s3))
				return true;
		}
		return false;
	}
	
	public String showMyAlbumImages()
	{
		Map<String,Object> session = getSession();
		UserModel user = (UserModel)session.get("user");
		emailid=(String) session.get("email");
		
		if(user==null){
			return LOGIN;
		}else{
		
		 Long userId=user.getUserId();
		 log.info("inside show my album images userid"+userId);
		albumModelList=albumService.findAlbumModelData(userId);
		albumType=getAlbumType();
		albumTypeId=getAlbumTypeId();
		for(AlbumModel am:albumModelList)
		{
		log.info("album id inside show my album images"+am.getAlbumId());
		Long albumId=am.getAlbumId();
		userAlbumList=userAlbumService.findAllImages(albumId,albumTypeId);
		
		
		
	
		for(UserAlbumModel uam:userAlbumList)
		{
		log.info("images are "+uam.getAlbumModel().getAlbumId());
		}
		}
		
	/*	try
	    {
	     File file = new File("G:/images/shashank.geeav200.jpg");
	     images = ImageIO.read(file);
	     imageList.add(images);
	    }
	  catch (IOException e)
	  {
	        e.printStackTrace();
	  }*/

		
		
		
		
		return SUCCESS;
		}
	}
	public String deleteImage()
	{
		log.info("id of image to be deleted is"+userAlbumId);
		Map<String,Object> session = getSession();
		String emailid=(String) session.get("email");
		emailid=(String) session.get("email");
		albumType=getAlbumType();
		albumTypeId=getAlbumTypeId();
		/*UserAlbumModel uamdeleteimages= new UserAlbumModel();
		uamdeleteimages.setUserAlbumId(userAlbumId);*/
		Object obj = userAlbumService.getObjectByID(UserAlbumModel.class,userAlbumId);
		userAlbumService.deleteObject(obj);
		String fullFileName = (("E:/ShoppingCartDev/tomcat_64 bit/apache-tomcat-6.0.35/webapps/images"+"/"+emailid+"/"+albumType)+ "/"+imagename);
		//String fullFileName = (("G:/images")+ "//"+imagename);
		File f1=new File(fullFileName);
		f1.delete();
		showMyAlbumImages();
		return SUCCESS;
	}
		
	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	public List<OrderDetailModel> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailModel> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	

	public UserAccountViewBean getUserAccountViewBean() {
		return userAccountViewBean;
	}

	public void setUserAccountViewBean(UserAccountViewBean userAccountViewBean) {
		this.userAccountViewBean = userAccountViewBean;
	}

	public WishListService getWishListService() {
		return wishListService;
	}

	public void setWishListService(WishListService wishListService) {
		this.wishListService = wishListService;
	}

	public AlbumService getAlbumService() {
		return albumService;
	}

	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	public UserAlbumService getUserAlbumService() {
		return userAlbumService;
	}

	public void setUserAlbumService(UserAlbumService userAlbumService) {
		this.userAlbumService = userAlbumService;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public Long getUserAlbumId() {
		return userAlbumId;
	}

	public void setUserAlbumId(Long userAlbumId) {
		this.userAlbumId = userAlbumId;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public List<AlbumModel> getAlbumModelList() {
		return albumModelList;
	}

	public void setAlbumModelList(List<AlbumModel> albumModelList) {
		this.albumModelList = albumModelList;
	}

	public List<UserAlbumModel> getUserAlbumList() {
		return userAlbumList;
	}

	public void setUserAlbumList(List<UserAlbumModel> userAlbumList) {
		this.userAlbumList = userAlbumList;
	}

	public File getUserImage1() {
		return userImage1;
	}

	public void setUserImage1(File userImage1) {
		this.userImage1 = userImage1;
	}

	public String getUserImageContentType1() {
		return userImageContentType1;
	}

	public void setUserImageContentType1(String userImageContentType1) {
		this.userImageContentType1 = userImageContentType1;
	}

	public String getUserImageFileName1() {
		return userImageFileName1;
	}

	public void setUserImageFileName1(String userImageFileName1) {
		this.userImageFileName1 = userImageFileName1;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Image getImages() {
		return images;
	}

	public void setImages(Image images) {
		this.images = images;
	}

	public Vector getImageList() {
		return imageList;
	}

	public void setImageList(Vector imageList) {
		this.imageList = imageList;
	}

	public String getAlbumType() {
		return albumType;
	}

	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}

	public Long getAlbumTypeId() {
		return albumTypeId;
	}

	public void setAlbumTypeId(Long albumTypeId) {
		this.albumTypeId = albumTypeId;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
}
