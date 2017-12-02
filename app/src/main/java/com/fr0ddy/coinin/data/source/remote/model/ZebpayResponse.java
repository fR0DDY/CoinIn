package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurav on 25/11/17.
 */

public class ZebpayResponse {
    @SerializedName("buy")
    Double buyPrice;
    @SerializedName("sell")
    Double sellPrice;

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "ZebpayResponse{" +
                "buyPrice='" + buyPrice + '\'' +
                ", sellPrice='" + sellPrice + '\'' +
                '}';
    }
}
