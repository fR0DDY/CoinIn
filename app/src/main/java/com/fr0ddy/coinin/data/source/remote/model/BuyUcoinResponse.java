package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gaurav on 16/12/17.
 */

public class BuyUcoinResponse {

    @SerializedName("BuyUcoin_data")
    List<Data> data;

    public class Data {
        @SerializedName("btc_buy_price")
        String btcBuyPrice;
        @SerializedName("btc_sell_price")
        String btcSellPrice;
        @SerializedName("eth_buy_price")
        String ethBuyPrice;
        @SerializedName("eth_sell_price")
        String ethSellPrice;
        @SerializedName("ltc_buy_price")
        String ltcBuyPrice;
        @SerializedName("ltc_sell_price")
        String ltcSellPrice;
        @SerializedName("xrp_buy_price")
        String xrpBuyPrice;
        @SerializedName("xrp_sell_price")
        String xrpSellPrice;
        @SerializedName("bcc_buy_price")
        String bchBuyPrice;
        @SerializedName("bcc_sell_price")
        String bchSellPrice;

        public String getBtcBuyPrice() {
            return btcBuyPrice;
        }

        public void setBtcBuyPrice(String btcBuyPrice) {
            this.btcBuyPrice = btcBuyPrice;
        }

        public String getBtcSellPrice() {
            return btcSellPrice;
        }

        public void setBtcSellPrice(String btcSellPrice) {
            this.btcSellPrice = btcSellPrice;
        }

        public String getEthBuyPrice() {
            return ethBuyPrice;
        }

        public void setEthBuyPrice(String ethBuyPrice) {
            this.ethBuyPrice = ethBuyPrice;
        }

        public String getEthSellPrice() {
            return ethSellPrice;
        }

        public void setEthSellPrice(String ethSellPrice) {
            this.ethSellPrice = ethSellPrice;
        }

        public String getLtcBuyPrice() {
            return ltcBuyPrice;
        }

        public void setLtcBuyPrice(String ltcBuyPrice) {
            this.ltcBuyPrice = ltcBuyPrice;
        }

        public String getLtcSellPrice() {
            return ltcSellPrice;
        }

        public void setLtcSellPrice(String ltcSellPrice) {
            this.ltcSellPrice = ltcSellPrice;
        }

        public String getXrpBuyPrice() {
            return xrpBuyPrice;
        }

        public void setXrpBuyPrice(String xrpBuyPrice) {
            this.xrpBuyPrice = xrpBuyPrice;
        }

        public String getXrpSellPrice() {
            return xrpSellPrice;
        }

        public void setXrpSellPrice(String xrpSellPrice) {
            this.xrpSellPrice = xrpSellPrice;
        }

        public String getBchBuyPrice() {
            return bchBuyPrice;
        }

        public void setBchBuyPrice(String bchBuyPrice) {
            this.bchBuyPrice = bchBuyPrice;
        }

        public String getBchSellPrice() {
            return bchSellPrice;
        }

        public void setBchSellPrice(String bchSellPrice) {
            this.bchSellPrice = bchSellPrice;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "btcBuyPrice='" + btcBuyPrice + '\'' +
                    ", btcSellPrice='" + btcSellPrice + '\'' +
                    ", ethBuyPrice='" + ethBuyPrice + '\'' +
                    ", ethSellPrice='" + ethSellPrice + '\'' +
                    ", ltcBuyPrice='" + ltcBuyPrice + '\'' +
                    ", ltcSellPrice='" + ltcSellPrice + '\'' +
                    ", xrpBuyPrice='" + xrpBuyPrice + '\'' +
                    ", xrpSellPrice='" + xrpSellPrice + '\'' +
                    ", bchBuyPrice='" + bchBuyPrice + '\'' +
                    ", bchSellPrice='" + bchSellPrice + '\'' +
                    '}';
        }
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BuyUcoinResponse{" +
                "data=" + data +
                '}';
    }
}
