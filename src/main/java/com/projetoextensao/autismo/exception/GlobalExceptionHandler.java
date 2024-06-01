package com.projetoextensao.autismo.exception;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> notValid(MethodArgumentNotValidException e) {
		List<String> errors = e.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(x -> x.getField() + ": " + x.getDefaultMessage()).toList();
		String message = String.join(", ", errors);
		String error = "Bad Request";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError(Instant.now(), status, error, message);
		return new ResponseEntity<>(err, err.getStatus());
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StandardError> nullPont(NullPointerException e) {
		String message = "Null Pointer";
		String error = "Internal Server Error";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		StandardError err = new StandardError(Instant.now(), status, error, message);
		return new ResponseEntity<>(err, err.getStatus());
	}
}