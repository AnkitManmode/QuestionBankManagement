package com.jbk.QuestionBank.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.QuestionBank.dao.QuestionDao;
import com.jbk.QuestionBank.entity.Question;

@Service
public class QuestionServiceImlp implements QuestionService {
	@Autowired
	private QuestionDao dao;
	
	@Override
	public boolean saveQuestion(Question question) {
		if(question.getQuestionNo() == null) {
			 String no = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
			 question.setQuestionNo(no);
		}
		boolean isAdded = dao.saveQuestion(question);
		
		return isAdded;
	}

	@Override
	public List<Question> getQuestion() {
		List <Question> list = dao.getQuestion();
		return list;
	}

	@Override
	public boolean deleteQuestion(String questionNo) {
		boolean isDeleted = dao.deleteQuestion(questionNo);
		
		return isDeleted;
	}


}
