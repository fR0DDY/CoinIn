package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurav on 28/12/17.
 */

public class CoinsecureResponse {

    Data message;

    public class Data {
        @SerializedName("ask")
        Double lowestAsk;
        @SerializedName("bid")
        Double highestBid;

        public Double getLowestAsk() {
            return lowestAsk;
        }

        public void setLowestAsk(Double lowestAsk) {
            this.lowestAsk = lowestAsk;
        }

        public Double getHighestBid() {
            return highestBid;
        }

        public void setHighestBid(Double highestBid) {
            this.highestBid = highestBid;
        }
    }

    public Data getMessage() {
        return message;
    }

    public void setMessage(Data message) {
        this.message = message;
    }
}
