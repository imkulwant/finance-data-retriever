package com.sds.service;

import com.sds.model.IntraDayRequest;
import com.sds.model.IntraDayResponse;

import java.util.Optional;

public interface AlphaVantageService {

    Optional<IntraDayResponse> intraDay(IntraDayRequest intraDayRequest);

}
