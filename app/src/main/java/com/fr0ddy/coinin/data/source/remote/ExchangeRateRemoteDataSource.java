package com.fr0ddy.coinin.data.source.remote;

import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.remote.model.BitfinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;
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
    public Flowable<ThroughbitResponse> fetchThroughbitETHRates() {
        return exchangeRateService.fetchThroughbitETHRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayRates() {
        return exchangeRateService.fetchZebpayRates();
    }

    @Override
    public Flowable<BitfinexResponse> fetchBitfinexRates() {
        return exchangeRateService.fetchBitfinexRates();
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
    public Flowable<List<ExchangeRate>> getRatesForCurrency(String currency) {
        // Not required in remote
        return null;
    }
}
