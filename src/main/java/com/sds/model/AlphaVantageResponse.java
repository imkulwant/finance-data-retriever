package com.sds.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlphaVantageResponse {

    @JsonProperty("Meta Data")
    private Metadata metadata;
    @JsonProperty("Time Series (5min)")
    private Map<String, IntraDayData> timeSeries;
    @JsonProperty("Time Series (Daily)")
    private Map<String, IntraDayData> dailySeries;

}
