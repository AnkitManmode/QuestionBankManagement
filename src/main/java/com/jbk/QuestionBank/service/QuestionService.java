package com.jbk.QuestionBank.service;

import java.util.List;

import com.jbk.QuestionBank.entity.Question;


public interface QuestionService {
	 public boolean saveQuestion (Question question);
	 
		public List<Question> getQuestion();
		
		
		public boolean deleteQuestion(String questionNo);
}
