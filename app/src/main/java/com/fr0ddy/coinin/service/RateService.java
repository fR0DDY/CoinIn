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
import com.fr0ddy.coinin.data.source.remote.model.CoindeltaResponse;
import com.fr0ddy.coinin.data.source.remote.model.PocketBitsAltcoinResponse;
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

import static com.fr0ddy.coinin.utils.AppConstants.BUYUCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINDELTA_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.POCKETBITS_ID;
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

                Flowable.zip(mExchangeRateRepository.fetchKoinexRates(), mExchangeRateRepository.fetchZebpayRates(), mExchangeRateRepository.fetchBuyUcoinRates(), mExchangeRateRepository.fetchCoindeltaRates(), mExchangeRateRepository.fetchPocketBitsBitcoinRates(), mExchangeRateRepository.fetchPocketBitsAltcoinRates(), (koinexResponse, zebpayResponse, buyUcoinResponse, coindeltaResponse, pocketBitsBitcoinResponse, pocketBitsAltcoinResponses) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();
                    ExchangeRate koinexETHRate = new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(koinexResponse.getStats().getETH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getETH().getHighestBid()));

                    ExchangeRate koinexBTCRate = new ExchangeRate(KOINEX_ID, "BTC", date, Double.parseDouble(koinexResponse.getStats().getBTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBTC().getHighestBid()));

                    ExchangeRate koinexBCHRate = new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(koinexResponse.getStats().getBCH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBCH().getHighestBid()));

                    ExchangeRate koinexLTCRate = new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(koinexResponse.getStats().getLTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getLTC().getHighestBid()));

                    ExchangeRate koinexXRPRate = new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(koinexResponse.getStats().getXRP().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getXRP().getHighestBid()));

                    ExchangeRate zebpayRate = new ExchangeRate(ZEBPAY_ID, "BTC", date, zebpayResponse.getBuyPrice(), zebpayResponse.getSellPrice());

                    /*ExchangeRate coinomeBTCRate = new ExchangeRate(COINOME_ID, "BTC", date, Double.parseDouble(coinomeResponse.getBTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBTC().getHighestBid()));

                    ExchangeRate coinomeBCHRate = new ExchangeRate(COINOME_ID, "BCH", date, Double.parseDouble(coinomeResponse.getBCH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBCH().getHighestBid()));

                    ExchangeRate coinomeLTCRate = new ExchangeRate(COINOME_ID, "LTC", date, Double.parseDouble(coinomeResponse.getLTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getLTC().getHighestBid()));*/

                    ExchangeRate buyUcoinETHRate = new ExchangeRate(BUYUCOIN_ID, "ETH", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getEthBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getEthSellPrice()));

                    ExchangeRate buyUcoinBTCRate = new ExchangeRate(BUYUCOIN_ID, "BTC", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getBtcBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getBtcSellPrice()));

                    ExchangeRate buyUcoinBCHRate = new ExchangeRate(BUYUCOIN_ID, "BCH", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getBchBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getBchSellPrice()));

                    ExchangeRate buyUcoinLTCRate = new ExchangeRate(BUYUCOIN_ID, "LTC", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getLtcBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getLtcSellPrice()));

                    ExchangeRate buyUcoinXRPRate = new ExchangeRate(BUYUCOIN_ID, "XRP", date, Double.parseDouble(buyUcoinResponse.getData().get(0).getXrpBuyPrice()), Double.parseDouble(buyUcoinResponse.getData().get(0).getXrpSellPrice()));

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
                        }
                    }

                    ExchangeRate pocketBitsBTCRate = new ExchangeRate(POCKETBITS_ID, "BTC", date, Double.parseDouble(pocketBitsBitcoinResponse.getRates().getBuyPrice()), Double.parseDouble(pocketBitsBitcoinResponse.getRates().getSellPrice()));

                    for (PocketBitsAltcoinResponse response : pocketBitsAltcoinResponses) {
                        if ("BCC".equalsIgnoreCase(response.getMarketName())) {
                            ExchangeRate rate = new ExchangeRate(POCKETBITS_ID, "BCH", date, Double.parseDouble(response.getBuyPrice()), Double.parseDouble(response.getSellPrice()));
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
                        }
                    }

                    exchangeRates.add(koinexETHRate);
                    exchangeRates.add(koinexBTCRate);
                    exchangeRates.add(koinexBCHRate);
                    exchangeRates.add(koinexLTCRate);
                    exchangeRates.add(koinexXRPRate);
                    exchangeRates.add(zebpayRate);
                    /*exchangeRates.add(coinomeBTCRate);
                    exchangeRates.add(coinomeBCHRate);
                    exchangeRates.add(coinomeLTCRate);*/
                    exchangeRates.add(buyUcoinETHRate);
                    exchangeRates.add(buyUcoinBTCRate);
                    exchangeRates.add(buyUcoinBCHRate);
                    exchangeRates.add(buyUcoinLTCRate);
                    exchangeRates.add(buyUcoinXRPRate);
                    exchangeRates.add(pocketBitsBTCRate);

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
                        double buyCost = fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee();
                        double transferFee = buyCost * fromFee.getTransferFee();

                        double sellCost = toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toFee.getSellFee();

                        double profit = sellCost - transferFee - buyCost;

                        if (profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyCost;
                            if (profitPercentage > 1) {
                                double breakEvenINR = ((sellCost * fromFee.getTransferFee()) /
                                        (sellCost - buyCost)) * sellCost;
                                profitToStringMap.put(profitPercentage, currency + " " +
                                        exchangeToNameMap.get(fromExchangeRate.getExchangeId()) + " → " +
                                        exchangeToNameMap.get(toExchangeRate.getExchangeId()) + " " +
                                        String.format("%.2f%%", profitPercentage) + " " + String.format("%.0f", breakEvenINR));

                                notificationCurrencies.add(currency);
                            }
                        }
                    }
                    fromExchangeRate = currencyExchangeRates.get(j);
                    toExchangeRate = currencyExchangeRates.get(i);
                    if (fromExchangeRate.getBuyRate() < toExchangeRate.getSellRate()) {
                        ExchangeFees fromFee = exchangeToExchangeFeesMap.get(fromExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        ExchangeFees toFee = exchangeToExchangeFeesMap.get(toExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        double buyCost = fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee();
                        double transferFee = buyCost * fromFee.getTransferFee();

                        double sellCost = toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toFee.getSellFee();

                        double profit = sellCost - transferFee - buyCost;

                        if (profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyCost;
                            if (profitPercentage > 1) {
                                double breakEvenINR = ((sellCost * fromFee.getTransferFee()) /
                                        (sellCost - buyCost)) * sellCost;
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
