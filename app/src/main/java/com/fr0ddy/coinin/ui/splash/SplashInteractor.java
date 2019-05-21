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
import static com.fr0ddy.coinin.utils.AppConstants.COINDCX_ID;
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
        Exchange coinDCX = new Exchange(COINDCX_ID, "CoinDCX", "IND");

        List<Exchange> exchanges = Arrays.asList(koinex, throughbit, zebpay, coinome, buyUcoin, coindelta, pocketBits, coinsecure, bitbns, oxybit, coinslab, unocoin, wazirX, koinOk, giottus, coinDCX);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchanges(exchanges));
    }


    @Override
    public Observable<List<Long>> saveDefaultExchangeFees() {

        ExchangeFees koinexETHFees = new ExchangeFees(1, KOINEX_ID, "ETH", 0.05, 0.0015, 0.003);
        ExchangeFees koinexBTCFees = new ExchangeFees(2, KOINEX_ID, "BTC", 0.05, 0.0015, 0.0004);
        ExchangeFees koinexBCHFees = new ExchangeFees(3, KOINEX_ID, "BCH", 1, 1, 1);
        ExchangeFees koinexLTCFees = new ExchangeFees(4, KOINEX_ID, "LTC", 0.05, 0.0015, 0.01);
        ExchangeFees koinexXRPFees = new ExchangeFees(5, KOINEX_ID, "XRP", 0.05, 0.0015, 0.25);
        ExchangeFees koinexOMGFees = new ExchangeFees(58, KOINEX_ID, "OMG", 0.05, 0.0015, 0.25);
        ExchangeFees koinexREQFees = new ExchangeFees(59, KOINEX_ID, "REQ", 0.05, 0.0015, 25);
        ExchangeFees koinexZRXFees = new ExchangeFees(93, KOINEX_ID, "ZRX", 0.05, 0.0015, 2);
        ExchangeFees koinexAEFees = new ExchangeFees(99, KOINEX_ID, "AE", 0.05, 0.0015, 1.5);
        ExchangeFees koinexBATFees = new ExchangeFees(100, KOINEX_ID, "BAT", 0.05, 0.0015, 10);
        ExchangeFees koinexGNTFees = new ExchangeFees(101, KOINEX_ID, "GNT", 0.05, 0.0015, 7.5);
        ExchangeFees koinexTRXFees = new ExchangeFees(111, KOINEX_ID, "TRX", 0.05, 0.0015, 5);
        ExchangeFees koinexXLMFees = new ExchangeFees(113, KOINEX_ID, "XLM", 0.05, 0.0015, 0.02);
        ExchangeFees koinexNEOFees = new ExchangeFees(114, KOINEX_ID, "NEO", 0.05, 0.0015, 0);
        ExchangeFees koinexGASFees = new ExchangeFees(115, KOINEX_ID, "GAS", 0.05, 0.0015, 0);
        ExchangeFees koinexAIONFees = new ExchangeFees(138, KOINEX_ID, "AION", 0.05, 0.0015, 2.5);
        ExchangeFees koinexNCASHFees = new ExchangeFees(139, KOINEX_ID, "NCASH", 0.05, 0.0015, 200);
        ExchangeFees koinexEOSFees = new ExchangeFees(146, KOINEX_ID, "EOS", 0.05, 0.0015, 0.1);
        ExchangeFees koinexNANOFees = new ExchangeFees(147, KOINEX_ID, "NANO", 0.05, 0.0015, 0.05);
        ExchangeFees koinexONTFees = new ExchangeFees(196, KOINEX_ID, "ONT", 0.05, 0.0015, 1);
        ExchangeFees koinexZILFees = new ExchangeFees(197, KOINEX_ID, "ZIL", 0.05, 0.0015, 35);
        ExchangeFees koinexIOSTFees = new ExchangeFees(206, KOINEX_ID, "IOST", 0.05, 0.0015, 100);
        ExchangeFees koinexZCOFees = new ExchangeFees(208, KOINEX_ID, "ZCO", 0.05, 0.0015, 100);
        ExchangeFees koinexPOLYFees = new ExchangeFees(209, KOINEX_ID, "POLY", 0.05, 0.0015, 8);
        ExchangeFees koinexAELFFees = new ExchangeFees(227, KOINEX_ID, "AELF", 0.05, 0.0015, 2.5);
        ExchangeFees koinexCMTFees = new ExchangeFees(238, KOINEX_ID, "CMT", 0.05, 0.0015, 1);
        ExchangeFees koinexACTFees = new ExchangeFees(259, KOINEX_ID, "ACT", 0.05, 0.0015, 0.2);
        ExchangeFees koinexSNTFees = new ExchangeFees(280, KOINEX_ID, "SNT", 0.05, 0.0015, 50);
        ExchangeFees koinexREPFees = new ExchangeFees(293, KOINEX_ID, "REP", 0.05, 0.0015, 0.2);
        ExchangeFees koinexQKCFees = new ExchangeFees(295, KOINEX_ID, "QKC", 0.05, 0.0015, 25);
        ExchangeFees koinexXZCFees = new ExchangeFees(297, KOINEX_ID, "XZC", 0.05, 0.0015, 0.02);
        ExchangeFees koinexTUSDFees = new ExchangeFees(324, KOINEX_ID, "TUSD", 0.05, 0.0015, 2);
        ExchangeFees koinexUSDTFees = new ExchangeFees(327, KOINEX_ID, "USDT", 0.05, 0.0015, 5);
        ExchangeFees koinexBCHABCFees = new ExchangeFees(328, KOINEX_ID, "BCHABC", 0.05, 0.0015, 0.001);
        ExchangeFees koinexBCHSVFees = new ExchangeFees(329, KOINEX_ID, "BCHSV", 0.05, 0.0015, 0.001);
        ExchangeFees koinexBTTFees = new ExchangeFees(330, KOINEX_ID, "BTT", 0.05, 0.0015, 100);
        ExchangeFees koinexMANAFees = new ExchangeFees(342, KOINEX_ID, "MANA", 0.05, 0.0015, 30);

        ExchangeFees throughbitETHFees = new ExchangeFees(6, THROUGHBIT_ID, "ETH", 0.1/*0.00885*/, 0.1, 0.002);
        ExchangeFees throughbitBTCFees = new ExchangeFees(7, THROUGHBIT_ID, "BTC", 0.1, 0.1, 0.00005);

        ExchangeFees pocketBitsETHFees = new ExchangeFees(22, POCKETBITS_ID, "ETH", 0.1, 0.1, 0.002);
        ExchangeFees pocketBitsBTCFees = new ExchangeFees(23, POCKETBITS_ID, "BTC", 0.1, 0.0, 0.0003);
        ExchangeFees pocketBitsBCHFees = new ExchangeFees(24, POCKETBITS_ID, "BCH", 1, 1, 1);
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


        ExchangeFees bitBnsBTCFees = new ExchangeFees(44, BITBNS_ID, "BTC", 0.0025, 0.05, 0.0005);
        ExchangeFees bitBnsXRPFees = new ExchangeFees(45, BITBNS_ID, "XRP", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsNEOFees = new ExchangeFees(46, BITBNS_ID, "NEO", 0.0025, 0.05, 0);
        ExchangeFees bitBnsETHFees = new ExchangeFees(47, BITBNS_ID, "ETH", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsXLMFees = new ExchangeFees(48, BITBNS_ID, "XLM", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsGASFees = new ExchangeFees(94, BITBNS_ID, "GAS", 0.0025, 0.05, 0);
        ExchangeFees bitBnsRPXFees = new ExchangeFees(95, BITBNS_ID, "RPX", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsDBCFees = new ExchangeFees(96, BITBNS_ID, "DBC", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsLTCFees = new ExchangeFees(97, BITBNS_ID, "LTC", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsXMRFees = new ExchangeFees(98, BITBNS_ID, "XMR", 0.0025, 0.05, 0.02);
        ExchangeFees bitBnsSIAFees = new ExchangeFees(104, BITBNS_ID, "SC", 0.0025, 0.05, 1);
        ExchangeFees bitBnsDOGEFees = new ExchangeFees(105, BITBNS_ID, "DOGE", 0.0025, 0.05, 2);
        ExchangeFees bitBnsBCHFees = new ExchangeFees(106, BITBNS_ID, "BCH", 1, 1, 1);
        ExchangeFees bitBnsDASHFees = new ExchangeFees(107, BITBNS_ID, "DASH", 0.0025, 0.05, 0.02);
        ExchangeFees bitBnsTRXFees = new ExchangeFees(110, BITBNS_ID, "TRX", 0.0025, 0.05, 5);
        ExchangeFees bitBnsETNFees = new ExchangeFees(135, BITBNS_ID, "ETN", 0.0025, 0.05, 5);
        ExchangeFees bitBnsONTFees = new ExchangeFees(136, BITBNS_ID, "ONT", 0.0025, 0.05, 1);
        ExchangeFees bitBnsZILFees = new ExchangeFees(137, BITBNS_ID, "ZIL", 0.0025, 0.05, 50);
        ExchangeFees bitBnsEOSFees = new ExchangeFees(142, BITBNS_ID, "EOS", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsPOLYFees = new ExchangeFees(143, BITBNS_ID, "POLY", 0.0025, 0.05, 8);
        ExchangeFees bitBnsDGBFees = new ExchangeFees(144, BITBNS_ID, "DGB", 0.0025, 0.05, 1);
        ExchangeFees bitBnsNCASHFees = new ExchangeFees(145, BITBNS_ID, "NCASH", 0.0025, 0.05, 200);
        ExchangeFees bitBnsADAFees = new ExchangeFees(148, BITBNS_ID, "ADA", 0.0025, 0.05, 1);
        ExchangeFees bitBnsICXFees = new ExchangeFees(149, BITBNS_ID, "ICX", 0.2, 0.05, 0.1);
        ExchangeFees bitBnsVENFees = new ExchangeFees(150, BITBNS_ID, "VEN", 0.2, 0.05, 1);
        ExchangeFees bitBnsOMGFees = new ExchangeFees(151, BITBNS_ID, "OMG", 0.0025, 0.05, 0.4);
        ExchangeFees bitBnsREQFees = new ExchangeFees(152, BITBNS_ID, "REQ", 0.0025, 0.05, 40);
        ExchangeFees bitBnsWAVESFees = new ExchangeFees(174, BITBNS_ID, "WAVES", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsWANFees = new ExchangeFees(175, BITBNS_ID, "WAN", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsACTFees = new ExchangeFees(201, BITBNS_ID, "ACT", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsDGDFees = new ExchangeFees(202, BITBNS_ID, "DGD", 0.0025, 0.05, 0.04);
        ExchangeFees bitBnsPOWRFees = new ExchangeFees(203, BITBNS_ID, "POWR", 0.0025, 0.05, 12);
        ExchangeFees bitBnsQLCFees = new ExchangeFees(204, BITBNS_ID, "QLC", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsWPRFees = new ExchangeFees(205, BITBNS_ID, "WPR", 0.0025, 0.05, 60);
        ExchangeFees bitBnsXVGFees = new ExchangeFees(210, BITBNS_ID, "XVG", 0.0025, 0.05, 2);
        ExchangeFees bitBnsBLZFees = new ExchangeFees(212, BITBNS_ID, "BLZ", 0.0025, 0.05, 10);
        ExchangeFees bitBnsLRCFees = new ExchangeFees(213, BITBNS_ID, "LRC", 0.0025, 0.05, 10);
        ExchangeFees bitBnsNEXOFees = new ExchangeFees(214, BITBNS_ID, "NEXO", 0.0025, 0.05, 30);
        ExchangeFees bitBnsSUBFees = new ExchangeFees(215, BITBNS_ID, "SUB", 0.0025, 0.05, 10);
        ExchangeFees bitBnsZRXFees = new ExchangeFees(228, BITBNS_ID, "ZRX", 0.0025, 0.05, 3);
        ExchangeFees bitBnsCPXFees = new ExchangeFees(229, BITBNS_ID, "CPX", 0.0025, 0.05, 1);
        ExchangeFees bitBnsREPFees = new ExchangeFees(230, BITBNS_ID, "REP", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsEFXFees = new ExchangeFees(231, BITBNS_ID, "EFX", 0.0025, 0.05, 1);
        ExchangeFees bitBnsLOOMFees = new ExchangeFees(232, BITBNS_ID, "LOOM", 0.0025, 0.05, 25);
        ExchangeFees bitBnsEOSDFees = new ExchangeFees(274, BITBNS_ID, "EOSD", 0.0025, 0.05, 1);
        ExchangeFees bitBnsQKCFees = new ExchangeFees(275, BITBNS_ID, "QKC", 0.0025, 0.05, 20);
        ExchangeFees bitBnsSTORMFees = new ExchangeFees(276, BITBNS_ID, "STORM", 0.0025, 0.05, 150);
        ExchangeFees bitBnsQTUMFees = new ExchangeFees(277, BITBNS_ID, "QTUM", 0.0025, 0.05, 0.01);
        ExchangeFees bitBnsGNTFees = new ExchangeFees(278, BITBNS_ID, "GNT", 0.0025, 0.05, 8);
        ExchangeFees bitBnsXEMFees = new ExchangeFees(279, BITBNS_ID, "XEM", 0.0025, 0.05, 1);
        ExchangeFees bitBnsLSKFees = new ExchangeFees(298, BITBNS_ID, "LSK", 0.0025, 0.05, 0.3);
        ExchangeFees bitBnsETCFees = new ExchangeFees(299, BITBNS_ID, "ETC", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsNPXSFees = new ExchangeFees(300, BITBNS_ID, "NPXS", 0.0025, 0.05, 600);
        ExchangeFees bitBnsUSDTFees = new ExchangeFees(301, BITBNS_ID, "USDT", 0.0025, 0.05, 5);
        ExchangeFees bitBnsCLOAKFees = new ExchangeFees(312, BITBNS_ID, "CLOAK", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsDENTFees = new ExchangeFees(313, BITBNS_ID, "DENT", 0.0025, 0.05, 750);
        ExchangeFees bitBnsGRSFees = new ExchangeFees(314, BITBNS_ID, "GRS", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsKMDFees = new ExchangeFees(315, BITBNS_ID, "KMD", 0.0025, 0.05, 0.1);
        ExchangeFees bitBnsBCHABCFees = new ExchangeFees(339, BITBNS_ID, "BCHABC", 0.0025, 0.05, 0.001);
        ExchangeFees bitBnsBCHSVFees = new ExchangeFees(340, BITBNS_ID, "BCHSV", 0.0025, 0.05, 0.001);
        ExchangeFees bitBnsBTTFees = new ExchangeFees(341, BITBNS_ID, "BTT", 0.0025, 0.05, 100);

        ExchangeFees unocoinFees1 = new ExchangeFees(157, UNOCOIN_ID, "BTC", 0.00708, 0.1/*0.00708*/, 0.0002);
        ExchangeFees unocoinFees2 = new ExchangeFees(158, UNOCOIN_ID, "ETH", 0.00708, 0.1, 0.01);
        ExchangeFees unocoinFees3 = new ExchangeFees(159, UNOCOIN_ID, "XRP", 0.00708, 0.1, 0.15);
        ExchangeFees unocoinFees4 = new ExchangeFees(160, UNOCOIN_ID, "BCH", 1, 1, 1);
        ExchangeFees unocoinFees5 = new ExchangeFees(161, UNOCOIN_ID, "LTC", 0.00708, 0.1, 0.02);
        ExchangeFees unocoinFees6 = new ExchangeFees(162, UNOCOIN_ID, "BTG", 0.00708, 0.1, 0.001);
        ExchangeFees unocoinFees7 = new ExchangeFees(219, UNOCOIN_ID, "BAT", 0.00708, 0.1, 2);
        ExchangeFees unocoinFees8 = new ExchangeFees(220, UNOCOIN_ID, "BRD", 0.00708, 0.1, 5);
        ExchangeFees unocoinFees9 = new ExchangeFees(221, UNOCOIN_ID, "FUN", 0.00708, 0.1, 50);
        ExchangeFees unocoinFees10 = new ExchangeFees(222, UNOCOIN_ID, "GNT", 0.00708, 0.1, 5);
        ExchangeFees unocoinFees11 = new ExchangeFees(223, UNOCOIN_ID, "ZIL", 0.00708, 0.1, 50);
        ExchangeFees unocoinFees12 = new ExchangeFees(233, UNOCOIN_ID, "CVC", 0.00708, 0.1, 5);
        ExchangeFees unocoinFees13 = new ExchangeFees(234, UNOCOIN_ID, "REP", 0.00708, 0.1, 0.1);
        ExchangeFees unocoinFees14 = new ExchangeFees(235, UNOCOIN_ID, "ZRX", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees15 = new ExchangeFees(317, UNOCOIN_ID, "OMG", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees16 = new ExchangeFees(318, UNOCOIN_ID, "KNC", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees17 = new ExchangeFees(319, UNOCOIN_ID, "RDN", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees18 = new ExchangeFees(320, UNOCOIN_ID, "NMR", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees19 = new ExchangeFees(321, UNOCOIN_ID, "PAY", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees20 = new ExchangeFees(322, UNOCOIN_ID, "QRL", 0.00708, 0.1, 1);
        ExchangeFees unocoinFees21 = new ExchangeFees(323, UNOCOIN_ID, "WAX", 0.00708, 0.1, 1);

        ExchangeFees wazirxFees1 = new ExchangeFees(176, WAZIRX_ID, "BTC", 0.00295, 0.00295, 0.0005);
        ExchangeFees wazirxFees2 = new ExchangeFees(177, WAZIRX_ID, "XRP", 0.00295, 0.00295, 0.02);
        ExchangeFees wazirxFees3 = new ExchangeFees(178, WAZIRX_ID, "ETH", 0.00295, 0.00295, 0.003);
        ExchangeFees wazirxFees4 = new ExchangeFees(179, WAZIRX_ID, "TRX", 0.00295, 0.00295, 60);
        ExchangeFees wazirxFees5 = new ExchangeFees(180, WAZIRX_ID, "LTC", 0.00295, 0.00295, 0.01);
        ExchangeFees wazirxFees6 = new ExchangeFees(181, WAZIRX_ID, "DASH", 0.00295, 0.00295, 0.001);
        ExchangeFees wazirxFees7 = new ExchangeFees(182, WAZIRX_ID, "BCH", 1, 1, 1);
        ExchangeFees wazirxFees8 = new ExchangeFees(192, WAZIRX_ID, "EOS", 1, 1, 0.39);
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

        ExchangeFees coinDCXFees1 = new ExchangeFees(343, COINDCX_ID, "BTC", 0.001, 0.001, 0.0003);
        ExchangeFees coinDCXFees2 = new ExchangeFees(344, COINDCX_ID, "USDT", 0.001, 0.001, 5);
        ExchangeFees coinDCXFees3 = new ExchangeFees(345, COINDCX_ID, "ETH", 0.001, 0.001, 0.005);
        ExchangeFees coinDCXFees4 = new ExchangeFees(346, COINDCX_ID, "TRX", 0.001, 0.001, 0);
        ExchangeFees coinDCXFees5 = new ExchangeFees(347, COINDCX_ID, "XRP", 0.001, 0.001, 0);
        ExchangeFees coinDCXFees6 = new ExchangeFees(348, COINDCX_ID, "ADA", 0.001, 0.001, 1);
        ExchangeFees coinDCXFees7 = new ExchangeFees(349, COINDCX_ID, "XLM", 0.001, 0.001, 0);
        ExchangeFees coinDCXFees8 = new ExchangeFees(350, COINDCX_ID, "BNB", 0.001, 0.001, 0.005);

        List<ExchangeFees> exchangeFees = Arrays.asList(koinexETHFees, koinexBTCFees, koinexBCHFees, koinexLTCFees, koinexXRPFees, throughbitETHFees, throughbitBTCFees, pocketBitsETHFees, pocketBitsBTCFees, pocketBitsBCHFees, pocketBitsLTCFees, pocketBitsXRPFees, pocketBitsBTGFees, pocketBitsDGBFees, pocketBitsXLMFees, pocketBitsSCFees, pocketBitsXVGFees, pocketBitsVOXFees, pocketBitsDASHFees, pocketBitsETCFees, pocketBitsXMRFees, pocketBitsNEOFees, pocketBitsOMGFees, pocketBitsZECFees, bitBnsBTCFees, bitBnsXRPFees, bitBnsNEOFees, bitBnsETHFees, bitBnsXLMFees, koinexOMGFees, koinexREQFees, koinexZRXFees, bitBnsGASFees, bitBnsRPXFees, bitBnsDBCFees, bitBnsLTCFees, bitBnsXMRFees, koinexAEFees, koinexBATFees, koinexGNTFees, bitBnsSIAFees, bitBnsDOGEFees, bitBnsBCHFees, bitBnsDASHFees, pocketBitsTRXFees, bitBnsTRXFees, koinexTRXFees, koinexXLMFees, koinexNEOFees, koinexGASFees, bitBnsETNFees, bitBnsONTFees, bitBnsZILFees, koinexAIONFees, koinexNCASHFees, bitBnsEOSFees, bitBnsPOLYFees, bitBnsDGBFees, bitBnsNCASHFees, koinexEOSFees, koinexNANOFees, bitBnsADAFees, bitBnsICXFees, bitBnsVENFees, bitBnsOMGFees, bitBnsREQFees, unocoinFees1, unocoinFees2, unocoinFees3, unocoinFees4, unocoinFees5, unocoinFees6, bitBnsWAVESFees, bitBnsWANFees, wazirxFees1, wazirxFees2, wazirxFees3, wazirxFees4, wazirxFees5, wazirxFees6, wazirxFees7, pocketBitsZRXFees, pocketBitsREPFees, pocketBitsBATFees, pocketBitsQTUMFees, pocketBitsADAFees, pocketBitsDOGEFees, pocketBitsGNTFees, pocketBitsSTORJFees, pocketBitsUBQFees, wazirxFees8, wazirxFees9, koinexONTFees, koinexZILFees, wazirxFees10, wazirxFees11, bitBnsACTFees, bitBnsDGDFees, bitBnsPOWRFees, bitBnsQLCFees, bitBnsWPRFees, koinexIOSTFees, wazirxFees12, koinexZCOFees, koinexPOLYFees, bitBnsXVGFees, wazirxFees13, bitBnsBLZFees, bitBnsLRCFees, bitBnsNEXOFees, bitBnsSUBFees, wazirxFees14, wazirxFees15, wazirxFees16, wazirxFees17, wazirxFees18, wazirxFees19, unocoinFees7, unocoinFees8, unocoinFees9, unocoinFees10, unocoinFees11, koinexAELFFees, bitBnsZRXFees, bitBnsCPXFees, bitBnsREPFees, bitBnsEFXFees, bitBnsLOOMFees, unocoinFees12, unocoinFees13, unocoinFees14, wazirxFees20, koinexCMTFees, wazirxFees21, wazirxFees22, koinexACTFees, wazirxFees23, wazirxFees24, wazirxFees25, wazirxFees26, wazirxFees27, wazirxFees28, wazirxFees29, wazirxFees30, wazirxFees31, wazirxFees32, wazirxFees33, wazirxFees34, wazirxFees35, bitBnsEOSDFees, bitBnsQKCFees, bitBnsSTORMFees, bitBnsQTUMFees, bitBnsGNTFees, bitBnsXEMFees, koinexSNTFees, koinexREPFees, koinexQKCFees, bitBnsLSKFees, bitBnsETCFees, bitBnsNPXSFees, bitBnsUSDTFees, koinexXZCFees, bitBnsCLOAKFees, bitBnsDENTFees, bitBnsGRSFees, bitBnsKMDFees, unocoinFees15, unocoinFees16, unocoinFees17, unocoinFees18, unocoinFees19, unocoinFees20, unocoinFees21, koinexUSDTFees, koinexTUSDFees, koinexBCHABCFees, koinexBCHSVFees, koinexBTTFees, bitBnsBCHABCFees, bitBnsBCHSVFees, bitBnsBTTFees, koinexMANAFees, coinDCXFees1, coinDCXFees1, coinDCXFees2, coinDCXFees3, coinDCXFees4, coinDCXFees5, coinDCXFees6, coinDCXFees7, coinDCXFees8);

        return Observable.fromCallable(() -> mExchangeRepository.insertExchangeFees(exchangeFees));
    }
}
