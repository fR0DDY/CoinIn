package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        BaseCurrency inr;
        BaseCurrency bitcoin;
        BaseCurrency ether;
        BaseCurrency ripple;
        BaseCurrency true_usd;

        public class BaseCurrency {
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
            //Data AION;
            Data NCASH;
            Data EOS;
            Data ONT;
            Data ZIL;
            Data IOST;
            Data ZCO;
            Data POLY;
            Data ELF;
            Data SNT;
            Data REP;
            Data QKC;
            Data TUSD;
            Data BCHABC;
            Data BTT;
            Data MANA;
            Data USDT;

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

            public Data getNCASH() {
                return NCASH;
            }

            public void setNCASH(Data NCASH) {
                this.NCASH = NCASH;
            }

            public Data getEOS() {
                return EOS;
            }

            public void setEOS(Data EOS) {
                this.EOS = EOS;
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
        ExchangeRate koinexETHRate = new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(stats.inr.getETH().getLowestAsk()), Double.parseDouble(stats.inr.getETH().getHighestBid()));

        ExchangeRate koinexBTCRate = new ExchangeRate(KOINEX_ID, "BTC", date, Double.parseDouble(stats.inr.getBTC().getLowestAsk()), Double.parseDouble(stats.inr.getBTC().getHighestBid()));

        //ExchangeRate koinexBCHRate = new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(stats.inr.getBCH().getLowestAsk()), Double.parseDouble(stats.inr.getBCH().getHighestBid()));

        ExchangeRate koinexLTCRate = new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(stats.inr.getLTC().getLowestAsk()), Double.parseDouble(stats.inr.getLTC().getHighestBid()));

        ExchangeRate koinexXRPRate = new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(stats.inr.getXRP().getLowestAsk()), Double.parseDouble(stats.inr.getXRP().getHighestBid()));

        ExchangeRate koinexOMGRate = new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(stats.inr.getOMG().getLowestAsk()), Double.parseDouble(stats.inr.getOMG().getHighestBid()));

        ExchangeRate koinexREQRate = new ExchangeRate(KOINEX_ID, "REQ", date, Double.parseDouble(stats.inr.getREQ().getLowestAsk()), Double.parseDouble(stats.inr.getREQ().getHighestBid()));

        ExchangeRate koinexZRXRate = new ExchangeRate(KOINEX_ID, "ZRX", date, Double.parseDouble(stats.inr.getZRX().getLowestAsk()), Double.parseDouble(stats.inr.getZRX().getHighestBid()));

        ExchangeRate koinexAERate = new ExchangeRate(KOINEX_ID, "AE", date, Double.parseDouble(stats.inr.getAE().getLowestAsk()), Double.parseDouble(stats.inr.getAE().getHighestBid()));

        ExchangeRate koinexBATRate = new ExchangeRate(KOINEX_ID, "BAT", date, Double.parseDouble(stats.inr.getBAT().getLowestAsk()), Double.parseDouble(stats.inr.getBAT().getHighestBid()));

        ExchangeRate koinexGNTRate = new ExchangeRate(KOINEX_ID, "GNT", date, Double.parseDouble(stats.inr.getGNT().getLowestAsk()), Double.parseDouble(stats.inr.getGNT().getHighestBid()));

        ExchangeRate koinexTRXRate = new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(stats.inr.getTRX().getLowestAsk()), Double.parseDouble(stats.inr.getTRX().getHighestBid()));

        ExchangeRate koinexXLMRate = new ExchangeRate(KOINEX_ID, "XLM", date, Double.parseDouble(stats.inr.getXLM().getLowestAsk()), Double.parseDouble(stats.inr.getXLM().getHighestBid()));

        //exchangeRates.add(new ExchangeRate(KOINEX_ID, "AION", date, Double.parseDouble(stats.inr.getAION().getLowestAsk()), Double.parseDouble(stats.inr.getAION().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(stats.inr.getNCASH().getLowestAsk()), Double.parseDouble(stats.inr.getNCASH().getHighestBid())));


        exchangeRates.add(new ExchangeRate(KOINEX_ID, "EOS", date, Double.parseDouble(stats.inr.getEOS().getLowestAsk()), Double.parseDouble(stats.inr.getEOS().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "ONT", date, Double.parseDouble(stats.inr.ONT.getLowestAsk()), Double.parseDouble(stats.inr.ONT.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "ZIL", date, Double.parseDouble(stats.inr.ZIL.getLowestAsk()), Double.parseDouble(stats.inr.ZIL.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "IOST", date, Double.parseDouble(stats.inr.IOST.getLowestAsk()), Double.parseDouble(stats.inr.IOST.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "ZCO", date, Double.parseDouble(stats.inr.ZCO.getLowestAsk()), Double.parseDouble(stats.inr.ZCO.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "POLY", date, Double.parseDouble(stats.inr.POLY.getLowestAsk()), Double.parseDouble(stats.inr.POLY.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "AELF", date, Double.parseDouble(stats.inr.ELF.getLowestAsk()), Double.parseDouble(stats.inr.ELF.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "SNT", date, Double.parseDouble(stats.inr.SNT.getLowestAsk()), Double.parseDouble(stats.inr.SNT.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "REP", date, Double.parseDouble(stats.inr.REP.getLowestAsk()), Double.parseDouble(stats.inr.REP.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "QKC", date, Double.parseDouble(stats.inr.QKC.getLowestAsk()), Double.parseDouble(stats.inr.QKC.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "TUSD", date, Double.parseDouble(stats.inr.TUSD.getLowestAsk()), Double.parseDouble(stats.inr.TUSD.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "BCHABC", date, Double.parseDouble(stats.inr.BCHABC.getLowestAsk()), Double.parseDouble(stats.inr.BCHABC.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "BTT", date, Double.parseDouble(stats.inr.BTT.getLowestAsk()), Double.parseDouble(stats.inr.BTT.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "MANA", date, Double.parseDouble(stats.inr.MANA.getLowestAsk()), Double.parseDouble(stats.inr.MANA.getHighestBid())));

        exchangeRates.add(koinexETHRate);
        exchangeRates.add(koinexBTCRate);
        //exchangeRates.add(koinexBCHRate);
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

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        //inrExchangeRates.put("BCH", new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(stats.inr.BCH.getLowestAsk()), Double.parseDouble(stats.inr.BCH.getHighestBid())));
        inrExchangeRates.put("LTC", new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(stats.inr.LTC.getLowestAsk()), Double.parseDouble(stats.inr.LTC.getHighestBid())));
        inrExchangeRates.put("XRP", new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(stats.inr.XRP.getLowestAsk()), Double.parseDouble(stats.inr.XRP.getHighestBid())));
        inrExchangeRates.put("BTC", new ExchangeRate(KOINEX_ID, "BTC", date, Double.parseDouble(stats.inr.BTC.getLowestAsk()), Double.parseDouble(stats.inr.BTC.getHighestBid())));
        inrExchangeRates.put("ETH", new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(stats.inr.ETH.getLowestAsk()), Double.parseDouble(stats.inr.ETH.getHighestBid())));
        inrExchangeRates.put("OMG", new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(stats.inr.OMG.getLowestAsk()), Double.parseDouble(stats.inr.OMG.getHighestBid())));
        inrExchangeRates.put("REQ", new ExchangeRate(KOINEX_ID, "REQ", date, Double.parseDouble(stats.inr.REQ.getLowestAsk()), Double.parseDouble(stats.inr.REQ.getHighestBid())));
        inrExchangeRates.put("TRX", new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(stats.inr.TRX.getLowestAsk()), Double.parseDouble(stats.inr.TRX.getHighestBid())));
        inrExchangeRates.put("NCASH", new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(stats.inr.NCASH.getLowestAsk()), Double.parseDouble(stats.inr.NCASH.getHighestBid())));
        inrExchangeRates.put("EOS", new ExchangeRate(KOINEX_ID, "EOS", date, Double.parseDouble(stats.inr.EOS.getLowestAsk()), Double.parseDouble(stats.inr.EOS.getHighestBid())));
        inrExchangeRates.put("AE", new ExchangeRate(KOINEX_ID, "AE", date, Double.parseDouble(stats.inr.AE.getLowestAsk()), Double.parseDouble(stats.inr.AE.getHighestBid())));
        inrExchangeRates.put("GNT", new ExchangeRate(KOINEX_ID, "GNT", date, Double.parseDouble(stats.inr.GNT.getLowestAsk()), Double.parseDouble(stats.inr.GNT.getHighestBid())));
        inrExchangeRates.put("ONT", new ExchangeRate(KOINEX_ID, "ONT", date, Double.parseDouble(stats.inr.ONT.getLowestAsk()), Double.parseDouble(stats.inr.ONT.getHighestBid())));
        inrExchangeRates.put("ZIL", new ExchangeRate(KOINEX_ID, "ZIL", date, Double.parseDouble(stats.inr.ZIL.getLowestAsk()), Double.parseDouble(stats.inr.ZIL.getHighestBid())));
        inrExchangeRates.put("IOST", new ExchangeRate(KOINEX_ID, "IOST", date, Double.parseDouble(stats.inr.IOST.getLowestAsk()), Double.parseDouble(stats.inr.IOST.getHighestBid())));
        inrExchangeRates.put("ZCO", new ExchangeRate(KOINEX_ID, "ZCO", date, Double.parseDouble(stats.inr.ZCO.getLowestAsk()), Double.parseDouble(stats.inr.ZCO.getHighestBid())));
        inrExchangeRates.put("POLY", new ExchangeRate(KOINEX_ID, "POLY", date, Double.parseDouble(stats.inr.POLY.getLowestAsk()), Double.parseDouble(stats.inr.POLY.getHighestBid())));
        inrExchangeRates.put("AELF", new ExchangeRate(KOINEX_ID, "AELF", date, Double.parseDouble(stats.inr.ELF.getLowestAsk()), Double.parseDouble(stats.inr.ELF.getHighestBid())));
        inrExchangeRates.put("SNT", new ExchangeRate(KOINEX_ID, "SNT", date, Double.parseDouble(stats.inr.SNT.getLowestAsk()), Double.parseDouble(stats.inr.SNT.getHighestBid())));
        inrExchangeRates.put("REP", new ExchangeRate(KOINEX_ID, "REP", date, Double.parseDouble(stats.inr.REP.getLowestAsk()), Double.parseDouble(stats.inr.REP.getHighestBid())));
        inrExchangeRates.put("QKC", new ExchangeRate(KOINEX_ID, "QKC", date, Double.parseDouble(stats.inr.QKC.getLowestAsk()), Double.parseDouble(stats.inr.QKC.getHighestBid())));
        inrExchangeRates.put("TUSD", new ExchangeRate(KOINEX_ID, "TUSD", date, Double.parseDouble(stats.inr.TUSD.getLowestAsk()), Double.parseDouble(stats.inr.TUSD.getHighestBid())));
        inrExchangeRates.put("BCHABC", new ExchangeRate(KOINEX_ID, "BCHABC", date, Double.parseDouble(stats.inr.BCHABC.getLowestAsk()), Double.parseDouble(stats.inr.BCHABC.getHighestBid())));
        inrExchangeRates.put("ZRX", new ExchangeRate(KOINEX_ID, "ZRX", date, Double.parseDouble(stats.inr.ZRX.getLowestAsk()), Double.parseDouble(stats.inr.ZRX.getHighestBid())));
        inrExchangeRates.put("XLM", new ExchangeRate(KOINEX_ID, "XLM", date, Double.parseDouble(stats.inr.XLM.getLowestAsk()), Double.parseDouble(stats.inr.XLM.getHighestBid())));
        inrExchangeRates.put("BTT", new ExchangeRate(KOINEX_ID, "BTT", date, Double.parseDouble(stats.inr.BTT.getLowestAsk()), Double.parseDouble(stats.inr.BTT.getHighestBid())));
        exchangeRates.put("INR", inrExchangeRates);

        Map<String, ExchangeRate> tusdExchangeRates = new HashMap<>();
        try {
            tusdExchangeRates.put("ZRX", new ExchangeRate(KOINEX_ID, "ZRX", date, Double.parseDouble(stats.true_usd.ZRX.getLowestAsk()), Double.parseDouble(stats.true_usd.ZRX.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("XRP", new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(stats.true_usd.XRP.getLowestAsk()), Double.parseDouble(stats.true_usd.XRP.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("TRX", new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(stats.true_usd.TRX.getLowestAsk()), Double.parseDouble(stats.true_usd.TRX.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("BTC", new ExchangeRate(KOINEX_ID, "BTC", date, Double.parseDouble(stats.true_usd.BTC.getLowestAsk()), Double.parseDouble(stats.true_usd.BTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("ETH", new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(stats.true_usd.ETH.getLowestAsk()), Double.parseDouble(stats.true_usd.ETH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("NCASH", new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(stats.true_usd.NCASH.getLowestAsk()), Double.parseDouble(stats.true_usd.NCASH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("BCHABC", new ExchangeRate(KOINEX_ID, "BCHABC", date, Double.parseDouble(stats.true_usd.BCHABC.getLowestAsk()), Double.parseDouble(stats.true_usd.BCHABC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("LTC", new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(stats.true_usd.LTC.getLowestAsk()), Double.parseDouble(stats.true_usd.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("ZIL", new ExchangeRate(KOINEX_ID, "ZIL", date, Double.parseDouble(stats.true_usd.ZIL.getLowestAsk()), Double.parseDouble(stats.true_usd.ZIL.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("XLM", new ExchangeRate(KOINEX_ID, "XLM", date, Double.parseDouble(stats.true_usd.XLM.getLowestAsk()), Double.parseDouble(stats.true_usd.XLM.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            tusdExchangeRates.put("BTT", new ExchangeRate(KOINEX_ID, "BTT", date, Double.parseDouble(stats.true_usd.BTT.getLowestAsk()), Double.parseDouble(stats.true_usd.BTT.getHighestBid())));
        } catch (Exception e) {
        }
        exchangeRates.put("TUSD", tusdExchangeRates);

        return exchangeRates;
    }
}
