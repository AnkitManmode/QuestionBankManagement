package com.jbk.QuestionBank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Subject {
	@Id
	private String subjectNo;
	private String subjectName;
	private String subjectChapter;

	public Subject() {
		
	}

	public Subject(String subjectNo, String subjectName, String subjectChapter) {
		super();
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
		this.subjectChapter = subjectChapter;
	}


	public String getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectChapter() {
		return subjectChapter;
	}

	public void setSubjectChapter(String subjectChapter) {
		this.subjectChapter = subjectChapter;
	}


	@Override
	public String toString() {
		return "Subject [subjectNo=" + subjectNo + ", subjectName=" + subjectName + ", subjectChapter=" + subjectChapter
				+ "]";
	}
	
}