package com.jbk.QuestionBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.QuestionBank.entity.Subject;
import com.jbk.QuestionBank.exception.SubjectNotFoundException;
import com.jbk.QuestionBank.service.SubjectService;



@RestController
@RequestMapping("/subject")
public class ControllerSubject {

	@Autowired
	private SubjectService service;
	
	@PostMapping (value = "/saveSubject")
	public ResponseEntity<Boolean> saveSubject(@RequestBody Subject subject) {
		boolean isAdded =service.saveSubject(subject);
		if(isAdded) {
		return new ResponseEntity<Boolean>(isAdded,HttpStatus.CREATED);
		}else {
		return new ResponseEntity<Boolean>(isAdded,HttpStatus.ALREADY_REPORTED);
		}
	}
	@GetMapping(value="/getSubject")
	public ResponseEntity<List<Subject>>getSubject(){
		List<Subject> allSubject = service.getSubject();
		if(allSubject.isEmpty()) {
			return new ResponseEntity<List<Subject>>(allSubject, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Subject>>(allSubject, HttpStatus.OK);
		}
	 
	}
	@DeleteMapping(value ="/deleteSubject/{subjectNo}")
		 public ResponseEntity<Boolean>deleteSubject(@PathVariable String subjectNo){
		boolean isDeleted = service.deleteSubject(subjectNo);
		if(isDeleted) {
			return new ResponseEntity<Boolean> (isDeleted ,HttpStatus.OK);
			}
			return new ResponseEntity<Boolean>(isDeleted,HttpStatus.NO_CONTENT);
	}	
	 
	@PutMapping(value= "updateSubject ")
	public ResponseEntity<Boolean>updateSubject(@RequestBody Subject subject){
		boolean isUpdated = service.updateSubject(subject);
		if(isUpdated) {
		return new ResponseEntity<Boolean>(isUpdated , HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value="/sortSubject")
	public ResponseEntity<List<Subject>> sortProduct(@RequestParam String sortBy){
		List<Subject> subjectsort = service.sortSubject(sortBy);
		
		if(!subjectsort.isEmpty()) {
		return new  ResponseEntity<List<Subject>>(subjectsort,HttpStatus.OK);
		}else {
			throw new SubjectNotFoundException("Subject not found for sort:==>"+ sortBy);
		}
	}
	@GetMapping(value="/getTotalCountOfSubject")
	public ResponseEntity<Integer>getTotalCountOfSubject(){
		int NoOfSubject = service.getTotalCountOfSubject();
		if(NoOfSubject > 0) {
			return new ResponseEntity<Integer>(NoOfSubject,HttpStatus.ACCEPTED);
		}else {
		return new ResponseEntity<Integer>(NoOfSubject,HttpStatus.NOT_FOUND);
		}
	}
}

