package com.fr0ddy.coinin.data.source.remote;

import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.remote.model.BitbnsResponse;
import com.fr0ddy.coinin.data.source.remote.model.BuyUcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoindeltaResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinsecureResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.OxybitResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsBitcoinResponse;
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
    public Flowable<CoinomeResponse> fetchCoinomeRates() {
        return exchangeRateService.fetchCoinomeRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBTCRates() {
        return exchangeRateService.fetchZebpayBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBCHRates() {
        return exchangeRateService.fetchZebpayBCHRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayLTCRates() {
        return exchangeRateService.fetchZebpayLTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayXRPRates() {
        return exchangeRateService.fetchZebpayXRPRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayETHRates() {
        return exchangeRateService.fetchZebpayETHRates();
    }

    @Override
    public Flowable<BuyUcoinResponse> fetchBuyUcoinRates() {
        return exchangeRateService.fetchBuyUcoinRates();
    }

    @Override
    public Flowable<List<CoindeltaResponse>> fetchCoindeltaRates() {
        return exchangeRateService.fetchCoindeltaRates();
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
    public Flowable<CoinsecureResponse> fetchCoinsecureRates() {
        return exchangeRateService.fetchCoinsecureRates();
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
    public Flowable<OxybitResponse> fetchOxybitRates() {
        return exchangeRateService.fetchOxybitRates();
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
