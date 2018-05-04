package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.COINOME_ID;

/**
 * Created by gaurav on 15/12/17.
 */

public class CoinomeResponse {

    @SerializedName("btc-inr")
    Data BTC;
    @SerializedName("ltc-inr")
    Data LTC;
    @SerializedName("bch-inr")
    Data BCH;
    @SerializedName("dash-inr")
    Data DASH;
    @SerializedName("dgb-inr")
    Data DGB;
    @SerializedName("zec-inr")
    Data ZEC;
    @SerializedName("qtum-inr")
    Data QTUM;
    @SerializedName("btg-inr")
    Data BTG;
    @SerializedName("ltc-btc")
    Data LTC_BTC;
    @SerializedName("bch-btc")
    Data BCH_BTC;
    @SerializedName("dash-btc")
    Data DASH_BTC;
    @SerializedName("zec-btc")
    Data ZEC_BTC;
    @SerializedName("btg-btc")
    Data BTG_BTC;
    @SerializedName("dgb-btc")
    Data DGB_BTC;
    @SerializedName("qtum-btc")
    Data QTUM_BTC;

    public Data getBTC() {
        return BTC;
    }

    public void setBTC(Data BTC) {
        this.BTC = BTC;
    }

    public Data getLTC() {
        return LTC;
    }

    public void setLTC(Data LTC) {
        this.LTC = LTC;
    }

    public Data getBCH() {
        return BCH;
    }

    public void setBCH(Data BCH) {
        this.BCH = BCH;
    }

    public Data getDASH() {
        return DASH;
    }

    public Data getDGB() {
        return DGB;
    }

    public Data getZEC() {
        return ZEC;
    }

    public void setDASH(Data DASH) {
        this.DASH = DASH;
    }

    public void setDGB(Data DGB) {
        this.DGB = DGB;
    }

    public void setZEC(Data ZEC) {
        this.ZEC = ZEC;
    }

    public Data getQTUM() {
        return QTUM;
    }

    public void setQTUM(Data QTUM) {
        this.QTUM = QTUM;
    }

    public Data getBTG() {
        return BTG;
    }

    public void setBTG(Data BTG) {
        this.BTG = BTG;
    }

    public class Data {
        @SerializedName("last")
        String lastTradedPrice;
        @SerializedName("lowest_ask")
        String lowestAsk;
        @SerializedName("highest_bid")
        String highestBid;

        public String getLastTradedPrice() {
            return lastTradedPrice;
        }

        public void setLastTradedPrice(String lastTradedPrice) {
            this.lastTradedPrice = lastTradedPrice;
        }

        public String getLowestAsk() {
            return lowestAsk;
        }

        public void setLowestAsk(String lowestAsk) {
            this.lowestAsk = lowestAsk;
        }

        public String getHighestBid() {
            return highestBid;
        }

        public void setHighestBid(String highestBid) {
            this.highestBid = highestBid;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "lastTradedPrice='" + lastTradedPrice + '\'' +
                    ", lowestAsk='" + lowestAsk + '\'' +
                    ", highestBid='" + highestBid + '\'' +
                    '}';
        }

        public Data(String lowestAsk, String highestBid) {
            this.lowestAsk = lowestAsk;
            this.highestBid = highestBid;
        }
    }

    @Override
    public String toString() {
        return "CoinomeResponse{" +
                "BTC=" + BTC +
                ", LTC=" + LTC +
                ", BCH=" + BCH +
                '}';
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        ExchangeRate coinomeBTCRate = new ExchangeRate(COINOME_ID, "BTC", date, Double.parseDouble(getBTC().getLowestAsk()), Double.parseDouble(getBTC().getHighestBid()));

        ExchangeRate coinomeBCHRate = new ExchangeRate(COINOME_ID, "BCH", date, Double.parseDouble(getBCH().getLowestAsk()), Double.parseDouble(getBCH().getHighestBid()));

        ExchangeRate coinomeLTCRate = new ExchangeRate(COINOME_ID, "LTC", date, Double.parseDouble(getLTC().getLowestAsk()), Double.parseDouble(getLTC().getHighestBid()));

        ExchangeRate coinomeDASHRate = new ExchangeRate(COINOME_ID, "DASH", date, Double.parseDouble(getDASH().getLowestAsk()), Double.parseDouble(getDASH().getHighestBid()));

        ExchangeRate coinomeDGBRate = new ExchangeRate(COINOME_ID, "DGB", date, Double.parseDouble(getDGB().getLowestAsk()), Double.parseDouble(getDGB().getHighestBid()));

        ExchangeRate coinomeZECRate = new ExchangeRate(COINOME_ID, "ZEC", date, Double.parseDouble(getZEC().getLowestAsk()), Double.parseDouble(getZEC().getHighestBid()));

        exchangeRates.add(new ExchangeRate(COINOME_ID, "QTUM", date, Double.parseDouble(getQTUM().getLowestAsk()), Double.parseDouble(getQTUM().getHighestBid())));

        exchangeRates.add(new ExchangeRate(COINOME_ID, "BTG", date, Double.parseDouble(getBTG().getLowestAsk()), Double.parseDouble(getBTG().getHighestBid())));

        exchangeRates.add(coinomeBTCRate);
        exchangeRates.add(coinomeBCHRate);
        exchangeRates.add(coinomeLTCRate);
        exchangeRates.add(coinomeDASHRate);
        exchangeRates.add(coinomeDGBRate);
        exchangeRates.add(coinomeZECRate);
        return exchangeRates;
    }

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        inrExchangeRates.put("BTC", new ExchangeRate(COINOME_ID, "BTC", date, Double.parseDouble(BTC.getLowestAsk()), Double.parseDouble(BTC.getHighestBid())));
        inrExchangeRates.put("LTC", new ExchangeRate(COINOME_ID, "LTC", date, Double.parseDouble(LTC.getLowestAsk()), Double.parseDouble(LTC.getHighestBid())));
        inrExchangeRates.put("BCH", new ExchangeRate(COINOME_ID, "BCH", date, Double.parseDouble(BCH.getLowestAsk()), Double.parseDouble(BCH.getHighestBid())));
        inrExchangeRates.put("DASH", new ExchangeRate(COINOME_ID, "DASH", date, Double.parseDouble(DASH.getLowestAsk()), Double.parseDouble(DASH.getHighestBid())));
        inrExchangeRates.put("ZEC", new ExchangeRate(COINOME_ID, "ZEC", date, Double.parseDouble(ZEC.getLowestAsk()), Double.parseDouble(ZEC.getHighestBid())));
        inrExchangeRates.put("BTG", new ExchangeRate(COINOME_ID, "BTG", date, Double.parseDouble(BTG.getLowestAsk()), Double.parseDouble(BTG.getHighestBid())));
        inrExchangeRates.put("DGB", new ExchangeRate(COINOME_ID, "DGB", date, Double.parseDouble(DGB.getLowestAsk()), Double.parseDouble(DGB.getHighestBid())));
        inrExchangeRates.put("QTUM", new ExchangeRate(COINOME_ID, "QTUM", date, Double.parseDouble(QTUM.getLowestAsk()), Double.parseDouble(QTUM.getHighestBid())));
        exchangeRates.put("INR", inrExchangeRates);

        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        try {
            bitcoinExchangeRates.put("LTC", new ExchangeRate(COINOME_ID, "LTC", date, Double.parseDouble(LTC_BTC.getLowestAsk()), Double.parseDouble(LTC_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("BCH", new ExchangeRate(COINOME_ID, "BCH", date, Double.parseDouble(BCH_BTC.getLowestAsk()), Double.parseDouble(BCH_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("DASH", new ExchangeRate(COINOME_ID, "DASH", date, Double.parseDouble(DASH_BTC.getLowestAsk()), Double.parseDouble(DASH_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("ZEC", new ExchangeRate(COINOME_ID, "ZEC", date, Double.parseDouble(ZEC_BTC.getLowestAsk()), Double.parseDouble(ZEC_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("BTG", new ExchangeRate(COINOME_ID, "BTG", date, Double.parseDouble(BTG_BTC.getLowestAsk()), Double.parseDouble(BTG_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("DGB", new ExchangeRate(COINOME_ID, "DGB", date, Double.parseDouble(DGB_BTC.getLowestAsk()), Double.parseDouble(DGB_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("QTUM", new ExchangeRate(COINOME_ID, "QTUM", date, Double.parseDouble(QTUM_BTC.getLowestAsk()), Double.parseDouble(QTUM_BTC.getHighestBid())));
        } catch (Exception e) {
        }
        exchangeRates.put("BTC", bitcoinExchangeRates);

        return exchangeRates;
    }
}
