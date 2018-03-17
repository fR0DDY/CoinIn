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

import static com.fr0ddy.coinin.utils.AppConstants.BITBNS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.BUYUCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINDELTA_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINOME_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINSECURE_ID;
import static com.fr0ddy.coinin.utils.AppConstants.COINSLAB_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.OXYBIT_ID;
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
        Exchange coinsecure = new Exchange(COINSECURE_ID, "Coinsecure", "IND");
        Exchange bitbns = new Exchange(BITBNS_ID, "Bitbns", "IND");
        Exchange oxybit = new Exchange(OXYBIT_ID, "Oxybit", "IND");
        Exchange coinslab = new Exchange(COINSLAB_ID, "Coinslab", "IND");

        List<Exchange> exchanges = Arrays.asList(koinex, throughbit, zebpay, coinome, buyUcoin, coindelta, pocketBits, coinsecure, bitbns, oxybit, coinslab);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchanges(exchanges));
    }


    @Override
    public Observable<List<Long>> saveDefaultExchangeFees() {

        ExchangeFees koinexETHFees = new ExchangeFees(1, KOINEX_ID, "ETH", 0.0025, 0.0, 0.003);
        ExchangeFees koinexBTCFees = new ExchangeFees(2, KOINEX_ID, "BTC", 0.0025, 0.0, 0.001);
        ExchangeFees koinexBCHFees = new ExchangeFees(3, KOINEX_ID, "BCH", 0.0025, 0.0, 0.001);
        ExchangeFees koinexLTCFees = new ExchangeFees(4, KOINEX_ID, "LTC", 0.0025, 0.0, 0.01);
        ExchangeFees koinexXRPFees = new ExchangeFees(5, KOINEX_ID, "XRP", 0.0025, 0.0, 0.02);
        ExchangeFees koinexOMGFees = new ExchangeFees(58, KOINEX_ID, "OMG", 0.0025, 0.0, 0.1);
        ExchangeFees koinexREQFees = new ExchangeFees(59, KOINEX_ID, "REQ", 0.0025, 0.0, 10);
        ExchangeFees koinexZRXFees = new ExchangeFees(93, KOINEX_ID, "ZRX", 0.0025, 0.0, 5);
        ExchangeFees koinexAEFees = new ExchangeFees(99, KOINEX_ID, "AE", 0.0025, 0.0, 2.5);
        ExchangeFees koinexBATFees = new ExchangeFees(100, KOINEX_ID, "BAT", 0.0025, 0.0, 10);
        ExchangeFees koinexGNTFees = new ExchangeFees(101, KOINEX_ID, "GNT", 0.0025, 0.0, 10);
        ExchangeFees koinexTRXFees = new ExchangeFees(111, KOINEX_ID, "TRX", 0.0025, 0.0, 60);
        ExchangeFees koinexXLMFees = new ExchangeFees(113, KOINEX_ID, "XLM", 0.0025, 0.0, 0.02);
        ExchangeFees koinexNEOFees = new ExchangeFees(114, KOINEX_ID, "NEO", 0.0025, 0.0, 0);
        ExchangeFees koinexGASFees = new ExchangeFees(115, KOINEX_ID, "GAS", 0.0025, 0.0, 0);

        ExchangeFees throughbitETHFees = new ExchangeFees(6, THROUGHBIT_ID, "ETH", 0.00885, 0.00885, 0.002);
        ExchangeFees throughbitBTCFees = new ExchangeFees(7, THROUGHBIT_ID, "BTC", 0.00885, 0.00885, 0.00005);

        ExchangeFees zebpayBTCFees = new ExchangeFees(8, ZEBPAY_ID, "BTC", 0.0118, 0.0118, 0.0005);
        ExchangeFees zebpayBCHFees = new ExchangeFees(28, ZEBPAY_ID, "BCH", 0.00472, 0.00472, 0.001);
        ExchangeFees zebpayLTCFees = new ExchangeFees(49, ZEBPAY_ID, "LTC", 0.00472, 0.00472, 0.001);
        ExchangeFees zebpayXRPFees = new ExchangeFees(50, ZEBPAY_ID, "XRP", 0.00472, 0.00472, 0.03);
        ExchangeFees zebpayETHFees = new ExchangeFees(60, ZEBPAY_ID, "ETH", 0.00472, 0.00472, 0.002);

        ExchangeFees coinomeBTCFees = new ExchangeFees(9, COINOME_ID, "BTC", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeBCHFees = new ExchangeFees(10, COINOME_ID, "BCH", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeLTCFees = new ExchangeFees(11, COINOME_ID, "LTC", 0.00354, 0.00354, 0.005);
        ExchangeFees coinomeDASHFees = new ExchangeFees(29, COINOME_ID, "DASH", 0.00354, 0.00354, 0.001);
        ExchangeFees coinomeDGBFees = new ExchangeFees(57, COINOME_ID, "DGB", 0.00354, 0.00354, 0.2);
        ExchangeFees coinomeZECFees = new ExchangeFees(61, COINOME_ID, "ZEC", 0.00354, 0.00354, 0.005);
        ExchangeFees coinomeQTUMFees = new ExchangeFees(112, COINOME_ID, "QTUM", 0.00354, 0.00354, 0.01);

        ExchangeFees buyUcoinETHFees = new ExchangeFees(12, BUYUCOIN_ID, "ETH", 0.01, 0.01, 0.06);
        ExchangeFees buyUcoinBTCFees = new ExchangeFees(13, BUYUCOIN_ID, "BTC", 0.01, 0.01, 0.0015);
        ExchangeFees buyUcoinBCHFees = new ExchangeFees(14, BUYUCOIN_ID, "BCH", 0.01, 0.01, 0.001);
        ExchangeFees buyUcoinLTCFees = new ExchangeFees(15, BUYUCOIN_ID, "LTC", 0.01, 0.01, 0.025);
        ExchangeFees buyUcoinXRPFees = new ExchangeFees(16, BUYUCOIN_ID, "XRP", 0.01, 0.01, 1);
        ExchangeFees buyUcoinDASHFees = new ExchangeFees(30, BUYUCOIN_ID, "DASH", 0.01, 0.01, 0.002);
        ExchangeFees buyUcoinNEOFees = new ExchangeFees(31, BUYUCOIN_ID, "NEO", 0.01, 0.01, 0.025);
        ExchangeFees buyUcoinETCFees = new ExchangeFees(32, BUYUCOIN_ID, "ETC", 0.01, 0.01, 0.4);
        ExchangeFees buyUcoinQTUMFees = new ExchangeFees(33, BUYUCOIN_ID, "QTUM", 0.01, 0.01, 0.04);
        ExchangeFees buyUcoinXMRFees = new ExchangeFees(34, BUYUCOIN_ID, "XMR", 0.01, 0.01, 0.08);
        ExchangeFees buyUcoinZECFees = new ExchangeFees(35, BUYUCOIN_ID, "ZEC", 0.01, 0.01, 0.015);
        ExchangeFees buyUcoinOMGFees = new ExchangeFees(36, BUYUCOIN_ID, "OMG", 0.01, 0.01, 0.2);
        ExchangeFees buyUcoinNEMFees = new ExchangeFees(118, BUYUCOIN_ID, "NEM", 0.01, 0.01, 4);
        ExchangeFees buyUcoinGNTFees = new ExchangeFees(119, BUYUCOIN_ID, "GNT", 0.01, 0.01, 8);
        ExchangeFees buyUcoinSTRATFees = new ExchangeFees(120, BUYUCOIN_ID, "STRAT", 0.01, 0.01, 0.4);
        ExchangeFees buyUcoinSTEEMFees = new ExchangeFees(121, BUYUCOIN_ID, "STEEM", 0.01, 0.01, 0.01);
        ExchangeFees buyUcoinREPFees = new ExchangeFees(121, BUYUCOIN_ID, "REP", 0.01, 0.01, 0.05);
        ExchangeFees buyUcoinLSKFees = new ExchangeFees(122, BUYUCOIN_ID, "LSK", 0.01, 0.01, 0.25);
        ExchangeFees buyUcoinFCTFees = new ExchangeFees(123, BUYUCOIN_ID, "FCT", 0.01, 0.01, 0.02);
        ExchangeFees buyUcoinCVCFees = new ExchangeFees(124, BUYUCOIN_ID, "CVC", 0.01, 0.01, 5);
        ExchangeFees buyUcoinSCFees = new ExchangeFees(125, BUYUCOIN_ID, "SC", 0.01, 0.01, 20);
        ExchangeFees buyUcoinPAYFees = new ExchangeFees(126, BUYUCOIN_ID, "PAY", 0.01, 0.01, 1);
        ExchangeFees buyUcoinDOGEFees = new ExchangeFees(127, BUYUCOIN_ID, "DOGE", 0.01, 0.01, 500);
        ExchangeFees buyUcoinDGBFees = new ExchangeFees(128, BUYUCOIN_ID, "DGB", 0.01, 0.01, 1);
        ExchangeFees buyUcoinNXTFees = new ExchangeFees(129, BUYUCOIN_ID, "NXT", 0.01, 0.01, 2);
        ExchangeFees buyUcoinBATFees = new ExchangeFees(130, BUYUCOIN_ID, "BAT", 0.01, 0.01, 6);
        ExchangeFees buyUcoinBTSFees = new ExchangeFees(131, BUYUCOIN_ID, "BTS", 0.01, 0.01, 10);
        ExchangeFees buyUcoinCLOAKFees = new ExchangeFees(132, BUYUCOIN_ID, "CLOAK", 0.01, 0.01, 0.05);
        ExchangeFees buyUcoinPIVXFees = new ExchangeFees(133, BUYUCOIN_ID, "PIVX", 0.01, 0.01, 0.02);
        ExchangeFees buyUcoinDCNFees = new ExchangeFees(134, BUYUCOIN_ID, "DCN", 0.01, 0.01, 5000);


        ExchangeFees coindeltaETHFees = new ExchangeFees(17, COINDELTA_ID, "ETH", 0.003, 0.003, 0.005);
        ExchangeFees coindeltaBTCFees = new ExchangeFees(18, COINDELTA_ID, "BTC", 0.003, 0.003, 0.001);
        ExchangeFees coindeltaBCHFees = new ExchangeFees(19, COINDELTA_ID, "BCH", 0.003, 0.003, 0.001);
        ExchangeFees coindeltaLTCFees = new ExchangeFees(20, COINDELTA_ID, "LTC", 0.003, 0.003, 0.002);
        ExchangeFees coindeltaXRPFees = new ExchangeFees(21, COINDELTA_ID, "XRP", 0.003, 0.003, 0.01);
        ExchangeFees coindeltaOMGFees = new ExchangeFees(37, COINDELTA_ID, "OMG", 0.003, 0.003, 0.1);
        ExchangeFees coindeltaQTUMFees = new ExchangeFees(38, COINDELTA_ID, "QTUM", 0.003, 0.003, 0.01);
        ExchangeFees coindeltaZILFees = new ExchangeFees(116, COINDELTA_ID, "ZIL", 0.003, 0.003, 50);
        ExchangeFees coindeltaZRXFees = new ExchangeFees(117, COINDELTA_ID, "ZRX", 0.003, 0.003, 5);

        ExchangeFees pocketBitsETHFees = new ExchangeFees(22, POCKETBITS_ID, "ETH", 0.0, 0.0, 0.002);
        ExchangeFees pocketBitsBTCFees = new ExchangeFees(23, POCKETBITS_ID, "BTC", 0.0, 0.0, 0.0003);
        ExchangeFees pocketBitsBCHFees = new ExchangeFees(24, POCKETBITS_ID, "BCH", 0.0, 0.0, 0.001);
        ExchangeFees pocketBitsLTCFees = new ExchangeFees(25, POCKETBITS_ID, "LTC", 0.0, 0.0, 0.01);
        ExchangeFees pocketBitsXRPFees = new ExchangeFees(26, POCKETBITS_ID, "XRP", 0.0, 0.0, 5);
        ExchangeFees pocketBitsDASHFees = new ExchangeFees(38, POCKETBITS_ID, "DASH", 0.0, 0.0, 0.002);
        ExchangeFees pocketBitsETCFees = new ExchangeFees(39, POCKETBITS_ID, "ETC", 0.0, 0.0, 0.01);
        ExchangeFees pocketBitsXMRFees = new ExchangeFees(40, POCKETBITS_ID, "XMR", 0.0, 0.0, 0.04);
        ExchangeFees pocketBitsNEOFees = new ExchangeFees(41, POCKETBITS_ID, "NEO", 0.0, 0.0, 0.025);
        ExchangeFees pocketBitsOMGFees = new ExchangeFees(42, POCKETBITS_ID, "OMG", 0.0, 0.0, 0.35);
        ExchangeFees pocketBitsZECFees = new ExchangeFees(43, POCKETBITS_ID, "ZEC", 0.0, 0.0, 0.005);
        ExchangeFees pocketBitsBTGFees = new ExchangeFees(51, POCKETBITS_ID, "BTG", 0.0, 0.0, 0.001);
        ExchangeFees pocketBitsDGBFees = new ExchangeFees(52, POCKETBITS_ID, "DGB", 0.0, 0.0, 0.2);
        ExchangeFees pocketBitsXLMFees = new ExchangeFees(53, POCKETBITS_ID, "XLM", 0.0, 0.0, 0.01);
        ExchangeFees pocketBitsSCFees = new ExchangeFees(54, POCKETBITS_ID, "SC", 0.0, 0.0, 0.1);
        ExchangeFees pocketBitsXVGFees = new ExchangeFees(55, POCKETBITS_ID, "XVG", 0.0, 0.0, 0.2);
        ExchangeFees pocketBitsVOXFees = new ExchangeFees(56, POCKETBITS_ID, "VOX", 0.0, 0.0, 0.1);
        ExchangeFees pocketBitsTRXFees = new ExchangeFees(109, POCKETBITS_ID, "TRX", 0.0, 0.0, 1);

        ExchangeFees coinsecureBTCFees = new ExchangeFees(27, COINSECURE_ID, "BTC", 0.004, 0.004, 0.0001);

        ExchangeFees bitBnsBTCFees = new ExchangeFees(44, BITBNS_ID, "BTC", 0.0025, 0.0025, 0.001);
        ExchangeFees bitBnsXRPFees = new ExchangeFees(45, BITBNS_ID, "XRP", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsNEOFees = new ExchangeFees(46, BITBNS_ID, "NEO", 0.0025, 0.0025, 0);
        ExchangeFees bitBnsETHFees = new ExchangeFees(47, BITBNS_ID, "ETH", 0.0025, 0.0025, 0.001);
        ExchangeFees bitBnsXLMFees = new ExchangeFees(48, BITBNS_ID, "XLM", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsGASFees = new ExchangeFees(94, BITBNS_ID, "GAS", 0.0025, 0.0025, 0);
        ExchangeFees bitBnsRPXFees = new ExchangeFees(95, BITBNS_ID, "RPX", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsDBCFees = new ExchangeFees(96, BITBNS_ID, "DBC", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsLTCFees = new ExchangeFees(97, BITBNS_ID, "LTC", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsXMRFees = new ExchangeFees(98, BITBNS_ID, "XMR", 0.0025, 0.0025, 0.02);
        ExchangeFees bitBnsSIAFees = new ExchangeFees(104, BITBNS_ID, "SC", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsDOGEFees = new ExchangeFees(105, BITBNS_ID, "DOGE", 0.0025, 0.0025, 2);
        ExchangeFees bitBnsBCHFees = new ExchangeFees(106, BITBNS_ID, "BCH", 0.0025, 0.0025, 0.001);
        ExchangeFees bitBnsDASHFees = new ExchangeFees(107, BITBNS_ID, "DASH", 0.0025, 0.0025, 0.001);
        ExchangeFees bitBnsTRXFees = new ExchangeFees(110, BITBNS_ID, "TRX", 0.0025, 0.0025, 30);

        ExchangeFees oxybitFees1 = new ExchangeFees(62, OXYBIT_ID, "BTC", 0.0, 0.0, 0.0005);
        ExchangeFees oxybitFees2 = new ExchangeFees(63, OXYBIT_ID, "ETH", 0.0, 0.0, 0.005);
        ExchangeFees oxybitFees3 = new ExchangeFees(64, OXYBIT_ID, "XRP", 0.0, 0.0, 0.5);
        ExchangeFees oxybitFees4 = new ExchangeFees(65, OXYBIT_ID, "LTC", 0.0, 0.0, 0.01);
        ExchangeFees oxybitFees5 = new ExchangeFees(66, OXYBIT_ID, "BCH", 0.0, 0.0, 0.001);
        ExchangeFees oxybitFees6 = new ExchangeFees(67, OXYBIT_ID, "XLM", 0.0, 0.0, 1);
        ExchangeFees oxybitFees7 = new ExchangeFees(68, OXYBIT_ID, "EOS", 0.0, 0.0, 0.1);
        ExchangeFees oxybitFees8 = new ExchangeFees(69, OXYBIT_ID, "DASH", 0.0, 0.0, 0.01);
        ExchangeFees oxybitFees9 = new ExchangeFees(70, OXYBIT_ID, "XMR", 0.0, 0.0, 0.06);
        ExchangeFees oxybitFees10 = new ExchangeFees(71, OXYBIT_ID, "TRX", 0.0, 0.0, 125);
        ExchangeFees oxybitFees11 = new ExchangeFees(72, OXYBIT_ID, "VET", 0.0, 0.0, 3);
        ExchangeFees oxybitFees12 = new ExchangeFees(73, OXYBIT_ID, "OMG", 0.0, 0.0, 0.3);
        ExchangeFees oxybitFees13 = new ExchangeFees(74, OXYBIT_ID, "NANO", 0.0, 0.0, 1);
        ExchangeFees oxybitFees14 = new ExchangeFees(75, OXYBIT_ID, "SNT", 0.0, 0.0, 30);
        ExchangeFees oxybitFees15 = new ExchangeFees(76, OXYBIT_ID, "REP", 0.0, 0.0, 0.1);
        ExchangeFees oxybitFees16 = new ExchangeFees(77, OXYBIT_ID, "ZRX", 0.0, 0.0, 8.1);
        ExchangeFees oxybitFees17 = new ExchangeFees(78, OXYBIT_ID, "BAT", 0.0, 0.0, 25);
        ExchangeFees oxybitFees18 = new ExchangeFees(79, OXYBIT_ID, "GNT", 0.0, 0.0, 15);
        ExchangeFees oxybitFees19 = new ExchangeFees(80, OXYBIT_ID, "KNC", 0.0, 0.0, 3);
        ExchangeFees oxybitFees20 = new ExchangeFees(81, OXYBIT_ID, "FUN", 0.0, 0.0, 120);
        ExchangeFees oxybitFees21 = new ExchangeFees(82, OXYBIT_ID, "SALT", 0.0, 0.0, 2);
        ExchangeFees oxybitFees22 = new ExchangeFees(83, OXYBIT_ID, "BNT", 0.0, 0.0, 3);
        ExchangeFees oxybitFees23 = new ExchangeFees(84, OXYBIT_ID, "REQ", 0.0, 0.0, 30);
        ExchangeFees oxybitFees24 = new ExchangeFees(85, OXYBIT_ID, "SAN", 0.0, 0.0, 3);
        ExchangeFees oxybitFees25 = new ExchangeFees(86, OXYBIT_ID, "GNO", 0.0, 0.0, 0.01);
        ExchangeFees oxybitFees26 = new ExchangeFees(87, OXYBIT_ID, "ICN", 0.0, 0.0, 3);
        ExchangeFees oxybitFees27 = new ExchangeFees(88, OXYBIT_ID, "POE", 0.0, 0.0, 120);
        ExchangeFees oxybitFees28 = new ExchangeFees(89, OXYBIT_ID, "CVC", 0.0, 0.0, 30);
        ExchangeFees oxybitFees29 = new ExchangeFees(90, OXYBIT_ID, "STORJ", 0.0, 0.0, 3);
        ExchangeFees oxybitFees30 = new ExchangeFees(91, OXYBIT_ID, "MCO", 0.0, 0.0, 1);
        ExchangeFees oxybitFees31 = new ExchangeFees(92, OXYBIT_ID, "ANT", 0.0, 0.0, 3);
        ExchangeFees oxybitFees32 = new ExchangeFees(102, OXYBIT_ID, "NEO", 0.0, 0.0, 0.01);
        ExchangeFees oxybitFees33 = new ExchangeFees(103, OXYBIT_ID, "GAS", 0.0, 0.0, 0.1);

        ExchangeFees coinslabFees = new ExchangeFees(108, COINSLAB_ID, "BTC", 0.0, 0.0, 0.0002);


        List<ExchangeFees> exchangeFees = Arrays.asList(koinexETHFees, koinexBTCFees, koinexBCHFees, koinexLTCFees, koinexXRPFees, throughbitETHFees, throughbitBTCFees, zebpayBTCFees, coinomeBTCFees, zebpayLTCFees, zebpayXRPFees, coinomeBCHFees, coinomeLTCFees, buyUcoinETHFees, buyUcoinBTCFees, buyUcoinBCHFees, buyUcoinLTCFees, buyUcoinXRPFees, coindeltaETHFees, coindeltaBTCFees, coindeltaBCHFees, coindeltaLTCFees, coindeltaXRPFees, pocketBitsETHFees, pocketBitsBTCFees, pocketBitsBCHFees, pocketBitsLTCFees, pocketBitsXRPFees, pocketBitsBTGFees, pocketBitsDGBFees, pocketBitsXLMFees, pocketBitsSCFees, pocketBitsXVGFees, pocketBitsVOXFees, coinsecureBTCFees, zebpayBCHFees, coinomeDASHFees, buyUcoinDASHFees, buyUcoinNEOFees, buyUcoinETCFees, buyUcoinQTUMFees, buyUcoinXMRFees, buyUcoinZECFees, buyUcoinOMGFees, coindeltaOMGFees, coindeltaQTUMFees, pocketBitsDASHFees, pocketBitsETCFees, pocketBitsXMRFees, pocketBitsNEOFees, pocketBitsOMGFees, pocketBitsZECFees, bitBnsBTCFees, bitBnsXRPFees, bitBnsNEOFees, bitBnsETHFees, bitBnsXLMFees, coinomeDGBFees, koinexOMGFees, koinexREQFees, zebpayETHFees, coinomeZECFees, oxybitFees1, oxybitFees2, oxybitFees3, oxybitFees4, oxybitFees5, oxybitFees6, oxybitFees7, oxybitFees8, oxybitFees9, oxybitFees10, oxybitFees11, oxybitFees12, oxybitFees13, oxybitFees14, oxybitFees15, oxybitFees16, oxybitFees17, oxybitFees18, oxybitFees19, oxybitFees20, oxybitFees21, oxybitFees22, oxybitFees23, oxybitFees24, oxybitFees25, oxybitFees26, oxybitFees27, oxybitFees28, oxybitFees29, oxybitFees30, oxybitFees31, koinexZRXFees, bitBnsGASFees, bitBnsRPXFees, bitBnsDBCFees, bitBnsLTCFees, bitBnsXMRFees, koinexAEFees, koinexBATFees, koinexGNTFees, oxybitFees32, oxybitFees33, bitBnsSIAFees, bitBnsDOGEFees, bitBnsBCHFees, bitBnsDASHFees, pocketBitsTRXFees, coinslabFees, bitBnsTRXFees, koinexTRXFees, coinomeQTUMFees, koinexXLMFees, koinexNEOFees, koinexGASFees, coindeltaZILFees, coindeltaZRXFees, buyUcoinNEMFees, buyUcoinGNTFees, buyUcoinSTRATFees, buyUcoinSTEEMFees, buyUcoinREPFees, buyUcoinLSKFees, buyUcoinFCTFees, buyUcoinCVCFees, buyUcoinSCFees, buyUcoinPAYFees, buyUcoinDOGEFees, buyUcoinDGBFees, buyUcoinNXTFees, buyUcoinBATFees, buyUcoinBTSFees, buyUcoinCLOAKFees, buyUcoinPIVXFees, buyUcoinDCNFees);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchangeFees(exchangeFees));
    }
}
