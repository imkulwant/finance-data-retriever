package com.sds.rest;

import com.sds.model.crypto.CryptoListings;
import com.sds.model.stocks.AlphaVantageResponse;
import com.sds.model.stocks.DailyAdjustedRequest;
import com.sds.model.stocks.GlobalQuoteRequest;
import com.sds.model.stocks.IntraDayRequest;
import com.sds.service.AlphaVantageService;
import com.sds.service.CoinMarketCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("crypto")
public class CryptoResource {

    private final CoinMarketCapService coinMarketCapService;

    @Autowired
    public CryptoResource(CoinMarketCapService coinMarketCapService) {
        this.coinMarketCapService = coinMarketCapService;
    }

    @GetMapping(value = "listings", produces = MediaType.APPLICATION_JSON_VALUE)
    public CryptoListings getIntraDayResponse() {
        return coinMarketCapService.getCryptoListings();
    }

}