package com.example.demo.handleException;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "This should be application specific";
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT,
        request);
  }
  
  @ExceptionHandler(value = {UnauthorizedException.class})
  protected ResponseEntity<Object> handleAuthenHeader(UnauthorizedException ex, WebRequest request) {
    return new ResponseEntity<Object>(
        ex.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
  }
  
//  @ExceptionHandler(value = {Exception.class})
//  protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//    return new ResponseEntity<Object>(
//        ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
//  }
}
