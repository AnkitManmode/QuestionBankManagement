 package com.jbk.QuestionBank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Question {
	@Id
	private String questionNo;
	private String questionName;
	
	public Question() {
	}

	public Question(String questionNo, String questionName) {
		super();
		this.questionNo = questionNo;
		this.questionName = questionName;
		
	}

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	

	@Override
	public String toString() {
		return "Question [QuestionNo=" + questionNo + ", QuestionName=" + questionName + "]";
	}

}