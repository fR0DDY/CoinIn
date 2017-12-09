package com.fr0ddy.coinin.data.source.remote.model;

import java.util.List;

/**
 * Created by gaurav on 03/12/17.
 */

public class BitfinexResponse {
    List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BitfinexResponse{" +
                "data=" + data +
                '}';
    }

    public class Data {
        String symbol;
        double bid, bidSize, ask, askSize, dailyChange, dailyChangePercentage, lastPrice, volume, high, low;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public double getBid() {
            return bid;
        }

        public void setBid(double bid) {
            this.bid = bid;
        }

        public double getBidSize() {
            return bidSize;
        }

        public void setBidSize(double bidSize) {
            this.bidSize = bidSize;
        }

        public double getAsk() {
            return ask;
        }

        public void setAsk(double ask) {
            this.ask = ask;
        }

        public double getAskSize() {
            return askSize;
        }

        public void setAskSize(double askSize) {
            this.askSize = askSize;
        }

        public double getDailyChange() {
            return dailyChange;
        }

        public void setDailyChange(double dailyChange) {
            this.dailyChange = dailyChange;
        }

        public double getDailyChangePercentage() {
            return dailyChangePercentage;
        }

        public void setDailyChangePercentage(double dailyChangePercentage) {
            this.dailyChangePercentage = dailyChangePercentage;
        }

        public double getLastPrice() {
            return lastPrice;
        }

        public void setLastPrice(double lastPrice) {
            this.lastPrice = lastPrice;
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(double volume) {
            this.volume = volume;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "symbol='" + symbol + '\'' +
                    ", bid=" + bid +
                    ", bidSize=" + bidSize +
                    ", ask=" + ask +
                    ", askSize=" + askSize +
                    ", dailyChange=" + dailyChange +
                    ", dailyChangePercentage=" + dailyChangePercentage +
                    ", lastPrice=" + lastPrice +
                    ", volume=" + volume +
                    ", high=" + high +
                    ", low=" + low +
                    '}';
        }
    }
}
