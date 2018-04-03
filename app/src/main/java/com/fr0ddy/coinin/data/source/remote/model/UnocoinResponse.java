package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.UNOCOIN_ID;

/**
 * Created by gaurav on 02/04/18.
 */

public class UnocoinResponse {

    Data BTC;
    Data LTC;
    Data BCH;
    Data XRP;
    Data ETH;
    Data BTG;

    public class Data {
        @SerializedName("lowest_ask")
        String lowestAsk;
        @SerializedName("highest_bid")
        String highestBid;

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
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BTC", date, Double.parseDouble(BTC.getLowestAsk()), Double.parseDouble(BTC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "LTC", date, Double.parseDouble(LTC.getLowestAsk()), Double.parseDouble(LTC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BCH", date, Double.parseDouble(BCH.getLowestAsk()), Double.parseDouble(BCH.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "XRP", date, Double.parseDouble(XRP.getLowestAsk()), Double.parseDouble(XRP.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "ETH", date, Double.parseDouble(ETH.getLowestAsk()), Double.parseDouble(ETH.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BTG", date, Double.parseDouble(BTG.getLowestAsk()), Double.parseDouble(BTG.getHighestBid())));
        return exchangeRates;
    }
}
