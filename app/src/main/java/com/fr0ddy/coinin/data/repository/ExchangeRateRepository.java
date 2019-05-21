package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.Local;
import com.fr0ddy.coinin.data.source.Remote;
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
    public Flowable<List<CoinDCXResponse>> fetchCoinDCXRates() {
        return mExchangeRateRemoteDataSource.fetchCoinDCXRates();
    }

    @Override
    public Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates() {
        return mExchangeRateRemoteDataSource.fetchPocketBitsBitcoinRates();
    }

    @Override
    public Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates() {
        return mExchangeRateRemoteDataSource.fetchPocketBitsAltcoinRates();
    }

    @Override
    public List<Long> saveRates(List<ExchangeRate> exchangeRates) {
        return mExchangeRateLocalDataSource.saveRates(exchangeRates);
    }

    @Override
    public Flowable<List<BitbnsResponse>> fetchBitbnsRates() {
        return mExchangeRateRemoteDataSource.fetchBitbnsRates();
    }

    @Override
    public Flowable<ThroughbitResponse> fetchThroughbitRates() {
        return mExchangeRateRemoteDataSource.fetchThroughbitRates();
    }

    @Override
    public Flowable<UnocoinResponse> fetchUnocoinRates() {
        return mExchangeRateRemoteDataSource.fetchUnocoinRates();
    }

    @Override
    public Flowable<WazirXResponse> fetchWazirXRates() {
        return mExchangeRateRemoteDataSource.fetchWazirXRates();
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
