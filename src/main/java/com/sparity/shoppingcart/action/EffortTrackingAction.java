package com.sparity.shoppingcart.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.model.AdminModel;
import com.sparity.shoppingcart.model.EffortTrackingModel;
import com.sparity.shoppingcart.model.OtherEffortsModel;
import com.sparity.shoppingcart.model.ProjectCreationModel;
import com.sparity.shoppingcart.model.TestAnalysisDesignModel;
import com.sparity.shoppingcart.model.TestExecutionModel;
import com.sparity.shoppingcart.model.TestReportingclosureModel;
import com.sparity.shoppingcart.service.EffortTrackingService;
import com.sparity.shoppingcart.service.ProjectCreationService;

@SuppressWarnings("serial")
public class EffortTrackingAction extends BaseAction{
	
	private EffortTrackingService effortTrackingService = (EffortTrackingService) getServiceBean("efService");

	private Long EffortId;
    private String ETDateOfEntry;
   private String Project_Name_ET;
	private String ETRole;
	private String testPlanPreparationCreate;
	private String testPlanPreparationReview;
	private String testPlanPreparationRework;
	private String estimationnResourceLoding;
	private String taskAllocationandCoordination;
	private String processAudit;
	
	private String requirementUnderstading;
	private String clarificationTracking;
	private String createUpdateRTM;
	private String creatUpdateTestScenarios;
	private String testScenariosSimple;
	private String testScenariosMedium;
	private String testScenariosComplex;
	private String tcDesignCreate;
	
	private String tcDesignReview;
	private String tcDesignRework;
	private String  tcDesignSimple;
	private String tcDesignMedium;
	private String  tcDesignComplex;
	private String  testDataSetupCreate;
	private String  testDataSetupRecreate;
	
	//-----
	private String funTestExecNew;
	
	private String funTestExecRetest;
	private String funTestExecSimple;
	private String funTestExecMedium;
	private String funTestExecComplex;
	private String  integTestExecNew;
	private String integTestExecRetest;
	private String integTestExecSimple;
	private String integTestExecMedium;
	private String integTestExecComplex;
	private String  regressionTestExecNew;
	private String regressionTestExecRetest;
	private String regressionTestExecSimple;
	private String regressionTestExecMedium;
	private String regressionTestExecComplex;
	private String  adhocTesting;
	private String defectReporting;
	private String defectReporingCritical;
	private String defectReporingMajor;
	private String defectReporingMinor;
	private String tesLogDocCreate;
	private String testLogDocReview;
	private String testLogDocRework;
	
	
	///-------
	private String  statusReportDailyWeekly;
	
	private String testMetricsGeneration;
	
	private String testSummaryReport;
	private String internalScheduledCalls;
	private String  internalUnscheduledCalls;
	private String  projectRelatedMeetings;
	private String otherMeetings;
	private String  	regressionSuiteUpdate;
	private String  knowledgeTransition;
	List<ProjectCreationModel> prjctNames =new ArrayList<ProjectCreationModel>(); 
	
	//-------
	private String  emailing;
	private String  trainingElearningPrjctSpecific;
	private String  trainingElearningNonPrjctSpecific;
	private String  environmentUnavailability;
	private String  organisationalActivities;
	private String knowledgePortalMaintainance;
	private String  leavesPlanned;
	private String  leavesUnplanned;
	//------
	
	private Long editEffortsEffortID;
	
	private Long hiddenTestAnalysisID;
	private Long hiddenTestExecID;
	private Long hiddenTestClosureID;
	private Long hiddenOtherEffortsID;
	private ProjectCreationService prjctCreationService = (ProjectCreationService) getServiceBean("projectCreationService");
	
	List<String> allProjectNamesList=new ArrayList<String>();
	List<EffortTrackingModel> prjctNamesBasedDate=new ArrayList<EffortTrackingModel>();
	
	List<EffortTrackingModel> effortsList=new ArrayList<EffortTrackingModel>();
	
	private String showProjectForDate;
	List<String> prjctNamesBasedOnDateList=new ArrayList<String>();
	//-------
	
	public List<String> getPrjctNamesBasedOnDateList() {
		return prjctNamesBasedOnDateList;
	}

	public void setPrjctNamesBasedOnDateList(List<String> prjctNamesBasedOnDateList) {
		this.prjctNamesBasedOnDateList = prjctNamesBasedOnDateList;
	}

	public String getShowProjectForDate() {
		return showProjectForDate;
	}

	public void setShowProjectForDate(String showProjectForDate) {
		this.showProjectForDate = showProjectForDate;
	}

	public String  getAllProjects()
	{
		prjctNames=prjctCreationService.getAllProjectNames();
		System.out.println("no of project for applns are"+prjctNames.size());
		for(ProjectCreationModel pcmModel:prjctNames)
		{
			allProjectNamesList.add(pcmModel.getProject_Name());
			System.out.println(""+pcmModel.getProject_Name());
		}
		System.out.println("no of project for after adding are allProjectNamesList"+allProjectNamesList.size());
		return SUCCESS;
		
		
	}
	
	public ProjectCreationService getPrjctCreationService() {
		return prjctCreationService;
	}

	public void setPrjctCreationService(ProjectCreationService prjctCreationService) {
		this.prjctCreationService = prjctCreationService;
	}

	public List<String> getAllProjectNamesList() {
		return allProjectNamesList;
	}

	public void setAllProjectNamesList(List<String> allProjectNamesList) {
		this.allProjectNamesList = allProjectNamesList;
	}

	public String saveEffortDetails()
	{
		
		try{
		EffortTrackingModel etmObj=new EffortTrackingModel();
		  Map<String,Object> session=getSession();
		String EmpID= (String) session.get("EmpIdSession");
		etmObj.setEmpId(EmpID);
		etmObj.setRole(ETRole);
		etmObj.setPrjctName(Project_Name_ET);
		etmObj.setDatOfEntry(ETDateOfEntry);
		etmObj.setTestPlanPreparationCreate(testPlanPreparationCreate);
		etmObj.setTestPlanPreparationReview(testPlanPreparationReview);
		etmObj.setTestPlanPreparationRework(testPlanPreparationRework);
		etmObj.setEstimationnResourceLoding(estimationnResourceLoding);
		etmObj.setTaskAllocationandCoordination(taskAllocationandCoordination);
		etmObj.setProcessAudit(processAudit);
		effortTrackingService.saveObject(etmObj);
		EffortId=etmObj.getEffortId();
		System.out.println("Effort id is"+EffortId);
		
		TestAnalysisDesignModel tadObj=new TestAnalysisDesignModel();
		tadObj.setEffortTrackingModel(etmObj);
		tadObj.setRequirementUnderstading(requirementUnderstading);
		tadObj.setClarificationTracking(clarificationTracking);
		tadObj.setCreateUpdateRTM(createUpdateRTM);
		tadObj.setCreatUpdateTestScenarios(creatUpdateTestScenarios);
		tadObj.setTestScenariosSimple(testScenariosSimple);
		tadObj.setTestScenariosMedium(testScenariosMedium);
		tadObj.setTestScenariosComplex(testScenariosComplex);
		tadObj.setTcDesignCreate(tcDesignCreate);
		tadObj.setTcDesignReview(tcDesignReview);
		tadObj.setTcDesignRework(tcDesignRework);
		tadObj.setTcDesignSimple(tcDesignSimple);
		tadObj.setTcDesignMedium(tcDesignMedium);
		tadObj.setTcDesignComplex(tcDesignComplex);
		tadObj.setTestDataSetupCreate(testDataSetupCreate);
		tadObj.setTestDataSetupRecreate(testDataSetupRecreate);
		
		effortTrackingService.saveObject(tadObj);
		
		
		TestExecutionModel temObj=new TestExecutionModel();
		temObj.setEffortTrackingModel(etmObj);
		temObj.setFunTestExecNew(funTestExecNew);
		temObj.setFunTestExecRetest(funTestExecRetest);
		temObj.setFunTestExecSimple(funTestExecSimple);
		temObj.setFunTestExecMedium(funTestExecMedium);
		temObj.setFunTestExecComplex(funTestExecComplex);
		temObj.setIntegTestExecNew(integTestExecNew);
		temObj.setIntegTestExecRetest(integTestExecRetest);
		temObj.setIntegTestExecSimple(integTestExecSimple);
		temObj.setIntegTestExecMedium(integTestExecMedium);
		temObj.setIntegTestExecComplex(integTestExecComplex);
		temObj.setRegressionTestExecNew(regressionTestExecNew);
		temObj.setRegressionTestExecRetest(regressionTestExecRetest);
		temObj.setRegressionTestExecSimple(regressionTestExecSimple);
		temObj.setRegressionTestExecMedium(regressionTestExecMedium);
		temObj.setRegressionTestExecComplex(regressionTestExecComplex);
		temObj.setAdhocTesting(adhocTesting);
		temObj.setDefectReporting(defectReporting);
		temObj.setDefectReporingCritical(defectReporingCritical);
		temObj.setDefectReporingMajor(defectReporingMajor);
		temObj.setDefectReporingMinor(defectReporingMinor);
		temObj.setTesLogDocCreate(tesLogDocCreate);
		temObj.setTestLogDocReview(testLogDocReview);
		temObj.setTestLogDocRework(testLogDocRework);
		
		effortTrackingService.saveObject(temObj);
		
		
		TestReportingclosureModel trcObj=new TestReportingclosureModel();
		trcObj.setEffortTrackingModel(etmObj);
		trcObj.setTestMetricsGeneration(testMetricsGeneration);
		trcObj.setTestSummaryReport(testSummaryReport);
		trcObj.setInternalScheduledCalls(internalScheduledCalls);
		trcObj.setInternalUnscheduledCalls(internalUnscheduledCalls);
		trcObj.setProjectRelatedMeetings(projectRelatedMeetings);
		trcObj.setOtherMeetings(otherMeetings);
		trcObj.setRegressionSuiteUpdate(regressionSuiteUpdate);
		trcObj.setKnowledgeTransition(knowledgeTransition);
		trcObj.setStatusReportDailyWeekly(statusReportDailyWeekly);
	
		
		effortTrackingService.saveObject(trcObj);
		
		
		OtherEffortsModel oemObj=new OtherEffortsModel();
		oemObj.setEffortTrackingModel(etmObj);
		oemObj.setEmailing(emailing);
		oemObj.setTrainingElearningPrjctSpecific(trainingElearningPrjctSpecific);
		oemObj.setTrainingElearningNonPrjctSpecific(trainingElearningNonPrjctSpecific);
		oemObj.setEnvironmentUnavailability(environmentUnavailability);
		oemObj.setOrganisationalActivities(organisationalActivities);
		oemObj.setKnowledgePortalMaintainance(knowledgePortalMaintainance);
		oemObj.setLeavesPlanned(leavesPlanned);
		oemObj.setLeavesUnplanned(leavesUnplanned);
		
		
		effortTrackingService.saveObject(oemObj);
		System.out.println("other models id"+oemObj.getOthereffortsId());
		addActionMessage("Efforts Saved Successfully");
		return SUCCESS;
		}
		catch(Exception e)
		{

			addActionError("Error Occured while saving efforts");
			return INPUT;
		}
	}
	
	//retrieve prjct names based on date for editing efforts screen
	public String  getProjectNamesBasedonDate()
	{
		
		  Map<String,Object> session=getSession();
		  String EmpID= (String) session.get("EmpIdSession");
		 
		prjctNamesBasedDate=effortTrackingService.getProjectBasedonDate(showProjectForDate,EmpID);//
		
		System.out.println("a list size"+prjctNames.size());
		System.out.println("ajax appln name is"+showProjectForDate);
		 System.out.println("emp id from session getProjectNamesBasedonDate"+EmpID);
	/*	for(EffortTrackingModel pcmModel:prjctNames)
		{
			prjctNamesBasedOnDateList.add(pcmModel.getProject_Name());
			System.out.println(""+pcmModel.getProject_Name());
		}*/
		
		return SUCCESS;
		
		
	}
	
	public String  getProjectDetailsBasedOnEffortID()
	{
		System.out.println("effrt id s"+editEffortsEffortID);
		effortsList=effortTrackingService.getEffortdetails(editEffortsEffortID);
		System.out.println("effrt id size is s"+effortsList.size());
		return SUCCESS;
	}
	public String updateEffortDetails()
	{
		EffortTrackingModel etmObj=effortTrackingService.getAlreadyExistedEffortObj(EffortId);
		
		try{
			  Map<String,Object> session=getSession();
			String EmpID= (String) session.get("EmpIdSession");
			etmObj.setEmpId(EmpID);
			etmObj.setRole(ETRole);
			etmObj.setPrjctName(Project_Name_ET);
			etmObj.setDatOfEntry(ETDateOfEntry);
			etmObj.setTestPlanPreparationCreate(testPlanPreparationCreate);
			etmObj.setTestPlanPreparationReview(testPlanPreparationReview);
			etmObj.setTestPlanPreparationRework(testPlanPreparationRework);
			etmObj.setEstimationnResourceLoding(estimationnResourceLoding);
			etmObj.setTaskAllocationandCoordination(taskAllocationandCoordination);
			etmObj.setProcessAudit(processAudit);
			//effortTrackingService.updateObject(etmObj);
			
			TestAnalysisDesignModel tadObj=new TestAnalysisDesignModel();
			tadObj.setEffortTrackingModel(etmObj);
			tadObj.setTestAnalysisId(hiddenTestAnalysisID);
			tadObj.setRequirementUnderstading(requirementUnderstading);
			tadObj.setClarificationTracking(clarificationTracking);
			tadObj.setCreateUpdateRTM(createUpdateRTM);
			tadObj.setCreatUpdateTestScenarios(creatUpdateTestScenarios);
			tadObj.setTestScenariosSimple(testScenariosSimple);
			tadObj.setTestScenariosMedium(testScenariosMedium);
			tadObj.setTestScenariosComplex(testScenariosComplex);
			tadObj.setTcDesignCreate(tcDesignCreate);
			tadObj.setTcDesignReview(tcDesignReview);
			tadObj.setTcDesignRework(tcDesignRework);
			tadObj.setTcDesignSimple(tcDesignSimple);
			tadObj.setTcDesignMedium(tcDesignMedium);
			tadObj.setTcDesignComplex(tcDesignComplex);
			tadObj.setTestDataSetupCreate(testDataSetupCreate);
			tadObj.setTestDataSetupRecreate(testDataSetupRecreate);
			
			//effortTrackingService.updateObject(tadObj);
			
			TestExecutionModel temObj=new TestExecutionModel();
			temObj.setEffortTrackingModel(etmObj);
			temObj.setTestExecutionId(hiddenTestExecID);
			temObj.setFunTestExecNew(funTestExecNew);
			temObj.setFunTestExecRetest(funTestExecRetest);
			temObj.setFunTestExecSimple(funTestExecSimple);
			temObj.setFunTestExecMedium(funTestExecMedium);
			temObj.setFunTestExecComplex(funTestExecComplex);
			temObj.setIntegTestExecNew(integTestExecNew);
			temObj.setIntegTestExecRetest(integTestExecRetest);
			temObj.setIntegTestExecSimple(integTestExecSimple);
			temObj.setIntegTestExecMedium(integTestExecMedium);
			temObj.setIntegTestExecComplex(integTestExecComplex);
			temObj.setRegressionTestExecNew(regressionTestExecNew);
			temObj.setRegressionTestExecRetest(regressionTestExecRetest);
			temObj.setRegressionTestExecSimple(regressionTestExecSimple);
			temObj.setRegressionTestExecMedium(regressionTestExecMedium);
			temObj.setRegressionTestExecComplex(regressionTestExecComplex);
			temObj.setAdhocTesting(adhocTesting);
			temObj.setDefectReporting(defectReporting);
			temObj.setDefectReporingCritical(defectReporingCritical);
			temObj.setDefectReporingMajor(defectReporingMajor);
			temObj.setDefectReporingMinor(defectReporingMinor);
			temObj.setTesLogDocCreate(tesLogDocCreate);
			temObj.setTestLogDocReview(testLogDocReview);
			temObj.setTestLogDocRework(testLogDocRework);
			
			//effortTrackingService.updateObject(temObj);
			System.out.println("TestExecutionModel id is"+temObj.getTestExecutionId());
			
			TestReportingclosureModel trcObj=new TestReportingclosureModel();
			trcObj.setEffortTrackingModel(etmObj);
			trcObj.setTestClosureId(hiddenTestClosureID);
			trcObj.setTestMetricsGeneration(testMetricsGeneration);
			trcObj.setTestSummaryReport(testSummaryReport);
			trcObj.setInternalScheduledCalls(internalScheduledCalls);
			trcObj.setInternalUnscheduledCalls(internalUnscheduledCalls);
			trcObj.setProjectRelatedMeetings(projectRelatedMeetings);
			trcObj.setOtherMeetings(otherMeetings);
			trcObj.setRegressionSuiteUpdate(regressionSuiteUpdate);
			trcObj.setKnowledgeTransition(knowledgeTransition);
			trcObj.setStatusReportDailyWeekly(statusReportDailyWeekly);
		
			
		//	effortTrackingService.updateObject(trcObj);
			
			System.out.println("TestReportingclosureModel id is"+trcObj.getTestClosureId());
			OtherEffortsModel oemObj=new OtherEffortsModel();
			oemObj.setEffortTrackingModel(etmObj);
			oemObj.setOthereffortsId(hiddenOtherEffortsID);
			oemObj.setEmailing(emailing);
			oemObj.setTrainingElearningPrjctSpecific(trainingElearningPrjctSpecific);
			oemObj.setTrainingElearningNonPrjctSpecific(trainingElearningNonPrjctSpecific);
			oemObj.setEnvironmentUnavailability(environmentUnavailability);
			oemObj.setOrganisationalActivities(organisationalActivities);
			oemObj.setKnowledgePortalMaintainance(knowledgePortalMaintainance);
			oemObj.setLeavesPlanned(leavesPlanned);
			oemObj.setLeavesUnplanned(leavesUnplanned);
			
			etmObj.setTestAnaylysisDesign(tadObj);
			etmObj.setTestExecution(temObj);
			etmObj.setTestReportClosure(trcObj);
			etmObj.setOtherEfforts(oemObj);
			effortTrackingService.updateObject(etmObj);
			
			System.out.println("other models update id"+oemObj.getOthereffortsId());
			addActionMessage("Efforts updated Successfully");
			return SUCCESS;
			}
			catch(Exception e)
			{

				addActionError("Error Occured while updating efforts");
				return INPUT;
			}
	}
	
	
/*	
	public EffortTrackingService getEffortTrackingService() {
		return effortTrackingService;
	}
	public void setEffortTrackingService(EffortTrackingService effortTrackingService) {
		this.effortTrackingService = effortTrackingService;
	}*/
	public String getETDateOfEntry() {
		return ETDateOfEntry;
	}
	public void setETDateOfEntry(String eTDateOfEntry) {
		ETDateOfEntry = eTDateOfEntry;
	}
	public String getETRole() {
		return ETRole;
	}
	public void setETRole(String eTRole) {
		ETRole = eTRole;
	}
	public String getTestPlanPreparationCreate() {
		return testPlanPreparationCreate;
	}
	public void setTestPlanPreparationCreate(String testPlanPreparationCreate) {
		this.testPlanPreparationCreate = testPlanPreparationCreate;
	}
	public String getTestPlanPreparationReview() {
		return testPlanPreparationReview;
	}
	public void setTestPlanPreparationReview(String testPlanPreparationReview) {
		this.testPlanPreparationReview = testPlanPreparationReview;
	}
	public String getTestPlanPreparationRework() {
		return testPlanPreparationRework;
	}
	public void setTestPlanPreparationRework(String testPlanPreparationRework) {
		this.testPlanPreparationRework = testPlanPreparationRework;
	}
	public String getEstimationnResourceLoding() {
		return estimationnResourceLoding;
	}
	public void setEstimationnResourceLoding(String estimationnResourceLoding) {
		this.estimationnResourceLoding = estimationnResourceLoding;
	}
	public String getTaskAllocationandCoordination() {
		return taskAllocationandCoordination;
	}
	public void setTaskAllocationandCoordination(
			String taskAllocationandCoordination) {
		this.taskAllocationandCoordination = taskAllocationandCoordination;
	}
	public String getProcessAudit() {
		return processAudit;
	}
	public void setProcessAudit(String processAudit) {
		this.processAudit = processAudit;
	}
	public String getRequirementUnderstading() {
		return requirementUnderstading;
	}
	public void setRequirementUnderstading(String requirementUnderstading) {
		this.requirementUnderstading = requirementUnderstading;
	}
	public String getClarificationTracking() {
		return clarificationTracking;
	}
	public void setClarificationTracking(String clarificationTracking) {
		this.clarificationTracking = clarificationTracking;
	}
	public String getCreateUpdateRTM() {
		return createUpdateRTM;
	}
	public void setCreateUpdateRTM(String createUpdateRTM) {
		this.createUpdateRTM = createUpdateRTM;
	}
	public String getCreatUpdateTestScenarios() {
		return creatUpdateTestScenarios;
	}
	public void setCreatUpdateTestScenarios(String creatUpdateTestScenarios) {
		this.creatUpdateTestScenarios = creatUpdateTestScenarios;
	}
	public String getTestScenariosSimple() {
		return testScenariosSimple;
	}
	public void setTestScenariosSimple(String testScenariosSimple) {
		this.testScenariosSimple = testScenariosSimple;
	}
	public String getTestScenariosMedium() {
		return testScenariosMedium;
	}
	public void setTestScenariosMedium(String testScenariosMedium) {
		this.testScenariosMedium = testScenariosMedium;
	}
	public String getTestScenariosComplex() {
		return testScenariosComplex;
	}
	public void setTestScenariosComplex(String testScenariosComplex) {
		this.testScenariosComplex = testScenariosComplex;
	}
	public String getTcDesignCreate() {
		return tcDesignCreate;
	}
	public void setTcDesignCreate(String tcDesignCreate) {
		this.tcDesignCreate = tcDesignCreate;
	}
	public String getTcDesignReview() {
		return tcDesignReview;
	}
	public void setTcDesignReview(String tcDesignReview) {
		this.tcDesignReview = tcDesignReview;
	}
	public String getTcDesignRework() {
		return tcDesignRework;
	}
	public void setTcDesignRework(String tcDesignRework) {
		this.tcDesignRework = tcDesignRework;
	}
	public String getTcDesignSimple() {
		return tcDesignSimple;
	}
	public void setTcDesignSimple(String tcDesignSimple) {
		this.tcDesignSimple = tcDesignSimple;
	}
	public String getTcDesignMedium() {
		return tcDesignMedium;
	}
	public void setTcDesignMedium(String tcDesignMedium) {
		this.tcDesignMedium = tcDesignMedium;
	}
	public String getTcDesignComplex() {
		return tcDesignComplex;
	}
	public void setTcDesignComplex(String tcDesignComplex) {
		this.tcDesignComplex = tcDesignComplex;
	}
	public String getTestDataSetupCreate() {
		return testDataSetupCreate;
	}
	public void setTestDataSetupCreate(String testDataSetupCreate) {
		this.testDataSetupCreate = testDataSetupCreate;
	}
	public String getTestDataSetupRecreate() {
		return testDataSetupRecreate;
	}
	public void setTestDataSetupRecreate(String testDataSetupRecreate) {
		this.testDataSetupRecreate = testDataSetupRecreate;
	}
	public String getFunTestExecNew() {
		return funTestExecNew;
	}
	public void setFunTestExecNew(String funTestExecNew) {
		this.funTestExecNew = funTestExecNew;
	}
	public String getFunTestExecRetest() {
		return funTestExecRetest;
	}
	public void setFunTestExecRetest(String funTestExecRetest) {
		this.funTestExecRetest = funTestExecRetest;
	}
	public String getFunTestExecSimple() {
		return funTestExecSimple;
	}
	public void setFunTestExecSimple(String funTestExecSimple) {
		this.funTestExecSimple = funTestExecSimple;
	}
	public String getFunTestExecMedium() {
		return funTestExecMedium;
	}
	public void setFunTestExecMedium(String funTestExecMedium) {
		this.funTestExecMedium = funTestExecMedium;
	}
	public String getFunTestExecComplex() {
		return funTestExecComplex;
	}
	public void setFunTestExecComplex(String funTestExecComplex) {
		this.funTestExecComplex = funTestExecComplex;
	}
	public String getIntegTestExecNew() {
		return integTestExecNew;
	}
	public void setIntegTestExecNew(String integTestExecNew) {
		this.integTestExecNew = integTestExecNew;
	}
	public String getIntegTestExecRetest() {
		return integTestExecRetest;
	}
	public void setIntegTestExecRetest(String integTestExecRetest) {
		this.integTestExecRetest = integTestExecRetest;
	}
	public String getIntegTestExecSimple() {
		return integTestExecSimple;
	}
	public void setIntegTestExecSimple(String integTestExecSimple) {
		this.integTestExecSimple = integTestExecSimple;
	}
	public String getIntegTestExecMedium() {
		return integTestExecMedium;
	}
	public void setIntegTestExecMedium(String integTestExecMedium) {
		this.integTestExecMedium = integTestExecMedium;
	}
	public String getIntegTestExecComplex() {
		return integTestExecComplex;
	}
	public void setIntegTestExecComplex(String integTestExecComplex) {
		this.integTestExecComplex = integTestExecComplex;
	}
	public String getRegressionTestExecNew() {
		return regressionTestExecNew;
	}
	public void setRegressionTestExecNew(String regressionTestExecNew) {
		this.regressionTestExecNew = regressionTestExecNew;
	}
	public String getRegressionTestExecRetest() {
		return regressionTestExecRetest;
	}
	public void setRegressionTestExecRetest(String regressionTestExecRetest) {
		this.regressionTestExecRetest = regressionTestExecRetest;
	}
	public String getRegressionTestExecSimple() {
		return regressionTestExecSimple;
	}
	public void setRegressionTestExecSimple(String regressionTestExecSimple) {
		this.regressionTestExecSimple = regressionTestExecSimple;
	}
	public String getRegressionTestExecMedium() {
		return regressionTestExecMedium;
	}
	public void setRegressionTestExecMedium(String regressionTestExecMedium) {
		this.regressionTestExecMedium = regressionTestExecMedium;
	}
	public String getRegressionTestExecComplex() {
		return regressionTestExecComplex;
	}
	public void setRegressionTestExecComplex(String regressionTestExecComplex) {
		this.regressionTestExecComplex = regressionTestExecComplex;
	}
	public String getAdhocTesting() {
		return adhocTesting;
	}
	public void setAdhocTesting(String adhocTesting) {
		this.adhocTesting = adhocTesting;
	}
	public String getDefectReporting() {
		return defectReporting;
	}
	public void setDefectReporting(String defectReporting) {
		this.defectReporting = defectReporting;
	}
	public String getDefectReporingCritical() {
		return defectReporingCritical;
	}
	public void setDefectReporingCritical(String defectReporingCritical) {
		this.defectReporingCritical = defectReporingCritical;
	}
	public String getDefectReporingMajor() {
		return defectReporingMajor;
	}
	public void setDefectReporingMajor(String defectReporingMajor) {
		this.defectReporingMajor = defectReporingMajor;
	}
	public String getDefectReporingMinor() {
		return defectReporingMinor;
	}
	public void setDefectReporingMinor(String defectReporingMinor) {
		this.defectReporingMinor = defectReporingMinor;
	}
	public String getTesLogDocCreate() {
		return tesLogDocCreate;
	}
	public void setTesLogDocCreate(String tesLogDocCreate) {
		this.tesLogDocCreate = tesLogDocCreate;
	}
	public String getTestLogDocReview() {
		return testLogDocReview;
	}
	public void setTestLogDocReview(String testLogDocReview) {
		this.testLogDocReview = testLogDocReview;
	}
	public String getTestLogDocRework() {
		return testLogDocRework;
	}
	public void setTestLogDocRework(String testLogDocRework) {
		this.testLogDocRework = testLogDocRework;
	}
	public String getStatusReportDailyWeekly() {
		return statusReportDailyWeekly;
	}
	public void setStatusReportDailyWeekly(String statusReportDailyWeekly) {
		this.statusReportDailyWeekly = statusReportDailyWeekly;
	}
	public String getTestMetricsGeneration() {
		return testMetricsGeneration;
	}
	public void setTestMetricsGeneration(String testMetricsGeneration) {
		this.testMetricsGeneration = testMetricsGeneration;
	}
	public String getTestSummaryReport() {
		return testSummaryReport;
	}
	public void setTestSummaryReport(String testSummaryReport) {
		this.testSummaryReport = testSummaryReport;
	}
	public String getInternalScheduledCalls() {
		return internalScheduledCalls;
	}
	public void setInternalScheduledCalls(String internalScheduledCalls) {
		this.internalScheduledCalls = internalScheduledCalls;
	}
	public String getInternalUnscheduledCalls() {
		return internalUnscheduledCalls;
	}
	public void setInternalUnscheduledCalls(String internalUnscheduledCalls) {
		this.internalUnscheduledCalls = internalUnscheduledCalls;
	}
	public String getProjectRelatedMeetings() {
		return projectRelatedMeetings;
	}
	public void setProjectRelatedMeetings(String projectRelatedMeetings) {
		this.projectRelatedMeetings = projectRelatedMeetings;
	}
	public String getOtherMeetings() {
		return otherMeetings;
	}
	public void setOtherMeetings(String otherMeetings) {
		this.otherMeetings = otherMeetings;
	}
	public String getRegressionSuiteUpdate() {
		return regressionSuiteUpdate;
	}
	public void setRegressionSuiteUpdate(String regressionSuiteUpdate) {
		this.regressionSuiteUpdate = regressionSuiteUpdate;
	}
	public String getKnowledgeTransition() {
		return knowledgeTransition;
	}
	public void setKnowledgeTransition(String knowledgeTransition) {
		this.knowledgeTransition = knowledgeTransition;
	}
	public String getEmailing() {
		return emailing;
	}
	public void setEmailing(String emailing) {
		this.emailing = emailing;
	}
	public String getTrainingElearningPrjctSpecific() {
		return trainingElearningPrjctSpecific;
	}
	public void setTrainingElearningPrjctSpecific(
			String trainingElearningPrjctSpecific) {
		this.trainingElearningPrjctSpecific = trainingElearningPrjctSpecific;
	}
	public String getTrainingElearningNonPrjctSpecific() {
		return trainingElearningNonPrjctSpecific;
	}
	public void setTrainingElearningNonPrjctSpecific(
			String trainingElearningNonPrjctSpecific) {
		this.trainingElearningNonPrjctSpecific = trainingElearningNonPrjctSpecific;
	}
	public String getEnvironmentUnavailability() {
		return environmentUnavailability;
	}
	public void setEnvironmentUnavailability(String environmentUnavailability) {
		this.environmentUnavailability = environmentUnavailability;
	}
	public String getOrganisationalActivities() {
		return organisationalActivities;
	}
	public void setOrganisationalActivities(String organisationalActivities) {
		this.organisationalActivities = organisationalActivities;
	}
	public String getKnowledgePortalMaintainance() {
		return knowledgePortalMaintainance;
	}
	public void setKnowledgePortalMaintainance(String knowledgePortalMaintainance) {
		this.knowledgePortalMaintainance = knowledgePortalMaintainance;
	}
	public String getLeavesPlanned() {
		return leavesPlanned;
	}
	public void setLeavesPlanned(String leavesPlanned) {
		this.leavesPlanned = leavesPlanned;
	}
	public String getLeavesUnplanned() {
		return leavesUnplanned;
	}
	public void setLeavesUnplanned(String leavesUnplanned) {
		this.leavesUnplanned = leavesUnplanned;
	}


	public EffortTrackingService getEffortTrackingService() {
		return effortTrackingService;
	}


	public void setEffortTrackingService(EffortTrackingService effortTrackingService) {
		this.effortTrackingService = effortTrackingService;
	}


	public String getProject_Name_ET() {
		return Project_Name_ET;
	}


	public void setProject_Name_ET(String project_Name_ET) {
		Project_Name_ET = project_Name_ET;
	}


	public Long getEffortId() {
		return EffortId;
	}


	public void setEffortId(Long effortId) {
		EffortId = effortId;
	}

	public List<EffortTrackingModel> getPrjctNamesBasedDate() {
		return prjctNamesBasedDate;
	}

	public void setPrjctNamesBasedDate(List<EffortTrackingModel> prjctNamesBasedDate) {
		this.prjctNamesBasedDate = prjctNamesBasedDate;
	}

	public List<ProjectCreationModel> getPrjctNames() {
		return prjctNames;
	}

	public void setPrjctNames(List<ProjectCreationModel> prjctNames) {
		this.prjctNames = prjctNames;
	}

	public List<EffortTrackingModel> getEffortsList() {
		return effortsList;
	}

	public void setEffortsList(List<EffortTrackingModel> effortsList) {
		this.effortsList = effortsList;
	}

	public Long getEditEffortsEffortID() {
		return editEffortsEffortID;
	}

	public void setEditEffortsEffortID(Long editEffortsEffortID) {
		this.editEffortsEffortID = editEffortsEffortID;
	}

	public Long getHiddenTestAnalysisID() {
		return hiddenTestAnalysisID;
	}

	public void setHiddenTestAnalysisID(Long hiddenTestAnalysisID) {
		this.hiddenTestAnalysisID = hiddenTestAnalysisID;
	}

	public Long getHiddenTestExecID() {
		return hiddenTestExecID;
	}

	public void setHiddenTestExecID(Long hiddenTestExecID) {
		this.hiddenTestExecID = hiddenTestExecID;
	}

	public Long getHiddenTestClosureID() {
		return hiddenTestClosureID;
	}

	public void setHiddenTestClosureID(Long hiddenTestClosureID) {
		this.hiddenTestClosureID = hiddenTestClosureID;
	}

	public Long getHiddenOtherEffortsID() {
		return hiddenOtherEffortsID;
	}

	public void setHiddenOtherEffortsID(Long hiddenOtherEffortsID) {
		this.hiddenOtherEffortsID = hiddenOtherEffortsID;
	}



	
}
