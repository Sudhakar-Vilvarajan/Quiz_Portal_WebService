package com.subhendu.jbhunt.quiz_portal_webservice.beans;

import java.util.Date;
import java.util.List;

public class QuestionBean {
	private long id;
	private long courseID;
	private String type;
	private String text;
	private List<OptionBean> options;
	private String createdBy;
	private Date createdDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCourseID() {
		return courseID;
	}
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<OptionBean> getOptions() {
		return options;
	}
	public void setOptions(List<OptionBean> options) {
		this.options = options;
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
	public QuestionBean(long id, long courseID, String type, String text, List<OptionBean> options, String createdBy,
			Date createdDate) {
		super();
		this.id = id;
		this.courseID = courseID;
		this.type = type;
		this.text = text;
		this.options = options;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	public QuestionBean() {
		super();
	}
	@Override
	public String toString() {
		return "QuestionBean [id=" + id + ", courseID=" + courseID + ", type=" + type + ", text=" + text + ", options="
				+ options + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}

}
