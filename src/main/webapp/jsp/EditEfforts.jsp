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

 document.forms["editEfforts"].submit();
}
</script>

<script>
$(function() {
$( "#showProjectForDate").datepicker();

});
</script>

<script src="jquery.js"></script>
<script>
$(document).ready(function(){



  $(".selectedDate").change(function(){
  
  var prods = document.forms["editEfforts"].elements["showProjectForDate"].value;
  
	$.ajax({
		type : "POST",
		url : "getProjectsBasedOnDate.action",
         data : {
			
			'showProjectForDate' : prods
		},
		dataType : "html",
		success : function(data) {
			
		 $('#Project_NamesBasdDateDiv').html(data);
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
<s:form  id="editEfforts"  action="showPrjctsBasedonDate" method="post"> 

<fieldset>
<legend>Edit Efforts</legend>

<p>Select Date for Editing Efforts<input type="text" name="showProjectForDate" id="showProjectForDate" class="selectedDate"/></p> 


<div id="Project_NamesBasdDateDiv">
</div>


    <div class="submitBut buttonChgPass"><a href="#" onclick="updateDetails();">Update Project Details</a></div>
  </fieldset>       
</s:form> 
		</body>
		</html>