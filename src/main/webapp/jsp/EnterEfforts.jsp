<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Toyota :: EnterEfforts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
	<style type="text/css">
	   body {background-color:;}	
	</style>
	
	<script type="text/javascript">
  
function checkedValues(){

 document.forms["saveEfforts"].submit();
}
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
<script>
$(function() {
$( "#ETDateOfEntry").datepicker();

});
</script>
  </head>
  <body>
   <s:actionerror cssClass="errors" />
    <s:actionmessage cssClass="successMessage"/>
  <s:form  id="saveEfforts"  action="saveEfforts" method="post"> 
    <div style="width:755px; height:auto; border: 2px solid black;">	
     <!-- table header EFFORT TRACKING-->
	<table width="100%" border="0">
<tr>
            <td width="100%" colspan="5" style="text-align: center;font-weight: bold;border: 4px solid black;">EFFORT TRACKING</td>
        </tr>
<tr>
<td width ="20%">Role</td>
<td width ="20%"><select name="ETRole"  id="ETRole">
<option value="Tester">&nbsp;Tester</option>Test Lead
<option value="Tester">&nbsp;Tester</option>
</select></td>
<td width ="35%" align="right">Date</td>
<td width ="15%" align="right"><div align="right">
&nbsp;&nbsp;&nbsp;&nbsp<script language="javascript" type="text/javascript" src="C:\Users\333361\Desktop\datetimepicker.js"> 
</script>
<input id="ETDateOfEntry" name="ETDateOfEntry"  type="text" size="11"></td>
</tr>
<tr>
<td>Project</td>
<td><select name="Project_Name_ET"  id="Project_Name_ET">
<s:iterator value="allProjectNamesList">  
 <option><s:property/></option>
 
 </s:iterator>
</select></td>
</tr>
</table>
<br>
<!-- table header PROGRAM MANAGEMENT-->	
   <table width="100%" border="0">
<tr>
<td width="100%" colspan="7" style="text-align: center;font-weight: bold;border: 3px solid black;">PROJECT MANAGEMENT</td>
</tr>
<tr>
<td width ="30%">Test Plan Preparation </td>
<td width ="10%">Create</td>
<td width ="10%"><input type="text" name ="testPlanPreparationCreate" id="testPlanPreparationCreate" size="5"></td>
<td width ="10%">Review</td>
<td width ="10%"><input type="text" name ="testPlanPreparationReview" id="testPlanPreparationReview"  size="5"></td>
<td width ="10%">Rework</td>
<td width ="10%"><input type="text" name ="testPlanPreparationRework" id="testPlanPreparationRework"  size="5"></td>
</tr>
</table>
	<table width="100%" border="0">
<tr>
<td width ="30%">Estimation and Resource Loading</td>
<td width ="10%"><input type="text" name ="estimationnResourceLoding"  id="estimationnResourceLoding"  size="5"></td>
<td width ="60%">
</tr>
<tr>
<td width ="30%">Task Allocation and Co-ordination</td>
<td width ="10%"><input type="text" name ="taskAllocationandCoordination" id="taskAllocationandCoordination"   size="5"></td>
<td width ="60%">
</tr>
<tr>
<td width ="30%">Process Audit </td>
<td width ="10%"><input type="text" name ="processAudit" id="processAudit"  size="5"></td>
<td width ="60%"></td>
</tr>
</table>
<br>
<!-- table header TEST ANALYSIS AND DESIGN-->	
   <table width="100%" border="0">
<tr>
<td width="100%" colspan="7" style="text-align: center;font-weight: bold;border: 3px solid black;">TEST ANALYSIS AND DESIGN</td>
</tr>
<td width ="29%">Requirement Understanding</td>
<td width ="10%"><input type="text" name ="requirementUnderstading" id="requirementUnderstading"  size="5"></td>
<td width ="63%"></td>
</tr>
<td width ="29%">Clarifcation Tracking</td>
<td width ="10%"><input type="text"  name ="clarificationTracking" id="clarificationTracking"  size="5"></td>
<td width ="63%"></td>
</tr>
</tr>
<td width ="29%">Create/Update RTM</td>
<td width ="10%"><input type="text"  name ="createUpdateRTM" id="createUpdateRTM"  size="5"></td>
<td width ="63%"></td>
</tr>
</tr>
<td width ="29%">Create/Update Test Scenario</td>
<td width ="10%"><input type="text"  name ="creatUpdateTestScenarios" id="creatUpdateTestScenarios"  size="5"></td>
<td style="float: right;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Complex
&nbsp;&nbsp;<input type="checbox"  name ="testScenariosComplex" id="testScenariosComplex"   size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox"  name ="testScenariosMedium" id="testScenariosMedium"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox"  name ="testScenariosSimple" id="testScenariosSimple"  size="1"/>&nbsp;&nbsp;&nbsp;</td>
                </tr></table>
<table width="100%" border="0">
<tr>
<td width ="35%">Test Design </td>
<td width ="10%">Create</td>
<td width ="12%"><input type="text"  name ="tcDesignCreate" id="tcDesignCreate"  size="5"></td>
<td width ="10%">Review</td>
<td width ="12%"><input type="text"  name ="tcDesignReview" id="tcDesignReview"   size="5"></td>
<td width ="10%">Rework</td>
<td width ="12%"><input type="text"  name ="tcDesignRework" id="tcDesignRework"  size="5"></td>
<tr></tr>
<tr>
<td colspan="2"></td>
            <td colspan="5">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox"  name ="tcDesignComplex" id="tcDesignComplex"  size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox"  name ="tcDesignMedium" id="tcDesignMedium"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox"  name ="tcDesignSimple" id="tcDesignSimple"  size="1"/>&nbsp;&nbsp;&nbsp;
            </td></tr>
<tr></tr>
</table>
<table>
<table width="100%" border="0">
<tr> 
<td width ="32%">Test Data Set-up</td>
<td width ="10%">Create</td>
<td width ="10%"><input type="text"  name ="testDataSetupCreate" id="testDataSetupCreate"   size="5"></td>
<td width ="10%">Recreate</td>
<td width ="10%"><input type="text"  name ="testDataSetupRecreate" id="testDataSetupRecreate"  size="5"></td>
<td width ="20%"></td>
</tr></table>

	<table width="100%" border="0">
        <tr>
            <td width="100%" colspan="5" style="text-align: center;font-weight: bold;border: 3px solid black;">TEST EXECUTION</td>
        </tr>
        <tr></tr>
        <tr>
            <td width="30%">Functional Test Execution</td>
            <td width="10%">New</td>
            <td width="10%"><input type="text" name="funTestExecNew" id="funTestExecNew" size="5"/></td>
            <td width="10%">Re-Test</td>
            <td width="30%"><input type="text" name="funTestExecRetest" id="funTestExecRetest"  size="5"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td colspan="3">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox" name="funTestExecComplex" id="funTestExecComplex"   size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox" name="funTestExecMedium" id="funTestExecMedium"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox" name="funTestExecSimple" id="funTestExecSimple"  size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td width="30%">Integration Test Execution </td>
            <td width="10%">New</td>
            <td width="10%"><input type="text" name="integTestExecNew" id="integTestExecNew"  size="5"/></td>
            <td width="10%">Re-Test</td>
            <td width="30%"><input type="text" name="integTestExecRetest" id="integTestExecRetest"  size="5"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td colspan="3">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox" name="integTestExecComplex" id="integTestExecComplex"  size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox" name="integTestExecMedium" id="integTestExecMedium"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox" name="integTestExecSimple" id="integTestExecSimple"  size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td width="30%">Regression Test Execution</td>
            <td width="10%">New</td>
            <td width="10%"><input type="text" name="regressionTestExecNew" id="regressionTestExecNew"  size="5"/></td>
            <td width="10%">Re-Test</td>
            <td width="30%"><input type="text" name="regressionTestExecRetest" id="regressionTestExecRetest"  size="5"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td colspan="3">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox" name="regressionTestExecComplex" id="regressionTestExecComplex"  size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox" name="regressionTestExecMedium" id="regressionTestExecMedium"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox" name="regressionTestExecSimple" id="regressionTestExecSimple"  size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>        
    </table>
    <table width="100%" border="0">
        <tr>
            <td width="25%"> Ad-hoc Testing</td>
            <td width="5%"><input type="text" name="adhocTesting" id="adhocTesting"  size="5"/></td>
            <td width="70%"></td>
        </tr>
        <tr>
            <td width="25%">Defect Reporting</td>
            <td width="5%"><input type="text" name="defectReporting" id="defectReporting"  size="5"/></td>            
            <td style="float: right;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Critical&nbsp;&nbsp;<input type="checbox" name="defectReporingCritical" id="defectReporingCritical"  size="1"/>&nbsp;&nbsp;&nbsp;
                Major&nbsp;&nbsp;<input type="checbox" name="defectReporingMajor" id="defectReporingMajor"  size="1"/>&nbsp;&nbsp;&nbsp;
                Minor&nbsp;&nbsp;<input type="checbox" name="defectReporingMinor" id="defectReporingMinor"  size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
    </table>
    <!-- table header TEST REPORTING AND CLOSURE-->
    <br>
    <table width="100%">
        <tr>
            <td width="100%" colspan="5" style="text-align: center;font-weight: bold;border: 3px solid black;">TEST REPORTING AND CLOSURE</td>
        </tr>
        <tr></tr>
        <tr>
            <td width="30%">Status Report (Daily/Weekly)</td>
            <td width="15%"><input type="text" name="statusReportDailyWeekly" id="statusReportDailyWeekly" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Test Metrics Generation</td>
            <td width="15%"><input type="text" name="testMetricsGeneration" id="testMetricsGeneration"  size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Test Summary Report</td>
            <td width="15%"><input type="text" name="testSummaryReport" id="testSummaryReport"  size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Internal Calls	 Scheduled Calls</td>
            <td width="15%"><input type="text" name="internalScheduledCalls" id="internalScheduledCalls"  size="5"/></td>
            <td width="25%">Unscheduled Calls</td>
            <td width="30%"><input type="text" name="internalUnscheduledCalls" id="internalUnscheduledCalls"  size="5"/></td>
        </tr>
        <tr>
            <td width="30%">Meetings 	Project related</td>
            <td width="15%"><input type="text" name="projectRelatedMeetings" id="projectRelatedMeetings"  size="5"/></td>
            <td width="25%">Others</td>
            <td width="30%"><input type="text" name="otherMeetings" id="otherMeetings"  size="5"/></td>
        </tr>
        <tr>
            <td width="30%">Regression Suite Update</td>
            <td width="15%"><input type="text" name="regressionSuiteUpdate" id="regressionSuiteUpdate"  size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Knowledge Transition</td>
            <td width="15%"><input type="text" name="knowledgeTransition" id="knowledgeTransition"  size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
    </table>
    <br>
    <!-- table header OTHERS-->
    <br>
    <table width="100%">
        <tr>
            <td width="100%" colspan="5" style="text-align: center;font-weight: bold;border: 3px solid black;">OTHERS</td>
        </tr>
        <tr></tr>
        <tr>
            <td width="35%">Emailing</td>
            <td width="10%"><input type="text" name="emailing" id="emailing" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Training/E-learning	Project Specific</td>
            <td width="10%"><input type="text" name="trainingElearningPrjctSpecific" id="trainingElearningPrjctSpecific"  size="5"/></td>
            <td width="25%">Non Project Specific</td>
            <td width="30%"><input type="text" name="trainingElearningNonPrjctSpecific" id="trainingElearningNonPrjctSpecific"   size="5"/></td>
        </tr>
        <tr>
            <td width="35%">Environment Unavailability</td>
            <td width="10%"><input type="text" name="environmentUnavailability" id="environmentUnavailability"   size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Organizational Activities</td>
            <td width="10%"><input type="text" name="organisationalActivities" id="organisationalActivities"   size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Knowledge Portal Maintenance</td>
            <td width="10%"><input type="text" name="knowledgePortalMaintainance" id="knowledgePortalMaintainance"   size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Leave&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Planned</td>
            <td width="10%"><input type="text" name="leavesPlanned" id="leavesPlanned"  size="5"/></td>
            <td width="25%">Unplanned</td>
            <td width="30%"><input type="text" name="leavesUnplanned" id="leavesUnplanned"   size="5"/></td>
        </tr>
    </table>
	
	
    <br>
  </div>
  <a href='<s:url action="EditEffortsAction"/>'>Edit Efforts</a>
  <div class="submitBut buttonChgPass"><a href="#" onclick="checkedValues();">Save Efforts</a></div>
  </s:form> 
  </body>
</html>

