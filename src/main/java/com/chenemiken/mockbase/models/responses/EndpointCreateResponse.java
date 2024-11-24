package com.chenemiken.mockbase.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

@Data
@Builder
@AllArgsConstructor
public class EndpointCreateResponse {

    private Long id;
    private String path;
    private RequestMethod method;
}
