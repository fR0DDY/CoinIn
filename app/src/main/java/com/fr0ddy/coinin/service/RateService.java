package com.fr0ddy.coinin.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.fr0ddy.coinin.CoinInApp;
import com.fr0ddy.coinin.R;
import com.fr0ddy.coinin.data.repository.ExchangeRateRepository;
import com.fr0ddy.coinin.data.repository.ExchangeRepository;
import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.data.source.remote.model.BitbnsResponse;
import com.fr0ddy.coinin.data.source.remote.model.CoindeltaResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
import com.fr0ddy.coinin.data.source.remote.model.ThroughbitResponse;
import com.fr0ddy.coinin.di.component.DaggerServiceComponent;
import com.fr0ddy.coinin.ui.home.HomeActivity;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.Flowable;
import timber.log.Timber;

import static com.fr0ddy.coinin.utils.AppConstants.BITBNS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.BUYUCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINDELTA_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINOME_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINSECURE_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINSLAB_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.POCKETBITS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.THROUGHBIT_ID;
import static com.fr0ddy.coinin.utils.AppConstants.ZEBPAY_ID;


/**
 * Created by gaurav on 21/11/17.
 */

public class RateService extends Service {

    @Inject
    ExchangeRateRepository mExchangeRateRepository;

    @Inject
    ExchangeRepository mExchangeRepository;

    @Inject
    SchedulerProvider schedulerProvider;

    private Timer timer = new Timer();

    public static void start(Context context) {
        Intent starter = new Intent(context, RateService.class);
        context.startService(starter);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerServiceComponent.builder()
                .applicationComponent(((CoinInApp) getApplication()).getApplicationComponent())
                .build()
                .inject(this);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Timber.i("Background service running");
                Date date = new Date();

                Flowable<List<ExchangeRate>> zebpay = Flowable.zip(mExchangeRateRepository.fetchZebpayBTCRates(), mExchangeRateRepository.fetchZebpayBCHRates(), mExchangeRateRepository.fetchZebpayLTCRates(), mExchangeRateRepository.fetchZebpayETHRates(), mExchangeRateRepository.fetchZebpayXRPRates(), (zebpayBTCResponse, zebpayBCHResponse, zebpayLTCResponse, zebpayETHResponse, zebpayXRPResponse) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();
                    ExchangeRate zebpayBTCRate = new ExchangeRate(ZEBPAY_ID, "BTC", date, zebpayBTCResponse.getBuyPrice(), zebpayBTCResponse.getSellPrice());
                    exchangeRates.add(zebpayBTCRate);
                    ExchangeRate zebpayBCHRate = new ExchangeRate(ZEBPAY_ID, "BCH", date, zebpayBCHResponse.getBuyPrice(), zebpayBCHResponse.getSellPrice());
                    exchangeRates.add(zebpayBCHRate);
                    ExchangeRate zebpayLTCRate = new ExchangeRate(ZEBPAY_ID, "LTC", date, zebpayLTCResponse.getBuyPrice(), zebpayLTCResponse.getSellPrice());
                    exchangeRates.add(zebpayLTCRate);
                    ExchangeRate zebpayXRPRate = new ExchangeRate(ZEBPAY_ID, "XRP", date, zebpayXRPResponse.getBuyPrice(), zebpayXRPResponse.getSellPrice());
                    exchangeRates.add(zebpayXRPRate);
                    ExchangeRate zebpayETHRate = new ExchangeRate(ZEBPAY_ID, "ETH", date, zebpayETHResponse.getBuyPrice(), zebpayETHResponse.getSellPrice());
                    exchangeRates.add(zebpayETHRate);
                    return exchangeRates;
                });

                Flowable<List<ExchangeRate>> pocketBits = Flowable.zip(mExchangeRateRepository.fetchPocketBitsBitcoinRates(), mExchangeRateRepository.fetchPocketBitsAltcoinRates(), (pocketBitsBitcoinResponse, pocketBitsAltcoinResponses) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    ExchangeRate pocketBitsBTCRate = new ExchangeRate(POCKETBITS_ID, "BTC", date, Double.parseDouble(pocketBitsBitcoinResponse.getRates().getBuyPrice()), Double.parseDouble(pocketBitsBitcoinResponse.getRates().getSellPrice()));

                    exchangeRates.add(pocketBitsBTCRate);

                    for (PocketBitsAltcoinResponse response : pocketBitsAltcoinResponses) {
                        if ("BCC".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "BCH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("BTG".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "BTG", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("DGB".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "DGB", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("XLM".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XLM", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("ETH".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ETH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("LTC".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "LTC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("XRP".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XRP", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("DASH".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "DASH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("ETC".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ETC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("XMR".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XMR", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("NEO".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "NEO", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("OMG".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "OMG", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("ZEC".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "ZEC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("SC".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "SC", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("XVG".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "XVG", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("VOX".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "VOX", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("TRX".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "TRX", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
                            exchangeRates.add(rate);
                        }
                    }
                    return exchangeRates;
                });


                Flowable<List<ExchangeRate>> exchangeRatesGroup = Flowable.zip(mExchangeRateRepository.fetchCoindeltaRates(), mExchangeRateRepository.fetchBitbnsRates(), mExchangeRateRepository.fetchThroughbitRates(), mExchangeRateRepository.fetchOxybitRates(), mExchangeRateRepository.fetchCoinslabRates(), (coindeltaResponse, bitbnsResponse, throughbitResponse, oxybitResponse, coinslabResponse) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();
                    for (CoindeltaResponse data : coindeltaResponse) {
                        if ("btc-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "BTC", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        } else if ("eth-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ETH", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        } else if ("ltc-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "LTC", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        } else if ("bch-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "BCH", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        } else if ("xrp-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "XRP", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        } else if ("qtum-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "QTUM", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        } else if ("omg-inr".equalsIgnoreCase(data.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "OMG", date, data.getLowestAsk(), data.getHighestBid());
                            exchangeRates.add(rate);
                        }
                    }
                    for (BitbnsResponse response : bitbnsResponse) {
                        if (response.getBTC() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "BTC", date, response.getBTC().getSellPrice(), response.getBTC().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getXRP() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "XRP", date, response.getXRP().getSellPrice(), response.getXRP().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getNEO() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "NEO", date, response.getNEO().getSellPrice(), response.getNEO().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getETH() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ETH", date, response.getETH().getSellPrice(), response.getETH().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getXLM() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "XLM", date, response.getXLM().getSellPrice(), response.getXLM().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getGAS() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "GAS", date, response.getGAS().getSellPrice(), response.getGAS().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getRPX() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "RPX", date, response.getRPX().getSellPrice(), response.getRPX().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getDBC() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DBC", date, response.getDBC().getSellPrice(), response.getDBC().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getLTC() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "LTC", date, response.getLTC().getSellPrice(), response.getLTC().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getXMR() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "XMR", date, response.getXMR().getSellPrice(), response.getXMR().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getDOGE() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DOGE", date, response.getDOGE().getSellPrice(), response.getDOGE().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getDASH() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DASH", date, response.getDASH().getSellPrice(), response.getDASH().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getSIA() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "SIA", date, response.getSIA().getSellPrice(), response.getSIA().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getBCH() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "BCH", date, response.getBCH().getSellPrice(), response.getBCH().getBuyPrice());
                            exchangeRates.add(rate);
                        } else if (response.getTRX() != null) {
                            ExchangeRate rate = new ExchangeRate(BITBNS_ID, "TRX", date, response.getTRX().getSellPrice(), response.getTRX().getBuyPrice());
                            exchangeRates.add(rate);
                        }
                    }

                    for (ThroughbitResponse.Data data : throughbitResponse.getData()) {
                        if ("BTC".equalsIgnoreCase(data.getCrypto())) {
                            ExchangeRate rate = new ExchangeRate(THROUGHBIT_ID, "BTC", date, Double.parseDouble(data.getBuyPrice()), Double.parseDouble(data.getSellPrice()));
                            exchangeRates.add(rate);
                        } else if ("ETH".equalsIgnoreCase(data.getCrypto())) {
                            ExchangeRate rate = new ExchangeRate(THROUGHBIT_ID, "ETH", date, Double.parseDouble(data.getBuyPrice()), Double.parseDouble(data.getSellPrice()));
                            exchangeRates.add(rate);
                        }
                    }
                    exchangeRates.addAll(oxybitResponse.getExchangeRates(date));

                    exchangeRates.add(new ExchangeRate(COINSLAB_ID, "BTC", date, coinslabResponse.getBuyPrice(), coinslabResponse.getSellPrice()));
                    return exchangeRates;
                });


                Flowable.zip(mExchangeRateRepository.fetchKoinexRates(), mExchangeRateRepository.fetchCoinomeRates(), mExchangeRateRepository.fetchCoinsecureRates(), pocketBits, exchangeRatesGroup, zebpay, (koinexResponse, coinomeResponse, coinsecureResponse, pocketbitsResponse, exchangeRateList, zebpayRates) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    ExchangeRate koinexETHRate = new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(koinexResponse.getStats().getETH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getETH().getHighestBid()));

                    ExchangeRate koinexBTCRate = new ExchangeRate(KOINEX_ID, "BTC", date, Double.parseDouble(koinexResponse.getStats().getBTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBTC().getHighestBid()));

                    ExchangeRate koinexBCHRate = new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(koinexResponse.getStats().getBCH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBCH().getHighestBid()));

                    ExchangeRate koinexLTCRate = new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(koinexResponse.getStats().getLTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getLTC().getHighestBid()));

                    ExchangeRate koinexXRPRate = new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(koinexResponse.getStats().getXRP().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getXRP().getHighestBid()));

                    ExchangeRate koinexOMGRate = new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(koinexResponse.getStats().getOMG().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getOMG().getHighestBid()));

                    ExchangeRate koinexREQRate = new ExchangeRate(KOINEX_ID, "REQ", date, Double.parseDouble(koinexResponse.getStats().getREQ().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getREQ().getHighestBid()));

                    ExchangeRate koinexZRXRate = new ExchangeRate(KOINEX_ID, "ZRX", date, Double.parseDouble(koinexResponse.getStats().getZRX().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getZRX().getHighestBid()));

                    ExchangeRate koinexAERate = new ExchangeRate(KOINEX_ID, "AE", date, Double.parseDouble(koinexResponse.getStats().getAE().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getAE().getHighestBid()));

                    ExchangeRate koinexBATRate = new ExchangeRate(KOINEX_ID, "BAT", date, Double.parseDouble(koinexResponse.getStats().getBAT().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBAT().getHighestBid()));

                    ExchangeRate koinexGNTRate = new ExchangeRate(KOINEX_ID, "GNT", date, Double.parseDouble(koinexResponse.getStats().getGNT().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getGNT().getHighestBid()));

                    ExchangeRate koinexTRXRate = new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(koinexResponse.getStats().getTRX().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getTRX().getHighestBid()));

                    ExchangeRate coinomeBTCRate = new ExchangeRate(COINOME_ID, "BTC", date, Double.parseDouble(coinomeResponse.getBTC().getLowestAsk()), Double.parseDouble(coinomeResponse.getBTC().getHighestBid()));

                    ExchangeRate coinomeBCHRate = new ExchangeRate(COINOME_ID, "BCH", date, Double.parseDouble(coinomeResponse.getBCH().getLowestAsk()), Double.parseDouble(coinomeResponse.getBCH().getHighestBid()));

                    ExchangeRate coinomeLTCRate = new ExchangeRate(COINOME_ID, "LTC", date, Double.parseDouble(coinomeResponse.getLTC().getLowestAsk()), Double.parseDouble(coinomeResponse.getLTC().getHighestBid()));

                    ExchangeRate coinomeDASHRate = new ExchangeRate(COINOME_ID, "DASH", date, Double.parseDouble(coinomeResponse.getDASH().getLowestAsk()), Double.parseDouble(coinomeResponse.getDASH().getHighestBid()));

                    ExchangeRate coinomeDGBRate = new ExchangeRate(COINOME_ID, "DGB", date, Double.parseDouble(coinomeResponse.getDGB().getLowestAsk()), Double.parseDouble(coinomeResponse.getDGB().getHighestBid()));

                    ExchangeRate coinomeZECRate = new ExchangeRate(COINOME_ID, "ZEC", date, Double.parseDouble(coinomeResponse.getZEC().getLowestAsk()), Double.parseDouble(coinomeResponse.getZEC().getHighestBid()));

                    /*ExchangeRate buyUcoinETHRate = new ExchangeRate(BUYUCOIN_ID, "ETH", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getEthBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getEthSellPrice()));

                    ExchangeRate buyUcoinBTCRate = new ExchangeRate(BUYUCOIN_ID, "BTC", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getBtcBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getBtcSellPrice()));

                    ExchangeRate buyUcoinBCHRate = new ExchangeRate(BUYUCOIN_ID, "BCH", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getBchBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getBchSellPrice()));

                    ExchangeRate buyUcoinLTCRate = new ExchangeRate(BUYUCOIN_ID, "LTC", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getLtcBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getLtcSellPrice()));

                    ExchangeRate buyUcoinXRPRate = new ExchangeRate(BUYUCOIN_ID, "XRP", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getXrpBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getXrpSellPrice()));

                    ExchangeRate buyUcoinZECRate = new ExchangeRate(BUYUCOIN_ID, "ZEC", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getZecBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getZecSellPrice()));

                    ExchangeRate buyUcoinXMRRate = new ExchangeRate(BUYUCOIN_ID, "XMR", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getXmrBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getXmrSellPrice()));

                    ExchangeRate buyUcoinQTUMRate = new ExchangeRate(BUYUCOIN_ID, "QTUM", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getQtumBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getQtumSellPrice()));

                    ExchangeRate buyUcoinETCRate = new ExchangeRate(BUYUCOIN_ID, "ETC", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getEtcBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getEtcSellPrice()));

                    ExchangeRate buyUcoinNEORate = new ExchangeRate(BUYUCOIN_ID, "NEO", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getNeoBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getNeoSellPrice()));

                    ExchangeRate buyUcoinDASHRate = new ExchangeRate(BUYUCOIN_ID, "DASH", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getDashBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getDashSellPrice()));

                    ExchangeRate buyUcoinOMGRate = new ExchangeRate(BUYUCOIN_ID, "OMG", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getOmgBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getOmgSellPrice()));*/


                    ExchangeRate coinsecureBTCRate = new ExchangeRate(COINSECURE_ID, "BTC", date, coinsecureResponse.getMessage().getLowestAsk() / 100.0, coinsecureResponse.getMessage().getHighestBid() / 100.0);

                    exchangeRates.addAll(zebpayRates);
                    exchangeRates.addAll(exchangeRateList);

                    exchangeRates.add(koinexETHRate);
                    exchangeRates.add(koinexBTCRate);
                    exchangeRates.add(koinexBCHRate);
                    exchangeRates.add(koinexLTCRate);
                    exchangeRates.add(koinexXRPRate);
                    exchangeRates.add(koinexOMGRate);
                    exchangeRates.add(koinexREQRate);
                    exchangeRates.add(koinexZRXRate);
                    exchangeRates.add(koinexAERate);
                    exchangeRates.add(koinexBATRate);
                    exchangeRates.add(koinexGNTRate);
                    exchangeRates.add(koinexTRXRate);
                    exchangeRates.add(coinomeBTCRate);
                    exchangeRates.add(coinomeBCHRate);
                    exchangeRates.add(coinomeLTCRate);
                    exchangeRates.add(coinomeDASHRate);
                    exchangeRates.add(coinomeDGBRate);
                    exchangeRates.add(coinomeZECRate);
                    /*exchangeRates.add(buyUcoinETHRate);
                    exchangeRates.add(buyUcoinBTCRate);
                    exchangeRates.add(buyUcoinBCHRate);
                    exchangeRates.add(buyUcoinLTCRate);
                    exchangeRates.add(buyUcoinXRPRate);
                    exchangeRates.add(buyUcoinZECRate);
                    exchangeRates.add(buyUcoinXMRRate);
                    exchangeRates.add(buyUcoinQTUMRate);
                    exchangeRates.add(buyUcoinETCRate);
                    exchangeRates.add(buyUcoinXRPRate);
                    exchangeRates.add(buyUcoinNEORate);
                    exchangeRates.add(buyUcoinDASHRate);
                    exchangeRates.add(buyUcoinOMGRate);*/
                    exchangeRates.add(coinsecureBTCRate);
                    exchangeRates.addAll(pocketbitsResponse);

                    checkArbitrage(exchangeRates);
                    return exchangeRates;
                }).subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.computation())
                        .subscribe(exchangeRates -> mExchangeRateRepository.saveRates(exchangeRates)
                                , throwable -> Timber.e(throwable));

            }
        }, 0, 60000);
    }

    private void checkArbitrage(List<ExchangeRate> exchangeRates) {
        HashMap<String, List<ExchangeRate>> currencyToRateMap = new HashMap<>();
        for (ExchangeRate exchangeRate : exchangeRates) {
            List<ExchangeRate> currencyExchangeRates = currencyToRateMap.get(exchangeRate.getCurrency());
            if (currencyExchangeRates == null) {
                currencyExchangeRates = new ArrayList<>();
                currencyToRateMap.put(exchangeRate.getCurrency(), currencyExchangeRates);
            }
            currencyExchangeRates.add(exchangeRate);
        }

        HashMap<Integer, String> exchangeToNameMap = new HashMap<>();
        List<Exchange> exchanges = mExchangeRepository.getExchanges();
        for (Exchange exchange : exchanges) {
            exchangeToNameMap.put(exchange.getId(), exchange.getName());
        }
        HashMap<String, ExchangeFees> exchangeToExchangeFeesMap = new HashMap<>();
        List<ExchangeFees> exchangeFees = mExchangeRepository.getExchangeFees();
        for (ExchangeFees exchangeFee : exchangeFees) {
            exchangeToExchangeFeesMap.put(exchangeFee.getExchangeId() + "_" + exchangeFee.getCurrency(), exchangeFee);
        }

        TreeMap<Double, String> profitToStringMap = new TreeMap<>(Collections.reverseOrder());

        Set<String> notificationCurrencies = new HashSet<>();

        for (Map.Entry<String, List<ExchangeRate>> entry : currencyToRateMap.entrySet()) {
            String currency = entry.getKey();
            List<ExchangeRate> currencyExchangeRates = entry.getValue();
            for (int i = 0; i < currencyExchangeRates.size(); i++) {
                for (int j = i + 1; j < currencyExchangeRates.size(); j++) {
                    ExchangeRate fromExchangeRate = currencyExchangeRates.get(i);
                    ExchangeRate toExchangeRate = currencyExchangeRates.get(j);
                    if (fromExchangeRate.getBuyRate() < toExchangeRate.getSellRate()) {
                        ExchangeFees fromFee = exchangeToExchangeFeesMap.get(fromExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        ExchangeFees toFee = exchangeToExchangeFeesMap.get(toExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        double buyCost = 1000 * (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee());
                        double transferFee = (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee()) * fromFee.getTransferFee();

                        double sellCost = 1000 * (toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toFee.getSellFee());

                        double profit = sellCost - transferFee - buyCost;

                        if (profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyCost;
                            if (profitPercentage > 1) {
                                double breakEvenINR = ((sellCost * fromFee.getTransferFee()) /
                                        (sellCost - buyCost)) * (sellCost / 1000.0);

                                if (breakEvenINR < 5000.0) {
                                    profitToStringMap.put(profitPercentage, currency + " " +
                                            exchangeToNameMap.get(fromExchangeRate.getExchangeId()) + " → " +
                                            exchangeToNameMap.get(toExchangeRate.getExchangeId()) + " " +
                                            String.format("%.2f%%", profitPercentage) + " " + String.format("%.0f", breakEvenINR));

                                    notificationCurrencies.add(currency);
                                }
                            }
                        }
                    }
                    fromExchangeRate = currencyExchangeRates.get(j);
                    toExchangeRate = currencyExchangeRates.get(i);
                    if (fromExchangeRate.getBuyRate() < toExchangeRate.getSellRate()) {
                        ExchangeFees fromFee = exchangeToExchangeFeesMap.get(fromExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        ExchangeFees toFee = exchangeToExchangeFeesMap.get(toExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        double buyCost = 1000 * (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee());
                        double transferFee = (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee()) * fromFee.getTransferFee();

                        double sellCost = 1000 * (toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toFee.getSellFee());

                        double profit = sellCost - transferFee - buyCost;

                        if (profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyCost;
                            if (profitPercentage > 1) {
                                double breakEvenINR = ((sellCost * fromFee.getTransferFee()) /
                                        (sellCost - buyCost)) * (sellCost / 1000.0);

                                if (breakEvenINR < 5000.0) {
                                    profitToStringMap.put(profitPercentage, currency + " " +
                                            exchangeToNameMap.get(fromExchangeRate.getExchangeId()) + " → " +
                                            exchangeToNameMap.get(toExchangeRate.getExchangeId()) + " " +
                                            String.format("%.2f%%", profitPercentage) + " " + String.format("%.0f", breakEvenINR));

                                    notificationCurrencies.add(currency);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (profitToStringMap.size() > 0) {
            String contentText = "";
            for (String currency : notificationCurrencies) {
                contentText += currency + " ";
            }
            Intent intent = HomeActivity.getStartIntent(this);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);


            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setContentTitle("Arbitrage")
                    .setContentText(contentText)
                    .setAutoCancel(false)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setColor(this.getResources().getColor(R.color.colorPrimary))
                    .setContentIntent(pendingIntent);

            if (profitToStringMap.firstKey() > 5) {
                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                notificationBuilder.setSound(alarmSound);
            }

            NotificationCompat.InboxStyle notificationInboxStyle = new NotificationCompat.InboxStyle(notificationBuilder)
                    .setBigContentTitle("Arbitrage Opportunity");

            for (Map.Entry<Double, String> entry : profitToStringMap.entrySet()) {
                notificationInboxStyle.addLine(entry.getValue());
            }

            if (profitToStringMap.size() == 1) {
                notificationInboxStyle.addLine("Nothing more.");
            }

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, notificationInboxStyle.build());
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
