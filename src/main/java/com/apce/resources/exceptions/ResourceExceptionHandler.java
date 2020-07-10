package com.apce.resources.exceptions;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apce.services.exceptions.DataIntegrityException;
import com.apce.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(StandardError.builder().status(HttpStatus.NOT_FOUND.value()).msg(e.getMessage())
						.timeStamp(System.currentTimeMillis()).build());
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(StandardError.builder().status(HttpStatus.BAD_REQUEST.value()).msg(e.getMessage())
						.timeStamp(System.currentTimeMillis()).build());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ValidationError.builder().status(HttpStatus.BAD_REQUEST.value()).msg("Validation error")
						.timeStamp(System.currentTimeMillis())
						.errors(e.getBindingResult().getFieldErrors().stream()
								.map(item -> FieldMessage.builder().fieldName(item.getField())
										.message(item.getDefaultMessage()).build())
								.collect(Collectors.toList()))
						.build());
	}

}
