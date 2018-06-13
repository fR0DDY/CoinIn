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
    @SerializedName("bchinr")
    Data BCH;
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
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "BCH", date, Double.parseDouble(BCH.sell), Double.parseDouble(BCH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "XRP", date, Double.parseDouble(XRP.sell), Double.parseDouble(XRP.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ETH", date, Double.parseDouble(ETH.sell), Double.parseDouble(ETH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "TRX", date, Double.parseDouble(TRX.sell), Double.parseDouble(TRX.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "DASH", date, Double.parseDouble(DASH.sell), Double.parseDouble(DASH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "EOS", date, Double.parseDouble(EOS.sell), Double.parseDouble(EOS.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ZIL", date, Double.parseDouble(ZIL.sell), Double.parseDouble(ZIL.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NCASH", date, Double.parseDouble(NCASH.sell), Double.parseDouble(NCASH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "GNT", date, Double.parseDouble(GNT.sell), Double.parseDouble(GNT.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ZRX", date, Double.parseDouble(ZRX.sell), Double.parseDouble(ZRX.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "STORM", date, Double.parseDouble(STORM.sell), Double.parseDouble(STORM.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "REQ", date, Double.parseDouble(REQ.sell), Double.parseDouble(REQ.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "SUB", date, Double.parseDouble(SUB.sell), Double.parseDouble(SUB.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NULS", date, Double.parseDouble(NULS.sell), Double.parseDouble(NULS.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ICX", date, Double.parseDouble(ICX.sell), Double.parseDouble(ICX.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "OMG", date, Double.parseDouble(OMG.sell), Double.parseDouble(OMG.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "POLY", date, Double.parseDouble(POLY.sell), Double.parseDouble(POLY.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "IOST", date, Double.parseDouble(IOST.sell), Double.parseDouble(IOST.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NPXS", date, Double.parseDouble(NPXS.sell), Double.parseDouble(NPXS.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "NOAH", date, Double.parseDouble(NOAH.sell), Double.parseDouble(NOAH.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "BANCA", date, Double.parseDouble(BANCA.sell), Double.parseDouble(BANCA.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "FUN", date, Double.parseDouble(FUN.sell), Double.parseDouble(FUN.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "HOT", date, Double.parseDouble(HOT.sell), Double.parseDouble(HOT.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "OCN", date, Double.parseDouble(OCN.sell), Double.parseDouble(OCN.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "POE", date, Double.parseDouble(POE.sell), Double.parseDouble(POE.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "STQ", date, Double.parseDouble(STQ.sell), Double.parseDouble(STQ.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "ZCO", date, Double.parseDouble(ZCO.sell), Double.parseDouble(ZCO.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "QKC", date, Double.parseDouble(QKC.sell), Double.parseDouble(QKC.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "THETA", date, Double.parseDouble(THETA.sell), Double.parseDouble(THETA.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "DENT", date, Double.parseDouble(DENT.sell), Double.parseDouble(DENT.buy)));
        exchangeRates.add(new ExchangeRate(WAZIRX_ID, "SNT", date, Double.parseDouble(SNT.sell), Double.parseDouble(SNT.buy)));
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
        exchangeRates.put("INR", inrExchangeRates);
        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        bitcoinExchangeRates.put("XRP", new ExchangeRate(WAZIRX_ID, "XRP", date, Double.parseDouble(XRP_BTC.sell), Double.parseDouble(XRP_BTC.buy)));
        bitcoinExchangeRates.put("TRX", new ExchangeRate(WAZIRX_ID, "TRX", date, Double.parseDouble(TRX_BTC.sell), Double.parseDouble(TRX_BTC.buy)));
        bitcoinExchangeRates.put("ETH", new ExchangeRate(WAZIRX_ID, "ETH", date, Double.parseDouble(ETH_BTC.sell), Double.parseDouble(ETH_BTC.buy)));
        bitcoinExchangeRates.put("NCASH", new ExchangeRate(WAZIRX_ID, "NCASH", date, Double.parseDouble(NCASH_BTC.sell), Double.parseDouble(NCASH_BTC.buy)));
        bitcoinExchangeRates.put("ZIL", new ExchangeRate(WAZIRX_ID, "ZIL", date, Double.parseDouble(ZIL_BTC.sell), Double.parseDouble(ZIL_BTC.buy)));
        exchangeRates.put("BTC", bitcoinExchangeRates);
        return exchangeRates;
    }
}
