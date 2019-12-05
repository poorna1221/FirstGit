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
@Table(name="TestReportingClosure")
public class TestReportingclosureModel extends BaseModel{
	
	@Id
	@GeneratedValue
	@Column(name = "Test_Closure_Id",unique=true, nullable=false, precision=10)
	private Long testClosureId;
	
	@Column(name="StatusReportsDailyWeekly", length=20)
	private String statusReportDailyWeekly;
	
	@Column(name="TestMetricsGeneration", length=20)
	private String testMetricsGeneration;
	
	@Column(name="TestSummaryReports", length=20)
	private String testSummaryReport;
	
	@Column(name="InternalScheduledCalls", length=20)
	private String internalScheduledCalls;
	
	@Column(name="InternalUnscheduledCalls", length=20)
	private String internalUnscheduledCalls;
	
	@Column(name="ProjectRelatedMeetings", length=20)
	private String projectRelatedMeetings;
	
	@Column(name="OtherMeetings", length=20)
	private String otherMeetings;
	
	@Column(name="RegressionSuiteUpdate", length=20)
	private String regressionSuiteUpdate;
	
	@Column(name="KnowledgeTransition", length=20)
	private String knowledgeTransition;
	
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Effort_id",updatable=true,insertable=true)
	private EffortTrackingModel effortTrackingModel;
	
	
	
	

	public Long getTestClosureId() {
		return testClosureId;
	}

	public void setTestClosureId(Long testClosureId) {
		this.testClosureId = testClosureId;
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

	public EffortTrackingModel getEffortTrackingModel() {
		return effortTrackingModel;
	}

	public void setEffortTrackingModel(EffortTrackingModel effortTrackingModel) {
		this.effortTrackingModel = effortTrackingModel;
	}
	
	
	

}
