package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurav on 25/11/17.
 */

public class KoinexResponse {

    Stats stats;

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public class Stats {
        Data ETH;
        Data BTC;
        Data LTC;
        Data XRP;
        Data BCH;

        public Data getETH() {
            return ETH;
        }

        public void setETH(Data ETH) {
            this.ETH = ETH;
        }

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

        public Data getXRP() {
            return XRP;
        }

        public void setXRP(Data XRP) {
            this.XRP = XRP;
        }

        public Data getBCH() {
            return BCH;
        }

        public void setBCH(Data BCH) {
            this.BCH = BCH;
        }

        @Override
        public String toString() {
            return "Stats{" +
                    "ETH=" + ETH +
                    ", BTC=" + BTC +
                    ", LTC=" + LTC +
                    ", XRP=" + XRP +
                    ", BCH=" + BCH +
                    '}';
        }
    }

    public class Data {
        @SerializedName("last_traded_price")
        String lastTradedPrice;
        @SerializedName("lowest_ask")
        String lowestAsk;
        @SerializedName("highest_bid")
        String highestBid;
        @SerializedName("min_24hrs")
        String min24Hrs;
        @SerializedName("max_24hrs")
        String max24Hrs;
        @SerializedName("vol_24hrs")
        String volume24Hrs;

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

        public String getMin24Hrs() {
            return min24Hrs;
        }

        public void setMin24Hrs(String min24Hrs) {
            this.min24Hrs = min24Hrs;
        }

        public String getMax24Hrs() {
            return max24Hrs;
        }

        public void setMax24Hrs(String max24Hrs) {
            this.max24Hrs = max24Hrs;
        }

        public String getVolume24Hrs() {
            return volume24Hrs;
        }

        public void setVolume24Hrs(String volume24Hrs) {
            this.volume24Hrs = volume24Hrs;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "lastTradedPrice='" + lastTradedPrice + '\'' +
                    ", lowestAsk='" + lowestAsk + '\'' +
                    ", highestBid='" + highestBid + '\'' +
                    ", min24Hrs='" + min24Hrs + '\'' +
                    ", max24Hrs='" + max24Hrs + '\'' +
                    ", volume24Hrs='" + volume24Hrs + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "KoinexResponse{" +
                "stats=" + stats +
                '}';
    }
}
