package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
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
import com.fr0ddy.coinin.data.source.remote.model.UnocoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.WazirXResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateDataSource {
    Flowable<KoinexResponse> fetchKoinexRates();

    Flowable<CoinomeResponse> fetchCoinomeRates();

    Flowable<ZebpayResponse> fetchZebpayBTCRates();

    Flowable<ZebpayResponse> fetchZebpayBCHRates();

    Flowable<ZebpayResponse> fetchZebpayLTCRates();

    Flowable<ZebpayResponse> fetchZebpayXRPRates();

    Flowable<ZebpayResponse> fetchZebpayETHRates();

    Flowable<ZebpayResponse> fetchZebpayEOSRates();

    Flowable<ZebpayResponse> fetchZebpayOMGRates();

    Flowable<BuyUcoinResponse> fetchBuyUcoinRates();

    Flowable<List<CoindeltaResponse>> fetchCoindeltaRates();

    Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates();

    Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates();

    Flowable<CoinsecureResponse> fetchCoinsecureRates();

    Flowable<List<BitbnsResponse>> fetchBitbnsRates();

    Flowable<ThroughbitResponse> fetchThroughbitRates();

    Flowable<OxybitResponse> fetchOxybitRates();

    Flowable<CoinslabResponse> fetchCoinslabRates();

    Flowable<UnocoinResponse> fetchUnocoinRates();

    Flowable<WazirXResponse> fetchWazirXRates();

    List<Long> saveRates(List<ExchangeRate> exchangeRates);

    Flowable<List<ExchangeRate>> getRates();

    Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency);
}
