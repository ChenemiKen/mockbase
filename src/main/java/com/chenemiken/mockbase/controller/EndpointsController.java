package com.chenemiken.mockbase.controller;

import com.chenemiken.mockbase.models.requests.EndpointRequest;
import com.chenemiken.mockbase.models.responses.EndpointCreateResponse;
import com.chenemiken.mockbase.services.impl.EndpointServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<EndpointCreateResponse> createEndpoint(
            @Valid @RequestBody EndpointRequest endpointRequest) throws NoSuchMethodException {
        log.info("request to create endpoint: {}", endpointRequest.getPath());
        return new ResponseEntity<>(endpointService.createEndpoint(endpointRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndpoint(@Valid @PathVariable("id") Long id){
        log.info("request to remove endpoint with id: {}", id);
        endpointService.removeEndpoint(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
