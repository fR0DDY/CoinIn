package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.COINDELTA_ID;

/**
 * Created by gaurav on 26/12/17.
 */

public class CoindeltaResponse {
    @SerializedName("Ask")
    Double lowestAsk;
    @SerializedName("Bid")
    Double highestBid;
    @SerializedName("MarketName")
    String marketName;

    public Double getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(Double lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public static List<ExchangeRate> getExchangeRates(List<CoindeltaResponse> coindeltaResponse, Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for (CoindeltaResponse data : coindeltaResponse) {
            if ("btc-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "BTC", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("eth-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ETH", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("ltc-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "LTC", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("bch-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "BCH", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("xrp-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "XRP", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("qtum-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "QTUM", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("omg-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "OMG", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("zil-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ZIL", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("zrx-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ZRX", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("knc-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "KNC", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("eos-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "EOS", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("zec-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ZEC", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("neo-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "NEO", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("gas-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "GAS", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("aion-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "AION", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("bat-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "BAT", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("cnd-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "CND", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("cvc-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "CVC", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("mana-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "MANA", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("eng-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ENG", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("gnt-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "GNT", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("icx-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ICX", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("spank-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "SPANK", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("trx-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "TRX", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("act-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "ACT", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("dai-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "DAI", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("qkc-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "QKC", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("krm-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "KRM", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("ae-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "AE", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("ten-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "TEN", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("stx-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "STX", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            } else if ("hst-inr".equalsIgnoreCase(data.getMarketName())) {
                ExchangeRate rate = new ExchangeRate(COINDELTA_ID, "HST", date, data.getLowestAsk(), data.getHighestBid());
                exchangeRates.add(rate);
            }
        }
        return  exchangeRates;
    }

    public static Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(List<CoindeltaResponse> coindeltaResponse, Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        for (CoindeltaResponse data : coindeltaResponse) {
            if ("btc-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("BTC", new ExchangeRate(COINDELTA_ID, "BTC", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("eth-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("ETH", new ExchangeRate(COINDELTA_ID, "ETH", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("ltc-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("LTC", new ExchangeRate(COINDELTA_ID, "LTC", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("xrp-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("XRP", new ExchangeRate(COINDELTA_ID, "XRP", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("qtum-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("QTUM", new ExchangeRate(COINDELTA_ID, "QTUM", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("omg-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("OMG", new ExchangeRate(COINDELTA_ID, "OMG", date, data.getLowestAsk(), data.getHighestBid()));
            }  else if ("ten-inr".equalsIgnoreCase(data.getMarketName())) {
                inrExchangeRates.put("TEN", new ExchangeRate(COINDELTA_ID, "TEN", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("eth-btc".equalsIgnoreCase(data.getMarketName())) {
                bitcoinExchangeRates.put("ETH", new ExchangeRate(COINDELTA_ID, "ETH", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("ltc-btc".equalsIgnoreCase(data.getMarketName())) {
                bitcoinExchangeRates.put("LTC", new ExchangeRate(COINDELTA_ID, "LTC", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("omg-btc".equalsIgnoreCase(data.getMarketName())) {
                bitcoinExchangeRates.put("OMG", new ExchangeRate(COINDELTA_ID, "OMG", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("qtum-btc".equalsIgnoreCase(data.getMarketName())) {
                bitcoinExchangeRates.put("QTUM", new ExchangeRate(COINDELTA_ID, "QTUM", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("xrp-btc".equalsIgnoreCase(data.getMarketName())) {
                bitcoinExchangeRates.put("XRP", new ExchangeRate(COINDELTA_ID, "XRP", date, data.getLowestAsk(), data.getHighestBid()));
            } else if ("ten-btc".equalsIgnoreCase(data.getMarketName())) {
                bitcoinExchangeRates.put("TEN", new ExchangeRate(COINDELTA_ID, "TEN", date, data.getLowestAsk(), data.getHighestBid()));
            }
        }
        exchangeRates.put("INR", inrExchangeRates);
        exchangeRates.put("BTC", bitcoinExchangeRates);
        return exchangeRates;
    }
}
