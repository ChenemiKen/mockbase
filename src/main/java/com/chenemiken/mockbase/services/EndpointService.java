package com.chenemiken.mockbase.services;

import com.chenemiken.mockbase.models.requests.EndpointRequest;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

public interface EndpointService {
    public void createEndpoint(EndpointRequest endpointRequest) throws NoSuchMethodException;
}
