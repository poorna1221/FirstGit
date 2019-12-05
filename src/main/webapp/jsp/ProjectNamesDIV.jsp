<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Cognizant:: Toyota :: Metrics </title>
</head>
<body bgcolor='FC7EA9'>
Project Name:
<select name="Project_Name"  id="Project_Name">
 <s:iterator value="prjctNamesList">  
 <option><s:property/></option>
 </s:iterator> 
 </select> <br>
		</body>
		</html>