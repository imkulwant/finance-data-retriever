package com.fdr.rest;

import com.fdr.model.crypto.CryptoListings;
import com.fdr.service.CoinMarketCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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