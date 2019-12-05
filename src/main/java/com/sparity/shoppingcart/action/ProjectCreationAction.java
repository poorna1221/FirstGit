package com.sparity.shoppingcart.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.inject.util.Strings;
import com.sparity.shoppingcart.base.action.BaseAction;
import com.sparity.shoppingcart.service.ProductService;
import com.sparity.shoppingcart.service.ProjectCreationService;
import com.sparity.shoppingcart.model.*;
public class ProjectCreationAction extends BaseAction{
	
	private ProjectCreationService prjctCreationService = (ProjectCreationService) getServiceBean("projectCreationService");
	

	private String ApplicationName;
	
	private String Project_Name;
	
	private String ProjectType;
	
	private String plannedstartDate;
	
	private String plannedendDate;
	
	private String Estimated_Effort;
	
	private String Allocated_Effort;
	
	private String Planned_Execution_Effort;
	
	private String Planned_Data_Setup_Effort;
	
	private String Number_of_OriginalReq;
	
	private String Number_of_Risksidentified;
	
	
	private String actualstartDate;
	
	private String actualendDate;
	
	private String noofUATDefects;
	
	private String noofProdDefects;
	
	private String noofRejectedDfcts;
	
	private String reqCountAdded;
	
	private String reqCountModified;
	
    private String reqCountDeleted;
	
	private String noofReviewComments;
	
	private String noofReviewDefctsFoundByClient;
	
	private String cummulativeCodeDropDelay;
	
	private String reqDfctsAnalysisPhase;
	
	private String reqDfctsinEntirePrjctCycle;
	
	private String noofRisksMitigatedButOccured;
	
	List<String> prjctNamesList=new ArrayList<String>();
	
	private String selectedEmpID;
	
	private String AdminUser;
	
	private String NormalUser;
	
	List<ApplcationUsersModel> usersList=new ArrayList<ApplcationUsersModel>();
	
	List<String> empIdsList=new ArrayList<String>();
	
	public String saveProjectDetails()
	{
		
		ProjectCreationModel alreadyExistedPrjct=prjctCreationService.getAlreadyExistedPrjctObj(Project_Name);
		if(alreadyExistedPrjct==null){
			
		ProjectCreationModel prjctCreationModel=new ProjectCreationModel();
		System.out.println("appln"+ApplicationName);
		System.out.println("appln"+Project_Name);
		System.out.println("appln"+ProjectType);
		System.out.println("appln"+plannedstartDate);
		System.out.println("appln"+plannedendDate);
		System.out.println("appln"+Estimated_Effort);
		System.out.println("appln"+Allocated_Effort);
		System.out.println("appln"+Planned_Execution_Effort);
		System.out.println("appln"+Planned_Data_Setup_Effort);
		System.out.println("appln"+Number_of_OriginalReq);
		System.out.println("no of risks"+Number_of_Risksidentified);
		prjctCreationModel.setApplicationName(ApplicationName);
		prjctCreationModel.setProject_Name(Project_Name);
		prjctCreationModel.setProjectType(ProjectType);
		prjctCreationModel.setPlannedstartDate(plannedstartDate);
		prjctCreationModel.setPlannedendDate(plannedendDate);
		prjctCreationModel.setEstimated_Effort(Estimated_Effort);
		prjctCreationModel.setAllocated_Effort(Allocated_Effort);
		prjctCreationModel.setPlanned_Execution_Effort(Planned_Execution_Effort);
		prjctCreationModel.setPlanned_Data_Setup_Effort(Planned_Data_Setup_Effort);
		prjctCreationModel.setNumber_of_OriginalReq(Number_of_OriginalReq);
		prjctCreationModel.setNumber_of_Risksidentified(Number_of_Risksidentified);
		
		prjctCreationService.saveProjectDetails(prjctCreationModel);
		
		System.out.println("project fgdf is id"+prjctCreationModel.getProjectID());
		return SUCCESS;
		}
		else
		{
			addActionError("Same Project Name is already found in db for the same application...");
			 return SUCCESS;
		}
	}
	
	public String  getProjectNames()
	{
		List<ProjectCreationModel> prjctNames=prjctCreationService.getProjectBasedonApplication(ApplicationName);
		System.out.println("no of project for applns are"+prjctNames.size());
		System.out.println("ajax appln name is"+ApplicationName);
		for(ProjectCreationModel pcmModel:prjctNames)
		{
			prjctNamesList.add(pcmModel.getProject_Name());
			System.out.println(""+pcmModel.getProject_Name());
		}
		
		return SUCCESS;
		
		
	}
	
	
	
	public String  updateProjectDetails()
	{
		
		ProjectCreationModel alreadyExistedPrjct=prjctCreationService.getAlreadyExistedPrjctObj(Project_Name);
	
		if(alreadyExistedPrjct!=null)
		{
		//ProjectCreationModel updatePrjctDetilsModel=new ProjectCreationModel();
			alreadyExistedPrjct.setApplicationName(ApplicationName);
			alreadyExistedPrjct.setProject_Name(Project_Name);
			alreadyExistedPrjct.setActual_Start_dt(actualstartDate);
			alreadyExistedPrjct.setActual_End_dt(actualendDate);
			alreadyExistedPrjct.setNo_Of_UatDefects(noofUATDefects);
			alreadyExistedPrjct.setNo_Of_ProdDefects(noofProdDefects);
			alreadyExistedPrjct.setNo_Of_RejectedDefects(noofRejectedDfcts);
			alreadyExistedPrjct.setReq_Count_Added(reqCountAdded);
			alreadyExistedPrjct.setReq_Count_Modified(reqCountModified);
			alreadyExistedPrjct.setReq_Count_Deleted(reqCountDeleted);
			alreadyExistedPrjct.setNo_Of_ReviewComments(noofReviewComments);
			alreadyExistedPrjct.setNo_Of_ReveiwDfctsFoundByClient(noofReviewDefctsFoundByClient);
			alreadyExistedPrjct.setCummulative_Code_Drop_Delay(cummulativeCodeDropDelay);
			alreadyExistedPrjct.setReq_Related_DfctsFound_AnaylysisPhase(reqDfctsAnalysisPhase);
			alreadyExistedPrjct.setReq_Related_DfctsFound_EntirePrjctCycle(reqDfctsinEntirePrjctCycle);
			alreadyExistedPrjct.setNo_OfRisksMitigatedButOccured(noofRisksMitigatedButOccured);
		
		    prjctCreationService.updatePrjctDetails(alreadyExistedPrjct);
		return SUCCESS;
		}else
		{
			  addActionError("Project Details not found in Database");
		       return ERROR;
		}
	}
	
	public String  adminOrNormalUser()
	{
		ApplcationUsersModel aum=prjctCreationService.getUserType(selectedEmpID);
		  Map<String,Object> session=getSession();
		  session.put("EmpIdSession", selectedEmpID);
		
		
			if(aum.getTypeOfUser().equalsIgnoreCase("yes"))
			{
				System.out.println("user"+aum.getEmpId()+" user type is"+aum.getTypeOfUser().toString());
				return SUCCESS;
			}
			else
			{
				return INPUT;
			}
	}
	public String retrieveAllUsers()
	{
     usersList=prjctCreationService.getUsersList();
     
     for(ApplcationUsersModel aum:usersList)
		{
    	 empIdsList.add(aum.getEmpId());
		}
	return SUCCESS;
		
	}
	 
	

	
	
	public ProjectCreationService getPrjctCreationService() {
		return prjctCreationService;
	}

	public void setPrjctCreationService(ProjectCreationService prjctCreationService) {
		this.prjctCreationService = prjctCreationService;
	}

	

	public String getProject_Name() {
		return Project_Name;
	}

	public void setProject_Name(String project_Name) {
		Project_Name = project_Name;
	}

	public String getProjectType() {
		return ProjectType;
	}

	public void setProjectType(String projectType) {
		ProjectType = projectType;
	}

	public String getPlannedstartDate() {
		return plannedstartDate;
	}

	public void setPlannedstartDate(String plannedstartDate) {
		this.plannedstartDate = plannedstartDate;
	}

	public String getPlannedendDate() {
		return plannedendDate;
	}

	public void setPlannedendDate(String plannedendDate) {
		this.plannedendDate = plannedendDate;
	}

	public String getEstimated_Effort() {
		return Estimated_Effort;
	}

	public void setEstimated_Effort(String estimated_Effort) {
		Estimated_Effort = estimated_Effort;
	}

	public String getAllocated_Effort() {
		return Allocated_Effort;
	}

	public void setAllocated_Effort(String allocated_Effort) {
		Allocated_Effort = allocated_Effort;
	}

	public String getPlanned_Execution_Effort() {
		return Planned_Execution_Effort;
	}

	public void setPlanned_Execution_Effort(String planned_Execution_Effort) {
		Planned_Execution_Effort = planned_Execution_Effort;
	}

	public String getPlanned_Data_Setup_Effort() {
		return Planned_Data_Setup_Effort;
	}

	public void setPlanned_Data_Setup_Effort(String planned_Data_Setup_Effort) {
		Planned_Data_Setup_Effort = planned_Data_Setup_Effort;
	}

	public String getNumber_of_OriginalReq() {
		return Number_of_OriginalReq;
	}

	public void setNumber_of_OriginalReq(String number_of_OriginalReq) {
		Number_of_OriginalReq = number_of_OriginalReq;
	}

	public String getNumber_of_Risksidentified() {
		return Number_of_Risksidentified;
	}

	public void setNumber_of_Risksidentified(String number_of_Risksidentified) {
		Number_of_Risksidentified = number_of_Risksidentified;
	}

	public String getApplicationName() {
		return ApplicationName;
	}

	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}

	public String getActualstartDate() {
		return actualstartDate;
	}

	public void setActualstartDate(String actualstartDate) {
		this.actualstartDate = actualstartDate;
	}

	public String getActualendDate() {
		return actualendDate;
	}

	public void setActualendDate(String actualendDate) {
		this.actualendDate = actualendDate;
	}

	public String getNoofUATDefects() {
		return noofUATDefects;
	}

	public void setNoofUATDefects(String noofUATDefects) {
		this.noofUATDefects = noofUATDefects;
	}

	public String getNoofProdDefects() {
		return noofProdDefects;
	}

	public void setNoofProdDefects(String noofProdDefects) {
		this.noofProdDefects = noofProdDefects;
	}

	public String getNoofRejectedDfcts() {
		return noofRejectedDfcts;
	}

	public void setNoofRejectedDfcts(String noofRejectedDfcts) {
		this.noofRejectedDfcts = noofRejectedDfcts;
	}

	public String getReqCountAdded() {
		return reqCountAdded;
	}

	public void setReqCountAdded(String reqCountAdded) {
		this.reqCountAdded = reqCountAdded;
	}

	public String getReqCountModified() {
		return reqCountModified;
	}

	public void setReqCountModified(String reqCountModified) {
		this.reqCountModified = reqCountModified;
	}

	public String getReqCountDeleted() {
		return reqCountDeleted;
	}

	public void setReqCountDeleted(String reqCountDeleted) {
		this.reqCountDeleted = reqCountDeleted;
	}

	public String getNoofReviewComments() {
		return noofReviewComments;
	}

	public void setNoofReviewComments(String noofReviewComments) {
		this.noofReviewComments = noofReviewComments;
	}

	public String getNoofReviewDefctsFoundByClient() {
		return noofReviewDefctsFoundByClient;
	}

	public void setNoofReviewDefctsFoundByClient(
			String noofReviewDefctsFoundByClient) {
		this.noofReviewDefctsFoundByClient = noofReviewDefctsFoundByClient;
	}

	public String getCummulativeCodeDropDelay() {
		return cummulativeCodeDropDelay;
	}

	public void setCummulativeCodeDropDelay(String cummulativeCodeDropDelay) {
		this.cummulativeCodeDropDelay = cummulativeCodeDropDelay;
	}

	public String getReqDfctsAnalysisPhase() {
		return reqDfctsAnalysisPhase;
	}

	public void setReqDfctsAnalysisPhase(String reqDfctsAnalysisPhase) {
		this.reqDfctsAnalysisPhase = reqDfctsAnalysisPhase;
	}

	public String getReqDfctsinEntirePrjctCycle() {
		return reqDfctsinEntirePrjctCycle;
	}

	public void setReqDfctsinEntirePrjctCycle(String reqDfctsinEntirePrjctCycle) {
		this.reqDfctsinEntirePrjctCycle = reqDfctsinEntirePrjctCycle;
	}

	public String getNoofRisksMitigatedButOccured() {
		return noofRisksMitigatedButOccured;
	}

	public void setNoofRisksMitigatedButOccured(String noofRisksMitigatedButOccured) {
		this.noofRisksMitigatedButOccured = noofRisksMitigatedButOccured;
	}

	public List<String> getPrjctNamesList() {
		return prjctNamesList;
	}

	public void setPrjctNamesList(List<String> prjctNamesList) {
		this.prjctNamesList = prjctNamesList;
	}

	public List<ApplcationUsersModel> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<ApplcationUsersModel> usersList) {
		this.usersList = usersList;
	}

	public List<String> getEmpIdsList() {
		return empIdsList;
	}

	public void setEmpIdsList(List<String> empIdsList) {
		this.empIdsList = empIdsList;
	}

	public String getSelectedEmpID() {
		return selectedEmpID;
	}

	public void setSelectedEmpID(String selectedEmpID) {
		this.selectedEmpID = selectedEmpID;
	}

	public String getAdminUser() {
		return AdminUser;
	}

	public void setAdminUser(String adminUser) {
		AdminUser = adminUser;
	}

	public String getNormalUser() {
		return NormalUser;
	}

	public void setNormalUser(String normalUser) {
		NormalUser = normalUser;
	}


	
	
	
}
