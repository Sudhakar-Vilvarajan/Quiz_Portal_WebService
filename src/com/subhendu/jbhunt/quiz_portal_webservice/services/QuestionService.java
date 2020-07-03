package com.subhendu.jbhunt.quiz_portal_webservice.services;

import java.util.ArrayList;
import java.util.List;

import com.subhendu.jbhunt.quiz_portal_webservice.beans.QuestionBean;
import com.subhendu.jbhunt.quiz_portal_webservice.dao.QuestionDao;
import com.subhendu.jbhunt.quiz_portal_webservice.exception.QuizPortalWebServiceException;
import com.subhendu.jbhunt.quiz_portal_webservice.utils.Context;

public class QuestionService {
	private QuestionDao questionDao = new QuestionDao();
	
	public List<QuestionBean> getAllQuestions() throws QuizPortalWebServiceException{
		List<QuestionBean> allQuestions = questionDao.getAllQuestions();
		
		if(allQuestions.size()==0)
			throw new QuizPortalWebServiceException(Context.ERROR_NO_QUESTION_AVAILABLE);
		
		return allQuestions;
	}
	
	
	
	public List<QuestionBean> getQuestionsForCourseID(long courseID, List<QuestionBean> allQuestions) throws QuizPortalWebServiceException{
		List<QuestionBean> filteredQuestions = new ArrayList<QuestionBean>();
		
		for(QuestionBean question : allQuestions) {
			if(question.getCourseID()==courseID)
				filteredQuestions.add(question);
		}
		if(filteredQuestions.size()==0) {
			throw new QuizPortalWebServiceException(Context.ERROR_NO_QUESTION_AVAILABLE + "for CourseID : " + courseID);
		}		
		
		return filteredQuestions;
	}
	
	
}
