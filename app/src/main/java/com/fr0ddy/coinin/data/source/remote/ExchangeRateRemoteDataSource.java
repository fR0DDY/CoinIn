package com.fr0ddy.coinin.data.source.remote;

import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
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
import com.fr0ddy.coinin.data.source.remote.service.ExchangeRateService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 25/11/17.
 */

@Singleton
public class ExchangeRateRemoteDataSource implements ExchangeRateDataSource {

    private ExchangeRateService exchangeRateService;

    @Inject
    public ExchangeRateRemoteDataSource(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public Flowable<KoinexResponse> fetchKoinexRates() {
        return exchangeRateService.fetchKoinexRates();
    }

    @Override
    public Flowable<List<CoinDCXResponse>> fetchCoinDCXRates() {
        return exchangeRateService.fetchCoinDCXRates();
    }

    @Override
    public Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates() {
        return exchangeRateService.fetchPocketBitsBitcoinRates();
    }

    @Override
    public Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates() {
        return exchangeRateService.fetchPocketBitsAltcoinRates();
    }

    @Override
    public Flowable<List<BitbnsResponse>> fetchBitbnsRates() {
        return exchangeRateService.fetchBitbnsRates();
    }

    @Override
    public Flowable<ThroughbitResponse> fetchThroughbitRates() {
        return exchangeRateService.fetchThroughbitRates();
    }

    @Override
    public Flowable<UnocoinResponse> fetchUnocoinRates() {
        return exchangeRateService.fetchUnocoinRates();
    }

    @Override
    public Flowable<WazirXResponse> fetchWazirXRates() {
        return exchangeRateService.fetchWazirXRates();
    }

    @Override
    public List<Long> saveRates(List<ExchangeRate> exchanges) {
        // Not required in remote
        return null;
    }

    @Override
    public Flowable<List<ExchangeRate>> getRates() {
        // Not required in remote
        return null;
    }

    @Override
    public Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency) {
        // Not required in remote
        return null;
    }
}
