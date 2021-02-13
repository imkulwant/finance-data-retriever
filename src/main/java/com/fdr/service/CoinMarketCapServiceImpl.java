package com.fdr.service;

import com.fdr.model.crypto.CryptoListings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CoinMarketCapServiceImpl implements CoinMarketCapService {

    private static final Logger LOG = LoggerFactory.getLogger(CoinMarketCapServiceImpl.class);

    public static final String API_KEY_HEADER = "X-CMC_PRO_API_KEY";

    private final WebClient webClient;

    @Value("${coinMarketCap.apiKey}")
    private String apiKey;

    @Value("${coinMarketCap.function.listings}")
    private String listingsFunction;

    @Autowired
    public CoinMarketCapServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    @Cacheable(value = "com.fdr.service.getCryptoListings")
    public CryptoListings getCryptoListings() {
        try {

            Mono<ClientResponse> result = webClient.get()
                    .uri(uriBuilder -> uriBuilder.path(listingsFunction).build())
                    .header(API_KEY_HEADER, apiKey)
                    .exchange();

            return result.block().bodyToFlux(CryptoListings.class).blockFirst(Duration.ofMillis(5000));

        } catch (Exception ex) {
            LOG.error("Exception occurred while calling CoinMarketCapService [message={}]", ex.getMessage(), ex);
            throw new InternalError("Exception occurred while calling CoinMarketCapService.");
        }

    }

}
