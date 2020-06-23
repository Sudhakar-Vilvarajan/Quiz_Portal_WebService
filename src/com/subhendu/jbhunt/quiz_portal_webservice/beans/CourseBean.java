package com.subhendu.jbhunt.quiz_portal_webservice.beans;

public class CourseBean {
	private long id;
	private long teamID;
	private String name;
	private String description;
	private int numberOfQuestions;
	private int durationInMins;
	private String createdBy;
	private String createdDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTeamID() {
		return teamID;
	}
	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public int getDurationInMins() {
		return durationInMins;
	}
	public void setDurationInMins(int durationInMins) {
		this.durationInMins = durationInMins;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public CourseBean(long id, long teamID, String name, String description, int numberOfQuestions, int durationInMins,
			String createdBy, String createdDate) {
		super();
		this.id = id;
		this.teamID = teamID;
		this.name = name;
		this.description = description;
		this.numberOfQuestions = numberOfQuestions;
		this.durationInMins = durationInMins;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	
	public CourseBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "CourseBean [id=" + id + ", teamID=" + teamID + ", name=" + name + ", description=" + description
				+ ", numberOfQuestions=" + numberOfQuestions + ", durationInMins=" + durationInMins + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + "]";
	}
	
	
}
