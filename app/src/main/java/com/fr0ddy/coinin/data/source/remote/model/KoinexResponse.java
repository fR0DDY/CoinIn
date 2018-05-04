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
            Data NEO;
            Data GAS;
            Data AION;
            Data NCASH;
            Data EOS;
            Data XRB;
            Data ONT;
            Data ZIL;
            Data IOST;

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

            public Data getEOS() {
                return EOS;
            }

            public void setEOS(Data EOS) {
                this.EOS = EOS;
            }

            public Data getXRB() {
                return XRB;
            }

            public void setXRB(Data XRB) {
                this.XRB = XRB;
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

        ExchangeRate koinexBCHRate = new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(stats.inr.getBCH().getLowestAsk()), Double.parseDouble(stats.inr.getBCH().getHighestBid()));

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

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "AION", date, Double.parseDouble(stats.inr.getAION().getLowestAsk()), Double.parseDouble(stats.inr.getAION().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(stats.inr.getNCASH().getLowestAsk()), Double.parseDouble(stats.inr.getNCASH().getHighestBid())));


        exchangeRates.add(new ExchangeRate(KOINEX_ID, "NEO", date, Double.parseDouble(stats.inr.getNEO().getLowestAsk()), Double.parseDouble(stats.inr.getNEO().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "GAS", date, Double.parseDouble(stats.inr.getGAS().getLowestAsk()), Double.parseDouble(stats.inr.getGAS().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "EOS", date, Double.parseDouble(stats.inr.getEOS().getLowestAsk()), Double.parseDouble(stats.inr.getEOS().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "NANO", date, Double.parseDouble(stats.inr.getXRB().getLowestAsk()), Double.parseDouble(stats.inr.getXRB().getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "ONT", date, Double.parseDouble(stats.inr.ONT.getLowestAsk()), Double.parseDouble(stats.inr.ONT.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "ZIL", date, Double.parseDouble(stats.inr.ZIL.getLowestAsk()), Double.parseDouble(stats.inr.ZIL.getHighestBid())));

        exchangeRates.add(new ExchangeRate(KOINEX_ID, "IOST", date, Double.parseDouble(stats.inr.IOST.getLowestAsk()), Double.parseDouble(stats.inr.IOST.getHighestBid())));

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

    public Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        inrExchangeRates.put("BCH", new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(stats.inr.BCH.getLowestAsk()), Double.parseDouble(stats.inr.BCH.getHighestBid())));
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
        exchangeRates.put("INR", inrExchangeRates);

        Map<String, ExchangeRate> bitcoinExchangeRates = new HashMap<>();
        try {
            bitcoinExchangeRates.put("BCH", new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(stats.bitcoin.BCH.getLowestAsk()), Double.parseDouble(stats.bitcoin.BCH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("LTC", new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(stats.bitcoin.LTC.getLowestAsk()), Double.parseDouble(stats.bitcoin.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("XRP", new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(stats.bitcoin.XRP.getLowestAsk()), Double.parseDouble(stats.bitcoin.XRP.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("ETH", new ExchangeRate(KOINEX_ID, "ETH", date, Double.parseDouble(stats.bitcoin.ETH.getLowestAsk()), Double.parseDouble(stats.bitcoin.ETH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("OMG", new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(stats.bitcoin.OMG.getLowestAsk()), Double.parseDouble(stats.bitcoin.OMG.getHighestBid())));
        } catch (Exception e) {
        }
        try {

            bitcoinExchangeRates.put("REQ", new ExchangeRate(KOINEX_ID, "REQ", date, Double.parseDouble(stats.bitcoin.REQ.getLowestAsk()), Double.parseDouble(stats.bitcoin.REQ.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("TRX", new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(stats.bitcoin.TRX.getLowestAsk()), Double.parseDouble(stats.bitcoin.TRX.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("NCASH", new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(stats.bitcoin.NCASH.getLowestAsk()), Double.parseDouble(stats.bitcoin.NCASH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            bitcoinExchangeRates.put("EOS", new ExchangeRate(KOINEX_ID, "EOS", date, Double.parseDouble(stats.bitcoin.EOS.getLowestAsk()), Double.parseDouble(stats.bitcoin.EOS.getHighestBid())));
        } catch (Exception e) {
        }

        exchangeRates.put("BTC", bitcoinExchangeRates);

        Map<String, ExchangeRate> etherExchangeRates = new HashMap<>();
        try {
            etherExchangeRates.put("XRP", new ExchangeRate(KOINEX_ID, "XRP", date, Double.parseDouble(stats.ether.XRP.getLowestAsk()), Double.parseDouble(stats.ether.XRP.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("LTC", new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(stats.ether.LTC.getLowestAsk()), Double.parseDouble(stats.ether.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("BCH", new ExchangeRate(KOINEX_ID, "BCH", date, Double.parseDouble(stats.ether.BCH.getLowestAsk()), Double.parseDouble(stats.ether.BCH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("OMG", new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(stats.ether.OMG.getLowestAsk()), Double.parseDouble(stats.ether.OMG.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("TRX", new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(stats.ether.TRX.getLowestAsk()), Double.parseDouble(stats.ether.TRX.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            etherExchangeRates.put("EOS", new ExchangeRate(KOINEX_ID, "EOS", date, Double.parseDouble(stats.ether.EOS.getLowestAsk()), Double.parseDouble(stats.ether.EOS.getHighestBid())));
        } catch (Exception e) {
        }
        exchangeRates.put("ETH", etherExchangeRates);

        Map<String, ExchangeRate> rippleExchangeRates = new HashMap<>();
        try {
            rippleExchangeRates.put("AE", new ExchangeRate(KOINEX_ID, "AE", date, Double.parseDouble(stats.ripple.AE.getLowestAsk()), Double.parseDouble(stats.ripple.AE.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("EOS", new ExchangeRate(KOINEX_ID, "EOS", date, Double.parseDouble(stats.ripple.EOS.getLowestAsk()), Double.parseDouble(stats.ripple.EOS.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("GNT", new ExchangeRate(KOINEX_ID, "GNT", date, Double.parseDouble(stats.ripple.GNT.getLowestAsk()), Double.parseDouble(stats.ripple.GNT.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("LTC", new ExchangeRate(KOINEX_ID, "LTC", date, Double.parseDouble(stats.ripple.LTC.getLowestAsk()), Double.parseDouble(stats.ripple.LTC.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("NCASH", new ExchangeRate(KOINEX_ID, "NCASH", date, Double.parseDouble(stats.ripple.NCASH.getLowestAsk()), Double.parseDouble(stats.ripple.NCASH.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("OMG", new ExchangeRate(KOINEX_ID, "OMG", date, Double.parseDouble(stats.ripple.OMG.getLowestAsk()), Double.parseDouble(stats.ripple.OMG.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("REQ", new ExchangeRate(KOINEX_ID, "REQ", date, Double.parseDouble(stats.ripple.REQ.getLowestAsk()), Double.parseDouble(stats.ripple.REQ.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("TRX", new ExchangeRate(KOINEX_ID, "TRX", date, Double.parseDouble(stats.ripple.TRX.getLowestAsk()), Double.parseDouble(stats.ripple.TRX.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("ONT", new ExchangeRate(KOINEX_ID, "ONT", date, Double.parseDouble(stats.ripple.ONT.getLowestAsk()), Double.parseDouble(stats.ripple.ONT.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("ZIL", new ExchangeRate(KOINEX_ID, "ZIL", date, Double.parseDouble(stats.ripple.ZIL.getLowestAsk()), Double.parseDouble(stats.ripple.ZIL.getHighestBid())));
        } catch (Exception e) {
        }
        try {
            rippleExchangeRates.put("IOST", new ExchangeRate(KOINEX_ID, "IOST", date, Double.parseDouble(stats.ripple.IOST.getLowestAsk()), Double.parseDouble(stats.ripple.IOST.getHighestBid())));
        } catch (Exception e) {
        }
        exchangeRates.put("XRP", rippleExchangeRates);

        return exchangeRates;
    }
}
