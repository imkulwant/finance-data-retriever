package com.sds.service;

import com.sds.model.DailyAdjustedRequest;
import com.sds.model.GlobalQuoteRequest;
import com.sds.model.IntraDayRequest;
import com.sds.model.AlphaVantageResponse;

public interface AlphaVantageService {

    AlphaVantageResponse intraDay(IntraDayRequest intraDayRequest);

    AlphaVantageResponse dailyAdjusted(DailyAdjustedRequest dailyAdjustedRequest);

    AlphaVantageResponse globalQuote(GlobalQuoteRequest globalQuoteRequest);

}