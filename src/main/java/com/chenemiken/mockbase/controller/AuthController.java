package com.chenemiken.mockbase.controller;

import com.chenemiken.mockbase.models.requests.SignupRequest;
import com.chenemiken.mockbase.models.responses.AuthResponse;
import com.chenemiken.mockbase.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignupRequest request){
    logger.info("signup request: "+ request);
    return new ResponseEntity<>(authService.signup(request), HttpStatus.OK);
  }

  @GetMapping("/")
  public String home(){
    return "welcome";
  }
  
}
