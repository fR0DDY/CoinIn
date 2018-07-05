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

import static com.fr0ddy.coinin.utils.AppConstants.COINDELTA_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINOME_ID;
import static com.fr0ddy.coinin.utils.AppConstants.GIOTTUS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINOK_ID;
import static com.fr0ddy.coinin.utils.AppConstants.POCKETBITS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.WAZIRX_ID;
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

                Flowable<List<ExchangeRate>> pocketBits = Flowable.zip(mExchangeRateRepository.fetchPocketBitsBitcoinRates(), mExchangeRateRepository.fetchPocketBitsAltcoinRates(), (pocketBitsBitcoinResponse, pocketBitsAltcoinResponses) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    ExchangeRate pocketBitsBTCRate = new ExchangeRate(POCKETBITS_ID, "BTC", date, Double.parseDouble(pocketBitsBitcoinResponse.getRates().getBuyPrice()), Double.parseDouble(pocketBitsBitcoinResponse.getRates().getSellPrice()));

                    exchangeRates.add(pocketBitsBTCRate);

                    exchangeRates.addAll(PocketBitsAltcoinResponse.getExchangeRates(pocketBitsAltcoinResponses, date));
                    return exchangeRates;
                });


                Flowable<List<ExchangeRate>> exchangeRatesGroup = Flowable.zip(mExchangeRateRepository.fetchCoindeltaRates(), mExchangeRateRepository.fetchBitbnsRates(), mExchangeRateRepository.fetchWazirXRates(), mExchangeRateRepository.fetchThroughbitRates(), (coindeltaResponse, bitbnsResponse, wazirXResponse, throughbitResponse) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    exchangeRates.addAll(CoindeltaResponse.getExchangeRates(coindeltaResponse, date));

                    exchangeRates.addAll(throughbitResponse.getExchangeRates(date));

                    exchangeRates.addAll(BitbnsResponse.getExchangeRates(bitbnsResponse, date));

                    //exchangeRates.addAll(oxybitResponse.getExchangeRates(date));

                    exchangeRates.addAll(wazirXResponse.getExchangeRates(date));

                    //exchangeRates.addAll(buyUcoinResponse.getExchangeRates(date));

                    //exchangeRates.add(new ExchangeRate(COINSLAB_ID, "BTC", date, coinslabResponse.getBuyPrice(), coinslabResponse.getSellPrice()));
                    checkIntraExchangeArbitrage(COINDELTA_ID, "Coindelta", CoindeltaResponse.getMultiCoinExchangeRates(coindeltaResponse, date), 0.003, 0.003);
                    checkIntraExchangeArbitrage(WAZIRX_ID, "WazirX", wazirXResponse.getMultiCoinExchangeRates(date), 0.00295, 0.00295);
                    return exchangeRates;
                });

                Flowable<Map<String, ExchangeRate>> zebpayINRRates1 = Flowable.zip(mExchangeRateRepository.fetchZebpayBTCRates(), mExchangeRateRepository.fetchZebpayBCHRates(), mExchangeRateRepository.fetchZebpayLTCRates(), mExchangeRateRepository.fetchZebpayETHRates(), mExchangeRateRepository.fetchZebpayXRPRates(), mExchangeRateRepository.fetchZebpayEOSRates(), mExchangeRateRepository.fetchZebpayOMGRates(), mExchangeRateRepository.fetchZebpayTRXRates(), mExchangeRateRepository.fetchZebpayZILRates(), (zebpayBTCResponse, zebpayBCHResponse, zebpayLTCResponse, zebpayETHResponse, zebpayXRPResponse, zebpayEOSResponse, zebpayOMGResponse, zebpayTRXResponse, zebpayZILResponse) -> {
                    Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
                    inrExchangeRates.put("BTC", new ExchangeRate(ZEBPAY_ID, "BTC", date, zebpayBTCResponse.getBuyPrice(), zebpayBTCResponse.getSellPrice()));
                    inrExchangeRates.put("BCH", new ExchangeRate(ZEBPAY_ID, "BCH", date, zebpayBCHResponse.getBuyPrice(), zebpayBCHResponse.getSellPrice()));
                    inrExchangeRates.put("LTC", new ExchangeRate(ZEBPAY_ID, "LTC", date, zebpayLTCResponse.getBuyPrice(), zebpayLTCResponse.getSellPrice()));
                    inrExchangeRates.put("XRP", new ExchangeRate(ZEBPAY_ID, "XRP", date, zebpayXRPResponse.getBuyPrice(), zebpayXRPResponse.getSellPrice()));
                    inrExchangeRates.put("ETH", new ExchangeRate(ZEBPAY_ID, "ETH", date, zebpayETHResponse.getBuyPrice(), zebpayETHResponse.getSellPrice()));
                    inrExchangeRates.put("EOS", new ExchangeRate(ZEBPAY_ID, "EOS", date, zebpayEOSResponse.getBuyPrice(), zebpayEOSResponse.getSellPrice()));
                    inrExchangeRates.put("OMG", new ExchangeRate(ZEBPAY_ID, "OMG", date, zebpayOMGResponse.getBuyPrice(), zebpayOMGResponse.getSellPrice()));
                    inrExchangeRates.put("TRX", new ExchangeRate(ZEBPAY_ID, "TRX", date, zebpayTRXResponse.getBuyPrice(), zebpayTRXResponse.getSellPrice()));
                    inrExchangeRates.put("ZIL", new ExchangeRate(ZEBPAY_ID, "ZIL", date, zebpayZILResponse.getBuyPrice(), zebpayZILResponse.getSellPrice()));
                    return inrExchangeRates;
                });

                Flowable<Map<String, ExchangeRate>> zebpayINRRates2 = Flowable.zip(mExchangeRateRepository.fetchZebpayREPRates(), mExchangeRateRepository.fetchZebpayZRXRates(), mExchangeRateRepository.fetchZebpayKNCRates(), mExchangeRateRepository.fetchZebpayGNTRates(), mExchangeRateRepository.fetchZebpayBATRates(), mExchangeRateRepository.fetchZebpayVENRates(), mExchangeRateRepository.fetchZebpayAERates(), mExchangeRateRepository.fetchZebpayIOSTRates(), mExchangeRateRepository.fetchZebpayCMTRates(), (zebpayREPResponse, zebpayZRXResponse, zebpayKNCResponse, zebpayGNTResponse, zebpayBATResponse, zebpayVENResponse, zebpayAEResponse, zebpayIOSTResponse, zebpayCMTResponse) -> {
                    Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
                    inrExchangeRates.put("REP", new ExchangeRate(ZEBPAY_ID, "REP", date, zebpayREPResponse.getBuyPrice(), zebpayREPResponse.getSellPrice()));
                    inrExchangeRates.put("ZRX", new ExchangeRate(ZEBPAY_ID, "ZRX", date, zebpayZRXResponse.getBuyPrice(), zebpayZRXResponse.getSellPrice()));
                    inrExchangeRates.put("KNC", new ExchangeRate(ZEBPAY_ID, "KNC", date, zebpayKNCResponse.getBuyPrice(), zebpayKNCResponse.getSellPrice()));
                    inrExchangeRates.put("GNT", new ExchangeRate(ZEBPAY_ID, "GNT", date, zebpayGNTResponse.getBuyPrice(), zebpayGNTResponse.getSellPrice()));
                    inrExchangeRates.put("BAT", new ExchangeRate(ZEBPAY_ID, "BAT", date, zebpayBATResponse.getBuyPrice(), zebpayBATResponse.getSellPrice()));
                    inrExchangeRates.put("VEN", new ExchangeRate(ZEBPAY_ID, "VEN", date, zebpayVENResponse.getBuyPrice(), zebpayVENResponse.getSellPrice()));
                    inrExchangeRates.put("AE", new ExchangeRate(ZEBPAY_ID, "AE", date, zebpayAEResponse.getBuyPrice(), zebpayAEResponse.getSellPrice()));
                    inrExchangeRates.put("IOST", new ExchangeRate(ZEBPAY_ID, "IOST", date, zebpayIOSTResponse.getBuyPrice(), zebpayIOSTResponse.getSellPrice()));
                    inrExchangeRates.put("CMT", new ExchangeRate(ZEBPAY_ID, "CMT", date, zebpayCMTResponse.getBuyPrice(), zebpayCMTResponse.getSellPrice()));
                    return inrExchangeRates;
                });

                Flowable<Map<String, ExchangeRate>> zebpaybitcoinRates1 = Flowable.zip(mExchangeRateRepository.fetchZebpayETHBTCRates(), mExchangeRateRepository.fetchZebpayBCHBTCRates(), mExchangeRateRepository.fetchZebpayLTCBTCRates(), mExchangeRateRepository.fetchZebpayEOSBTCRates(), mExchangeRateRepository.fetchZebpayOMGBTCRates(), mExchangeRateRepository.fetchZebpayTRXBTCRates(), mExchangeRateRepository.fetchZebpayXRPBTCRates(), mExchangeRateRepository.fetchZebpayGNTBTCRates(), mExchangeRateRepository.fetchZebpayZRXBTCRates(), (zebpayETHResponse, zebpayBCHResponse, zebpayLTCResponse, zebpayEOSResponse, zebpayOMGResponse, zebpayTRXResponse, zebpayXRPResponse, zebpayGNTRespone, zebpayZRXRespone) -> {
                    Map<String, ExchangeRate> btcExchangeRates = new HashMap<>();
                    btcExchangeRates.put("BCH", new ExchangeRate(ZEBPAY_ID, "BCH", date, zebpayBCHResponse.getBuyPrice(), zebpayBCHResponse.getSellPrice()));
                    btcExchangeRates.put("LTC", new ExchangeRate(ZEBPAY_ID, "LTC", date, zebpayLTCResponse.getBuyPrice(), zebpayLTCResponse.getSellPrice()));
                    btcExchangeRates.put("XRP", new ExchangeRate(ZEBPAY_ID, "XRP", date, zebpayXRPResponse.getBuyPrice(), zebpayXRPResponse.getSellPrice()));
                    btcExchangeRates.put("ETH", new ExchangeRate(ZEBPAY_ID, "ETH", date, zebpayETHResponse.getBuyPrice(), zebpayETHResponse.getSellPrice()));
                    btcExchangeRates.put("EOS", new ExchangeRate(ZEBPAY_ID, "EOS", date, zebpayEOSResponse.getBuyPrice(), zebpayEOSResponse.getSellPrice()));
                    btcExchangeRates.put("OMG", new ExchangeRate(ZEBPAY_ID, "OMG", date, zebpayOMGResponse.getBuyPrice(), zebpayOMGResponse.getSellPrice()));
                    btcExchangeRates.put("TRX", new ExchangeRate(ZEBPAY_ID, "TRX", date, zebpayTRXResponse.getBuyPrice(), zebpayTRXResponse.getSellPrice()));
                    btcExchangeRates.put("GNT", new ExchangeRate(ZEBPAY_ID, "GNT", date, zebpayGNTRespone.getBuyPrice(), zebpayGNTRespone.getSellPrice()));
                    btcExchangeRates.put("ZRX", new ExchangeRate(ZEBPAY_ID, "ZRX", date, zebpayZRXRespone.getBuyPrice(), zebpayZRXRespone.getSellPrice()));
                    return btcExchangeRates;
                });

                Flowable<Map<String, ExchangeRate>> zebpaybitcoinRates2 = Flowable.zip(mExchangeRateRepository.fetchZebpayREPBTCRates(), mExchangeRateRepository.fetchZebpayKNCBTCRates(), mExchangeRateRepository.fetchZebpayBATBTCRates(), mExchangeRateRepository.fetchZebpayVENBTCRates(), mExchangeRateRepository.fetchZebpayAEBTCRates(), mExchangeRateRepository.fetchZebpayZILBTCRates(), mExchangeRateRepository.fetchZebpayCMTBTCRates(), mExchangeRateRepository.fetchZebpayNCASHBTCRates(), (zebpayREPResponse, zebpayKNCResponse, zebpayBATResponse, zebpayVENResponse, zebpayAEResponse, zebpayZILResponse, zebpayCMTResponse, zebpayNCASHRespone) -> {
                    Map<String, ExchangeRate> btcExchangeRates = new HashMap<>();
                    btcExchangeRates.put("REP", new ExchangeRate(ZEBPAY_ID, "REP", date, zebpayREPResponse.getBuyPrice(), zebpayREPResponse.getSellPrice()));
                    btcExchangeRates.put("KNC", new ExchangeRate(ZEBPAY_ID, "KNC", date, zebpayKNCResponse.getBuyPrice(), zebpayKNCResponse.getSellPrice()));
                    btcExchangeRates.put("BAT", new ExchangeRate(ZEBPAY_ID, "BAT", date, zebpayBATResponse.getBuyPrice(), zebpayBATResponse.getSellPrice()));
                    btcExchangeRates.put("VEN", new ExchangeRate(ZEBPAY_ID, "VEN", date, zebpayVENResponse.getBuyPrice(), zebpayVENResponse.getSellPrice()));
                    btcExchangeRates.put("AE", new ExchangeRate(ZEBPAY_ID, "AE", date, zebpayAEResponse.getBuyPrice(), zebpayAEResponse.getSellPrice()));
                    btcExchangeRates.put("ZIL", new ExchangeRate(ZEBPAY_ID, "ZIL", date, zebpayZILResponse.getBuyPrice(), zebpayZILResponse.getSellPrice()));
                    btcExchangeRates.put("CMT", new ExchangeRate(ZEBPAY_ID, "CMT", date, zebpayCMTResponse.getBuyPrice(), zebpayCMTResponse.getSellPrice()));
                    btcExchangeRates.put("NCASH", new ExchangeRate(ZEBPAY_ID, "NCASH", date, zebpayNCASHRespone.getBuyPrice(), zebpayNCASHRespone.getSellPrice()));
                    return btcExchangeRates;
                });

                Flowable<List<ExchangeRate>> zebpay = Flowable.zip(zebpayINRRates1, zebpayINRRates2, zebpaybitcoinRates1, zebpaybitcoinRates2, mExchangeRateRepository.fetchZebpayNCASHRates(), mExchangeRateRepository.fetchZebpayTRXXRPRates(), (inrRates1, inrRates2, bitcoinRates1, bitcoinRate2, zebpayNCASHResponse, zebpayTRXXRPResponse) -> {
                    Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
                    inrRates2.put("NCASH", new ExchangeRate(ZEBPAY_ID, "NCASH", date, zebpayNCASHResponse.getBuyPrice(), zebpayNCASHResponse.getSellPrice()));
                    inrRates1.putAll(inrRates2);
                    exchangeRates.put("INR", inrRates1);
                    bitcoinRates1.putAll(bitcoinRate2);
                    exchangeRates.put("BTC", bitcoinRates1);
                    Map<String, ExchangeRate> xrpExchangeRates = new HashMap<>();
                    xrpExchangeRates.put("TRX", new ExchangeRate(ZEBPAY_ID, "TRX", date, zebpayTRXXRPResponse.getBuyPrice(), zebpayTRXXRPResponse.getSellPrice()));
                    exchangeRates.put("XRP", xrpExchangeRates);
                    checkIntraExchangeArbitrage(ZEBPAY_ID, "Zebpay", exchangeRates, 0.00295, 0.00295);
                    List<ExchangeRate> inrRates = new ArrayList<>();
                    for (ExchangeRate rates : exchangeRates.get("INR").values()) {
                        if (!rates.getCurrency().equalsIgnoreCase("EOS") && !rates.getCurrency().equalsIgnoreCase("TRX"))
                            inrRates.add(rates);
                    }
                    return inrRates;
                });


                Flowable.zip(mExchangeRateRepository.fetchKoinexRates(), exchangeRatesGroup, mExchangeRateRepository.fetchCoinomeRates(), mExchangeRateRepository.fetchKoinOkRates(), mExchangeRateRepository.fetchUnocoinRates(), pocketBits, zebpay, (koinexResponse, exchangeRateList, coinomeResponse, koinOkResponse, unocoinResponse, pocketbitsResponse, zebpayRates) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();

                    //ExchangeRate coinsecureBTCRate = new ExchangeRate(COINSECURE_ID, "BTC", date, coinsecureResponse.getMessage().getLowestAsk() / 100.0, coinsecureResponse.getMessage().getHighestBid() / 100.0);

                    exchangeRates.addAll(zebpayRates);
                    exchangeRates.addAll(exchangeRateList);
                    exchangeRates.addAll(koinexResponse.getExchangeRates(date));
                    exchangeRates.addAll(coinomeResponse.getExchangeRates(date));

                    //exchangeRates.add(coinsecureBTCRate);
                    exchangeRates.addAll(pocketbitsResponse);
                    exchangeRates.addAll(unocoinResponse.getExchangeRates(date));

                    exchangeRates.addAll(koinOkResponse.getExchangeRates(date));

                    //exchangeRates.addAll(giottusResponse.getExchangeRates(date));

                    checkArbitrage(exchangeRates);

                    checkIntraExchangeArbitrage(COINOME_ID, "Coinome", coinomeResponse.getMultiCoinExchangeRates(date), 0.00354, 0.00118);
                    checkIntraExchangeArbitrage(KOINEX_ID, "Koinex", koinexResponse.getMultiCoinExchangeRates(date), 0.0015, 0);

                    //checkIntraExchangeArbitrage(GIOTTUS_ID, "Giottus", giottusResponse.getMultiCoinExchangeRates(date), 0.0025, 0.0025);

                    checkIntraExchangeArbitrage(KOINOK_ID, "Koinok", koinOkResponse.getMultiCoinExchangeRates(date), 0.0025, 0);
                    return exchangeRates;
                }).subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.computation())
                        .subscribe(exchangeRates -> mExchangeRateRepository.saveRates(exchangeRates)
                                , throwable -> Timber.e(throwable));

            }
        }, 0, 60000);
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
                        if (multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getBuyRate() != 0.0 && profit > 0) {
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
                            if (multiCoinExchangeRates.get(baseCurrency).get(exchangeCurrency).getSellRate() != 0.0 && profitPercentage > 0) {
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
            notificationManager.notify(exchangeId + 1, notificationInboxStyle.build());
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
