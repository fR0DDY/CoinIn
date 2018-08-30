package com.fr0ddy.coinin.data.source.remote.service;

import com.fr0ddy.coinin.data.source.remote.model.BitbnsResponse;
import com.fr0ddy.coinin.data.source.remote.model.BuyUcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoindeltaResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinsecureResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinslabResponse;
import com.fr0ddy.coinin.data.source.remote.model.GiottusResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinOkResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.OxybitResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsBitcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.data.source.remote.model.UnocoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.WazirXResponse;
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

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/eos/inr")
    Flowable<ZebpayResponse> fetchZebpayEOSRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/omg/inr")
    Flowable<ZebpayResponse> fetchZebpayOMGRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/trx/inr")
    Flowable<ZebpayResponse> fetchZebpayTRXRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/zil/inr")
    Flowable<ZebpayResponse> fetchZebpayZILRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/rep/inr")
    Flowable<ZebpayResponse> fetchZebpayREPRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/zrx/inr")
    Flowable<ZebpayResponse> fetchZebpayZRXRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/knc/inr")
    Flowable<ZebpayResponse> fetchZebpayKNCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/gnt/inr")
    Flowable<ZebpayResponse> fetchZebpayGNTRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/bat/inr")
    Flowable<ZebpayResponse> fetchZebpayBATRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ven/inr")
    Flowable<ZebpayResponse> fetchZebpayVENRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ae/inr")
    Flowable<ZebpayResponse> fetchZebpayAERates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/iost/inr")
    Flowable<ZebpayResponse> fetchZebpayIOSTRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/cmt/inr")
    Flowable<ZebpayResponse> fetchZebpayCMTRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ncash/inr")
    Flowable<ZebpayResponse> fetchZebpayNCASHRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/tusd/inr")
    Flowable<ZebpayResponse> fetchZebpayTUSDRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/eth/btc")
    Flowable<ZebpayResponse> fetchZebpayETHBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/bch/btc")
    Flowable<ZebpayResponse> fetchZebpayBCHBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ltc/btc")
    Flowable<ZebpayResponse> fetchZebpayLTCBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/eos/btc")
    Flowable<ZebpayResponse> fetchZebpayEOSBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/omg/btc")
    Flowable<ZebpayResponse> fetchZebpayOMGBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/trx/btc")
    Flowable<ZebpayResponse> fetchZebpayTRXBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/xrp/btc")
    Flowable<ZebpayResponse> fetchZebpayXRPBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/gnt/btc")
    Flowable<ZebpayResponse> fetchZebpayGNTBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/zrx/btc")
    Flowable<ZebpayResponse> fetchZebpayZRXBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/rep/btc")
    Flowable<ZebpayResponse> fetchZebpayREPBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/knc/btc")
    Flowable<ZebpayResponse> fetchZebpayKNCBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/bat/btc")
    Flowable<ZebpayResponse> fetchZebpayBATBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ven/btc")
    Flowable<ZebpayResponse> fetchZebpayVENBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ae/btc")
    Flowable<ZebpayResponse> fetchZebpayAEBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/zil/btc")
    Flowable<ZebpayResponse> fetchZebpayZILBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/cmt/btc")
    Flowable<ZebpayResponse> fetchZebpayCMTBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/ncash/btc")
    Flowable<ZebpayResponse> fetchZebpayNCASHBTCRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/trx/xrp")
    Flowable<ZebpayResponse> fetchZebpayTRXXRPRates();

    @GET("https://www.zebapi.com/api/v1/market/ticker-new/btc/tusd")
    Flowable<ZebpayResponse> fetchZebpayBTCTUSDRates();

    @GET("https://www.buyucoin.com/api/v1.2/currency/markets")
    Flowable<BuyUcoinResponse> fetchBuyUcoinRates();

    @GET("https://api.coindelta.com/api/v1/public/getticker/")
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

    @GET("https://api.unocoin.com/api/exchange/unodax-ticker")
    Flowable<UnocoinResponse> fetchUnocoinRates();

    @GET("https://api.wazirx.com/api/v2/tickers")
    Flowable<WazirXResponse> fetchWazirXRates();

    @GET("https://www.koinok.com/api/brain/ticker")
    Flowable<KoinOkResponse> fetchKoinOkRates();

    @GET("https://www.giottus.com/api/ticker")
    Flowable<GiottusResponse> fetchGiottusRates();
}
