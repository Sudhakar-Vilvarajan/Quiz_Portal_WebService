package com.subhendu.jbhunt.quiz_portal_webservice.service;

import java.util.List;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.TeamBean;
import com.subhendu.jbhunt.quiz_portal_webservice.dao.TeamDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;

public class TeamService {
	private TeamDao teamDao = new TeamDao();
	
	public List<TeamBean> getAllTeams() throws QuizPortalWebServiceException{
		List<TeamBean> allTeams = teamDao.getAllTeams();
		if(allTeams.size() == 0) {
			throw new QuizPortalWebServiceException(Context.ERROR_NO_TEAM_AVAILABLE);
		}
		return allTeams;
	}
	
	
	public TeamBean getTeamByID(long teamID) throws QuizPortalWebServiceException{
		
		List<TeamBean> allTeams = getAllTeams();
		for(TeamBean team : allTeams) {
			if(team.getId() == teamID)
				return team;
		}
		
		{
			throw new QuizPortalWebServiceException(Context.ERROR_NO_TEAM_AVAILABLE + " for team ID : " + teamID);
		}
	}
}
