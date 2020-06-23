package com.subhendu.jbhunt.quiz_portal_webservice.beans;

import java.util.Date;

public class TeamBean {
	private long id;
	private String name;
	private Date createdDate;
	private String createdBy;
	private String backgroundImageURL;
	public String getBackgroundImageURL() {
		return backgroundImageURL;
	}
	public void setBackgroundImageURL(String backgroundImageURL) {
		this.backgroundImageURL = backgroundImageURL;
	}
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
	public TeamBean(long id, String name, Date createdDate, String createdBy, String backgroundImageURL) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.backgroundImageURL = backgroundImageURL;
	}
	public TeamBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "TeamBean [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", backgroundImageURL=" + backgroundImageURL + "]";
	}
	
	
	
}
