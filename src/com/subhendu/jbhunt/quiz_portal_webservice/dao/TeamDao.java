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
	private ExcelUtil excelUtil = new ExcelUtil();
	
	public List<TeamBean> getAllTeams() throws QuizPortalWebServiceException{
		List<TeamBean> allTeams = new ArrayList<TeamBean>();
		
		XSSFWorkbook workbook = excelUtil.getWorkbook();
		try {
			XSSFSheet sheet = workbook.getSheet(Context.TeamTable);
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum()!=0) {
					TeamBean teamBean = new TeamBean();
					
					teamBean.setId((long)row.getCell(0).getNumericCellValue());
					teamBean.setName(row.getCell(1).getStringCellValue().trim());
					teamBean.setCreatedBy(row.getCell(2).getStringCellValue().trim());
					teamBean.setCreatedDate(row.getCell(3).getDateCellValue());
					teamBean.setBackgroundImageURL(row.getCell(4).getStringCellValue().trim());
					
					allTeams.add(teamBean);
				}
			}
		} 
		catch (Exception e) {
			throw new QuizPortalWebServiceException(Context.ERROR_FETCH_ALL_TEAMS + " -> " + e.getLocalizedMessage());
		}
		
		excelUtil.closeWorkbook(workbook);
		return allTeams;
	}
}
