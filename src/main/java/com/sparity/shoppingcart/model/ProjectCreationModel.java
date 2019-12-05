package com.sparity.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="productcreation")
public class ProjectCreationModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "proj_id",unique=true, nullable=false, precision=10)
	private Long ProjectID;
	
	@Column(name="ApplicationName")
	private String ApplicationName;
	
	@Column(name="Project_Name", length=100)
	private String Project_Name;
	
	@Column(name="ProjectType")
	private String ProjectType;
	
	@Column(name="plannedstartDate")
	private String plannedstartDate;
	
	@Column(name="plannedendDate")
	private String plannedendDate;
	
	@Column(name="Estimated_Effort")
	private String Estimated_Effort;
	
	@Column(name="Allocated_Effort")
	private String Allocated_Effort;
	
	@Column(name="Planned_Execution_Effort")
	private String Planned_Execution_Effort;
	
	@Column(name="Planned_Data_Setup_Effort")
	private String Planned_Data_Setup_Effort;
	
	@Column(name="Number_of_OriginalReq")
	private String Number_of_OriginalReq;
	
	@Column(name="Number_of_Risksidentified")
	private String Number_of_Risksidentified;
	
	@Column(name="Actual_Start_dt")
	private String Actual_Start_dt;
	
	@Column(name="Actual_End_dt")
	private String Actual_End_dt;
	
	@Column(name="No_Of_UatDefects")
	private String No_Of_UatDefects;
	
	@Column(name="No_Of_ProdDefects")
	private String No_Of_ProdDefects;
	
	@Column(name="No_Of_RejectedDefects")
	private String No_Of_RejectedDefects;
	
	@Column(name="Req_Count_Added")
	private String Req_Count_Added;
	
	@Column(name="Req_Count_Modified")
	private String Req_Count_Modified;
	
	@Column(name="Req_Count_Deleted")
	private String Req_Count_Deleted;
	
	@Column(name="No_Of_ReviewComments")
	private String No_Of_ReviewComments;
	
	@Column(name="No_Of_ReveiwDfctsFoundByClient")
	private String No_Of_ReveiwDfctsFoundByClient;
	
	@Column(name="Cummulative_Code_Drop_Delay")
	private String Cummulative_Code_Drop_Delay;
	
	@Column(name="Req_Related_DfctsFound_AnaylysisPhase")
	private String Req_Related_DfctsFound_AnaylysisPhase;
	
	@Column(name="Req_Related_DfctsFound_EntirePrjctCycle")
	private String Req_Related_DfctsFound_EntirePrjctCycle;
	
	@Column(name="No_OfRisksMitigatedButOccured")
	private String No_OfRisksMitigatedButOccured;
	
	
	
	
	
	
	
	
	
	
	public Long getProjectID() {
		return ProjectID;
	}
	public void setProjectID(Long projectID) {
		ProjectID = projectID;
	}
	public String getApplicationName() {
		return ApplicationName;
	}
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
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
	public String getActual_Start_dt() {
		return Actual_Start_dt;
	}
	public void setActual_Start_dt(String actual_Start_dt) {
		Actual_Start_dt = actual_Start_dt;
	}
	public String getActual_End_dt() {
		return Actual_End_dt;
	}
	public void setActual_End_dt(String actual_End_dt) {
		Actual_End_dt = actual_End_dt;
	}
	public String getNo_Of_UatDefects() {
		return No_Of_UatDefects;
	}
	public void setNo_Of_UatDefects(String no_Of_UatDefects) {
		No_Of_UatDefects = no_Of_UatDefects;
	}
	public String getNo_Of_ProdDefects() {
		return No_Of_ProdDefects;
	}
	public void setNo_Of_ProdDefects(String no_Of_ProdDefects) {
		No_Of_ProdDefects = no_Of_ProdDefects;
	}
	public String getNo_Of_RejectedDefects() {
		return No_Of_RejectedDefects;
	}
	public void setNo_Of_RejectedDefects(String no_Of_RejectedDefects) {
		No_Of_RejectedDefects = no_Of_RejectedDefects;
	}
	public String getReq_Count_Added() {
		return Req_Count_Added;
	}
	public void setReq_Count_Added(String req_Count_Added) {
		Req_Count_Added = req_Count_Added;
	}
	public String getReq_Count_Modified() {
		return Req_Count_Modified;
	}
	public void setReq_Count_Modified(String req_Count_Modified) {
		Req_Count_Modified = req_Count_Modified;
	}
	public String getReq_Count_Deleted() {
		return Req_Count_Deleted;
	}
	public void setReq_Count_Deleted(String req_Count_Deleted) {
		Req_Count_Deleted = req_Count_Deleted;
	}
	public String getNo_Of_ReviewComments() {
		return No_Of_ReviewComments;
	}
	public void setNo_Of_ReviewComments(String no_Of_ReviewComments) {
		No_Of_ReviewComments = no_Of_ReviewComments;
	}
	public String getNo_Of_ReveiwDfctsFoundByClient() {
		return No_Of_ReveiwDfctsFoundByClient;
	}
	public void setNo_Of_ReveiwDfctsFoundByClient(
			String no_Of_ReveiwDfctsFoundByClient) {
		No_Of_ReveiwDfctsFoundByClient = no_Of_ReveiwDfctsFoundByClient;
	}
	public String getCummulative_Code_Drop_Delay() {
		return Cummulative_Code_Drop_Delay;
	}
	public void setCummulative_Code_Drop_Delay(String cummulative_Code_Drop_Delay) {
		Cummulative_Code_Drop_Delay = cummulative_Code_Drop_Delay;
	}
	public String getReq_Related_DfctsFound_AnaylysisPhase() {
		return Req_Related_DfctsFound_AnaylysisPhase;
	}
	public void setReq_Related_DfctsFound_AnaylysisPhase(
			String req_Related_DfctsFound_AnaylysisPhase) {
		Req_Related_DfctsFound_AnaylysisPhase = req_Related_DfctsFound_AnaylysisPhase;
	}
	public String getReq_Related_DfctsFound_EntirePrjctCycle() {
		return Req_Related_DfctsFound_EntirePrjctCycle;
	}
	public void setReq_Related_DfctsFound_EntirePrjctCycle(
			String req_Related_DfctsFound_EntirePrjctCycle) {
		Req_Related_DfctsFound_EntirePrjctCycle = req_Related_DfctsFound_EntirePrjctCycle;
	}
	public String getNo_OfRisksMitigatedButOccured() {
		return No_OfRisksMitigatedButOccured;
	}
	public void setNo_OfRisksMitigatedButOccured(
			String no_OfRisksMitigatedButOccured) {
		No_OfRisksMitigatedButOccured = no_OfRisksMitigatedButOccured;
	}
	

}
