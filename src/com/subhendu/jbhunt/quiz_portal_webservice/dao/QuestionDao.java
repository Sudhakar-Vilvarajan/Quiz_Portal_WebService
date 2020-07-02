package com.subhendu.jbhunt.quiz_portal_webservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.OptionBean;
import com.subhendu.jbhunt.quiz_portal_webservice.beans.QuestionBean;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.ExcelUtil;

public class QuestionDao {
	private ExcelUtil excelUtil = new ExcelUtil();
	
	public List<QuestionBean> getAllQuestions() throws QuizPortalWebServiceException{
		List<QuestionBean> allQuestion = new ArrayList<QuestionBean>();
		
		XSSFWorkbook workbook = excelUtil.getWorkbook();
		try {
			XSSFSheet sheet = workbook.getSheet(Context.QuestionTable);
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum()!=0) {
					QuestionBean question = new QuestionBean();
					
					question.setId((long)row.getCell(0).getNumericCellValue());
					question.setCourseID((long)row.getCell(1).getNumericCellValue());
					question.setType(row.getCell(2).getStringCellValue().trim());
					question.setText(row.getCell(3).getStringCellValue().trim());
					
					List<OptionBean> allOptions = new ArrayList<OptionBean>();
					for(int i=4; i<=8; i++) {
						try {
							allOptions.add(new OptionBean(row.getCell(i).getStringCellValue().trim(),
														row.getCell(i+5).getNumericCellValue()));
						}
						catch (NullPointerException e) {
							continue;
						}
					}
					
					question.setOptions(allOptions);
					question.setCreatedBy(row.getCell(14).getStringCellValue().trim());
					question.setCreatedDate(row.getCell(15).getDateCellValue());
					
					allQuestion.add(question);
				}
			}
			System.out.println("fetched all questions");
		} 
		catch (Exception e) {
			throw new QuizPortalWebServiceException(Context.ERROR_FETCH_ALL_QUESTIONS + " -> " + e.getLocalizedMessage());
		}
		
		excelUtil.closeWorkbook(workbook);
		return allQuestion;
	}
}
