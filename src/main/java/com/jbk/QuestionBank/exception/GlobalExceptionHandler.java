package com.jbk.QuestionBank.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.naming.Binding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex ){
		HashMap<String, Object> map = new HashMap<>();
		map.put("Time", new Date());
		
		BindingResult bindingresult = ex.getBindingResult();
		
		List<FieldError>fieldErrors = bindingresult.getFieldErrors();
		
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return map;
	}
		@ExceptionHandler(SubjectNotFoundException.class)
		public ResponseEntity<String>SubjectNotFoundExcept(SubjectNotFoundException ex ){
			
			
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
			
		}
		
	}

