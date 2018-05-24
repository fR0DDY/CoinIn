package com.fr0ddy.coinin.data.repository;

import com.fr0ddy.coinin.data.source.Local;
import com.fr0ddy.coinin.data.source.Remote;
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
    public Flowable<ZebpayResponse> fetchZebpayBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBCHRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayBCHRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayLTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayLTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayXRPRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayXRPRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayETHRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayETHRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayEOSRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayEOSRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayOMGRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayOMGRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTRXRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayTRXRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayETHBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayETHBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBCHBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayBCHBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayLTCBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayLTCBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayEOSBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayEOSBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayOMGBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayOMGBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTRXBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayTRXBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayXRPBTCRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayXRPBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTRXXRPRates() {
        return mExchangeRateRemoteDataSource.fetchZebpayTRXXRPRates();
    }

    @Override
    public Flowable<BuyUcoinResponse> fetchBuyUcoinRates() {
        return mExchangeRateRemoteDataSource.fetchBuyUcoinRates();
    }

    @Override
    public Flowable<List<CoindeltaResponse>> fetchCoindeltaRates() {
        return mExchangeRateRemoteDataSource.fetchCoindeltaRates();
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
    public Flowable<CoinsecureResponse> fetchCoinsecureRates() {
        return mExchangeRateRemoteDataSource.fetchCoinsecureRates();
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
    public Flowable<OxybitResponse> fetchOxybitRates() {
        return mExchangeRateRemoteDataSource.fetchOxybitRates();
    }

    @Override
    public Flowable<CoinslabResponse> fetchCoinslabRates() {
        return mExchangeRateRemoteDataSource.fetchCoinslabRates();
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
