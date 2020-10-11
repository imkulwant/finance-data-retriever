package com.sds.rest;

import com.sds.model.IntraDayRequest;
import com.sds.model.IntraDayResponse;
import com.sds.service.AlphaVantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("stocks")
public class StockTimeSeriesResource {

    private final AlphaVantageService alphaVantageService;

    @Autowired
    public StockTimeSeriesResource(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    @PostMapping(value = "intra-day", consumes = "application/json")
    public IntraDayResponse getIntraDayResponse(@RequestBody IntraDayRequest request) {
        Optional<IntraDayResponse> response = alphaVantageService.intraDay(request);

        if (response.isPresent()) {
            return response.get();
        } else {
            throw new InternalError("Unable to fetch");
        }
    }

}
