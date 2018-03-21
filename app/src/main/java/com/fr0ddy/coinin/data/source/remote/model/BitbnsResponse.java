package com.fr0ddy.coinin.data.source.remote.model;

import com.fr0ddy.coinin.data.source.local.db.model.ExchangeRate;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            }
        }
        return exchangeRates;
    }
}
