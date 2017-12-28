package com.fr0ddy.coinin.data.source.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurav on 26/12/17.
 */

public class CoindeltaResponse {
    @SerializedName("Ask")
    Double lowestAsk;
    @SerializedName("Bid")
    Double highestBid;
    @SerializedName("MarketName")
    String marketName;

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

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
