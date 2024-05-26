package com.chenemiken.springreactjwt.exceptions;

public class SignupException extends RuntimeException{
  public SignupException(String message){
    super(message);
  }
}
