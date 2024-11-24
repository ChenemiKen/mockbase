package com.chenemiken.mockbase.services.impl;

import com.chenemiken.mockbase.models.requests.EndpointRequest;
import com.chenemiken.mockbase.models.responses.EndpointCreateResponse;
import com.chenemiken.mockbase.services.EndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/23/2024
 */

@Slf4j
@Service
public class EndpointServiceImpl implements EndpointService {
    private final RequestMappingHandlerMapping handlerMapping;

    private final HashMap<Long, EndpointRequest> endpointList = new HashMap<>();
    private Long id = 0L;

    public EndpointServiceImpl(RequestMappingHandlerMapping handlerMapping){
        this.handlerMapping = handlerMapping;
    }

    public EndpointCreateResponse createEndpoint(EndpointRequest request)
            throws NoSuchMethodException {

        System.out.println("so this this");

        Object handler = new Object() {
            public ResponseEntity<Object> handleRequest() {
                System.out.println("ran dancing");
                return new ResponseEntity<>(request.getResponseBody(), HttpStatus.OK);
            }
        };

        Method method = handler.getClass().getMethod("handleRequest");

        RequestMappingInfo mappingInfo = RequestMappingInfo
                .paths(request.getPath())
                .methods(request.getMethod())
                .build();

        handlerMapping.registerMapping(mappingInfo, handler, method);

        Long endpointId = id++;
        endpointList.put(endpointId, request);

        return EndpointCreateResponse.builder()
                .id(endpointId)
                .path(request.getPath())
                .method(request.getMethod())
                .build();
    }

    public HashMap<Long, EndpointRequest> getEndpointList(){
        return endpointList;
    }

    public void removeEndpoint(Long id){
        if(endpointList.containsKey(id)){
            EndpointRequest endpoint = endpointList.remove(id);
            RequestMappingInfo mappingInfo = RequestMappingInfo
                    .paths(endpoint.getPath())
                    .methods(endpoint.getMethod())
                    .build();
            handlerMapping.unregisterMapping(mappingInfo);
        }
    }
}
