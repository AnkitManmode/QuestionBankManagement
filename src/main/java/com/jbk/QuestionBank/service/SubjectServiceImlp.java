package com.jbk.QuestionBank.service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.QuestionBank.comparator.SubjectNameComparator;
import com.jbk.QuestionBank.comparator.SubjectNoComparator;
import com.jbk.QuestionBank.dao.SubjectDao;
import com.jbk.QuestionBank.entity.Subject;


@Service
public class SubjectServiceImlp implements SubjectService {
	
	@Autowired
	private SubjectDao dao;
	
	@Override
	public boolean saveSubject(Subject subject) {
			 if(subject.getSubjectNo() == null) {
				 String no = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
				 subject.setSubjectNo(no);
			 }
	boolean isAdded = dao.saveSubject(subject);
	return isAdded;
	}

	@Override
	public List<Subject> getSubject() {
		List<Subject>getSubject = dao.getSubject();
		return getSubject;
	}

	@Override
	public boolean deleteSubject(String subjectNo) {
		boolean isDeleted = dao.deleteSubject(subjectNo);
		return isDeleted;
	}

	@Override
	public boolean updateSubject(Subject subject) {
		boolean isUpdated = dao.updateSubject(subject);
		return isUpdated;
	}

	@Override
	public List<Subject> sortSubject(String sortBy) {
		
		List<Subject>list = getSubject();
		if(!list.isEmpty()) {

			if(sortBy.equalsIgnoreCase("subjectName")) {
				Collections.sort(list,new SubjectNameComparator());

			}else if(sortBy.equalsIgnoreCase("subjectNo")) {
				Collections.sort(list, new SubjectNoComparator());
			}
		}
		return list;
	}

	@Override
	public int getTotalCountOfSubject() {
		List<Subject>countSub = getSubject();
		int size = 0;
		if(countSub.size() > 0) {
			size = countSub.size();
		}
		return size;
	}
	
	
	}
	

