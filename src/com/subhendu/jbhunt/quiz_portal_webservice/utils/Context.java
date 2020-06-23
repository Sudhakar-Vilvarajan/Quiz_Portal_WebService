package com.subhendu.jbhunt.quiz_portal_webservice.utils;

public class Context {
	public static final String dbpath = "/DB.xlsx"; 
	public static final String TeamTable = "Team";
	
	
	
//	Error Messages
	private static final String ERROR_INITIAL = "Error occured while ";
	
	public static final String ERROR_CONNECT_DB = ERROR_INITIAL + "connecting DB";
	public static final String ERROR_DISCONNECT_DB = ERROR_INITIAL + "disconnecting DB";
	public static final String ERROR_FETCH_ALL_TEAMS = ERROR_INITIAL + "fetching all teams";
	
}
