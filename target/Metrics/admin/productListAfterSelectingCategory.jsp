<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-: Admin | Product List :-</title>
<style type="text/css">

.deleteclass{
  
    background-color: #99FF66;
   
    border-radius: 1px 1px;
    font-size: 18px;
    list-style: none outside none;
    margin-bottom: 10px;
    padding: 5px;
    width:800px;
    
    
} 
</style>
<script src="<%=request.getContextPath()%>/js/jquery-1.6.4.min.js" type="text/javascript"></script>

<script type="text/javascript">

function saveadmindetails(id)
{

//document.forms["adminform"].submit();
//jQuery("#prodForm").attr("action","adminaction.action");
// jQuery("#"+id).submit();

document.forms[id].submit();
}

</script>
<link href="Style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div id="g1">

	<div class="wrapper">
	  
      <div class="wrapper02">
        	
            <div class="logo"><a href="showHomePage"><img src="images/logo.png" alt=""/></a></div>
          <div class="topLinks right"><a href='<s:url action="logout"/>'>Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
<a href='<s:url action="myaccount"/>'>My account</a></div>
            
            <div class="contents">
            		
					
                   
                    
                    
                	<div class="leftCont left">
                   		 <p class="heading">Categories</p>	
                         <div class="leftBox">
                         	<ul>
                         		<s:iterator value="#application.prodctTypeList" status="mbstat">
                         		<s:if test="#mbstat.last==true">
                            	<li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Mobiles</a></li>
                            	</s:if>
                            	</s:iterator>
                            	 <s:iterator value="#application.camprodctTypeList" status="camstat">
								 <s:if test="#camstat.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Cameras</a></li>
                                 </s:if>
                            	</s:iterator>
                                 	<s:iterator value="#application.compprodctTypeList" status="comstat">
								 <s:if test="#comstat.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Computers</a></li>
								</s:if>
                                </s:iterator>
                              <s:iterator value="#application.elcprodctTypeList" status="elstatus">
							  <s:if test="#elstatus.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Electronics</a></li>
								</s:if>
                                </s:iterator>
                                	<s:iterator value="#application.accprodctTypeList" status="comstat">
									<s:if test="#comstat.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Accessories</a></li>
								</s:if>
                                </s:iterator>
								<s:iterator value="#application.giftprodctTypeList" status="comstat">
								<s:if test="#comstat.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Gifts</a></li>
								</s:if></s:iterator>
								<s:iterator value="#application.trypodprodctTypeList" status="comstat">
								<s:if test="#comstat.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Tripods</a></li>
								</s:if></s:iterator>
									<s:iterator value="#application.lenseprodctTypeList" status="comstat">
									<s:if test="#comstat.last==true">
                                <li><a href="showAllGridProducts.action?categoryId=<s:property value='categoryModel.categoryId'/>">Lens</a></li>
								</s:if></s:iterator>
                            </ul>
                         </div>
                	</div>
                   
                    <div class="mainCont left">
                     	<s:iterator value="brandProdList" status="comstat">
                     	<s:if test="#comstat.last==true">
                    	 <p class="heading"><s:property value="prodTypeModel.categoryModel.categoryName"/></p>	
                    	 </s:if>
                    	
                    	 </s:iterator>
                         <div class="rightBox">
                         <s:actionmessage cssClass="deleteclass"/> 
                      
                         
                          	<s:iterator value="brandProdList">
                          	
                      	
                          	   <form action="adminaction.action"  id="admin_<s:property value='productId'/>" method="post">
                         	<div class="itemslist">
                            	<div class="imgClass left">
                                
                                <img src="images/<s:property value='impagePath'/>"  width="144" height="112" alt="" />
                                </div>
                                <div class="listCont left">
                                	<table>
                                    	<tr>
                                        	<td>Brand Name : </td>
                                            <td><input  type="text"  class="txtBox" disabled="true"  value="<s:property value="brandModel.brandName"/>"  /></td>
                                            <td></td>
                                         </tr>   
                                         <tr>
                                            <td>Product Name : </td>
                                            <td><input  type="text"  class="txtBox"  disabled="true"    value="<s:property value="productName"/>"  /></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>MRP : </td>
                                            <td><input  type="text" id = "mrpPrice_<s:property value='productId'/>" style="width:150px;"     value="<s:property value="getText('{0,number,#,##0.00}',{mrpPrice})"/>" name="adminmrp"/></td>
                                            <td>in Rupees</td>
                                        </tr>
                                        <input type="hidden"  name="productid" value='<s:property value="productId"/>'/>
                                         <input type="hidden"  name="categoryId" value='<s:property value="prodTypeModel.categoryModel.categoryId"/>'/>
                                        <tr>
                                            <td>Offer Price :</td>
                                            <td><input  type="text"  id = "offerPrice_<s:property value='productId'/>" style="width:150px;"  value="<s:property value="getText('{0,number,#,##0.00}',{offerPrice})"/>"  name="adminoffer" /></td>
                                            <td>in Rupees</td>
                                        </tr>
                                    </table>
                                </div>
                                 <div class="listCont left">
                                 <p>  <a href="#" onclick="saveadmindetails('admin_<s:property value='productId'/>')">Save Product</a>    &nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;&nbsp;  <a href="deleteproduct.action?productid=<s:property value='productId'/>&&categoryId=<s:property value='prodTypeModel.categoryModel.categoryId'/>">  Delete Product</a></p>
                                 <p>&nbsp;</p>
                                 <p>&nbsp;</p>
                                 <p>&nbsp;</p>
                                 <!--<p align="center"><a>Successfully product updated</a></p>-->
                                 </div>
                         	</div>
                         	</form>

                            </s:iterator>
                            

                            
                         </div>
                	</div>
                	
                	         <div id="tnt_pagination">
		    <s:if test="%{show}">
				<s:if test="%{firsthide}">
				   <s:url id="testUrlId1" value="showAllGridProducts.action">
						<s:param name="pageNumbers" value="%{'0'}" />
						<s:param name="categoryId" value="%{pageCategoryId}" />
				   </s:url>
				   <s:a id="firstId" href="%{testUrlId1}">&lt;&lt;First</s:a>&nbsp;&nbsp;
				   
				   <s:url id="testUrlId2" value="showAllGridProducts.action">
						<s:param name="pageNumbers" value="%{previousPage}" />
						<s:param name="categoryId" value="%{pageCategoryId}" />
				   </s:url>
				   <s:a id="previousId" href="%{testUrlId2}">&lt;Previous</s:a>&nbsp;&nbsp;
			   </s:if>
			   <s:else>
			       <span class="hideButtons">&lt;&lt;First&nbsp;&nbsp;</span>
				   <span class="hideButtons">&lt;Previous&nbsp;&nbsp;</span>
			   </s:else>
		  
				
				  <s:iterator value="showPageList" >
					  <s:url id="testUrlId5" value="showAllGridProducts.action">
							<s:param name="pageNumbers" value="%{pageNumber}" />
							<s:param name="categoryId" value="%{pageCategoryId}" />
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
				  <s:url id="testUrlId3" value="showAllGridProducts.action">
						<s:param name="pageNumbers" value="%{nextPage}" />
						<s:param name="categoryId" value="%{pageCategoryId}" />
				   </s:url>
				   
				   <s:a href="%{testUrlId3}">Next&gt;</s:a>&nbsp;&nbsp; 
				   
				   <s:url id="testUrlId4" value="showAllGridProducts.action">
						<s:param name="pageNumbers" value="%{lastPage}" />
						<s:param name="categoryId" value="%{pageCategoryId}" />
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
		<div class="credit right">Designed & Developed By Sparity Soft Technologies Pvt Ltd</div>
    	</div>
       
</div>
</body>
</html>
