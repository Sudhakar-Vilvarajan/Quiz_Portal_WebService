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
import com.subhendu.jbhunt.quiz_portal_webservice.services.QuestionService;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.RequestUtil;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ResponceUtil;

/**
 * Servlet implementation class Question
 */
@WebServlet("/question/*")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private QuestionService questionService = new QuestionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Question GET route has been hit");
		ResponceUtil.enrichResponceHeader(response);
		PrintWriter pw = response.getWriter();
		ResponceBean responceBean = null;
		
		try {
			if(RequestUtil.hasParam(request, Context.QP_QUESTION_COURSEID)) {
				responceBean = new ResponceBean(
					questionService.getQuestionsForCourseID(
						RequestUtil.getParam(request, Context.QP_QUESTION_COURSEID), 
						questionService.getAllQuestions()
					)
				);
			}
//			else if(RequestUtil.hasEmbeddedID(request))
//				responceBean = new ResponceBean(
//					questionService.getQuestionsForCourseID(
//						RequestUtil.getEmbededID(request),
//						questionService.getAllQuestions()
//					)
//				);
			else
				responceBean = new ResponceBean(questionService.getAllQuestions());
		} catch (QuizPortalWebServiceException error) {
			responceBean = new ResponceBean(error);
		}
		
		pw.print(gson.toJson(responceBean));
		pw.close();
		pw.flush();
	}

}
