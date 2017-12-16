package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.remote.model.BuyUcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateDataSource {
    Flowable<KoinexResponse> fetchKoinexRates();

    Flowable<CoinomeResponse> fetchCoinomeRates();

    Flowable<ZebpayResponse> fetchZebpayRates();

    Flowable<BuyUcoinResponse> fetchBuyUcoinRates();

    List<Long> saveRates(List<ExchangeRate> exchangeRates);

    Flowable<List<ExchangeRate>> getRates();

    Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency);
}
