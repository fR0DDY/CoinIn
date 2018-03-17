package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.THROUGHBIT_ID;

/**
 * Created by gaurav on 22/02/18.
 */

public class ThroughbitResponse {

    List<Data> data;

    public class Data {
        @SerializedName("crypto")
        String crypto;
        @SerializedName("buy_price")
        String buyPrice;
        @SerializedName("sell_price")
        String sellPrice;

        public String getCrypto() {
            return crypto;
        }

        public void setCrypto(String crypto) {
            this.crypto = crypto;
        }

        public String getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(String buyPrice) {
            this.buyPrice = buyPrice;
        }

        public String getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(String sellPrice) {
            this.sellPrice = sellPrice;
        }
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for (Data data : getData()) {
            if ("BTC".equalsIgnoreCase(data.getCrypto())) {
                ExchangeRate rate = new ExchangeRate(THROUGHBIT_ID, "BTC", date, Double.parseDouble(data.getBuyPrice()), Double.parseDouble(data.getSellPrice()));
                exchangeRates.add(rate);
            } else if ("ETH".equalsIgnoreCase(data.getCrypto())) {
                ExchangeRate rate = new ExchangeRate(THROUGHBIT_ID, "ETH", date, Double.parseDouble(data.getBuyPrice()), Double.parseDouble(data.getSellPrice()));
                exchangeRates.add(rate);
            }
        }
        return exchangeRates;
    }
}
