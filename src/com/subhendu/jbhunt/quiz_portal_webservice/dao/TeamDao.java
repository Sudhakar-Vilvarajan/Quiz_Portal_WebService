package com.subhendu.jbhunt.quiz_portal_webservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.TeamBean;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ExcelUtil;

public class TeamDao {
	public List<TeamBean> getAllTeams() throws QuizPortalWebServiceException{
		List<TeamBean> allTeams = new ArrayList<TeamBean>();
		
		ExcelUtil excelUtill = new ExcelUtil();
		XSSFWorkbook workbook = excelUtill.getWorkbook();
		try {
			XSSFSheet sheet = workbook.getSheet(Context.TeamTable);
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum()!=0) {
					TeamBean teamBean = new TeamBean();
					
					teamBean.setId((long)row.getCell(0).getNumericCellValue());
					teamBean.setName(row.getCell(1).getStringCellValue());
					teamBean.setCreatedBy(row.getCell(2).getStringCellValue());
					teamBean.setCreatedDate(row.getCell(3).getDateCellValue());
					teamBean.setBackgroundImageURL(row.getCell(4).getStringCellValue());
					
					allTeams.add(teamBean);
				}
			}
			System.out.println("fetched all teams");
		} 
		catch (Exception e) {
			throw new QuizPortalWebServiceException(Context.ERROR_FETCH_ALL_TEAMS + " -> " + e.getLocalizedMessage());
		}
		
		excelUtill.closeWorkbook(workbook);
		return allTeams;
	}
	
	
	public TeamBean getTeamByID(long teamID) throws QuizPortalWebServiceException{
		TeamBean teamBean = null;
		
		List<TeamBean> allTeams = getAllTeams();
		for(TeamBean team : allTeams) {
			if(team.getId() == teamID)
				return team;
		}
		
		return teamBean;
	}
}
