package com.fr0ddy.coinin.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.fr0ddy.coinin.CoinInApp;
import com.fr0ddy.coinin.data.repository.ExchangeRateRepository;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.fr0ddy.coinin.di.component.DaggerServiceComponent;
import com.fr0ddy.coinin.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import io.reactivex.Flowable;
import timber.log.Timber;


/**
 * Created by gaurav on 21/11/17.
 */

public class RateService extends Service {

    @Inject
    ExchangeRateRepository mExchangeRateRepository;

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

                Flowable.zip(mExchangeRateRepository.fetchKoinexRates(), mExchangeRateRepository.fetchZebpayRates(), mExchangeRateRepository.fetchCoinomeRates(), (koinexResponse, zebpayResponse, coinomeResponse) -> {
                    List<ExchangeRate> exchangeRates = new ArrayList<>();
                    ExchangeRate koinexETHRate = new ExchangeRate(1, "ETH", date, Double.parseDouble(koinexResponse.getStats().getETH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getETH().getHighestBid()));

                    ExchangeRate koinexBTCRate = new ExchangeRate(1, "BTC", date, Double.parseDouble(koinexResponse.getStats().getBTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBTC().getHighestBid()));

                    ExchangeRate koinexBCHRate = new ExchangeRate(1, "BCH", date, Double.parseDouble(koinexResponse.getStats().getBCH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBCH().getHighestBid()));

                    ExchangeRate koinexLTCRate = new ExchangeRate(1, "LTC", date, Double.parseDouble(koinexResponse.getStats().getLTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getLTC().getHighestBid()));

                    ExchangeRate koinexXRPRate = new ExchangeRate(1, "XRP", date, Double.parseDouble(koinexResponse.getStats().getXRP().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getXRP().getHighestBid()));

                    ExchangeRate zebpayRate = new ExchangeRate(3, "BTC", date, zebpayResponse.getBuyPrice(), zebpayResponse.getSellPrice());

                    ExchangeRate coinomeBTCRate = new ExchangeRate(4, "BTC", date, Double.parseDouble(coinomeResponse.getBTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBTC().getHighestBid()));

                    ExchangeRate coinomeBCHRate = new ExchangeRate(4, "BCH", date, Double.parseDouble(coinomeResponse.getBCH().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getBCH().getHighestBid()));

                    ExchangeRate coinomeLTCRate = new ExchangeRate(4, "LTC", date, Double.parseDouble(coinomeResponse.getLTC().getLowestAsk()), Double.parseDouble(koinexResponse.getStats().getLTC().getHighestBid()));

                    exchangeRates.add(koinexETHRate);
                    exchangeRates.add(koinexBTCRate);
                    exchangeRates.add(koinexBCHRate);
                    exchangeRates.add(koinexLTCRate);
                    exchangeRates.add(koinexXRPRate);
                    exchangeRates.add(zebpayRate);
                    exchangeRates.add(coinomeBTCRate);
                    exchangeRates.add(coinomeBCHRate);
                    exchangeRates.add(coinomeLTCRate);
                    return exchangeRates;
                }).subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.computation())
                        .subscribe(exchangeRates -> mExchangeRateRepository.saveRates(exchangeRates)
                                , throwable -> Timber.e(throwable));

            }
        }, 0, 60000);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
