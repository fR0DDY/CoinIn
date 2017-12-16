package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.Local;
import com.fr0ddy.coinin.data.source.Remote;
import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.remote.model.BuyUcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.ZebpayResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 25/11/17.
 */

@Singleton
public class ExchangeRateRepository implements ExchangeRateDataSource {

    private final ExchangeRateDataSource mExchangeRateLocalDataSource;
    private final ExchangeRateDataSource mExchangeRateRemoteDataSource;

    @Inject
    ExchangeRateRepository(@Local ExchangeRateDataSource exchangeRateLocalDataSource, @Remote ExchangeRateDataSource exchangeRateRemoteDataSource) {
        mExchangeRateLocalDataSource = exchangeRateLocalDataSource;
        mExchangeRateRemoteDataSource = exchangeRateRemoteDataSource;
    }

    @Override
    public Flowable<KoinexResponse> fetchKoinexRates() {
        return mExchangeRateRemoteDataSource.fetchKoinexRates();
    }

    @Override
    public Flowable<CoinomeResponse> fetchCoinomeRates() {
        return mExchangeRateRemoteDataSource.fetchCoinomeRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayRates();
    }

    @Override
    public Flowable<BuyUcoinResponse> fetchBuyUcoinRates() {
        return mExchangeRateRemoteDataSource.fetchBuyUcoinRates();
    }

    @Override
    public List<Long> saveRates(List<ExchangeRate> exchangeRates) {
        return mExchangeRateLocalDataSource.saveRates(exchangeRates);
    }

    @Override
    public Flowable<List<ExchangeRate>> getRates() {
        return mExchangeRateLocalDataSource.getRates();
    }

    @Override
    public Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency) {
        return mExchangeRateLocalDataSource.getRatesForCurrency(currency);
    }
}
