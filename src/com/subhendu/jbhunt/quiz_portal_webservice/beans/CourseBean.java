package com.subhendu.jbhunt.quiz_portal_webservice.beans;

import java.util.Date;

public class CourseBean {
	private long id;
	private String name;
	private String description;
	private int numberOfQuestions;
	private int durationInMins;
	private String createdBy;
	private Date createdDate;
	private TeamBean team;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "CourseBean [id=" + id + ", name=" + name + ", description=" + description + ", numberOfQuestions="
				+ numberOfQuestions + ", durationInMins=" + durationInMins + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", team=" + team + "]";
	}
	public CourseBean(long id, String name, String description, int numberOfQuestions, int durationInMins,
			String createdBy, Date createdDate, TeamBean team) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.numberOfQuestions = numberOfQuestions;
		this.durationInMins = durationInMins;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.team = team;
	}
	public TeamBean getTeam() {
		return team;
	}
	public void setTeam(TeamBean team) {
		this.team = team;
	}
	public CourseBean() {
		super();
	}
	
	
}
