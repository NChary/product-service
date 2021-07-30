package com.product.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.model.ApiResponse;
import com.product.util.ProductUtil;

// Global Exception Handler for the entire project
@ControllerAdvice
public class ProductGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	ProductUtil productUtil;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException invalidArgError,HttpHeaders httpHeaders,HttpStatus httpStatus,WebRequest request){

		Map<String, String> errors = new HashMap<>();

		invalidArgError.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		ApiResponse response = productUtil.buildApiResponse("4001", errors.toString());

		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception){
		ApiResponse response = productUtil.buildApiResponse("4002", exception.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

}
