package com.fr0ddy.coinin.ui.splash;

import com.fr0ddy.coinin.data.repository.ExchangeRepository;
import com.fr0ddy.coinin.data.source.local.db.model.Exchange;
import com.fr0ddy.coinin.data.source.local.db.model.ExchangeFees;
import com.fr0ddy.coinin.data.source.local.prefs.PreferencesHelper;
import com.fr0ddy.coinin.ui.base.BaseInteractor;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by gaurav on 18/11/17.
 */

public class SplashInteractor extends BaseInteractor
        implements SplashContract.Interactor {

    private ExchangeRepository mExchangeRepository;

    @Inject
    public SplashInteractor(PreferencesHelper preferencesHelper, ExchangeRepository exchangeRepository) {
        super(preferencesHelper);
        this.mExchangeRepository = exchangeRepository;
    }

    @Override
    public Observable<List<Long>> saveDefaultExchanges() {

        Exchange koinex = new Exchange(1, "Koinex", "IND");
        Exchange throughbit = new Exchange(2, "Throughbit", "IND");
        Exchange zebpay = new Exchange(3, "Zebpay", "IND");
        Exchange coinome = new Exchange(4, "Coinome", "IND");
        Exchange buyUcoin = new Exchange(5, "BuyUcoin", "IND");

        List<Exchange> exchanges = Arrays.asList(koinex, throughbit, zebpay, coinome, buyUcoin);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchanges(exchanges));
    }


    @Override
    public Observable<List<Long>> saveDefaultExchangeFees() {

        ExchangeFees koinexETHFees = new ExchangeFees(1, 1, "ETH", 0.0025, 0.0020, 0.003);
        ExchangeFees koinexBTCFees = new ExchangeFees(2, 1, "BTC", 0.0025, 0.0020, 0.001);
        ExchangeFees koinexBCHFees = new ExchangeFees(3, 1, "BCH", 0.0025, 0.0020, 0.001);
        ExchangeFees koinexLTCFees = new ExchangeFees(4, 1, "LTC", 0.0025, 0.0020, 0.01);
        ExchangeFees koinexXRPFees = new ExchangeFees(5, 1, "XRP", 0.0025, 0.0020, 0.02);
        ExchangeFees throughbitETHFees = new ExchangeFees(6, 2, "ETH", 0.00885, 0.00885, 0.002);
        ExchangeFees throughbitBTCFees = new ExchangeFees(7, 2, "BTC", 0.00885, 0.00885, 0.0007);
        ExchangeFees zebpayBTCFees = new ExchangeFees(8, 3, "BTC", 0.0, 0.0, 0.0001);
        ExchangeFees coinomeBTCFees = new ExchangeFees(9, 4, "BTC", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeBCHFees = new ExchangeFees(10, 4, "BCH", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeLTCFees = new ExchangeFees(11, 4, "LTC", 0.00354, 0.00354, 0.005);
        ExchangeFees buyUcoinETHFees = new ExchangeFees(12, 5, "ETH", 0.0, 0.0, 0.006);
        ExchangeFees buyUcoinBTCFees = new ExchangeFees(13, 5, "BTC", 0.0, 0.0, 0.0015);
        ExchangeFees buyUcoinBCHFees = new ExchangeFees(14, 5, "BCH", 0.0, 0.0, 0.001);
        ExchangeFees buyUcoinLTCFees = new ExchangeFees(15, 5, "LTC", 0.0, 0.0, 0.025);
        ExchangeFees buyUcoinXRPFees = new ExchangeFees(16, 5, "XRP", 0.0, 0.0, 5);

        List<ExchangeFees> exchangeFees = Arrays.asList(koinexETHFees, koinexBTCFees, koinexBCHFees, koinexLTCFees, koinexXRPFees, throughbitETHFees, throughbitBTCFees, zebpayBTCFees, coinomeBTCFees, coinomeBCHFees, coinomeLTCFees, buyUcoinETHFees, buyUcoinBTCFees, buyUcoinBCHFees, buyUcoinLTCFees,
                buyUcoinXRPFees);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchangeFees(exchangeFees));
    }
}
