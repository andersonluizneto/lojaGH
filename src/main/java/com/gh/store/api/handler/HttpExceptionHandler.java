package com.gh.store.api.handler;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gh.store.domain.exception.DomainException;

@RestControllerAdvice
public class HttpExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiError> runtimeExceptionHandler(RuntimeException e){
		ApiError error = new ApiError(e, "OPERATION_FAILED", HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<ApiError> domainExceptionHandler(DomainException e){
		ApiError error = new ApiError(e.getStatus(), e.getCode(), e.getMessage(), List.of());
		HttpStatus httpStatus = Optional.ofNullable(HttpStatus.resolve(e.getStatus()))
				.orElse(HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(httpStatus).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)	                               
	public ResponseEntity<ApiError> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		List<ApiError.Field> fields = e.getBindingResult().getFieldErrors().stream()
				.map(fielError -> {
					return ApiError.Field.builder()
							.name(fielError.getField())
							.message(fielError.getDefaultMessage())							
							.build();
					}).toList();		
		ApiError error = new ApiError(fields);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
