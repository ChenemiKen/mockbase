package com.chenemiken.mockbase.services;

import com.chenemiken.mockbase.entity.User;
import com.chenemiken.mockbase.exceptions.SignupException;
import com.chenemiken.mockbase.models.requests.SignupRequest;
import com.chenemiken.mockbase.models.responses.AuthResponse;
import com.chenemiken.mockbase.repositories.UserRepository;
import com.chenemiken.mockbase.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  final UserRepository userRepository;
  final PasswordEncoder passwordEncoder;
  final JwtService jwtService;

//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    return userRepository.findByEmail(username).orElseThrow(() ->
//        new ModelNotFoundException("user not found"));
//  }
  public AuthResponse signup(SignupRequest request) {
    userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
      throw new SignupException("user with this email address already exists");
    });

    User newUser = new User(request.getName(), request.getEmail(),
        passwordEncoder.encode(request.getPassword()));

//    newUser = userRepository.save(newUser);

    return AuthResponse.builder()
            .user(newUser.getEmail())
            .token(jwtService.generateToken(newUser))
            .build();
  }
}
