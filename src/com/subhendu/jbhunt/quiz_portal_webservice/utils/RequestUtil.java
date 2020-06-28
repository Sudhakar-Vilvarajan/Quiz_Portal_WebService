package com.subhendu.jbhunt.quiz_portal_webservice.utils;

import javax.servlet.http.HttpServletRequest;

import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;

public class RequestUtil {
	public static boolean hasEmbeddedID(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		return (pathInfo == null || pathInfo.equals("/")) ? false : true ;
	}
	
	public static long getEmbededID(HttpServletRequest request) throws QuizPortalWebServiceException {
		long id = 0;
		
		String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/"))
			throw new QuizPortalWebServiceException(Context.ERROR_ID_HAS_NO_PROVIDED);
		try {
			id = Long.parseLong(pathInfo.substring(1));
		} catch (NumberFormatException e) {
			throw new QuizPortalWebServiceException(Context.ERROR_NO_A_VALID_ID);
		}
		
		return id;
	}
}
