package com.contacts.app.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.contacts.app.dto.ErrorResponseDto;

@RestControllerAdvice
@RestController
public class HandleValidationException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex) {
		List<String> errorList = new ArrayList();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	    	errorList.add(error.getField()+": "+error.getDefaultMessage());
	    }
	    ErrorResponseDto response = new ErrorResponseDto(new Date(), "Validation Error", errorList);
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
	    ErrorResponseDto response = new ErrorResponseDto(new Date(), ex.getMessage(), null);
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	
}
