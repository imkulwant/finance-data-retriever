package com.sds.rest;

import com.sds.model.IntraDayRequest;
import com.sds.model.IntraDayResponse;
import com.sds.service.AlphaVantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Native;
import java.util.Optional;

@RestController
@RequestMapping("stocks/quote")
public class StockTimeSeriesResource {

    private final AlphaVantageService alphaVantageService;

    @Autowired
    public StockTimeSeriesResource(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    @GetMapping(value = "intra-day", produces = "application/json")
    public IntraDayResponse getIntraDayResponse(@RequestParam @NotNull String symbol, @RequestParam(defaultValue = "5min") String timeInterval) {

        Optional<IntraDayResponse> response = alphaVantageService.intraDay(IntraDayRequest.builder().symbol(symbol).timeInterval(timeInterval).build());

        if (response.isPresent()) {
            return response.get();
        } else {
            throw new InternalError("Unable to fetch");
        }
    }

}
