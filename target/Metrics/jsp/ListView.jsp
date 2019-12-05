<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<title> :: PARAS | List View :: </title>
<style type="text/css">

</style>
<link href="css/Style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		//console.log(<s:property value="currentPage"/>);
		jQuery("#page_"+<s:property value="currentPage"/>).addClass("active_tnt_link");
		
		<s:if test="%{firsthide}">
		jQuery("#firstId").attr('disabled');
		</s:if>
		
	});
</script>

<link rel="stylesheet" type="text/css" href="css/jkmegamenu.css" />

<script type="text/javascript" src="js/jkmegamenu.js"></script>

<script type="text/javascript">

	jkmegamenu.definemenu("megaanchor01", "megamenu1", "mouseover")
	jkmegamenu.definemenu("megaanchor02", "megamenu2", "mouseover")
	jkmegamenu.definemenu("megaanchor03", "megamenu3", "mouseover")
	jkmegamenu.definemenu("megaanchor04", "megamenu4", "mouseover")
	jkmegamenu.definemenu("megaanchor05", "megamenu5", "mouseover")
	jkmegamenu.definemenu("megaanchor06", "megamenu6", "mouseover")
	jkmegamenu.definemenu("megaanchor07", "megamenu7", "mouseover")
	
</script>

</head>

<body>



<div id="g1">

  <div class="wrapper">
    	
    	<s:if test="%{#session.user!=null}">
    	   <div class="topLine">   Hello, <strong><s:property value="%{#session.user.userEmailId}"/></strong>&nbsp; &nbsp;&nbsp;&nbsp; <a href='<s:url action="SignOut"/>'>Sign out</a>&nbsp;| Help&nbsp; | Customer Care&nbsp; | <a href='<s:url action="myaccount"/>'>My account</a> &nbsp;&nbsp;</div>
        </s:if>
		<s:else>
		  <div class="topLine">   Hello, <strong>Guest</strong>&nbsp; &nbsp;&nbsp;&nbsp; <a href='<s:url action="Signin"/>'>Sign in</a>&nbsp;| Help&nbsp; | Customer Care&nbsp; | <a href='<s:url action="Signin"/>'>My account</a> &nbsp;&nbsp;</div>
		</s:else>
        <div class="header">
        	<div class="logo left"><a href="showHompePage"><img src="images/logo.png" alt=""/></a></div>
			<div class="logoTxt left"><img src="images/logo_text.png" alt="" /></div>
            <div class="headerPh right">
            	<p style="font-weight:bold">ORDER BY PHONE</p>
                <p>+91 - 8790611965</p>
          </div>
          <div class="topCart right">
	          <s:if test="%{#session.totalItems!=null && #session.totalItems>0}">
			  	<a href="showCart">My Cart ( <s:property value="%{#session.totalItems}"/> )</a>
			  </s:if>
			  <s:elseif test="%{#session.totalItems==0}">
					<a href="showCart">My Cart( Empty )</a>
			  </s:elseif>
	          <s:else>
	          	<a href="showCart">My Cart( Empty )</a>
	          </s:else>
		  </div>
    </div>
        <div class="menuBar">
        	<ul id="solidmenu" class="solidblockmenu">
            <li><a href="showHompePage">Home</a></li>
              <li><a href="#">About Us</a></li>
              <li><a href="#" id="megaanchor01">Mobiles</a></li>
              <li><a href="#" id="megaanchor02" >Cameras</a></li>
              <li><a href="#" id="megaanchor03" >Electronics</a></li>
              <li><a href="#" id="megaanchor04">Computers</a></li>
              <li><a href="#" id="megaanchor05">Accessories</a></li>
              <li><a href="#" id="megaanchor06">Tripod</a></li>
              <li><a href="#" id="megaanchor07">Gifts</a></li>
            </ul>
        </div>
        
        <div class="clear"></div>
        
       
       
       <div class="contentWrapper"> 
	     
         <div class="filterLeft left">
         
         <div class="filtType">
                <div class="filtHeader">Categories</div> 
                <div class="filtBox">
                  <p><a href="#">Digital Cameras</a></p>
                   <p><a href="#">Digital SLR</a></p>
                    <p><a href="#">Cam Corders</a></p>
                </div>  
           </div>
         
         	<div class="filtType">
                <div class="filtHeader">Brand Name</div> 
                <div class="filtBox">
                  <p><a href="#">Nokia</a></p>
                   <p><a href="#">Sony</a></p>
                    <p><a href="#">Samsung</a></p>
                     <p><a href="#">Alcatel</a></p>
                      <p><a href="#">Motorolo</a></p>
                </div>  
            </div>
            
            <div class="filtType">
                <div class="filtHeader">Price</div> 
                <div class="filtBox">
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
                </div>  
            </div>      
     
            <div class="filtType">
                <div class="filtHeader">Availability</div> 
                <div class="filtBox">
                  <p>&nbsp;</p>
                 
                        <input type="checkbox" name="InStock" value="checkbox" id="InStock10_0">
                        InStock ( 10 )
                  <p></p>
                  <p>&nbsp;</p>
                </div>  
            </div>
            
            
            
         </div> 
         
         <div class="gridView right">
           <p>
           		<span class="headerBlue"><!--Paras > Cameras ></span> <span class="headerRed">Digital Cameras</span>
                    <div class="grdWishLst right"><a href="#">Add to Wishlist</a></div>
                    <div class="compare right"><a href="#">Compare</a></div>   -->         
           </p>
           <p>&nbsp;</p>
           <div class="gridHeader"><!--Showing <span class="headerBlue">1 to 16</span> of <span class="headerBlue">100</span> results for <span class="headerBlue">Digital Cameras </span> -->
          
           <div class="compare right"><a href="#">Compare</a></div>
           <div class="gridBut right"><a href='<s:url action="ProductGrid"/>'>Grid View</a></div>
           <div class="listBut right"><a href="#">List View</a></div>
           </div>
		   
           <div class="displayArea">
           
            <s:iterator value="productModelList"> 
            
               <div class="listBox">
               		 <s:url id="testUrlId2" value="productSpec.action">
                                               <s:param name="imageId" value="%{impagePath}" />
                                                <s:param name="prodId" value="%{productId}" />
                                  </s:url>
                    <div class="listImg"><s:a id="previousId" href="%{testUrlId2}"><img src='images/<s:property value="impagePath"/>' alt="" width="127" height="97" /></s:a></div>
                    <div class="listCont right">
                    	<p class="lstPrdName"><s:property value="productName"/></p>
                        <p>&nbsp;</p>
                        <p class="">Price : -<span class="red"> &nbsp;Rs.<!-- <s:property value="mrpPrice"/>-->
                            <s:property value="getText('{0,number,#,##0.00}',{mrpPrice})"/> 
                        </span> <span class="grey"> with </span><span class="green">Free Shipping</span></p>
                        <p>&nbsp;</p>
                        <p>Delivered in 3-4 working days.  Pay Cash on Delivery </p>
                        <p>&nbsp;</p>
                        <!-- <div class="lstDescBox">
                        	Free 4GB SDHC + Battery Charger + Case + Use GC 'GC39PU51P1PT' and get additional Rs. 250/- off during check out
                        </div> -->
                        <!-- <div class="lstBuyNow right"><a href="#">BUY NOW</a></div> -->
                    </div>
                    
                   <!--  <div class="listOffer">60% off</div> -->
                    
                    <div class="chkBoxList"><input type="checkbox" name="gridCompare" value="checkbox" id="gridCompare_0"></div>
                    
               </div>
               
              </s:iterator> 
        

           </div>
           
         </div>

   	   </div>  
	   
	   <div id="tnt_pagination">
		    <s:if test="%{show}">
				<s:if test="%{firsthide}">
				   <s:url id="testUrlId1" value="ProductList.action">
						<s:param name="pageNumbers" value="%{'0'}" />
				   </s:url>
				   <s:a id="firstId" href="%{testUrlId1}">&lt;&lt;First</s:a>&nbsp;&nbsp;
				   
				   <s:url id="testUrlId2" value="ProductList.action">
						<s:param name="pageNumbers" value="%{previousPage}" />
				   </s:url>
				   <s:a id="previousId" href="%{testUrlId2}">&lt;Previous</s:a>&nbsp;&nbsp;
			   </s:if>
			   <s:else>
			       <span class="hideButtons">&lt;&lt;First&nbsp;&nbsp;</span>
				   <span class="hideButtons">&lt;Previous&nbsp;&nbsp;</span>
			   </s:else>
		  
				
				  <s:iterator value="showPageList" >
					  <s:url id="testUrlId5" value="ProductList.action">
							<s:param name="pageNumbers" value="%{pageNumber}" />
					  </s:url>
					
					 <s:if test="%{currentPage==pageNumber1}">
					    <span id='page_<s:property value="pageNumber1"/>' class="activeSelectClass">
						   <s:property value="pageNumber1"/>
						 </span>
					 </s:if>
					 <s:else>
					 <s:a href="%{testUrlId5}">					    
						<s:property value="pageNumber1"/>						
					 </s:a>
					 </s:else>
					 
					
				  </s:iterator>
          
			<s:if test="%{lasthide}">
				  <s:url id="testUrlId3" value="ProductList.action">
						<s:param name="pageNumbers" value="%{nextPage}" />
				   </s:url>
				   
				   <s:a href="%{testUrlId3}">Next&gt;</s:a>&nbsp;&nbsp; 
				   
				   <s:url id="testUrlId4" value="ProductList.action">
						<s:param name="pageNumbers" value="%{lastPage}" />
				   </s:url>
				   
				   <s:a href="%{testUrlId4}">Last&gt;&gt;</s:a>&nbsp;&nbsp;
			 </s:if>
			 <s:else>
			       <span class="hideButtons">Next&gt;&nbsp;&nbsp; </span>
				   <span class="hideButtons">Last&gt;&gt;&nbsp;&nbsp;</span>
			       
			   </s:else>
		   </s:if>
		    
		   </div>
              
  </div>
      
</div>

<div id="megamenu1" class="megamenu">

		<div class="ddown01">
			<s:iterator value="#application.brandList" status="mbstat">
             <s:if test="#mbstat.count<=4">
				<div class="row01">

					 <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.mobileCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 
					 <!--<div class="ddCaption"><s:property value="brandName"/></div> -->
					 
				</div>
			 </s:if>
			</s:iterator>
			
		</div>
		
			<div class="ddown02">

			<s:iterator value="#application.brandList" status="mbstat">
			<s:if test="(#mbstat.count>=5)&&(#mbstat.count<=12)">
				<div class="row02">
					<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.mobileCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
					<p>&nbsp;</p>
				</div>
			  </s:if>
            </s:iterator>

			 
			</div>

			<div class="ddown03">
			<div class="row03">
			<s:iterator value="#application.prodctTypeList" status="mbstat" >
			<s:if test="#mbstat.count<=3">
				<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
				<s:if test="#mbstat.count<3">
				|
				</s:if>
				
			</s:if>
				<s:if test="#mbstat.last==true">
			<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">
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
			  <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.cameraCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a>  
	        	
			
            <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       	</s:if>
	</s:iterator>
    </div>
    
    <div class="ddown02">
	    <s:iterator value="#application.cambrandList" status="camstatus">
		    
		    <s:if test="(#camstatus.count>=5)&&(#camstatus.count<=12)">
		         <div class="row02">
		         	<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.cameraCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
		            <p>&nbsp;</p>
		         </div>
		    </s:if>
	     </s:iterator>    
    </div>
    
    <div class="ddown03">
    <% int ptypecount=0;%>
	    <div class="row03">
		    <s:iterator value="#application.camprodctTypeList" status="camstat">
		    	<s:if test="#camstat.count<=3">
		    		<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
		    			<s:if test="#camstat.count<3">
		    				|
		    			</s:if>
		    	</s:if>
		    	<s:if test="#camstat.last==true">
						<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Cameras</a></div>
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
				 <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.elcCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a>  
	        	<!-- <a href="showBrandProds?brandId=<s:property value='brandId'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=""/></a> -->
	            <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
	        </div>
	        </s:if>
        </s:iterator>  		
    </div>
    <div class="ddown02">
    	<s:iterator value="#application.elcbrandList" status="elstatus">
    		<s:if test="#(elstatus.count>=5)&&(elstatus.count<=12)">
	         <div class="row02">
	         	<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.elcCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
	            <p>&nbsp;</p>
	         </div>
	        </s:if>
         </s:iterator>
    </div>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.elcprodctTypeList" status="elstatus">
	    	<s:if test="#elstatus.count<=3">
    		<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
    		<s:if test="#elstatus.count<3">
    		|
    		</s:if>
    		<s:if test="#elstatus.last==true">
    		<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Items </a></div>
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
                 <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.compCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
    <div class="ddown02">
    	<s:iterator value="#application.compbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.compCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.compprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Computers </a></div>
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
                 <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.accessorisCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
    <div class="ddown02">
    	<s:iterator value="#application.accbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.accessorisCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.accprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Accessories </a></div>
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
                 <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.trypodCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
    <div class="ddown02">
    	<s:iterator value="#application.trypodbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.trypodCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.trypodprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Trypods </a></div>
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
                 <a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.giftCategory'/>"><img src="images/brand Logos/<s:property value='brandImpage'/>" alt=" "/></a> 

	        	    <!-- <div class="ddCaption"><s:property value="brandName"/></div>  -->
        </div>
       </s:if>
        </s:iterator>
    </div>
    <div class="ddown02">
    	<s:iterator value="#application.giftbrandList" status="comstatus">
    	<s:if test="#comstatus.count>=5">
         <div class="row02">
         	<p><a href="showBrandProds?fromWhichList=brandNamesDiv&brandId=<s:property value='brandId'/>&categoryId=<s:property value='#application.giftCategory'/>"><strong><s:property value="brandName"/></strong></a></p>
            <p>&nbsp;</p>
         </div>
         </s:if>
         </s:iterator>
    </div>
    <div class="ddown03">
	    <div class="row03">
	    	<s:iterator value="#application.giftprodctTypeList" status="comstat">
	    	<s:if test="#comstat.count<=3">
    		<a href="showAllProducttypes.action?fromWhichList=productTypeList&&prodTypeId=<s:property value='prodTypeId'/>"><strong><s:property value="prodTypeName"/></strong></a>
    		</s:if>
			<s:if test="#comstat.count<3">   		
			|
    		</s:if> 
    		<s:if test="#comstat.last==true">
    		<div class="more right"><a href="showAllCategoryProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>"  class="linkBold">All Gifts </a></div>
    		</s:if>
    		</s:iterator>
        </div>
    </div>

</div>

<div id="b1">
	<div class="botWrapper">
     
      <div class="credit left">Designed and Developed by Sparity Soft Technologies Pvt Ltd</div>
    </div>
     
</div>





</body>
</html>
