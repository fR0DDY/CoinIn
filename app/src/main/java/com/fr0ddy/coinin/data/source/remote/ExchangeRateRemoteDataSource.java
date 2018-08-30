package com.fr0ddy.coinin.data.source.remote;

import com.fr0ddy.coinin.data.repository.ExchangeRateDataSource;
import com.fr0ddy.coinin.data.source.local.db.model.CurrentExchangeRate;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.remote.model.BitbnsResponse;
import com.fr0ddy.coinin.data.source.remote.model.BuyUcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoindeltaResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinomeResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinsecureResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoinslabResponse;
import com.fr0ddy.coinin.data.source.remote.model.GiottusResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinOkResponse;
import com.fr0ddy.coinin.data.source.remote.model.KoinexResponse;
import com.fr0ddy.coinin.data.source.remote.model.OxybitResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsBitcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.data.source.remote.model.UnocoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.WazirXResponse;
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
    public Flowable<ZebpayResponse> fetchZebpayEOSRates() {
        return exchangeRateService.fetchZebpayEOSRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayOMGRates() {
        return exchangeRateService.fetchZebpayOMGRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTRXRates() {
        return exchangeRateService.fetchZebpayTRXRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayZILRates() {
        return exchangeRateService.fetchZebpayZILRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayREPRates() {
        return exchangeRateService.fetchZebpayREPRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayZRXRates() {
        return exchangeRateService.fetchZebpayZRXRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayKNCRates() {
        return exchangeRateService.fetchZebpayKNCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayGNTRates() {
        return exchangeRateService.fetchZebpayGNTRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBATRates() {
        return exchangeRateService.fetchZebpayBATRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayVENRates() {
        return exchangeRateService.fetchZebpayVENRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayAERates() {
        return exchangeRateService.fetchZebpayAERates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayIOSTRates() {
        return exchangeRateService.fetchZebpayIOSTRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayCMTRates() {
        return exchangeRateService.fetchZebpayCMTRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayNCASHRates() {
        return exchangeRateService.fetchZebpayNCASHRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayETHBTCRates() {
        return exchangeRateService.fetchZebpayETHBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBCHBTCRates() {
        return exchangeRateService.fetchZebpayBCHBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayLTCBTCRates() {
        return exchangeRateService.fetchZebpayLTCBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayEOSBTCRates() {
        return exchangeRateService.fetchZebpayEOSBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayOMGBTCRates() {
        return exchangeRateService.fetchZebpayOMGBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTRXBTCRates() {
        return exchangeRateService.fetchZebpayTRXBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayXRPBTCRates() {
        return exchangeRateService.fetchZebpayXRPBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayGNTBTCRates() {
        return exchangeRateService.fetchZebpayGNTBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayZRXBTCRates() {
        return exchangeRateService.fetchZebpayZRXBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayREPBTCRates() {
        return exchangeRateService.fetchZebpayREPBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayKNCBTCRates() {
        return exchangeRateService.fetchZebpayKNCBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBATBTCRates() {
        return exchangeRateService.fetchZebpayBATBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayVENBTCRates() {
        return exchangeRateService.fetchZebpayVENBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayAEBTCRates() {
        return exchangeRateService.fetchZebpayAEBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayZILBTCRates() {
        return exchangeRateService.fetchZebpayZILBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayCMTBTCRates() {
        return exchangeRateService.fetchZebpayCMTBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayNCASHBTCRates() {
        return exchangeRateService.fetchZebpayNCASHBTCRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTRXXRPRates() {
        return exchangeRateService.fetchZebpayTRXXRPRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayTUSDRates() {
        return exchangeRateService.fetchZebpayTUSDRates();
    }

    @Override
    public Flowable<ZebpayResponse> fetchZebpayBTCTUSDRates() {
        return exchangeRateService.fetchZebpayBTCTUSDRates();
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
    public Flowable<CoinslabResponse> fetchCoinslabRates() {
        return exchangeRateService.fetchCoinslabRates();
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
    public Flowable<KoinOkResponse> fetchKoinOkRates() {
        return exchangeRateService.fetchKoinOkRates();
    }

    @Override
    public Flowable<GiottusResponse> fetchGiottusRates() {
        return exchangeRateService.fetchGiottusRates();
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
