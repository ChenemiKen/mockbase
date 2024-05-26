package com.chenemiken.springreactjwt.exceptions;

public class ModelNotFoundException extends RuntimeException{
  public ModelNotFoundException(String message){
    super(message);
  }
}
