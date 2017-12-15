package com.fr0ddy.coinin.data.source.local.db.model;

/**
 * Created by gaurav on 15/12/17.
 */

public final class CurrentExchangeRate extends ExchangeRate {

    public String exchangeName;

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
}
