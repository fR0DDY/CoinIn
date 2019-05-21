package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.COINDCX_ID;

public class CoinDCXResponse {
    @SerializedName("ask")
    String buyPrice;
    @SerializedName("bid")
    String sellPrice;
    @SerializedName("market")
    String market;

    public static List<ExchangeRate> getExchangeRates(List<CoinDCXResponse> coinDCXResponses, Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        Double btcBuy = 0.0, btcSell = 0.0;
        for (CoinDCXResponse response : coinDCXResponses) {
            if ("BTCINR".equalsIgnoreCase(response.market)) {
                btcBuy = Double.parseDouble(response.buyPrice);
                btcSell = Double.parseDouble(response.sellPrice);
            } else if ("USDTINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "USDT", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ETHINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "ETH", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XLMINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "XLM", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ADAINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "ADA", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XRPINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "XRP", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BNBINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "BNB", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXINR".equalsIgnoreCase(response.market)) {
                exchangeRates.add(new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BTCINR_insta".equalsIgnoreCase(response.market)) {
                btcBuy = Math.min(btcBuy, Double.parseDouble(response.buyPrice));
                btcSell = Math.max(Double.parseDouble(response.sellPrice), btcSell);
            }
        }
        exchangeRates.add(new ExchangeRate(COINDCX_ID, "BTC", date, btcBuy, btcSell));
        return exchangeRates;
    }

    public static Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(List<CoinDCXResponse> coinDCXResponses, Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> btcExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> bnbExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> ethExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> usdtExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> xrpExchangeRates = new HashMap<>();
        Double btcBuy = 0.0, btcSell = 0.0;
        for (CoinDCXResponse response : coinDCXResponses) {
            if ("BTCINR".equalsIgnoreCase(response.market)) {
                btcBuy = Double.parseDouble(response.buyPrice);
                btcSell = Double.parseDouble(response.sellPrice);
            } else if ("BTCINR_insta".equalsIgnoreCase(response.market)) {
                btcBuy = Math.min(btcBuy, Double.parseDouble(response.buyPrice));
                btcSell = Math.max(Double.parseDouble(response.sellPrice), btcSell);
            } else if ("USDTINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("USDT", new ExchangeRate(COINDCX_ID, "USDT", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ETHINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("ETH", new ExchangeRate(COINDCX_ID, "ETH", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XLMINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("XLM", new ExchangeRate(COINDCX_ID, "XLM", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ADAINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("ADA", new ExchangeRate(COINDCX_ID, "ADA", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XRPINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("XRP", new ExchangeRate(COINDCX_ID, "XRP", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BNBINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("BNB", new ExchangeRate(COINDCX_ID, "BNB", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXINR".equalsIgnoreCase(response.market)) {
                inrExchangeRates.put("TRX", new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ETHBTC".equalsIgnoreCase(response.market)) {
                btcExchangeRates.put("ETH", new ExchangeRate(COINDCX_ID, "ETH", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XLMBTC".equalsIgnoreCase(response.market)) {
                btcExchangeRates.put("XLM", new ExchangeRate(COINDCX_ID, "XLM", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ADABTC".equalsIgnoreCase(response.market)) {
                btcExchangeRates.put("ADA", new ExchangeRate(COINDCX_ID, "ADA", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XRPBTC".equalsIgnoreCase(response.market)) {
                btcExchangeRates.put("XRP", new ExchangeRate(COINDCX_ID, "XRP", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BNBBTC".equalsIgnoreCase(response.market)) {
                btcExchangeRates.put("BNB", new ExchangeRate(COINDCX_ID, "BNB", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXBTC".equalsIgnoreCase(response.market)) {
                btcExchangeRates.put("TRX", new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XLMBNB".equalsIgnoreCase(response.market)) {
                bnbExchangeRates.put("XLM", new ExchangeRate(COINDCX_ID, "XLM", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ADABNB".equalsIgnoreCase(response.market)) {
                bnbExchangeRates.put("ADA", new ExchangeRate(COINDCX_ID, "ADA", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XRPBNB".equalsIgnoreCase(response.market)) {
                bnbExchangeRates.put("XRP", new ExchangeRate(COINDCX_ID, "XRP", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXBNB".equalsIgnoreCase(response.market)) {
                bnbExchangeRates.put("TRX", new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XLMETH".equalsIgnoreCase(response.market)) {
                ethExchangeRates.put("XLM", new ExchangeRate(COINDCX_ID, "XLM", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ADAETH".equalsIgnoreCase(response.market)) {
                ethExchangeRates.put("ADA", new ExchangeRate(COINDCX_ID, "ADA", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XRPETH".equalsIgnoreCase(response.market)) {
                ethExchangeRates.put("XRP", new ExchangeRate(COINDCX_ID, "XRP", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BNBETH".equalsIgnoreCase(response.market)) {
                ethExchangeRates.put("BNB", new ExchangeRate(COINDCX_ID, "BNB", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXETH".equalsIgnoreCase(response.market)) {
                ethExchangeRates.put("TRX", new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BTCUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("BTC", new ExchangeRate(COINDCX_ID, "BTC", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ETHUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("ETH", new ExchangeRate(COINDCX_ID, "ETH", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XLMUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("XLM", new ExchangeRate(COINDCX_ID, "XLM", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("ADAUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("ADA", new ExchangeRate(COINDCX_ID, "ADA", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("XRPUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("XRP", new ExchangeRate(COINDCX_ID, "XRP", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("BNBUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("BNB", new ExchangeRate(COINDCX_ID, "BNB", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXUSDT".equalsIgnoreCase(response.market)) {
                usdtExchangeRates.put("TRX", new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            } else if ("TRXXRP".equalsIgnoreCase(response.market)) {
                xrpExchangeRates.put("TRX", new ExchangeRate(COINDCX_ID, "TRX", date, Double.parseDouble(response.buyPrice), Double.parseDouble(response.sellPrice)));
            }
        }
        inrExchangeRates.put("BTC", new ExchangeRate(COINDCX_ID, "BTC", date, btcBuy, btcSell));
        exchangeRates.put("INR", inrExchangeRates);
        exchangeRates.put("BTC", btcExchangeRates);
        exchangeRates.put("ETH", ethExchangeRates);
        exchangeRates.put("BNB", bnbExchangeRates);
        exchangeRates.put("USDT", usdtExchangeRates);
        exchangeRates.put("XRP", xrpExchangeRates);
        return exchangeRates;
    }
}
