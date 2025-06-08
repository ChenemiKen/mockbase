package com.chenemiken.mockbase.services;

import com.chenemiken.mockbase.models.dto.EndpointDto;
import com.chenemiken.mockbase.models.responses.EndpointCreateResponse;

import java.util.List;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

public interface EndpointService {
    EndpointCreateResponse createEndpoint(EndpointDto endpointRequest) throws NoSuchMethodException;

    List<EndpointDto> listEndpoints();

    void removeEndpoint(Long id);
}
