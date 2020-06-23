package com.subhendu.jbhunt.quiz_portal_webservice.beans;

import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;

public class ResponceBean {
	private boolean isSuccess;
	private Object result;
	private QuizPortalWebServiceException error;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public QuizPortalWebServiceException getError() {
		return error;
	}
	public void setError(QuizPortalWebServiceException error) {
		this.error = error;
	}
	public ResponceBean(Object object) {
		if(QuizPortalWebServiceException.class == object.getClass()) {
			this.isSuccess = false;
			this.error = (QuizPortalWebServiceException)object;
			this.result = null;
		}
		else {
			this.isSuccess=true;
			this.result = object;
			this.error = null;
		}
	}
	
	
	
	
	
	

}
