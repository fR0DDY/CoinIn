package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gaurav on 25/11/17.
 */

public class ThroughbitResponse {
    //{"status":1,"error":"","result":"Price details","data":{"price":[{"buy_price":"32782","sell_price":"31515"}],"24hrchange":[{"buychange":"4.07","sellchange":"8.26"}]}}

    Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ThroughbitResponse{" +
                "data=" + data +
                '}';
    }

    public class Data {
        List<Price> price;

        public List<Price> getPrice() {
            return price;
        }

        public void setPrice(List<Price> price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "price=" + price +
                    '}';
        }
    }

    public class Price {
        @SerializedName("buy_price")
        String buyPrice;
        @SerializedName("sell_price")
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

        @Override
        public String toString() {
            return "Price{" +
                    "buyPrice='" + buyPrice + '\'' +
                    ", sellPrice='" + sellPrice + '\'' +
                    '}';
        }
    }
}
