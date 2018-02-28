package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

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
}
