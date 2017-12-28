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

import static com.fr0ddy.coinin.utils.AppConstants.BUYUCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINDELTA_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINOME_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.POCKETBITS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.THROUGHBIT_ID;
import static com.fr0ddy.coinin.utils.AppConstants.ZEBPAY_ID;

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

        Exchange koinex = new Exchange(KOINEX_ID, "Koinex", "IND");
        Exchange throughbit = new Exchange(THROUGHBIT_ID, "Throughbit", "IND");
        Exchange zebpay = new Exchange(ZEBPAY_ID, "Zebpay", "IND");
        Exchange coinome = new Exchange(COINOME_ID, "Coinome", "IND");
        Exchange buyUcoin = new Exchange(BUYUCOIN_ID, "BuyUcoin", "IND");
        Exchange coindelta = new Exchange(COINDELTA_ID, "Coindelta", "IND");
        Exchange pocketBits = new Exchange(POCKETBITS_ID, "PocketBits", "IND");

        List<Exchange> exchanges = Arrays.asList(koinex, throughbit, zebpay, coinome, buyUcoin, coindelta, pocketBits);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchanges(exchanges));
    }


    @Override
    public Observable<List<Long>> saveDefaultExchangeFees() {

        ExchangeFees koinexETHFees = new ExchangeFees(1, KOINEX_ID, "ETH", 0.0025, 0.0020, 0.003);
        ExchangeFees koinexBTCFees = new ExchangeFees(2, KOINEX_ID, "BTC", 0.0025, 0.0020, 0.001);
        ExchangeFees koinexBCHFees = new ExchangeFees(3, KOINEX_ID, "BCH", 0.0025, 0.0020, 0.001);
        ExchangeFees koinexLTCFees = new ExchangeFees(4, KOINEX_ID, "LTC", 0.0025, 0.0020, 0.01);
        ExchangeFees koinexXRPFees = new ExchangeFees(5, KOINEX_ID, "XRP", 0.0025, 0.0020, 0.02);
        ExchangeFees throughbitETHFees = new ExchangeFees(6, THROUGHBIT_ID, "ETH", 0.00885, 0.00885, 0.002);
        ExchangeFees throughbitBTCFees = new ExchangeFees(7, THROUGHBIT_ID, "BTC", 0.00885, 0.00885, 0.0007);
        ExchangeFees zebpayBTCFees = new ExchangeFees(8, ZEBPAY_ID, "BTC", 0.0, 0.0, 0.0001);
        ExchangeFees coinomeBTCFees = new ExchangeFees(9, COINOME_ID, "BTC", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeBCHFees = new ExchangeFees(10, COINOME_ID, "BCH", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeLTCFees = new ExchangeFees(11, COINOME_ID, "LTC", 0.00354, 0.00354, 0.005);
        ExchangeFees buyUcoinETHFees = new ExchangeFees(12, BUYUCOIN_ID, "ETH", 0.0, 0.0, 0.006);
        ExchangeFees buyUcoinBTCFees = new ExchangeFees(13, BUYUCOIN_ID, "BTC", 0.0, 0.0, 0.0015);
        ExchangeFees buyUcoinBCHFees = new ExchangeFees(14, BUYUCOIN_ID, "BCH", 0.0, 0.0, 0.001);
        ExchangeFees buyUcoinLTCFees = new ExchangeFees(15, BUYUCOIN_ID, "LTC", 0.0, 0.0, 0.025);
        ExchangeFees buyUcoinXRPFees = new ExchangeFees(16, BUYUCOIN_ID, "XRP", 0.0, 0.0, 5);
        ExchangeFees coindeltaETHFees = new ExchangeFees(17, COINDELTA_ID, "ETH", 0.003, 0.003, 0.005);
        ExchangeFees coindeltaBTCFees = new ExchangeFees(18, COINDELTA_ID, "BTC", 0.003, 0.003, 0.001);
        ExchangeFees coindeltaBCHFees = new ExchangeFees(19, COINDELTA_ID, "BCH", 0.003, 0.003, 0.001);
        ExchangeFees coindeltaLTCFees = new ExchangeFees(20, COINDELTA_ID, "LTC", 0.003, 0.003, 0.002);
        ExchangeFees coindeltaXRPFees = new ExchangeFees(21, COINDELTA_ID, "XRP", 0.003, 0.003, 0.01);
        ExchangeFees pocketBitsETHFees = new ExchangeFees(22, POCKETBITS_ID, "ETH", 0.0, 0.0, 0.002);
        ExchangeFees pocketBitsBTCFees = new ExchangeFees(23, POCKETBITS_ID, "BTC", 0.0, 0.0, 0.0003);
        ExchangeFees pocketBitsBCHFees = new ExchangeFees(24, POCKETBITS_ID, "BCH", 0.0, 0.0, 0.001);
        ExchangeFees pocketBitsLTCFees = new ExchangeFees(25, POCKETBITS_ID, "LTC", 0.0, 0.0, 0.01);
        ExchangeFees pocketBitsXRPFees = new ExchangeFees(26, POCKETBITS_ID, "XRP", 0.0, 0.0, 5);

        List<ExchangeFees> exchangeFees = Arrays.asList(koinexETHFees, koinexBTCFees, koinexBCHFees, koinexLTCFees, koinexXRPFees, throughbitETHFees, throughbitBTCFees, zebpayBTCFees, coinomeBTCFees, coinomeBCHFees, coinomeLTCFees, buyUcoinETHFees, buyUcoinBTCFees, buyUcoinBCHFees, buyUcoinLTCFees,
                buyUcoinXRPFees, coindeltaETHFees, coindeltaBTCFees, coindeltaBCHFees, coindeltaLTCFees, coindeltaXRPFees, pocketBitsETHFees, pocketBitsBTCFees,
                pocketBitsBCHFees, pocketBitsLTCFees, pocketBitsXRPFees);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchangeFees(exchangeFees));
    }
}
