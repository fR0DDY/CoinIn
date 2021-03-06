package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.WAZIRX_ID;

/**
 * Created by gaurav on 19/04/18.
 */

public class WazirXResponse {
    @SerializedName("btcinr")
    Data BTC;
    @SerializedName("ltcinr")
    Data LTC;
    @SerializedName("xrpinr")
    Data XRP;
    @SerializedName("ethinr")
    Data ETH;
    @SerializedName("trxinr")
    Data TRX;
    @SerializedName("dashinr")
    Data DASH;
    @SerializedName("eosinr")
    Data EOS;
    @SerializedName("zilinr")
    Data ZIL;
    @SerializedName("ncashinr")
    Data NCASH;
    @SerializedName("gntinr")
    Data GNT;
    @SerializedName("zrxinr")
    Data ZRX;
    @SerializedName("storminr")
    Data STORM;
    @SerializedName("reqinr")
    Data REQ;
    @SerializedName("subinr")
    Data SUB;
    @SerializedName("nulsinr")
    Data NULS;
    @SerializedName("icxinr")
    Data ICX;
    @SerializedName("omginr")
    Data OMG;
    @SerializedName("polyinr")
    Data POLY;
    @SerializedName("iostinr")
    Data IOST;
    @SerializedName("npxsinr")
    Data NPXS;
    @SerializedName("noahinr")
    Data NOAH;
    @SerializedName("bancainr")
    Data BANCA;
    @SerializedName("funinr")
    Data FUN;
    @SerializedName("hotinr")
    Data HOT;
    @SerializedName("poeinr")
    Data POE;
    @SerializedName("ocninr")
    Data OCN;
    @SerializedName("stqinr")
    Data STQ;
    @SerializedName("zcoinr")
    Data ZCO;
    @SerializedName("dentinr")
    Data DENT;
    @SerializedName("qkcinr")
    Data QKC;
    @SerializedName("thetainr")
    Data THETA;
    @SerializedName("sntinr")
    Data SNT;
    @SerializedName("csinr")
    Data CS;
    @SerializedName("batinr")
    Data BAT;
    @SerializedName("usdtinr")
    Data USDT;
    @SerializedName("xrpbtc")
    Data XRP_BTC;
    @SerializedName("trxbtc")
    Data TRX_BTC;
    @SerializedName("ethbtc")
    Data ETH_BTC;
    @SerializedName("ncashbtc")
    Data NCASH_BTC;
    @SerializedName("zilbtc")
    Data ZIL_BTC;
    @SerializedName("ltcbtc")
    Data LTC_BTC;
    @SerializedName("qkcbtc")
    Data QKC_BTC;
    @SerializedName("batbtc")
    Data BAT_BTC;
    @SerializedName("npxsbtc")
    Data NPXS_BTC;
    @SerializedName("gntbtc")
    Data GNT_BTC;
    @SerializedName("subbtc")
    Data SUB_BTC;
    @SerializedName("reqbtc")
    Data REQ_BTC;
    @SerializedName("sntbtc")
    Data SNT_BTC;
    @SerializedName("iostbtc")
    Data IOST_BTC;
    @SerializedName("dashbtc")
    Data DASH_BTC;
    @SerializedName("stormbtc")
    Data STORM_BTC;
    @SerializedName("zrxbtc")
    Data ZRX_BTC;
    @SerializedName("btcusdt")
    Data BTC_USDT;
    @SerializedName("xrpusdt")
    Data XRP_USDT;
    @SerializedName("trxusdt")
    Data TRX_USDT;
    @SerializedName("bchusdt")
    Data BCH_USDT;
    @SerializedName("ltcusdt")
    Data LTC_USDT;
    @SerializedName("ethusdt")
    Data ETH_USDT;
    @SerializedName("eosusdt")
    Data EOS_USDT;
    @SerializedName("icxusdt")
    Data ICX_USDT;
    @SerializedName("bancausdt")
    Data BANCA_USDT;
    @SerializedName("batusdt")
    Data BAT_USDT;
    @SerializedName("hotusdt")
    Data HOT_USDT;
    @SerializedName("ncashusdt")
    Data NCASH_USDT;
    @SerializedName("noahusdt")
    Data NOAH_USDT;
    @SerializedName("npxsusdt")
    Data NPXS_USDT;
    @SerializedName("qkcusdt")
    Data QKC_USDT;
    @SerializedName("zilusdt")
    Data ZIL_USDT;
    @SerializedName("hotbtc")
    Data HOT_BTC;
    @SerializedName("bchbtc")
    Data BCH_BTC;
    @SerializedName("eosbtc")
    Data EOS_BTC;
    @SerializedName("nulsbtc")
    Data NULS_BTC;
    @SerializedName("polybtc")
    Data POLY_BTC;
    @SerializedName("thetabtc")
    Data THETA_BTC;
    @SerializedName("omgbtc")
    Data OMG_BTC;
    @SerializedName("dashusdt")
    Data DASH_USDT;
    @SerializedName("zrxusdt")
    Data ZRX_USDT;
    @SerializedName("bchabcusdt")
    Data BCHABC_USDT;
    @SerializedName("bchsvusdt")
    Data BCHSV_USDT;
    @SerializedName("csusdt")
    Data CS_USDT;
    @SerializedName("dentusdt")
    Data DENT_USDT;
    @SerializedName("gntusdt")
    Data GNT_USDT;
    @SerializedName("ocnusdt")
    Data OCN_USDT;
    @SerializedName("polyusdt")
    Data POLY_USDT;
    @SerializedName("requsdt")
    Data REQ_USDT;
    @SerializedName("stormusdt")
    Data STORM_USDT;
    @SerializedName("stqusdt")
    Data STQ_USDT;
    @SerializedName("subusdt")
    Data SUB_USDT;
    @SerializedName("zcousdt")
    Data ZCO_USDT;


    public class Data {
        @SerializedName("sell")
        String sell;
        @SerializedName("buy")
        String buy;

        public String getSell() {
            return sell;
        }

        public void setSell(String sell) {
            this.sell = sell;
        }

        public String getBuy() {
            return buy;
        }

        public void setBuy(String buy) {
            this.buy = buy;
        }
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "BTC", date, Double.parseDouble(BTC.sell), Double.parseDouble(BTC.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "LTC", date, Double.parseDouble(LTC.sell), Double.parseDouble(LTC.buy)));
        //exchangeRates.add(new ExchangeRate(WAZIRX_ID, "BCH", date, Double.parseDouble(BCH.sell), Double.parseDouble(BCH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "XRP", date, Double.parseDouble(XRP.sell), Double.parseDouble(XRP.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ETH", date, Double.parseDouble(ETH.sell), Double.parseDouble(ETH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "TRX", date, Double.parseDouble(TRX.sell), Double.parseDouble(TRX.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "DASH", date, Math.min(Double.parseDouble(DASH_BTC.sell) * Double.parseDouble(BTC.sell), Double.parseDouble(DASH_USDT.sell) * Double.parseDouble(USDT.sell)), Math.min(Double.parseDouble(DASH_BTC.buy) * Double.parseDouble(BTC.buy), Double.parseDouble(DASH_USDT.buy) * Double.parseDouble(USDT.buy))));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "EOS", date, Double.parseDouble(EOS.sell), Double.parseDouble(EOS.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ZIL", date, Double.parseDouble(ZIL.sell), Double.parseDouble(ZIL.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NCASH", date, Double.parseDouble(NCASH.sell), Double.parseDouble(NCASH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "GNT", date, Double.parseDouble(GNT.sell), Double.parseDouble(GNT.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ZRX", date, Math.min(Double.parseDouble(ZRX_BTC.sell) * Double.parseDouble(BTC.sell), Double.parseDouble(ZRX_USDT.sell) * Double.parseDouble(USDT.sell)), Math.min(Double.parseDouble(ZRX_BTC.buy) * Double.parseDouble(BTC.buy), Double.parseDouble(ZRX_USDT.buy) * Double.parseDouble(USDT.buy))));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "STORM", date, Double.parseDouble(STORM.sell), Double.parseDouble(STORM.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "REQ", date, Double.parseDouble(REQ.sell), Double.parseDouble(REQ.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "SUB", date, Double.parseDouble(SUB.sell), Double.parseDouble(SUB.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NULS", date, Double.parseDouble(NULS.sell), Double.parseDouble(NULS.buy)));
        //exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ICX", date, Double.parseDouble(ICX.sell), Double.parseDouble(ICX.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "OMG", date, Double.parseDouble(OMG_BTC.sell) * Double.parseDouble(BTC.sell), Double.parseDouble(OMG_BTC.buy) * Double.parseDouble(BTC.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "POLY", date, Double.parseDouble(POLY.sell), Double.parseDouble(POLY.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "IOST", date, Double.parseDouble(IOST_BTC.sell) * Double.parseDouble(BTC.sell), Double.parseDouble(IOST_BTC.buy) * Double.parseDouble(BTC.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NPXS", date, Double.parseDouble(NPXS.sell), Double.parseDouble(NPXS.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NOAH", date, Double.parseDouble(NOAH.sell), Double.parseDouble(NOAH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "BANCA", date, Double.parseDouble(BANCA.sell), Double.parseDouble(BANCA.buy)));
        //exchangeRates.add(new ExchangeRate(WAZIRX_ID, "FUN", date, Double.parseDouble(FUN.sell), Double.parseDouble(FUN.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "HOT", date, Double.parseDouble(HOT.sell), Double.parseDouble(HOT.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "OCN", date, Double.parseDouble(OCN.sell), Double.parseDouble(OCN.buy)));
        //exchangeRates.add(new ExchangeRate(WAZIRX_ID, "POE", date, Double.parseDouble(POE.sell), Double.parseDouble(POE.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "STQ", date, Double.parseDouble(STQ.sell), Double.parseDouble(STQ.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ZCO", date, Double.parseDouble(ZCO.sell), Double.parseDouble(ZCO.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "QKC", date, Double.parseDouble(QKC.sell), Double.parseDouble(QKC.buy)));
        //exchangeRates.add(new ExchangeRate(WAZIRX_ID, "THETA", date, Double.parseDouble(THETA.sell), Double.parseDouble(THETA.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "DENT", date, Double.parseDouble(DENT.sell), Double.parseDouble(DENT.buy)));
        //exchangeRates.add(new ExchangeRate(WAZIRX_ID, "SNT", date, Double.parseDouble(SNT.sell), Double.parseDouble(SNT.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "CS", date, Double.parseDouble(CS.sell), Double.parseDouble(CS.buy)));
        return exchangeRates;
    }

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        inrExchangeRates.put("BTC", new ExchangeRate(WAZIRX_ID, "BTC", date, Double.parseDouble(BTC.sell), Double.parseDouble(BTC.buy)));
        inrExchangeRates.put("XRP", new ExchangeRate(WAZIRX_ID, "XRP", date, Double.parseDouble(XRP.sell), Double.parseDouble(XRP.buy)));
        inrExchangeRates.put("TRX", new ExchangeRate(WAZIRX_ID, "TRX", date, Double.parseDouble(TRX.sell), Double.parseDouble(TRX.buy)));
        inrExchangeRates.put("ETH", new ExchangeRate(WAZIRX_ID, "ETH", date, Double.parseDouble(ETH.sell), Double.parseDouble(ETH.buy)));
        inrExchangeRates.put("NCASH", new ExchangeRate(WAZIRX_ID, "NCASH", date, Double.parseDouble(NCASH.sell), Double.parseDouble(NCASH.buy)));
        inrExchangeRates.put("ZIL", new ExchangeRate(WAZIRX_ID, "ZIL", date, Double.parseDouble(ZIL.sell), Double.parseDouble(ZIL.buy)));
        inrExchangeRates.put("LTC", new ExchangeRate(WAZIRX_ID, "LTC", date, Double.parseDouble(LTC.sell), Double.parseDouble(LTC.buy)));
        inrExchangeRates.put("QKC", new ExchangeRate(WAZIRX_ID, "QKC", date, Double.parseDouble(QKC.sell), Double.parseDouble(QKC.buy)));
        inrExchangeRates.put("BAT", new ExchangeRate(WAZIRX_ID, "BAT", date, Double.parseDouble(BAT.sell), Double.parseDouble(BAT.buy)));
        inrExchangeRates.put("NPXS", new ExchangeRate(WAZIRX_ID, "NPXS", date, Double.parseDouble(NPXS.sell), Double.parseDouble(NPXS.buy)));
        inrExchangeRates.put("GNT", new ExchangeRate(WAZIRX_ID, "GNT", date, Double.parseDouble(GNT.sell), Double.parseDouble(GNT.buy)));
        inrExchangeRates.put("SUB", new ExchangeRate(WAZIRX_ID, "SUB", date, Double.parseDouble(SUB.sell), Double.parseDouble(SUB.buy)));
        inrExchangeRates.put("REQ", new ExchangeRate(WAZIRX_ID, "REQ", date, Double.parseDouble(REQ.sell), Double.parseDouble(REQ.buy)));
        inrExchangeRates.put("STORM", new ExchangeRate(WAZIRX_ID, "STORM", date, Double.parseDouble(STORM.sell), Double.parseDouble(STORM.buy)));
        inrExchangeRates.put("USDT", new ExchangeRate(WAZIRX_ID, "USDT", date, Double.parseDouble(USDT.sell), Double.parseDouble(USDT.buy)));
        inrExchangeRates.put("HOT", new ExchangeRate(WAZIRX_ID, "HOT", date, Double.parseDouble(HOT.sell), Double.parseDouble(HOT.buy)));
        inrExchangeRates.put("EOS", new ExchangeRate(WAZIRX_ID, "EOS", date, Double.parseDouble(EOS.sell), Double.parseDouble(EOS.buy)));
        inrExchangeRates.put("BANCA", new ExchangeRate(WAZIRX_ID, "BANCA", date, Double.parseDouble(BANCA.sell), Double.parseDouble(BANCA.buy)));
        inrExchangeRates.put("NOAH", new ExchangeRate(WAZIRX_ID, "NOAH", date, Double.parseDouble(NOAH.sell), Double.parseDouble(NOAH.buy)));
        inrExchangeRates.put("NULS", new ExchangeRate(WAZIRX_ID, "NULS", date, Double.parseDouble(NULS.sell), Double.parseDouble(NULS.buy)));
        inrExchangeRates.put("POLY", new ExchangeRate(WAZIRX_ID, "POLY", date, Double.parseDouble(POLY.sell), Double.parseDouble(POLY.buy)));
        inrExchangeRates.put("CS", new ExchangeRate(WAZIRX_ID, "CS", date, Double.parseDouble(CS.sell), Double.parseDouble(CS.buy)));
        inrExchangeRates.put("DENT", new ExchangeRate(WAZIRX_ID, "DENT", date, Double.parseDouble(DENT.sell), Double.parseDouble(DENT.buy)));
        inrExchangeRates.put("OCN", new ExchangeRate(WAZIRX_ID, "OCN", date, Double.parseDouble(OCN.sell), Double.parseDouble(OCN.buy)));
        inrExchangeRates.put("STQ", new ExchangeRate(WAZIRX_ID, "STQ", date, Double.parseDouble(STQ.sell), Double.parseDouble(STQ.buy)));
        inrExchangeRates.put("ZCO", new ExchangeRate(WAZIRX_ID, "ZCO", date, Double.parseDouble(ZCO.sell), Double.parseDouble(ZCO.buy)));
        exchangeRates.put("INR", inrExchangeRates);
        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        bitcoinExchangeRates.put("XRP", new ExchangeRate(WAZIRX_ID, "XRP", date, Double.parseDouble(XRP_BTC.sell), Double.parseDouble(XRP_BTC.buy)));
        bitcoinExchangeRates.put("TRX", new ExchangeRate(WAZIRX_ID, "TRX", date, Double.parseDouble(TRX_BTC.sell), Double.parseDouble(TRX_BTC.buy)));
        bitcoinExchangeRates.put("ETH", new ExchangeRate(WAZIRX_ID, "ETH", date, Double.parseDouble(ETH_BTC.sell), Double.parseDouble(ETH_BTC.buy)));
        bitcoinExchangeRates.put("NCASH", new ExchangeRate(WAZIRX_ID, "NCASH", date, Double.parseDouble(NCASH_BTC.sell), Double.parseDouble(NCASH_BTC.buy)));
        bitcoinExchangeRates.put("ZIL", new ExchangeRate(WAZIRX_ID, "ZIL", date, Double.parseDouble(ZIL_BTC.sell), Double.parseDouble(ZIL_BTC.buy)));
        bitcoinExchangeRates.put("LTC", new ExchangeRate(WAZIRX_ID, "LTC", date, Double.parseDouble(LTC_BTC.sell), Double.parseDouble(LTC_BTC.buy)));
        bitcoinExchangeRates.put("QKC", new ExchangeRate(WAZIRX_ID, "QKC", date, Double.parseDouble(QKC_BTC.sell), Double.parseDouble(QKC_BTC.buy)));
        bitcoinExchangeRates.put("BAT", new ExchangeRate(WAZIRX_ID, "BAT", date, Double.parseDouble(BAT_BTC.sell), Double.parseDouble(BAT_BTC.buy)));
        bitcoinExchangeRates.put("NPXS", new ExchangeRate(WAZIRX_ID, "NPXS", date, Double.parseDouble(NPXS_BTC.sell), Double.parseDouble(NPXS_BTC.buy)));
        bitcoinExchangeRates.put("GNT", new ExchangeRate(WAZIRX_ID, "GNT", date, Double.parseDouble(GNT_BTC.sell), Double.parseDouble(GNT_BTC.buy)));
        bitcoinExchangeRates.put("SUB", new ExchangeRate(WAZIRX_ID, "SUB", date, Double.parseDouble(SUB_BTC.sell), Double.parseDouble(SUB_BTC.buy)));
        bitcoinExchangeRates.put("REQ", new ExchangeRate(WAZIRX_ID, "REQ", date, Double.parseDouble(REQ_BTC.sell), Double.parseDouble(REQ_BTC.buy)));
        bitcoinExchangeRates.put("STORM", new ExchangeRate(WAZIRX_ID, "STORM", date, Double.parseDouble(STORM_BTC.sell), Double.parseDouble(STORM_BTC.buy)));
        bitcoinExchangeRates.put("HOT", new ExchangeRate(WAZIRX_ID, "HOT", date, Double.parseDouble(HOT_BTC.sell), Double.parseDouble(HOT_BTC.buy)));
        bitcoinExchangeRates.put("EOS", new ExchangeRate(WAZIRX_ID, "EOS", date, Double.parseDouble(EOS_BTC.sell), Double.parseDouble(EOS_BTC.buy)));
        bitcoinExchangeRates.put("NULS", new ExchangeRate(WAZIRX_ID, "NULS", date, Double.parseDouble(NULS_BTC.sell), Double.parseDouble(NULS_BTC.buy)));
        bitcoinExchangeRates.put("POLY", new ExchangeRate(WAZIRX_ID, "POLY", date, Double.parseDouble(POLY_BTC.sell), Double.parseDouble(POLY_BTC.buy)));
        exchangeRates.put("BTC", bitcoinExchangeRates);
        Map<String, ExchangeRate> usdtExchangeRates = new HashMap<>();
        usdtExchangeRates.put("BTC", new ExchangeRate(WAZIRX_ID, "BTC", date, Double.parseDouble(BTC_USDT.sell), Double.parseDouble(BTC_USDT.buy)));
        usdtExchangeRates.put("XRP", new ExchangeRate(WAZIRX_ID, "XRP", date, Double.parseDouble(XRP_USDT.sell), Double.parseDouble(XRP_USDT.buy)));
        usdtExchangeRates.put("TRX", new ExchangeRate(WAZIRX_ID, "TRX", date, Double.parseDouble(TRX_USDT.sell), Double.parseDouble(TRX_USDT.buy)));
        usdtExchangeRates.put("ETH", new ExchangeRate(WAZIRX_ID, "ETH", date, Double.parseDouble(ETH_USDT.sell), Double.parseDouble(ETH_USDT.buy)));
        usdtExchangeRates.put("LTC", new ExchangeRate(WAZIRX_ID, "LTC", date, Double.parseDouble(LTC_USDT.sell), Double.parseDouble(LTC_USDT.buy)));
        usdtExchangeRates.put("EOS", new ExchangeRate(WAZIRX_ID, "EOS", date, Double.parseDouble(EOS_USDT.sell), Double.parseDouble(EOS_USDT.buy)));
        usdtExchangeRates.put("BANCA", new ExchangeRate(WAZIRX_ID, "BANCA", date, Double.parseDouble(BANCA_USDT.sell), Double.parseDouble(BANCA_USDT.buy)));
        usdtExchangeRates.put("BAT", new ExchangeRate(WAZIRX_ID, "BAT", date, Double.parseDouble(BAT_USDT.sell), Double.parseDouble(BAT_USDT.buy)));
        usdtExchangeRates.put("HOT", new ExchangeRate(WAZIRX_ID, "HOT", date, Double.parseDouble(HOT_USDT.sell), Double.parseDouble(HOT_USDT.buy)));
        usdtExchangeRates.put("NCASH", new ExchangeRate(WAZIRX_ID, "NCASH", date, Double.parseDouble(NCASH_USDT.sell), Double.parseDouble(NCASH_USDT.buy)));
        usdtExchangeRates.put("NOAH", new ExchangeRate(WAZIRX_ID, "NOAH", date, Double.parseDouble(NOAH_USDT.sell), Double.parseDouble(NOAH_USDT.buy)));
        usdtExchangeRates.put("NPXS", new ExchangeRate(WAZIRX_ID, "NPXS", date, Double.parseDouble(NPXS_USDT.sell), Double.parseDouble(NPXS_USDT.buy)));
        usdtExchangeRates.put("QKC", new ExchangeRate(WAZIRX_ID, "QKC", date, Double.parseDouble(QKC_USDT.sell), Double.parseDouble(QKC_USDT.buy)));
        usdtExchangeRates.put("ZIL", new ExchangeRate(WAZIRX_ID, "ZIL", date, Double.parseDouble(ZIL_USDT.sell), Double.parseDouble(ZIL_USDT.buy)));
        usdtExchangeRates.put("CS", new ExchangeRate(WAZIRX_ID, "CS", date, Double.parseDouble(CS_USDT.sell), Double.parseDouble(CS_USDT.buy)));
        usdtExchangeRates.put("DENT", new ExchangeRate(WAZIRX_ID, "DENT", date, Double.parseDouble(DENT_USDT.sell), Double.parseDouble(DENT_USDT.buy)));
        usdtExchangeRates.put("GNT", new ExchangeRate(WAZIRX_ID, "GNT", date, Double.parseDouble(GNT_USDT.sell), Double.parseDouble(GNT_USDT.buy)));
        usdtExchangeRates.put("OCN", new ExchangeRate(WAZIRX_ID, "OCN", date, Double.parseDouble(OCN_USDT.sell), Double.parseDouble(OCN_USDT.buy)));
        usdtExchangeRates.put("POLY", new ExchangeRate(WAZIRX_ID, "POLY", date, Double.parseDouble(POLY_USDT.sell), Double.parseDouble(POLY_USDT.buy)));
        usdtExchangeRates.put("REQ", new ExchangeRate(WAZIRX_ID, "REQ", date, Double.parseDouble(REQ_USDT.sell), Double.parseDouble(REQ_USDT.buy)));
        usdtExchangeRates.put("STORM", new ExchangeRate(WAZIRX_ID, "STORM", date, Double.parseDouble(STORM_USDT.sell), Double.parseDouble(STORM_USDT.buy)));
        usdtExchangeRates.put("STQ", new ExchangeRate(WAZIRX_ID, "STQ", date, Double.parseDouble(STQ_USDT.sell), Double.parseDouble(STQ_USDT.buy)));
        usdtExchangeRates.put("SUB", new ExchangeRate(WAZIRX_ID, "SUB", date, Double.parseDouble(SUB_USDT.sell), Double.parseDouble(SUB_USDT.buy)));
        usdtExchangeRates.put("ZCO", new ExchangeRate(WAZIRX_ID, "ZCO", date, Double.parseDouble(ZCO_USDT.sell), Double.parseDouble(ZCO_USDT.buy)));
        exchangeRates.put("USDT", usdtExchangeRates);
        return exchangeRates;
    }
}
