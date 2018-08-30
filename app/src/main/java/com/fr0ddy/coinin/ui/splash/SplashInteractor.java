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
import static com.fr0ddy.coinin.utils.AppConstants.GIOTTUS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;
import static com.fr0ddy.coinin.utils.AppConstants.KOINOK_ID;
import static com.fr0ddy.coinin.utils.AppConstants.OXYBIT_ID;
import static com.fr0ddy.coinin.utils.AppConstants.POCKETBITS_ID;
import static com.fr0ddy.coinin.utils.AppConstants.THROUGHBIT_ID;
import static com.fr0ddy.coinin.utils.AppConstants.UNOCOIN_ID;
import static com.fr0ddy.coinin.utils.AppConstants.WAZIRX_ID;
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
        Exchange unocoin = new Exchange(UNOCOIN_ID, "Unocoin", "IND");
        Exchange wazirX = new Exchange(WAZIRX_ID, "WazirX", "IND");
        Exchange koinOk = new Exchange(KOINOK_ID, "KoinOk", "IND");
        Exchange giottus = new Exchange(GIOTTUS_ID, "Giottus", "IND");

        List<Exchange> exchanges = Arrays.asList(koinex, throughbit, zebpay, coinome, buyUcoin, coindelta, pocketBits, coinsecure, bitbns, oxybit, coinslab, unocoin, wazirX, koinOk, giottus);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchanges(exchanges));
    }


    @Override
    public Observable<List<Long>> saveDefaultExchangeFees() {

        ExchangeFees koinexETHFees = new ExchangeFees(1, KOINEX_ID, "ETH", 0.0015, 0.0015, 0.003);
        ExchangeFees koinexBTCFees = new ExchangeFees(2, KOINEX_ID, "BTC", 0.0015, 0.0015, 0.0005);
        ExchangeFees koinexBCHFees = new ExchangeFees(3, KOINEX_ID, "BCH", 0.0015, 0.0015, 0.001);
        ExchangeFees koinexLTCFees = new ExchangeFees(4, KOINEX_ID, "LTC", 0.0015, 0.0015, 0.01);
        ExchangeFees koinexXRPFees = new ExchangeFees(5, KOINEX_ID, "XRP", 0.0015, 0.0015, 0.25);
        ExchangeFees koinexOMGFees = new ExchangeFees(58, KOINEX_ID, "OMG", 0.0015, 0.0015, 0.25);
        ExchangeFees koinexREQFees = new ExchangeFees(59, KOINEX_ID, "REQ", 0.0015, 0.0015, 30);
        ExchangeFees koinexZRXFees = new ExchangeFees(93, KOINEX_ID, "ZRX", 0.0015, 0.0015, 2);
        ExchangeFees koinexAEFees = new ExchangeFees(99, KOINEX_ID, "AE", 0.0015, 0.0015, 2);
        ExchangeFees koinexBATFees = new ExchangeFees(100, KOINEX_ID, "BAT", 0.0015, 0.0015, 25);
        ExchangeFees koinexGNTFees = new ExchangeFees(101, KOINEX_ID, "GNT", 0.0015, 0.0015, 7.5);
        ExchangeFees koinexTRXFees = new ExchangeFees(111, KOINEX_ID, "TRX", 0.0015, 0.0015, 5);
        ExchangeFees koinexXLMFees = new ExchangeFees(113, KOINEX_ID, "XLM", 0.0015, 0.0015, 0.02);
        ExchangeFees koinexNEOFees = new ExchangeFees(114, KOINEX_ID, "NEO", 0.0015, 0.0015, 0);
        ExchangeFees koinexGASFees = new ExchangeFees(115, KOINEX_ID, "GAS", 0.0015, 0.0015, 0);
        ExchangeFees koinexAIONFees = new ExchangeFees(138, KOINEX_ID, "AION", 0.0015, 0.0015, 4);
        ExchangeFees koinexNCASHFees = new ExchangeFees(139, KOINEX_ID, "NCASH", 0.0015, 0.0015, 200);
        ExchangeFees koinexEOSFees = new ExchangeFees(146, KOINEX_ID, "EOS", 0.1, 0.1, 0.4);
        ExchangeFees koinexNANOFees = new ExchangeFees(147, KOINEX_ID, "NANO", 0.0015, 0.0015, 0.05);
        ExchangeFees koinexONTFees = new ExchangeFees(196, KOINEX_ID, "ONT", 0.0015, 0.1, 0.0);
        ExchangeFees koinexZILFees = new ExchangeFees(197, KOINEX_ID, "ZIL", 0.0015, 0.0015, 50);
        ExchangeFees koinexIOSTFees = new ExchangeFees(206, KOINEX_ID, "IOST", 0.0015, 0.0015, 140);
        ExchangeFees koinexZCOFees = new ExchangeFees(208, KOINEX_ID, "ZCO", 0.0015, 0.0015, 100);
        ExchangeFees koinexPOLYFees = new ExchangeFees(209, KOINEX_ID, "POLY", 0.0015, 0.0015, 10);
        ExchangeFees koinexAELFFees = new ExchangeFees(227, KOINEX_ID, "AELF", 0.0015, 0.0015, 3.5);
        ExchangeFees koinexCMTFees = new ExchangeFees(238, KOINEX_ID, "CMT", 0.0015, 0.0015, 15);
        ExchangeFees koinexACTFees = new ExchangeFees(259, KOINEX_ID, "ACT", 0.0015, 0.0015, 0.2);
        ExchangeFees koinexSNTFees = new ExchangeFees(280, KOINEX_ID, "SNT", 0.0015, 0.0015, 75);
        ExchangeFees koinexREPFees = new ExchangeFees(293, KOINEX_ID, "REP", 0.0015, 0.0015, 0.2);
        ExchangeFees koinexQKCFees = new ExchangeFees(295, KOINEX_ID, "QKC", 0.0015, 0.0015, 25);
        ExchangeFees koinexXZCFees = new ExchangeFees(297, KOINEX_ID, "XZC", 0.0015, 0.0015, 0.02);
        ExchangeFees koinexUSDTFees = new ExchangeFees(324, KOINEX_ID, "TUSD", 0.0015, 0.0015, 4);

        ExchangeFees throughbitETHFees = new ExchangeFees(6, THROUGHBIT_ID, "ETH", 0.1/*0.00885*/, 0.1, 0.002);
        ExchangeFees throughbitBTCFees = new ExchangeFees(7, THROUGHBIT_ID, "BTC", 0.1, 0.1, 0.00005);

        ExchangeFees zebpayBTCFees = new ExchangeFees(8, ZEBPAY_ID, "BTC", 0.00295, 0.2, 0.0005);
        ExchangeFees zebpayBCHFees = new ExchangeFees(28, ZEBPAY_ID, "BCH", 0.00295, 0.2, 0.001);
        ExchangeFees zebpayLTCFees = new ExchangeFees(49, ZEBPAY_ID, "LTC", 0.00295, 0.2, 0.006);
        ExchangeFees zebpayXRPFees = new ExchangeFees(50, ZEBPAY_ID, "XRP", 0.00295, 0.2, 0.15);
        ExchangeFees zebpayETHFees = new ExchangeFees(60, ZEBPAY_ID, "ETH", 0.00295, 0.2, 0.01);
        ExchangeFees zebpayEOSFees = new ExchangeFees(194, ZEBPAY_ID, "EOS", 0.00295, 0.2, 0.05);
        ExchangeFees zebpayOMGFees = new ExchangeFees(195, ZEBPAY_ID, "OMG", 0.00295, 0.2, 0.1);
        ExchangeFees zebpayTRXFees = new ExchangeFees(199, ZEBPAY_ID, "TRX", 0.00295, 0.2, 10);
        ExchangeFees zebpayZILFees = new ExchangeFees(283, ZEBPAY_ID, "ZIL", 0.00295, 0.2, 2);
        ExchangeFees zebpayREPFees = new ExchangeFees(284, ZEBPAY_ID, "REP", 0.00295, 0.2, 0.05);
        ExchangeFees zebpayZRXFees = new ExchangeFees(285, ZEBPAY_ID, "ZRX", 0.00295, 0.2, 5);
        ExchangeFees zebpayKNCFees = new ExchangeFees(286, ZEBPAY_ID, "KNC", 0.00295, 0.2, 1);
        ExchangeFees zebpayGNTFees = new ExchangeFees(287, ZEBPAY_ID, "GNT", 0.00295, 0.2, 5);
        ExchangeFees zebpayBATFees = new ExchangeFees(288, ZEBPAY_ID, "BAT", 0.00295, 0.2, 10);
        ExchangeFees zebpayVENFees = new ExchangeFees(289, ZEBPAY_ID, "VEN", 0.00295, 0.2, 1);
        ExchangeFees zebpayAEFees = new ExchangeFees(290, ZEBPAY_ID, "AE", 0.00295, 0.2, 1);
        ExchangeFees zebpayIOSTFees = new ExchangeFees(291, ZEBPAY_ID, "IOST", 0.00295, 0.2, 85);
        ExchangeFees zebpayCMTFees = new ExchangeFees(292, ZEBPAY_ID, "CMT", 0.00295, 0.2, 8);
        ExchangeFees zebpayNCASHFees = new ExchangeFees(316, ZEBPAY_ID, "NCASH", 0.00295, 0.2, 200);
        ExchangeFees zebpayTUSDFees = new ExchangeFees(325, ZEBPAY_ID, "TUSD", 0.00295, 0.2, 0);

        ExchangeFees coinomeBTCFees = new ExchangeFees(9, COINOME_ID, "BTC", 0.00354, 0.1, 0.0005);
        ExchangeFees coinomeBCHFees = new ExchangeFees(10, COINOME_ID, "BCH", 0.00354, 0.1, 0.001);
        ExchangeFees coinomeLTCFees = new ExchangeFees(11, COINOME_ID, "LTC", 0.00354, 0.1, 0.005);
        ExchangeFees coinomeDASHFees = new ExchangeFees(29, COINOME_ID, "DASH", 0.00354, 0.1, 0.001);
        ExchangeFees coinomeDGBFees = new ExchangeFees(57, COINOME_ID, "DGB", 0.00354, 0.1, 0.2);
        ExchangeFees coinomeZECFees = new ExchangeFees(61, COINOME_ID, "ZEC", 0.00354, 0.1, 0.005);
        ExchangeFees coinomeQTUMFees = new ExchangeFees(112, COINOME_ID, "QTUM", 0.00354, 0.1, 0.01);
        ExchangeFees coinomeBTGFees = new ExchangeFees(156, COINOME_ID, "BTG", 0.00354, 0.1, 0.01);
        ExchangeFees coinomeXRPFees = new ExchangeFees(242, COINOME_ID, "XRP", 0.00354, 0.1, 0.25);
        ExchangeFees coinomeETHFees = new ExchangeFees(260, COINOME_ID, "ETH", 0.00354, 0.1, 0.003);

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


        ExchangeFees coindeltaETHFees = new ExchangeFees(17, COINDELTA_ID, "ETH", 0.0015, 0.0015, 0.01);
        ExchangeFees coindeltaBTCFees = new ExchangeFees(18, COINDELTA_ID, "BTC", 0.0015, 0.0015, 0.001);
        ExchangeFees coindeltaBCHFees = new ExchangeFees(19, COINDELTA_ID, "BCH", 0.0015, 0.0015, 0.001);
        ExchangeFees coindeltaLTCFees = new ExchangeFees(20, COINDELTA_ID, "LTC", 0.0015, 0.0015, 0.002);
        ExchangeFees coindeltaXRPFees = new ExchangeFees(21, COINDELTA_ID, "XRP", 0.0015, 0.0015, 0.01);
        ExchangeFees coindeltaOMGFees = new ExchangeFees(37, COINDELTA_ID, "OMG", 0.0015, 0.003, 0.1);
        ExchangeFees coindeltaQTUMFees = new ExchangeFees(38, COINDELTA_ID, "QTUM", 0.0015, 0.0015, 0.01);
        ExchangeFees coindeltaZILFees = new ExchangeFees(116, COINDELTA_ID, "ZIL", 0.0015, 0.0015, 50);
        ExchangeFees coindeltaZRXFees = new ExchangeFees(117, COINDELTA_ID, "ZRX", 0.0015, 0.0015, 5);
        ExchangeFees coindeltaKNCFees = new ExchangeFees(140, COINDELTA_ID, "KNC", 0.0015, 0.0015, 2);
        ExchangeFees coindeltaEOSFees = new ExchangeFees(141, COINDELTA_ID, "EOS", 0.1, 0.1, 0.5);
        ExchangeFees coindeltaZECFees = new ExchangeFees(153, COINDELTA_ID, "ZEC", 0.0015, 0.0015, 0.005);
        ExchangeFees coindeltaNEOFees = new ExchangeFees(154, COINDELTA_ID, "NEO", 0.0015, 0.0015, 0);
        ExchangeFees coindeltaGASFees = new ExchangeFees(155, COINDELTA_ID, "GAS", 0.0015, 0.0015, 0);
        ExchangeFees coindeltaAIONFees = new ExchangeFees(164, COINDELTA_ID, "AION", 0.0015, 0.0015, 1);
        ExchangeFees coindeltaBATFees = new ExchangeFees(165, COINDELTA_ID, "BAT", 0.0015, 0.0015, 10);
        ExchangeFees coindeltaCNDFees = new ExchangeFees(166, COINDELTA_ID, "CND", 0.0015, 0.0015, 30);
        ExchangeFees coindeltaCVCFees = new ExchangeFees(167, COINDELTA_ID, "CVC", 0.0015, 0.0015, 10);
        ExchangeFees coindeltaMANAFees = new ExchangeFees(168, COINDELTA_ID, "MANA", 0.0015, 0.0015, 30);
        ExchangeFees coindeltaENGFees = new ExchangeFees(169, COINDELTA_ID, "ENG", 0.0015, 0.0015, 1.5);
        ExchangeFees coindeltaGNTFees = new ExchangeFees(170, COINDELTA_ID, "GNT", 0.0015, 0.0015, 10);
        ExchangeFees coindeltaICXFees = new ExchangeFees(171, COINDELTA_ID, "ICX", 0.0015, 0.0015, 0.1);
        ExchangeFees coindeltaSPANKFees = new ExchangeFees(172, COINDELTA_ID, "SPANK", 0.0015, 0.0015, 20);
        ExchangeFees coindeltaTRXFees = new ExchangeFees(173, COINDELTA_ID, "TRX", 0.1, 0.1, 60);
        ExchangeFees coindeltaACTFees = new ExchangeFees(236, COINDELTA_ID, "ACT", 0.0015, 0.0015, 1);
        ExchangeFees coindeltaDAIFees = new ExchangeFees(241, COINDELTA_ID, "DAI", 0.0015, 0.0015, 5);
        ExchangeFees coindeltaQKCFees = new ExchangeFees(281, COINDELTA_ID, "QKC", 0.0015, 0.0015, 20);
        ExchangeFees coindeltaKRMFees = new ExchangeFees(282, COINDELTA_ID, "KRM", 0.0015, 0.0015, 20);
        ExchangeFees coindeltaAEFees = new ExchangeFees(294, COINDELTA_ID, "AE", 0.0015, 0.0015, 1.2);
        ExchangeFees coindeltaTENFees = new ExchangeFees(296, COINDELTA_ID, "TEN", 0.0015, 0.0015, 10);
        ExchangeFees coindeltaSTXFees = new ExchangeFees(310, COINDELTA_ID, "STX", 0.0015, 0.0015, 10);
        ExchangeFees coindeltaHSTFees = new ExchangeFees(311, COINDELTA_ID, "HST", 0.0015, 0.0015, 10);

        ExchangeFees pocketBitsETHFees = new ExchangeFees(22, POCKETBITS_ID, "ETH", 0.1, 0.1, 0.002);
        ExchangeFees pocketBitsBTCFees = new ExchangeFees(23, POCKETBITS_ID, "BTC", 0.1, 0.0, 0.0003);
        ExchangeFees pocketBitsBCHFees = new ExchangeFees(24, POCKETBITS_ID, "BCH", 0.1, 0.1, 0.001);
        ExchangeFees pocketBitsLTCFees = new ExchangeFees(25, POCKETBITS_ID, "LTC", 0.1, 0.1, 0.01);
        ExchangeFees pocketBitsXRPFees = new ExchangeFees(26, POCKETBITS_ID, "XRP", 0.1, 0.1, 5);
        ExchangeFees pocketBitsDASHFees = new ExchangeFees(163, POCKETBITS_ID, "DASH", 0.1, 0.1, 0.002);
        ExchangeFees pocketBitsETCFees = new ExchangeFees(39, POCKETBITS_ID, "ETC", 0.1, 0.1, 0.01);
        ExchangeFees pocketBitsXMRFees = new ExchangeFees(40, POCKETBITS_ID, "XMR", 0.1, 0.1, 0.04);
        ExchangeFees pocketBitsNEOFees = new ExchangeFees(41, POCKETBITS_ID, "NEO", 0.1, 0.1, 0.025);
        ExchangeFees pocketBitsOMGFees = new ExchangeFees(42, POCKETBITS_ID, "OMG", 0.1, 0.1, 0.35);
        ExchangeFees pocketBitsZECFees = new ExchangeFees(43, POCKETBITS_ID, "ZEC", 0.1, 0.1, 0.005);
        ExchangeFees pocketBitsBTGFees = new ExchangeFees(51, POCKETBITS_ID, "BTG", 0.1, 0.1, 0.001);
        ExchangeFees pocketBitsDGBFees = new ExchangeFees(52, POCKETBITS_ID, "DGB", 0.1, 0.1, 0.2);
        ExchangeFees pocketBitsXLMFees = new ExchangeFees(53, POCKETBITS_ID, "XLM", 0.1, 0.1, 0.01);
        ExchangeFees pocketBitsSCFees = new ExchangeFees(54, POCKETBITS_ID, "SC", 0.1, 0.1, 0.1);
        ExchangeFees pocketBitsXVGFees = new ExchangeFees(55, POCKETBITS_ID, "XVG", 0.1, 0.1, 0.2);
        ExchangeFees pocketBitsVOXFees = new ExchangeFees(56, POCKETBITS_ID, "VOX", 0.1, 0.1, 0.1);
        ExchangeFees pocketBitsTRXFees = new ExchangeFees(109, POCKETBITS_ID, "TRX", 0.1, 0.1, 1);
        ExchangeFees pocketBitsZRXFees = new ExchangeFees(183, POCKETBITS_ID, "ZRX", 0.1, 0.1, 1);
        ExchangeFees pocketBitsREPFees = new ExchangeFees(184, POCKETBITS_ID, "REP", 0.1, 0.1, 0.1);
        ExchangeFees pocketBitsBATFees = new ExchangeFees(185, POCKETBITS_ID, "BAT", 0.1, 0.1, 10);
        ExchangeFees pocketBitsQTUMFees = new ExchangeFees(186, POCKETBITS_ID, "QTUM", 0.1, 0.1, 0.01);
        ExchangeFees pocketBitsADAFees = new ExchangeFees(187, POCKETBITS_ID, "ADA", 0.1, 0.1, 0.2);
        ExchangeFees pocketBitsDOGEFees = new ExchangeFees(188, POCKETBITS_ID, "DOGE", 0.1, 0.1, 2);
        ExchangeFees pocketBitsGNTFees = new ExchangeFees(189, POCKETBITS_ID, "GNT", 0.1, 0.1, 9);
        ExchangeFees pocketBitsSTORJFees = new ExchangeFees(190, POCKETBITS_ID, "STORJ", 0.1, 0.1, 3);
        ExchangeFees pocketBitsUBQFees = new ExchangeFees(191, POCKETBITS_ID, "UBQ", 0.1, 0.1, 0.01);


        ExchangeFees coinsecureBTCFees = new ExchangeFees(27, COINSECURE_ID, "BTC", 0.004, 0.004, 0.0001);

        ExchangeFees bitBnsBTCFees = new ExchangeFees(44, BITBNS_ID, "BTC", 0.0025, 0.0025, 0.0005);
        ExchangeFees bitBnsXRPFees = new ExchangeFees(45, BITBNS_ID, "XRP", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsNEOFees = new ExchangeFees(46, BITBNS_ID, "NEO", 0.0025, 0.0025, 0);
        ExchangeFees bitBnsETHFees = new ExchangeFees(47, BITBNS_ID, "ETH", 0.0025, 0.0025, 0.002);
        ExchangeFees bitBnsXLMFees = new ExchangeFees(48, BITBNS_ID, "XLM", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsGASFees = new ExchangeFees(94, BITBNS_ID, "GAS", 0.0025, 0.0025, 0);
        ExchangeFees bitBnsRPXFees = new ExchangeFees(95, BITBNS_ID, "RPX", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsDBCFees = new ExchangeFees(96, BITBNS_ID, "DBC", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsLTCFees = new ExchangeFees(97, BITBNS_ID, "LTC", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsXMRFees = new ExchangeFees(98, BITBNS_ID, "XMR", 0.0025, 0.0025, 0.02);
        ExchangeFees bitBnsSIAFees = new ExchangeFees(104, BITBNS_ID, "SC", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsDOGEFees = new ExchangeFees(105, BITBNS_ID, "DOGE", 0.0025, 0.0025, 2);
        ExchangeFees bitBnsBCHFees = new ExchangeFees(106, BITBNS_ID, "BCH", 0.0025, 0.0025, 0.001);
        ExchangeFees bitBnsDASHFees = new ExchangeFees(107, BITBNS_ID, "DASH", 0.0025, 0.0025, 0.02);
        ExchangeFees bitBnsTRXFees = new ExchangeFees(110, BITBNS_ID, "TRX", 0.0025, 0.0025, 5);
        ExchangeFees bitBnsETNFees = new ExchangeFees(135, BITBNS_ID, "ETN", 0.0025, 0.0025, 5);
        ExchangeFees bitBnsONTFees = new ExchangeFees(136, BITBNS_ID, "ONT", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsZILFees = new ExchangeFees(137, BITBNS_ID, "ZIL", 0.0025, 0.0025, 50);
        ExchangeFees bitBnsEOSFees = new ExchangeFees(142, BITBNS_ID, "EOS", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsPOLYFees = new ExchangeFees(143, BITBNS_ID, "POLY", 0.0025, 0.0025, 8);
        ExchangeFees bitBnsDGBFees = new ExchangeFees(144, BITBNS_ID, "DGB", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsNCASHFees = new ExchangeFees(145, BITBNS_ID, "NCASH", 0.0025, 0.0025, 200);
        ExchangeFees bitBnsADAFees = new ExchangeFees(148, BITBNS_ID, "ADA", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsICXFees = new ExchangeFees(149, BITBNS_ID, "ICX", 0.2, 0.2, 1.5);
        ExchangeFees bitBnsVENFees = new ExchangeFees(150, BITBNS_ID, "VEN", 0.2, 0.2, 1);
        ExchangeFees bitBnsOMGFees = new ExchangeFees(151, BITBNS_ID, "OMG", 0.0025, 0.0025, 0.4);
        ExchangeFees bitBnsREQFees = new ExchangeFees(152, BITBNS_ID, "REQ", 0.0025, 0.0025, 40);
        ExchangeFees bitBnsWAVESFees = new ExchangeFees(174, BITBNS_ID, "WAVES", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsWANFees = new ExchangeFees(175, BITBNS_ID, "WAN", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsACTFees = new ExchangeFees(201, BITBNS_ID, "ACT", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsDGDFees = new ExchangeFees(202, BITBNS_ID, "DGD", 0.0025, 0.0025, 0.04);
        ExchangeFees bitBnsPOWRFees = new ExchangeFees(203, BITBNS_ID, "POWR", 0.0025, 0.0025, 12);
        ExchangeFees bitBnsQLCFees = new ExchangeFees(204, BITBNS_ID, "QLC", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsWPRFees = new ExchangeFees(205, BITBNS_ID, "WPR", 0.0025, 0.0025, 60);
        ExchangeFees bitBnsXVGFees = new ExchangeFees(210, BITBNS_ID, "XVG", 0.0025, 0.0025, 2);
        ExchangeFees bitBnsBLZFees = new ExchangeFees(212, BITBNS_ID, "BLZ", 0.0025, 0.0025, 10);
        ExchangeFees bitBnsLRCFees = new ExchangeFees(213, BITBNS_ID, "LRC", 0.0025, 0.0025, 10);
        ExchangeFees bitBnsNEXOFees = new ExchangeFees(214, BITBNS_ID, "NEXO", 0.0025, 0.0025, 30);
        ExchangeFees bitBnsSUBFees = new ExchangeFees(215, BITBNS_ID, "SUB", 0.0025, 0.0025, 10);
        ExchangeFees bitBnsZRXFees = new ExchangeFees(228, BITBNS_ID, "ZRX", 0.0025, 0.0025, 3);
        ExchangeFees bitBnsCPXFees = new ExchangeFees(229, BITBNS_ID, "CPX", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsREPFees = new ExchangeFees(230, BITBNS_ID, "REP", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsEFXFees = new ExchangeFees(231, BITBNS_ID, "EFX", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsLOOMFees = new ExchangeFees(232, BITBNS_ID, "LOOM", 0.0025, 0.0025, 25);
        ExchangeFees bitBnsEOSDFees = new ExchangeFees(274, BITBNS_ID, "EOSD", 0.0025, 0.0025, 25);
        ExchangeFees bitBnsQKCFees = new ExchangeFees(275, BITBNS_ID, "QKC", 0.0025, 0.0025, 20);
        ExchangeFees bitBnsSTORMFees = new ExchangeFees(276, BITBNS_ID, "STORM", 0.0025, 0.0025, 150);
        ExchangeFees bitBnsQTUMFees = new ExchangeFees(277, BITBNS_ID, "QTUM", 0.0025, 0.0025, 0.01);
        ExchangeFees bitBnsGNTFees = new ExchangeFees(278, BITBNS_ID, "GNT", 0.0025, 0.0025, 8);
        ExchangeFees bitBnsXEMFees = new ExchangeFees(279, BITBNS_ID, "XEM", 0.0025, 0.0025, 1);
        ExchangeFees bitBnsLSKFees = new ExchangeFees(298, BITBNS_ID, "LSK", 0.0025, 0.0025, 0.3);
        ExchangeFees bitBnsETCFees = new ExchangeFees(299, BITBNS_ID, "ETC", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsNPXSFees = new ExchangeFees(300, BITBNS_ID, "NPXS", 0.0025, 0.0025, 600);
        ExchangeFees bitBnsUSDTFees = new ExchangeFees(301, BITBNS_ID, "USDT", 0.0025, 0.0025, 10);
        ExchangeFees bitBnsCLOAKFees = new ExchangeFees(312, BITBNS_ID, "CLOAK", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsDENTFees = new ExchangeFees(313, BITBNS_ID, "DENT", 0.0025, 0.0025, 750);
        ExchangeFees bitBnsGRSFees = new ExchangeFees(314, BITBNS_ID, "GRS", 0.0025, 0.0025, 0.1);
        ExchangeFees bitBnsKMDFees = new ExchangeFees(315, BITBNS_ID, "KMD", 0.0025, 0.0025, 0.1);

        ExchangeFees oxybitFees1 = new ExchangeFees(62, OXYBIT_ID, "BTC", 0.1, 0.1, 0.0005);
        ExchangeFees oxybitFees2 = new ExchangeFees(63, OXYBIT_ID, "ETH", 0.1, 0.1, 0.005);
        ExchangeFees oxybitFees3 = new ExchangeFees(64, OXYBIT_ID, "XRP", 0.1, 0.1, 0.5);
        ExchangeFees oxybitFees4 = new ExchangeFees(65, OXYBIT_ID, "LTC", 0.1, 0.1, 0.01);
        ExchangeFees oxybitFees5 = new ExchangeFees(66, OXYBIT_ID, "BCH", 0.1, 0.1, 0.001);
        ExchangeFees oxybitFees6 = new ExchangeFees(67, OXYBIT_ID, "XLM", 0.1, 0.1, 1);
        ExchangeFees oxybitFees7 = new ExchangeFees(68, OXYBIT_ID, "EOS", 0.1, 0.1, 0.1);
        ExchangeFees oxybitFees8 = new ExchangeFees(69, OXYBIT_ID, "DASH", 0.1, 0.1, 0.01);
        ExchangeFees oxybitFees9 = new ExchangeFees(70, OXYBIT_ID, "XMR", 0.1, 0.1, 0.06);
        ExchangeFees oxybitFees10 = new ExchangeFees(71, OXYBIT_ID, "TRX", 0.1, 0.1, 125);
        ExchangeFees oxybitFees11 = new ExchangeFees(72, OXYBIT_ID, "VET", 0.1, 0.1, 3);
        ExchangeFees oxybitFees12 = new ExchangeFees(73, OXYBIT_ID, "OMG", 0.1, 0.1, 1);
        ExchangeFees oxybitFees13 = new ExchangeFees(74, OXYBIT_ID, "NANO", 0.1, 0.1, 1);
        ExchangeFees oxybitFees14 = new ExchangeFees(75, OXYBIT_ID, "SNT", 0.1, 0.1, 30);
        ExchangeFees oxybitFees15 = new ExchangeFees(76, OXYBIT_ID, "REP", 0.1, 0.1, 0.1);
        ExchangeFees oxybitFees16 = new ExchangeFees(77, OXYBIT_ID, "ZRX", 0.1, 0.1, 18.1);
        ExchangeFees oxybitFees17 = new ExchangeFees(78, OXYBIT_ID, "BAT", 0.1, 0.1, 35);
        ExchangeFees oxybitFees18 = new ExchangeFees(79, OXYBIT_ID, "GNT", 0.1, 0.1, 35);
        ExchangeFees oxybitFees19 = new ExchangeFees(80, OXYBIT_ID, "KNC", 0.1, 0.1, 3);
        ExchangeFees oxybitFees20 = new ExchangeFees(81, OXYBIT_ID, "FUN", 0.1, 0.1, 120);
        ExchangeFees oxybitFees21 = new ExchangeFees(82, OXYBIT_ID, "SALT", 0.1, 0.1, 2);
        ExchangeFees oxybitFees22 = new ExchangeFees(83, OXYBIT_ID, "BNT", 0.1, 0.1, 3);
        ExchangeFees oxybitFees23 = new ExchangeFees(84, OXYBIT_ID, "REQ", 0.1, 0.1, 30);
        ExchangeFees oxybitFees24 = new ExchangeFees(85, OXYBIT_ID, "SAN", 0.1, 0.1, 3);
        ExchangeFees oxybitFees25 = new ExchangeFees(86, OXYBIT_ID, "GNO", 0.1, 0.1, 0.01);
        ExchangeFees oxybitFees26 = new ExchangeFees(87, OXYBIT_ID, "ICN", 0.1, 0.1, 3);
        ExchangeFees oxybitFees27 = new ExchangeFees(88, OXYBIT_ID, "POE", 0.1, 0.1, 120);
        ExchangeFees oxybitFees28 = new ExchangeFees(89, OXYBIT_ID, "CVC", 0.1, 0.1, 30);
        ExchangeFees oxybitFees29 = new ExchangeFees(90, OXYBIT_ID, "STORJ", 0.1, 0.1, 3);
        ExchangeFees oxybitFees30 = new ExchangeFees(91, OXYBIT_ID, "MCO", 0.1, 0.1, 1);
        ExchangeFees oxybitFees31 = new ExchangeFees(92, OXYBIT_ID, "ANT", 0.1, 0.1, 3);
        ExchangeFees oxybitFees32 = new ExchangeFees(102, OXYBIT_ID, "NEO", 0.1, 0.1, 0.01);
        ExchangeFees oxybitFees33 = new ExchangeFees(103, OXYBIT_ID, "GAS", 0.1, 0.1, 0.1);

        ExchangeFees coinslabFees = new ExchangeFees(108, COINSLAB_ID, "BTC", 0.0, 0.0, 0.0002);

        ExchangeFees unocoinFees1 = new ExchangeFees(157, UNOCOIN_ID, "BTC", 0.00708, 0.00708, 0.0002);
        ExchangeFees unocoinFees2 = new ExchangeFees(158, UNOCOIN_ID, "ETH", 0.00708, 0.00708, 0.01);
        ExchangeFees unocoinFees3 = new ExchangeFees(159, UNOCOIN_ID, "XRP", 0.00708, 0.00708, 0.15);
        ExchangeFees unocoinFees4 = new ExchangeFees(160, UNOCOIN_ID, "BCH", 0.00708, 0.00708, 0.0001);
        ExchangeFees unocoinFees5 = new ExchangeFees(161, UNOCOIN_ID, "LTC", 0.00708, 0.00708, 0.02);
        ExchangeFees unocoinFees6 = new ExchangeFees(162, UNOCOIN_ID, "BTG", 0.00708, 0.00708, 0.001);
        ExchangeFees unocoinFees7 = new ExchangeFees(219, UNOCOIN_ID, "BAT", 0.00708, 0.00708, 2);
        ExchangeFees unocoinFees8 = new ExchangeFees(220, UNOCOIN_ID, "BRD", 0.00708, 0.00708, 5);
        ExchangeFees unocoinFees9 = new ExchangeFees(221, UNOCOIN_ID, "FUN", 0.00708, 0.00708, 50);
        ExchangeFees unocoinFees10 = new ExchangeFees(222, UNOCOIN_ID, "GNT", 0.00708, 0.00708, 5);
        ExchangeFees unocoinFees11 = new ExchangeFees(223, UNOCOIN_ID, "ZIL", 0.00708, 0.00708, 50);
        ExchangeFees unocoinFees12 = new ExchangeFees(233, UNOCOIN_ID, "CVC", 0.00708, 0.00708, 5);
        ExchangeFees unocoinFees13 = new ExchangeFees(234, UNOCOIN_ID, "REP", 0.00708, 0.00708, 0.1);
        ExchangeFees unocoinFees14 = new ExchangeFees(235, UNOCOIN_ID, "ZRX", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees15 = new ExchangeFees(317, UNOCOIN_ID, "OMG", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees16 = new ExchangeFees(318, UNOCOIN_ID, "KNC", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees17 = new ExchangeFees(319, UNOCOIN_ID, "RDN", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees18 = new ExchangeFees(320, UNOCOIN_ID, "NMR", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees19 = new ExchangeFees(321, UNOCOIN_ID, "PAY", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees20 = new ExchangeFees(322, UNOCOIN_ID, "QRL", 0.00708, 0.00708, 1);
        ExchangeFees unocoinFees21 = new ExchangeFees(323, UNOCOIN_ID, "WAX", 0.00708, 0.00708, 1);

        ExchangeFees wazirxFees1 = new ExchangeFees(176, WAZIRX_ID, "BTC", 0.00295, 0.00295, 0.0005);
        ExchangeFees wazirxFees2 = new ExchangeFees(177, WAZIRX_ID, "XRP", 0.00295, 0.00295, 0.02);
        ExchangeFees wazirxFees3 = new ExchangeFees(178, WAZIRX_ID, "ETH", 0.00295, 0.00295, 0.003);
        ExchangeFees wazirxFees4 = new ExchangeFees(179, WAZIRX_ID, "TRX", 0.00295, 0.00295, 60);
        ExchangeFees wazirxFees5 = new ExchangeFees(180, WAZIRX_ID, "LTC", 0.00295, 0.00295, 0.01);
        ExchangeFees wazirxFees6 = new ExchangeFees(181, WAZIRX_ID, "DASH", 0.00295, 0.00295, 0.001);
        ExchangeFees wazirxFees7 = new ExchangeFees(182, WAZIRX_ID, "BCH", 0.00295, 0.00295, 0.001);
        ExchangeFees wazirxFees8 = new ExchangeFees(192, WAZIRX_ID, "EOS", 0.1, 0.1, 0.39);
        ExchangeFees wazirxFees9 = new ExchangeFees(193, WAZIRX_ID, "ZIL", 0.00295, 0.00295, 50);
        ExchangeFees wazirxFees10 = new ExchangeFees(198, WAZIRX_ID, "NCASH", 0.00295, 0.00295, 60);
        ExchangeFees wazirxFees11 = new ExchangeFees(200, WAZIRX_ID, "BAT", 0.00295, 0.00295, 10);
        ExchangeFees wazirxFees12 = new ExchangeFees(207, WAZIRX_ID, "GNT", 0.00295, 0.00295, 10);
        ExchangeFees wazirxFees13 = new ExchangeFees(211, WAZIRX_ID, "ZRX", 0.00295, 0.00295, 5);
        ExchangeFees wazirxFees14 = new ExchangeFees(216, WAZIRX_ID, "STORM", 0.00295, 0.00295, 60);
        ExchangeFees wazirxFees15 = new ExchangeFees(217, WAZIRX_ID, "SUB", 0.00295, 0.00295, 5);
        ExchangeFees wazirxFees16 = new ExchangeFees(218, WAZIRX_ID, "NULS", 0.00295, 0.00295, 0.5);
        ExchangeFees wazirxFees17 = new ExchangeFees(224, WAZIRX_ID, "REQ", 0.00295, 0.00295, 10);
        ExchangeFees wazirxFees18 = new ExchangeFees(225, WAZIRX_ID, "ICX", 0.1, 0.1, 0.5);
        ExchangeFees wazirxFees19 = new ExchangeFees(226, WAZIRX_ID, "OMG", 0.00295, 0.00295, 0.1);
        ExchangeFees wazirxFees20 = new ExchangeFees(237, WAZIRX_ID, "POLY", 0.00295, 0.00295, 5);
        ExchangeFees wazirxFees21 = new ExchangeFees(239, WAZIRX_ID, "IOST", 0.00295, 0.00295, 60);
        ExchangeFees wazirxFees22 = new ExchangeFees(240, WAZIRX_ID, "NPXS", 0.00295, 0.00295, 300);
        ExchangeFees wazirxFees23 = new ExchangeFees(261, WAZIRX_ID, "NOAH", 0.00295, 0.00295, 850);
        ExchangeFees wazirxFees24 = new ExchangeFees(262, WAZIRX_ID, "BANCA", 0.00295, 0.00295, 2000);
        ExchangeFees wazirxFees25 = new ExchangeFees(263, WAZIRX_ID, "FUN", 0.00295, 0.00295, 200);
        ExchangeFees wazirxFees26 = new ExchangeFees(264, WAZIRX_ID, "HOT", 0.00295, 0.00295, 7000);
        ExchangeFees wazirxFees27 = new ExchangeFees(265, WAZIRX_ID, "OCN", 0.00295, 0.00295, 400);
        ExchangeFees wazirxFees28 = new ExchangeFees(266, WAZIRX_ID, "POE", 0.00295, 0.00295, 250);
        ExchangeFees wazirxFees29 = new ExchangeFees(267, WAZIRX_ID, "STQ", 0.00295, 0.00295, 700);
        ExchangeFees wazirxFees30 = new ExchangeFees(268, WAZIRX_ID, "ZCO", 0.00295, 0.00295, 50);
        ExchangeFees wazirxFees31 = new ExchangeFees(269, WAZIRX_ID, "QKC", 0.00295, 0.00295, 30);
        ExchangeFees wazirxFees32 = new ExchangeFees(270, WAZIRX_ID, "THETA", 0.00295, 0.00295, 30);
        ExchangeFees wazirxFees33 = new ExchangeFees(271, WAZIRX_ID, "DENT", 0.00295, 0.00295, 750);
        ExchangeFees wazirxFees34 = new ExchangeFees(272, WAZIRX_ID, "SNT", 0.00295, 0.00295, 10);
        ExchangeFees wazirxFees35 = new ExchangeFees(273, WAZIRX_ID, "CS", 0.00295, 0.00295, 10);

        ExchangeFees koinok1 = new ExchangeFees(243, KOINOK_ID, "BTC", 0.1, 0.001, 0.0005);
        ExchangeFees koinok2 = new ExchangeFees(244, KOINOK_ID, "CAS", 0.1, 0.001, 50);
        ExchangeFees koinok3 = new ExchangeFees(245, KOINOK_ID, "CVC", 0.1, 0.001, 5);
        ExchangeFees koinok4 = new ExchangeFees(246, KOINOK_ID, "ETH", 0.1, 0.001, 0.003);
        ExchangeFees koinok5 = new ExchangeFees(247, KOINOK_ID, "GAS", 0.1, 0.001, 0.001);
        ExchangeFees koinok6 = new ExchangeFees(248, KOINOK_ID, "ICX", 0.1, 0.001, 0.5);
        ExchangeFees koinok7 = new ExchangeFees(249, KOINOK_ID, "NEO", 0.1, 0.001, 0);
        ExchangeFees koinok8 = new ExchangeFees(250, KOINOK_ID, "OMG", 0.1, 0.001, 0.2);
        ExchangeFees koinok9 = new ExchangeFees(251, KOINOK_ID, "RDD", 0.1, 0.001, 5);
        ExchangeFees koinok10 = new ExchangeFees(252, KOINOK_ID, "TRX", 0.1, 0.1, 50);
        ExchangeFees koinok11 = new ExchangeFees(253, KOINOK_ID, "VEN", 0.1, 0.001, 0.5);
        ExchangeFees koinok12 = new ExchangeFees(254, KOINOK_ID, "VIB", 0.1, 0.001, 10);
        ExchangeFees koinok13 = new ExchangeFees(255, KOINOK_ID, "XDCE", 0.1, 0.001, 50);
        ExchangeFees koinok14 = new ExchangeFees(256, KOINOK_ID, "XRP", 0.1, 0.001, 0.1);
        ExchangeFees koinok15 = new ExchangeFees(257, KOINOK_ID, "ZIL", 0.1, 0.001, 15);
        ExchangeFees koinok16 = new ExchangeFees(258, KOINOK_ID, "ZRX", 0.1, 0.001, 1);
        ExchangeFees koinok17 = new ExchangeFees(307, KOINOK_ID, "GRS", 0.1, 0.001, 0.2);
        ExchangeFees koinok18 = new ExchangeFees(308, KOINOK_ID, "KEY", 0.1, 0.001, 100);
        ExchangeFees koinok19 = new ExchangeFees(309, KOINOK_ID, "LWF", 0.1, 0.001, 0.5);

        ExchangeFees giottus1 = new ExchangeFees(302, GIOTTUS_ID, "BTC", 0.0025, 0.0025, 0.0001);
        ExchangeFees giottus2 = new ExchangeFees(303, GIOTTUS_ID, "BCH", 0.0025, 0.0025, 0.001);
        ExchangeFees giottus3 = new ExchangeFees(304, GIOTTUS_ID, "XRP", 0.0025, 0.0025, 0.02);
        ExchangeFees giottus4 = new ExchangeFees(305, GIOTTUS_ID, "LTC", 0.0025, 0.0025, 0.001);
        ExchangeFees giottus5 = new ExchangeFees(306, GIOTTUS_ID, "ETH", 0.0025, 0.0025, 0.003);

        List<ExchangeFees> exchangeFees = Arrays.asList(koinexETHFees, koinexBTCFees, koinexBCHFees, koinexLTCFees, koinexXRPFees, throughbitETHFees, throughbitBTCFees, zebpayBTCFees, coinomeBTCFees, zebpayLTCFees, zebpayXRPFees, coinomeBCHFees, coinomeLTCFees, buyUcoinETHFees, buyUcoinBTCFees, buyUcoinBCHFees, buyUcoinLTCFees, buyUcoinXRPFees, coindeltaETHFees, coindeltaBTCFees, coindeltaBCHFees, coindeltaLTCFees, coindeltaXRPFees, pocketBitsETHFees, pocketBitsBTCFees, pocketBitsBCHFees, pocketBitsLTCFees, pocketBitsXRPFees, pocketBitsBTGFees, pocketBitsDGBFees, pocketBitsXLMFees, pocketBitsSCFees, pocketBitsXVGFees, pocketBitsVOXFees, coinsecureBTCFees, zebpayBCHFees, coinomeDASHFees, buyUcoinDASHFees, buyUcoinNEOFees, buyUcoinETCFees, buyUcoinQTUMFees, buyUcoinXMRFees, buyUcoinZECFees, buyUcoinOMGFees, coindeltaOMGFees, coindeltaQTUMFees, pocketBitsDASHFees, pocketBitsETCFees, pocketBitsXMRFees, pocketBitsNEOFees, pocketBitsOMGFees, pocketBitsZECFees, bitBnsBTCFees, bitBnsXRPFees, bitBnsNEOFees, bitBnsETHFees, bitBnsXLMFees, coinomeDGBFees, koinexOMGFees, koinexREQFees, zebpayETHFees, coinomeZECFees, oxybitFees1, oxybitFees2, oxybitFees3, oxybitFees4, oxybitFees5, oxybitFees6, oxybitFees7, oxybitFees8, oxybitFees9, oxybitFees10, oxybitFees11, oxybitFees12, oxybitFees13, oxybitFees14, oxybitFees15, oxybitFees16, oxybitFees17, oxybitFees18, oxybitFees19, oxybitFees20, oxybitFees21, oxybitFees22, oxybitFees23, oxybitFees24, oxybitFees25, oxybitFees26, oxybitFees27, oxybitFees28, oxybitFees29, oxybitFees30, oxybitFees31, koinexZRXFees, bitBnsGASFees, bitBnsRPXFees, bitBnsDBCFees, bitBnsLTCFees, bitBnsXMRFees, koinexAEFees, koinexBATFees, koinexGNTFees, oxybitFees32, oxybitFees33, bitBnsSIAFees, bitBnsDOGEFees, bitBnsBCHFees, bitBnsDASHFees, pocketBitsTRXFees, coinslabFees, bitBnsTRXFees, koinexTRXFees, coinomeQTUMFees, koinexXLMFees, koinexNEOFees, koinexGASFees, coindeltaZILFees, coindeltaZRXFees, buyUcoinNEMFees, buyUcoinGNTFees, buyUcoinSTRATFees, buyUcoinSTEEMFees, buyUcoinREPFees, buyUcoinLSKFees, buyUcoinFCTFees, buyUcoinCVCFees, buyUcoinSCFees, buyUcoinPAYFees, buyUcoinDOGEFees, buyUcoinDGBFees, buyUcoinNXTFees, buyUcoinBATFees, buyUcoinBTSFees, buyUcoinCLOAKFees, buyUcoinPIVXFees, buyUcoinDCNFees, bitBnsETNFees, bitBnsONTFees, bitBnsZILFees, koinexAIONFees, koinexNCASHFees, coindeltaKNCFees, coindeltaEOSFees, bitBnsEOSFees, bitBnsPOLYFees, bitBnsDGBFees, bitBnsNCASHFees, koinexEOSFees, koinexNANOFees, bitBnsADAFees, bitBnsICXFees, bitBnsVENFees, bitBnsOMGFees, bitBnsREQFees, coindeltaZECFees, coindeltaNEOFees, coindeltaGASFees, coinomeBTGFees, unocoinFees1, unocoinFees2, unocoinFees3, unocoinFees4, unocoinFees5, unocoinFees6, coindeltaAIONFees, coindeltaBATFees, coindeltaCNDFees, coindeltaCVCFees, coindeltaMANAFees, coindeltaENGFees, coindeltaGNTFees, coindeltaICXFees, coindeltaSPANKFees, coindeltaTRXFees, bitBnsWAVESFees, bitBnsWANFees, wazirxFees1, wazirxFees2, wazirxFees3, wazirxFees4, wazirxFees5, wazirxFees6, wazirxFees7, pocketBitsZRXFees, pocketBitsREPFees, pocketBitsBATFees, pocketBitsQTUMFees, pocketBitsADAFees, pocketBitsDOGEFees, pocketBitsGNTFees, pocketBitsSTORJFees, pocketBitsUBQFees, wazirxFees8, wazirxFees9, zebpayEOSFees, zebpayOMGFees, koinexONTFees, koinexZILFees, wazirxFees10, zebpayTRXFees, wazirxFees11, bitBnsACTFees, bitBnsDGDFees, bitBnsPOWRFees, bitBnsQLCFees, bitBnsWPRFees, koinexIOSTFees, wazirxFees12, koinexZCOFees, koinexPOLYFees, bitBnsXVGFees, wazirxFees13, bitBnsBLZFees, bitBnsLRCFees, bitBnsNEXOFees, bitBnsSUBFees, wazirxFees14, wazirxFees15, wazirxFees16, wazirxFees17, wazirxFees18, wazirxFees19, unocoinFees7, unocoinFees8, unocoinFees9, unocoinFees10, unocoinFees11, koinexAELFFees, bitBnsZRXFees, bitBnsCPXFees, bitBnsREPFees, bitBnsEFXFees, bitBnsLOOMFees, unocoinFees12, unocoinFees13, unocoinFees14, coindeltaACTFees, wazirxFees20, koinexCMTFees, wazirxFees21, wazirxFees22, coindeltaDAIFees, coinomeXRPFees, koinok1, koinok2, koinok3, koinok4, koinok5, koinok6, koinok7, koinok8, koinok9, koinok10, koinok11, koinok12, koinok13, koinok14, koinok15, koinok16, koinexACTFees, coinomeETHFees, wazirxFees23, wazirxFees24, wazirxFees25, wazirxFees26, wazirxFees27, wazirxFees28, wazirxFees29, wazirxFees30, wazirxFees31, wazirxFees32, wazirxFees33, wazirxFees34, wazirxFees35, bitBnsEOSDFees, bitBnsQKCFees, bitBnsSTORMFees, bitBnsQTUMFees, bitBnsGNTFees, bitBnsXEMFees, koinexSNTFees, coindeltaQKCFees, coindeltaKRMFees, zebpayZILFees, zebpayREPFees, zebpayZRXFees, zebpayKNCFees, zebpayGNTFees, zebpayBATFees, zebpayVENFees, zebpayAEFees, zebpayIOSTFees, zebpayCMTFees, koinexREPFees, coindeltaAEFees, koinexQKCFees, coindeltaTENFees, bitBnsLSKFees, bitBnsETCFees, bitBnsNPXSFees, bitBnsUSDTFees, koinexXZCFees, giottus1, giottus2, giottus3, giottus4, giottus5, koinok17, koinok18, koinok19, bitBnsCLOAKFees, bitBnsDENTFees, bitBnsGRSFees, bitBnsKMDFees, coindeltaSTXFees, coindeltaHSTFees, zebpayNCASHFees, unocoinFees15, unocoinFees16, unocoinFees17, unocoinFees18, unocoinFees19, unocoinFees20, unocoinFees21, koinexUSDTFees, zebpayTUSDFees);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchangeFees(exchangeFees));
    }
}
