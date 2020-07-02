package com.subhendu.jbhunt.quiz_portal_webservice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.subhendu.jbhunt.quiz_portal_webservice.services.QuestionService;

/**
 * Servlet implementation class Question
 */
@WebServlet("/question")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
