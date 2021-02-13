package com.sds.service;

import com.sds.model.stocks.DailyAdjustedRequest;
import com.sds.model.stocks.GlobalQuoteRequest;
import com.sds.model.stocks.IntraDayRequest;
import com.sds.model.stocks.AlphaVantageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageServiceImpl implements AlphaVantageService {

    private final RestTemplate restTemplate;
    private final String DAILY_ADJUSTED_BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=%s&outputsize=%s";
    private final String INTRA_DAY_BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=%s&interval=%s&outputsize=%s";
    private final String GLOBAL_QUOTE_BASE_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=%s";

    private static final Logger LOG = LoggerFactory.getLogger(AlphaVantageServiceImpl.class);

    @Value("${alphavantage.apiKey}")
    private String apiKey;

    @Value("${alphavantage.function.intraDay}")
    private String intraDayFunction;

    @Value("${alphavantage.function.dailyAdjusted}")
    private String dailyAdjustedFunction;

    @Value("${alphavantage.function.globalQuote}")
    private String globalQuoteFunction;

    @Autowired
    public AlphaVantageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AlphaVantageResponse intraDay(IntraDayRequest request) {

        String apiUrl = String.format(INTRA_DAY_BASE_URL, intraDayFunction, request.getSymbol(),
                apiKey, request.getTimeInterval(), request.getOutputSize());

        return getAlphaVantageResponse(apiUrl);
    }

    @Override
    public AlphaVantageResponse dailyAdjusted(DailyAdjustedRequest dailyAdjustedRequest) {

        String apiUrl = String.format(DAILY_ADJUSTED_BASE_URL, dailyAdjustedFunction, dailyAdjustedRequest.getSymbol(),
                apiKey, dailyAdjustedRequest.getOutputSize());

        return getAlphaVantageResponse(apiUrl);

    }

    @Override
    public AlphaVantageResponse globalQuote(GlobalQuoteRequest globalQuoteRequest) {

        String apiUrl = String.format(GLOBAL_QUOTE_BASE_URL, globalQuoteFunction, globalQuoteRequest.getSymbol(), apiKey);

        return getAlphaVantageResponse(apiUrl);

    }

    private AlphaVantageResponse getAlphaVantageResponse(String apiUrl) {
        try {
            ResponseEntity<AlphaVantageResponse> intraDayResponse = restTemplate.getForEntity(apiUrl, AlphaVantageResponse.class);
            return intraDayResponse.getBody();
        } catch (Exception ex) {
            LOG.error("Exception occurred while calling AlphaVantageService [message={}]", ex.getMessage(), ex);
            throw new InternalError("Exception occurred while calling AlphaVantageService.");
        }
    }

}