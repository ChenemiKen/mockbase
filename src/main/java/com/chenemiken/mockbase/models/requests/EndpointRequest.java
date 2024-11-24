package com.chenemiken.mockbase.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author ChenemiKen
 * Email chenemiken15@gmail.com
 * Date 11/24/2024
 */

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EndpointRequest {
    @NotNull
    private String path;

    @NotBlank
    private String method;
}
