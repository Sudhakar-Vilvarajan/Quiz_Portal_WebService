package com.subhendu.jbhunt.quiz_portal_webservice.utils;

import javax.servlet.http.HttpServletResponse;

public class ResponceUtil {
	
	public static void enrichResponceHeader(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
	}

}
