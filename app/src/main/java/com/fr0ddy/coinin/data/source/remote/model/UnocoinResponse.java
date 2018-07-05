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

    Stats stats;

    public class Stats {

        Currency inr;

        public class Currency {
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
            Data OMG;
            Data KNC;
            Data RDN;
            Data NMR;
            Data PAY;
            Data QRL;
            Data WAX;

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
        }
    }


    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BTC", date, Double.parseDouble(stats.inr.BTC.getLowestAsk()), Double.parseDouble(stats.inr.BTC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "LTC", date, Double.parseDouble(stats.inr.LTC.getLowestAsk()), Double.parseDouble(stats.inr.LTC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BCH", date, Double.parseDouble(stats.inr.BCH.getLowestAsk()), Double.parseDouble(stats.inr.BCH.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "XRP", date, Double.parseDouble(stats.inr.XRP.getLowestAsk()), Double.parseDouble(stats.inr.XRP.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "ETH", date, Double.parseDouble(stats.inr.ETH.getLowestAsk()), Double.parseDouble(stats.inr.ETH.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BTG", date, Double.parseDouble(stats.inr.BTG.getLowestAsk()), Double.parseDouble(stats.inr.BTG.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BAT", date, Double.parseDouble(stats.inr.BAT.getLowestAsk()), Double.parseDouble(stats.inr.BAT.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "BRD", date, Double.parseDouble(stats.inr.BRD.getLowestAsk()), Double.parseDouble(stats.inr.BRD.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "FUN", date, Double.parseDouble(stats.inr.FUN.getLowestAsk()), Double.parseDouble(stats.inr.FUN.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "GNT", date, Double.parseDouble(stats.inr.GNT.getLowestAsk()), Double.parseDouble(stats.inr.GNT.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "ZIL", date, Double.parseDouble(stats.inr.ZIL.getLowestAsk()), Double.parseDouble(stats.inr.ZIL.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "CVC", date, Double.parseDouble(stats.inr.CVC.getLowestAsk()), Double.parseDouble(stats.inr.CVC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "REP", date, Double.parseDouble(stats.inr.REP.getLowestAsk()), Double.parseDouble(stats.inr.REP.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "ZRX", date, Double.parseDouble(stats.inr.ZRX.getLowestAsk()), Double.parseDouble(stats.inr.ZRX.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "OMG", date, Double.parseDouble(stats.inr.OMG.getLowestAsk()), Double.parseDouble(stats.inr.OMG.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "KNC", date, Double.parseDouble(stats.inr.KNC.getLowestAsk()), Double.parseDouble(stats.inr.KNC.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "RDN", date, Double.parseDouble(stats.inr.RDN.getLowestAsk()), Double.parseDouble(stats.inr.RDN.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "NMR", date, Double.parseDouble(stats.inr.NMR.getLowestAsk()), Double.parseDouble(stats.inr.NMR.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "PAY", date, Double.parseDouble(stats.inr.PAY.getLowestAsk()), Double.parseDouble(stats.inr.PAY.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "QRL", date, Double.parseDouble(stats.inr.QRL.getLowestAsk()), Double.parseDouble(stats.inr.QRL.getHighestBid())));
        exchangeRates.add(new ExchangeRate(UNOCOIN_ID, "WAX", date, Double.parseDouble(stats.inr.WAX.getLowestAsk()), Double.parseDouble(stats.inr.WAX.getHighestBid())));
        return exchangeRates;
    }
}
