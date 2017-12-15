package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurav on 15/12/17.
 */

public class CoinomeResponse {

    @SerializedName("BTC-INR")
    Data BTC;
    @SerializedName("LTC-INR")
    Data LTC;
    @SerializedName("BCH-INR")
    Data BCH;

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
    }

    @Override
    public String toString() {
        return "CoinomeResponse{" +
                "BTC=" + BTC +
                ", LTC=" + LTC +
                ", BCH=" + BCH +
                '}';
    }
}
