package com.jbk.QuestionBank.dao;

import java.util.List;

import com.jbk.QuestionBank.entity.Question;
import com.jbk.QuestionBank.entity.Subject;

public interface QuestionDao {
	
	public boolean saveQuestion (Question question);
	
	public List<Question> getQuestion();
	
	public boolean deleteQuestion(String questionNo);
}
