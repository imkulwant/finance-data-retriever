package com.sds.service;

import com.sds.model.IntraDayRequest;
import com.sds.model.IntraDayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AlphaVantageServiceImpl implements AlphaVantageService {

    private Environment environment;
    private RestTemplate restTemplate;
    private final String INTRA_DAY_BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=%s&interval=%s&outputsize=%s";
    private static final Logger LOG = LoggerFactory.getLogger(AlphaVantageServiceImpl.class);

    @Autowired
    public AlphaVantageServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public Optional<IntraDayResponse> intraDay(IntraDayRequest request) {

        String apiUrl = String.format(INTRA_DAY_BASE_URL, "TIME_SERIES_INTRADAY", request.getSymbol(),
                environment.getProperty("apiKey"), request.getTimeInterval(), request.getOutputSize());

        try {
            ResponseEntity<IntraDayResponse> intraDayResponse = restTemplate.getForEntity(apiUrl, IntraDayResponse.class);
            return Optional.ofNullable(intraDayResponse.getBody());
        } catch (Exception e) {
            LOG.error("AlphaVantage intra day call unsuccessful!");
            return Optional.empty();
        }
    }
}
