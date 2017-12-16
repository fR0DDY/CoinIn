package com.fr0ddy.coinin.data.source.local.db;

import android.support.annotation.NonNull;

import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
import com.fr0ddy.coinin.data.source.local.db.dao.ExchangeRateDao;
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
    public Flowable<CoinomeResponse> fetchCoinomeRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayRates() {
        // Not required in Local
        return null;
    }

    @Override
    public Flowable<BuyUcoinResponse> fetchBuyUcoinRates() {
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
