package com.subhendu.jbhunt.quiz_portal_webservice.services;

import java.util.List;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.QuestionBean;
import com.subhendu.jbhunt.quiz_portal_webservice.dao.QuestionDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;

public class QuestionService {
	private QuestionDao questionDao = new QuestionDao();
	
	public List<QuestionBean> getAllQuestions() throws QuizPortalWebServiceException{
		return questionDao.getAllQuestions();
	}
}
