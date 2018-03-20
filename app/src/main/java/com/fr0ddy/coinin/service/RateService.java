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

                /*Flowable<List<ExchangeRate>> pocketBits = Flowable.zip(mExchangeRateRepository.fetchPocketBitsBitcoinRates(), mExchangeRateRepository.fetchPocketBitsAltcoinRates(), (pocketBitsBitcoinResponse, pocketBitsAltcoinResponses) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    ExchangeRate pocketBitsBTCRate = new ExchangeRate(POCKETBITS_ID, "BTC", date, Double.parseDouble(pocketBitsBitcoinResponse.getRates().getBuyPrice()), Double.parseDouble(pocketBitsBitcoinResponse.getRates().getSellPrice()));

                    exchangeRates.add(pocketBitsBTCRate);

                    exchangeRates.addAll(PocketBitsAltcoinResponse.getExchangeRates(pocketBitsAltcoinResponses, date));
                    return exchangeRates;
                });*/


                Flowable<List<ExchangeRate>> exchangeRatesGroup = Flowable.zip(mExchangeRateRepository.fetchCoindeltaRates(), mExchangeRateRepository.fetchBitbnsRates(), mExchangeRateRepository.fetchThroughbitRates(), mExchangeRateRepository.fetchOxybitRates(), mExchangeRateRepository.fetchCoinslabRates(), mExchangeRateRepository.fetchBuyUcoinRates(), (coindeltaResponse, bitbnsResponse, throughbitResponse, oxybitResponse, coinslabResponse, buyUcoinResponse) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    exchangeRates.addAll(CoindeltaResponse.getExchangeRates(coindeltaResponse, date));

                    exchangeRates.addAll(throughbitResponse.getExchangeRates(date));

                    exchangeRates.addAll(BitbnsResponse.getExchangeRates(bitbnsResponse, date));

                    exchangeRates.addAll(oxybitResponse.getExchangeRates(date));

                    exchangeRates.addAll(buyUcoinResponse.getExchangeRates(date));

                    exchangeRates.add(new ExchangeRate(COINSLAB_ID, "BTC", date, coinslabResponse.getBuyPrice(), coinslabResponse.getSellPrice()));
                    return exchangeRates;
                });


                Flowable.zip(mExchangeRateRepository.fetchKoinexRates(), mExchangeRateRepository.fetchCoinomeRates(), mExchangeRateRepository.fetchCoinsecureRates(), exchangeRatesGroup, zebpay, (koinexResponse, coinomeResponse, coinsecureResponse, exchangeRateList, zebpayRates) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    ExchangeRate coinsecureBTCRate = new ExchangeRate(COINSECURE_ID, "BTC", date, coinsecureResponse.getMessage().getLowestAsk() / 100.0, coinsecureResponse.getMessage().getHighestBid() / 100.0);

                    exchangeRates.addAll(zebpayRates);
                    exchangeRates.addAll(exchangeRateList);
                    exchangeRates.addAll(koinexResponse.getExchangeRates(date));
                    exchangeRates.addAll(coinomeResponse.getExchangeRates(date));

                    exchangeRates.add(coinsecureBTCRate);
                    //exchangeRates.addAll(pocketbitsResponse);

                    checkArbitrage(exchangeRates);
                    return exchangeRates;
                }).subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.computation())
                        .subscribe(exchangeRates -> mExchangeRateRepository.saveRates(exchangeRates)
                                , throwable -> Timber.e(throwable));

            }
        }, 0,60000);
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
