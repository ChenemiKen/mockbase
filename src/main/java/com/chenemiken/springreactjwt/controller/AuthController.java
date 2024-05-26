package com.chenemiken.springreactjwt.controller;

import com.chenemiken.springreactjwt.models.requests.SignupRequest;
import com.chenemiken.springreactjwt.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
  private static final Log logger = LogFactory.getLog(AuthController.class);

  final AuthService authService;

  @PostMapping("/signup")
  public void signup(@Valid @RequestBody SignupRequest request){
    logger.info("signup request: "+ request);
    authService.signup(request);
  }

  @GetMapping("/")
  public String home(){
    return "welcome";
  }

}
