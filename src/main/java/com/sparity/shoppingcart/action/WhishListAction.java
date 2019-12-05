package com.sparity.shoppingcart.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.base.service.BaseService;
import com.sparity.shoppingcart.model.ProductModel;
import com.sparity.shoppingcart.model.UserModel;
import com.sparity.shoppingcart.model.WhishListsModel;
import com.sparity.shoppingcart.service.WishListService;
import com.sparity.shoppingcart.util.CartUtil;
import com.sparity.shoppingcart.view.CartViewVO;

public class WhishListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2548423643764740963L;
	private static Logger logger = Logger.getLogger(WhishListAction.class);
	private CartViewVO wishVO;
	private Long cartProdId;
	private String imageId;
	private String selectedColor;
	private BaseService baseService=(BaseService) getServiceBean("baseService");
	private WishListService wishListService=(WishListService) getServiceBean("wishListService");
	
	public String showWhishList(){
		Map<String,Object> session =  getSession();
		// TODO check user session if not show registration page.
		return SUCCESS;
	}
	
	public String addCartProdToWhishList(){
		logger.info("price--"+wishVO.getPrice());
		logger.info("descripton--"+wishVO.getProdDescription());
		logger.info("imgpath--"+wishVO.getImagePath());
		logger.info("prodId--"+wishVO.getProdId());
		logger.info("Quanitity--"+wishVO.getQuantity());
		logger.info("TotalPrice--"+wishVO.getTotalPrice());
		
		Map<String,Object> session =  getSession();
		@SuppressWarnings("unchecked")
		LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("cartList"); 
		if(spcart!=null && spcart.size()>0){
			int cartsize = spcart.size();
			for(int i=0;i<cartsize;i++){
				CartViewVO sessionVO = spcart.get(i);
				if(sessionVO.getProdId().longValue() == getWishVO().getProdId().longValue()){
					spcart.remove(i);
					break;
				}
			}
			Object[] totals = CartUtil.calculateMyCartSummary(spcart);
			session.put("cartList", spcart);
			session.put("totalItems", totals[0]);
			session.put("totalAmount", totals[1]);
			
			//adding prods to whish list
			LinkedList<CartViewVO> whishListcart = null; 
			if( session.get("whishList")!=null){
				whishListcart = (LinkedList<CartViewVO>) session.get("whishList");
				if(!isThisProductAdded(whishListcart)){
					whishListcart.addFirst(getWishVO());
				}
				
			} else {
				whishListcart = new LinkedList<CartViewVO>();
				whishListcart.add(getWishVO());
			}
			
			session.put("whishList", whishListcart);
			
		}
		
		return SUCCESS;
	}
	
	public String addCartProdToWhishList1(){
		Map<String,Object> session =  getSession();
		LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("cartList");
		LinkedList<CartViewVO> whishListcart = null;
		if(spcart!=null && spcart.size()>0){
			if( session.get("whishList")!=null){
				whishListcart = (LinkedList<CartViewVO>) session.get("whishList");
				for(int i=0;i<spcart.size();i++){
					if(spcart.get(i).getProdId().longValue() == getCartProdId().longValue()){
						whishListcart.addFirst(spcart.get(i));
						spcart.remove(i);
						break;
					}
				}
				
			} else {
				whishListcart = new LinkedList<CartViewVO>();
				for(int i=0;i<spcart.size();i++){
					if(spcart.get(i).getProdId().longValue() == getCartProdId().longValue()){
						whishListcart.add(spcart.get(i));
						spcart.remove(i);
						break;
					}
				}
			}
			
			Object[] totals = CartUtil.calculateMyCartSummary(spcart);
			session.put("cartList", spcart);
			session.put("totalItems", totals[0]);
			session.put("totalAmount", totals[1]);
			session.put("whishList", whishListcart);
			
			
		}
		
		/*//adding prods to whish list
		LinkedList<CartViewVO> whishListcart = null; 
		if( session.get("whishList")!=null){
			whishListcart = (LinkedList<CartViewVO>) session.get("whishList");
			if(!isThisProductAdded(whishListcart)){
				whishListcart.addFirst(getWishVO());
			}
			
		} else {
			whishListcart = new LinkedList<CartViewVO>();
			whishListcart.add(getWishVO());
		}
		
		session.put("whishList", whishListcart);*/
		return SUCCESS;
	}
	
	/**
	 * This method for user directly move product to wishlist
	 * @return
	 */
	
	public String addProdToWishList(){
		Map<String,Object> session =  getSession();
		
		CartViewVO cartProd=(CartViewVO) session.get("cartProd");
		
		
	    cartProd.setSelectedColor(selectedColor);
	    
	    
		  
		session.put("cartProd", cartProd);
		CartViewVO cartVO = null;
		LinkedList<CartViewVO> whishListcart = null;
		
		UserModel user = (UserModel)session.get("user");
		
		if(user==null){
			return LOGIN;
		}else{		
		if(session.get("cartProd")!=null){
			if(((CartViewVO)session.get("cartProd")).getProdId().longValue()== getCartProdId()){
				cartVO = (CartViewVO)session.get("cartProd");
				logger.info("cartProd.... "+cartVO.getProdId());
				logger.info("userId.... "+user.getUserId());
				logger.info("quantity.... "+cartVO.getQuantity());
				ProductModel prodModel = (ProductModel)baseService.getObjectByID(ProductModel.class, cartVO.getProdId());
				WhishListsModel whishListsModel = new WhishListsModel();
				whishListsModel.setProductModel(prodModel);
				whishListsModel.setQuantity(cartVO.getQuantity());
				whishListsModel.setColor(cartVO.getSelectedColor());
				
				whishListsModel.setUser(user);
				
				
				setImageId(cartVO.getImagePath());
				
				
				if( session.get("whishList")!=null){
					whishListcart = (LinkedList<CartViewVO>) session.get("whishList");
					if(!isThisProductAdded1(whishListcart)){
						whishListcart.addFirst(cartVO);
						baseService.saveObject(whishListsModel);
					}
					
				} else {
					whishListcart = new LinkedList<CartViewVO>();
					whishListcart.add(cartVO);
				}
				session.put("whishList", whishListcart);
				
			}
			return SUCCESS;
		} else {
			return INPUT;
		}
		}
	}
	
	
	public String moveProdToCart(){
		
		
		Map<String,Object> session =  getSession();
		

	   
	  
	   
		LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("whishList");
		CartViewVO cartAddProd = new CartViewVO();
		if(spcart!=null && spcart.size()>0){
			int cartsize = spcart.size();
			for(int i=0;i<cartsize;i++){
				CartViewVO sessionVO = spcart.get(i);
				if(sessionVO.getProdId().longValue() == getCartProdId().longValue()){
					cartAddProd.setProdId(sessionVO.getProdId());
					cartAddProd.setImagePath(sessionVO.getImagePath());
					cartAddProd.setProdDescription(sessionVO.getProdDescription());
					cartAddProd.setQuantity(sessionVO.getQuantity());
					cartAddProd.setPrice(sessionVO.getPrice());
					cartAddProd.setTotalPrice(sessionVO.getTotalPrice());
					cartAddProd.setSelectedColor(sessionVO.getSelectedColor());
					spcart.remove(i);
					break;
				}
			}
			LinkedList<CartViewVO> sessionCart = (LinkedList<CartViewVO>) session.get("cartList"); 
			if(sessionCart!=null){
				sessionCart.addFirst(cartAddProd);
				Object[] totals = CartUtil.calculateMyCartSummary(sessionCart);
				session.put("cartList", sessionCart);
				session.put("totalItems", totals[0]);
				session.put("totalAmount", totals[1]);
				session.put("whishList", spcart);
			} else {
				sessionCart = new LinkedList<CartViewVO>();
				sessionCart.addFirst(cartAddProd);
				Object[] totals = CartUtil.calculateMyCartSummary(sessionCart);
				session.put("cartList", sessionCart);
				session.put("totalItems", totals[0]);
				session.put("totalAmount", totals[1]);
				session.put("whishList", spcart);
			}
			
			/*Object[] totals = CartUtil.calculateMyCartSummary(sessionCart);
			session.put("cartList", sessionCart);
			session.put("totalItems", totals[0]);
			session.put("totalAmount", totals[1]);
			session.put("whishList", spcart);*/
			}
		
		return SUCCESS;
	}
	
	/**
	 * Remove Products from whish list.
	 * @return
	 */
	public String removeProdFromWhishList(){
		Map<String,Object> session =  getSession();
		LinkedList<CartViewVO> spcart = (LinkedList<CartViewVO>) session.get("whishList"); 
		UserModel userMode = (UserModel)session.get("user");
		List<WhishListsModel> wishList =  wishListService.wishList(userMode.getUserId());
		if(spcart!=null && spcart.size()>0){
		int cartsize = spcart.size();
		logger.info(wishListService);
		for(int i=0;i<cartsize;i++){
			CartViewVO sessionVO = spcart.get(i);
			if(sessionVO.getProdId().longValue() == getCartProdId().longValue()){
								
				spcart.remove(i);				
				
				break;
			}
		}
		session.put("whishList", spcart);
		
		for(WhishListsModel wList: wishList){
			if(wList.getProductModel().getProductId().longValue() == getCartProdId().longValue()){
				
				wishListService.deleteWishListItem(wList.getWhishListId());
				break;
			}
		}
		
		
		
		}
		return SUCCESS;
	}
	
	
	private boolean isThisProductAdded(List<CartViewVO> list) {
		for (CartViewVO cvo : list) {
			if (cvo.getProdId().longValue() == wishVO.getProdId().longValue())
				return true;
		}
		return false;
	}
	
	private boolean isThisProductAdded1(List<CartViewVO> list) {
		for (CartViewVO cvo : list) {
			if (cvo.getProdId().longValue() == cartProdId.longValue())
				return true;
		}
		return false;
	}

	public CartViewVO getWishVO() {
		return wishVO;
	}

	public void setWishVO(CartViewVO wishVO) {
		this.wishVO = wishVO;
	}

	public Long getCartProdId() {
		return cartProdId;
	}

	public void setCartProdId(Long cartProdId) {
		this.cartProdId = cartProdId;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public WishListService getWishListService() {
		return wishListService;
	}

	public void setWishListService(WishListService wishListService) {
		this.wishListService = wishListService;
	}

	public String getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}


}
