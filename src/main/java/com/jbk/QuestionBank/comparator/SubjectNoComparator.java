package com.jbk.QuestionBank.comparator;

import java.util.Comparator;

import com.jbk.QuestionBank.entity.Subject;

public class SubjectNoComparator implements Comparator<Subject> {

	@Override
	public int compare(Subject s1, Subject s2) {
		
		return s1.getSubjectNo().compareTo(s2.getSubjectNo());
	}

}
