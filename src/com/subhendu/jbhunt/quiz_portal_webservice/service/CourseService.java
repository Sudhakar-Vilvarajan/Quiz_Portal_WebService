package com.subhendu.jbhunt.quiz_portal_webservice.service;

import java.util.List;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.CourseBean;
import com.subhendu.jbhunt.quiz_portal_webservice.dao.CourseDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;

public class CourseService {
	private CourseDao courseDao = new CourseDao();
	
	public List<CourseBean> getAllCourses() throws QuizPortalWebServiceException{
		List<CourseBean> allCourses = courseDao.getAllCourses();
		if(allCourses.size() == 0) {
			throw new QuizPortalWebServiceException(Context.ERROR_NO_COURSE_AVAILABLE);
		}
		return allCourses;
	}
}
