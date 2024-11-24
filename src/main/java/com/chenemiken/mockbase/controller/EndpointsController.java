package com.chenemiken.mockbase.controller;

import com.chenemiken.mockbase.models.requests.EndpointRequest;
import com.chenemiken.mockbase.services.impl.EndpointServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/endpoints")
public class EndpointsController {

    private final EndpointServiceImpl endpointService;

    @PostMapping()
    public void createEndpoint(@Valid @RequestBody EndpointRequest endpointRequest) throws NoSuchMethodException {
        log.info("request to create endpoint: {}", endpointRequest.getPath());
        endpointService.createEndpoint(endpointRequest);
    }
}
