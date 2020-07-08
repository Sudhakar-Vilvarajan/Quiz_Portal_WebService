package com.subhendu.jbhunt.quiz_portal_webservice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;

public class ExcelUtil {
	public XSSFWorkbook getWorkbook() throws QuizPortalWebServiceException{
		XSSFWorkbook workbook = null;
		try {
			URL url = getClass().getResource(Context.dbpath);
			workbook =  new XSSFWorkbook(new FileInputStream(new File(url.getPath())));
		}
		catch (Exception e) {
			throw new QuizPortalWebServiceException(Context.ERROR_CONNECT_DB + " -> " + e.getLocalizedMessage());
		}
		return workbook;
	}
	
	
	public void closeWorkbook(XSSFWorkbook workbook) throws QuizPortalWebServiceException{
		try {
			workbook.close();
		} 
		catch (Exception e) {
			throw new QuizPortalWebServiceException(Context.ERROR_DISCONNECT_DB + "->" + e.getLocalizedMessage());
		}
	}
	
}
