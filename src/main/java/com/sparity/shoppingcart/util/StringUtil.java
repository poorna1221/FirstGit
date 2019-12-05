/**
 * 
 */
package com.sparity.shoppingcart.util;
import java.util.TreeMap;
import java.security.MessageDigest;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.*;

import org.apache.commons.lang.StringUtils;

/**
 * @author Administrator
 *
 */
public class StringUtil {
	public static String htmlSpecialChars(final String src) {
		return htmlSpecialChars(new StringBuffer(src)).toString();
	}
	/**
	 * Convert html special charectors.
	 * @param src Source.
	 * @return Changed String.
	 */
	public static StringBuffer htmlSpecialChars(final StringBuffer src) {
		if (src == null) {
			return null;
		}
		int srcLength = src.length();
		
		for (int i = 0; i < srcLength; i++) {
			switch (src.charAt(i)) {
			case '<' :
				src.replace(i, i + 1, "&lt;");
				srcLength += 3;
				i += 3;
				break;
			case '>' :
				src.replace(i, i + 1, "&gt;");
				srcLength += 3;
				i += 3;
				break;
			case '&' :
				src.replace(i, i + 1, "&amp;");
				srcLength += 4;
				i += 4;
				break;
			case '"' :
				src.replace(i, i + 1, "&quot;");
				srcLength += 5;
				i += 5;
				break;
			case '\'' :
				src.replace(i, i + 1, "&#039;");
				srcLength += 5;
				i += 5;
				break;
			default :
				break;
			}
			if (i > 0 && src.charAt(i - 1) == ' ' && src.charAt(i) == ' ') {
				src.replace(i - 1, i, "&nbsp;");
				src.replace(i + 5, i + 6, "&nbsp;");
				srcLength += 10;
				i = i + 10;
			}
		}
		return src;
	}
	
	public static String getHtmlOutCode(String str,String defaultValue) {
		if(str==null)
			return defaultValue;
		else
			return str;
	}
	public static String getHtmlDropDownCode(String selected, 
			String defaultSelect, 
			TreeMap values) {
		StringBuffer htmlCode = new StringBuffer("");	   
		String[] keys = new String[values.size()];	   
		values.keySet().toArray(keys);
		String selectValue = defaultSelect;
		if(selected!=null && selected.length()>0) selectValue = selected;
		for (int i = 0; i < keys.length; i++) {
			if(selectValue.equalsIgnoreCase(keys[i]))
				htmlCode.append("<option selected value='"+keys[i]+"'>"+values.get(keys[i])+"</option>");
			else
				htmlCode.append("<option value='"+keys[i]+"'>"+values.get(keys[i])+"</option>");
		}
		return htmlCode.toString();
	}   
	public static String getHtmlDropDownCode(String selectName, 
			String selected, 
			String defaultSelect, 
			TreeMap values) {
		StringBuffer htmlCode = new StringBuffer("");
		htmlCode.append("<select name='"+selectName+"'>");
		htmlCode.append(getHtmlDropDownCode(selected,defaultSelect,values));
		htmlCode.append("</select>");
		return htmlCode.toString();
	}
	public static String getToString(Object object) {
		StringBuffer buffer = new StringBuffer("");
		Method[] methods = object.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			try {
				String methodName = methods[i].getName();
				if(methodName.startsWith("get") && !methodName.equals("getToString")){
					String result = "";
					try {
						result = (methods[i].invoke(object,null)).toString();
					} catch (Exception e) {}
					if(result==null) result = "";
					buffer.append(methodName+"="+result+"\n");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}
	public static String trim(String bigString, int limit) {
		if(bigString==null) return null;
		int newLimit = (limit<bigString.length()?limit:bigString.length());
		if(newLimit<limit) return bigString;
		
		StringBuffer trimmedString = new StringBuffer(bigString.substring(0,newLimit));
		trimmedString.append("...");
		return trimmedString.toString();
	}
	public static String getIds(Vector ids) {
		if(ids.size()==0) return " ";
		StringBuffer idString = new StringBuffer();
		idString.append(ids.get(0));
		for(int i=1;i<ids.size();i++) { 
			idString.append(","+ids.get(i));
		}
		return idString.toString();
	}
	public static String getNumberTag(int inNumber) {
		String tag = "";
		if (inNumber==1 || (inNumber>20 && inNumber%10==1)) {
			tag = "st";
		} else if (inNumber==2 || (inNumber>20 && inNumber%10==2)) {
			tag = "nd";
		} else if (inNumber==3 || (inNumber>20 && inNumber%10==3)) {
			tag = "rd";
		} else {
			tag = "th";
		}
		return tag;
	}
	
	public static int getPromotionCode(String userId,String friendMailId, String time) {
		String code = userId+friendMailId+time;
		int promotionCode = Math.abs(code.hashCode()); 
		return promotionCode;
	}
	public static final String getMD5Code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] byt = str.getBytes();
            md.update(byt);
            byte [] digBytes = md.digest();
            StringBuffer hexStr = new StringBuffer();
            for (int i=0; i<digBytes.length; i++) {
                byte tempbyte = digBytes[ i ];
                String s;
                if (tempbyte >= 0 && tempbyte <= 0xF) {
                    s = "0" + Integer.toHexString(0xF & tempbyte);
                } else {
                    s = Integer.toHexString(0xFF & tempbyte);
                }
                hexStr.append(s);
            }
            return hexStr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static String getSubString(String str,char c) {
		if(str==null) return "";
		return str.substring(0,str.indexOf(c));
	}
	public static String getSubString(String str,char c,char c1) {
		if(str==null) return "";
		if(str.indexOf(c)==-1) return "";
		if(str.indexOf(c1)==-1) return "";
		return str.substring(str.indexOf(c)+1,str.indexOf(c1));		 
	}
	
	public static String getOnlyNumerics(String str) {
	    
	    if (str == null) {
	        return null;
	    }

	    StringBuffer strBuff = new StringBuffer();
	    char c;
	    
	    for (int i = 0; i < str.length() ; i++) {
	        c = str.charAt(i);	        
	        if (Character.isDigit(c)) {
	            strBuff.append(c);
	        }
	    }
	    return strBuff.toString();
	}

	public static Boolean isEmail(String email){
		
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();

		if(matchFound){
			return true;
		}else{
			return false;
		}
		
	}	
	
	public static boolean isFieldBlank(String value){
		boolean isBlank = false;
		
		if(value==null || StringUtils.isBlank(value)){
			isBlank = true;
		}
		
		return isBlank;
	}
	
	public static int getIntFromBoolean(Boolean value){
		int boolVal=0;
		if(value==null){
			boolVal=0;
		}else if(value.booleanValue()){
			boolVal = 1;
		}
			
		return boolVal;
	}
	
	public static String filterWildCardString(String value){
		return replaceCharacter(value,'*','%');
	}
	
	public static String replaceCharacter(String value,char oldCh, char newCh){
		if(value!=null){
			return value.replace(oldCh,newCh);
		}else
			return "";
	}
	
	
}
