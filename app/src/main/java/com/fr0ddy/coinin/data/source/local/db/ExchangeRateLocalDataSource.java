package com.fr0ddy.coinin.data.source.local.db;

import android.support.annotation.NonNull;

import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeRateDao;
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
public class ExchangeRateLocalDataSource implements ExchangeRateDataSource {

    private final ExchangeRateDao mExchangeRateDao;

    @Inject
    public ExchangeRateLocalDataSource(@NonNull ExchangeRateDao exchangeRateDao) {
        mExchangeRateDao = exchangeRateDao;
    }

    @Override
    public Flowable<KoinexResponse> fetchKoinexRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<List<CoinDCXResponse>> fetchCoinDCXRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<List<BitbnsResponse>> fetchBitbnsRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<ThroughbitResponse> fetchThroughbitRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<UnocoinResponse> fetchUnocoinRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<WazirXResponse> fetchWazirXRates() {
        // Not required in Local
        return null;
    }

    @Override
    public List<Long> saveRates(List<ExchangeRate> exchangeRates) {
        return mExchangeRateDao.insertExchangeRates(exchangeRates);
    }

    @Override
    public Flowable<List<ExchangeRate>> getRates() {
        return mExchangeRateDao.getRates();
    }

    @Override
    public Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency) {
        return mExchangeRateDao.getRatesForCurrency(currency);
    }
}
