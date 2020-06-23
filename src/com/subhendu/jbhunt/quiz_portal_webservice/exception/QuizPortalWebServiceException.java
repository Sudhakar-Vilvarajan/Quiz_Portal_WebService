package com.subhendu.jbhunt.quiz_portal_webservice.exception;

public class QuizPortalWebServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public QuizPortalWebServiceException(String errorMessage) {
		super(errorMessage);
	}
	public QuizPortalWebServiceException() {
		super();
	}
	
}
