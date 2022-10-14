package com.jbk.QuestionBank.service;

import java.util.List;

import com.jbk.QuestionBank.entity.Subject;


public interface SubjectService {
		
	public boolean saveSubject (Subject subject);
	
	public List<Subject> getSubject();
	
	public boolean deleteSubject(String subjectNo);
	
	public boolean updateSubject(Subject subject);

	public List<Subject>sortSubject(String sortBy);
	
	public int getTotalCountOfSubject();
}
