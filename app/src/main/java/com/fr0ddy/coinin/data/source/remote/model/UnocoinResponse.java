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
    Data BAT;
    Data BRD;
    Data FUN;
    Data GNT;
    Data ZIL;
    Data CVC;
    Data REP;
    Data ZRX;

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
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BAT", date, Double.parseDouble(BAT.getLowestAsk()), Double.parseDouble(BAT.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BRD", date, Double.parseDouble(BRD.getLowestAsk()), Double.parseDouble(BRD.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "FUN", date, Double.parseDouble(FUN.getLowestAsk()), Double.parseDouble(FUN.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "GNT", date, Double.parseDouble(GNT.getLowestAsk()), Double.parseDouble(GNT.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "ZIL", date, Double.parseDouble(ZIL.getLowestAsk()), Double.parseDouble(ZIL.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "CVC", date, Double.parseDouble(CVC.getLowestAsk()), Double.parseDouble(CVC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "REP", date, Double.parseDouble(REP.getLowestAsk()), Double.parseDouble(REP.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "ZRX", date, Double.parseDouble(ZRX.getLowestAsk()), Double.parseDouble(ZRX.getHighestBid())));
        return exchangeRates;
    }
}
