package com.fdr.service;

import com.fdr.model.stocks.DailyAdjustedRequest;
import com.fdr.model.stocks.GlobalQuoteRequest;
import com.fdr.model.stocks.IntraDayRequest;
import com.fdr.model.stocks.AlphaVantageResponse;

public interface AlphaVantageService {

    AlphaVantageResponse intraDay(IntraDayRequest intraDayRequest);

    AlphaVantageResponse dailyAdjusted(DailyAdjustedRequest dailyAdjustedRequest);

    AlphaVantageResponse globalQuote(GlobalQuoteRequest globalQuoteRequest);

}