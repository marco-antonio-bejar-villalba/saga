package org.marco.preferences.crud.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> generalError(Exception exception) {

		exception.printStackTrace();
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);

	}

}
