package com.subhendu.jbhunt.quiz_portal_webservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.CourseBean;
import com.subhendu.jbhunt.quiz_portal_webservice.beans.TeamBean;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.service.TeamService;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ExcelUtil;

public class CourseDao {
	private ExcelUtil excelUtil = new ExcelUtil();
	private TeamService teamService = new TeamService();	
	
	public List<CourseBean> getAllCourses() throws QuizPortalWebServiceException{
		List<CourseBean> allCourses = new ArrayList<CourseBean>();
		
		List<TeamBean> allTeams = teamService.getAllTeams();
		XSSFWorkbook workbook = excelUtil.getWorkbook();
		try {
			XSSFSheet sheet = workbook.getSheet(Context.CourseTable);
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum()!=0) {
					CourseBean courseBean = new CourseBean();
					
					courseBean.setId((long)row.getCell(0).getNumericCellValue());
					courseBean.setTeam(teamService.getTeamByID((long)row.getCell(1).getNumericCellValue(), allTeams));
					courseBean.setName(row.getCell(2).getStringCellValue());
					courseBean.setDescription(row.getCell(3).getStringCellValue());
					courseBean.setNumberOfQuestions((int)row.getCell(4).getNumericCellValue());
					courseBean.setDurationInMins((int)row.getCell(5).getNumericCellValue());
					courseBean.setCreatedBy(row.getCell(6).getStringCellValue());
					courseBean.setCreatedDate(row.getCell(7).getDateCellValue());
					
					allCourses.add(courseBean);
				}
			}
			System.out.println("fetched all courses");
		} 
		catch (Exception e) {
			throw new QuizPortalWebServiceException(Context.ERROR_FETCH_ALL_TEAMS + " -> " + e.getLocalizedMessage());
		}
		
		excelUtil.closeWorkbook(workbook);
		return allCourses;
	}
}
