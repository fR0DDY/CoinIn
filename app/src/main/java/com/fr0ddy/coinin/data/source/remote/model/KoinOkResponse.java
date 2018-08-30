package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            if (data.lowestAsk == null) data.lowestAsk = 0.0;
            if (data.highestBid == null) data.highestBid = 0.0;
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
            } else if ("GRS-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "GRS", date, data.lowestAsk, data.highestBid));
            } else if ("ICX-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "ICX", date, data.lowestAsk, data.highestBid));
            } else if ("KEY-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "KEY", date, data.lowestAsk, data.highestBid));
            } else if ("LWF-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "LWF", date, data.lowestAsk, data.highestBid));
            } else if ("NEO-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "NEO", date, data.lowestAsk, data.highestBid));
            } else if ("OMG-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "OMG", date, data.lowestAsk, data.highestBid));
            } else if ("RDD-INR".equalsIgnoreCase(data.market)) {
                exchangeRates.add(new ExchangeRate(KOINOK_ID, "RDD", date, data.lowestAsk, data.highestBid));
            } else if ("TRX-INR".equalsIgnoreCase(data.market)) {
                //exchangeRates.add(new ExchangeRate(KOINOK_ID, "TRX", date, data.lowestAsk, data.highestBid));
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

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();

        for (Data data : result) {
            if ("BTC-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("BTC", new ExchangeRate(KOINOK_ID, "BTC", date, data.lowestAsk, data.highestBid));
            } else if ("CAS-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("CAS", new ExchangeRate(KOINOK_ID, "CAS", date, data.lowestAsk, data.highestBid));
            } else if ("CVC-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("CVC", new ExchangeRate(KOINOK_ID, "CVC", date, data.lowestAsk, data.highestBid));
            } else if ("ETH-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("ETH", new ExchangeRate(KOINOK_ID, "ETH", date, data.lowestAsk, data.highestBid));
            } else if ("GAS-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("GAS", new ExchangeRate(KOINOK_ID, "GAS", date, data.lowestAsk, data.highestBid));
            } else if ("GRS-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("GRS", new ExchangeRate(KOINOK_ID, "GRS", date, data.lowestAsk, data.highestBid));
            } else if ("ICX-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("ICX", new ExchangeRate(KOINOK_ID, "ICX", date, data.lowestAsk, data.highestBid));
            } else if ("KEY-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("KEY", new ExchangeRate(KOINOK_ID, "KEY", date, data.lowestAsk, data.highestBid));
            } else if ("LWF-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("LWF", new ExchangeRate(KOINOK_ID, "LWF", date, data.lowestAsk, data.highestBid));
            } else if ("NEO-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("NEO", new ExchangeRate(KOINOK_ID, "NEO", date, data.lowestAsk, data.highestBid));
            } else if ("OMG-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("OMG", new ExchangeRate(KOINOK_ID, "OMG", date, data.lowestAsk, data.highestBid));
            } else if ("RDD-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("RDD", new ExchangeRate(KOINOK_ID, "RDD", date, data.lowestAsk, data.highestBid));
            } else if ("TRX-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("TRX", new ExchangeRate(KOINOK_ID, "TRX", date, data.lowestAsk, data.highestBid));
            } else if ("VEN-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("VEN", new ExchangeRate(KOINOK_ID, "VEN", date, data.lowestAsk, data.highestBid));
            } else if ("VIB-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("VIB", new ExchangeRate(KOINOK_ID, "VIB", date, data.lowestAsk, data.highestBid));
            } else if ("XDCE-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("XDCE", new ExchangeRate(KOINOK_ID, "XDCE", date, data.lowestAsk, data.highestBid));
            } else if ("XRP-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("XRP", new ExchangeRate(KOINOK_ID, "XRP", date, data.lowestAsk, data.highestBid));
            } else if ("ZIL-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("ZIL", new ExchangeRate(KOINOK_ID, "ZIL", date, data.lowestAsk, data.highestBid));
            } else if ("ZRX-INR".equalsIgnoreCase(data.market)) {
                inrExchangeRates.put("ZRX", new ExchangeRate(KOINOK_ID, "ZRX", date, data.lowestAsk, data.highestBid));
            } else if ("CAS-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("CAS", new ExchangeRate(KOINOK_ID, "CAS", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("CVC-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("CVC", new ExchangeRate(KOINOK_ID, "CVC", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("ETH-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("ETH", new ExchangeRate(KOINOK_ID, "ETH", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("GAS-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("GAS", new ExchangeRate(KOINOK_ID, "GAS", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("GRS-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("GRS", new ExchangeRate(KOINOK_ID, "GRS", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("ICX-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("ICX", new ExchangeRate(KOINOK_ID, "ICX", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("KEY-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("KEY", new ExchangeRate(KOINOK_ID, "KEY", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("LWF-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("LWF", new ExchangeRate(KOINOK_ID, "LWF", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("NEO-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("NEO", new ExchangeRate(KOINOK_ID, "NEO", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("OMG-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("OMG", new ExchangeRate(KOINOK_ID, "OMG", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("RDD-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("RDD", new ExchangeRate(KOINOK_ID, "RDD", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("TRX-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("TRX", new ExchangeRate(KOINOK_ID, "TRX", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("VEN-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("VEN", new ExchangeRate(KOINOK_ID, "VEN", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("VIB-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("VIB", new ExchangeRate(KOINOK_ID, "VIB", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("XDCE-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("XDCE", new ExchangeRate(KOINOK_ID, "XDCE", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("XRP-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("XRP", new ExchangeRate(KOINOK_ID, "XRP", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("ZIL-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("ZIL", new ExchangeRate(KOINOK_ID, "ZIL", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            } else if ("ZRX-BTC".equalsIgnoreCase(data.market)) {
                try {
                    bitcoinExchangeRates.put("ZRX", new ExchangeRate(KOINOK_ID, "ZRX", date, data.lowestAsk, data.highestBid));
                } catch (Exception e) {
                }
            }
        }


        exchangeRates.put("INR", inrExchangeRates);
        exchangeRates.put("BTC", bitcoinExchangeRates);

        return exchangeRates;
    }
}
