package com.chenemiken.mockbase.exceptions;

public class ModelNotFoundException extends RuntimeException{
  public ModelNotFoundException(String message){
    super(message);
  }
}
