package com.chenemiken.springreactjwt.models;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
  LocalDateTime timeStamp;
  int status;
  String error;
  String message;
}
