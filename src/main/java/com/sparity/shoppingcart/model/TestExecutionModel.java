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
@Table(name="TestExecution")
public class TestExecutionModel extends BaseModel {
	
	@Id
	@GeneratedValue
	@Column(name = "TestExecution_Id",unique=true, nullable=false, precision=10)
	private Long TestExecutionId;
	
	@Column(name="FunTestExecNew", length=20)
	private String funTestExecNew;
	
	@Column(name="FunTestExecReTest", length=20)
	private String funTestExecRetest;
	
	@Column(name="FunTestExecSimple", length=20)
	private String funTestExecSimple;
	
	@Column(name="FunTestExecMedium", length=20)
	private String funTestExecMedium;
	
	@Column(name="FunTestExecComplex", length=20)
	private String funTestExecComplex;
	
	@Column(name="IntegTestExecNew", length=20)
	private String integTestExecNew;
	
	@Column(name="IntegTestExecReTest", length=20)
	private String integTestExecRetest;
	
	@Column(name="IntegTestExecSimple", length=20)
	private String integTestExecSimple;
	
	@Column(name="IntegTestExecMedium", length=20)
	private String integTestExecMedium;
	
	@Column(name="IntegTestExecComplex", length=20)
	private String integTestExecComplex;
	
	@Column(name="RegTestExecNew", length=20)
	private String regressionTestExecNew;
	
	@Column(name="RegTestExecReTest", length=20)
	private String regressionTestExecRetest;
	
	@Column(name="RegTestExecSimple", length=20)
	private String regressionTestExecSimple;
	
	@Column(name="RegTestExecMedium", length=20)
	private String regressionTestExecMedium;
	
	@Column(name="RegTestExecComplex", length=20)
	private String regressionTestExecComplex;
	
	@Column(name="Adhoctesting", length=20)
	private String adhocTesting;
	
	@Column(name="DfctReporting", length=20)
	private String defectReporting;
	
	@Column(name="DfctReportingCritical", length=20)
	private String defectReporingCritical;
	
	@Column(name="DfctReportingMajor", length=20)
	private String defectReporingMajor;
	
	@Column(name="DfctReportingMinor", length=20)
	private String defectReporingMinor;
	
	@Column(name="TestLogDocCreate", length=20)
	private String tesLogDocCreate;
	
	@Column(name="TestLogDocReview", length=20)
	private String testLogDocReview;
	
	@Column(name="TestLogDocRework", length=20)
	private String testLogDocRework;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Effort_id",updatable=true,insertable=true)
	private EffortTrackingModel effortTrackingModel;
	
	
	

	public Long getTestExecutionId() {
		return TestExecutionId;
	}

	public void setTestExecutionId(Long testExecutionId) {
		TestExecutionId = testExecutionId;
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

	public EffortTrackingModel getEffortTrackingModel() {
		return effortTrackingModel;
	}

	public void setEffortTrackingModel(EffortTrackingModel effortTrackingModel) {
		this.effortTrackingModel = effortTrackingModel;
	}
	

}
