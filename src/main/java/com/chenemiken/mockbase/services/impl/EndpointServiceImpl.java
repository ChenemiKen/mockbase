package com.chenemiken.mockbase.services.impl;

import com.chenemiken.mockbase.models.requests.EndpointRequest;
import com.chenemiken.mockbase.services.EndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/23/2024
 */

@Slf4j
@Service
public class EndpointServiceImpl implements EndpointService {
    private final RequestMappingHandlerMapping handlerMapping;

    public EndpointServiceImpl(RequestMappingHandlerMapping handlerMapping){
        this.handlerMapping = handlerMapping;
    }

    public void createEndpoint(EndpointRequest request)
            throws NoSuchMethodException {

        System.out.println("so this this");

        Object handler = new Object() {
            public ResponseEntity<String> handleRequest() {
                System.out.println("ran dancing");
                return new ResponseEntity<>("Dynamic Endpoint Response", HttpStatus.OK);
            }
        };

        Method method = handler.getClass().getMethod("handleRequest");

        RequestMappingInfo mappingInfo = RequestMappingInfo
                .paths(request.getPath())
                .methods(RequestMethod.resolve(request.getMethod()))
                .build();

        handlerMapping.registerMapping(mappingInfo, handler, method);
//        handlerMapping.unregisterMapping(mappingInfo);
    }
}
