package com.projetoextensao.autismo.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> notValid(MethodArgumentNotValidException e) {
		String message = e.getMessage();
		String error = "MethodArgumentNotValidException";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError(LocalDate.now(), status, error, message);
		return new ResponseEntity<>(err, err.getStatus());
	}
	
}