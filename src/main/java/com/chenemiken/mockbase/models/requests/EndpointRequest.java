package com.chenemiken.mockbase.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EndpointRequest {
    @NotEmpty
    private String path;

    @NotNull
    private RequestMethod method;

    private Object responseBody;
}
