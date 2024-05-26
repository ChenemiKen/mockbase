package com.chenemiken.springreactjwt.exceptions;

import com.chenemiken.springreactjwt.models.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
  @ExceptionHandler(SignupException.class)
  public ResponseEntity<ErrorResponse> handleSignupException(HttpServletRequest request, SignupException e){
    ErrorResponse errorResponse = ErrorResponse.builder()
        .timeStamp(LocalDateTime.now())
        .status(HttpStatus.FOUND.value())
        .error(HttpStatus.FOUND.getReasonPhrase())
        .message(e.getMessage())
        .build();
    return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
  }
}
