package com.chenemiken.springreactjwt.services;

import com.chenemiken.springreactjwt.entity.User;
import com.chenemiken.springreactjwt.exceptions.ModelNotFoundException;
import com.chenemiken.springreactjwt.exceptions.SignupException;
import com.chenemiken.springreactjwt.models.requests.SignupRequest;
import com.chenemiken.springreactjwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  final UserRepository userRepository;
  final PasswordEncoder passwordEncoder;

//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    return userRepository.findByEmail(username).orElseThrow(() ->
//        new ModelNotFoundException("user not found"));
//  }
  public void signup(SignupRequest request) {
    userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
      throw new SignupException("user with this email address already exists");
    });

    User newUser = new User(request.getName(), request.getEmail(),
        passwordEncoder.encode(request.getPassword()));

    userRepository.save(newUser);
  }


}
