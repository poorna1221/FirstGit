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
<s:form  id="UserType" method="post"> 

<fieldset>

<a href='<s:url action="CreatePrjctAction"/>'>Create New Project</a><br/><br/>

<a href='<s:url action="editProjectDetailsPage"/>'>Update Existing Project</a><br/><br/>

<a href='<s:url action="enterEffortsAction"/>'>Enter Efforts</a><br/><br/>


</fieldset>
       
</s:form> 
		</body>
		</html>