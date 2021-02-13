
package com.fdr.model.crypto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data"
})
public class CryptoListings {

    @JsonProperty("status")
    public Status status;

    @JsonProperty("data")
    public List<Object> data = null;

}
