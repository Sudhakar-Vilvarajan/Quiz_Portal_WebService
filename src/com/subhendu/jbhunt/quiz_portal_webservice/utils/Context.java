package com.subhendu.jbhunt.quiz_portal_webservice.utils;

public class Context {
	
// 	DB Details 
	public static final String dbpath = "/DB.xlsx"; 
	public static final String TeamTable = "Team";
	public static final String CourseTable = "Course";
	public static final String QuestionTable = "Question";
	
	
//	Query Parameters
	public static final String QP_COURSE_TEAMID = "teamID";
	public static final String QP_QUESTION_COURSEID = "courseID";
	
	
	
//	Error Messages
	private static final String ERROR_INITIAL = "Error occured while ";
	public static final String ERROR_CONNECT_DB = ERROR_INITIAL + "connecting DB";
	public static final String ERROR_DISCONNECT_DB = ERROR_INITIAL + "disconnecting DB";
	public static final String ERROR_FETCH_ALL_TEAMS = ERROR_INITIAL + "fetching all teams";
	public static final String ERROR_FETCH_ALL_COURSES = ERROR_INITIAL + "fetching all courses";
	public static final String ERROR_FETCH_ALL_QUESTIONS = ERROR_INITIAL + "fetching all questions";
	
	
	public static final String ERROR_NO_TEAM_AVAILABLE = "No team available";
	public static final String ERROR_NO_COURSE_AVAILABLE = "No course available";
	public static final String ERROR_NO_QUESTION_AVAILABLE = "No question available";
	public static final String ERROR_ID_HAS_NO_PROVIDED = "ID has not provided";
	public static final String ERROR_NO_A_VALID_ID = "Not a valid ID";
}
