package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.UNOCOIN_ID;

/**
 * Created by gaurav on 02/04/18.
 */

public class UnocoinResponse {

    Stats stats;

    public class Stats {

        Currency inr;
        Currency btc;
        Currency eth;
        Currency xrp;

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

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        inrExchangeRates.put("BTC", new ExchangeRate(UNOCOIN_ID, "BTC", date, Double.parseDouble(stats.inr.BTC.getLowestAsk()), Double.parseDouble(stats.inr.BTC.getHighestBid())));
        inrExchangeRates.put("LTC", new ExchangeRate(UNOCOIN_ID, "LTC", date, Double.parseDouble(stats.inr.LTC.getLowestAsk()), Double.parseDouble(stats.inr.LTC.getHighestBid())));
        inrExchangeRates.put("BCH", new ExchangeRate(UNOCOIN_ID, "BCH", date, Double.parseDouble(stats.inr.BCH.getLowestAsk()), Double.parseDouble(stats.inr.BCH.getHighestBid())));
        inrExchangeRates.put("XRP", new ExchangeRate(UNOCOIN_ID, "XRP", date, Double.parseDouble(stats.inr.XRP.getLowestAsk()), Double.parseDouble(stats.inr.XRP.getHighestBid())));
        inrExchangeRates.put("ETH", new ExchangeRate(UNOCOIN_ID, "ETH", date, Double.parseDouble(stats.inr.ETH.getLowestAsk()), Double.parseDouble(stats.inr.ETH.getHighestBid())));
        inrExchangeRates.put("BTG", new ExchangeRate(UNOCOIN_ID, "BTG", date, Double.parseDouble(stats.inr.BTG.getLowestAsk()), Double.parseDouble(stats.inr.BTG.getHighestBid())));
        inrExchangeRates.put("BAT", new ExchangeRate(UNOCOIN_ID, "BAT", date, Double.parseDouble(stats.inr.BAT.getLowestAsk()), Double.parseDouble(stats.inr.BAT.getHighestBid())));
        inrExchangeRates.put("BRD", new ExchangeRate(UNOCOIN_ID, "BRD", date, Double.parseDouble(stats.inr.BRD.getLowestAsk()), Double.parseDouble(stats.inr.BRD.getHighestBid())));
        inrExchangeRates.put("FUN", new ExchangeRate(UNOCOIN_ID, "FUN", date, Double.parseDouble(stats.inr.FUN.getLowestAsk()), Double.parseDouble(stats.inr.FUN.getHighestBid())));
        inrExchangeRates.put("GNT", new ExchangeRate(UNOCOIN_ID, "GNT", date, Double.parseDouble(stats.inr.GNT.getLowestAsk()), Double.parseDouble(stats.inr.GNT.getHighestBid())));
        inrExchangeRates.put("ZIL", new ExchangeRate(UNOCOIN_ID, "ZIL", date, Double.parseDouble(stats.inr.ZIL.getLowestAsk()), Double.parseDouble(stats.inr.ZIL.getHighestBid())));
        inrExchangeRates.put("CVC", new ExchangeRate(UNOCOIN_ID, "CVC", date, Double.parseDouble(stats.inr.CVC.getLowestAsk()), Double.parseDouble(stats.inr.CVC.getHighestBid())));
        inrExchangeRates.put("REP", new ExchangeRate(UNOCOIN_ID, "REP", date, Double.parseDouble(stats.inr.REP.getLowestAsk()), Double.parseDouble(stats.inr.REP.getHighestBid())));
        inrExchangeRates.put("ZRX", new ExchangeRate(UNOCOIN_ID, "ZRX", date, Double.parseDouble(stats.inr.ZRX.getLowestAsk()), Double.parseDouble(stats.inr.ZRX.getHighestBid())));
        inrExchangeRates.put("OMG", new ExchangeRate(UNOCOIN_ID, "OMG", date, Double.parseDouble(stats.inr.OMG.getLowestAsk()), Double.parseDouble(stats.inr.OMG.getHighestBid())));
        inrExchangeRates.put("KNC", new ExchangeRate(UNOCOIN_ID, "KNC", date, Double.parseDouble(stats.inr.KNC.getLowestAsk()), Double.parseDouble(stats.inr.KNC.getHighestBid())));
        inrExchangeRates.put("RDN", new ExchangeRate(UNOCOIN_ID, "RDN", date, Double.parseDouble(stats.inr.RDN.getLowestAsk()), Double.parseDouble(stats.inr.RDN.getHighestBid())));
        inrExchangeRates.put("NMR", new ExchangeRate(UNOCOIN_ID, "NMR", date, Double.parseDouble(stats.inr.NMR.getLowestAsk()), Double.parseDouble(stats.inr.NMR.getHighestBid())));
        inrExchangeRates.put("PAY", new ExchangeRate(UNOCOIN_ID, "PAY", date, Double.parseDouble(stats.inr.PAY.getLowestAsk()), Double.parseDouble(stats.inr.PAY.getHighestBid())));
        inrExchangeRates.put("QRL", new ExchangeRate(UNOCOIN_ID, "QRL", date, Double.parseDouble(stats.inr.QRL.getLowestAsk()), Double.parseDouble(stats.inr.QRL.getHighestBid())));
        inrExchangeRates.put("WAX", new ExchangeRate(UNOCOIN_ID, "WAX", date, Double.parseDouble(stats.inr.WAX.getLowestAsk()), Double.parseDouble(stats.inr.WAX.getHighestBid())));
        exchangeRates.put("INR", inrExchangeRates);

        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        try {
            bitcoinExchangeRates.put("BCH", new ExchangeRate(UNOCOIN_ID, "BCH", date, Double.parseDouble(stats.btc.BCH.getLowestAsk()), Double.parseDouble(stats.btc.BCH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("LTC", new ExchangeRate(UNOCOIN_ID, "LTC", date, Double.parseDouble(stats.btc.LTC.getLowestAsk()), Double.parseDouble(stats.btc.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("ETH", new ExchangeRate(UNOCOIN_ID, "ETH", date, Double.parseDouble(stats.btc.ETH.getLowestAsk()), Double.parseDouble(stats.btc.ETH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("XRP", new ExchangeRate(UNOCOIN_ID, "XRP", date, Double.parseDouble(stats.btc.XRP.getLowestAsk()), Double.parseDouble(stats.btc.XRP.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("BTG", new ExchangeRate(UNOCOIN_ID, "BTG", date, Double.parseDouble(stats.btc.BTG.getLowestAsk()), Double.parseDouble(stats.btc.BTG.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("GNT", new ExchangeRate(UNOCOIN_ID, "GNT", date, Double.parseDouble(stats.btc.GNT.getLowestAsk()), Double.parseDouble(stats.btc.GNT.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("CVC", new ExchangeRate(UNOCOIN_ID, "CVC", date, Double.parseDouble(stats.btc.CVC.getLowestAsk()), Double.parseDouble(stats.btc.CVC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("ZRX", new ExchangeRate(UNOCOIN_ID, "ZRX", date, Double.parseDouble(stats.btc.ZRX.getLowestAsk()), Double.parseDouble(stats.btc.ZRX.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("OMG", new ExchangeRate(UNOCOIN_ID, "OMG", date, Double.parseDouble(stats.btc.OMG.getLowestAsk()), Double.parseDouble(stats.btc.OMG.getHighestBid())));
        } catch (Exception e) {
        }
        exchangeRates.put("BTC", bitcoinExchangeRates);

        Map<String, ExchangeRate> etherExchangeRates = new HashMap<>();
        try {
            etherExchangeRates.put("BCH", new ExchangeRate(UNOCOIN_ID, "BCH", date, Double.parseDouble(stats.eth.BCH.getLowestAsk()), Double.parseDouble(stats.eth.BCH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("LTC", new ExchangeRate(UNOCOIN_ID, "LTC", date, Double.parseDouble(stats.eth.LTC.getLowestAsk()), Double.parseDouble(stats.eth.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("XRP", new ExchangeRate(UNOCOIN_ID, "XRP", date, Double.parseDouble(stats.eth.XRP.getLowestAsk()), Double.parseDouble(stats.eth.XRP.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("BTG", new ExchangeRate(UNOCOIN_ID, "BTG", date, Double.parseDouble(stats.eth.BTG.getLowestAsk()), Double.parseDouble(stats.eth.BTG.getHighestBid())));
        } catch (Exception e) {
        }

        exchangeRates.put("ETH", etherExchangeRates);

        Map<String, ExchangeRate> rippleExchangeRates = new HashMap<>();
        try {
            rippleExchangeRates.put("LTC", new ExchangeRate(UNOCOIN_ID, "LTC", date, Double.parseDouble(stats.xrp.LTC.getLowestAsk()), Double.parseDouble(stats.xrp.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("BTG", new ExchangeRate(UNOCOIN_ID, "BTG", date, Double.parseDouble(stats.xrp.BTG.getLowestAsk()), Double.parseDouble(stats.xrp.BTG.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("FUN", new ExchangeRate(UNOCOIN_ID, "FUN", date, Double.parseDouble(stats.xrp.FUN.getLowestAsk()), Double.parseDouble(stats.xrp.FUN.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("ZIL", new ExchangeRate(UNOCOIN_ID, "ZIL", date, Double.parseDouble(stats.xrp.ZIL.getLowestAsk()), Double.parseDouble(stats.xrp.ZIL.getHighestBid())));
        } catch (Exception e) {
        }
        exchangeRates.put("XRP", rippleExchangeRates);

        return exchangeRates;
    }
}
