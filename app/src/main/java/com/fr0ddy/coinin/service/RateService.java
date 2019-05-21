package com.fr0ddy.coinin.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
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
import com.fr0ddy.coinin.data.source.remote.model.CoinDCXResponse;
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
import static com.fr0ddy.coinin.utils.AppConstants.COINDCX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.UNOCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.WAZIRX_ID;


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


                Flowable.zip(mExchangeRateRepository.fetchBitbnsRates(),
                        mExchangeRateRepository.fetchWazirXRates(),
                        mExchangeRateRepository.fetchKoinexRates(),
                        mExchangeRateRepository.fetchUnocoinRates(),
                        mExchangeRateRepository.fetchCoinDCXRates(),
                        (bitbnsResponse, wazirXResponse, koinexResponse, unocoinResponse, coinDCXResponse) -> {
                            List<ExchangeRate> exchangeRates = new ArrayList<>();

                            exchangeRates.addAll(BitbnsResponse.getExchangeRates(bitbnsResponse, date));

                            exchangeRates.addAll(koinexResponse.getExchangeRates(date));

                            exchangeRates.addAll(wazirXResponse.getExchangeRates(date));

                            exchangeRates.addAll(unocoinResponse.getExchangeRates(date));

                            exchangeRates.addAll(CoinDCXResponse.getExchangeRates(coinDCXResponse, date));

                            checkIntraExchangeArbitrage(WAZIRX_ID, "WazirX", wazirXResponse.getMultiCoinExchangeRates(date), 0.00295, 0.00295);

                            checkIntraExchangeArbitrage(KOINEX_ID, "Koinex", koinexResponse.getMultiCoinExchangeRates(date), 0.0015, 0);

                            checkIntraExchangeArbitrage(BITBNS_ID, "Btibns", BitbnsResponse.getMultiCoinExchangeRates(bitbnsResponse, date), 0.0025, 0.0025);

                            checkIntraExchangeArbitrage(UNOCOIN_ID, "Unocoin", unocoinResponse.getMultiCoinExchangeRates(date), 0.00708, 0.00708);

                            checkIntraExchangeArbitrage(COINDCX_ID, "CoinDCX", CoinDCXResponse.getMultiCoinExchangeRates(coinDCXResponse, date), 0.002, 0.002);

                            checkTriangularExchangeArbitrage(exchangeRates);

                            checkArbitrage(exchangeRates);

                            return exchangeRates;
                        }).subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.computation())
                        .subscribe(exchangeRates -> mExchangeRateRepository.saveRates(exchangeRates)
                                , throwable -> Timber.e(throwable));
            }
        }, 0, 60000);
    }

    private void checkTriangularExchangeArbitrage(List<ExchangeRate> exchangeRates) {
        HashMap<Integer, Double> fromExchangeFee = new HashMap<>();
        fromExchangeFee.put(1, 0.0015);
        fromExchangeFee.put(9, 0.0025);
        fromExchangeFee.put(12, 0.0025);
        fromExchangeFee.put(13, 0.00295);
        fromExchangeFee.put(17, 0.001);

        HashMap<Integer, Double> toExchangeFee = new HashMap<>();
        toExchangeFee.put(1, 0.0015);
        toExchangeFee.put(9, 0.0025);
        toExchangeFee.put(12, 0.0025);
        toExchangeFee.put(13, 0.00295);
        toExchangeFee.put(17, 0.001);

        HashMap<String, List<ExchangeRate>> currencyToRateMap = new HashMap<>();
        for (ExchangeRate exchangeRate : exchangeRates) {
            List<ExchangeRate> currencyExchangeRates = currencyToRateMap.get(exchangeRate.getCurrency());
            if (currencyExchangeRates == null) {
                currencyExchangeRates = new ArrayList<>();
                currencyToRateMap.put(exchangeRate.getCurrency(), currencyExchangeRates);
            }
            currencyExchangeRates.add(exchangeRate);
        }

        HashMap<Integer, List<ExchangeRate>> exchangeToRateMap = new HashMap<>();
        for (ExchangeRate exchangeRate : exchangeRates) {
            List<ExchangeRate> exchangeExchangeRates = exchangeToRateMap.get(exchangeRate.getExchangeId());
            if (exchangeExchangeRates == null) {
                exchangeExchangeRates = new ArrayList<>();
                exchangeToRateMap.put(exchangeRate.getExchangeId(), exchangeExchangeRates);
            }
            exchangeExchangeRates.add(exchangeRate);
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
                for (int j = 0; j < currencyExchangeRates.size(); j++) {
                    if (i != j) {
                        ExchangeRate fromExchangeRate = currencyExchangeRates.get(i);
                        ExchangeRate toExchangeRate = currencyExchangeRates.get(j);
                        ExchangeFees fromFee = exchangeToExchangeFeesMap.get(fromExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        ExchangeFees toFee = exchangeToExchangeFeesMap.get(toExchangeRate.getExchangeId() + "_" + fromExchangeRate.getCurrency());
                        double buyCost = 10000;
                        double buyVolume = 10000 / (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromExchangeFee.get(fromExchangeRate.getExchangeId()));

                        double sellCost = (buyVolume - fromFee.getTransferFee()) * (toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toExchangeFee.get(toExchangeRate.getExchangeId()));

                        for (ExchangeRate reverseCurrencyRate : exchangeToRateMap.get(toExchangeRate.getExchangeId())) {
                            if (!currency.equalsIgnoreCase(reverseCurrencyRate.getCurrency())) {
                                ExchangeRate fromExchangeRate2 = reverseCurrencyRate;
                                ExchangeRate toExchangeRate2 = null;
                                for (ExchangeRate tempCurrencyRate : exchangeToRateMap.get(fromExchangeRate.getExchangeId())) {
                                    if (tempCurrencyRate.getCurrency().equalsIgnoreCase(reverseCurrencyRate.getCurrency())) {
                                        toExchangeRate2 = tempCurrencyRate;
                                    }
                                }
                                if (toExchangeRate2 != null && fromExchangeRate2.getBuyRate() != 0.0 && fromExchangeRate.getBuyRate() != 0.0) {
                                    double buyVolume2 = sellCost / (fromExchangeRate2.getBuyRate() + fromExchangeRate2.getBuyRate() * fromExchangeFee.get(toExchangeRate.getExchangeId()));
                                    double sellCost2 = (buyVolume2 - toFee.getTransferFee()) * (toExchangeRate2.getSellRate() - toExchangeRate2.getSellRate() * toExchangeFee.get(toExchangeRate.getExchangeId()));

                                    double profit = sellCost2 - buyCost;
                                    if (fromExchangeRate.getBuyRate() != 0.0 && profit > 0) {
                                        double profitPercentage = (profit * 100.0) / buyCost;
                                        if (profitPercentage > 1) {
                                            profitToStringMap.put(profitPercentage, String.format("%.2f%%", profitPercentage) + " " +
                                                    currency + " " +
                                                    exchangeToNameMap.get(fromExchangeRate.getExchangeId()) + "(" + String.format(fromExchangeRate.getBuyRate() > 1000 ? "%.0f" : "%.2f", fromExchangeRate.getBuyRate()) + ") → " +
                                                    exchangeToNameMap.get(toExchangeRate.getExchangeId()) + "(" + String.format(toExchangeRate.getSellRate() > 1000 ? "%.0f" : "%.2f", toExchangeRate.getSellRate()) + ")" +
                                                    reverseCurrencyRate.getCurrency() + "(" + String.format(fromExchangeRate2.getBuyRate() > 1000 ? "%.0f" : "%.2f", fromExchangeRate2.getBuyRate()) + ") → " +
                                                    "(" + String.format(toExchangeRate2.getSellRate() > 1000 ? "%.0f" : "%.2f", toExchangeRate2.getSellRate()) + ")"
                                            );

                                            notificationCurrencies.add(currency);
                                        }
                                    }
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

            String notificationLevel = "Medium";
            if (profitToStringMap.firstKey() > 10) {
                notificationLevel = "Urgent";
            } else if (profitToStringMap.firstKey() > 5) {
                notificationLevel = "High";
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, notificationLevel + "X")
                    .setContentTitle("Triangular Arbitrage")
                    .setContentText(contentText)
                    .setAutoCancel(false)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setColor(this.getResources().getColor(R.color.colorPrimary))
                    .setContentIntent(pendingIntent);

            NotificationCompat.InboxStyle notificationInboxStyle = new NotificationCompat.InboxStyle(notificationBuilder)
                    .setBigContentTitle("Triangular Arbitrage Opportunity");

            for (Map.Entry<Double, String> entry : profitToStringMap.entrySet()) {
                notificationInboxStyle.addLine(entry.getValue());
            }

            if (profitToStringMap.size() == 1) {
                notificationInboxStyle.addLine("Nothing more.");
            }

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel(notificationLevel + "X", "Triangular Arbitrage Opportunity", profitToStringMap.firstKey() > 10 ? NotificationManager.IMPORTANCE_HIGH : profitToStringMap.firstKey() > 5 ? NotificationManager.IMPORTANCE_DEFAULT : NotificationManager.IMPORTANCE_LOW);

                // Configure the notification channel.
                notificationChannel.setDescription("Arbitrage Notification");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(2, notificationInboxStyle.build());
        }
    }

    private void checkIntraExchangeArbitrage(int exchangeId, String exchangeName, Map<String, Map<String, ExchangeRate>> multiCoinExchangeRates, double inrFee, double cryptoFee) {
        TreeMap<Double, String> profitToStringMap = new TreeMap<>(Collections.reverseOrder());
        Set<String> notificationCurrencies = new HashSet<>();
        for (String baseCurrency : multiCoinExchangeRates.keySet()) {
            if (!"INR".equalsIgnoreCase(baseCurrency)) {
                for (String exchangeCurrency : multiCoinExchangeRates.get(baseCurrency).keySet()) {
                    if (multiCoinExchangeRates.get("INR").get(exchangeCurrency) != null) {
                        double sellPrice = multiCoinExchangeRates.get("INR").get(exchangeCurrency).getSellRate() * (1 - inrFee);
                        double buyPrice = multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getBuyRate() * (1 + cryptoFee) * multiCoinExchangeRates.get("INR").get(baseCurrency).getBuyRate() * (1 + inrFee);
                        double profit = sellPrice - buyPrice;
                        if (multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getBuyRate() != 0.0 &&
                                multiCoinExchangeRates.get("INR").get(baseCurrency).getBuyRate() != 0.0 && profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyPrice;
                            if (profitPercentage > 0) {
                                profitToStringMap.put(profitPercentage, String.format("%.2f%%", profitPercentage) + " INR(" + multiCoinExchangeRates.get("INR").get(baseCurrency).getBuyRate() + ") → " +
                                        baseCurrency + "(" + multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getBuyRate() + ") → " +
                                        exchangeCurrency + " → INR(" + multiCoinExchangeRates.get("INR").get(exchangeCurrency).getSellRate() + ")");
                                notificationCurrencies.add(exchangeCurrency);
                            }
                        }
                    }
                }
                for (String exchangeCurrency : multiCoinExchangeRates.get(baseCurrency).keySet()) {
                    if (multiCoinExchangeRates.get("INR").get(baseCurrency) != null) {
                        double sellPrice = multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getSellRate() * multiCoinExchangeRates.get("INR").get(baseCurrency).getSellRate() * (1 - inrFee) * (1 - cryptoFee);
                        double buyPrice = multiCoinExchangeRates.get("INR").get(exchangeCurrency).getBuyRate() * (1 + inrFee);
                        double profit = sellPrice - buyPrice;
                        if (profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyPrice;
                            if (multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getSellRate() != 0.0 &&
                                    multiCoinExchangeRates.get("INR").get(baseCurrency).getSellRate() != 0.0 && profitPercentage > 0) {
                                profitToStringMap.put(profitPercentage, String.format("%.2f%%", profitPercentage) + " INR(" + multiCoinExchangeRates.get("INR").get(exchangeCurrency).getBuyRate() + ") → " +
                                        exchangeCurrency + "(" + multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getSellRate() + ") → " +
                                        baseCurrency + " → INR(" + multiCoinExchangeRates.get("INR").get(baseCurrency).getSellRate() + ")");
                                notificationCurrencies.add(exchangeCurrency);
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

            String notificationLevel = "Medium";
            if (profitToStringMap.firstKey() > 5) {
                notificationLevel = "Urgent";
            } else if (profitToStringMap.firstKey() > 1) {
                notificationLevel = "High";
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, notificationLevel + (exchangeId + 1))
                    .setContentTitle(exchangeName + " Arbitrage")
                    .setContentText(contentText)
                    .setAutoCancel(false)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setColor(this.getResources().getColor(R.color.colorPrimary))
                    .setContentIntent(pendingIntent);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                if (profitToStringMap.firstKey() > 10) {
                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                    notificationBuilder.setSound(alarmSound);
                } else if (profitToStringMap.firstKey() > 5) {
                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                    notificationBuilder.setSound(alarmSound);
                } else if (profitToStringMap.firstKey() > 1) {
                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    notificationBuilder.setSound(alarmSound);
                }
            }

            NotificationCompat.InboxStyle notificationInboxStyle = new NotificationCompat.InboxStyle(notificationBuilder)
                    .setBigContentTitle(exchangeName + " Arbitrage");

            for (Map.Entry<Double, String> entry : profitToStringMap.entrySet()) {
                notificationInboxStyle.addLine(entry.getValue());
            }

            if (profitToStringMap.size() == 1) {
                notificationInboxStyle.addLine("Nothing more.");
            }

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel(notificationLevel + (exchangeId + 1), exchangeName + " Arbitrage", profitToStringMap.firstKey() > 5 ? NotificationManager.IMPORTANCE_HIGH : profitToStringMap.firstKey() > 1 ? NotificationManager.IMPORTANCE_DEFAULT : NotificationManager.IMPORTANCE_LOW);

                // Configure the notification channel.
                notificationChannel.setDescription("Arbitrage Notification");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(exchangeId + 10, notificationInboxStyle.build());
        }
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
                        double buyCost = 10000 * (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee());
                        double transferFee = (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee()) * fromFee.getTransferFee();

                        double sellCost = 10000 * (toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toFee.getSellFee());

                        double profit = sellCost - transferFee - buyCost;

                        if (fromExchangeRate.getBuyRate() != 0.0 && profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyCost;
                            if (profitPercentage > 1) {
                                double breakEvenINR = ((sellCost * fromFee.getTransferFee()) /
                                        (sellCost - buyCost)) * (sellCost / 10000.0);

                                if (breakEvenINR < 3000.0) {
                                    profitToStringMap.put(profitPercentage, String.format("%.2f%%", profitPercentage) + " " + String.format("%.0f", breakEvenINR) +
                                            " " + currency + " " +
                                            exchangeToNameMap.get(fromExchangeRate.getExchangeId()) + "(" + String.format(fromExchangeRate.getBuyRate() > 1000 ? "%.0f" : "%.2f", fromExchangeRate.getBuyRate()) + ") → " +
                                            exchangeToNameMap.get(toExchangeRate.getExchangeId()) + "(" + String.format(toExchangeRate.getSellRate() > 1000 ? "%.0f" : "%.2f", toExchangeRate.getSellRate()) + ")");

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
                        double buyCost = 10000 * (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee());
                        double transferFee = (fromExchangeRate.getBuyRate() + fromExchangeRate.getBuyRate() * fromFee.getBuyFee()) * fromFee.getTransferFee();

                        double sellCost = 10000 * (toExchangeRate.getSellRate() - toExchangeRate.getSellRate() * toFee.getSellFee());

                        double profit = sellCost - transferFee - buyCost;

                        if (fromExchangeRate.getBuyRate() != 0.0 && profit > 0) {
                            double profitPercentage = (profit * 100.0) / buyCost;
                            if (profitPercentage > 1) {
                                double breakEvenINR = ((sellCost * fromFee.getTransferFee()) /
                                        (sellCost - buyCost)) * (sellCost / 10000.0);

                                if (breakEvenINR < 3000.0) {
                                    profitToStringMap.put(profitPercentage, String.format("%.2f%%", profitPercentage) + " " + String.format("%.0f", breakEvenINR) +
                                            " " + currency + " " +
                                            exchangeToNameMap.get(fromExchangeRate.getExchangeId()) + "(" + String.format(fromExchangeRate.getBuyRate() > 1000 ? "%.0f" : "%.2f", fromExchangeRate.getBuyRate()) + ") → " +
                                            exchangeToNameMap.get(toExchangeRate.getExchangeId()) + "(" + String.format(toExchangeRate.getSellRate() > 1000 ? "%.0f" : "%.2f", toExchangeRate.getSellRate()) + ")");

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

            String notificationLevel = "Medium";
            if (profitToStringMap.firstKey() > 10) {
                notificationLevel = "Urgent";
            } else if (profitToStringMap.firstKey() > 5) {
                notificationLevel = "High";
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, notificationLevel + "1")
                    .setContentTitle("Arbitrage")
                    .setContentText(contentText)
                    .setAutoCancel(false)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setColor(this.getResources().getColor(R.color.colorPrimary))
                    .setContentIntent(pendingIntent);

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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel(notificationLevel + "1", "Arbitrage Opportunity", profitToStringMap.firstKey() > 10 ? NotificationManager.IMPORTANCE_HIGH : profitToStringMap.firstKey() > 5 ? NotificationManager.IMPORTANCE_DEFAULT : NotificationManager.IMPORTANCE_LOW);

                // Configure the notification channel.
                notificationChannel.setDescription("Arbitrage Notification");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(1, notificationInboxStyle.build());
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
