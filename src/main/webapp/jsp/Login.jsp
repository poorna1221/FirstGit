<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Cognizant:: Toyota :: Metrics </title>

<script type="text/javascript">

</script>




</head>
<body bgcolor='#9966FF'>
<s:form  id="UserType"  action="SelectTypeOfUser" method="post"> 

<fieldset>
<legend>UserLoginPage</legend>
<div>
<legend>Select Employee ID:</legend><br/>
 <select class="txtBox0"  id="selectedEmpID" name="selectedEmpID">
                     <s:iterator value="empIdsList">  
                            <option><s:property/></option>
                        </s:iterator>  
                        </select>	<br>
</div>
</fieldset>
<input type="submit" value="submit"/>
   <!-- <div class="submitBut buttonChgPass"><a href="#" onclick="updateDetails();">Update Project Details</a></div>-->
         
</s:form> 
		</body>
		</html>