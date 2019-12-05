package com.sparity.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="ProjectMgmt")
public class EffortTrackingModel extends BaseModel{

	

	private static final long serialVersionUID = 683099735368810123L;
	@Id
	@GeneratedValue
	@Column(name = "Effort_id",unique=true, nullable=false, precision=10)
	private Long EffortId;
	
	@Column(name="EmpID", length=20)
	private String empId;
	
	
	@Column(name="Role", length=20)
	private String role;
	
	@Column(name="ProjectName", length=20)
	private String prjctName;
	

	@Column(name="DatOfEntry", length=20)
	private String datOfEntry;
	
	@Column(name="TstPlanPrepartionCreate", length=20)
	private String testPlanPreparationCreate;
	
	@Column(name="TstPlanPrepartionReview", length=20)
	private String testPlanPreparationReview;
	
	@Column(name="TstPlanPrepartionRework", length=20)
	private String testPlanPreparationRework;
	
	@Column(name="EstimationandResourceLoading", length=20)
	private String estimationnResourceLoding;
	
	@Column(name="TaskAllocationCoordination", length=20)
	private String taskAllocationandCoordination;
	
	@Column(name="ProcessAudit", length=20)
	private String processAudit;
	
	
	@OneToOne(mappedBy="effortTrackingModel",targetEntity = TestAnalysisDesignModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private TestAnalysisDesignModel testAnaylysisDesign;
	
	
	@OneToOne(mappedBy="effortTrackingModel",targetEntity = TestExecutionModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private TestExecutionModel testExecution;
	
	@OneToOne(mappedBy="effortTrackingModel",targetEntity = TestReportingclosureModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private TestReportingclosureModel testReportClosure;
	
	@OneToOne(mappedBy="effortTrackingModel",targetEntity = OtherEffortsModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private OtherEffortsModel otherEfforts;
	

	public Long getEffortId() {
		return EffortId;
	}

	public void setEffortId(Long effortId) {
		EffortId = effortId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPrjctName() {
		return prjctName;
	}

	public void setPrjctName(String prjctName) {
		this.prjctName = prjctName;
	}

	public String getDatOfEntry() {
		return datOfEntry;
	}

	public void setDatOfEntry(String datOfEntry) {
		this.datOfEntry = datOfEntry;
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
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public TestAnalysisDesignModel getTestAnaylysisDesign() {
		return testAnaylysisDesign;
	}

	public void setTestAnaylysisDesign(TestAnalysisDesignModel testAnaylysisDesign) {
		this.testAnaylysisDesign = testAnaylysisDesign;
	}

	public TestExecutionModel getTestExecution() {
		return testExecution;
	}

	public void setTestExecution(TestExecutionModel testExecution) {
		this.testExecution = testExecution;
	}

	public TestReportingclosureModel getTestReportClosure() {
		return testReportClosure;
	}

	public void setTestReportClosure(TestReportingclosureModel testReportClosure) {
		this.testReportClosure = testReportClosure;
	}

	public OtherEffortsModel getOtherEfforts() {
		return otherEfforts;
	}

	public void setOtherEfforts(OtherEffortsModel otherEfforts) {
		this.otherEfforts = otherEfforts;
	}

	
	
	
	
	
	
	
	
	
}


