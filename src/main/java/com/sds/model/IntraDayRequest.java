package com.sds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntraDayRequest {

    @NotNull
    private String symbol;
    @NotNull
    private String timeInterval;
    private String outputSize;
}
