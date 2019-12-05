package com.sparity.shoppingcart.util;

import java.text.DecimalFormat;
import java.util.List;

import com.sparity.shoppingcart.view.CartViewVO;

public class CartUtil {
	public static Object[] calculateMyCartSummary(List<CartViewVO> cart) {
		double totalAmount = 0;
		int itemsCount = 0;
		for (CartViewVO list : cart) {
			itemsCount ++;
			
			if (list.getQuantity()>1) {
				totalAmount += list.getQuantity()*list.getPrice();
			} else {
				totalAmount += list.getPrice();
			}
			
		}
		DecimalFormat priceFormatter = new DecimalFormat("#0.00");
		return new Object[] { itemsCount, priceFormatter.format(totalAmount) };
	}
	
	
	public static Double getOriginalPrice(Double mrpPrice,Double offerPrice){
		if(offerPrice!=null){
			if(offerPrice.doubleValue() == mrpPrice.doubleValue()){
				return mrpPrice;
			} else {
				return offerPrice;
			}
		} else {
			return mrpPrice;
		}
		
	}
	
}
