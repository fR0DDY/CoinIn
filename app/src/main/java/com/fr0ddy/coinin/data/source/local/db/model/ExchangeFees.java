package com.fr0ddy.coinin.data.source.local.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by gaurav on 25/11/17.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Exchange.class,
                parentColumns = "id",
                childColumns = "exchangeId",
                onDelete = ForeignKey.CASCADE)},
        indices = {@Index(value = "exchangeId")})
public class ExchangeFees {
    @PrimaryKey
    private int id;
    private int exchangeId;
    private String currency;
    private double buyFee;
    private double sellFee;
    private double transferFee;

    public ExchangeFees(int id, int exchangeId, String currency, double buyFee, double sellFee, double transferFee) {
        this.id = id;
        this.exchangeId = exchangeId;
        this.currency = currency;
        this.buyFee = buyFee;
        this.sellFee = sellFee;
        this.transferFee = transferFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public double getBuyFee() {
        return buyFee;
    }

    public void setBuyFee(double buyFee) {
        this.buyFee = buyFee;
    }

    public double getSellFee() {
        return sellFee;
    }

    public void setSellFee(double sellFee) {
        this.sellFee = sellFee;
    }

    public double getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(double transferFee) {
        this.transferFee = transferFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
