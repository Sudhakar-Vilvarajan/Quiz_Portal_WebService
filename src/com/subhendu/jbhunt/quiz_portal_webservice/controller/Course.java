package com.subhendu.jbhunt.quiz_portal_webservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.subhendu.jbhunt.quiz_portal_webservice.beans.ResponceBean;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.services.CourseService;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.RequestUtil;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ResponceUtil;

/**
 * Servlet implementation class Course
 */
@WebServlet("/course/*")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseService();
	private Gson gson = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Course GET route has been hit");
		ResponceUtil.enrichResponceHeader(response);
		PrintWriter pw = response.getWriter();
		ResponceBean responceBean = null;
		
		try {
			if(RequestUtil.hasParam(request, Context.QP_COURSE_TEAMID))
				responceBean = new ResponceBean(
					courseService.getCoursesForTeamID(
						RequestUtil.getParam(request, Context.QP_COURSE_TEAMID),
						courseService.getAllCourses()
					)
				);
			else
				responceBean = new ResponceBean(courseService.getAllCourses());
		} catch (QuizPortalWebServiceException error) {
			responceBean = new ResponceBean(error);
		}
		
		pw.print(gson.toJson(responceBean));
		pw.close();
		pw.flush();
	}

}
