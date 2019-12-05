<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> Cognizant:: Toyota :: Metrics </title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script type="text/javascript">
  
function checkedValues(){

 document.forms["prjctDetails"].submit();
}
</script>

<script>
$(function() {
$( "#plannedstartDate").datepicker();
$( "#plannedendDate").datepicker();
});
</script>

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
</head>
<body bgcolor='#9966FF'>
 <s:actionerror cssClass="errors" />
<s:form  id="prjctDetails"  action="savePrjctDetails" method="post"> 

<fieldset>
<legend>Project Creation Page</legend>
<div>
<label for="city">Application:</label><br>
<select name="ApplicationName"  id="ApplicationName">
  <option value ="OTM">OTM</option>
  <option value ="T3">T3</option>
  <option value ="WO">WO</option>
  <option value ="CPS">CPS</option>
  <option value ="CPS">AROR</option>
</select>
</div>
<div>
<label for="project_name">Project Name:</label><br>
<input type="text"  id="Project_Name" name="Project_Name" value="" maxlength="100" /><br>
</div>
<div>
<label for="city">Project Type:</label><br>
<select name="ProjectType" id="ProjectType">
  <option value ="AD">AD</option>
  <option value ="Migration">Migration</option>
  <option value ="REgular release">Regular Release</option>
  <option value ="Enhancement">Enhancement</option>
</select>
</div>

<p>Planned Start Date: <input type="text" name="plannedstartDate" id="plannedstartDate"/></p> 
&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <p>Planned End Date: <input type="text" name="plannedendDate" id="plannedendDate"/></p>

<div>
<label for="Estimated_Effort">Estimated Effort:</label><br>
<input type="text"  id="Estimated_Effort" name="Estimated_Effort" value="" maxlength="100" /><br>
</div>
<div>
<label for="Allocated_Effort">Allocated Effort:</label><br>
<input type="text"  id="Allocated_Effort"  name="Allocated_Effort" value="" maxlength="100" /><br>
</div>
<div>
<label for="Planned_Execution_Effort">Planned Execution Effort:</label><br>
<input type="text"  id="Planned_Execution_Effort"  name="Planned_Execution_Effort" value="" maxlength="100" /><br>
</div>
<div>
<label for="Planned_Data_Setup_Effort">Planned Data Setup Effort:</label><br>
<input type="text"  id="Planned_Data_Setup_Effort"  name="Planned_Data_Setup_Effort" value="" maxlength="100" /><br>
</div>
<div>
<label for="Number_of_Original_Requirements">Number of Original Requirements:</label><br>
<input type="text"  id="Number_of_OriginalReq"  name="Number_of_OriginalReq" value="" maxlength="100" /><br>
</div>
<div>
<label for="Number_of_Risks">Number of Risks Identified:</label><br>
<input type="text"  id="Number_of_Risksidentified"  name="Number_of_Risksidentified" value="" maxlength="100" /><br>
</div>
		   
    <div class="submitBut buttonChgPass"><a href="#" onclick="checkedValues();">Save Project Details</a></div>
         
</s:form> 
		</body>
		</html>