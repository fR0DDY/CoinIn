package com.fr0ddy.coinin.data.source.remote.service;

import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateService {
    @GET("https://koinex.in/api/ticker")
    Flowable<KoinexResponse> fetchKoinexRates();

    @GET("https://www.coinome.com/api/v1/ticker.json")
    Flowable<CoinomeResponse> fetchCoinomeRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker/btc/inr")
    Flowable<ZebpayResponse> fetchZebpayRates();
}
