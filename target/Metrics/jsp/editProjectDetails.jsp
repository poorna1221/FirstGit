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
  
function updateDetails(){

 document.forms["updatePrjctDetails"].submit();
}
</script>

<script>
$(function() {
$( "#actualstartDate").datepicker();
$( "#actualendDate").datepicker();
});
</script>

<script src="jquery.js"></script>
<script>
$(document).ready(function(){



  $(".gid").change(function(){
  
  var prods = document.forms["updatePrjctDetails"].elements["ApplicationName"].value;
  
	$.ajax({
		type : "POST",
		url : "GetProjectNamesAction.action",
         data : {
			
			'ApplicationName' : prods
		},
		dataType : "html",
		success : function(data) {
			
		 $('#Project_NameDIV').html(data);
			//updateCart();
			//$("#dialog-form").dialog( "close" );
			//$('#processing-form').dialog('close');	  

		},
		error : function(err, error) {
			try {
				alert(getErrorMessage(err));
			} catch (ex) {
			}
		}
	});


  });

});
</script>

</head>
<body bgcolor='FC7EA9'>
<s:form  id="updatePrjctDetails"  action="updatePrjctDetails" method="post"> 

<fieldset>
<legend>Project Creation Page</legend>
<div>
<label for="city">Application:</label><br>
<select name="ApplicationName"  id="ApplicationName" class="gid">
  <option value ="OTM">OTM</option>
  <option value ="T3">T3</option>
  <option value ="WO">WO</option>
  <option value ="CPS">CPS</option>
  <option value ="AROR">AROR</option>
</select><br>
</div>

<div id="Project_NameDIV">
</div>


<p>Actual Start Date: <input type="text" name="actualstartDate" id="actualstartDate"/></p> 
&nbsp; &nbsp;
<p>Actual End Date: <input type="text" name="actualendDate" id="actualendDate"/></p>

<div>
Number Of UAT Defects:<br>
<input type="text"  id="noofUATDefects" name="noofUATDefects" value="" maxlength="100" /><br>
</div><br>
<div>
No Of Production Defects:<br>
<input type="text"  id="noofProdDefects"  name="noofProdDefects" value="" maxlength="100" /><br>
</div><br>
<div>
No Of Rejected Defects:<br>
<input type="text"  id="noofRejectedDfcts"  name="noofRejectedDfcts" value="" maxlength="100" /><br>
</div><br>
<div>
Requirement Count Update in the Project Life Cycle:<br/><br/>
Added:
<input type="text"  id="reqCountAdded"  name="reqCountAdded" value="" maxlength="100" />
&nbsp;&nbsp;&nbsp;&nbsp;
Modified:
<input type="text"  id="reqCountModified"  name="reqCountModified" value="" maxlength="100" />
&nbsp;&nbsp;&nbsp;&nbsp;
Deleted:
<input type="text"  id="reqCountDeleted"  name="reqCountDeleted" value="" maxlength="100" />
</div><br>
<div>
No Of Review Comments<br>
<input type="text"  id="noofReviewComments"  name="noofReviewComments" value="" maxlength="100" /><br>
</div><br>
<div>
No of Review Defects Found By Client<br>
<input type="text"  id="noofReviewDefctsFoundByClient"  name="noofReviewDefctsFoundByClient" value="" maxlength="100" /><br>
</div><br>

<div>
Cummulative Code Drop Delay:<br/>
<input type="text"  id="cummulativeCodeDropDelay"  name="cummulativeCodeDropDelay" value="" maxlength="100" /><br>
</div><br>

<div>
Requirement related Defect Count found in various Phases:<br/><br/>
Found in Analysis Phase
<input type="text"  id="reqDfctsAnalysisPhase"  name="reqDfctsAnalysisPhase" value="" maxlength="100" /><br>
</div> &nbsp; &nbsp; &nbsp;

<div>
Found in Entire Project Cycle:
<input type="text"  id="reqDfctsinEntirePrjctCycle"  name="reqDfctsinEntirePrjctCycle" value="" maxlength="100" /><br>
</div><br><br>

<div>
<br/>No of Risks mitigated but occured:
<input type="text"  id="noofRisksMitigatedButOccured"  name="noofRisksMitigatedButOccured" value="" maxlength="100" /><br>
</div>
<br/><br/>
		   
    <div class="submitBut buttonChgPass"><a href="#" onclick="updateDetails();">Update Project Details</a></div>
         
</s:form> 
		</body>
		</html>