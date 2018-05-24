package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        return exchangeRates;
    }
}
