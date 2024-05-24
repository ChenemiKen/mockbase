package com.chenemiken.springreactjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      return httpSecurity
          .authorizeHttpRequests(authorize -> authorize
              .requestMatchers( "/error", "/signup").permitAll()
          )
          .csrf(csrf -> csrf.ignoringRequestMatchers("/signup"))
          .build();
  }
}
