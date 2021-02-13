package com.sds.service;

import com.sds.model.stocks.DailyAdjustedRequest;
import com.sds.model.stocks.GlobalQuoteRequest;
import com.sds.model.stocks.IntraDayRequest;
import com.sds.model.stocks.AlphaVantageResponse;

public interface AlphaVantageService {

    AlphaVantageResponse intraDay(IntraDayRequest intraDayRequest);

    AlphaVantageResponse dailyAdjusted(DailyAdjustedRequest dailyAdjustedRequest);

    AlphaVantageResponse globalQuote(GlobalQuoteRequest globalQuoteRequest);

}