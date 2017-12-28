package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurav on 27/12/17.
 */

public class PocketBitsBitcoinResponse {

    Data rates;

    public class Data {
        @SerializedName("BTC_BuyingRate")
        String buyPrice;
        @SerializedName("BTC_SellingRate")
        String sellPrice;

        public String getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(String buyPrice) {
            this.buyPrice = buyPrice;
        }

        public String getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(String sellPrice) {
            this.sellPrice = sellPrice;
        }
    }

    public Data getRates() {
        return rates;
    }

    public void setRates(Data rates) {
        this.rates = rates;
    }
}
