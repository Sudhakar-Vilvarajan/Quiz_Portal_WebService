package com.subhendu.jbhunt.quiz_portal_webservice.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	public static boolean hasIDEmbedded(HttpServletRequest request) {
		return (request.getPathInfo() != null) ? true : false ;
	}
}
