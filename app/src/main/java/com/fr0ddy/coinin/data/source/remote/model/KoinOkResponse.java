package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.KOINOK_ID;

/**
 * Created by gaurav on 31/05/18.
 */

public class KoinOkResponse {
    List<Data> result;

    class Data {
        @SerializedName("marketSymbol")
        String market;
        @SerializedName("lowestAsk")
        Double lowestAsk;
        @SerializedName("highestBid")
        Double highestBid;
    }

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for (Data data : result) {
            if ("BTC-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "BTC", date, data.lowestAsk, data.highestBid));
            } else if ("CAS-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "CAS", date, data.lowestAsk, data.highestBid));
            } else if ("CVC-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "CVC", date, data.lowestAsk, data.highestBid));
            } else if ("ETH-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "ETH", date, data.lowestAsk, data.highestBid));
            } else if ("GAS-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "GAS", date, data.lowestAsk, data.highestBid));
            } else if ("ICX-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "ICX", date, data.lowestAsk, data.highestBid));
            } else if ("ENO-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "NEO", date, data.lowestAsk, data.highestBid));
            } else if ("OMG-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "OMG", date, data.lowestAsk, data.highestBid));
            } else if ("RDD-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "RDD", date, data.lowestAsk, data.highestBid));
            } else if ("TRX-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "TRX", date, data.lowestAsk, data.highestBid));
            } else if ("VEN-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "VEN", date, data.lowestAsk, data.highestBid));
            } else if ("VIB-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "VIB", date, data.lowestAsk, data.highestBid));
            } else if ("XDCE-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "XDCE", date, data.lowestAsk, data.highestBid));
            } else if ("XRP-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "XRP", date, data.lowestAsk, data.highestBid));
            } else if ("ZIL-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "ZIL", date, data.lowestAsk, data.highestBid));
            } else if ("ZRX-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "ZRX", date, data.lowestAsk, data.highestBid));
            }
        }
        return exchangeRates;
    }
}
