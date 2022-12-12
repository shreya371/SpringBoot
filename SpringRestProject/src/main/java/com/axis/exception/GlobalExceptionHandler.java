package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

	
//	@ExceptionHandler(IDNotFoundException.class)
//	public ResponseEntity<String> noIdFound(IDNotFoundException exception)
//	{
//		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler(InvalidPasswordException.class)
//	public ResponseEntity<String> noIdFound(InvalidPasswordException exception)
//	{
//		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.EXPECTATION_FAILED);
//	}
	
	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<ErrorInfo> idNotFound(IDNotFoundException exception)
	{
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setHttpStatus(HttpStatus.NOT_FOUND.toString());;
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorInfo> ivalidPassword(InvalidPasswordException exception)
	{
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMsg());
		errorInfo.setHttpStatus(HttpStatus.NOT_FOUND.toString());;
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	
}
