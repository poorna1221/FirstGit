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
@Table(name="OtherEfforts")
public class OtherEffortsModel extends BaseModel{

	
	@Id
	@GeneratedValue
	@Column(name = "OtherEfforts_Id",unique=true, nullable=false, precision=10)
	private Long othereffortsId;
	
	@Column(name="Emailing", length=20)
	private String emailing;
	
	@Column(name="ElerPrjctSpecific", length=20)
	private String trainingElearningPrjctSpecific;
	
	@Column(name="ElerNonPrjctSpecific", length=20)
	private String trainingElearningNonPrjctSpecific;
	
	@Column(name="EnvironmentUnavailability", length=20)
	private String environmentUnavailability;
	
	@Column(name="OrgActivities", length=20)
	private String organisationalActivities;
	
	@Column(name="KnowledgePortalMaintainence", length=20)
	private String knowledgePortalMaintainance;
	
	@Column(name="LeavesPlanned", length=20)
	private String leavesPlanned;
	
	@Column(name="LeavesUnplanned", length=20)
	private String leavesUnplanned;
	
	
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Effort_id",updatable=true,insertable=true)
	private EffortTrackingModel effortTrackingModel;
	
	
	
	
	
	

	public Long getOthereffortsId() {
		return othereffortsId;
	}

	public void setOthereffortsId(Long othereffortsId) {
		this.othereffortsId = othereffortsId;
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

	public EffortTrackingModel getEffortTrackingModel() {
		return effortTrackingModel;
	}

	public void setEffortTrackingModel(EffortTrackingModel effortTrackingModel) {
		this.effortTrackingModel = effortTrackingModel;
	}
	
	
	
	
	
}
