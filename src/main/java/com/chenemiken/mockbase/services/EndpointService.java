package com.chenemiken.mockbase.services;

import com.chenemiken.mockbase.models.requests.EndpointRequest;
import com.chenemiken.mockbase.models.responses.EndpointCreateResponse;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

public interface EndpointService {
    EndpointCreateResponse createEndpoint(EndpointRequest endpointRequest) throws NoSuchMethodException;

    void removeEndpoint(Long id);
}
