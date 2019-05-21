package com.fr0ddy.coinin.data.source.remote.service;

import com.fr0ddy.coinin.data.source.remote.model.BitbnsResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinDCXResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsBitcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.data.source.remote.model.UnocoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.WazirXResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateService {
    @GET("https://koinex.in/api/ticker")
    Flowable<KoinexResponse> fetchKoinexRates();

    @GET("https://api.coindcx.com/exchange/ticker")
    Flowable<List<CoinDCXResponse>> fetchCoinDCXRates();

    @GET("https://www.pocketbits.in/Index/getBalanceRates")
    Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates();

    @GET("https://www.pocketbits.in/AltCoins/GetFrontDataBuySell")
    Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates();

    @GET("https://bitbns.com/order/getTickerAll")
    Flowable<List<BitbnsResponse>> fetchBitbnsRates();

    @GET("https://www.throughbit.com/tbit_ci/index.php/cryptoprice")
    Flowable<ThroughbitResponse> fetchThroughbitRates();

    @GET("https://api.unocoin.com/api/exchange/unodax-ticker")
    Flowable<UnocoinResponse> fetchUnocoinRates();

    @GET("https://api.wazirx.com/api/v2/tickers")
    Flowable<WazirXResponse> fetchWazirXRates();
}
