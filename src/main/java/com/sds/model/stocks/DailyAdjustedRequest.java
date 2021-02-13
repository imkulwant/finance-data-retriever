package com.sds.model.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyAdjustedRequest {

    @NotNull
    private String symbol;
    private String datatype;
    private String outputSize;

}
