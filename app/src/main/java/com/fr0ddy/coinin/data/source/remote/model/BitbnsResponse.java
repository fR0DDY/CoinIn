package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fr0ddy.coinin.utils.AppConstants.BITBNS_ID;

/**
 * Created by gaurav on 11/02/18.
 */

public class BitbnsResponse {
    Data BTC;
    Data XRP;
    Data NEO;
    Data GAS;
    Data ETH;
    Data XLM;
    Data RPX;
    Data DBC;
    Data LTC;
    Data XMR;
    Data DOGE;
    Data DASH;
    Data SC;
    Data BCH;
    Data TRX;
    Data ETN;
    Data ONT;
    Data ZIL;
    Data EOS;
    Data POLY;
    Data DGB;
    Data NCASH;
    Data ADA;
    Data ICX;
    Data VEN;
    Data REQ;
    Data OMG;
    Data ACT;
    Data WAVES;
    Data WAN;
    Data DGD;
    Data POWR;
    Data QLC;
    Data WPR;
    Data XEM;
    Data XVG;
    Data BLZ;
    Data LRC;
    Data NEXO;
    Data SUB;
    Data ZRX;
    Data CPX;
    Data REP;
    Data EFX;
    Data LOOM;
    Data EOSD;
    Data QKC;
    Data STORM;
    Data QTUM;
    Data GNT;
    Data LSK;
    Data ETC;
    Data NPXS;
    Data USDT;
    Data CLOAK;
    Data DENT;
    Data GRS;
    Data KMD;
    Data BTT;
    Data BCHABC;
    Data BCHSV;
    Data BTCUSDT;
    Data ETHUSDT;
    Data XRPUSDT;
    Data TRXUSDT;
    Data BTTUSDT;
    Data BCHABCUSDT;
    Data EOSUSDT;
    Data NEOUSDT;
    Data XLMUSDT;
    Data ADAUSDT;
    Data LTCUSDT;

    public class Data {
        @SerializedName("sellPrice")
        Double sellPrice;
        @SerializedName("buyPrice")
        Double buyPrice;
        @SerializedName("lastTradePrice")
        Double lastTradePrice;

        public Double getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(Double sellPrice) {
            this.sellPrice = sellPrice;
        }

        public Double getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(Double buyPrice) {
            this.buyPrice = buyPrice;
        }

        public Double getLastTradePrice() {
            return lastTradePrice;
        }

        public void setLastTradePrice(Double lastTradePrice) {
            this.lastTradePrice = lastTradePrice;
        }
    }

    public Data getBTC() {
        return BTC;
    }

    public void setBTC(Data BTC) {
        this.BTC = BTC;
    }

    public Data getXRP() {
        return XRP;
    }

    public void setXRP(Data XRP) {
        this.XRP = XRP;
    }

    public Data getNEO() {
        return NEO;
    }

    public void setNEO(Data NEO) {
        this.NEO = NEO;
    }

    public Data getETH() {
        return ETH;
    }

    public void setETH(Data ETH) {
        this.ETH = ETH;
    }

    public Data getXLM() {
        return XLM;
    }

    public void setXLM(Data XLM) {
        this.XLM = XLM;
    }

    public Data getGAS() {
        return GAS;
    }

    public void setGAS(Data GAS) {
        this.GAS = GAS;
    }

    public Data getRPX() {
        return RPX;
    }

    public void setRPX(Data RPX) {
        this.RPX = RPX;
    }

    public Data getDBC() {
        return DBC;
    }

    public void setDBC(Data DBC) {
        this.DBC = DBC;
    }

    public Data getLTC() {
        return LTC;
    }

    public void setLTC(Data LTC) {
        this.LTC = LTC;
    }

    public Data getXMR() {
        return XMR;
    }

    public void setXMR(Data XMR) {
        this.XMR = XMR;
    }

    public Data getDOGE() {
        return DOGE;
    }

    public void setDOGE(Data DOGE) {
        this.DOGE = DOGE;
    }

    public Data getDASH() {
        return DASH;
    }

    public void setDASH(Data DASH) {
        this.DASH = DASH;
    }

    public Data getSIA() {
        return SC;
    }

    public void setSIA(Data SIA) {
        this.SC = SIA;
    }

    public Data getBCH() {
        return BCH;
    }

    public void setBCH(Data BCH) {
        this.BCH = BCH;
    }

    public Data getTRX() {
        return TRX;
    }

    public void setTRX(Data TRX) {
        this.TRX = TRX;
    }

    public Data getSC() {
        return SC;
    }

    public void setSC(Data SC) {
        this.SC = SC;
    }

    public Data getETN() {
        return ETN;
    }

    public void setETN(Data ETN) {
        this.ETN = ETN;
    }

    public Data getONT() {
        return ONT;
    }

    public void setONT(Data ONT) {
        this.ONT = ONT;
    }

    public Data getZIL() {
        return ZIL;
    }

    public void setZIL(Data ZIL) {
        this.ZIL = ZIL;
    }

    public Data getEOS() {
        return EOS;
    }

    public void setEOS(Data EOS) {
        this.EOS = EOS;
    }

    public Data getPOLY() {
        return POLY;
    }

    public void setPOLY(Data POLY) {
        this.POLY = POLY;
    }

    public Data getDGB() {
        return DGB;
    }

    public void setDGB(Data DGB) {
        this.DGB = DGB;
    }

    public Data getNCASH() {
        return NCASH;
    }

    public void setNCASH(Data NCASH) {
        this.NCASH = NCASH;
    }

    public Data getADA() {
        return ADA;
    }

    public void setADA(Data ADA) {
        this.ADA = ADA;
    }

    public Data getICX() {
        return ICX;
    }

    public void setICX(Data ICX) {
        this.ICX = ICX;
    }

    public Data getVEN() {
        return VEN;
    }

    public void setVEN(Data VEN) {
        this.VEN = VEN;
    }

    public Data getREQ() {
        return REQ;
    }

    public void setREQ(Data REQ) {
        this.REQ = REQ;
    }

    public Data getOMG() {
        return OMG;
    }

    public void setOMG(Data OMG) {
        this.OMG = OMG;
    }

    public static List<ExchangeRate> getExchangeRates(List<BitbnsResponse> bitbnsResponse, Date date) {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        for (BitbnsResponse response : bitbnsResponse) {
            if (response.getBTC() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "BTC", date, response.getBTC().getSellPrice(), response.getBTC().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getXRP() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "XRP", date, response.getXRP().getSellPrice(), response.getXRP().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getNEO() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "NEO", date, response.getNEO().getSellPrice(), response.getNEO().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getETH() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ETH", date, response.getETH().getSellPrice(), response.getETH().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getXLM() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "XLM", date, response.getXLM().getSellPrice(), response.getXLM().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getGAS() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "GAS", date, response.getGAS().getSellPrice(), response.getGAS().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getRPX() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "RPX", date, response.getRPX().getSellPrice(), response.getRPX().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getDBC() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DBC", date, response.getDBC().getSellPrice(), response.getDBC().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getLTC() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "LTC", date, response.getLTC().getSellPrice(), response.getLTC().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getXMR() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "XMR", date, response.getXMR().getSellPrice(), response.getXMR().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getDOGE() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DOGE", date, response.getDOGE().getSellPrice(), response.getDOGE().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getDASH() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DASH", date, response.getDASH().getSellPrice(), response.getDASH().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getSIA() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "SC", date, response.getSIA().getSellPrice(), response.getSIA().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getBCH() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "BCH", date, response.getBCH().getSellPrice(), response.getBCH().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getTRX() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "TRX", date, response.getTRX().getSellPrice(), response.getTRX().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getETN() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ETN", date, response.getETN().getSellPrice(), response.getETN().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getONT() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ONT", date, response.getONT().getSellPrice(), response.getONT().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getZIL() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ZIL", date, response.getZIL().getSellPrice(), response.getZIL().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getEOS() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "EOS", date, response.getEOS().getSellPrice(), response.getEOS().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getPOLY() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "POLY", date, response.getPOLY().getSellPrice(), response.getPOLY().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getDGB() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "DGB", date, response.getDGB().getSellPrice(), response.getDGB().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getNCASH() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "NCASH", date, response.getNCASH().getSellPrice(), response.getNCASH().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getADA() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ADA", date, response.getADA().getSellPrice(), response.getADA().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getICX() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "ICX", date, response.getICX().getSellPrice(), response.getICX().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getVEN() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "VEN", date, response.getVEN().getSellPrice(), response.getVEN().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getREQ() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "REQ", date, response.getREQ().getSellPrice(), response.getREQ().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.getOMG() != null) {
                ExchangeRate rate = new ExchangeRate(BITBNS_ID, "OMG", date, response.getOMG().getSellPrice(), response.getOMG().getBuyPrice());
                exchangeRates.add(rate);
            } else if (response.ACT != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "ACT", date, response.ACT.getSellPrice(), response.ACT.getBuyPrice()));
            } else if (response.WAVES != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "WAVES", date, response.WAVES.getSellPrice(), response.WAVES.getBuyPrice()));
            } else if (response.WAN != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "WAN", date, response.WAN.getSellPrice(), response.WAN.getBuyPrice()));
            } else if (response.DGD != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "DGD", date, response.DGD.getSellPrice(), response.DGD.getBuyPrice()));
            } else if (response.POWR != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "POWR", date, response.POWR.getSellPrice(), response.POWR.getBuyPrice()));
            } else if (response.QLC != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "QLC", date, response.QLC.getSellPrice(), response.QLC.getBuyPrice()));
            } else if (response.WPR != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "WPR", date, response.WPR.getSellPrice(), response.WPR.getBuyPrice()));
            } else if (response.XEM != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "XEM", date, response.XEM.getSellPrice(), response.XEM.getBuyPrice()));
            } else if (response.XVG != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "XVG", date, response.XVG.getSellPrice(), response.XVG.getBuyPrice()));
            } else if (response.BLZ != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "BLZ", date, response.BLZ.getSellPrice(), response.BLZ.getBuyPrice()));
            } else if (response.LRC != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "LRC", date, response.LRC.getSellPrice(), response.LRC.getBuyPrice()));
            } else if (response.NEXO != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "NEXO", date, response.NEXO.getSellPrice(), response.NEXO.getBuyPrice()));
            } else if (response.SUB != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "SUB", date, response.SUB.getSellPrice(), response.SUB.getBuyPrice()));
            } else if (response.ZRX != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "ZRX", date, response.ZRX.getSellPrice(), response.ZRX.getBuyPrice()));
            } else if (response.CPX != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "CPX", date, response.CPX.getSellPrice(), response.CPX.getBuyPrice()));
            } else if (response.REP != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "REP", date, response.REP.getSellPrice(), response.REP.getBuyPrice()));
            } else if (response.EFX != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "EFX", date, response.EFX.getSellPrice(), response.EFX.getBuyPrice()));
            } else if (response.LOOM != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "LOOM", date, response.LOOM.getSellPrice(), response.LOOM.getBuyPrice()));
            } else if (response.EOSD != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "EOSD", date, response.EOSD.getSellPrice(), response.EOSD.getBuyPrice()));
            } else if (response.QKC != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "QKC", date, response.QKC.getSellPrice(), response.QKC.getBuyPrice()));
            } else if (response.STORM != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "STORM", date, response.STORM.getSellPrice(), response.STORM.getBuyPrice()));
            } else if (response.QTUM != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "QTUM", date, response.QTUM.getSellPrice(), response.QTUM.getBuyPrice()));
            } else if (response.GNT != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "GNT", date, response.GNT.getSellPrice(), response.GNT.getBuyPrice()));
            } else if (response.LSK != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "LSK", date, response.LSK.getSellPrice(), response.LSK.getBuyPrice()));
            } else if (response.ETC != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "ETC", date, response.ETC.getSellPrice(), response.ETC.getBuyPrice()));
            } else if (response.NPXS != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "NPXS", date, response.NPXS.getSellPrice(), response.NPXS.getBuyPrice()));
            } else if (response.USDT != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "USDT", date, response.USDT.getSellPrice(), response.USDT.getBuyPrice()));
            } else if (response.CLOAK != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "CLOAK", date, response.CLOAK.getSellPrice(), response.CLOAK.getBuyPrice()));
            } else if (response.DENT != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "DENT", date, response.DENT.getSellPrice(), response.DENT.getBuyPrice()));
            } else if (response.GRS != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "GRS", date, response.GRS.getSellPrice(), response.GRS.getBuyPrice()));
            } else if (response.KMD != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "KMD", date, response.KMD.getSellPrice(), response.KMD.getBuyPrice()));
            } else if (response.BCHABC != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "BCHABC", date, response.BCHABC.getSellPrice(), response.BCHABC.getBuyPrice()));
            } else if (response.BCHSV != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "BCHSV", date, response.BCHSV.getSellPrice(), response.BCHSV.getBuyPrice()));
            } else if (response.BTT != null) {
                exchangeRates.add(new ExchangeRate(BITBNS_ID, "BTT", date, response.BTT.getSellPrice(), response.BTT.getBuyPrice()));
            }
        }
        return exchangeRates;
    }

    public static Map<String, Map<String, ExchangeRate>> getMultiCoinExchangeRates(List<BitbnsResponse> bitbnsResponse, Date date) {
        Map<String, Map<String, ExchangeRate>> exchangeRates = new HashMap<>();
        Map<String, ExchangeRate> inrExchangeRates = new HashMap<>();
        Map<String, ExchangeRate> usdtExchangeRates = new HashMap<>();
        for (BitbnsResponse response : bitbnsResponse) {
            if (response.BTC != null) {
                inrExchangeRates.put("BTC", new ExchangeRate(BITBNS_ID, "BTC", date, response.BTC.getSellPrice(), response.BTC.getBuyPrice()));
            } else if (response.XRP != null) {
                inrExchangeRates.put("XRP", new ExchangeRate(BITBNS_ID, "XRP", date, response.XRP.getSellPrice(), response.XRP.getBuyPrice()));
            } else if (response.ETH != null) {
                inrExchangeRates.put("ETH", new ExchangeRate(BITBNS_ID, "ETH", date, response.ETH.getSellPrice(), response.ETH.getBuyPrice()));
            } else if (response.TRX != null) {
                inrExchangeRates.put("TRX", new ExchangeRate(BITBNS_ID, "TRX", date, response.TRX.getSellPrice(), response.TRX.getBuyPrice()));
            } else if (response.BTT != null) {
                inrExchangeRates.put("BTT", new ExchangeRate(BITBNS_ID, "BTT", date, response.BTT.getSellPrice(), response.BTT.getBuyPrice()));
            } else if (response.BCHABC != null) {
                inrExchangeRates.put("BCHABC", new ExchangeRate(BITBNS_ID, "BCHABC", date, response.BCHABC.getSellPrice(), response.BCHABC.getBuyPrice()));
            } else if (response.EOS != null) {
                inrExchangeRates.put("EOS", new ExchangeRate(BITBNS_ID, "EOS", date, response.EOS.getSellPrice(), response.EOS.getBuyPrice()));
            } else if (response.NEO != null) {
                inrExchangeRates.put("NEO", new ExchangeRate(BITBNS_ID, "NEO", date, response.NEO.getSellPrice(), response.NEO.getBuyPrice()));
            } else if (response.XLM != null) {
                inrExchangeRates.put("XLM", new ExchangeRate(BITBNS_ID, "XLM", date, response.XLM.getSellPrice(), response.XLM.getBuyPrice()));
            } else if (response.ADA != null) {
                inrExchangeRates.put("ADA", new ExchangeRate(BITBNS_ID, "ADA", date, response.ADA.getSellPrice(), response.ADA.getBuyPrice()));
            } else if (response.LTC != null) {
                inrExchangeRates.put("LTC", new ExchangeRate(BITBNS_ID, "LTC", date, response.LTC.getSellPrice(), response.LTC.getBuyPrice()));
            } else if (response.USDT != null) {
                inrExchangeRates.put("USDT", new ExchangeRate(BITBNS_ID, "USDT", date, response.USDT.getSellPrice(), response.USDT.getBuyPrice()));
            } else if (response.BTCUSDT != null) {
                usdtExchangeRates.put("BTC", new ExchangeRate(BITBNS_ID, "BTC", date, response.BTCUSDT.getSellPrice(), response.BTCUSDT.getBuyPrice()));
            } else if (response.XRPUSDT != null) {
                usdtExchangeRates.put("XRP", new ExchangeRate(BITBNS_ID, "XRP", date, response.XRPUSDT.getSellPrice(), response.XRPUSDT.getBuyPrice()));
            } else if (response.ETHUSDT != null) {
                usdtExchangeRates.put("ETH", new ExchangeRate(BITBNS_ID, "ETH", date, response.ETHUSDT.getSellPrice(), response.ETHUSDT.getBuyPrice()));
            } else if (response.TRXUSDT != null) {
                usdtExchangeRates.put("TRX", new ExchangeRate(BITBNS_ID, "TRX", date, response.TRXUSDT.getSellPrice(), response.TRXUSDT.getBuyPrice()));
            } else if (response.BTTUSDT != null) {
                usdtExchangeRates.put("BTT", new ExchangeRate(BITBNS_ID, "BTT", date, response.BTTUSDT.getSellPrice(), response.BTTUSDT.getBuyPrice()));
            } else if (response.BCHABCUSDT != null) {
                usdtExchangeRates.put("BCHABC", new ExchangeRate(BITBNS_ID, "BCHABC", date, response.BCHABCUSDT.getSellPrice(), response.BCHABCUSDT.getBuyPrice()));
            } else if (response.EOSUSDT != null) {
                usdtExchangeRates.put("EOS", new ExchangeRate(BITBNS_ID, "EOS", date, response.EOSUSDT.getSellPrice(), response.EOSUSDT.getBuyPrice()));
            } else if (response.NEOUSDT != null) {
                usdtExchangeRates.put("NEO", new ExchangeRate(BITBNS_ID, "NEO", date, response.NEOUSDT.getSellPrice(), response.NEOUSDT.getBuyPrice()));
            } else if (response.XLMUSDT != null) {
                usdtExchangeRates.put("XLM", new ExchangeRate(BITBNS_ID, "XLM", date, response.XLMUSDT.getSellPrice(), response.XLMUSDT.getBuyPrice()));
            } else if (response.ADAUSDT != null) {
                usdtExchangeRates.put("ADA", new ExchangeRate(BITBNS_ID, "ADA", date, response.ADAUSDT.getSellPrice(), response.ADAUSDT.getBuyPrice()));
            } else if (response.LTCUSDT != null) {
                usdtExchangeRates.put("LTC", new ExchangeRate(BITBNS_ID, "LTC", date, response.LTCUSDT.getSellPrice(), response.LTCUSDT.getBuyPrice()));
            }
        }
        exchangeRates.put("INR", inrExchangeRates);
        exchangeRates.put("USDT", usdtExchangeRates);
        return exchangeRates;
    }
}
