package com.projetoextensao.autismo.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {
	
	private LocalDate timestamp;
	private HttpStatus status;
	private String err;
	private String message;
	
}
