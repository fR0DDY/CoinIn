package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.GIOTTUS_ID;

/**
 * Created by gaurav on 26/06/18.
 */

public class GiottusResponse {

    Market market;

    public class Market {
        @SerializedName("XRP/ETH")
        Data XRP_ETH;
        @SerializedName("LTC/XRP")
        Data LTC_XRP;
        @SerializedName("BCH/INR")
        Data BCH_INR;
        @SerializedName("LTC/BCH")
        Data LTC_BCH;
        @SerializedName("LTC/BTC")
        Data LTC_BTC;
        @SerializedName("LTC/ETH")
        Data LTC_ETH;
        @SerializedName("XRP/BTC")
        Data XRP_BTC;
        @SerializedName("BCH/ETH")
        Data BCH_ETH;
        @SerializedName("XRP/INR")
        Data XRP_INR;
        @SerializedName("XRP/BCH")
        Data XRP_BCH;
        @SerializedName("BCH/BTC")
        Data BCH_BTC;
        @SerializedName("ETH/INR")
        Data ETH_INR;
        @SerializedName("LTC/INR")
        Data LTC_INR;
        @SerializedName("BTC/INR")
        Data BTC_INR;
        @SerializedName("ETH/BTC")
        Data ETH_BTC;


        public class Data {
            @SerializedName("top_ask")
            String lowestAsk;
            @SerializedName("top_bid")
            String highestBid;

            public Double lowestAsk() {
                return Double.parseDouble(lowestAsk.split(" ")[0]);
            }

            public Double highestBid() {
                return Double.parseDouble(highestBid.split(" ")[0]);
            }
        }

    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        try {
            exchangeRates.add(new ExchangeRate(GIOTTUS_ID, "BTC", date, market.BTC_INR.lowestAsk(), market.BTC_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            exchangeRates.add(new ExchangeRate(GIOTTUS_ID, "BCH", date, market.BCH_INR.lowestAsk(), market.BCH_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            exchangeRates.add(new ExchangeRate(GIOTTUS_ID, "XRP", date, market.XRP_INR.lowestAsk(), market.XRP_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            exchangeRates.add(new ExchangeRate(GIOTTUS_ID, "ETH", date, market.ETH_INR.lowestAsk(), market.ETH_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            exchangeRates.add(new ExchangeRate(GIOTTUS_ID, "LTC", date, market.LTC_INR.lowestAsk(), market.LTC_INR.highestBid()));
        } catch (Exception e) {
        }
        return exchangeRates;
    }

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        try {
            inrExchangeRates.put("BTC", new ExchangeRate(GIOTTUS_ID, "BTC", date, market.BTC_INR.lowestAsk(), market.BTC_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            inrExchangeRates.put("BCH", new ExchangeRate(GIOTTUS_ID, "BCH", date, market.BCH_INR.lowestAsk(), market.BCH_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            inrExchangeRates.put("XRP", new ExchangeRate(GIOTTUS_ID, "XRP", date, market.XRP_INR.lowestAsk(), market.XRP_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            inrExchangeRates.put("ETH", new ExchangeRate(GIOTTUS_ID, "ETH", date, market.ETH_INR.lowestAsk(), market.ETH_INR.highestBid()));
        } catch (Exception e) {
        }
        try {
            inrExchangeRates.put("LTC", new ExchangeRate(GIOTTUS_ID, "LTC", date, market.LTC_INR.lowestAsk(), market.LTC_INR.highestBid()));
        } catch (Exception e) {
        }

        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        try {
            bitcoinExchangeRates.put("BCH", new ExchangeRate(GIOTTUS_ID, "BCH", date, market.BCH_BTC.lowestAsk(), market.BCH_BTC.highestBid()));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("XRP", new ExchangeRate(GIOTTUS_ID, "XRP", date, market.XRP_BTC.lowestAsk(), market.XRP_BTC.highestBid()));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("ETH", new ExchangeRate(GIOTTUS_ID, "ETH", date, market.ETH_BTC.lowestAsk(), market.ETH_BTC.highestBid()));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("LTC", new ExchangeRate(GIOTTUS_ID, "LTC", date, market.LTC_BTC.lowestAsk(), market.LTC_BTC.highestBid()));
        } catch (Exception e) {
        }

        Map<String, ExchangeRate> etherExchangeRates = new HashMap<>();
        try {
            etherExchangeRates.put("XRP", new ExchangeRate(GIOTTUS_ID, "XRP", date, market.XRP_ETH.lowestAsk(), market.XRP_ETH.highestBid()));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("BCH", new ExchangeRate(GIOTTUS_ID, "BCH", date, market.BCH_ETH.lowestAsk(), market.BCH_ETH.highestBid()));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("LTC", new ExchangeRate(GIOTTUS_ID, "LTC", date, market.LTC_ETH.lowestAsk(), market.LTC_ETH.highestBid()));
        } catch (Exception e) {
        }

        Map<String, ExchangeRate> bitcoinCashExchangeRates = new HashMap<>();
        try {
            bitcoinCashExchangeRates.put("XRP", new ExchangeRate(GIOTTUS_ID, "XRP", date, market.XRP_BCH.lowestAsk(), market.XRP_BCH.highestBid()));
        } catch (Exception e) {
        }
        try {
            bitcoinCashExchangeRates.put("LTC", new ExchangeRate(GIOTTUS_ID, "LTC", date, market.LTC_BCH.lowestAsk(), market.LTC_BCH.highestBid()));
        } catch (Exception e) {
        }

        Map<String, ExchangeRate> rippleExchangeRates = new HashMap<>();
        try {
            rippleExchangeRates.put("LTC", new ExchangeRate(GIOTTUS_ID, "LTC", date, market.LTC_XRP.lowestAsk(), market.LTC_XRP.highestBid()));
        } catch (Exception e) {
        }

        exchangeRates.put("INR", inrExchangeRates);
        exchangeRates.put("BTC", bitcoinExchangeRates);
        exchangeRates.put("ETH", etherExchangeRates);
        exchangeRates.put("BCH", bitcoinCashExchangeRates);
        exchangeRates.put("XRP", rippleExchangeRates);

        return exchangeRates;

    }
}
