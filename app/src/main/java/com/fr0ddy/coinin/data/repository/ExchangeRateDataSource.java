package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
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

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateDataSource {
    Flowable<KoinexResponse> fetchKoinexRates();

    Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates();

    Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates();

    Flowable<List<BitbnsResponse>> fetchBitbnsRates();

    Flowable<ThroughbitResponse> fetchThroughbitRates();

    Flowable<UnocoinResponse> fetchUnocoinRates();

    Flowable<WazirXResponse> fetchWazirXRates();

    Flowable<List<CoinDCXResponse>> fetchCoinDCXRates();

    List<Long> saveRates(List<ExchangeRate> exchangeRates);

    Flowable<List<ExchangeRate>> getRates();

    Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency);
}
