package com.subhendu.jbhunt.quiz_portal_webservice.beans;

import java.util.Date;

public class TeamBean {
	private long teamID;
	private String teamName;
	private Date createdDate;
	private String createdBy;
	private String backgroundImageURL;
	public String getBackgroundImageURL() {
		return backgroundImageURL;
	}
	public void setBackgroundImageURL(String backgroundImageURL) {
		this.backgroundImageURL = backgroundImageURL;
	}
	public long getTeamID() {
		return teamID;
	}
	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public TeamBean(long teamID, String teamName, Date createdDate, String createdBy, String backgroundImageURL) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.backgroundImageURL = backgroundImageURL;
	}
	public TeamBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "TeamBean [teamID=" + teamID + ", teamName=" + teamName + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", backgroundImageURL=" + backgroundImageURL + "]";
	}
	
	
	
}
