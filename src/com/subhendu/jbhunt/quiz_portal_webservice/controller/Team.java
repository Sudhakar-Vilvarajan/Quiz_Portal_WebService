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
import com.subhendu.jbhunt.quiz_portal_webservice.dao.ExcelDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ResponceUtil;

/**
 * Servlet implementation class Team
 */
@WebServlet("/team")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Team() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Team GET route has been hit");
		ResponceUtil.enrichResponceHeader(response);
		PrintWriter pw = response.getWriter();
		ResponceBean responceBean = null;
				
		ExcelDao excelDao = new ExcelDao();
		Gson gson = new Gson();		
		
		try {
			responceBean = new ResponceBean(excelDao.getAllTeams());
		}
		catch (QuizPortalWebServiceException error) {
			responceBean = new ResponceBean(error);
		}
		pw.print(gson.toJson(responceBean));
		pw.close();
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Team POST route has been hit");
		ResponceUtil.enrichResponceHeader(response);
		PrintWriter pw = response.getWriter();
		ResponceBean responceBean = null;
				
//		ExcelDao excelDao = new ExcelDao();
		Gson gson = new Gson();		
		
//		TeamBean teamBean = gson.fromJson(request.getReader(), TeamBean.class);
//		try {
			responceBean = new ResponceBean("Successfull responce from Team POST route");
//		}
//		catch (QuizPortalWebServiceException error) {
//			responceBean = new ResponceBean(error);
//		}
		pw.print(gson.toJson(responceBean));
		pw.close();
		pw.flush();
	}

}
