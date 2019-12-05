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

 document.forms["updateEffortsDB"].submit();
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
  <s:form  id="updateEffortsDB"  action="updateEffortsAction" method="post"> 
  
   <s:iterator value="effortsList">
   <input id="EffortId" name="EffortId" value="<s:property value="EffortId"/>" type="text"/>
   <input id="hiddenTestAnalysisID" name="hiddenTestAnalysisID" value="<s:property value="testAnaylysisDesign.TestAnalysisId"/>" type="text"/>
   <input id="hiddenTestExecID" name="hiddenTestExecID" value="<s:property value="testExecution.TestExecutionId"/>" type="text"/>
   <input id="hiddenTestClosureID" name="hiddenTestClosureID" value="<s:property value="testReportClosure.testClosureId"/>" type="text"/>
   <input id="hiddenOtherEffortsID" name="hiddenOtherEffortsID" value="<s:property value="otherEfforts.othereffortsId"/>" type="text"/>
    <div style="width:755px; height:auto; border: 2px solid black;">	
     <!-- table header EFFORT TRACKING-->
	<table width="100%" border="0">
<tr>
            <td width="100%" colspan="5" style="text-align: center;font-weight: bold;border: 4px solid black;">EFFORT TRACKING</td>
        </tr>
<tr>
<td width ="20%">Role</td>
<td width ="20%">
<!-- <select name="ETRole"  id="ETRole">
<option value="Tester">&nbsp;Tester</option>Test Lead
<option value="Tester">&nbsp;Tester</option>
</select>--><input id="ETRole" name="ETRole"  value="<s:property value="role"/>" type="text" size="11">
</td>
<td width ="35%" align="right">Date</td>
<td width ="15%" align="right"><div align="right">
&nbsp;&nbsp;&nbsp;&nbsp<script language="javascript" type="text/javascript" src="C:\Users\333361\Desktop\datetimepicker.js"> 
</script>
<input id="ETDateOfEntry" name="ETDateOfEntry"  value="<s:property value="datOfEntry"/>" type="text" size="11"></td>
</tr>
<tr>
<td>Project</td>
<td><input id="Project_Name_ET" name="Project_Name_ET"  value="<s:property value="prjctName"/>" type="text" size="11">
<!--
<select name="Project_Name_ET"  id="Project_Name_ET" value="<s:property value="prjctName"/>">
<s:iterator value="allProjectNamesList">  
 <option><s:property/></option>
 
 </s:iterator>
</select>-->
</td>
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
<td width ="10%"><input type="text" name ="testPlanPreparationCreate" id="testPlanPreparationCreate" value="<s:property value="testPlanPreparationCreate"/>" size="5"></td>
<td width ="10%">Review</td>
<td width ="10%"><input type="text" name ="testPlanPreparationReview" id="testPlanPreparationReview" value="<s:property value="testPlanPreparationReview"/>" size="5"></td>
<td width ="10%">Rework</td>
<td width ="10%"><input type="text" name ="testPlanPreparationRework" id="testPlanPreparationRework"  value="<s:property value="testPlanPreparationRework"/>" size="5"></td>
</tr>
</table>
	<table width="100%" border="0">
<tr>
<td width ="30%">Estimation and Resource Loading</td>
<td width ="10%"><input type="text" name ="estimationnResourceLoding"  id="estimationnResourceLoding"  value="<s:property value="estimationnResourceLoding"/>" size="5"></td>
<td width ="60%">
</tr>
<tr>
<td width ="30%">Task Allocation and Co-ordination</td>
<td width ="10%"><input type="text" name ="taskAllocationandCoordination" id="taskAllocationandCoordination"  value="<s:property value="taskAllocationandCoordination"/>" size="5"></td>
<td width ="60%">
</tr>
<tr>
<td width ="30%">Process Audit </td>
<td width ="10%"><input type="text" name ="processAudit" id="processAudit" value="<s:property value="processAudit"/>" size="5"></td>
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
<td width ="10%"><input type="text" name ="requirementUnderstading" id="requirementUnderstading"  value="<s:property value="testAnaylysisDesign.requirementUnderstading"/>" size="5"></td>
<td width ="63%"></td>
</tr>
<td width ="29%">Clarifcation Tracking</td>
<td width ="10%"><input type="text"  name ="clarificationTracking" id="clarificationTracking" value="<s:property value="testAnaylysisDesign.clarificationTracking"/>" size="5"></td>
<td width ="63%"></td>
</tr>
</tr>
<td width ="29%">Create/Update RTM</td>
<td width ="10%"><input type="text"  name ="createUpdateRTM" id="createUpdateRTM" value="<s:property value="testAnaylysisDesign.createUpdateRTM"/>" size="5"></td>
<td width ="63%"></td>
</tr>
</tr>
<td width ="29%">Create/Update Test Scenario</td>
<td width ="10%"><input type="text"  name ="creatUpdateTestScenarios" id="creatUpdateTestScenarios" value="<s:property value="testAnaylysisDesign.creatUpdateTestScenarios"/>" size="5"></td>
<td style="float: right;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Complex
&nbsp;&nbsp;<input type="checbox"  name ="testScenariosComplex" id="testScenariosComplex"  value="<s:property value="testAnaylysisDesign.testScenariosComplex"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox"  name ="testScenariosMedium" id="testScenariosMedium" value="<s:property value="testAnaylysisDesign.testScenariosMedium"/>"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox"  name ="testScenariosSimple" id="testScenariosSimple" value="<s:property value="testAnaylysisDesign.testScenariosSimple"/>"  size="1"/>&nbsp;&nbsp;&nbsp;</td>
                </tr></table>
<table width="100%" border="0">
<tr>
<td width ="35%">Test Design </td>
<td width ="10%">Create</td>
<td width ="12%"><input type="text"  name ="tcDesignCreate" id="tcDesignCreate"  value="<s:property value="testAnaylysisDesign.tcDesignCreate"/>" size="5"></td>
<td width ="10%">Review</td>
<td width ="12%"><input type="text"  name ="tcDesignReview" id="tcDesignReview"  value="<s:property value="testAnaylysisDesign.tcDesignReview"/>"  size="5"></td>
<td width ="10%">Rework</td>
<td width ="12%"><input type="text"  name ="tcDesignRework" id="tcDesignRework" value="<s:property value="testAnaylysisDesign.tcDesignRework"/>"  size="5"></td>
<tr></tr>
<tr>
<td colspan="2"></td>
            <td colspan="5">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox"  name ="tcDesignComplex" id="tcDesignComplex" value="<s:property value="testAnaylysisDesign.tcDesignComplex"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox"  name ="tcDesignMedium" id="tcDesignMedium" value="<s:property value="testAnaylysisDesign.tcDesignMedium"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox"  name ="tcDesignSimple" id="tcDesignSimple" value="<s:property value="testAnaylysisDesign.tcDesignSimple"/>" size="1"/>&nbsp;&nbsp;&nbsp;
            </td></tr>
<tr></tr>
</table>
<table>
<table width="100%" border="0">
<tr> 
<td width ="32%">Test Data Set-up</td>
<td width ="10%">Create</td>
<td width ="10%"><input type="text"  name ="testDataSetupCreate" id="testDataSetupCreate"  value="<s:property value="testAnaylysisDesign.testDataSetupCreate"/>" size="5"></td>
<td width ="10%">Recreate</td>
<td width ="10%"><input type="text"  name ="testDataSetupRecreate" id="testDataSetupRecreate" value="<s:property value="testAnaylysisDesign.testDataSetupRecreate"/>"  size="5"></td>
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
            <td width="10%"><input type="text" name="funTestExecNew" id="funTestExecNew" value="<s:property value="testExecution.funTestExecNew"/>" size="5"/></td>
            <td width="10%">Re-Test</td>
            <td width="30%"><input type="text" name="funTestExecRetest" id="funTestExecRetest" value="<s:property value="testExecution.funTestExecRetest"/>"  size="5"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td colspan="3">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox" name="funTestExecComplex" id="funTestExecComplex"  value="<s:property value="testExecution.funTestExecComplex"/>"  size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox" name="funTestExecMedium" id="funTestExecMedium" value="<s:property value="testExecution.funTestExecMedium"/>"  size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox" name="funTestExecSimple" id="funTestExecSimple" value="<s:property value="testExecution.funTestExecSimple"/>"  size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td width="30%">Integration Test Execution </td>
            <td width="10%">New</td>
            <td width="10%"><input type="text" name="integTestExecNew" id="integTestExecNew" value="<s:property value="testExecution.integTestExecNew"/>" size="5"/></td>
            <td width="10%">Re-Test</td>
            <td width="30%"><input type="text" name="integTestExecRetest" id="integTestExecRetest" value="<s:property value="testExecution.integTestExecRetest"/>" size="5"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td colspan="3">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox" name="integTestExecComplex" id="integTestExecComplex" value="<s:property value="testExecution.integTestExecComplex"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox" name="integTestExecMedium" id="integTestExecMedium" value="<s:property value="testExecution.integTestExecMedium"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox" name="integTestExecSimple" id="integTestExecSimple" value="<s:property value="testExecution.integTestExecSimple"/>" size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td width="30%">Regression Test Execution</td>
            <td width="10%">New</td>
            <td width="10%"><input type="text" name="regressionTestExecNew" id="regressionTestExecNew"  value="<s:property value="testExecution.regressionTestExecNew"/>" size="5"/></td>
            <td width="10%">Re-Test</td>
            <td width="30%"><input type="text" name="regressionTestExecRetest" id="regressionTestExecRetest" value="<s:property value="testExecution.regressionTestExecRetest"/>"  size="5"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td colspan="3">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Complex&nbsp;&nbsp;<input type="checbox" name="regressionTestExecComplex" id="regressionTestExecComplex" value="<s:property value="testExecution.regressionTestExecComplex"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Medium&nbsp;&nbsp;<input type="checbox" name="regressionTestExecMedium" id="regressionTestExecMedium" value="<s:property value="testExecution.regressionTestExecMedium"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Simple&nbsp;&nbsp;<input type="checbox" name="regressionTestExecSimple" id="regressionTestExecSimple" value="<s:property value="testExecution.regressionTestExecSimple"/>" size="1"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>        
    </table>
    <table width="100%" border="0">
        <tr>
            <td width="25%"> Ad-hoc Testing</td>
            <td width="5%"><input type="text" name="adhocTesting" id="adhocTesting"  value="<s:property value="testExecution.adhocTesting"/>" size="5"/></td>
            <td width="70%"></td>
        </tr>
        <tr>
            <td width="25%">Defect Reporting</td>
            <td width="5%"><input type="text" name="defectReporting" id="defectReporting" value="<s:property value="testExecution.defectReporting"/>" size="5"/></td>            
            <td style="float: right;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Critical&nbsp;&nbsp;<input type="checbox" name="defectReporingCritical" id="defectReporingCritical" value="<s:property value="testExecution.defectReporingCritical"/>"  size="1"/>&nbsp;&nbsp;&nbsp;
                Major&nbsp;&nbsp;<input type="checbox" name="defectReporingMajor" id="defectReporingMajor"  value="<s:property value="testExecution.defectReporingMajor"/>" size="1"/>&nbsp;&nbsp;&nbsp;
                Minor&nbsp;&nbsp;<input type="checbox" name="defectReporingMinor" id="defectReporingMinor"  value="<s:property value="testExecution.defectReporingMinor"/>" size="1"/>&nbsp;&nbsp;&nbsp;
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
            <td width="15%"><input type="text" name="statusReportDailyWeekly" id="statusReportDailyWeekly" value="<s:property value="testReportClosure.statusReportDailyWeekly"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Test Metrics Generation</td>
            <td width="15%"><input type="text" name="testMetricsGeneration" id="testMetricsGeneration"  value="<s:property value="testReportClosure.testMetricsGeneration"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Test Summary Report</td>
            <td width="15%"><input type="text" name="testSummaryReport" id="testSummaryReport"  value="<s:property value="testReportClosure.testSummaryReport"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Internal Calls	 Scheduled Calls</td>
            <td width="15%"><input type="text" name="internalScheduledCalls" id="internalScheduledCalls" value="<s:property value="testReportClosure.internalScheduledCalls"/>" size="5"/></td>
            <td width="25%">Unscheduled Calls</td>
            <td width="30%"><input type="text" name="internalUnscheduledCalls" id="internalUnscheduledCalls"  value="<s:property value="testReportClosure.internalUnscheduledCalls"/>" size="5"/></td>
        </tr>
        <tr>
            <td width="30%">Meetings 	Project related</td>
            <td width="15%"><input type="text" name="projectRelatedMeetings" id="projectRelatedMeetings"  value="<s:property value="testReportClosure.projectRelatedMeetings"/>" size="5"/></td>
            <td width="25%">Others</td>
            <td width="30%"><input type="text" name="otherMeetings" id="otherMeetings" value="<s:property value="testReportClosure.otherMeetings"/>" size="5"/></td>
        </tr>
        <tr>
            <td width="30%">Regression Suite Update</td>
            <td width="15%"><input type="text" name="regressionSuiteUpdate" id="regressionSuiteUpdate" value="<s:property value="testReportClosure.regressionSuiteUpdate"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="30%">Knowledge Transition</td>
            <td width="15%"><input type="text" name="knowledgeTransition" id="knowledgeTransition" value="<s:property value="testReportClosure.knowledgeTransition"/>"  size="5"/></td>
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
            <td width="10%"><input type="text" name="emailing" id="emailing" value="<s:property value="otherEfforts.emailing"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Training/E-learning	Project Specific</td>
            <td width="10%"><input type="text" name="trainingElearningPrjctSpecific" id="trainingElearningPrjctSpecific"  value="<s:property value="otherEfforts.trainingElearningPrjctSpecific"/>" size="5"/></td>
            <td width="25%">Non Project Specific</td>
            <td width="30%"><input type="text" name="trainingElearningNonPrjctSpecific" id="trainingElearningNonPrjctSpecific"  value="<s:property value="otherEfforts.trainingElearningNonPrjctSpecific"/>"  size="5"/></td>
        </tr>
        <tr>
            <td width="35%">Environment Unavailability</td>
            <td width="10%"><input type="text" name="environmentUnavailability" id="environmentUnavailability"  value="<s:property value="otherEfforts.environmentUnavailability"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Organizational Activities</td>
            <td width="10%"><input type="text" name="organisationalActivities" id="organisationalActivities" value="<s:property value="otherEfforts.organisationalActivities"/>"  size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Knowledge Portal Maintenance</td>
            <td width="10%"><input type="text" name="knowledgePortalMaintainance" id="knowledgePortalMaintainance"  value="<s:property value="otherEfforts.knowledgePortalMaintainance"/>" size="5"/></td>
            <td width="25%"></td>
            <td width="30%"></td>
        </tr>
        <tr>
            <td width="35%">Leave&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Planned</td>
            <td width="10%"><input type="text" name="leavesPlanned" id="leavesPlanned"  value="<s:property value="otherEfforts.leavesPlanned"/>" size="5"/></td>
            <td width="25%">Unplanned</td>
            <td width="30%"><input type="text" name="leavesUnplanned" id="leavesUnplanned" value="<s:property value="otherEfforts.leavesUnplanned"/>"  size="5"/></td>
        </tr>
    </table>
	
	
    <br>
  </div>
 
  <div class="submitBut buttonChgPass"><a href="#" onclick="checkedValues();">Update Efforts</a></div>
  </s:iterator>
  </s:form> 
  </body>
</html>

