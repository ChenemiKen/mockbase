package com.chenemiken.springreactjwt.controller;

import com.chenemiken.springreactjwt.models.requests.SignupRequest;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  private static final Log logger = LogFactory.getLog(AuthController.class);

  @PostMapping("/signup")
  public void signup(@Valid @RequestBody SignupRequest request){
    logger.info("signup request: "+ request);
  }

}
