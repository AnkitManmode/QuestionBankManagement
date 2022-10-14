package com.jbk.QuestionBank.dao;

import java.util.List;

import com.jbk.QuestionBank.entity.Subject;

public interface SubjectDao {

	public boolean saveSubject (Subject subject);
	
	public List<Subject> getSubject();
	
	public boolean deleteSubject(String subjectNo);
	
	public boolean updateSubject(Subject subject);
	
	
}
