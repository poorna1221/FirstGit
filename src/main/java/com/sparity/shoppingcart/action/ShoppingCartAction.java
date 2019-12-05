package com.sparity.shoppingcart.action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.sparity.shoppingcart.model.ProductColorModel;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.ShippingAddressModel;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.util.CartUtil;
import com.sparity.shoppingcart.view.CartViewVO;

public class ShoppingCartAction extends UserAccountAction {

	private static final long serialVersionUID = -3900217456845313788L;
	private static Logger logger = Logger.getLogger(ShoppingCartAction.class);
	private CartViewVO cart;
	private List<CartViewVO> cartAddedProducts;
	private Long cartProdId;
	private int quantity;
	private String selectedColor;
	
	
	public String showCart(){
		/*Map<String,Object> session =  getSession();
		if(session!=null){
			LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("cartList");
		}
		session.put("sesboj", "hi");*/
		return SUCCESS;
	}
	
	
	public String addToCart(){
		Map<String,Object> session =  getSession();
		LinkedList<CartViewVO> whishListCart = (LinkedList<CartViewVO>) session.get("whishList");
		int quantity = 0;
		Double totalPrice =0D;
		LinkedList<CartViewVO> spcart = null; 
		if (session.get("cartList") != null) {
			try {
				spcart = (LinkedList<CartViewVO>) session.get("cartList");
				if(whishListCart!=null&&whishListCart.size()>0){
					for(int i=0;i<whishListCart.size();i++){
						if(cart.getProdId().longValue()== whishListCart.get(i).getProdId().longValue()){
							quantity = whishListCart.get(i).getQuantity();
							totalPrice = whishListCart.get(i).getTotalPrice();
							whishListCart.remove(i);
							break;
						}
					}
				}
					if(!isThisProductAdded(spcart)){
						if(quantity>0){
							cart.setQuantity(quantity);
							cart.setTotalPrice(totalPrice);
						}
						spcart.addFirst(cart);
					}
				
				
			} catch (Exception e) {
				logger.error(e);
			}
		} else {
			spcart = new LinkedList<CartViewVO>();
			spcart.add(cart);
		}
		
		//if(size>0){
			/*for(int i=0;i<size;i++){
				CartViewVO cvo = spcart.get(i);
				if(!(cvo.getProdId().longValue()== cart.getProdId().longValue())){
					logger.info("session productid "+cvo.getProdId().longValue());
					logger.info("current productid "+cart.getProdId().longValue());
					spcart.add(cart);
				}
			}*/
		/*List<CartViewVO> newspcart =new ArrayList<CartViewVO>();
			for(CartViewVO cvo:spcart){
				if(!(cvo.getProdId().longValue() == cart.getProdId().longValue())){
					newspcart.add(cart);
				}
			}*/
			//spcart.addAll(newspcart);
	//	}
		//spcart.add(cart);
		Object[] totals = CartUtil.calculateMyCartSummary(spcart);
		session.put("cartList", spcart);
		session.put("totalItems", totals[0]);
		session.put("totalAmount", totals[1]);

		logger.info("seesion Obj "+ session.get("cartList"));
		logger.info("cart values... "+ cart.getImagePath());
		return SUCCESS;
	}
	
	private boolean isThisProductAdded(List<CartViewVO> list) {
		for (CartViewVO cvo : list) {
			if (cvo.getProdId().longValue() == cart.getProdId().longValue())
				return true;
		}
		return false;
	}
	
	
	public String removeCart(){
		Map<String,Object> session =  getSession();
		LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("cartList"); 
		if(spcart!=null && spcart.size()>0){
		int cartsize = spcart.size();
		for(int i=0;i<cartsize;i++){
			CartViewVO sessionVO = spcart.get(i);
			if(sessionVO.getProdId().longValue() == getCartProdId().longValue()){
				spcart.remove(i);
				break;
			}
		}
		Object[] totals = CartUtil.calculateMyCartSummary(spcart);
		session.put("cartList", spcart);
		session.put("totalItems", totals[0]);
		session.put("totalAmount", totals[1]);
		}
		
		return SUCCESS;
	}
	
	public String updateQuantity(){
		Map<String,Object> session =  getSession();
		logger.info("prodid------"+getCartProdId());
		logger.info("Quantity------"+getQuantity());
		LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("cartList"); 
		
		if(spcart!=null && spcart.size()>0){
			int cartsize = spcart.size();
			for(int i=0;i<cartsize;i++){
				CartViewVO sessionVO = spcart.get(i);
				if(sessionVO.getProdId().longValue() == getCartProdId().longValue()){
					sessionVO.setQuantity(getQuantity());
					sessionVO.setTotalPrice(getQuantity()*sessionVO.getPrice());
				}
			}
			
			Object[] totals = CartUtil.calculateMyCartSummary(spcart);
			session.put("cartList", spcart);
			session.put("totalItems", totals[0]);
			session.put("totalAmount", totals[1]);
			
		}
		return SUCCESS;
		
	}
	
	public String addUserCartProds(){
		Map<String,Object> session =  getSession();
		UserModel user = (UserModel)session.get("user");
		LinkedList<CartViewVO> whishListCart = (LinkedList<CartViewVO>) session.get("whishList");
		int quantity = 0;
		Double totalPrice =0D;
		LinkedList<CartViewVO> spcart = null; 
		if(user!=null){
			if (session.get("cartList") != null) {
				try {
					spcart = (LinkedList<CartViewVO>) session.get("cartList");
					if(whishListCart!=null&&whishListCart.size()>0){
						for(int i=0;i<whishListCart.size();i++){
							if(cart.getProdId().longValue()== whishListCart.get(i).getProdId().longValue()){
								quantity = whishListCart.get(i).getQuantity();
								totalPrice = whishListCart.get(i).getTotalPrice();
								whishListCart.remove(i);
								break;
							}
						}
					}
						if(!isThisProductAdded(spcart)){
							if(quantity>0){
								cart.setQuantity(quantity);
								cart.setTotalPrice(totalPrice);
							}
							spcart.addFirst(cart);
						}
					
					
				} catch (Exception e) {
					logger.error(e);
				}
			} else {
				spcart = new LinkedList<CartViewVO>();
				spcart.add(cart);
			}
			
		} else {
			return INPUT;
		}
		return SUCCESS;
	}

	
	
	public String addToCart1(){
		

   logger.info("selected color is"+selectedColor);
   
   
   
   
   
	Map<String,Object> session =  getSession();
	
	  CartViewVO cartProd=(CartViewVO) session.get("cartProd");
	  cartProd.setSelectedColor(selectedColor);
	  
	session.put("cartProd", cartProd);
	LinkedList<CartViewVO> whishListCart = (LinkedList<CartViewVO>) session.get("whishList");
	CartViewVO cartVO = null;
	
	
	
	if(session.get("cartProd")!=null){
		if(((CartViewVO)session.get("cartProd")).getProdId().longValue()== getCartProdId()){
			cartVO = (CartViewVO)session.get("cartProd");
			logger.info("cartProd "+cartVO.getProdId());
		}
	}
	int quantity = 0;
	Double totalPrice =0D;
	LinkedList<CartViewVO> spcart = null; 
	if (session.get("cartList") != null) {
		try {
			spcart = (LinkedList<CartViewVO>) session.get("cartList");
			if(whishListCart!=null&&whishListCart.size()>0){
				for(int i=0;i<whishListCart.size();i++){
					if(cartVO.getProdId().longValue()== whishListCart.get(i).getProdId().longValue()){
						quantity = whishListCart.get(i).getQuantity();
						totalPrice = whishListCart.get(i).getTotalPrice();
						whishListCart.remove(i);
						break;
					}
				}
			}
				if(!isThisProductAdded1(spcart)){
					if(quantity>0){
						cartVO.setQuantity(quantity);
						cartVO.setTotalPrice(totalPrice);
					}
					spcart.addFirst(cartVO);
				}
			
			
		} catch (Exception e) {
			logger.error(e);
		}
	} else {
		spcart = new LinkedList<CartViewVO>();
		spcart.add(cartVO);
	}
	
	
	Object[] totals = CartUtil.calculateMyCartSummary(spcart);
	session.put("cartList", spcart);
	session.put("totalItems", totals[0]);
	session.put("totalAmount", totals[1]);

	
	String url=getRequest().getHeader("referer");
	
	logger.info("requested url is"+url);
	
	List<String> urllist=null;
	
	if(session.get("selectedUrls")!=null)
	{
	List<String>urllist1=(List<String>) session.get("selectedUrls");
	urllist= new ArrayList<String>();
	urllist.addAll(urllist1);
	urllist.add(url);
	
	
	}
	else
	{
		urllist= new ArrayList<String>();
		urllist.add(url);
		
	}
	session.put("selectedUrls", urllist);
	
	List<String> str=(List<String>) session.get("selectedUrls");
	
	for(String str1:str)
	{
		logger.info("requested urls from session are"+str1);
		
	}
	
	
	return SUCCESS;
}
	
	private boolean isThisProductAdded1(List<CartViewVO> list) {
		logger.info("cartPordId "+cartProdId);
		for (CartViewVO cvo : list) {
			if (cvo.getProdId().longValue() ==cartProdId.longValue())
				return true;
		}
		return false;
	}

public String sendemailtoadmin()
{
	

	Map<String,Object> session=getSession();
	ProductColorModel pcm= new ProductColorModel();
	CartViewVO cv=(CartViewVO) session.get("cartProd");
	ProductModel pm=new ProductModel();
	pm.setProductId(cv.getProdId());
	pcm.setProductModel(pm);
	
	pcm.setProdColorName(cv.getSelectedColor());
	

	
	UserModel userModel= (UserModel) session.get("user");
	
	
	
	Long userId=userModel.getUserId();
	
	String adminEmailId="shashank.gee@gmail.com";
	
	String userEmailId=userModel.getUserEmailId();
	
 	
   String mobileNumber=userModel.getMobileNumber();
    
   
/*    
    Set<ShippingAddressModel> shmodel=  userModel.getShippingAddLists();
    
    Iterator<ShippingAddressModel>	it = shmodel.iterator();
    ShippingAddressModel sm = null;
    while(it.hasNext()){
    	sm = it.next();
    	break;
    }
    
    String presentaddress=sm.getPresentAddress();*/
   
   
    ShippingAddressModel shModel=(ShippingAddressModel) session.get("shipmodel");
  
  String presentaddress=shModel.getPresentAddress();
    
    LinkedList<CartViewVO> cvo1=(LinkedList<CartViewVO>) session.get("cartList");
    
  
    
   /* CartViewVO cvo=cvo1.get(0);
     Long productId=cvo.getProdId();
      
     int quantity=cvo.getQuantity();
      
    Double totalPrice=cvo.getTotalPrice();*/
    
    
    
	
	
	logger.info("userid is "+userId);
	logger.info("userEmailId is "+userEmailId);
	logger.info("mobile no is "+mobileNumber);
	logger.info("shipping address is "+presentaddress);
	//logger.info("product id of ordered item is"+productId);
	//logger.info("Quantity is"+quantity);
	
	//logger.info("totalprice is"+totalPrice);
	
	 /* for(CartViewVO cartListObject:cvo1)
	    {
	    	logger.info("product id is"+cartListObject.getProdId());
	    	logger.info("quantity is"+cartListObject.getQuantity());
	        logger.info("total price for product is"+cartListObject.getTotalPrice());
	    }*/
	
		 
  	Properties props = new Properties();
		
  	    props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session1 = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("shashank.gee@gmail.com","whatif7whatif7");
				}
			});

		
		try {
           
			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress("shashank"));
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(adminEmailId));
		
		   message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(userEmailId));
			
			
			message.setSubject("Product Purchase Details ");
			String bodyContent = "Customer Email:"+userEmailId+"\n"+"\n"+"Customer mobile number:"+mobileNumber+"\n"+"\n"+"Customer address is:"+presentaddress+"\n";
			
			 for(CartViewVO cartListObject:cvo1)
			    {
			    	logger.info("product id is"+cartListObject.getProdId());
			    	logger.info("quantity is"+cartListObject.getQuantity());
			        logger.info("total price for product is"+cartListObject.getTotalPrice());
			        
			    
			        
			    	bodyContent +="Purchased product id:"+cartListObject.getProdId()+"\n"
			    	+"Product Name:"+cartListObject.getProdDescription()+"\n"
			    	+"Color:"+cartListObject.getSelectedColor()+"\n"
			    	
			    	+"No of products:"+cartListObject.getQuantity()+"\n"
			    	+"Total Price is"+cartListObject.getTotalPrice()+"\n"+"\n"+"\n";
			    	
			    	
			    
			    	
			    	
			    	
			    }
			
			 
			 bodyContent+="Total amount:"+session.get("totalAmount")+"\n"+"\n";
			 
			 bodyContent+="\n"+"product url is"+"\t"+"\n"+session.get("selectedUrls");

			
			message.setText(bodyContent);
			Transport.send(message);

		
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
 
		
		return SUCCESS;
		}


	public CartViewVO getCart() {
		return cart;
	}


	public void setCart(CartViewVO cart) {
		this.cart = cart;
	}


	public List<CartViewVO> getCartAdded() {
		return cartAddedProducts;
	}


	public void setCartAdded(List<CartViewVO> cartAdded) {
		this.cartAddedProducts = cartAdded;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Long getCartProdId() {
		return cartProdId;
	}


	public void setCartProdId(Long cartProdId) {
		this.cartProdId = cartProdId;
	}


	public String getSelectedColor() {
		return selectedColor;
	}


	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}


	

	
}
