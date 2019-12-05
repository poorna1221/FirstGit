package com.sparity.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;


@Entity
@Table(name="TestAnalysisDesign")
public class TestAnalysisDesignModel extends BaseModel{

	@Id
	@GeneratedValue
	@Column(name = "TestAnalysis_Id",unique=true, nullable=false, precision=10)
	private Long TestAnalysisId;
	
	@Column(name="Req_Understanding", length=20)
	private String requirementUnderstading;
	
	@Column(name="ClarificationTracking", length=20)
	private String clarificationTracking;
	
	@Column(name="CreateUpdateRTM", length=20)
	private String createUpdateRTM;
	
	@Column(name="CreatUpdateTestScenarios", length=20)
	private String creatUpdateTestScenarios;
	
	@Column(name="TestScenSimple", length=20)
	private String testScenariosSimple;
	
	@Column(name="TestScenariosMedium", length=20)
	private String testScenariosMedium;
	
	@Column(name="TestScenariosComplex", length=20)
	private String testScenariosComplex;
	
	@Column(name="TcDesignCreate", length=20)
	private String tcDesignCreate;
	
	@Column(name="TcDesignReview", length=20)
	private String tcDesignReview;
	
	@Column(name="TcDesignRework", length=20)
	private String tcDesignRework;
	
	@Column(name="TcDesignSimple", length=20)
	private String tcDesignSimple;
	
	@Column(name="TcDesignMedium", length=20)
	private String tcDesignMedium;
	
	@Column(name="TcDesignComplex", length=20)
	private String tcDesignComplex;
	
	@Column(name="TestDataSetupCreate", length=20)
	private String testDataSetupCreate;
	
	@Column(name="TestDataSetupRecreate", length=20)
	private String testDataSetupRecreate;

//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="Effort_id",nullable=false,updatable=true,insertable=true)
//	private EffortTrackingModel effortTrackingModel;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Effort_id",updatable=true,insertable=true)
	private EffortTrackingModel effortTrackingModel;
	
	
	
	
	
	
	
	
	
	
	public Long getTestAnalysisId() {
		return TestAnalysisId;
	}

	public void setTestAnalysisId(Long testAnalysisId) {
		TestAnalysisId = testAnalysisId;
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

	public EffortTrackingModel getEffortTrackingModel() {
		return effortTrackingModel;
	}

	public void setEffortTrackingModel(EffortTrackingModel effortTrackingModel) {
		this.effortTrackingModel = effortTrackingModel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
