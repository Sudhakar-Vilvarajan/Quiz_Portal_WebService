package com.subhendu.jbhunt.quiz_portal_webservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subhendu.jbhunt.quiz_portal_webservice.dao.QuestionDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.RequestUtil;

/**
 * Servlet implementation class Test
 */
@WebServlet({ "/test/*"})
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	resp.getWriter().print("from get"+ req.getMethod());
//    }
//    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	QuestionDao q = new QuestionDao();
    	PrintWriter pw = resp.getWriter();
    	pw.append("You hit the Root/Test GET route.");
    	try {
			pw.append("\nQuestions : "+ q.getAllQuestions());
		} catch (QuizPortalWebServiceException e) {
			pw.append("\nError : "+ e.getMessage());
			e.printStackTrace();
		}
    	
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.getWriter().append("You hit the Root/Test POST route ").append(req.getPathInfo());
    	
    }
}
