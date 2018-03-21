package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fr0ddy.coinin.utils.AppConstants.KOINEX_ID;

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
        Data OMG;
        Data REQ;
        Data ZRX;
        Data AE;
        Data BAT;
        Data GNT;
        Data TRX;
        Data XLM;
        Data NEO;
        Data GAS;
        Data AION;
        Data NCASH;

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

        public Data getOMG() {
            return OMG;
        }

        public Data getREQ() {
            return REQ;
        }

        public void setOMG(Data OMG) {
            this.OMG = OMG;
        }

        public void setREQ(Data REQ) {
            this.REQ = REQ;
        }

        public Data getZRX() {
            return ZRX;
        }

        public void setZRX(Data ZRX) {
            this.ZRX = ZRX;
        }

        public Data getAE() {
            return AE;
        }

        public void setAE(Data AE) {
            this.AE = AE;
        }

        public Data getBAT() {
            return BAT;
        }

        public void setBAT(Data BAT) {
            this.BAT = BAT;
        }

        public Data getGNT() {
            return GNT;
        }

        public void setGNT(Data GNT) {
            this.GNT = GNT;
        }

        public Data getTRX() {
            return TRX;
        }

        public void setTRX(Data TRX) {
            this.TRX = TRX;
        }

        public Data getXLM() {
            return XLM;
        }

        public void setXLM(Data XLM) {
            this.XLM = XLM;
        }

        public Data getNEO() {
            return NEO;
        }

        public void setNEO(Data NEO) {
            this.NEO = NEO;
        }

        public Data getGAS() {
            return GAS;
        }

        public void setGAS(Data GAS) {
            this.GAS = GAS;
        }

        public Data getAION() {
            return AION;
        }

        public void setAION(Data AION) {
            this.AION = AION;
        }

        public Data getNCASH() {
            return NCASH;
        }

        public void setNCASH(Data NCASH) {
            this.NCASH = NCASH;
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

    public List<ExchangeRate> getExchangeRates(Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        ExchangeRate koinexETHRate = new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(getStats().getETH().getLowestAsk()), Double.parseDouble(getStats().getETH().getHighestBid()));

        ExchangeRate koinexBTCRate = new ExchangeRate(KOINEX_ID, "BTC", date, Double.parseDouble(getStats().getBTC().getLowestAsk()), Double.parseDouble(getStats().getBTC().getHighestBid()));

        ExchangeRate koinexBCHRate = new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(getStats().getBCH().getLowestAsk()), Double.parseDouble(getStats().getBCH().getHighestBid()));

        ExchangeRate koinexLTCRate = new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(getStats().getLTC().getLowestAsk()), Double.parseDouble(getStats().getLTC().getHighestBid()));

        ExchangeRate koinexXRPRate = new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(getStats().getXRP().getLowestAsk()), Double.parseDouble(getStats().getXRP().getHighestBid()));

        ExchangeRate koinexOMGRate = new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(getStats().getOMG().getLowestAsk()), Double.parseDouble(getStats().getOMG().getHighestBid()));

        ExchangeRate koinexREQRate = new ExchangeRate(KOINEX_ID, "REQ", date, Double.parseDouble(getStats().getREQ().getLowestAsk()), Double.parseDouble(getStats().getREQ().getHighestBid()));

        ExchangeRate koinexZRXRate = new ExchangeRate(KOINEX_ID, "ZRX", date, Double.parseDouble(getStats().getZRX().getLowestAsk()), Double.parseDouble(getStats().getZRX().getHighestBid()));

        ExchangeRate koinexAERate = new ExchangeRate(KOINEX_ID, "AE", date, Double.parseDouble(getStats().getAE().getLowestAsk()), Double.parseDouble(getStats().getAE().getHighestBid()));

        ExchangeRate koinexBATRate = new ExchangeRate(KOINEX_ID, "BAT", date, Double.parseDouble(getStats().getBAT().getLowestAsk()), Double.parseDouble(getStats().getBAT().getHighestBid()));

        ExchangeRate koinexGNTRate = new ExchangeRate(KOINEX_ID, "GNT", date, Double.parseDouble(getStats().getGNT().getLowestAsk()), Double.parseDouble(getStats().getGNT().getHighestBid()));

        ExchangeRate koinexTRXRate = new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(getStats().getTRX().getLowestAsk()), Double.parseDouble(getStats().getTRX().getHighestBid()));

        ExchangeRate koinexXLMRate = new ExchangeRate(KOINEX_ID, "XLM", date, Double.parseDouble(getStats().getXLM().getLowestAsk()), Double.parseDouble(getStats().getXLM().getHighestBid()));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "AION", date, Double.parseDouble(getStats().getAION().getLowestAsk()), Double.parseDouble(getStats().getAION().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(getStats().getNCASH().getLowestAsk()), Double.parseDouble(getStats().getNCASH().getHighestBid())));


        exchangeRates.add(new ExchangeRate(KOINEX_ID, "NEO", date, Double.parseDouble(getStats().getNEO().getLowestAsk()), Double.parseDouble(getStats().getNEO().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "GAS", date, Double.parseDouble(getStats().getGAS().getLowestAsk()), Double.parseDouble(getStats().getGAS().getHighestBid())));

        exchangeRates.add(koinexETHRate);
        exchangeRates.add(koinexBTCRate);
        exchangeRates.add(koinexBCHRate);
        exchangeRates.add(koinexLTCRate);
        exchangeRates.add(koinexXRPRate);
        exchangeRates.add(koinexOMGRate);
        exchangeRates.add(koinexREQRate);
        exchangeRates.add(koinexZRXRate);
        exchangeRates.add(koinexAERate);
        exchangeRates.add(koinexBATRate);
        exchangeRates.add(koinexGNTRate);
        exchangeRates.add(koinexTRXRate);
        exchangeRates.add(koinexXLMRate);
        return exchangeRates;
    }
}
