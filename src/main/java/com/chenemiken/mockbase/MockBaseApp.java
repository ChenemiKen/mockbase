package com.chenemiken.mockbase;

import com.chenemiken.mockbase.models.requests.EndpointRequest;
import com.chenemiken.mockbase.services.impl.EndpointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class MockBaseApp implements CommandLineRunner {
  public static void main(String[] args){
    SpringApplication.run(MockBaseApp.class, args);
  }

  @Autowired
  private EndpointServiceImpl endpointService;

  @Override
  public void run(String... args) throws Exception {
    EndpointRequest request = new EndpointRequest("/dancing", RequestMethod.GET,
            "Dynamic endpoint response");
    endpointService.createEndpoint(request);
  }
}
