package com.chenemiken.mockbase.exceptions;

import com.chenemiken.mockbase.models.responses.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<ErrorResponse> handleSignupException(HttpServletRequest request, NoResourceFoundException e){
    ErrorResponse errorResponse = ErrorResponse.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.NOT_FOUND.value())
            .error(HttpStatus.NOT_FOUND.getReasonPhrase())
            .message(e.getMessage())
            .build();
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception e){
    ErrorResponse errorResponse = ErrorResponse.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .message(e.getLocalizedMessage())
            .build();
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
