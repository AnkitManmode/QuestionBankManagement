package com.jbk.QuestionBank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.QuestionBank.entity.Question;
import com.jbk.QuestionBank.service.QuestionService;

@RestController
@RequestMapping("/question")
public class ControllerQuestion {
	private QuestionService service;

	@PostMapping(value = "/saveQuestion")
	public ResponseEntity<List<Question>> saveQuestion(@RequestBody Question question){
		boolean isAdded = service.saveQuestion(question);
		return new ResponseEntity<List<Question>>(HttpStatus.CREATED);
	}

	@GetMapping (value = "/getQuestion")
	public ResponseEntity<List<Question>>getQuestion(@PathVariable String questionNo){
		List<Question> getQuestions= service.getQuestion();
		if(getQuestions.isEmpty()) {
			return new ResponseEntity<List<Question>>(getQuestions, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Question>>(getQuestions, HttpStatus.OK);
		}
	}
	@DeleteMapping(value ="/deleteQuestion{questionNo}")
	public ResponseEntity<Boolean> deleteQuestion(@PathVariable String questionNo){
		boolean isDeleted = service.deleteQuestion(questionNo);
		if(isDeleted) {
			return new ResponseEntity<Boolean> (isDeleted ,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(isDeleted,HttpStatus.NO_CONTENT);

	}
}
