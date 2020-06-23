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
import com.subhendu.jbhunt.quiz_portal_webservice.beans.TeamBean;
import com.subhendu.jbhunt.quiz_portal_webservice.dao.ExcelDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ResponceUtil;

/**
 * Servlet implementation class SingleTeam
 */
@WebServlet("/team/byID")
public class TeamByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TeamByID GET route has been hit");
		ResponceUtil.enrichResponceHeader(response);
		PrintWriter pw = response.getWriter();
		ResponceBean responceBean = null;
				
		ExcelDao excelDao = new ExcelDao();
		Gson gson = new Gson();		
		
		try {
			long teamID;
			try {
				teamID = Long.parseLong(request.getParameter("id"));
			} 
			catch (NumberFormatException e) {
				throw new QuizPortalWebServiceException("Not a vaild TeamID : " + request.getParameter("id"));
			}
			TeamBean searchedTeam = excelDao.getTeamByID(teamID);
			if(searchedTeam == null)
				throw new QuizPortalWebServiceException("No team details found for TeamID : " + teamID);
			else
				responceBean = new ResponceBean(searchedTeam);
		}
		catch (QuizPortalWebServiceException error) {
			responceBean = new ResponceBean(error);
		}
		pw.print(gson.toJson(responceBean));
		pw.close();
		pw.flush();
		
	}

}
