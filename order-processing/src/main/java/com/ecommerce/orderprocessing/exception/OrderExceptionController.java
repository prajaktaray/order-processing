package com.ecommerce.orderprocessing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> exception(OrderNotFoundException ex){
		return new ResponseEntity<>("Order ID not found", HttpStatus.NOT_FOUND);
	}

}
