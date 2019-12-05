<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> :: PARAS | My Account - Change Password :: </title>

<style type="text/css">
.errors {
	background-color:#FFE3D5;
	border:2px solid #CC0000;
	width:600px;
	margin-bottom:8px;
    font-size:16px;
	
	}
.successMessage  {
  
    background-color: #EFFEE1;
    border: 1px solid #9AFF38;
    border-radius: 2px 2px;
    font-size: 18px;
    list-style: none outside none;
    margin-bottom: 10px;
    padding: 5px;
    width:660px;
	}

</style>
<link href="css/Style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/jkmegamenu.css" />

<script type="text/javascript" src="js/jkmegamenu.js"></script>

<script type="text/javascript">
function checkedValues(){
         
		 var x=document.forms["changepasswordform"].elements["oldpassword"].value;	 
		   if(x==null || x=="")
		   {  
			   alert(' Enter Your Password');  
			   return false;
			}
		 
		 var y=document.forms["changepasswordform"].elements["newpassword"].value;	 
		   if(y==null || y=="")
		   {  
			   alert(' Enter Your  New Password');  
			   return false;
			}
		        else if(y.match(/^\s*$/))
	        {	
		     alert('spaces are not allowed');
		     return false;
			}		
			
			else if(y.length<6 || y.length>15)
			{
			alert('password must contain atleast 6 chartacters maximum 15 characters');
			return false;
			}
		 var z=document.forms["changepasswordform"].elements["confirmPassword"].value;	 
		   if(z==null || z=="")
		   {  
			   alert(' Enter confirm Password');  
			   return false;
			} 
			   
			   var b=document.getElementById("newpassword");                          
			   var c=document.getElementById("confirmPassword");
			 
			     if(b.value!=c.value)
			     	{
					alert('passwordS dont match.Please EnterCorrectPassword');
					return false;
					 
					}
		 
		 
		 
       document.forms["changepasswordform"].submit();
}

</script>




<script type="text/javascript">

	jkmegamenu.definemenu("megaanchor01", "megamenu1", "mouseover")
	jkmegamenu.definemenu("megaanchor02", "megamenu2", "mouseover")
	jkmegamenu.definemenu("megaanchor03", "megamenu3", "mouseover")
	jkmegamenu.definemenu("megaanchor04", "megamenu4", "mouseover")
	jkmegamenu.definemenu("megaanchor05", "megamenu5", "mouseover")
	jkmegamenu.definemenu("megaanchor06", "megamenu6", "mouseover")
	jkmegamenu.definemenu("megaanchor07", "megamenu7", "mouseover")
	jkmegamenu.definemenu("megaanchor08", "megamenu8", "mouseover")
	jkmegamenu.definemenu("serviceAnchor", "serviceMenu", "mouseover")
	
</script>

</head>

<body>



<div id="g1">

  <div class="wrapper">
    	
    	<s:if test="%{#session.user!=null}">
    	   <div class="topLine">   Hello, <strong><s:property value="%{#session.user.userEmailId}"/></strong>&nbsp; &nbsp;&nbsp;&nbsp; <a href='<s:url action="SignOut"/>'>Sign out</a>&nbsp;| <a href="contactUs"> Contact us</a> &nbsp; | <a href='<s:url action="myaccount"/>'>My account</a> &nbsp;&nbsp;| <a href="aboutUs">About Us</a> &nbsp;&nbsp;</div>
        </s:if>
		<s:else>
		  <div class="topLine">   Hello, <strong>Guest</strong>&nbsp; &nbsp;&nbsp;&nbsp; <a href='<s:url action="Signin"/>'>Sign in</a>&nbsp;|<a href="contactUs"> Contact us</a> &nbsp; | <a href='<s:url action="Signin"/>'>My account</a> &nbsp;&nbsp;| <a href="aboutUs">About Us</a> &nbsp;&nbsp;</div>
		</s:else>
        <div class="header">
        	<div class="logo"><a href="showHomePage"><img src="images/logo.png" alt=""/></a></div>
            <div class="logoTxt1 left"><img src="images/logo_text.png" alt="" /></div>
            <div class="headerPh right">
            	<p style="font-weight:bold">ORDER BY PHONE</p>
                <p>+91 - 8790611965</p>
          </div>
          <div class="topCart right">
          <s:if test="%{#session.totalItems!=null && #session.totalItems>0}">
		  	<a href="showCart">My Cart (<s:property value="%{#session.totalItems}"/>)</a>
		  </s:if>
		  <s:elseif test="%{#session.totalItems==0}">
				<a href="showCart">My Cart (Empty)</a>
		  </s:elseif>
          <s:else>
          	<a href="showCart">My Cart (Empty)</a>
          </s:else>
		  </div>
    </div>
         <div class="menuBar">
        	<ul id="solidmenu" class="solidblockmenu">
              <!-- <li><a href="aboutUs">About Us</a></li> -->
			  <s:iterator value="#application.prodctTypeList" status="mbstat">
			  <s:if test="#mbstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor01">Mobiles</a></li></s:if></s:iterator>
			  <s:iterator value="#application.camprodctTypeList" status="camstat">
			  <s:if test="#camstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor02" >Cameras</a></li></s:if></s:iterator>
               <s:iterator value="#application.camprodctTypeList" status="camstat">
			  <s:if test="#camstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor08" >Lenses</a></li></s:if></s:iterator>
			  <s:iterator value="#application.elcprodctTypeList" status="elstatus">
			  <s:if test="#elstatus.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor03" >Electronics</a></li></s:if></s:iterator>
			  <s:iterator value="#application.compprodctTypeList" status="comstat">
			  <s:if test="#comstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor04">Computers</a></li></s:if></s:iterator>
			  <s:iterator value="#application.accprodctTypeList" status="comstat">
			  <s:if test="#comstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor05">Accessories</a></li></s:if></s:iterator>
			  <s:iterator value="#application.trypodprodctTypeList" status="comstat">
			  <s:if test="#comstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor06">Tripods</a></li></s:if></s:iterator>
			  <s:iterator value="#application.giftprodctTypeList" status="comstat">
			  <s:if test="#comstat.last==true">
              <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>" id="megaanchor07">Gifts</a></li></s:if></s:iterator>
			  <li><a href="#" id="serviceAnchor">Services</a></li>
            </ul>
        </div>
        
        <div class="clear"></div>
        
       
       
       <div class="contentWrapper"> 
			<div class="accSettingsList">
				<p class="blueHeadingH2">My Account            	</p>
				<div class="settingList">
       	     <s:if test="%{#session.user!=null}">              
				<p><a href= '<s:url action="changepassword"/>'>Change Password</a></p>
				</s:if>
				<s:else>
				<p><a href= '<s:url action="Signin"/>'>Change Password</a></p>
				</s:else>
               	 <p>&nbsp;</p>
               	     <a href="showCart">
			 In the Cart<s:if test="%{#session.totalItems!=null && #session.totalItems>0}">
			 <s:if test="%{#session.totalItems==1}">
			 (<s:property value="%{#session.totalItems}"/>&nbspitem)
			 </s:if>
			 <s:else>
            (<s:property value="%{#session.totalItems}"/>&nbspitems)
			</s:else>
		  </s:if>
		  <s:elseif test="%{#session.totalItems==0}">
			(Empty)
		  </s:elseif>
		  <s:else>
		   (Empty)
		  </s:else>
			 </a> 
			 <p>&nbsp;</p>
				   <p><a href="showWhishList.action">View Wishlist</a></p>
				   
	<p>&nbsp;</p>
            		<p><a href= '<s:url action="orderHistory"/>'>OrderHistory</a></p>			   
				   
		<p>&nbsp;</p>
				   	<p><a href= '<s:url action="personaldetails"/>'>PersonalDetails</a></p>
		
				   
            	</div>
</div>
            
         <div class="rtContArea right">
       	   
       	  <s:actionerror cssClass="errors" />
       <s:actionmessage cssClass="successMessage" />
	  
	  <s:form id="changepasswordform"  action="ChangePasswordmethod" method="post" >     


		 <p>&nbsp;</p>
       	   <p class="blueHeadingH1"> Change Password</p>
       	   <p>&nbsp;</p>
       	 
    		 <table >
             <tr>
               <td class="tblChgPass01">Email Address :</td>
               <td class="tblChgPass02"><s:property value="%{#session.user.userEmailId}"/></td>
             </tr>
             
             <tr>
               <td class="tblChgPass01">Old Password :</td>
 <td class="tblChgPass02"><input class="txtBox" type="password"  id="oldpassword" name="userAccountViewBean.userPasword" /></td>              
             </tr>
            
    			<tr>
               <td class="tblChgPass01">New Password :</td>
<td class="tblChgPass02"><input class="txtBox" type="password" id="newpassword" name="userAccountViewBean.NewPassword" /></td>              
             </tr>
             <tr>
               <td class="tblChgPass01">Confirm Password :</td>
               <td class="tblChgPass02"><input class="txtBox" type="password" id="confirmPassword" /></td>              
             </tr>
           </table>
          
        	  
           <p>&nbsp;</p>
           <div class="submitBut buttonChgPass"><a href="#" onclick="checkedValues();">Change Password</a></div>
          <div class="submitBut buttonChgPass"><a href='<s:url action="cancel" />' >Cancel</a></div>
           <p>&nbsp;</p>
         </s:form>
		
		 </div>
            
    </div>  
              
  </div>
      
</div>

<div id="megamenu1" class="megamenu">

		<div class="ddown01">
			<s:iterator value="#application.brandList" status="mbstat">
             <s:if test="#mbstat.count<=4">
				<div class="row01">

					 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.mobileCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 
					 <!--<div class="ddCaption"><s:property value="brandName"/></div> -->
					 
				</div>
			 </s:if>
			</s:iterator>
			
		</div>
		<s:if test="#application.brandList.size>4">
			<div class="ddown02">

			<s:iterator value="#application.brandList" status="mbstat">
			<s:if test="(#mbstat.count>=5)&&(#mbstat.count<=12)">
				<div class="row02">
					<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.mobileCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
					<p>&nbsp;</p>
				</div>
			  </s:if>
            </s:iterator>

			 
			</div>
        </s:if>
			<div class="ddown03">
			<div class="row03">
			<s:iterator value="#application.prodctTypeList" status="mbstat" >
			<s:if test="#mbstat.count<=3">
				<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
				<s:if test="#mbstat.count<3">
				|
				</s:if>
				
			</s:if>
				<s:if test="#mbstat.last==true">
			<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">
			All Mobiles </a></div>
				</s:if>
			
			
			</s:iterator>
			
			</div>
			
			
    </div>

	</div>

	
<!-- </div>  -->
<!--/***********************************************************************************************/-->

<div id="megamenu2" class="megamenu">
	
	<div class="ddown01">
	<s:iterator value="#application.cambrandList" status="camstatus">
	<s:if test="#camstatus.count<=4">
    	<div class="row01">
        	<!-- <a href="showBrandProds?brandId=<s:property value='brandId'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> -->
			  <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.cameraCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a>  
	        	
			
            <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       	</s:if>
	</s:iterator>
    </div>
    <s:if test="#application.cambrandList.size>4">
    <div class="ddown02">
	    <s:iterator value="#application.cambrandList" status="camstatus">
		    
		    <s:if test="(#camstatus.count>=5)&&(#camstatus.count<=12)">
		         <div class="row02">
		         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.cameraCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
		            <p>&nbsp;</p>
		         </div>
		    </s:if>
	     </s:iterator>    
    </div>
    </s:if>
    <div class="ddown03">
    <% int ptypecount=0;%>
	    <div class="row03">
		    <s:iterator value="#application.camprodctTypeList" status="camstat">
		    	<s:if test="#camstat.count<=3">
		    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
		    			<s:if test="#camstat.count<3">
		    				|
		    			</s:if>
		    	</s:if>
		    	<s:if test="#camstat.last==true">
						<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Cameras</a></div>
				</s:if>
				
	        </s:iterator>
       </div>
    </div>

</div>

<!--/***********************************************************************************************/-->

<div id="megamenu3" class="megamenu">
	<div class="ddown01">
		<s:iterator value="#application.elcbrandList" status="elstatus">
			<s:if test="#elstatus.count<=4">
	    	<div class="row01">
				 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.elcCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a>  
	        	<!-- <a href="showBrandProds?brandId=<s:property value='brandId'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=""/></a> -->
	            <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
	        </div>
	        </s:if>
        </s:iterator>  		
    </div>
	 <s:if test="#application.elcbrandList.size>4">
    <div class="ddown02">
    	<s:iterator value="#application.elcbrandList" status="elstatus">
    		<s:if test="#(elstatus.count>=5)&&(elstatus.count<=12)">
	         <div class="row02">
	         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.elcCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
	            <p>&nbsp;</p>
	         </div>
	        </s:if>
         </s:iterator>
    </div>
	</s:if>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.elcprodctTypeList" status="elstatus">
	    	<s:if test="#elstatus.count<=3">
    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
    		<s:if test="#elstatus.count<3">
    		|
    		</s:if>
    		<s:if test="#elstatus.last==true">
    		<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Items </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>

<!--/***********************************************************************************************/-->

<div id="megamenu4" class="megamenu">
	<div class="ddown01">
		<s:iterator value="#application.compbrandList" status="comstatus">
		<s:if test="#comstatus.count<=4">
    	<div class="row01">
                 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.compCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
	<s:if test="#application.compbrandList.size>4">
    <div class="ddown02">
    	<s:iterator value="#application.compbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.compCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
	</s:if>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.compprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Computers </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>



<!--/***********************************************************************************************/-->

<div id="megamenu5" class="megamenu">
	<div class="ddown01">
		<s:iterator value="#application.accbrandList" status="comstatus">
		<s:if test="#comstatus.count<=4">
    	<div class="row01">
                 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.accessorisCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
	<s:if test="#application.accbrandList.size>4">
    <div class="ddown02">
    	<s:iterator value="#application.accbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.accessorisCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
	</s:if>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.accprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Accessories </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>


<!--/***********************************************************************************************/-->

<div id="megamenu6" class="megamenu">
	<div class="ddown01">
		<s:iterator value="#application.trypodbrandList" status="comstatus">
		<s:if test="#comstatus.count<=4">
    	<div class="row01">
                 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.trypodCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
	<s:if test="#application.trypodbrandList.size>4">
    <div class="ddown02">
    	<s:iterator value="#application.trypodbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.trypodCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
	 </s:if>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.trypodprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Trypods </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>


<!--/***********************************************************************************************/-->

<div id="megamenu7" class="megamenu">
	<div class="ddown01">
		<s:iterator value="#application.giftbrandList" status="comstatus">
		<s:if test="#comstatus.count<=4">
    	<div class="row01">
                 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.giftCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
	<s:if test="#application.giftbrandList.size>4">
    <div class="ddown02">
    	<s:iterator value="#application.giftbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.giftCategory'/>"><s:property value="brandName"/></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
	</s:if>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.giftprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Gifts </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>

<!--/***********************************************************************************************/-->

<div id="megamenu8" class="megamenu">
	<div class="ddown01">
	
	<s:property value="lenseBrandList"/>
		<s:iterator value="#application.lenseBrandList" status="comstatus">
		<s:if test="#comstatus.count<=4">
    	<div class="row01">
                 <a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.lensCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
	<s:if test="#application.lenseBrandList.size>4">
    <div class="ddown02">
    	<s:iterator value="#application.lenseBrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandCategoryGridProds?brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.lensCategory'/>"><s:property value="brandName"/></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
	</s:if>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.lenseprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllGridProducttypes.action?prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Lenses </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>



<!--/***********************************************************************************************/-->

<div id="serviceMenu" class="servicemegamenu">
<s:iterator value="#application.albumTypeList" >
		
		<s:url id="albumTypeUrlId" value="myimages.action">
           <s:param name="albumType" value="%{albumType}" />  
		   <s:param name="albumTypeId" value="%{albumId}" />
        </s:url>
		<div class="serviceTab">
         	<p><b><a href="${albumTypeUrlId}"><s:property value="albumType"/></a></b></p>
		</div>
		      <input type="hidden" name="albumType" value='<s:property value="albumType"/>'/>
			  <input type="hidden" name="albumTypeId" value='<s:property value="albumId"/>'/>
			  
	</s:iterator>
</div>


<div id="b1">
	<!-- <div class="botWrapper"> -->
	<div class="botWrapper">
     

      <p class="footerCont left"><a href='<s:url action="showHomePage"/>'>Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="aboutUs">About Us</a>&nbsp; |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <a href='<s:url action="showWhishList.action"/>'>Wishlist</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='<s:url action="showCart"/>'>My Cart</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="contactUs">Contact Us</a></p>
     
     <p class="footerCont right">Designed and Developed by Sparity Soft Technologies Pvt Ltd</p>
    </div>
     </div>
       
<!--       </div> -->
<!--       <div class="credit left">Designed and Developed by Sparity Soft Technologies pvt ltd</div> -->
<!--     </div> -->
     
<!-- </div> -->



</body>
</html>
