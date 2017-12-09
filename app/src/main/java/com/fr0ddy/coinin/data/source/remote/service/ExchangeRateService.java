package com.fr0ddy.coinin.data.source.remote.service;

import com.fr0ddy.coinin.data.source.remote.model.BitfinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateService {
    @GET("https://koinex.in/api/ticker")
    Flowable<KoinexResponse> fetchKoinexRates();

    @GET("https://www.throughbit.com/tbit_ci/index.php/cryptoprice/type/eth/inr")
    Flowable<ThroughbitResponse> fetchThroughbitETHRates();

    @GET("https://api.zebpay.com/api/v1/ticker?currencyCode=INR")
    Flowable<ZebpayResponse> fetchZebpayRates();

    @GET("https://api.bitfinex.com/v2/tickers?symbols=tBTCUSD,tETHUSD,tXRPUSD,tLTCUSD,tBCHUSD")
    Flowable<BitfinexResponse> fetchBitfinexRates();

}
