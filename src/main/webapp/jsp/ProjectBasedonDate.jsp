<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Cognizant:: Toyota :: Metrics </title>
</head>
<body>
<!--<select name="Project_Name"  id="Project_Name">
 <s:iterator value="prjctNamesBasedDate">  
 <option><s:property value='prjctName'/></option>
</s:iterator> 
 </select> <br>-->
 
 <s:iterator value="prjctNamesBasedDate">
 <a href="showEffortsForEditing.action?editEffortsEffortID=<s:property value='EffortId'/>" id="megaanchor01"><s:property value='prjctName'/></a><br/>
</s:iterator> 
 <br>
</body>
</html>