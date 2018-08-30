package com.fr0ddy.coinin.data.repository;

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

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by gaurav on 25/11/17.
 */

public interface ExchangeRateDataSource {
    Flowable<KoinexResponse> fetchKoinexRates();

    Flowable<CoinomeResponse> fetchCoinomeRates();

    Flowable<ZebpayResponse> fetchZebpayBTCRates();

    Flowable<ZebpayResponse> fetchZebpayBCHRates();

    Flowable<ZebpayResponse> fetchZebpayLTCRates();

    Flowable<ZebpayResponse> fetchZebpayXRPRates();

    Flowable<ZebpayResponse> fetchZebpayETHRates();

    Flowable<ZebpayResponse> fetchZebpayEOSRates();

    Flowable<ZebpayResponse> fetchZebpayOMGRates();

    Flowable<ZebpayResponse> fetchZebpayTRXRates();

    Flowable<ZebpayResponse> fetchZebpayZILRates();

    Flowable<ZebpayResponse> fetchZebpayREPRates();

    Flowable<ZebpayResponse> fetchZebpayZRXRates();

    Flowable<ZebpayResponse> fetchZebpayKNCRates();

    Flowable<ZebpayResponse> fetchZebpayGNTRates();

    Flowable<ZebpayResponse> fetchZebpayBATRates();

    Flowable<ZebpayResponse> fetchZebpayVENRates();

    Flowable<ZebpayResponse> fetchZebpayAERates();

    Flowable<ZebpayResponse> fetchZebpayIOSTRates();

    Flowable<ZebpayResponse> fetchZebpayCMTRates();

    Flowable<ZebpayResponse> fetchZebpayNCASHRates();

    Flowable<ZebpayResponse> fetchZebpayTUSDRates();

    Flowable<ZebpayResponse> fetchZebpayETHBTCRates();

    Flowable<ZebpayResponse> fetchZebpayBCHBTCRates();

    Flowable<ZebpayResponse> fetchZebpayLTCBTCRates();

    Flowable<ZebpayResponse> fetchZebpayEOSBTCRates();

    Flowable<ZebpayResponse> fetchZebpayOMGBTCRates();

    Flowable<ZebpayResponse> fetchZebpayTRXBTCRates();

    Flowable<ZebpayResponse> fetchZebpayXRPBTCRates();

    Flowable<ZebpayResponse> fetchZebpayGNTBTCRates();

    Flowable<ZebpayResponse> fetchZebpayZRXBTCRates();

    Flowable<ZebpayResponse> fetchZebpayREPBTCRates();

    Flowable<ZebpayResponse> fetchZebpayKNCBTCRates();

    Flowable<ZebpayResponse> fetchZebpayBATBTCRates();

    Flowable<ZebpayResponse> fetchZebpayVENBTCRates();

    Flowable<ZebpayResponse> fetchZebpayAEBTCRates();

    Flowable<ZebpayResponse> fetchZebpayZILBTCRates();

    Flowable<ZebpayResponse> fetchZebpayCMTBTCRates();

    Flowable<ZebpayResponse> fetchZebpayNCASHBTCRates();

    Flowable<ZebpayResponse> fetchZebpayTRXXRPRates();

    Flowable<ZebpayResponse> fetchZebpayBTCTUSDRates();

    Flowable<BuyUcoinResponse> fetchBuyUcoinRates();

    Flowable<List<CoindeltaResponse>> fetchCoindeltaRates();

    Flowable<PocketBitsBitcoinResponse> fetchPocketBitsBitcoinRates();

    Flowable<List<PocketBitsAltcoinResponse>> fetchPocketBitsAltcoinRates();

    Flowable<CoinsecureResponse> fetchCoinsecureRates();

    Flowable<List<BitbnsResponse>> fetchBitbnsRates();

    Flowable<ThroughbitResponse> fetchThroughbitRates();

    Flowable<OxybitResponse> fetchOxybitRates();

    Flowable<CoinslabResponse> fetchCoinslabRates();

    Flowable<UnocoinResponse> fetchUnocoinRates();

    Flowable<WazirXResponse> fetchWazirXRates();

    Flowable<KoinOkResponse> fetchKoinOkRates();

    Flowable<GiottusResponse> fetchGiottusRates();

    List<Long> saveRates(List<ExchangeRate> exchangeRates);

    Flowable<List<ExchangeRate>> getRates();

    Flowable<List<CurrentExchangeRate>> getRatesForCurrency(String currency);
}
