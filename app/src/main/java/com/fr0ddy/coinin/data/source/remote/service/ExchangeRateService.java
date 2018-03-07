package com.fr0ddy.coinin.data.source.remote.service;

import com.fr0ddy.coinin.data.source.remote.model.BitbnsResponse;
import com.fr0ddy.coinin.data.source.remote.model.BuyUcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoindeltaResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinsecureResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinslabResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.OxybitResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsBitcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;

import java.util.List;

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

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/btc/inr")
    Flowable<ZebpayResponse> fetchZebpayBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/bch/inr")
    Flowable<ZebpayResponse> fetchZebpayBCHRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ltc/inr")
    Flowable<ZebpayResponse> fetchZebpayLTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/xrp/inr")
    Flowable<ZebpayResponse> fetchZebpayXRPRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/eth/inr")
    Flowable<ZebpayResponse> fetchZebpayETHRates();

    @GET("https://www.buyucoin.com/api/v1/crypto/")
    Flowable<BuyUcoinResponse> fetchBuyUcoinRates();

    @GET("https://coindelta.com/api/v1/public/getticker/")
    Flowable<List<CoindeltaResponse>> fetchCoindeltaRates();

    @GET("https://www.pocketbits.in/Index/getBalanceRates")
    Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates();

    @GET("https://www.pocketbits.in/AltCoins/GetFrontDataBuySell")
    Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates();

    @GET("https://api.coinsecure.in/v1/exchange/ticker")
    Flowable<CoinsecureResponse> fetchCoinsecureRates();

    @GET("https://bitbns.com/order/getTickerAll")
    Flowable<List<BitbnsResponse>> fetchBitbnsRates();

    @GET("https://www.throughbit.com/tbit_ci/index.php/cryptoprice")
    Flowable<ThroughbitResponse> fetchThroughbitRates();

    @GET("https://api.oxybit.com/trade/ticker")
    Flowable<OxybitResponse> fetchOxybitRates();

    @GET("https://www.coinslab.com/api/v1/ticker/btc/inr")
    Flowable<CoinslabResponse> fetchCoinslabRates();
}
